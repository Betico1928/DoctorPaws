package com.javeriana.drpaws.proyecto.repositorio;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.Usuario;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DataBaseInit implements ApplicationRunner {

    @Autowired
    MascotaRepository repoMascota;

    @Autowired
    UsuarioRepository repoUsuario;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // usuarios
        repoUsuario.save(
                new Usuario("123", "admin", "admin@admin.com", "3161234567", "password", "path/to/imageadmin"));
        repoUsuario.save(
                new Usuario("456", "user", "user@suemail.com", "3161232567", "password1", "path/to/imageuser"));
        repoUsuario.save(new Usuario("789", "user2", "user2@axdxd.com", "311231234567", "password2",
                "path/to/imageuser2"));
        repoUsuario.save(
                new Usuario("321", "user3", "user3@aaa.com", "3161234567", "password3", "path/to/imageuser3"));

        // mascotas

        repoMascota.save(new Mascota("firulais", "Bull Terrier", 4, 6.8f, "Escoliosis", "path/to/image"));
        repoMascota.save(new Mascota("firulais2", "Lindo", 4, 6.8f, "Tristesa", "path/to/image"));
        repoMascota.save(new Mascota("firulais3", "COOl Terrier", 4, 6.8f, "Locura", "path/to/image"));
        repoMascota.save(new Mascota("firulais4", " Terrier", 4, 6.8f, "Aneurismas", "path/to/image"));
        repoMascota.save(new Mascota("firulais11", "Bull Terrier", 4, 6.8f, "Escoliosis", "path/to/image"));
        repoMascota.save(new Mascota("firulais22", "Lindo", 4, 6.8f, "Tristesa", "path/to/image"));
        repoMascota.save(new Mascota("firulais33", "COOl Terrier", 4, 6.8f, "Locura", "path/to/image"));
        repoMascota.save(new Mascota("firulais44", " Terrier", 4, 6.8f, "Aneurismas", "path/to/image"));

        // Retrieve all Usuario objects
        List<Usuario> usuarios = repoUsuario.findAll();

        // Retrieve all Mascota objects
        List<Mascota> mascotas = repoMascota.findAll();

        // Shuffle the list of Mascota objects to randomize their order
        Collections.shuffle(mascotas);

        // Iterate through Usuario objects
        for (Usuario usuario : usuarios) {
            // Take the first two Mascota objects from the shuffled list
            if (mascotas.size() >= 2) {
                Mascota mascota1 = mascotas.remove(0);
                Mascota mascota2 = mascotas.remove(0);

                // Store the Usuario reference in the Mascota objects
                mascota1.setUsuario(usuario);
                mascota2.setUsuario(usuario);

                // Save the updated Mascota objects
                repoMascota.save(mascota1);
                repoMascota.save(mascota2);

            } else {
                System.out.println("Not enough mascotas to associate with usuarios.");
                break;
            }
        }

    }

}
