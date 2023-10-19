package com.javeriana.drpaws.proyecto.Repository;

import com.javeriana.drpaws.proyecto.entidad.Usuario;
import com.javeriana.drpaws.proyecto.repositorio.MascotaRepository;
import com.javeriana.drpaws.proyecto.repositorio.UsuarioRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UsuarioRepositoryTest
{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    // Primera prueba:
    @Test
    public void UsuarioRepositor_testFindByCorreo_Usuario()
    {
        // 1. Arrange:
        Usuario usuarioABuscar = new Usuario("111111179", "Luisa Gomez", "luisa-gomez@gmail.com", "+57 578 876 8309", "password80", "path/to/imageuser80");

        // 2. Act:
        Usuario usuarioBuscado = usuarioRepository.save(usuarioABuscar);

        // 3. Assert:
        Assertions.assertThat(usuarioRepository.findByCorreo(usuarioBuscado.getCorreo())).isEqualTo(usuarioBuscado);
    }
}
