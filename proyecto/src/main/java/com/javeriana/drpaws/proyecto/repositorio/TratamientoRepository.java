package com.javeriana.drpaws.proyecto.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
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

        /*
         * select t.nombre, count(m.unidades_vendidas)
         * from TRATAMIENTO t inner join MEDICAMENTO m on m.id = t.medicamento_id
         * group by t.nombre
         * order by count(m.unidades_vendidas) DESC
         * fetch first 3 rows only;
         */
        @Query("SELECT m.nombre, COUNT(m.unidadesVendidas) " +
                        "FROM Tratamiento t INNER JOIN Medicamento m ON t.medicamento.id = m.id " +
                        "GROUP BY m.nombre " +
                        "ORDER BY COUNT(m.unidadesVendidas) DESC " +
                        "LIMIT 3")
        List<Object[]> findTop3Treatments();

        /*
         * select cast(sum(m.unidades_vendidas*m.precio_venta) as NUMERIC)
         * "Venta Total Medicamento"
         * from MEDICAMENTO m
         * where m.unidades_vendidas > 0;
         */

        @Query("SELECT CAST(sum(m.unidadesVendidas*m.precioVenta) as java.math.BigDecimal) " +
                        "FROM Medicamento m " +
                        "WHERE m.unidadesVendidas > 0")
        Object computeSales();

        /*
         * select cast(sum(m.unidades_vendidas*m.precio_venta) as NUMERIC)
         * "Venta Total Medicamento"
         * from MEDICAMENTO m
         * where m.unidades_vendidas > 0;
         */
        @Query("SELECT cast(sum(m.unidadesVendidas*m.precioVenta-m.precioVenta) as java.math.BigDecimal) " +
                        "FROM Medicamento m " +
                        "WHERE m.unidadesVendidas > 0")
        Object computeProfit();
}
