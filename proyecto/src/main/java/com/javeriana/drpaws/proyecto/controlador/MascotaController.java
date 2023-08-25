package com.javeriana.drpaws.proyecto.controlador;

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
import com.javeriana.drpaws.proyecto.servicio.MascotaService;
import com.javeriana.drpaws.proyecto.servicio.Usuario.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class MascotaController {

    @Autowired
    UsuarioService usuarioService;
    MascotaService mascotaService;

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

    @GetMapping("/add")
    public String formularioCrear(Model model) {
        Mascota mascota = new Mascota(0, "", "", 0, 0, "", "");
        model.addAttribute("mascota", mascota);
        return "add-mascota";
    }

    @PostMapping("/agregar")
    public String agregarMascota(Mascota mascota) {
        mascotaService.add(mascota);
        return "redirect:";
    }

    @GetMapping("/delete/{id}")
    public String deleteMascota(@PathVariable("id") int id) {
        mascotaService.deleteById(id);
        return "redirect:";

    }

    @GetMapping("/update/{id}")
    public String updateMascota(@PathVariable("id") int id, Model model) {
        Mascota mascota = mascotaService.searchById(id);
        model.addAttribute("mascota", mascota);
        return "update-mascota";
    }

    @PostMapping("/update/{id}")
    public String updateMascota(@PathVariable("id") int id, @ModelAttribute("mascota") Mascota mascota) {
        mascotaService.update(mascota);
        return "redirect:";
    }

}
