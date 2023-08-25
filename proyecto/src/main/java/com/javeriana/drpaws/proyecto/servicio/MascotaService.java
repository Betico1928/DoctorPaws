package com.javeriana.drpaws.proyecto.servicio;

import java.util.Collection;

import com.javeriana.drpaws.proyecto.entidad.Mascota;

public interface MascotaService {

    public Mascota searchById(int id);

    public Collection<Mascota> searchAll();

    public void deleteById(int id);

    public void update(Mascota mascota);

    public void add(Mascota mascota);

}
