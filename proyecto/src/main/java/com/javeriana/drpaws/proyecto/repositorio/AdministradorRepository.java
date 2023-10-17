package com.javeriana.drpaws.proyecto.repositorio;

import com.javeriana.drpaws.proyecto.entidad.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    Administrador findByEmail(String email);

}
