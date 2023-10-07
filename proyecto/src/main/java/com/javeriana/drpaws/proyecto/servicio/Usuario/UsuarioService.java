package com.javeriana.drpaws.proyecto.servicio.Usuario;

import java.util.List;

import com.javeriana.drpaws.proyecto.controlador.DTO.CredencialesDTO;
import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.Usuario;

public interface UsuarioService {
    public Usuario searchById(Long id);

    public List<Usuario> searchAll();

    public void deleteById(Long id);

    public void update(Usuario usuario);

    public void add(Usuario usuario);

    public List<Mascota> getMascotasByUsuarioID(Long id);

    public Usuario findByCorreo(String correo);

    public Usuario autenticarUsuario(CredencialesDTO credenciales);
}
