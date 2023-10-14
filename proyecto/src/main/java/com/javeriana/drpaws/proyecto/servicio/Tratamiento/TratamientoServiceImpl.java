package com.javeriana.drpaws.proyecto.servicio.Tratamiento;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javeriana.drpaws.proyecto.controlador.DTO.MedicamentoDTO;
import com.javeriana.drpaws.proyecto.entidad.Medicamento;
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

    @Override
    public List<MedicamentoDTO> countTratamientosPorTipoMedicamentoAdminsitradoEnUltimoMes() {
        LocalDate endDate = LocalDate.now(); // Current date
        LocalDate startDate = endDate.minus(Period.ofMonths(1)); // One month ago
        List<Medicamento> medicamentos = repo.countTratamientosPorTipoMedicamentoAdminsitradoEnUltimoMes(startDate,
                endDate);

        List<MedicamentoDTO> medicamentoDTOs = new ArrayList<>();
        for (Medicamento medicamento : medicamentos) {
            MedicamentoDTO dto = new MedicamentoDTO();
            dto.setId(medicamento.getId());
            dto.setNombre(medicamento.getNombre());
            int cantidad = countTratamientosForMedicamento(medicamento, startDate, endDate);
            dto.setCantidadTratamientos(cantidad);
            medicamentoDTOs.add(dto);
        }

        return medicamentoDTOs;
    }

    // Helper method to count treatments for a specific Medicamento
    private int countTratamientosForMedicamento(Medicamento medicamento, LocalDate startDate, LocalDate endDate) {
        int cantidad = 0;
        for (Tratamiento tratamiento : medicamento.getTratamientos()) {
            LocalDate fechaInicio = tratamiento.getFechaInicio();
            if (fechaInicio != null && fechaInicio.isAfter(startDate) && fechaInicio.isBefore(endDate)) {
                cantidad++;
            }
        }
        return cantidad;
    }

}
