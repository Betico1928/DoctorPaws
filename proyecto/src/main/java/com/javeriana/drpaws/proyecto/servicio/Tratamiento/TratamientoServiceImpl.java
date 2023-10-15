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

    @Override
    public Long countTratamientosAdminsitradosEnUltimoMes() {
        LocalDate endDate = LocalDate.now(); // Current date
        LocalDate startDate = endDate.minus(Period.ofMonths(1)); // One month ago

        return repo.countTratamientosAdminsitradosEnUltimoMes(startDate, endDate);
    }

    @Override
    public List<Tratamiento> getAll() {
        return repo.findAll();
    }

    public List<Object[]> obtenerCantidadTratamientosPorMedicamentoEnUltimoMes() {
        // Calcular las fechas para el último mes
        LocalDate fechaFin = LocalDate.now();
        LocalDate fechaInicio = fechaFin.minusMonths(1);

        // Llamar a la consulta personalizada en el repositorio
        return repo.countTratamientosPorMedicamentoEnUltimoMes(fechaInicio, fechaFin);
    }

}
