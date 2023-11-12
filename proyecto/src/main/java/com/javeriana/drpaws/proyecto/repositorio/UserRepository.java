package com.javeriana.drpaws.proyecto.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javeriana.drpaws.proyecto.entidad.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);

}
