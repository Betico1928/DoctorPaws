package com.javeriana.drpaws.proyecto.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javeriana.drpaws.proyecto.controlador.DTO.MedicamentoDTO;
import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.Medicamento;
import com.javeriana.drpaws.proyecto.entidad.Tratamiento;

public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {

        @Query("SELECT COUNT(t) FROM Tratamiento t WHERE t.fechaInicio >= :fechaInicio AND t.fechaInicio <= :fechaFin")
        Long countTratamientosAdminsitradosEnUltimoMes(
                        @Param("fechaInicio") LocalDate fechaInicio,
                        @Param("fechaFin") LocalDate fechaFin);

        @Query("SELECT m.nombre AS medicamento, COUNT(t) AS cantidadTratamientos " +
                        "FROM Tratamiento t " +
                        "JOIN t.medicamento m " +
                        "WHERE t.fechaInicio >= :fechaInicio AND t.fechaInicio <= :fechaFin " +
                        "GROUP BY m.nombre")
        List<Object[]> countTratamientosPorMedicamentoEnUltimoMes(
                        @Param("fechaInicio") LocalDate fechaInicio,
                        @Param("fechaFin") LocalDate fechaFin);

        @Query("SELECT t FROM Tratamiento t WHERE t.mascota = :mascota")
        List<Tratamiento> findTratamientosByMascota(@Param("mascota") Mascota mascota);

}
