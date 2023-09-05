package com.javeriana.drpaws.proyecto.servicio.Usuario;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

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
    public Usuario searchById(Long id) {
        return repo.findById(id).get();

    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Usuario usuario) {
        repo.save(usuario);
    }

    @Override
    public void add(Usuario usuario) {
        repo.save(usuario);

    }

    @Override
    public Collection<Usuario> searchAll() {
        return repo.findAll();

    }

    @Override
    public List<Mascota> getMascotasByUsuarioID(Long id) {
        return repo.findMascotasById(id);
    }

}
