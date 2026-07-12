package com.metaphorce.tienda.services;

import com.metaphorce.tienda.entidades.DetallePedido;
import com.metaphorce.tienda.entidades.Pedido;

import java.util.List;

public interface IPedidoServices {
    //pedidos_methods
    List<Pedido> listarPedidos();
    Pedido obetnerPedido(int id);
    Pedido insertarPedido(Pedido pedido);
    Pedido actualizarPedido(int id,Pedido pedido);
    void eliminarPedido(int id);
}
