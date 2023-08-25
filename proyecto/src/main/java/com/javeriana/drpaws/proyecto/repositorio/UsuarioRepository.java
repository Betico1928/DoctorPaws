package com.javeriana.drpaws.proyecto.repositorio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
import org.springframework.stereotype.Repository;
import com.javeriana.drpaws.proyecto.entidad.Usuario;

@Repository
public class UsuarioRepository {

    private Map<Integer, Usuario> usuarios = new HashMap<>();

    public UsuarioRepository() {

        usuarios.put(1234,
                new Usuario(1234, "contraseña1234", "Especialidad1", "foto1", 5,
                        List.of(new Mascota(1, "Luna", "Pitbull", 1, 20.5f, "Gastritis", "samoyed"),
                                new Mascota(2, "Guaracha", "Golden", 5, 36.5f, "Rabia", "pug"))));

        usuarios.put(5678, new Usuario(5678, "contraseña5678", "Especialidad2", "foto2", 7,
                List.of(new Mascota(1, "Guaracha", "Golden", 5, 36.5f, "Rabia", "samoyed"),
                        new Mascota(2, "Jill", "Bull Terrier", 7, 30.5f, "Brucelosis", "pug"))));

        usuarios.put(9012,
                new Usuario(9012, "contraseña9012", "Especialidad3", "foto3", 3,
                        List.of(new Mascota(1, "Jill", "Bull Terrier", 7, 30.5f, "Brucelosis", "beagle"),
                                new Mascota(2, "Lola", "Chihuahua", 2, 6.5f, "Rabia", "shiba"))));

        usuarios.put(3456,
                new Usuario(3456, "contraseña3456", "Especialidad4", "foto4", 2,
                        List.of(new Mascota(1, "Lola", "Chihuahua", 2, 6.5f, "Moquillo", "shiba"),
                                new Mascota(2, "Guaracha", "Golden", 5, 36.5f, "Moquillo", "beagle"))));

    }

    public Usuario findById(int id) {
        return usuarios.get(id);
    }

    public void deleteById(int id) {
        usuarios.remove(id);
    }

    public void updatebyId(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }

    public void add(Usuario usuario) {
        int tam = usuarios.size();
        int lastId = usuarios.get(tam).getId();
        usuario.setId(lastId + 1);
        usuarios.put(lastId + 1, usuario);

    }

}
