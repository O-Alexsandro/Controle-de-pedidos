package com.controlepedidos.controle.domain.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CadastroClienteDTO(
        @NotNull
        String nome,
        @NotNull
        @Email
        String email,
        @NotNull
        @Pattern(regexp = "\\d{9}")
        String telefone,
        @NotNull
        String endereco
) {
        public CadastroClienteDTO(Cliente cliente){
                this(cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getEndereco());
        }
}
