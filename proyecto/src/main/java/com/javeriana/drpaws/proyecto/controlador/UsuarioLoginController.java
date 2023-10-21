package com.javeriana.drpaws.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javeriana.drpaws.proyecto.entidad.Usuario;
import com.javeriana.drpaws.proyecto.servicio.Usuario.UsuarioService;

@RestController
@RequestMapping("/loginUsuario")
@CrossOrigin(origins = "http://localhost:")
public class UsuarioLoginController {

    @Autowired
    private UsuarioService usuarioService;

    // // Maneja el GET para mostrar la página de login
    // @GetMapping
    // public String showLoginPage(Model model)
    // {
    // model.addAttribute("loginForm", new Usuario()); // Añadir un objeto Usuario
    // para binding
    // return "login-user";
    // }

    // Maneja el POST del formulario de login
    @PostMapping
    public String handleLogin(@RequestParam(name = "userId") String userInput, Model model) {
        try {
            Long userId = Long.parseLong(userInput);
            Usuario user = usuarioService.searchById(userId);

            if (user != null) {
                return "redirect:/usuario/find/" + userId;
            } else {
                model.addAttribute("error", "Usuario no encontrado");
                return "login-user";
            }
        } catch (NumberFormatException e) {
            // Si el usuario introduce texto en lugar de un número
            model.addAttribute("error", "ID introducido no es válido");
            return "login-user";
        } catch (Exception e) {
            // Otros errores no especificados
            model.addAttribute("error", "Ha ocurrido un error desconocido");
            return "login-user";
        }
    }
}