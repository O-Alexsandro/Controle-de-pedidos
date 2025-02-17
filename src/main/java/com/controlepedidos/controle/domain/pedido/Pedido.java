package com.controlepedidos.controle.domain.pedido;

import com.controlepedidos.controle.domain.cliente.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "pedido")
@Table(name = "pedidos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDateTime data;
    private double valor;
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    @ManyToOne()
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;

    public Pedido(CadastroPedidoDTO dados){
        this.nome = dados.nome();
        this.data = dados.data();
        this.valor = dados.valor();
        this.status = dados.statusPedido();
        this.cliente = null;
    }
}
