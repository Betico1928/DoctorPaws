package com.javeriana.drpaws.proyecto.servicio.Mascota;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.Tratamiento;
import com.javeriana.drpaws.proyecto.repositorio.MascotaRepository;
import com.javeriana.drpaws.proyecto.repositorio.TratamientoRepository;

@Service
public class MascotaServiceImpl implements com.javeriana.drpaws.proyecto.servicio.Mascota.MascotaService {

    @Autowired
    MascotaRepository repo;

    @Autowired
    TratamientoRepository tratamientoRepository;

    @Override
    public Mascota searchById(Long id) {
        return repo.findById(id).get();

    }

    @Override
    public List<Mascota> searchAll() {
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

    @Override
    public Long totalMascotas() {
        return repo.count();
    }

    @Override
    public Long totalMascotasActivas() {
        desactivarMascotasSinTratamiento();
        return repo.countMascotasActivas();
    }

    public void desactivarMascotasSinTratamiento() {
        List<Mascota> mascotas = repo.findAll();

        for (Mascota mascota : mascotas) {
            List<Tratamiento> tratamientos = tratamientoRepository.findTratamientosByMascota(mascota);

            if (tratamientos.isEmpty()) {
                mascota.setActivo(false);
                repo.save(mascota);
            }
        }
    }
}
