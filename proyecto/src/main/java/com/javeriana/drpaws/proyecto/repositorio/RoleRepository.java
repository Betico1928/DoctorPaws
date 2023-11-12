package com.javeriana.drpaws.proyecto.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javeriana.drpaws.proyecto.entidad.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{
    Optional<Role> findByName(String name);
}
