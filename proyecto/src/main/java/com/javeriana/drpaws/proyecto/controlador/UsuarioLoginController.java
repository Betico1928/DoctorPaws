package com.javeriana.drpaws.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javeriana.drpaws.proyecto.entidad.Usuario;
import com.javeriana.drpaws.proyecto.servicio.Usuario.UsuarioService;

@Controller
@RequestMapping("/loginUsuario")
public class UsuarioLoginController {

    @Autowired
    private UsuarioService usuarioService;

    // Maneja el GET para mostrar la página de login
    @GetMapping
    public String showLoginPage(Model model) {
        model.addAttribute("loginForm", new Usuario()); // Añadir un objeto Usuario para binding
        return "login-user";
    }

    // Maneja el POST del formulario de login
    @PostMapping
    public String handleLogin(@RequestParam(name = "userId") Integer userId, Model model) {
        Usuario user = usuarioService.searchById(userId);

        if (user != null) {
            return "redirect:/usuario/dash/" + userId;
        } else {
            model.addAttribute("error", true);
            return "login-user"; // Vuelve a mostrar la página de login con el mensaje de error.
        }
    }

}