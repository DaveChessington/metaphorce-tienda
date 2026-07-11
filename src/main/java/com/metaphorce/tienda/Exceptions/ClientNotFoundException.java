package com.metaphorce.tienda.Exceptions;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(String mensaje) {
        super(mensaje);
    }
}
