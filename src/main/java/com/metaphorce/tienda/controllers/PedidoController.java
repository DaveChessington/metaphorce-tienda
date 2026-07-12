package com.metaphorce.tienda.controllers;

import com.metaphorce.tienda.entidades.Pedido;
import com.metaphorce.tienda.services.IPedidoServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tienda")
public class PedidoController {
    private final IPedidoServices pedidoServices;

    public PedidoController(IPedidoServices pedidoServices) {
        this.pedidoServices = pedidoServices;
    }


    @GetMapping("/pedidos")
    public ResponseEntity<?> obtenerListaPedidos(){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoServices.listarPedidos());
    }

    @GetMapping("/pedido/{id}")
    public ResponseEntity<?> obtenerPedido(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoServices.obetnerPedido(id));
    }

    @PostMapping("/pedido")
    public ResponseEntity<?> insertarPedido(@RequestBody @Valid Pedido pedido){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoServices.insertarPedido(pedido));
    }

    @PutMapping("/pedido/{id}")
    public ResponseEntity<?> actualizarPedido(@PathVariable int id, @RequestBody @Valid Pedido pedido){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoServices.actualizarPedido(id,pedido));
    }

    @DeleteMapping("/pedido/{id}")
    public  ResponseEntity<?> eliminarPedido(@PathVariable int id){
        pedidoServices.eliminarPedido(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
