package com.metaphorce.tienda.services;

import com.metaphorce.tienda.entidades.Producto;

import java.util.List;

public interface IProductoServices {
    List<Producto> listarProductos();
    Producto obtenerProducto(int id);
    Producto insertarProducto(Producto producto);
    Producto actualizarProducto(int id,Producto producto);
    void eliminarProducto(int id);
}
