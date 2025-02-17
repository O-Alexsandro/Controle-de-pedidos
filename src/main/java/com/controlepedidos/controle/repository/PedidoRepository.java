package com.controlepedidos.controle.repository;

import com.controlepedidos.controle.domain.cliente.Cliente;
import com.controlepedidos.controle.domain.pedido.Pedido;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClienteId(Long id);
    Page<Pedido> findAll(Pageable page);
}
