package com.javeriana.drpaws.proyecto.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javeriana.drpaws.proyecto.entidad.Role;
import com.javeriana.drpaws.proyecto.entidad.UserEntity;
import com.javeriana.drpaws.proyecto.entidad.Usuario;
import com.javeriana.drpaws.proyecto.entidad.Veterinario;
import com.javeriana.drpaws.proyecto.repositorio.RoleRepository;
import com.javeriana.drpaws.proyecto.repositorio.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // UserEntity es la interfaz
    // User es la implementación de la interfaz
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userDB = userRepository.findByUsername(username).orElseThrow(
            ()-> new UsernameNotFoundException("User not found")
        );  
        // UserDetails(Usuario estándar para temas de seguridad)
        UserDetails userDetails = new User(userDB.getUsername(),
                                            userDB.getPassword(),
                                            mapRolesToAuthorities(userDB.getRoles())
                                            );
       return userDetails;
    }

    // Mapear el rol que se tiene en la base de datos
    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    // Mapeo con los veterinarios
    public UserEntity saveVeterinario(Veterinario veterinario){
        UserEntity user = new UserEntity();
        user.setUsername(veterinario.getEmail());
        user.setPassword(passwordEncoder.encode(veterinario.getPassword()));

        // Asignarle su rol
        Role roles = roleRepository.findByName("VETERINARIO").get();
        user.setRoles(List.of(roles));
        return user;
    }

    // Mapeo con los usuarios
     public UserEntity saveUsuario(Usuario usuario){
        UserEntity user = new UserEntity();
        user.setUsername(usuario.getCedula());
        user.setPassword(passwordEncoder.encode("123"));

        // Asignarle su rol
        Role roles = roleRepository.findByName("USUARIO").get();
        user.setRoles(List.of(roles));
        return user;
    }



}