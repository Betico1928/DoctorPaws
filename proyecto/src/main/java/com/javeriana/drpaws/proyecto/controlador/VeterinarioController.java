package com.javeriana.drpaws.proyecto.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javeriana.drpaws.proyecto.entidad.Veterinario;
import com.javeriana.drpaws.proyecto.servicio.Veterinario.VeterinarioService;

@RestController
@RequestMapping("/veterinario")
@CrossOrigin(origins = "http://localhost:4200")
public class VeterinarioController {

    private final VeterinarioService veterinarioService;

    public VeterinarioController(VeterinarioService veterinarioService) {
        this.veterinarioService = veterinarioService;
    }

    // Para buscar a un veterinario en especifico:
    // http://localhost:8080/veterinario/{id}
    @GetMapping("/{id}")
    public Veterinario getVeterinario(@PathVariable("id") Long id)
    {
        System.out.println("Buscando al veterinario con ID: " + id);
        return veterinarioService.searchById(id);
    }

    // Para crear a un veterinario
    // http://localhost:8080/veterinario/add
    @PostMapping("/add")
    public void createVeterinario(@RequestBody Veterinario veterinario)
    {
        System.out.println("\nInformación del veterinario a crear:");
        System.out.println("+----------------+-------------------------------------+");
        System.out.printf("| %-14s | %-35s |\n", "ID", veterinario.getId());
        System.out.printf("| %-14s | %-35s |\n", "Especialidad", veterinario.getEspecialidad());
        System.out.printf("| %-14s | %-35s |\n", "Nombre", veterinario.getNombre());
        System.out.printf("| %-14s | %-35s |\n", "Email", veterinario.getEmail());
        System.out.printf("| %-14s | %-35s |\n", "Password", "****"); // No es recomendable imprimir contraseñas
        System.out.printf("| %-14s | %-35s |\n", "Imagen URL", veterinario.getImagen());
        System.out.printf("| %-14s | %-35s |\n", "Activo", veterinario.isActivo() ? "Sí" : "No");
        System.out.println("+----------------+-------------------------------------+");

        veterinarioService.add(veterinario);
    }

    // Para actualizar a un veterinario en especifico:
    // http://localhost:8080/veterinario/update/{id}
    @PostMapping("/update/{id}")
    public void updateVeterinario(@PathVariable("id") Long id, @RequestBody Veterinario veterinario)
    {
        System.out.println("\nInformación del veterinario a actualizar:");
        System.out.println("+----------------+-------------------------------------+");
        System.out.printf("| %-14s | %-35s |\n", "ID", veterinario.getId());
        System.out.printf("| %-14s | %-35s |\n", "Especialidad", veterinario.getEspecialidad());
        System.out.printf("| %-14s | %-35s |\n", "Nombre", veterinario.getNombre());
        System.out.printf("| %-14s | %-35s |\n", "Email", veterinario.getEmail());
        System.out.printf("| %-14s | %-35s |\n", "Password", "****"); // No es recomendable imprimir contraseñas
        System.out.printf("| %-14s | %-35s |\n", "Imagen URL", veterinario.getImagen());
        System.out.printf("| %-14s | %-35s |\n", "Activo", veterinario.isActivo() ? "Sí" : "No");
        System.out.println("+----------------+-------------------------------------+");

        veterinarioService.update(veterinario);
    }

    // Para borrar a un veterinario en especifico:
    // http://localhost:8080/veterinario/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void deleteVeterinario(@PathVariable("id") Long id)
    {
        System.out.println("Borrando al veterinario con ID: " + id);
        veterinarioService.deleteById(id);
    }

    // Para buscar a todos los veterinarios:
    // http://localhost:8080/veterinario/all
    @GetMapping("/all")
    public List<Veterinario> getAllVeterinarios()
    {
        System.out.println("Buscando a todos los veterinarios...");
        return veterinarioService.searchAll();
    }

    // Para obtener a todos los veterinarios activos:
    // http://localhost:8080/veterinario/query/count-active
    @GetMapping("/query/count-active")
    public Long obtenerCantidadVeterinariosActivos() {
        return veterinarioService.obtenerCantidadVeterinariosActivos();
    }

    // Para obtener a todos los veterinarios NO activos:
    // http://localhost:8080/veterinario/query/count-inactive
    @GetMapping("/query/count-inactive")
    public Long obtenerCantidadVeterinariosInactivos() {
        return veterinarioService.obtenerCantidadVeterinariosInactivos();
    }
}
