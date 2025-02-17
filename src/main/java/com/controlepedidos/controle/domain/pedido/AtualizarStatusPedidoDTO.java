package com.controlepedidos.controle.domain.pedido;

import jakarta.validation.constraints.NotNull;

public record AtualizarStatusPedidoDTO(

        @NotNull
        Long id,
        @NotNull
        StatusPedido statusPedido) {
}
