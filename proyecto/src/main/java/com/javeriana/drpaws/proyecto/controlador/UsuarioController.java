package com.javeriana.drpaws.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.Usuario;
import com.javeriana.drpaws.proyecto.servicio.Usuario.UsuarioService;

@Controller
@RequestMapping("/usuario")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    // http://localhost:8080/usuario/all -> Vista de todos los usuarios
    @GetMapping("/all")
    public String getAllUsuarios(Model model)
    {
        model.addAttribute("usuarios", usuarioService.searchAll());
        return "usuarios";
    }

    // http://localhost:8080/usuario/find/1 -> Vista de un usuario en específico
    @GetMapping("/find/{id}")
    public String getUsuario(@PathVariable("id") Long id, Model model)
    {
        Usuario usuario = usuarioService.searchById(id);
        if (usuario != null) {
            List<Mascota> mascotas = usuarioService.getMascotasByUsuarioID(id);
            model.addAttribute("mascotas", mascotas);
            model.addAttribute("usuario", usuario);
            return "dashboard-usuario";
        } else {
            throw new NotFoundException(id);
        }
    }


    // http://localhost:8080/usuario/add -> Vista del formulario para crear un usuario
    @GetMapping("/add")
    public String formularioCrear(Model model)
    {
        Usuario usuario = new Usuario("", "", "", "", "", "");
        model.addAttribute("usuario", usuario);

        return "add-usuario";
    }


    // http://localhost:8080/usuario/agregar -> Agregar un usuario
    @PostMapping("/agregar")
    public String agregarUsuario(Usuario usuario)
    {
        usuarioService.add(usuario);
        return "redirect:/usuario/all";
    }


    // http://localhost:8080/usuario/delete/1 -> Eliminar un usuario
    @GetMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable("id") Long id)
    {
        usuarioService.deleteById(id);
        return "redirect:/usuario/all";
    }


    // http://localhost:8080/usuario/update/1 -> Vista del formulario para actualizar un usuario
    @GetMapping("/update/{id}")
    public String updateUsuarioForm(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("usuario", usuarioService.searchById(id));
        return "update-usuario";
    }


    // http://localhost:8080/usuario/actualizar/1 -> Actualizar un usuario
    @PostMapping("/update/{id}")
    public String updateUsuario(@PathVariable("id") Long id, @ModelAttribute("usuario") Usuario usuario)
    {
        System.out.println("Updating user with ID: " + id);
        System.out.println("User object: " + usuario.toString());
        usuarioService.update(usuario);

        return "redirect:/usuario/all";
    }
}
