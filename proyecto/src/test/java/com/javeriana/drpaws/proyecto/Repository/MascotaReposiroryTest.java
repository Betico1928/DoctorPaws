package com.javeriana.drpaws.proyecto.Repository;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.repositorio.MascotaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class MascotaReposiroryTest
{
    @Autowired
    private MascotaRepository mascotaRepository;

    private Logger logger = LoggerFactory.getLogger(MascotaReposiroryTest.class);


    // Primera prueba: Contar mascotas activas:
    @Test
    public void MascotaRepository_testCountMascotasActivas_Long()
    {
        // 1. Arrange:
        Mascota mascota1 = new Mascota("Mascota 1", "Raza 1", 10, 23.3F, "Enfermedad 1", "path/to/image1");
        Mascota mascota2 = new Mascota("Mascota 2", "Raza 2", 10, 23.3F, "Enfermedad 2", "path/to/image2");

        mascotaRepository.save(mascota1);
        mascotaRepository.save(mascota2);

        logger.info(() -> "Mascota 1: " + mascota1.toString());
        logger.info(() -> "Mascota 2: " + mascota2.toString());

        // 2. Act:
        Long numeroMascotasActivas = mascotaRepository.countMascotasActivas();

        // 3. Assert:
        try
        {
            Assertions.assertThat(numeroMascotasActivas).isEqualTo(2);
            logger.info(() -> "Numero de mascotas activas: " + numeroMascotasActivas);
        }
        catch (AssertionError e) {
            logger.error(() -> "Error en la prueba de contar mascotas activas");
            throw e;  // Vuelve a lanzar el error para que el test falle si estás en un entorno de pruebas
        }
    }
}
