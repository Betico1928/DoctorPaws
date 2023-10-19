package com.javeriana.drpaws.proyecto.Repository;

import com.javeriana.drpaws.proyecto.entidad.Usuario;
import com.javeriana.drpaws.proyecto.repositorio.MascotaRepository;
import com.javeriana.drpaws.proyecto.repositorio.UsuarioRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UsuarioRepositoryTest {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    private Logger logger = LoggerFactory.getLogger(UsuarioRepositoryTest.class);

    // Primera prueba: Buscar por correo:
    @Test
    public void UsuarioRepository_testFindByCorreo_Usuario()
    {
        // 1. Arrange:
        Usuario usuarioABuscarPorCorreo = new Usuario("1193215807", "Alberto Vigna", "a-vigna@javeriana.edu.co", "+57 318 523 4355", "passwordJeje", "path/to/imageuser80");
        logger.info(() -> "Usuario a buscar: " + usuarioABuscarPorCorreo.toString());

        // 2. Act:
        Usuario usuarioBuscadoPorCorreo = usuarioRepository.save(usuarioABuscarPorCorreo);

        // 3. Assert:
        try
        {
            Assertions.assertThat(usuarioRepository.findByCorreo(usuarioBuscadoPorCorreo.getCorreo())).isEqualTo(usuarioBuscadoPorCorreo);
            logger.info(() -> "Prueba de buscar a un usuario por correo exitosa");
        }
        catch (AssertionError e) {
            logger.error(() -> "Error en la prueba de buscar a un usuario por correo");
            throw e;  // Vuelve a lanzar el error para que el test falle si estás en un entorno de pruebas
        }
    }


    // Segunda prueba: Buscar por cedula:
    @Test
    public void UsuarioRepository_testFindByCedula_Usuario()
    {
        // 1. Arrange:
        Usuario usuarioABuscarPorCedula = new Usuario("1193215807", "Alberto Vigna", "a-vigna@javeriana.edu.co", "+57 318 523 4355", "passwordJeje", "path/to/imageuser80");
        logger.info(() -> "Usuario a buscar: " + usuarioABuscarPorCedula.toString());

        // 2. Act:
        Usuario usuarioBuscadoPorCedula = usuarioRepository.save(usuarioABuscarPorCedula);

        // 3. Assert:
        try
        {
            Assertions.assertThat(usuarioRepository.findByCedula(usuarioBuscadoPorCedula.getCedula())).isEqualTo(usuarioBuscadoPorCedula);
            logger.info(() -> "Prueba de buscar a un usuario por cedula exitosa");
        }
        catch (AssertionError e) {
            logger.error(() -> "Error en la prueba de buscar a un usuario por cedula");
            throw e;  // Vuelve a lanzar el error para que el test falle si estás en un entorno de pruebas
        }
    }


    // Tercera prueba: Buscar por correo y contrasenna:
    @Test
    public void UsuarioRepository_testFindByCorreoAndContrasenna_Usuario()
    {
        // 1. Arrange:
        Usuario usuarioABuscarPorCorreoYContrasenna = new Usuario("1193215807", "Alberto Vigna", "a-vigna@javeriana.edu.co", "+57 318 523 4355", "passwordJeje", "path/to/imageuser80");
        logger.info(() -> "Usuario a buscar: " + usuarioABuscarPorCorreoYContrasenna.toString());

        // 2. Act:
        Usuario usuarioBuscadoPorCorreoYContrasenna = usuarioRepository.save(usuarioABuscarPorCorreoYContrasenna);

        // 3. Assert:
        try
        {
            Assertions.assertThat(usuarioRepository.findByCorreoAndContrasenna(usuarioBuscadoPorCorreoYContrasenna.getCorreo(), usuarioBuscadoPorCorreoYContrasenna.getContrasenna())).isEqualTo(usuarioBuscadoPorCorreoYContrasenna);
            logger.info(() -> "Prueba de buscar a un usuario por correo y contrasenna exitosa");
        }
        catch (AssertionError e) {
            logger.error(() -> "Error en la prueba de buscar a un usuario por correo y contrasenna");
            throw e;  // Vuelve a lanzar el error para que el test falle si estás en un entorno de pruebas
        }
    }
}

