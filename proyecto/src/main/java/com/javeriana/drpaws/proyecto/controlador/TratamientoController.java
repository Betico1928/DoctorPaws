package com.javeriana.drpaws.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javeriana.drpaws.proyecto.entidad.Tratamiento;
import com.javeriana.drpaws.proyecto.servicio.Tratamiento.TratamientoService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tratamientos")
public class TratamientoController {
    @Autowired
    private TratamientoService tratamientoService;

    @GetMapping("/all")
    public List<Tratamiento> getAllTratamientos() {

        return tratamientoService.getAll();
    }

    @GetMapping("/{id}")
    public Tratamiento getTratamientoById(@PathVariable Long id) {
        return tratamientoService.searchById(id);

    }

    @PostMapping("/add")
    public void createTratamiento(@RequestBody Tratamiento tratamiento) {
        tratamientoService.add(tratamiento);

    }

    @PostMapping("/update/{id}")
    public void updateTratamiento(@PathVariable Long id, @RequestBody Tratamiento tratamiento) {
        tratamientoService.update(tratamiento);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteTratamiento(@PathVariable Long id) {
        tratamientoService.deleteById(id);

    }

}
