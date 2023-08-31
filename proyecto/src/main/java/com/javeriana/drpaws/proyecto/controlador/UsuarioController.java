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
import com.javeriana.drpaws.proyecto.servicio.Mascota.MascotaService;
import com.javeriana.drpaws.proyecto.servicio.Usuario.UsuarioService;

@Controller
@RequestMapping("/usuario")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MascotaService mascotaService;

    @GetMapping("/all")
    public String getAllUsuarios(Model model)
    {
        model.addAttribute("usuarios", usuarioService.searchAll());
        return "usuarios";
    }

    @GetMapping("/find/{id}")
    public String getUsuario(@PathVariable("id") int id, Model model)
    {
        Usuario usuario = usuarioService.searchById(id);

        if(usuario != null)
        {
        model.addAttribute("mascotas",usuarioService.findMascotas(mascotaService.searchAll(), id));
        model.addAttribute("usuario", usuario);

        return "usuario";
        }

        else
        {
            throw new NotFoundException(id);
        }
    }

    @GetMapping("/add")
    public String formularioCrear(Model model)
    {
        Usuario usuario = new Usuario(0,"","","","", null,"");
        model.addAttribute("usuario", usuario);

        return "add-usuario";
    }

    @PostMapping("/agregar")
    public String agregarUsuario(Usuario usuario)
    {
        usuarioService.add(usuario);

        return "redirect:/usuario/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable("id") int id)
    {
        usuarioService.deleteById(id);

        return "redirect:/usuario/all";
    }

    @GetMapping("/update/{id}")
    public String updateUsuario(@PathVariable("id") int id, Model model)
    {
        Usuario usuario = usuarioService.searchById(id);
        model.addAttribute("usuario", usuario);

        return "update-usuario";
    }

    @PostMapping("/update/{id}")
    public String updateUsuario(@PathVariable("id") int id, @ModelAttribute("usuario") Usuario usuario)
    {
        usuarioService.update(usuario);

        return "redirect:/usuario/all";
    }

}
