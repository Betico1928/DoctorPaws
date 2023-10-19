package com.javeriana.drpaws.proyecto.Repository;

import com.javeriana.drpaws.proyecto.entidad.Tratamiento;
import com.javeriana.drpaws.proyecto.repositorio.TratamientoRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@DataJpaTest
@RunWith(SpringRunner.class)
public class TratamientoRepositoryTest
{
    @Autowired
    private TratamientoRepository tratamientoRepository;

    private Logger logger = LoggerFactory.getLogger(TratamientoRepositoryTest.class);


    // Primera prueba: Contar tratamientos administrados en el último mes:
    @Test
    public void TratamientoRepository_testCountTratamientosAdminsitradosEnUltimoMes_Long()
    {
        // 1. Arrange:
        Tratamiento tratamiento1 = new Tratamiento(1L, "Tratamiento 1", "Descripción del tratamiento", LocalDate.now().minusMonths(1), LocalDate.now(), 100000, "Frecuencia del tratamiento 1");
        Tratamiento tratamiento2 = new Tratamiento(2L, "Tratamiento 2", "Descripción del tratamiento", LocalDate.now().minusMonths(2), LocalDate.now(), 100000, "Frecuencia del tratamiento 2");
        tratamientoRepository.save(tratamiento1);
        tratamientoRepository.save(tratamiento2);

        LocalDate fechaInicio = LocalDate.now().minusMonths(5);
        LocalDate fechaFin = LocalDate.now();

        // 2. Act:
        Long numeroTratamientos = tratamientoRepository.countTratamientosAdminsitradosEnUltimoMes(fechaInicio, fechaFin);

        // 3. Assert:
        try
        {
            Assertions.assertThat(numeroTratamientos).isEqualTo(2);
            logger.info(() -> "Numero de tratamientos administrados en el último mes: " + numeroTratamientos);
        }
        catch (AssertionError e) {
            logger.error(() -> "Error en la prueba de contar tratamientos administrados en el último mes");
            throw e;  // Vuelve a lanzar el error para que el test falle si estás en un entorno de pruebas
        }
    }
}