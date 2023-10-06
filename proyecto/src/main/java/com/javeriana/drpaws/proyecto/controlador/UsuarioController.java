package com.javeriana.drpaws.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    // http://localhost:8080/usuario/all -> Vista de todos los usuarios
    @GetMapping("/all")
    public List<Usuario> getAllUsuarios() {

        return usuarioService.searchAll();
    }

    // http://localhost:8080/usuario/find/1 -> Vista de un usuario en específico
    @GetMapping("/find/{id}")
    public Usuario getUsuario(@PathVariable("id") Long id) {
        return usuarioService.searchById(id);

    }

    @GetMapping("/find/{id}/mascotas")
    public List<Mascota> getMascotasByUsuarioID(@PathVariable("id") Long id) {
        return usuarioService.getMascotasByUsuarioID(id);
    }

    // http://localhost:8080/usuario/add -> Vista del formulario para crear un
    // usuario

    // http://localhost:8080/usuario/agregar -> Agregar un usuario
    @PostMapping("/add")
    public void agregarUsuario(@RequestBody Usuario usuario) {
        usuarioService.add(usuario);

    }

    // http://localhost:8080/usuario/delete/1 -> Eliminar un usuario
    @DeleteMapping("/delete/{id}")
    public void deleteUsuario(@PathVariable("id") Long id) {
        usuarioService.deleteById(id);

    }

    // http://localhost:8080/usuario/update/1 -> Vista del formulario para
    // actualizar un usuario

    // http://localhost:8080/usuario/actualizar/1 -> Actualizar un usuario
    @PostMapping("/update/{id}")
    public void updateUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {

        usuarioService.update(usuario);

    }
}
