package com.javeriana.drpaws.proyecto.servicio.Tratamiento;

import com.javeriana.drpaws.proyecto.entidad.Tratamiento;

public interface TratamientoService {
    public Tratamiento searchById(Long id);

    public void deleteById(Long id);

    public void update(Tratamiento tratamiento);

    public void add(Tratamiento tratamiento);

}
