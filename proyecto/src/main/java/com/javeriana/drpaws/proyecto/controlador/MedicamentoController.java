package com.javeriana.drpaws.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javeriana.drpaws.proyecto.entidad.Medicamento;
import com.javeriana.drpaws.proyecto.servicio.Medicamento.MedicamentoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoServicio;

    // Para obtener la lista total de los medicamentos en el sistema
    // http://localhost:8080/medicamentos/all
    @GetMapping("/all")
    public List<Medicamento> getAllMedicamentos() {
        return medicamentoServicio.getAll();
    }

    // Devuelve un medicamento identificado por su ID
    // http://localhost:8080/medicamentos/find/{id}
    @GetMapping("/find/{id}")
    public Medicamento getMedicamento(@PathVariable("id") Long id) {
        return medicamentoServicio.searchById(id);
    }

    
    // Devuelve un medicamento identificado por su ID
    // http://localhost:8080/medicamentos/find/{id}
    @PostMapping("/add")
    public void addMedicamento(@RequestBody Medicamento medicamento) {
        medicamentoServicio.add(medicamento);
    }

    // Actualiza un medicamento identificado por su ID
    // http://localhost:8080/medicamentos/update/{id}
    @PostMapping("/update/{id}")
    public void updateMedicamento(@RequestBody Medicamento medicamento, @PathVariable("id") Long id) {
        medicamentoServicio.update(medicamento);
    }

    // Elimina un medicamento del sistema dado su ID
    // http://localhost:8080/medicamentos/update/{id}
    @DeleteMapping("/delete/{id}")
    public void deleteMedicamento(@PathVariable("id") Long id) {
        medicamentoServicio.deleteById(id);
    }

}