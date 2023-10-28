package com.javeriana.drpaws.proyecto.servicio.Tratamiento;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.Medicamento;
import com.javeriana.drpaws.proyecto.entidad.Tratamiento;
import com.javeriana.drpaws.proyecto.entidad.Veterinario;
import com.javeriana.drpaws.proyecto.repositorio.MascotaRepository;
import com.javeriana.drpaws.proyecto.repositorio.MedicamentoRepository;
import com.javeriana.drpaws.proyecto.repositorio.TratamientoRepository;
import com.javeriana.drpaws.proyecto.repositorio.VeterinarioRepository;

@Service
public class TratamientoServiceImpl implements TratamientoService {

    @Autowired
    TratamientoRepository repo;

    @Autowired
    MascotaRepository mascotaRepo;

    @Autowired
    MedicamentoRepository medicamentoRepo;

    @Autowired
    VeterinarioRepository veterinarioRepo;

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
    public void add(Tratamiento tratamiento, Long idMascota, Long idMedicamento, Long idVeterinario) {
        // System.out.println("Tratamiento: " + tratamiento);
        // System.out.println("Mascota: " + idMascota);
        // System.out.println("Medicamento: " + idMedicamento);
        // System.out.println("Veterinario: " + idVeterinario);
        // Find the associated Mascota, Medicamento, and Veterinario objects
        Mascota mascota = mascotaRepo.findById(idMascota).orElseThrow(() -> new RuntimeException("Mascota not found"));
        Medicamento medicamento = medicamentoRepo.findById(idMedicamento)
                .orElseThrow(() -> new RuntimeException("Medicamento not found"));
        Veterinario veterinario = veterinarioRepo.findById(idVeterinario)
                .orElseThrow(() -> new RuntimeException("Veterinario not found"));

        // Set the associated objects on the Tratamiento object
        tratamiento.setMascota(mascota);
        tratamiento.setMedicamento(medicamento);
        tratamiento.setVeterinario(veterinario);

        // El front-end verifica que solo aparezcan medicamentos con unidades disponibles 

        // Se actualiza el numero de unidades disponibles 
        medicamento.setUnidadesDisponibles(medicamento.getUnidadesDisponibles()-1);

        // Se actualiza el numero de unidades disponibles
        medicamento.setUnidadesVendidas(medicamento.getUnidadesVendidas()+1);

        // Save the Tratamiento object
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

    // Obtiene la frecuencia de uso de un medicamento por su nombre en cada
    // tratamiento en una lista
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
    public List<Object[]> findTop3Treatments() {
        return repo.findTop3Treatments();
    }

    // Calcula las ventas totales
    @Override
    public Object computeSales() {
        return repo.computeSales();
    }

    // Calcula las ganancias totales
    @Override
    public Object computeProfit() {
        return repo.computeProfit();
    }

}
