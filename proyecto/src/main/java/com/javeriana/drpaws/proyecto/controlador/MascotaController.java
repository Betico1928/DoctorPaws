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
import com.javeriana.drpaws.proyecto.servicio.mascota.MascotaService;

@Controller
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    MascotaService mascotaService;

    @GetMapping("/all")
    public String getAllMascotas(Model model) {

        model.addAttribute("mascotas", mascotaService.searchAll());
        return "dashboard-mascotas";

    }

    @GetMapping("/find/{id}")
    public String getMascotaById(Model model, @PathVariable("id") Long id) {
        model.addAttribute("mascota", mascotaService.searchById(id));
        return "ver-mascota";
    }

    @GetMapping("/add")
    public String formularioCrear(Model model) {
        Mascota mascota = new Mascota("", "", 0, 0, "", "");
        model.addAttribute("mascota", mascota);
        return "add-mascota";
    }

    @PostMapping("/agregar")
    public String agregarMascota(Mascota mascota) {
        mascotaService.add(mascota);
        return "redirect:/mascota/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteMascota(@PathVariable("id") Long id) {
        mascotaService.deleteById(id);
        return "redirect:/mascota/all";

    }

    @GetMapping("/actualizar/{id}")
    public String updateMascotaForm(@PathVariable("id") Long id, Model model) {
        Mascota mascota = mascotaService.searchById(id);
        model.addAttribute("mascota", mascota);
        return "update-mascota";
    }

    @PostMapping("/actualizar/{id}")
    public String updateMascota(@PathVariable("id") Long id, @ModelAttribute("mascota") Mascota mascota) {
        mascotaService.update(mascota);
        return "redirect:/mascota/all";
    }

}
