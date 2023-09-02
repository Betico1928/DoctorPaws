package com.javeriana.drpaws.proyecto.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Mascota> findMascotasById(Long Long);

}
