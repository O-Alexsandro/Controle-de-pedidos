package com.controlepedidos.controle.domain.pedido;

import com.controlepedidos.controle.domain.cliente.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record CadastroPedidoDTO(
        @NotNull
        String nome,
        @NotNull
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime data,
        @NotNull
        Double valor,
        @NotNull
        StatusPedido statusPedido,
        @NotNull
        Long clienteId) {
}
