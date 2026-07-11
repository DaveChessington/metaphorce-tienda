package com.metaphorce.tienda.services;

import com.metaphorce.tienda.Exceptions.ClientNotFoundException;
import com.metaphorce.tienda.entidades.Cliente;
import com.metaphorce.tienda.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicesImp implements IClienteServices{
    //inyeccion de dependencias
    private ClienteRepository clienteRepository;
    //por constructor
    public ClienteServicesImp(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> listarClentes() {
        return clienteRepository.findAll(); //metodos de JPA repository
    }

    @Override
    public Cliente insertarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(int id, Cliente cliente) {
        Cliente actual=clienteRepository.findById(id).orElse(null);
        if (actual!=null){
            actual.setCiudad(cliente.getCiudad());
            actual.setNombre(cliente.getNombre());
            return clienteRepository.save(actual);
        }
        throw new ClientNotFoundException("El cliente que trata de actualizar no existe");
    }

    @Override
    public void eliminarCliente(int id) {
        Cliente clienteExistente=clienteRepository.findById(id).orElse(null);
        if (clienteExistente==null){
        //if (!clienteRepository.existsById(id)){
            throw new ClientNotFoundException("El cliente que trata de Borrar no existe");
        }
        clienteRepository.deleteById(id);
    }


}
