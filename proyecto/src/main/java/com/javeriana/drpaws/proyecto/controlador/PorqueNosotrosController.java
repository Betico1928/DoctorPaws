package com.javeriana.drpaws.proyecto.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PorqueNosotrosController
{
    @RequestMapping("/porqueNosotros")
    public String showPorqueNosotrosPage()
    {
        return "porque-nosotros";
    }

    @RequestMapping("/porqueNosotros/testimonios")
    public String showTestimoniosPage()
    {
        return "testimonios";
    }
}
