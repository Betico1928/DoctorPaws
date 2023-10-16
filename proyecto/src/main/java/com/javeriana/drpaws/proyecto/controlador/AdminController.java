package com.javeriana.drpaws.proyecto.controlador;

import com.javeriana.drpaws.proyecto.servicio.Mascota.MascotaService;
import com.javeriana.drpaws.proyecto.servicio.Tratamiento.TratamientoService;
import com.javeriana.drpaws.proyecto.servicio.Veterinario.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Conroller para el dashboard de administrador

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
    @Autowired
    private TratamientoService tratamientoService;

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private VeterinarioService veterinarioService;

    // Para obtener la cantidad de mascotas en la veterinaria
    // http://localhost:8080/admin/query/total-mascotas
    @GetMapping("/query/total-mascotas")
    public Long getTotalMascotas() {
        return mascotaService.totalMascotas();
    }

    // Para obtener la cantidad total de mascotas activas en tratamiento en la
    // veterinaria
    // http://localhost:8080/admin/query/total-active-mascotas
    @GetMapping("/query/total-active-mascotas")
    public Long getTotalMascotasActivas() {
        return mascotaService.totalMascotasActivas();
    }

    // Para obtener a todos los veterinarios activos:
    // http://localhost:8080/admin/query/count-active
    @GetMapping("/query/count-active")
    public Long obtenerCantidadVeterinariosActivos() {
        return veterinarioService.obtenerCantidadVeterinariosActivos();
    }

    // Para obtener a todos los veterinarios NO activos:
    // http://localhost:8080/admin/query/count-inactive
    @GetMapping("/query/count-inactive")
    public Long obtenerCantidadVeterinariosInactivos() {
        return veterinarioService.obtenerCantidadVeterinariosInactivos();
    }

    // Para obtener la cuenta de tratamientos administrados en el ultimo mes
    // http://localhost:8080/admin/query/count-last-month
    @GetMapping("/query/count-last-month")
    public Long countTratamientosAdminsitradosEnUltimoMes() {
        return tratamientoService.countTratamientosAdminsitradosEnUltimoMes();
    }

    // Para obtener una tabla de los medicamentos y su cantidad suministrada el
    // ultimo mes
    // http://localhost:8080/admin/query/count-last-month-by-medicamento
    @GetMapping("/query/count-last-month-by-medicamento")
    public List<Object[]> countTratamientosPorTipoMedicamentoAdminsitradoEnUltimoMes() {
        return tratamientoService.obtenerCantidadTratamientosPorMedicamentoEnUltimoMes();
    }

    // Las tres drogas más vendidas en los tratamientos
    // http://localhost:8080/admin/query/find-Top3
    @GetMapping("/query/find-top3")
    public List<Object[]> findTop3Tratamientos() {
        return tratamientoService.findTop3Treatments();
    }

    // Para obtener las ventas totales de la veterinaria
    // http://localhost:8080/admin/query/sales
    @GetMapping("/query/sales")
    public Object computeSales() {
        return tratamientoService.computeSales();
    }

    // Para obtener las ganancias de las veterinarias
    // http://localhost:8080/admin/query/profit
    @GetMapping("/query/profit")
    public Object computeProfit() {
        return tratamientoService.computeProfit();
    }

}
