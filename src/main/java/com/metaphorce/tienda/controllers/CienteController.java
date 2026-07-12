package com.metaphorce.tienda.controllers;

import com.metaphorce.tienda.entidades.Cliente;
import com.metaphorce.tienda.services.IClienteServices;
import jakarta.validation.Valid;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.lang.classfile.FieldElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tienda")
public class CienteController {
    //hacer referencia al service para traer datos
    //inyectar interfaz de service
    private final IClienteServices clienteServices;

    public CienteController(IClienteServices clienteServices) {
        this.clienteServices = clienteServices;
    }

    @GetMapping("/clientes")
    public ResponseEntity<?> obtenerListaClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteServices.listarClentes());
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<?> obtenerCliente(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(clienteServices.obetenerCliente(id));
    }
    /*
    @PostMapping("/cliente")
    public Cliente insertarCliente(@RequestBody Cliente cliente){ //el cliente vendrá definido en el cuerpo de la petición
        return clienteServices.insertarCliente(cliente);
    }

    @PostMapping("/cliente")
    public ResponseEntity<?> insertarCliente(@RequestBody @Valid Cliente cliente, BindingResult bindResult){ //el cliente vendrá definido en el cuerpo de la petición
        Map<String,String> errores=new HashMap<>();
        if (bindResult.hasErrors()){
            for (FieldError error:bindResult.getFieldErrors()){
                errores.put(error.getField(),error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
        }
        Cliente clienteCreado=clienteServices.insertarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreado);
    }*/

    @PostMapping("/cliente")
    public ResponseEntity<?> insertarCliente(@RequestBody @Valid Cliente cliente){ //el cliente vendrá definido en el cuerpo de la petición
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteServices.insertarCliente(cliente));
    }

    @PutMapping("/cliente/{id}")
    public ResponseEntity<?> actualizarCliente(@PathVariable @Valid int id,@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.OK).body(clienteServices.actualizarCliente(id,cliente));
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable @Valid int id){
        clienteServices.eliminarCliente(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
