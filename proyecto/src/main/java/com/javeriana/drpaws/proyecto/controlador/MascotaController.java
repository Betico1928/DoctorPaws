package com.javeriana.drpaws.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javeriana.drpaws.proyecto.entidad.Usuario;
import com.javeriana.drpaws.proyecto.servicio.Usuario.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class MascotaController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/dash/{id}")
    public String getAllMascotas(Model model, @PathVariable("id") int id) {
        Usuario usuario = usuarioService.searchById(id);
        model.addAttribute("usuario", usuario);
        return "mascotas";

    }

    @GetMapping("/find/{uid}/{id}")
    public String getMascotaById(Model model, @PathVariable("uid") int uid, @PathVariable("id") int id) {
        model.addAttribute("mascota", usuarioService.searchMascota(uid, id));
        model.addAttribute("usuario", usuarioService.searchById(uid));
        return "mascota";
    }

}
