package com.javeriana.drpaws.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javeriana.drpaws.proyecto.entidad.Veterinario;
import com.javeriana.drpaws.proyecto.repositorio.VeterinarioRepository;

@Controller
@RequestMapping("/loginVeterinario")
public class VeterinarioLoginController {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @GetMapping
    public ModelAndView showLoginForm() {
        ModelAndView mav = new ModelAndView("/login-administrativo");
        mav.addObject("loginForm", new Veterinario());
        return mav;
    }

    @PostMapping
    public String processLogin(Veterinario loginForm)
    {
        System.out.println("Email enviado desde el formulario: " + loginForm.getEmail());
        System.out.println("Contraseña enviada desde el formulario: " + loginForm.getPassword());

        Veterinario existente = veterinarioRepository.findByEmail(loginForm.getEmail());

        if (existente != null)
        {
            System.out.println("Email en el repositorio: " + existente.getEmail());
            System.out.println("Contraseña en el repositorio: " + existente.getPassword());

            if (existente.getPassword().equals(loginForm.getPassword()))
            {
                return "redirect:/mascota/all";
            }
        }
        return "redirect:/loginVeterinario?error=true";
    }

}
