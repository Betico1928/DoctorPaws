package com.javeriana.drpaws.proyecto.servicio.Veterinario;

import org.springframework.beans.factory.annotation.Autowired;

import com.javeriana.drpaws.proyecto.entidad.Veterinario;
import com.javeriana.drpaws.proyecto.repositorio.VeterinarioRepository;

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

}
