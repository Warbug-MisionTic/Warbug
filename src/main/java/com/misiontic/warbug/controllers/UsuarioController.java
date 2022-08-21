package com.misiontic.warbug.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public String getUsuario(){
        return "Hola Mundo";
    }
}
