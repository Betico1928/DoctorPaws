package com.javeriana.drpaws.proyecto.servicio.Administrador;

import com.javeriana.drpaws.proyecto.DTO.InputDTO.CredencialesDTO;
import com.javeriana.drpaws.proyecto.entidad.Administrador;

public interface AdministradorService {
    public Administrador autenticarAdministrador(CredencialesDTO credenciales);

}
