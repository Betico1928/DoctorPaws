package com.javeriana.drpaws.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.servicio.Mascota.MascotaService;

import java.util.List;

@RestController
@RequestMapping("/mascota")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {
    @Autowired
    MascotaService mascotaService;

    // http://localhost:8080/mascota/all -> Vista de todas las mascotas
    @GetMapping("/all")
    public List<Mascota> getAllMascotas() {
        return mascotaService.searchAll();
    }

    // http://localhost:8080/mascota/find/1 -> Vista de una mascota en específico
    @GetMapping("/find/{id}")
    public Mascota getMascotaById(Model model, @PathVariable("id") Long id) {
        return mascotaService.searchById(id);
    }

    // http://localhost:8080/mascota/agregar -> Agregar una mascota
    @PostMapping("/agregar")
    public void agregarMascota(@RequestBody Mascota mascota) {
        System.out.println("\nInformación de la mascota a añadir:");
        System.out.println("+-----------------+--------------------------------+");
        System.out.printf("| %-15s | %-30s |\n", "Nombre", mascota.getNombre());
        System.out.printf("| %-15s | %-30s |\n", "Raza", mascota.getRaza());
        System.out.printf("| %-15s | %-30s |\n", "Edad", mascota.getEdad() + " años");
        System.out.printf("| %-15s | %-30s |\n", "Peso", mascota.getPeso() + " kg");
        System.out.printf("| %-15s | %-30s |\n", "Enfermedad",
                (mascota.getEnfermedad() != null ? mascota.getEnfermedad() : "Ninguna"));
        System.out.println("+-----------------+--------------------------------+");

        mascotaService.add(mascota);
    }

    // http://localhost:8080/mascota/delete/1 -> Eliminar una mascota
    @DeleteMapping("/delete/{id}")
    public void deleteMascota(@PathVariable("id") Long id) {
        System.out.println("ID de la mascota a eliminar: " + id);
        mascotaService.deleteById(id);
    }

    // http://localhost:8080/mascota/actualizar/1 -> Actualizar una mascota
    @PostMapping("/update/{id}")
    public void updateMascota(@PathVariable("id") Long id, @RequestBody Mascota mascota) {
        System.out.println("\nInformación de la mascota a actualizar:");
        System.out.println("+-----------------+--------------------------------+");
        System.out.printf("| %-15s | %-30s |\n", "ID de la mascota", mascota.getId());
        System.out.printf("| %-15s | %-30s |\n", "Nombre", mascota.getNombre());
        System.out.printf("| %-15s | %-30s |\n", "Raza", mascota.getRaza());
        System.out.printf("| %-15s | %-30s |\n", "Edad", mascota.getEdad() + " años");
        System.out.printf("| %-15s | %-30s |\n", "Peso", mascota.getPeso() + " kg");
        System.out.printf("| %-15s | %-30s |\n", "Enfermedad",
                (mascota.getEnfermedad() != null ? mascota.getEnfermedad() : "Ninguna"));
        System.out.println("+-----------------+--------------------------------+");

        mascotaService.update(mascota);
    }

    @GetMapping("/query/total")
    public Long getTotalMascotas() {
        return mascotaService.totalMascotas();
    }

    @GetMapping("/query/total-active")
    public Long getTotalMascotasActivas() {
        return mascotaService.totalMascotasActivas();
    }
}
