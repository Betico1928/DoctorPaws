package com.javeriana.drpaws.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.Usuario;
import com.javeriana.drpaws.proyecto.servicio.Usuario.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    // Devuelve todos los usuarios
    // http://localhost:8080/usuario/all
    @GetMapping("/all")
    public List<Usuario> getAllUsuarios() {

        return usuarioService.searchAll();
    }

    // Devuelve el usuario buscado por su id
    // http://localhost:8080/usuario/find/1
    @GetMapping("/find/{id}")
    public Usuario getUsuario(@PathVariable("id") Long id) {
        return usuarioService.searchById(id);

    }

    // Devuelve las mascotas asociadas a un usuario por su id
    //  http://localhost:8080/usuario/find/1/mascotas
    @GetMapping("/find/{id}/mascotas")
    public List<Mascota> getMascotasByUsuarioID(@PathVariable("id") Long id) {
        return usuarioService.getMascotasByUsuarioID(id);
    }


    // Agrega un usuario al sistema
    // http://localhost:8080/usuario/add
    @PostMapping("/add")
    public void agregarUsuario(@RequestBody Usuario usuario) {
        usuarioService.add(usuario);

    }

    // Elimina a un usuario dado su id
    // http://localhost:8080/usuario/delete/id
    @DeleteMapping("/delete/{id}")
    public void deleteUsuario(@PathVariable("id") Long id) {
        usuarioService.deleteById(id);

    }


    // Actualiza a un usuario dado su id
    // http://localhost:8080/usuario/actualizar/id
    @PostMapping("/update/{id}")
    public void updateUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {

        usuarioService.update(usuario);

    }

}
