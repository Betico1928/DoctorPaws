package com.javeriana.drpaws.proyecto.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Consulta personalizada
    // Devuelve todas las mascotas asociadas a un usuario por su id
    @Query("SELECT m FROM Mascota m WHERE m.usuario.id = :id")
    List<Mascota> findMascotasById(@Param("id") Long id);

    public Usuario findByCorreo(String correo);

    public Usuario findByCedula(String cedula);

    Usuario findByCorreoAndContrasenna(String correo, String contrasenna);
}
