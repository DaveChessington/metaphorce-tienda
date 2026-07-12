package com.metaphorce.tienda.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdviceGlobal {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> manejarListaErroresValidacion(MethodArgumentNotValidException exception){
        Map<String,String> errores=new HashMap<>();
        for (FieldError error: exception.getFieldErrors()){
            errores.put(error.getField(),error.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<?> manejarClienteNoEncontrado(ClientNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(PedidoNotFoundException.class)
    public ResponseEntity<?> manejarPedidoNoEncontrado(PedidoNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public  ResponseEntity<?> manejarPedidoNoEncontrado(ProductNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }


}
