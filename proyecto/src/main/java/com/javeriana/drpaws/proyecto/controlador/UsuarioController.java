package com.javeriana.drpaws.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javeriana.drpaws.proyecto.DTO.Usuario.UsuDTO;
import com.javeriana.drpaws.proyecto.DTO.Usuario.UsuMapper;
import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.UserEntity;
import com.javeriana.drpaws.proyecto.entidad.Usuario;
import com.javeriana.drpaws.proyecto.repositorio.UserRepository;
import com.javeriana.drpaws.proyecto.security.CustomUserDetailsService;
import com.javeriana.drpaws.proyecto.servicio.Usuario.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

     @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

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
    public ResponseEntity agregarUsuario(@RequestBody Usuario usuario) {
        if(userRepository.existsByUsername(usuario.getCedula())){
            return new ResponseEntity<String>("Ya existe el usuario", HttpStatus.BAD_REQUEST);
        }
        UserEntity userEntity = customUserDetailsService.saveUsuario(usuario);
        // Se le asigna el rol de veterinario al nuevo veterinario creado
        usuario.setUser(userEntity);
        usuarioService.add(usuario);

        return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);


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

    // Autentica a un usuario con el JWT
    @GetMapping("/details")
    public ResponseEntity<UsuDTO> buscarEstudiante(){
        // Se asume que un usuario que llega a esta URL ya está autenticado

        Usuario usuario = usuarioService.searchByCedula(
            SecurityContextHolder.getContext().getAuthentication().getName()
        );

        UsuDTO usuDTO = UsuMapper.INSTANCE.convert(usuario);


        if(usuario == null){
            return new ResponseEntity<UsuDTO>(new UsuDTO(), HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<UsuDTO>(usuDTO, HttpStatus.OK);
        }

    }

}
