package com.javeriana.drpaws.proyecto.repositorio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.Usuario;

@Repository
public class UsuarioRepository {

    private Map<Integer, Usuario> usuarios = new HashMap<>();

    public UsuarioRepository() {
        usuarios.put(1,new Usuario(1,"Alejandro Sanz", "alejandro-sanz@gmail.com","+34 612-34-56-78","contraseña", new ArrayList<>(List.of(1,2)),"alejandro_sanz.jpg"));
                    usuarios.put(2,new Usuario(2,"Adele Laurie Blue Adkins", "adele@gmail.com","+44 2071-234-567","contraseña", new ArrayList<>(
            List.of(2,3)),"adele.jpg"));
                    usuarios.put(3,new Usuario(3,"Daft Punk", "daft-punk-jeje@gmail.com","+33 1-23-45-67-89","contraseña", new ArrayList<>(
            List.of(4,1)),"daft_punk.jpg"));
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

    public Collection<Usuario> findAll() {
        return usuarios.values();
    }

    public Collection<Mascota> findMascotas(Collection<Mascota> mascotas, Integer uid){
       Usuario usuario = usuarios.get(uid);
       ArrayList<Mascota> myPets = new ArrayList<>();
       for(Mascota mascota : mascotas){
        if(usuario.getMascotas().contains(mascota.getId())){
            myPets.add(mascota);
        }
       }

       return myPets;
    }

}
