package com.javeriana.drpaws.proyecto.servicio.Veterinario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javeriana.drpaws.proyecto.DTO.InputDTO.CredencialesDTO;
import com.javeriana.drpaws.proyecto.entidad.UserEntity;
import com.javeriana.drpaws.proyecto.entidad.Veterinario;
import com.javeriana.drpaws.proyecto.repositorio.UserRepository;
import com.javeriana.drpaws.proyecto.repositorio.VeterinarioRepository;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {
    @Autowired
    VeterinarioRepository repo;

    @Autowired
    UserRepository userRepository; // Add UserRepository

    @Override
    public Veterinario searchById(Long id) {
        return repo.findById(id).get();

    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Veterinario veterinario) {
        repo.save(veterinario);

    }

    @Override
    public void add(Veterinario veterinario) {
        repo.save(veterinario);
    }

    // Busca un veterinario por su correo
    @Override
    public Veterinario searchByEmail(String email) {

        return repo.findByEmail(email);
    }

    // Autentica un veterinario por sus credenciales
    // Las credenciales del veterinario son su correo y contraseña
    // Si exitosa, se devuelve un veterinario
    @Override
    public Veterinario autenticarVeterinario(CredencialesDTO credenciales) {
        String correo = credenciales.getCorreo();
        String contrasena = credenciales.getPassword();

        Veterinario veterinario = repo.findByEmail(correo);
        System.out.println("Se encontro");
        System.out.println("Correo del :" + veterinario.getEmail());
        System.out.println("Contraseña " + veterinario.getPassword());
        System.out.println(veterinario.toString());

        if (veterinario != null && veterinario.getPassword().equals(contrasena)) {
            System.out.println("HOLA");
            return veterinario;

        } else {
            System.out.println("hola 2");
            return new Veterinario();

        }

    }

    @Override
    public List<Veterinario> searchAll() {
        return repo.findAll();

    }

    // Devuelve la cantidad de veterinarios activos en el sistema
    public Long obtenerCantidadVeterinariosActivos() {
        return repo.countVeterinariosActivos();
    }

    // Devuleve la cantidad de veterinarios inactivos en el sistema
    @Override
    public Long obtenerCantidadVeterinariosInactivos() {
        // cambiarEstadoVeterinarios(); // Funcion de prueba para verificar que se
        // contaban los veterinarios inactivos del sistema
        return repo.countVeterinariosInactivos();
    }

    public void cambiarEstadoVeterinarios() {
        List<Veterinario> veterinarios = repo.findAll();
        for (int i = 0; i < 3 && i < veterinarios.size(); i++) {
            Veterinario veterinario = veterinarios.get(i);
            veterinario.setActivo(false);
            repo.save(veterinario);
        }
    }

}
