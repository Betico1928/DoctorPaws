package com.javeriana.drpaws.proyecto.servicio.Tratamiento;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javeriana.drpaws.proyecto.entidad.Tratamiento;
import com.javeriana.drpaws.proyecto.repositorio.TratamientoRepository;

@Service
public class TratamientoServiceImpl implements TratamientoService {

    @Autowired
    TratamientoRepository repo;

    @Override
    public Tratamiento searchById(Long id) {
        return repo.findById(id).get();

    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);

    }

    @Override
    public void update(Tratamiento tratamiento) {
        repo.save(tratamiento);
    }

    @Override
    public void add(Tratamiento tratamiento) {
        repo.save(tratamiento);
    }

    // Retorna la cuenta de tratamientos administrados en el último mes
    @Override
    public Long countTratamientosAdminsitradosEnUltimoMes() {
        LocalDate endDate = LocalDate.now(); // Fecha actual
        LocalDate startDate = endDate.minus(Period.ofMonths(1)); // Hace un mes pasado

        return repo.countTratamientosAdminsitradosEnUltimoMes(startDate, endDate);
    }

    // Retorna la lista de tratamientos en el sistema
    @Override
    public List<Tratamiento> getAll() {
        return repo.findAll();
    }

    // Obtiene la frecuencia de uso de un medicamento por su nombre en cada tratamiento en una lista
    public List<Object[]> obtenerCantidadTratamientosPorMedicamentoEnUltimoMes() {
        // Calcular las fechas para el último mes

        // La fecha actual
        LocalDate fechaFin = LocalDate.now();
        // La fecha hace un mes
        LocalDate fechaInicio = fechaFin.minusMonths(1);

        // Llamar a la consulta personalizada en el repositorio
        return repo.countTratamientosPorMedicamentoEnUltimoMes(fechaInicio, fechaFin);
    }

    // Obtiene los 3 medicamentos más usados en los tratamientos
    @Override
    public List<Object[]> findTop3Treatments(){
        return repo.findTop3Treatments();
    }

    // Calcula las ventas totales
    @Override
    public Object computeSales(){
        return repo.computeSales();
    }

    // Calcula las ganancias totales
    @Override
    public Object computeProfit(){
        return repo.computeProfit();
    }


}
