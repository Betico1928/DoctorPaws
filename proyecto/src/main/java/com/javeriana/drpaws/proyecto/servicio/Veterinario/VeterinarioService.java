package com.javeriana.drpaws.proyecto.servicio.Veterinario;

import java.util.List;

import com.javeriana.drpaws.proyecto.DTO.InputDTO.CredencialesDTO;
import com.javeriana.drpaws.proyecto.entidad.Veterinario;

public interface VeterinarioService {

    // Devuelve un veterinario dado su id
    public Veterinario searchById(Long id);

    // Devuelve todos los veterinarios del sistema
    public List<Veterinario> searchAll();

    // Remueve un veterinario dado su id
    public void deleteById(Long id);

    // Actualiza un veterinario
    public void update(Veterinario veterinario);

    // Agrega un veterinario al sistema
    public void add(Veterinario veterinario);

    // Se busca un veterinario por su correo electrónico
    public Veterinario searchByEmail(String email);

    // Se devuelve un veterinario asociado a las credenciales
    // enviadas que contiene su correo y contraseña
    public Veterinario autenticarVeterinario(CredencialesDTO credenciales);

    // Devuelve la cantidad de veterinarios activos en el sistema
    public Long obtenerCantidadVeterinariosActivos();

    // Devuelve la cantidad de veterinarios inactivos en el sistema
    public Long obtenerCantidadVeterinariosInactivos();

}
