package com.javeriana.drpaws.proyecto.servicio.Administrador;

import com.javeriana.drpaws.proyecto.controlador.DTO.CredencialesDTO;
import com.javeriana.drpaws.proyecto.entidad.Administrador;
import com.javeriana.drpaws.proyecto.entidad.Veterinario;

public interface AdministradorService {
    public Administrador autenticarAdministrador(CredencialesDTO credenciales);

}
