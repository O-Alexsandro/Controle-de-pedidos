package com.controlepedidos.controle.service;

import com.controlepedidos.controle.domain.cliente.Cliente;
import com.controlepedidos.controle.domain.pedido.AtualizarStatusPedidoDTO;
import com.controlepedidos.controle.domain.pedido.CadastroPedidoDTO;
import com.controlepedidos.controle.domain.pedido.Pedido;
import com.controlepedidos.controle.repository.ClienteRepository;
import com.controlepedidos.controle.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    public ResponseEntity<Page<Pedido>> listarPedidos(Pageable pageable){
        var pedidos = pedidoRepository.findAll(pageable);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidos);
    }

    public ResponseEntity<Pedido> listarPedidosPorId(Long id){
        var pedido = pedidoRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "id do pedido não encontrado"));
        return ResponseEntity.ok(pedido);
    }

    public ResponseEntity<Pedido> CadastrarPedido(CadastroPedidoDTO dados){
        Cliente cliente = clienteRepository.findById(dados.clienteId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));

        Pedido pedido = new Pedido(dados);
        pedido.setCliente(cliente);
        pedidoRepository.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<Pedido> atualizarStatusPedido(AtualizarStatusPedidoDTO dados){
        var pedido = pedidoRepository.findById(dados.id()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id do pedido não encontrado"));
        pedido.setStatus(dados.statusPedido());
        pedidoRepository.save(pedido);
        return ResponseEntity.ok(pedido);
    }

    public ResponseEntity<Void> deletarPedido(Long id){
        var pedido = pedidoRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id do pedido não localizado"));
        pedidoRepository.delete(pedido);
        return ResponseEntity.noContent().build();
    }
}
