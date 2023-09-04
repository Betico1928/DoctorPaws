package com.javeriana.drpaws.proyecto.controlador;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.Usuario;
import com.javeriana.drpaws.proyecto.servicio.Usuario.UsuarioService;
import com.javeriana.drpaws.proyecto.servicio.mascota.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MascotaService mascotaService;

    @RequestMapping("/dashboard")
    public String dashboard(Model model)
    {
        // Obtener los datos de ambos servicios
        Collection<Usuario> usuarios = usuarioService.searchAll();
        Collection<Mascota> mascotas = mascotaService.searchAll();

        // Agregar los datos al modelo
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("mascotas", mascotas);

        return "dashboard-administrativo";
    }
}
