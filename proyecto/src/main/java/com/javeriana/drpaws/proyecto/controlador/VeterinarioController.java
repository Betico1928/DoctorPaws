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

    @GetMapping("/{id}")
    public Veterinario getVeterinario(@PathVariable Long id) {
        return veterinarioService.searchById(id);
    }

    @PostMapping("/add")
    public void createVeterinario(@RequestBody Veterinario veterinario) {
        veterinarioService.add(veterinario);
    }

    @PostMapping("/update/{id}")
    public void updateVeterinario(@PathVariable Long id, @RequestBody Veterinario veterinario) {
        veterinarioService.update(veterinario);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVeterinario(@PathVariable Long id) {
        veterinarioService.deleteById(id);
    }

    @GetMapping("/all")
    public List<Veterinario> getAllVeterinarios() {
        return veterinarioService.searchAll();
    }
}
