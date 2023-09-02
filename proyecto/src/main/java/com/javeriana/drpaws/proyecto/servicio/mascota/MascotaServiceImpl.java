package com.javeriana.drpaws.proyecto.servicio.mascota;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.repositorio.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService {

    @Autowired
    MascotaRepository repo;

    @Override
    public Mascota searchById(Long id) {
        return repo.findById(id).get();

    }

    @Override
    public Collection<Mascota> searchAll() {
        return repo.findAll();

    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);

    }

    @Override
    public void update(Mascota mascota) {
        repo.save(mascota);

    }

    @Override
    public void add(Mascota mascota) {
        repo.save(mascota);
    }

}
