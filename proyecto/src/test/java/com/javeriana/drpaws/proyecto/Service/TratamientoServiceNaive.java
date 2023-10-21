package com.javeriana.drpaws.proyecto.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.javeriana.drpaws.proyecto.entidad.Medicamento;
import com.javeriana.drpaws.proyecto.entidad.Tratamiento;
import com.javeriana.drpaws.proyecto.servicio.Medicamento.MedicamentoService;
import com.javeriana.drpaws.proyecto.servicio.Tratamiento.TratamientoService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class TratamientoServiceNaive {

    @Autowired
    private TratamientoService tratamientoService;

    @Autowired
    private MedicamentoService medicamentoService;
    

    @BeforeEach
    // Datos previos
    public void init(){

        // Crear los medicamentos para pruebas 
        Medicamento medicamento1 = new Medicamento("Medicamento 1", 17000, 15000, 5, 2);
        Medicamento medicamento2 = new Medicamento("Medicamento 2",21000,12000,3,1);
        Medicamento medicamento3 = new Medicamento("Medicamento 3",30000,20000,10,1);

        // Cargar los medicamentos a la base de datos
        medicamentoService.add(medicamento1);
        medicamentoService.add(medicamento2);
        medicamentoService.add(medicamento3);

        // Crear los tres tratamientos para hacer pruebas
        Tratamiento  tratamiento = new Tratamiento();
        tratamiento.setNombre("Vacunacion anti pulgas");
        tratamiento.setDescripcion("Proceso de desinfección de parasitos");
        tratamiento.setFechaInicio(LocalDate.now().minusMonths(1).plusDays(2));
        tratamiento.setMedicamento(medicamento1);

        Tratamiento  tratamiento2 = new Tratamiento();
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
        tratamientoService.add(tratamiento);
        tratamientoService.add(tratamiento2);
        tratamientoService.add(tratamiento3);
        tratamientoService.add(tratamiento4);

    }


    // Create
    @Test
    public void TratamientoService_add_void(){

        init();

        // Arrange
        Tratamiento tratamiento =  new Tratamiento();
        tratamiento.setNombre("Limpieza de pulgas");
        tratamiento.setDescripcion("Baño");
        tratamiento.setFrecuencia("Mensual");
        tratamiento.setFechaFin(LocalDate.now());

        // Act
        tratamientoService.add(tratamiento);


        // Assert
        Assertions.assertThat(tratamientoService.getAll().size()).isEqualTo(5);
        
    }

    // Read
    @Test
    public void TratamientoService_searchById_Tratamiento(){
        init();

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
    public void TratamientoService_getAll_TratamientoLists(){

        // Arrange
        init();

        // Act
        List<Tratamiento> tratamientos = tratamientoService.getAll();

        // Assert
        Assertions.assertThat(tratamientos).isNotNull();
        Assertions.assertThat(tratamientos.size()).isEqualTo(4);
        
    }

    @Test
    public void TratamientoService_countTratamientosAdminsitradosEnUltimoMes_Long(){
        // Arrange
        init();

        // Act
        Long count = tratamientoService.countTratamientosAdminsitradosEnUltimoMes();
        
        // Assert
        Assertions.assertThat(count).isGreaterThan(0);
        Assertions.assertThat(count).isEqualTo(4);

    }

    @Test
    public void TratamientoService_obtenerCantidadTratamientosPorMedicamentoEnUltimoMes_ObjectList(){

        // Arrange 
        init();

        // Act 
        List<Object[]> objetos = tratamientoService.obtenerCantidadTratamientosPorMedicamentoEnUltimoMes();

        // Assert
        Assertions.assertThat(objetos).isNotNull();

        Assertions.assertThat(objetos.size()).isEqualTo(3);

        Assertions.assertThat(objetos.get(0)[0]).isEqualTo("Medicamento 1");

        Assertions.assertThat(objetos.get(0)[1]).isEqualTo(2L);
        
    }

    @Test
    public void TratamientoService_findTop3Treatments_ObjectList(){
        // Arrange
        init();

        // Act
        List<Object[]> objetos = tratamientoService.findTop3Treatments();

        // Assert
        Assertions.assertThat(objetos).isNotNull();

        Assertions.assertThat(objetos.size()).isEqualTo(3);

        Assertions.assertThat(objetos.get(0)[0]).isEqualTo("Medicamento 1");

        Assertions.assertThat(objetos.get(0)[1]).isEqualTo(2L);
    }

    @Test
    public void TratamientoService__ComputeSales__Object(){
        // Arrange
        init();

        // Act
        Object ventas = tratamientoService.computeSales();

        // Assert
        Assertions.assertThat(ventas).isNotNull();
        Assertions.assertThat(ventas).isEqualTo(new BigDecimal("85000.00"));
    }

    @Test
    public void TratamientoService__ComputeProfit__Object(){
        // Arrange
        init();

        // Act
        Object ganancias = tratamientoService.computeProfit();

        // Assert
        Assertions.assertThat(ganancias).isNotNull();
        Assertions.assertThat(ganancias).isEqualTo(new BigDecimal("38000.00"));
    }




    
}
