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


    // Obtiene todos los tratamientos del sistema
    // http://localhost:8080/tratamientos/all
    @GetMapping("/all")
    public List<Tratamiento> getAllTratamientos() {

        return tratamientoService.getAll();
    }

    
    // Obtiene un tratamiento por su ID
    // http://localhost:8080/tratamientos/id
    @GetMapping("/{id}")
    public Tratamiento getTratamientoById(@PathVariable Long id) {
        return tratamientoService.searchById(id);

    }


    // Agrega un tratamiento al sistema, recibiendo como parametro un objeto de tipo tratamiento en cuerpo de respuesta
    // http://localhost:8080/tratamientos/add
    @PostMapping("/add")
    public void createTratamiento(@RequestBody Tratamiento tratamiento) {
        tratamientoService.add(tratamiento);

    }

    // Actualiza un tratamiento dado su id y recibe como parametro el id de ese tratamiento y el tratamiento actualizado
    // http://localhost:8080/tratamientos/update/id
    @PostMapping("/update/{id}")
    public void updateTratamiento(@PathVariable Long id, @RequestBody Tratamiento tratamiento) {
        tratamientoService.update(tratamiento);

    }

    // Elimina un tratamiento dado su id del sistema y recibe como parametro el id del tratamiento
    // http://localhost:8080/tratamientos/delete/id
    @DeleteMapping("/delete/{id}")
    public void deleteTratamiento(@PathVariable Long id) {
        tratamientoService.deleteById(id);

    }

}
