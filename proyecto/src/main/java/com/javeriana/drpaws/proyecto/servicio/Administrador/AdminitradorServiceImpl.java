package com.javeriana.drpaws.proyecto.servicio.Administrador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javeriana.drpaws.proyecto.controlador.DTO.CredencialesDTO;
import com.javeriana.drpaws.proyecto.entidad.Administrador;
import com.javeriana.drpaws.proyecto.entidad.Veterinario;
import com.javeriana.drpaws.proyecto.repositorio.AdministradorRepository;

@Service
public class AdminitradorServiceImpl implements AdministradorService {

    @Autowired
    AdministradorRepository repo;

    @Override
    public Administrador autenticarAdministrador(CredencialesDTO credenciales) {
        String correo = credenciales.getCorreo();
        String contrasena = credenciales.getContrasenna();

        Administrador administrador = repo.findByEmail(correo);
        System.out.println(administrador);

        if (administrador != null && administrador.getPassword().equals(contrasena)) {
            return administrador;

        } else {
            return new Administrador();

        }

    }

}
