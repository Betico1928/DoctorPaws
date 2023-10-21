package com.javeriana.drpaws.proyecto.servicio.Mascota;

import java.util.Collection;

import com.javeriana.drpaws.proyecto.entidad.Mascota;

public interface MascotaService {

    public Mascota searchById(Long id);

    public Collection<Mascota> searchAll();

    public void deleteById(Long id);

    public void update(Mascota mascota);

    public void add(Mascota mascota);

}
