package com.javeriana.drpaws.proyecto.servicio.Mascota;

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
    public Mascota searchById(int id) {
        return repo.findById(id);

    }

    @Override
    public Collection<Mascota> searchAll() {
        return repo.findAll();

    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);

    }

    @Override
    public void update(Mascota mascota) {
        repo.updatebyId(mascota);

    }

    @Override
    public void add(Mascota mascota) {
        repo.add(mascota);
    }

}
