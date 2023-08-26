package com.javeriana.drpaws.proyecto.servicio.Usuario;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.Usuario;
import com.javeriana.drpaws.proyecto.repositorio.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UsuarioRepository repo;

    @Override
    public Usuario searchById(int id) {
        return repo.findById(id);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Usuario usuario) {
        repo.updatebyId(usuario);
    }

    @Override
    public void add(Usuario usuario) {
        repo.add(usuario);

    }

    @Override
    public Collection<Usuario> searchAll() {
        return repo.findAll();

    }
}
