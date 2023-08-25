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
        mascotas.put(1, new Mascota(1, "Luna", "Pitbull", 1, 20.5f, "Gastronomia",
                "src\\main\\resources\\static\\images\\samoyed.jpg"));
        mascotas.put(2, new Mascota(2, "Guaracha", "Golden", 5, 36.5f, "Goofines",
                "src\\main\\resources\\static\\images\\samoyed.jpg"));
        mascotas.put(3, new Mascota(3, "Jill", "Bull Terrier", 7, 30.5f, "Escoliosis Multiple",
                "src\\main\\resources\\static\\images\\samoyed.jpg"));
        mascotas.put(4, new Mascota(4, "Lola", "Chihuahua", 2, 6.5f, "Posesion Satanica",
                "src\\main\\resources\\static\\images\\samoyed.jpg"));

    }

    public Mascota findById(int id) {
        return mascotas.get(id);

    }

    public Collection<Mascota> findAll() {
        return mascotas.values();

    }

    public void deleteById(int id) {
        mascotas.remove(id);
    }

    public void updatebyId(Mascota mascota) {
        mascotas.put(mascota.getId(), mascota);
    }

    public void add(Mascota mascota) {
        int tam = mascotas.size();
        int lastId = mascotas.get(tam).getId();
        mascota.setId(lastId + 1);
        mascotas.put(lastId + 1, mascota);

    }

}
