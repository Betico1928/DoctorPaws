package com.javeriana.drpaws.proyecto.controlador;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(Exception.class) // Esto manejará todas las excepciones
    public String handleError(Model model, Exception exception) {
        // Aquí puedes agregar atributos adicionales relacionados con la excepción
        model.addAttribute("message", exception.getMessage());
        model.addAttribute("exceptionType", exception.getClass().getSimpleName());

        return "pagina_error";
    }
}

