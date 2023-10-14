package com.javeriana.drpaws.proyecto.servicio.Veterinario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javeriana.drpaws.proyecto.controlador.DTO.CredencialesDTO;
import com.javeriana.drpaws.proyecto.entidad.Veterinario;
import com.javeriana.drpaws.proyecto.repositorio.VeterinarioRepository;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {
    @Autowired
    VeterinarioRepository repo;

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

    @Override
    public Veterinario searchByEmail(String email) {

        return repo.findByEmail(email);
    }

    @Override
    public Veterinario autenticarVeterinario(CredencialesDTO credenciales) {
        String correo = credenciales.getCorreo();
        String contrasena = credenciales.getContrasenna();

        Veterinario veterinario = repo.findByEmail(correo);
        System.out.println(veterinario);

        if (veterinario != null && veterinario.getPassword().equals(contrasena)) {
            return veterinario;

        } else {
            return new Veterinario();

        }

    }

    @Override
    public List<Veterinario> searchAll() {
        return repo.findAll();

    }

    public Long obtenerCantidadVeterinariosActivos() {
        return repo.countVeterinariosActivos();
    }

    @Override
    public Long obtenerCantidadVeterinariosInactivos() {
        cambiarEstadoVeterinarios();

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
