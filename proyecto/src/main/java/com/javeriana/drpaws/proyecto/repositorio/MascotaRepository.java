package com.javeriana.drpaws.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javeriana.drpaws.proyecto.entidad.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {

}
