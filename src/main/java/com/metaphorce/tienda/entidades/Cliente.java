package com.metaphorce.tienda.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //la pk sera manejada por la bd
    @Column(name = "cliente_id")
    private int clienteId;
    //@NotBlank(message = "El nombre no puede ser vacio")
    private String nombre; //commented out to avoid problems when trying to insert new pedido 
    //@Size(min = 3,max = 50,message = "la ciudad debe tener de 3 a 50 caracteres")
    private String ciudad;

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
