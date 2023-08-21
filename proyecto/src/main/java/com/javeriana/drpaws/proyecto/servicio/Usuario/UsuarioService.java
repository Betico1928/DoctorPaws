package com.javeriana.drpaws.proyecto.servicio.Usuario;

import java.util.Collection;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.Usuario;

public interface UsuarioService {
    public Usuario searchById(int id);
    
    public Mascota searchMascota(int uid, int id);

    public Collection<Mascota> searchMascotas(int uid);
}
