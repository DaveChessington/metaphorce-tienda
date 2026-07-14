package com.metaphorce.tienda.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    private int pedidoId;
    @ManyToOne(fetch = FetchType.EAGER)///eager para traer eñ objeot principal y atributos relacionados
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id") //relationship with table clientes via id
    @Valid //valid id for clients
    private Cliente cliente;
    /*@Column(name = "cliente_id")
    private int clienteId;*/
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("pedido") //tell jackson (translator of java objcts to json and vicecersa) to ignore property pedido from serializing to avoid recursiveness
    @Valid //validate inner structure and ids for products
    private List<DetallePedido> detalles; //se encargará de que el pedido guarde sus detalles pedidos

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

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }
}
