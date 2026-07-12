package com.metaphorce.tienda.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_pedido_id")
    private int detallePedidoId;
    /*
    @Column(name = "pedido_id")
    private int pedidoId;
    @Column(name = "producto_id")
    private int productoId;*/
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id",referencedColumnName = "pedido_id")
    private Pedido pedido;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id", referencedColumnName = "producto_id")
    private Producto producto;
    @Positive
    private int cantidad;

    public int getDetallePedidoId() {
        return detallePedidoId;
    }

    public void setDetallePedidoId(int detallePedidoId) {
        this.detallePedidoId = detallePedidoId;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
