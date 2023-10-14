package com.javeriana.drpaws.proyecto.servicio.Veterinario;

import java.util.List;

import com.javeriana.drpaws.proyecto.controlador.DTO.CredencialesDTO;
import com.javeriana.drpaws.proyecto.entidad.Veterinario;

public interface VeterinarioService {
    public Veterinario searchById(Long id);

    public List<Veterinario> searchAll();

    public void deleteById(Long id);

    public void update(Veterinario veterinario);

    public void add(Veterinario veterinario);

    public Veterinario searchByEmail(String email);

    public Veterinario autenticarVeterinario(CredencialesDTO credenciales);

    public Long obtenerCantidadVeterinariosActivos();

    public Long obtenerCantidadVeterinariosInactivos();

}
