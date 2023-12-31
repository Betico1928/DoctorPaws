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

import com.javeriana.drpaws.proyecto.DTO.Veterinario.VetDTO;
import com.javeriana.drpaws.proyecto.DTO.Veterinario.VetMapper;
import com.javeriana.drpaws.proyecto.entidad.UserEntity;
import com.javeriana.drpaws.proyecto.entidad.Veterinario;
import com.javeriana.drpaws.proyecto.repositorio.UserRepository;
import com.javeriana.drpaws.proyecto.security.CustomUserDetailsService;
import com.javeriana.drpaws.proyecto.servicio.Veterinario.VeterinarioService;

@RestController
@RequestMapping("/veterinario")
@CrossOrigin(origins = "http://localhost:4200")
public class VeterinarioController {


    @Autowired
    private final VeterinarioService veterinarioService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;



    public VeterinarioController(VeterinarioService veterinarioService) {
        this.veterinarioService = veterinarioService;
    }

    // Para buscar a un veterinario en especifico:
    // http://localhost:8080/veterinario/{id}
    @GetMapping("/find/{id}")
    public Veterinario getVeterinario(@PathVariable("id") Long id) {
        System.out.println("Buscando al veterinario con ID: " + id);
        return veterinarioService.searchById(id);
    }

    // Para crear a un veterinario
    // http://localhost:8080/veterinario/add
    // Se cambia el método de agregar estudiante
    @PostMapping("/add")
    public ResponseEntity createVeterinario(@RequestBody Veterinario veterinario) {
        if(userRepository.existsByUsername(veterinario.getEmail())){
            return new ResponseEntity<String>("Este usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        UserEntity userEntity = customUserDetailsService.saveVeterinario(veterinario);
        //System.out.println("Contraseña " + userEntity.getPassword());
        // Se le asigna el rol de veterinario al nuevo veterinario creado
        veterinario.setUser(userEntity);


        System.out.println("\nInformación del veterinario a crear:");
        System.out.println("+----------------+-------------------------------------+");
        System.out.printf("| %-14s | %-35s |\n", "ID", veterinario.getId());
        System.out.printf("| %-14s | %-35s |\n", "Especialidad", veterinario.getEspecialidad());
        System.out.printf("| %-14s | %-35s |\n", "Nombre", veterinario.getNombre());
        System.out.printf("| %-14s | %-35s |\n", "Email", veterinario.getEmail());
        System.out.printf("| %-14s | %-35s |\n", "Password", veterinario.getPassword());
        System.out.printf("| %-14s | %-35s |\n", "Imagen URL", veterinario.getImagen());
        System.out.printf("| %-14s | %-35s |\n", "Activo", veterinario.isActivo() ? "Sí" : "No");
        System.out.println("+----------------+-------------------------------------+");

         veterinarioService.add(veterinario);

        return new ResponseEntity<Veterinario>(veterinario, HttpStatus.CREATED);
 
    }

    // Para actualizar a un veterinario en especifico:
    // http://localhost:8080/veterinario/update/{id}
    @PostMapping("/update/{id}")
    public void updateVeterinario(@PathVariable("id") Long id, @RequestBody Veterinario veterinario) {

        // Se obtiene el veterinario anterior
        Veterinario anterior = veterinarioService.searchById(id);
        
        // Se crea un entidad de usuario para el veterinario nuevo
        UserEntity userEntity = customUserDetailsService.saveVeterinario(veterinario);

        // Se asigna los nuevos valores de correo y contraseña al user entity del veterinario anterior
        userRepository.findByUsername(anterior.getEmail()).get().setUsername(userEntity.getUsername());
        userRepository.findByUsername(anterior.getEmail()).get().setPassword(userEntity.getPassword());



        System.out.println("\nInformación del veterinario a actualizar:");
        System.out.println("+----------------+-------------------------------------+");
        System.out.printf("| %-14s | %-35s |\n", "ID", veterinario.getId());
        System.out.printf("| %-14s | %-35s |\n", "Especialidad", veterinario.getEspecialidad());
        System.out.printf("| %-14s | %-35s |\n", "Nombre", veterinario.getNombre());
        System.out.printf("| %-14s | %-35s |\n", "Email", veterinario.getEmail());
        System.out.printf("| %-14s | %-35s |\n", "Password", veterinario.getPassword());
        System.out.printf("| %-14s | %-35s |\n", "Imagen URL", veterinario.getImagen());
        System.out.printf("| %-14s | %-35s |\n", "Activo", veterinario.isActivo() ? "Sí" : "No");
        System.out.println("+----------------+-------------------------------------+");

        veterinarioService.update(veterinario);
    }

    // Para borrar a un veterinario en especifico:
    // http://localhost:8080/veterinario/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void deleteVeterinario(@PathVariable("id") Long id) {
        System.out.println("Borrando al veterinario con ID: " + id);
        veterinarioService.deleteById(id);
    }

    // Para buscar a todos los veterinarios:
    // http://localhost:8080/veterinario/all
    @GetMapping("/all")
    public List<Veterinario> getAllVeterinarios() {
        System.out.println("Buscando a todos los veterinarios...");
        return veterinarioService.searchAll();
    }

    // Verifica que un veterinario ya está autenticado
    @GetMapping("/details")
    public ResponseEntity<VetDTO> buscarVeterinario(){
        // Se asume que el veterinario ya está autenticado
        Veterinario veterinario =veterinarioService.searchByEmail(
            SecurityContextHolder.getContext().getAuthentication().getName()
        );
        VetDTO vetDTO = null;

        if(veterinario  == null) {
            return new ResponseEntity<VetDTO>(vetDTO,HttpStatus.NOT_FOUND);
        }else{
            vetDTO = VetMapper.INSTANCE.convert(veterinario);
            return new ResponseEntity<VetDTO>(vetDTO,HttpStatus.OK);
        }
    }
}