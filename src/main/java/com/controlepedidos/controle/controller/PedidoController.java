package com.controlepedidos.controle.controller;

import com.controlepedidos.controle.domain.pedido.AtualizarStatusPedidoDTO;
import com.controlepedidos.controle.domain.pedido.CadastroPedidoDTO;
import com.controlepedidos.controle.domain.pedido.Pedido;
import com.controlepedidos.controle.service.PedidoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity listarPedido(Pageable pageable){
        return pedidoService.listarPedidos(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> listarPedidosPorId(@PathVariable Long id){
        return pedidoService.listarPedidosPorId(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Pedido> cadastrarPedido(@RequestBody @Valid CadastroPedidoDTO dados){
        return pedidoService.CadastrarPedido(dados);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Pedido> atualizarStatusPedido(@RequestBody @Valid AtualizarStatusPedidoDTO dados){
        return pedidoService.atualizarStatusPedido(dados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id){
        return pedidoService.deletarPedido(id);
    }
}
