package com.javeriana.drpaws.proyecto.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javeriana.drpaws.proyecto.entidad.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {

}
