package com.javeriana.drpaws.proyecto.servicio.Mascota;

import java.util.List;

import com.javeriana.drpaws.proyecto.entidad.Mascota;

public interface MascotaService {

    public Mascota searchById(Long id);

    public List<Mascota> searchAll();

    public void deleteById(Long id);

    public void update(Mascota mascota);

    public void add(Mascota mascota);

    public Long totalMascotas();

    public Long totalMascotasActivas();

}
