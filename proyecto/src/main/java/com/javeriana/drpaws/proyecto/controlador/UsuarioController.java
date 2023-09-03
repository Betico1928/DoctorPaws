package com.javeriana.drpaws.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javeriana.drpaws.proyecto.entidad.Usuario;
import com.javeriana.drpaws.proyecto.servicio.Usuario.UsuarioService;

@Controller
@RequestMapping("/usuario")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/all")
    public String getAllUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.searchAll());
        return "usuarios";
    }

    // http://localhost:8080/usuario/find/1
    @GetMapping("/find/{id}")
    public String getUsuario(@PathVariable("id") Long id, Model model) {
        Usuario usuario = usuarioService.searchById(id);
        if (usuario != null) {
            model.addAttribute("mascotas", usuarioService.getMascotasByUsuarioID(id));
            model.addAttribute("usuario", usuario);

            return "dashboard-usuario";
        } else {
            throw new NotFoundException(id);
        }
    }

    @GetMapping("/add")
    public String formularioCrear(Model model) {
        Usuario usuario = new Usuario("", "", "", "", "", "");
        model.addAttribute("usuario", usuario);

        return "add-usuario";
    }

    @PostMapping("/agregar")
    public String agregarUsuario(Usuario usuario) {
        usuarioService.add(usuario);

        return "redirect:/usuario/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable("id") Long id) {
        usuarioService.deleteById(id);

        return "redirect:/usuario/all";
    }

    @GetMapping("/update/{id}")
    public String updateUsuarioForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("usuario", usuarioService.searchById(id));

        return "update-usuario";
    }

    @PostMapping("/update/{id}")
    public String updateUsuario(@PathVariable("id") Long id, @ModelAttribute("usuario") Usuario usuario) {
        usuarioService.update(usuario);

        return "redirect:/usuario/all";
    }

}
