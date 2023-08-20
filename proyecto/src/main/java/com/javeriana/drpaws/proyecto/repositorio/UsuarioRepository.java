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

    public UsuarioRepository()
    {
        usuarios.put(1234, new Usuario(1234, List.of(new Mascota("Luna", "Pitbull", 1, 20.5f, "Gastronomia"))));
        usuarios.put(5678, new Usuario(5678, List.of(new Mascota("Guaracha", "Golden", 5, 36.5f, "Goofines"))));
        usuarios.put(9012, new Usuario(9012, List.of(new Mascota("Jill", "Bull Terrier", 7, 30.5f, "Escoliosis Multiple"))));
        usuarios.put(3456, new Usuario(3456, List.of(new Mascota("Lola", "Chihuahua", 2, 6.5f, "Posesion Satanica"))));
    }

    public Usuario findById(int id)
    {
        return usuarios.get(id);
    }
}
