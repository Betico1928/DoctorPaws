package com.javeriana.drpaws.proyecto.servicio.Usuario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javeriana.drpaws.proyecto.controlador.DTO.CedulaDTO;
import com.javeriana.drpaws.proyecto.controlador.DTO.CredencialesDTO;
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
    public List<Usuario> searchAll() {
        return repo.findAll();

    }

    @Override
    public List<Mascota> getMascotasByUsuarioID(Long id) {
        return repo.findMascotasById(id);
    }

    @Override
    public Usuario findByCorreo(String correo) {
        return repo.findByCorreo(correo);
    }

    @Override
    public Usuario autenticarUsuario(CedulaDTO credenciales) {

        String cedula = credenciales.getCedula();

        Usuario usuario = repo.findByCedula(cedula);

        if (usuario != null) {
            return usuario; // Credenciales válidas, devuelve el usuario
        } else {
            return new Usuario(); // Credenciales inválidas, devuelve un usuario vacío
        }

    }

    // @Override
    // public Usuario autenticarUsuario(CredencialesDTO credenciales) {
    // String correo = credenciales.getCorreo();
    // String contrasena = credenciales.getContrasenna();

    // Usuario usuario = repo.findByCorreo(correo);

    // if (usuario != null && usuario.getContrasenna().equals(contrasena)) {
    // return usuario; // Credenciales válidas, devuelve el usuario
    // } else {
    // return new Usuario(); // Credenciales inválidas, devuelve un usuario vacío
    // }
    // }

}
