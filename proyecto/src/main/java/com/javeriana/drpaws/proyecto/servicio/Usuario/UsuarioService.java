package com.javeriana.drpaws.proyecto.servicio.Usuario;

import java.util.Collection;

import com.javeriana.drpaws.proyecto.entidad.Usuario;

public interface UsuarioService {
    public Usuario searchById(int id);

    public Collection<Usuario> searchAll();

    public void deleteById(int id);

    public void update(Usuario usuario);

    public void add(Usuario usuario);
}
