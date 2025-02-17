package com.controlepedidos.controle.domain.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AtualizarClienteDTO(
        @NotNull
        Long id,

        String nome,
        @Email
        String email,
        @Pattern(regexp = "\\d{9}")
        String telefone,
        String endereco
) {
}
