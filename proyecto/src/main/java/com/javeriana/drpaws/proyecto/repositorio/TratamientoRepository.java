package com.javeriana.drpaws.proyecto.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.Tratamiento;

public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {

        // Consulta personalizada para el número de tratameintos en el ultimo mes
        @Query("SELECT COUNT(t) FROM Tratamiento t WHERE t.fechaInicio >= :fechaInicio AND t.fechaInicio <= :fechaFin")
        Long countTratamientosAdminsitradosEnUltimoMes(
                        @Param("fechaInicio") LocalDate fechaInicio,
                        @Param("fechaFin") LocalDate fechaFin);

        // Consulta personalizada que agrupa medicamentos y su frecuencia de uso en los tratamientos
        @Query("SELECT m.nombre AS medicamento, COUNT(t) AS cantidadTratamientos " +
                        "FROM Tratamiento t " +
                        "JOIN t.medicamento m " +
                        "WHERE t.fechaInicio >= :fechaInicio AND t.fechaInicio <= :fechaFin " +
                        "GROUP BY m.nombre")
        List<Object[]> countTratamientosPorMedicamentoEnUltimoMes(
                        @Param("fechaInicio") LocalDate fechaInicio,
                        @Param("fechaFin") LocalDate fechaFin);

        // Devuelve los tratamientos que tiene una mascota
        @Query("SELECT t FROM Tratamiento t WHERE t.mascota = :mascota")
        List<Tratamiento> findTratamientosByMascota(@Param("mascota") Mascota mascota);


        // Consulta personalizada ajustada para la anotación query
        // Devuelve los tres medicamentos más usados en el los tratamientos
        @Query("SELECT m.nombre, m.unidadesVendidas " +
                        "FROM Tratamiento t INNER JOIN Medicamento m ON t.medicamento.id = m.id " +
                        "GROUP BY m.nombre " +
                        "ORDER BY m.unidadesVendidas DESC " +
                        "LIMIT 3")
        List<Object[]> findTop3Treatments();


        // Consulta personalizada ajustada para laanotación query
        // Devuelve las ventas totales con la formula descrita en la clausula select
        @Query("SELECT CAST(sum(m.unidadesVendidas*m.precioVenta) as java.math.BigDecimal) " +
                        "FROM Medicamento m " +
                        "WHERE m.unidadesVendidas > 0")
        Object computeSales();

        // Consulta personalizada ajustada para la anotación query
        // Devuelve las ganancias totales con la formula descrita en la clausula select
        @Query("SELECT cast(sum(m.unidadesVendidas*m.precioVenta-m.precioVenta) as java.math.BigDecimal) " +
                        "FROM Medicamento m " +
                        "WHERE m.unidadesVendidas > 0")
        Object computeProfit();
}
