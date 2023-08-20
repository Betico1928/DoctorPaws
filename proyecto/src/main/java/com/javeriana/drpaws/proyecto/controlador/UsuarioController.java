package com.javeriana.drpaws.proyecto.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController
{
    @RequestMapping("/loginUsuario")
    public String loginUsuario()
    {
        return "login-user";
    }
}
