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
import com.javeriana.drpaws.proyecto.servicio.Mascota.MascotaService;

@Controller
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    MascotaService mascotaService;

    // http://localhost:8080/mascota/all -> Vista de todas las mascotas
    @GetMapping("/all")
    public String getAllMascotas(Model model)
    {
        model.addAttribute("mascotas", mascotaService.searchAll());
        return "dashboard-mascotas";
    }

    // http://localhost:8080/mascota/find/1 -> Vista de una mascota en específico
    @GetMapping("/find/{id}")
    public String getMascotaById(Model model, @PathVariable("id") Long id)
    {
        model.addAttribute("mascota", mascotaService.searchById(id));
        return "ver-mascota";
    }


    // http://localhost:8080/mascota/add -> Vista del formulario para crear una mascota
    @GetMapping("/add")
    public String formularioCrear(Model model)
    {
        Mascota mascota = new Mascota("", "", 0, 0, "", "");
        model.addAttribute("mascota", mascota);
        return "add-mascota";
    }


    // http://localhost:8080/mascota/agregar -> Agregar una mascota
    @PostMapping("/agregar")
    public String agregarMascota(Mascota mascota)
    {
        mascotaService.add(mascota);
        return "redirect:/mascota/all";
    }

    // http://localhost:8080/mascota/delete/1 -> Eliminar una mascota
    @GetMapping("/delete/{id}")
    public String deleteMascota(@PathVariable("id") Long id)
    {
        mascotaService.deleteById(id);
        return "redirect:/mascota/all";
    }


    // http://localhost:8080/mascota/update/1 -> Vista del formulario para actualizar una mascota
    @GetMapping("/update/{id}")
    public String updateMascotaForm(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("mascota", mascotaService.searchById(id));
        return "update-mascota";
    }


    // http://localhost:8080/mascota/actualizar/1 -> Actualizar una mascota
    @PostMapping("/update/{id}")
    public String updateMascota(@PathVariable("id") Long id, @ModelAttribute("mascota") Mascota mascota)
    {
        System.out.println("Updating mascota with ID: " + id);
        System.out.println("Mascota object: " + mascota.toString());
        mascotaService.update(mascota);
        return "redirect:/mascota/all";
    }
}
