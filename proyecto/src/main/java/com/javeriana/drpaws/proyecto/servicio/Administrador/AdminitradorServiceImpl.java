package com.javeriana.drpaws.proyecto.servicio.Administrador;

import com.javeriana.drpaws.proyecto.DTO.InputDTO.CredencialesDTO;
import com.javeriana.drpaws.proyecto.entidad.Administrador;
import com.javeriana.drpaws.proyecto.repositorio.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminitradorServiceImpl implements AdministradorService {

    @Autowired
    AdministradorRepository repo;

    @Override
    public Administrador autenticarAdministrador(CredencialesDTO credenciales) {
        String correo = credenciales.getCorreo();
        String contrasena = credenciales.getPassword();

        Administrador administrador = repo.findByEmail(correo);
        System.out.println(administrador);

        if (administrador != null && administrador.getPassword().equals(contrasena)) {
            return administrador;

        } else {
            return new Administrador();

        }

    }

}
