package com.javeriana.drpaws.proyecto.servicio.Usuario;

import java.util.List;

import com.javeriana.drpaws.proyecto.DTO.InputDTO.CedulaDTO;
import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.Usuario;

public interface UsuarioService {
    // Retorna un usuario dado su id
    public Usuario searchById(Long id);

    // Retorna la lista de usuarios del sistema
    public List<Usuario> searchAll();

    // Elimina un usuario dado su id
    public void deleteById(Long id);

    // Actualiza un usuario
    public void update(Usuario usuario);

    // Agrega un usuario al sistema
    public void add(Usuario usuario);

    // Obtiene las mascotas asociadas a un usuario dado su id
    public List<Mascota> getMascotasByUsuarioID(Long id);

    // Encuentra el usuario dado su correo
    public Usuario findByCorreo(String correo);

    // Autentica un usuario dado sus credenciales
    public Usuario autenticarUsuario(CedulaDTO credenciales);
}
