package com.javeriana.drpaws.proyecto.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PorqueNosotrosController
{
    //http://localhost:8080/porqueNosotros  -> Vista de la página de porque-nosotros
    @RequestMapping("/porqueNosotros")
    public String showPorqueNosotrosPage()
    {
        return "porque-nosotros";
    }

    //http://localhost:8080/porqueNosotros/testimonios  -> Vista de la página de testimonios
    @RequestMapping("/porqueNosotros/testimonios")
    public String showTestimoniosPage()
    {
        return "testimonios";
    }
}
