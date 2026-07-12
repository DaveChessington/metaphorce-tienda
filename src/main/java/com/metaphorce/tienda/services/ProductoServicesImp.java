package com.metaphorce.tienda.services;

import com.metaphorce.tienda.Exceptions.ProductNotFoundException;
import com.metaphorce.tienda.entidades.Producto;
import com.metaphorce.tienda.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //registrar calse como un Bean
public class ProductoServicesImp implements IProductoServices {
    ProductoRepository productoRepository;

    @Autowired //inyeccion de dependencias explicita por cntructor
    public ProductoServicesImp(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerProducto(int id) {
        Producto producto=productoRepository.findById(id).orElse(null);
        if (producto==null){
            throw new ProductNotFoundException("No se encontro el producto con el id: "+id);
        }
        return producto;
    }

    @Override
    public Producto insertarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizarProducto(int id, Producto producto) {
        Producto actual=productoRepository.findById(id).orElse(null);
        if (actual!=null){
            actual.setNombre(producto.getNombre());
            actual.setPrecio(producto.getPrecio());
            return productoRepository.save(actual);
        }
        throw new ProductNotFoundException("El producto que trata de actualizar no existe");
    }

    @Override
    public void eliminarProducto(int id) {
        Producto actual=productoRepository.findById(id).orElse(null);
        if (actual==null) {
            throw new ProductNotFoundException("El producto que trata de eliminar no existe");
        }
        productoRepository.deleteById(id);
    }
}
