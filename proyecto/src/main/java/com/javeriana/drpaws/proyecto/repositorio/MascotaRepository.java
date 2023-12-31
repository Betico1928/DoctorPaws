package com.javeriana.drpaws.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javeriana.drpaws.proyecto.entidad.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {


    // Consultas personalizadas para el repositorio Mascota
    // Devuelve la cantidad de mascotasactivas
    @Query("SELECT COUNT(m) FROM Mascota m WHERE m.activo = true")
    long countMascotasActivas();

    Mascota findByNombre(String nombre);
}
