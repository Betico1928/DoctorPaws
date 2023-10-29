package com.javeriana.drpaws.proyecto.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.Medicamento;
import com.javeriana.drpaws.proyecto.entidad.Tratamiento;
import com.javeriana.drpaws.proyecto.entidad.Veterinario;
import com.javeriana.drpaws.proyecto.servicio.Mascota.MascotaService;
import com.javeriana.drpaws.proyecto.servicio.Medicamento.MedicamentoService;
import com.javeriana.drpaws.proyecto.servicio.Tratamiento.TratamientoService;
import com.javeriana.drpaws.proyecto.servicio.Veterinario.VeterinarioService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test2")
public class TratamientoServiceNaive {

    @Autowired
    private TratamientoService tratamientoService;

    @Autowired
    private MedicamentoService medicamentoService;

    @Autowired
    private VeterinarioService veterinarioService;

    @Autowired
    private MascotaService mascotaService;

    @BeforeEach
    // Datos previos
    public void init() {
        // Crear los medicamentos para pruebas
        Medicamento medicamento1 = new Medicamento("Medicamento 1", 17000, 15000, 5, 2);
        Medicamento medicamento2 = new Medicamento("Medicamento 2", 21000, 12000, 3, 1);
        Medicamento medicamento3 = new Medicamento("Medicamento 3", 30000, 20000, 10, 1);

        // Cargar los medicamentos a la base de datos
        medicamentoService.add(medicamento1);
        medicamentoService.add(medicamento2);
        medicamentoService.add(medicamento3);

        // Crear veterinario para prueba
        Veterinario veterinario1 = new Veterinario("Ojos", "Juan", "Juan@gmail.com", "123", "url");

        // Cargar veterinario a la base de datos
        veterinarioService.add(veterinario1);

        // Crear mascota para prueba
        Mascota mascota = new Mascota("Andy", "Beagle", 10, 123, "Obesidad", "URL");

        // Cargar mascota para prueba
        mascotaService.add(mascota);

        // Crear los tres tratamientos para hacer pruebas
        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setNombre("Vacunacion anti pulgas");
        tratamiento.setDescripcion("Proceso de desinfección de parasitos");
        tratamiento.setFechaInicio(LocalDate.now().minusMonths(1).plusDays(2));
        // tratamiento.setMedicamento(medicamento1);

        Tratamiento tratamiento2 = new Tratamiento();
        tratamiento2.setNombre("Vacunacion anti hongo");
        tratamiento2.setDescripcion("Proceso de desinfección de hongos");
        tratamiento2.setFechaInicio(LocalDate.now().minusMonths(1).plusDays(4));
        tratamiento2.setMedicamento(medicamento1);

        Tratamiento tratamiento3 = new Tratamiento();
        tratamiento3.setNombre("Vacunacion anti rabia");
        tratamiento3.setDescripcion("Proceso de prevención de rabia");
        tratamiento3.setFechaInicio(LocalDate.now().minusMonths(1).plusDays(3));
        tratamiento3.setMedicamento(medicamento2);

        Tratamiento tratamiento4 = new Tratamiento();
        tratamiento4.setNombre("Limpieza de oidos");
        tratamiento4.setDescripcion("Lavar orejas para prevenir infección");
        tratamiento4.setFechaInicio(LocalDate.now().minusMonths(1).plusDays(5));
        tratamiento4.setMedicamento(medicamento3);

        // Almacenar los tratamientos en la base de datos
        tratamientoService.add(tratamiento, 1l, 1l, 1l);
        tratamientoService.add(tratamiento2, 1l, 1l, 1l);
        tratamientoService.add(tratamiento3, 1l, 2l, 1l);
        tratamientoService.add(tratamiento4, 1l, 3l, 1l);

    }

    // Create
    @Test
    public void TratamientoService_add_void() {
        // Creo otra mascota y veterinario
        // Crear veterinario para prueba
        Veterinario veterinario1 = new Veterinario("Dientes", "Emilio", "Emil@gmail.com", "123", "url");

        // Cargar veterinario a la base de datos
        veterinarioService.add(veterinario1);

        // Crear mascota para prueba
        Mascota mascota = new Mascota("Buddy", "Pitbull", 3, 13, "Rabia", "URL");

        // Cargar mascota para prueba
        mascotaService.add(mascota);

        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setNombre("Limpieza de pulgas");
        tratamiento.setDescripcion("Baño");
        tratamiento.setFrecuencia("Mensual");
        tratamiento.setFechaFin(LocalDate.now());

        // Act
        tratamientoService.add(tratamiento, 2l, 3l, 2l);

        // Assert
        Assertions.assertThat(tratamientoService.getAll().size()).isEqualTo(5);

    }

    // Read
    @Test
    public void TratamientoService_searchById_Tratamiento() {
        // Arrange
        Long index = 1l;

        // Act
        Tratamiento tratamiento = tratamientoService.searchById(index);

        // Arrange
        Assertions.assertThat(tratamiento).isNotNull();
        Assertions.assertThat(tratamiento.getNombre()).isEqualTo("Vacunacion anti pulgas");

    }

    // Find all
    @Test
    public void TratamientoService_getAll_TratamientoLists() {

        // Arrange

        // Act
        List<Tratamiento> tratamientos = tratamientoService.getAll();

        // Assert
        Assertions.assertThat(tratamientos).isNotNull();
        Assertions.assertThat(tratamientos.size()).isEqualTo(4);

    }

    @Test
    public void TratamientoService_countTratamientosAdminsitradosEnUltimoMes_Long() {
        // Arrange

        // Act
        Long count = tratamientoService.countTratamientosAdminsitradosEnUltimoMes();

        // Assert
        Assertions.assertThat(count).isGreaterThan(0);
        Assertions.assertThat(count).isEqualTo(4);

    }

    @Test
    public void TratamientoService_obtenerCantidadTratamientosPorMedicamentoEnUltimoMes_ObjectList() {

        // Arrange

        // Act
        List<Object[]> objetos = tratamientoService.obtenerCantidadTratamientosPorMedicamentoEnUltimoMes();

        // Assert
        Assertions.assertThat(objetos).isNotNull();

        Assertions.assertThat(objetos.size()).isEqualTo(3);

        Assertions.assertThat(objetos.get(0)[0]).isEqualTo("Medicamento 1");

        Assertions.assertThat(objetos.get(0)[1]).isEqualTo(2L);

    }

    @Test
    public void TratamientoService_findTop3Treatments_ObjectList() {
        // Arrange

        // Act
        List<Object[]> objetos = tratamientoService.findTop3Treatments();

        // Assert
        Assertions.assertThat(objetos).isNotNull();

        Assertions.assertThat(objetos.size()).isEqualTo(3);

        Assertions.assertThat(objetos.get(0)[0]).isEqualTo("Medicamento 1");

        Assertions.assertThat(objetos.get(0)[1]).isEqualTo(2);
    }

    @Test
    public void TratamientoService__ComputeSales__Object() {
        // Arrange

        // Act
        Object ventas = tratamientoService.computeSales();

        // Assert
        Assertions.assertThat(ventas).isNotNull();
        Assertions.assertThat(ventas).isEqualTo(new BigDecimal("85000.00"));
    }

    @Test
    public void TratamientoService__ComputeProfit__Object() {
        // Arrange

        // Act
        Object ganancias = tratamientoService.computeProfit();

        // Assert
        Assertions.assertThat(ganancias).isNotNull();
        Assertions.assertThat(ganancias).isEqualTo(new BigDecimal("38000.00"));
    }

}