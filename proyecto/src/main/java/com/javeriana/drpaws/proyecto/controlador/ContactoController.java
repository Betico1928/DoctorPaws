package com.javeriana.drpaws.proyecto.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactoController {
    @GetMapping("/contacto")
    public String showContactoPage(){
        return "contacto";
    }

}
