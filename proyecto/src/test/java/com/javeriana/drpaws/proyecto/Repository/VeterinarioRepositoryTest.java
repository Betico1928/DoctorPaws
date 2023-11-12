package com.javeriana.drpaws.proyecto.Repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.javeriana.drpaws.proyecto.entidad.Veterinario;
import com.javeriana.drpaws.proyecto.repositorio.VeterinarioRepository;

@DataJpaTest
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class VeterinarioRepositoryTest {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @BeforeEach
    public void setUp() {
        veterinarioRepository.deleteAll();
        // --- VETERINARIOS ---
        // Veterinario #1 - Dr. Juan Perez
        veterinarioRepository.save(new Veterinario("Cardiología", "Dr. Juan Perez", "perezj@email.com", "password1",
                "path/to/imagevet1"));

        // Veterinario #2 - Dra. Maria Rodriguez
        veterinarioRepository.save(new Veterinario("Cirugía", "Dra. Maria Rodriguez", "rodrim@email.com", "password2",
                "path/to/imagevet2"));

        // Veterinario #3 - Dr. Carlos Garcia
        veterinarioRepository.save(new Veterinario("Dermatología", "Dr. Carlos Garcia", "garciac@email.com",
                "password3", "path/to/imagevet3"));

        // Veterinario #4 - Dra. Laura Lopez
        veterinarioRepository.save(new Veterinario("Oftalmología", "Dra. Laura Lopez", "lopezl@email.com",
                "password4", "path/to/imagevet4"));

    }

    @Test
    public void VeterinarioRepository_save_Veterinario() {
        Veterinario veterinario = new Veterinario("Juan", "Cardiologia", "Juan@veterinario.com", "1234", "imagen");
        Veterinario savedVeterinario = veterinarioRepository.save(veterinario);

        Assertions.assertThat(savedVeterinario).isNotNull();

    }

    @Test
    public void VeterinarioRepository_FindAll_NotEmptyList() {
        Veterinario veterinario = new Veterinario("Juan", "Cardiologia", "Juan@veterinario.com", "1234", "imagen");
        Veterinario veterinario2 = new Veterinario("Juan2", "Cardiologia2", "Juan2@veterinario.com", "1233", "imagen2");

        veterinarioRepository.save(veterinario);
        veterinarioRepository.save(veterinario2);

        List<Veterinario> veterinarios = veterinarioRepository.findAll();

        Assertions.assertThat(veterinarios).isNotEmpty();
        Assertions.assertThat(veterinarios).hasSize(6);
        Assertions.assertThat(veterinarios).hasSizeGreaterThan(0);

    }

    @Test
    public void VeterinarioRepository_FindById_Veterinario() {

        Optional<Veterinario> optionalVeterinario = veterinarioRepository.findById(1L);

        Assertions.assertThat(optionalVeterinario).isPresent();
        System.out.println(optionalVeterinario.get().toString());

        if (optionalVeterinario.isPresent()) {
            Veterinario veterinarian = optionalVeterinario.get();
            Assertions.assertThat(veterinarian.getNombre()).isEqualTo("Dr. Juan Perez");
            Assertions.assertThat(veterinarian.getEspecialidad()).isEqualTo("Cardiología");
            Assertions.assertThat(veterinarian.getEmail()).isEqualTo("perezj@email.com");
            Assertions.assertThat(veterinarian.getPassword()).isEqualTo("password1");
            Assertions.assertThat(veterinarian.getImagen()).isEqualTo("path/to/imagevet1");
        }

    }

    @Test
    public void VeterinarioRepository_FindByEmail_Veterinario() {

        Assertions.assertThat(veterinarioRepository.findByEmail("perezj@email.com"))
                .isEqualTo(veterinarioRepository.findById(1L).get());

    }

    @Test
    public void VeterinarioRepository_FindById_WrongIndex() {

        Long wrongIndex = -100L;

        Assertions.assertThat(veterinarioRepository.findById(wrongIndex)).isEmpty();

    }

    @Test
    public void VeterinarioRepository_updateByEspecialidad_Veterinario() {
        Veterinario veterinario = veterinarioRepository.findById(1L).get();
        veterinario.setEspecialidad("MODIFICADO");
        veterinarioRepository.save(veterinario);
        Assertions.assertThat(veterinarioRepository.findById(1L).get().getEspecialidad()).isEqualTo("MODIFICADO");
    }

    @Test
    public void VeterinarioRepository_DeleteByID_EmptyVeterinario() {
        veterinarioRepository.deleteById(1L);
        Assertions.assertThat(veterinarioRepository.findById(1L)).isEmpty();
    }

}
