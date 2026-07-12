package com.metaphorce.tienda.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    private int pedidoId;
    @ManyToOne(fetch = FetchType.EAGER)///eager para traer eñ objeot principal y atributos relacionados
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id") //relationship with table clientes via id
    private Cliente cliente;
    /*@Column(name = "cliente_id")
    private int clienteId;*/

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
