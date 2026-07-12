package com.metaphorce.tienda.controllers;

import com.metaphorce.tienda.entidades.Producto;
import com.metaphorce.tienda.services.IProductoServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tienda")
public class ProductoCotroller{
    private final IProductoServices productoServices;

    public ProductoCotroller(IProductoServices productoServices) {
        this.productoServices = productoServices;
    }

    @GetMapping("/productos")
    public ResponseEntity<?> obtenerListaProducto(){
        return ResponseEntity.status(HttpStatus.OK).body(productoServices.listarProductos());
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<?> obtenerProductoPorId(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(productoServices.obtenerProducto(id));
    }

    @PostMapping("/producto")
    public  ResponseEntity<?> crearProducto(@RequestBody @Valid Producto producto){
        return  ResponseEntity.status(HttpStatus.CREATED).body(productoServices.insertarProducto(producto));
    }

    @PutMapping("/producto/{id}")
    public ResponseEntity<?> actualizarProducto(@PathVariable int id, @RequestBody @Valid Producto producto){
        return ResponseEntity.status(HttpStatus.OK).body(productoServices.actualizarProducto(id,producto));
    }

    @DeleteMapping("/producto/{id}")
    public  ResponseEntity<?> eliminarProducto(@PathVariable int id){
        productoServices.eliminarProducto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
