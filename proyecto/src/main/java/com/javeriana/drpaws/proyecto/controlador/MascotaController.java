package com.javeriana.drpaws.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.servicio.MascotaService;

@Controller
@RequestMapping("/mascota")
public class MascotaController {
    @Autowired
    MascotaService mascotaService;

    @GetMapping("/all")
    public String getAllMascotas(Model model) {

        model.addAttribute("mascotas", mascotaService.searchAll());
        return "Mostar_Todas_Mascotas"; // TODO: ALBERTO ESTO LO TE LO DEJO este es el html que muestra la lista de
                                        // todas la mascotas

    }

    @GetMapping("/find/{id}")
    public String getMascotaById(Model model, @PathVariable("id") int id) {
        Mascota mascota = mascotaService.searchById(id);

        if (mascota != null) {
            model.addAttribute("mascota", mascota);

        }

        return "Mostrar_Mascota"; // TODO: ALBERTO ESTO LO TE LO DEJO este es el html que muestra la mascota con
                                  // el id indicado

    }

}
