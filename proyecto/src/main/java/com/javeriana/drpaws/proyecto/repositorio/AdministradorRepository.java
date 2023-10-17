package com.javeriana.drpaws.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javeriana.drpaws.proyecto.entidad.Administrador;
import com.javeriana.drpaws.proyecto.entidad.Veterinario;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    Administrador findByEmail(String email);

}
