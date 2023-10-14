package com.javeriana.drpaws.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javeriana.drpaws.proyecto.entidad.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
    public Veterinario findByEmail(String email);

    @Query("SELECT COUNT(v) FROM Veterinario v WHERE v.activo = true")
    Long countVeterinariosActivos();

    @Query("SELECT COUNT(v) FROM Veterinario v WHERE v.activo = false")
    Long countVeterinariosInactivos();

}
