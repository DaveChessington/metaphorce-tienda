package com.metaphorce.tienda.services;

import com.metaphorce.tienda.entidades.Cliente;

import java.util.List;

public interface IClienteServices {
    //traer datos del repository y realizar logica de negocio
    List<Cliente> listarClentes(); //se define el nombre del metodo lo que retorna y parametros
    Cliente obetenerCliente(int id);
    Cliente insertarCliente(Cliente cliente);
    Cliente actualizarCliente(int id,Cliente cliente);
    void eliminarCliente(int id);
}
