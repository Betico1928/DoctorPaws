package com.javeriana.drpaws.proyecto.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javeriana.drpaws.proyecto.entidad.Mascota;

@Repository
public class MascotaRepository {

    private Map<Integer, Mascota> mascotas = new HashMap<>();

    public MascotaRepository() {
        mascotas.put(1, new Mascota("Luna", "Pitbull", 1, 20.5f, "Gastronomia"));
        mascotas.put(2, new Mascota("Guaracha", "Golden", 5, 36.5f, "Goofines"));
        mascotas.put(3, new Mascota("Jill", "Bull Terrier", 7, 30.5f, "Escoliosis Multiple"));
        mascotas.put(4, new Mascota("Lola", "Chihuahua", 2, 6.5f, "Posesion Satanica"));

    }

    public Mascota findById(int id) {
        return mascotas.get(id);

    }

    public Collection<Mascota> findAll() {
        return mascotas.values();

    }

}
