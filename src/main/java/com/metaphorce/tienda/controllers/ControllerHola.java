package com.metaphorce.tienda.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tienda")
public class ControllerHola {

    @GetMapping("/hola")
    public String saludar(){
        return "Hola mundo";
    }
}
