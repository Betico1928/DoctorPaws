package com.javeriana.drpaws.proyecto.controlador;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(Model model) {
        // Aquí puedes agregar atributos adicionales si es necesario
        return "pagina_error";
    }
}

