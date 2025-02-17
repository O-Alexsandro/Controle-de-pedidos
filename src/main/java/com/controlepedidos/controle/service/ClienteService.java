package com.controlepedidos.controle.service;

import com.controlepedidos.controle.domain.cliente.AtualizarClienteDTO;
import com.controlepedidos.controle.domain.cliente.CadastroClienteDTO;
import com.controlepedidos.controle.domain.cliente.Cliente;
import com.controlepedidos.controle.repository.ClienteRepository;
import com.controlepedidos.controle.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService extends SpringDataWebProperties.Pageable {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public ResponseEntity<List<Cliente>> listarClientes(){
        var clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }

    public ResponseEntity<Cliente> listarClientesPorId(Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (!cliente.isPresent()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(cliente.get());
    }

    public ResponseEntity<Cliente> cadastrarCliente(CadastroClienteDTO dados){
        Cliente cliente = new Cliente(dados);
        clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    public ResponseEntity<Cliente> atualizarCliente(AtualizarClienteDTO dados){
        var cliente = clienteRepository.findById(dados.id()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id do cliente não encontrado"));
        cliente.setNome(dados.nome());
        cliente.setEmail(dados.email());
        clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    public ResponseEntity<String> excluirCliente(Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if (cliente.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        if(!pedidoRepository.findByClienteId(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não é possivel excluir um cliente com pedidos");
        }

        clienteRepository.delete(cliente.get());
        return ResponseEntity.noContent().build();
    }

}
