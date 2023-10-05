package com.javeriana.drpaws.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.servicio.Mascota.MascotaService;

import java.util.List;

@RestController
@RequestMapping("/mascota")
public class MascotaController
{
    @Autowired
    MascotaService mascotaService;

    // http://localhost:8080/mascota/all -> Vista de todas las mascotas
    @GetMapping("/all")
    public List<Mascota> getAllMascotas()
    {
        return (List<Mascota>) mascotaService.searchAll();
    }

    // http://localhost:8080/mascota/find/1 -> Vista de una mascota en específico
    @GetMapping("/find/{id}")
    public Mascota getMascotaById(Model model, @PathVariable("id") Long id)
    {
        return mascotaService.searchById(id);
    }


    // http://localhost:8080/mascota/agregar -> Agregar una mascota
    @PostMapping("/agregar")
    public void agregarMascota(@RequestBody Mascota mascota)
    {
        mascotaService.add(mascota);
    }

    // http://localhost:8080/mascota/delete/1 -> Eliminar una mascota
    @DeleteMapping("/delete/{id}")
    public void deleteMascota(@PathVariable("id") Long id)
    {
        mascotaService.deleteById(id);
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
