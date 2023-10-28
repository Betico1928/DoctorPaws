package com.javeriana.drpaws.proyecto.servicio.Mascota;

import java.util.List;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.Tratamiento;

public interface MascotaService {

    // Buscar una mascota por su ID
    public Mascota searchById(Long id);

    // Buscar todas las mascotas
    public List<Mascota> searchAll();

    // Eliminar una mascota por su ID
    public void deleteById(Long id);

    // Actualizar una mascota
    public void update(Mascota mascota, Long id);

    // Agregar una mascota
    public void add(Mascota mascota);

    // Devuelve la cantidad de mascotas totales en la veterinaria
    public Long totalMascotas();

    // Devuelve la cantidad de mascotas activas en la veterinaria
    public Long totalMascotasActivas();

    // Retorna la lista de tratamientos que tiene una mascota identificada por su id
    public List<Tratamiento> getTratamientosByNombreMascota(Long id);
}
