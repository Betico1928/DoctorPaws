package com.javeriana.drpaws.proyecto.controlador;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.Tratamiento;
import com.javeriana.drpaws.proyecto.servicio.Mascota.MascotaService;

import java.util.List;

@RestController
@RequestMapping("/mascota")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {
    @Autowired
    MascotaService mascotaService;

    private Logger logger = org.slf4j.LoggerFactory.getLogger(MascotaController.class);

    // http://localhost:8080/mascota/all -> Vista de todas las mascotas
    @GetMapping("/all")
    public List<Mascota> getAllMascotas() {
        return mascotaService.searchAll();
    }

    // http://localhost:8080/mascota/find/1 -> Vista de una mascota en específico
    @GetMapping("/find/{id}")
    public ResponseEntity<Mascota> getMascotaById(Model model, @PathVariable("id") Long id)
    {
        Mascota mascota = mascotaService.searchById(id);

        if(mascota == null)
        {
            logger.error("Mascota con id " + id + " no existe.");
            return ResponseEntity.notFound().build();
        }
        else
        {
            logger.info("Mascota con id " + id + " encontrada.");
            return ResponseEntity.ok(mascota);
        }
    }

    // http://localhost:8080/mascota/agregar -> Agregar una mascota
    @PostMapping("/agregar")
    public void agregarMascota(@RequestBody Mascota mascota)
    {
        System.out.println("\nInformación de la mascota a añadir:");
        System.out.println("+-----------------+--------------------------------+");
        System.out.printf("| %-15s | %-30s |\n", "Dueño", mascota.getUsuario().getNombre());
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

    // http://localhost:8080/mascota/update/1 -> Actualizar una mascota
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

    // http://localhost:8080/mascota/tratamientos/1 -> Vista de los tratamientos de una mascota
    @GetMapping("/tratamientos/{id}")
    public List<Tratamiento> getTratamientosByNombreMascota(@PathVariable("id") Long id) {
        return mascotaService.getTratamientosByNombreMascota(id);
    }
}
