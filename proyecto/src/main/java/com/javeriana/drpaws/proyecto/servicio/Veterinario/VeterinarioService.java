package com.javeriana.drpaws.proyecto.servicio.Veterinario;

import com.javeriana.drpaws.proyecto.entidad.Veterinario;

public interface VeterinarioService {
    public Veterinario searchById(Long id);

    public void deleteById(Long id);

    public void update(Veterinario veterinario);

    public void add(Veterinario veterinario);

}
