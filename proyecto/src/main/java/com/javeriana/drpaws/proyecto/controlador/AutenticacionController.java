package com.javeriana.drpaws.proyecto.controlador;

import com.javeriana.drpaws.proyecto.DTO.InputDTO.CedulaDTO;
import com.javeriana.drpaws.proyecto.DTO.InputDTO.CredencialesDTO;
import com.javeriana.drpaws.proyecto.DTO.Usuario.UsuDTO;
import com.javeriana.drpaws.proyecto.DTO.Usuario.UsuMapper;
import com.javeriana.drpaws.proyecto.DTO.Veterinario.VetDTO;
import com.javeriana.drpaws.proyecto.DTO.Veterinario.VetMapper;
import com.javeriana.drpaws.proyecto.entidad.Administrador;
import com.javeriana.drpaws.proyecto.entidad.Usuario;
import com.javeriana.drpaws.proyecto.entidad.Veterinario;
import com.javeriana.drpaws.proyecto.servicio.Administrador.AdministradorService;
import com.javeriana.drpaws.proyecto.servicio.Usuario.UsuarioService;
import com.javeriana.drpaws.proyecto.servicio.Veterinario.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autenticacion")
@CrossOrigin(origins = "http://localhost:4200")
public class AutenticacionController {

    /*
     * Servicio de usuario
     */
    @Autowired
    UsuarioService usuarioService;

    /*
     *  Servicio de veterinario
     */
    @Autowired
    VeterinarioService veterinarioService;

    @Autowired
    AdministradorService administradorService;

    // http://localhost:8080/autenticacion/user -> Autenticar un usuario
    @PostMapping("/user")
    public ResponseEntity<Object> autenticarUser(@RequestBody CedulaDTO credenciales) {
        System.out.println("Cedula recibida para autenticación:" + credenciales.getCedula());
        Usuario usuarioAutenticado = usuarioService.autenticarUsuario(credenciales);
        UsuDTO usuDTO = UsuMapper.INSTANCE.convert(usuarioAutenticado);

        if (usuarioAutenticado.getId() != null) {
            return ResponseEntity.ok(usuDTO); // Credenciales válidas
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas"); // Credenciales
                                                                                                    // inválidas
        }
    }

    // http://localhost:8080/autenticacion/vet -> Autenticar un veterinario
    @PostMapping("/vet")
    public ResponseEntity<Object> autenticarVet(@RequestBody CredencialesDTO credenciales) {

        System.out.println("Correo: " + credenciales.getCorreo()+ "Contraseña: " + credenciales.getContrasenna());
        Veterinario veterinarioAutenticado = veterinarioService.autenticarVeterinario(credenciales);
        System.out.println("Nombre" +veterinarioAutenticado.getNombre());
        VetDTO vetDTO = VetMapper.INSTANCE.convert(veterinarioAutenticado);

        if (veterinarioAutenticado.getId() != null) {
            System.out.println("Credenciales válidas - Puede entrar el veterinario con ID: "
                    + veterinarioAutenticado.getId() + "\n");
            return ResponseEntity.ok(vetDTO); // Credenciales válidas
        } else {
            System.out.println("Credenciales Incorrectas");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas\n"); // Credenciales
                                                                                                      // inválidas
        }
    }

    // http://localhost:8080/autenticacion/admin -> Autenticar un administrador
    @PostMapping("/admin")
    public ResponseEntity<Object> autenticarAdmin(@RequestBody CredencialesDTO credenciales) {

        Administrador administradorAutenticado = administradorService.autenticarAdministrador(credenciales);

        if (administradorAutenticado.getId() != null) {
            System.out.println("Credenciales válidas - Puede entrar el administrador con ID: "
                    + administradorAutenticado.getId() + "\n");
            return ResponseEntity.ok(administradorAutenticado); // Credenciales válidas
        } else {
            System.out.println("Credenciales Incorrectas");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas\n"); // Credenciales
                                                                                                      // inválidas
        }
    }

}
