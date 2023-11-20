package com.javeriana.drpaws.proyecto.controlador;

import com.javeriana.drpaws.proyecto.DTO.InputDTO.CredencialesDTO;
import com.javeriana.drpaws.proyecto.entidad.Administrador;
import com.javeriana.drpaws.proyecto.security.JWTGenerator;
import com.javeriana.drpaws.proyecto.servicio.Administrador.AdministradorService;
import com.javeriana.drpaws.proyecto.servicio.Usuario.UsuarioService;
import com.javeriana.drpaws.proyecto.servicio.Veterinario.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTGenerator jwtGenerator;

    // http://localhost:8080/autenticacion/user -> Autenticar un usuario
    @PostMapping("/user")
    public ResponseEntity autenticarUser(@RequestBody CredencialesDTO credenciales) {

        // Un objeto que guarda mis crendenciales
        // Método para autenticarme
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(credenciales.getCorreo(),"123")
        );

        // Guarda mi autenticación
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);
        System.out.println("Usuario Token"+token);

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    // http://localhost:8080/autenticacion/administrativo -> Autenticar un veterinario o administrador
    @PostMapping("/administrativo")
    public ResponseEntity autenticarAdministrativo(@RequestBody CredencialesDTO credenciales) {
        /**
         * ResponseEntity<Object>
         *         System.out.println("Correo: " + credenciales.getCorreo()+ "Contraseña: " + credenciales.getContrasenna());
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
         */

         System.out.println("Credenciales" + credenciales.getCorreo() + " " + credenciales.getPassword());
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(credenciales.getCorreo(),credenciales.getPassword())
        );

        // Guarda mi autenticación
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        System.out.println("Token Administrativo: "+token);



        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

}
