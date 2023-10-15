package com.javeriana.drpaws.proyecto.controlador;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.Usuario;
import com.javeriana.drpaws.proyecto.servicio.Usuario.UsuarioService;
import com.javeriana.drpaws.proyecto.servicio.Mascota.MascotaService;
import com.javeriana.drpaws.proyecto.servicio.Tratamiento.TratamientoService;
import com.javeriana.drpaws.proyecto.servicio.Veterinario.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

//Conroller para el dashboard de administrador

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private TratamientoService tratamientoService;

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private VeterinarioService veterinarioService;

    @GetMapping("/query/total-mascotas")
    public Long getTotalMascotas() {
        return mascotaService.totalMascotas();
    }

    @GetMapping("/query/total-active")
    public Long getTotalMascotasActivas() {
        return mascotaService.totalMascotasActivas();
    }

    // Para obtener a todos los veterinarios activos:
    // http://localhost:8080/veterinario/query/count-active
    @GetMapping("/query/count-active")
    public Long obtenerCantidadVeterinariosActivos() {
        return veterinarioService.obtenerCantidadVeterinariosActivos();
    }

    // Para obtener a todos los veterinarios NO activos:
    // http://localhost:8080/veterinario/query/count-inactive
    @GetMapping("/query/count-inactive")
    public Long obtenerCantidadVeterinariosInactivos() {
        return veterinarioService.obtenerCantidadVeterinariosInactivos();
    }

    @GetMapping("/query/count-last-month")
    public Long countTratamientosAdminsitradosEnUltimoMes() {
        return tratamientoService.countTratamientosAdminsitradosEnUltimoMes();
    }

    @GetMapping("/query/count-last-month-by-medicamento")
    public List<Object[]> countTratamientosPorTipoMedicamentoAdminsitradoEnUltimoMes() {
        return tratamientoService.obtenerCantidadTratamientosPorMedicamentoEnUltimoMes();
    }
}
