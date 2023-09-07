package com.javeriana.drpaws.proyecto.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactoController
{
    //http://localhost:8080/contacto  -> Vista de la página de contacto
    @GetMapping("/contacto")
    public String showContactoPage(){
        return "contacto";
    }

}
