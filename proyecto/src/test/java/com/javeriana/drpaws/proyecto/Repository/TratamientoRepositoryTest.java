package com.javeriana.drpaws.proyecto.Repository;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.Medicamento;
import com.javeriana.drpaws.proyecto.entidad.Tratamiento;
import com.javeriana.drpaws.proyecto.repositorio.MascotaRepository;
import com.javeriana.drpaws.proyecto.repositorio.MedicamentoRepository;
import com.javeriana.drpaws.proyecto.repositorio.TratamientoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
@RunWith(SpringRunner.class)
public class TratamientoRepositoryTest {
        @Autowired
        private TratamientoRepository tratamientoRepository;

        @Autowired
        private MascotaRepository mascotaRepository;

        @Autowired
        private MedicamentoRepository medicamentoRepository;

        private Logger logger = LoggerFactory.getLogger(TratamientoRepositoryTest.class);

        // Primera prueba: Contar tratamientos administrados en el último mes:
        @Test
        public void TratamientoRepository_testCountTratamientosAdminsitradosEnUltimoMes_Long() {
                // 1. Arrange:
                Tratamiento tratamiento1 = new Tratamiento(1L, "Tratamiento 1", "Descripción del tratamiento",
                                LocalDate.now().minusMonths(1), LocalDate.now(), 100000,
                                "Frecuencia del tratamiento 1");
                Tratamiento tratamiento2 = new Tratamiento(2L, "Tratamiento 2", "Descripción del tratamiento",
                                LocalDate.now().minusMonths(2), LocalDate.now(), 100000,
                                "Frecuencia del tratamiento 2");
                tratamientoRepository.save(tratamiento1);
                tratamientoRepository.save(tratamiento2);

                LocalDate fechaInicio = LocalDate.now().minusMonths(5);
                LocalDate fechaFin = LocalDate.now();

                // 2. Act:
                Long numeroTratamientos = tratamientoRepository.countTratamientosAdminsitradosEnUltimoMes(fechaInicio,
                                fechaFin);

                // 3. Assert:
                try {
                        Assertions.assertThat(numeroTratamientos).isEqualTo(2);
                        logger.info(() -> "Numero de tratamientos administrados en el último mes: "
                                        + numeroTratamientos);
                } catch (AssertionError e) {
                        logger.error(() -> "Error en la prueba de contar tratamientos administrados en el último mes");
                        throw e; // Vuelve a lanzar el error para que el test falle si estás en un entorno de
                                 // pruebas
                }

        }

        @Test
        public void TratamientoRepository_findTratamientosByMascota_ListTratamientos() {
                // 1. Arrange:
                Mascota mascota = new Mascota("Benny", "Boston Terrier", 10, 29.0f, "Parvovirus canino",
                                "path/to/image98");
                mascotaRepository.save(mascota); // Save the Mascota entity first

                Tratamiento tratamiento1 = new Tratamiento(1L, "Tratamiento 1", "Descripción del tratamiento",
                                LocalDate.now().minusMonths(1), LocalDate.now(), 100000,
                                "Frecuencia del tratamiento 1");
                tratamiento1.setMascota(mascota);

                Tratamiento tratamiento2 = new Tratamiento(2L, "Tratamiento 2", "Descripción del tratamiento",
                                LocalDate.now().minusMonths(2), LocalDate.now(), 100000,
                                "Frecuencia del tratamiento 2");
                tratamiento2.setMascota(mascota);

                tratamientoRepository.save(tratamiento1);
                tratamientoRepository.save(tratamiento2);

                // 2. Act:
                List<Tratamiento> tratamientos = tratamientoRepository.findTratamientosByMascota(mascota);

                // 3. Assert:
                try {
                        Assertions.assertThat(tratamientos).hasSize(2);
                        logger.info(() -> "Tratamientos de la mascota " + mascota.getNombre() + ": " + tratamientos);
                } catch (AssertionError e) {
                        logger.error(() -> "Error en la prueba de encontrar tratamientos por mascota");
                        throw e; // Re-throw the error to make the test fail in a test environment
                }
        }

        @Test
        public void TratamientoRepository_FindTop3Treatments_ListObjectArray() {
                // 1. Arrange:
                Medicamento medicamento1 = new Medicamento("Medicamento 1", 2f, 5000, 10000, 100);
                medicamentoRepository.save(medicamento1);

                Tratamiento tratamiento1 = new Tratamiento("Tratamiento 1", "Descripción del tratamiento",
                                LocalDate.now().minusMonths(1), LocalDate.now(), 100000,
                                "Frecuencia del tratamiento 1");
                tratamiento1.setMedicamento(medicamento1);
                tratamientoRepository.save(tratamiento1);

                Medicamento medicamento2 = new Medicamento("Medicamento 2", 3f, 10000, 20000, 200);
                medicamentoRepository.save(medicamento2);

                Tratamiento tratamiento2 = new Tratamiento("Tratamiento 2", "Descripción del tratamiento",
                                LocalDate.now().minusMonths(2), LocalDate.now(), 100000,
                                "Frecuencia del tratamiento 2");
                tratamiento2.setMedicamento(medicamento2);
                tratamientoRepository.save(tratamiento2);

                Medicamento medicamento3 = new Medicamento("Medicamento 3", 4f, 15000, 30000, 300);
                medicamentoRepository.save(medicamento3);

                Tratamiento tratamiento3 = new Tratamiento("Tratamiento 3", "Descripción del tratamiento",
                                LocalDate.now().minusMonths(3), LocalDate.now(), 100000,
                                "Frecuencia del tratamiento 3");
                tratamiento3.setMedicamento(medicamento3);
                tratamientoRepository.save(tratamiento3);

                Medicamento medicamento4 = new Medicamento("Medicamento 4", 4f, 15000, 30000, 400);
                medicamentoRepository.save(medicamento4);
                tratamiento3.setMedicamento(medicamento4);

                // Repeat the same process for other Tratamiento entities if needed...

                // 2. Act:
                List<Object[]> top3Treatments = tratamientoRepository.findTop3Treatments();

                // 3. Assert:
                Assertions.assertThat(top3Treatments).hasSize(3);

                 Assertions.assertThat(top3Treatments.get(0)).containsExactly("Medicamento 4",
                 400);
                Assertions.assertThat(top3Treatments.get(1)).containsExactly("Medicamento 2",
                200);
                Assertions.assertThat(top3Treatments.get(2)).containsExactly("Medicamento 1",
                 100);
        }

}