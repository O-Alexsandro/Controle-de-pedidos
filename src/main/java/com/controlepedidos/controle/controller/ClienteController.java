package com.controlepedidos.controle.controller;

import com.controlepedidos.controle.domain.cliente.AtualizarClienteDTO;
import com.controlepedidos.controle.domain.cliente.CadastroClienteDTO;
import com.controlepedidos.controle.domain.cliente.Cliente;
import com.controlepedidos.controle.service.ClienteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarCliente(){
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarClientePorId(@PathVariable Long id){
        return clienteService.listarClientesPorId(id);
    }


    @PostMapping
    public ResponseEntity cadastrarCliente(@RequestBody @Valid CadastroClienteDTO dados){
        return clienteService.cadastrarCliente(dados);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Cliente> atualizarCliente(@RequestBody @Valid AtualizarClienteDTO dados){
        return clienteService.atualizarCliente(dados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarCliente(@PathVariable Long id){
       return clienteService.excluirCliente(id);
    }


}
