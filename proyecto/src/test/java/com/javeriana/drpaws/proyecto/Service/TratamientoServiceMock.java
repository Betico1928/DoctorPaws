package com.javeriana.drpaws.proyecto.Service;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import com.javeriana.drpaws.proyecto.entidad.Tratamiento;
import com.javeriana.drpaws.proyecto.repositorio.MedicamentoRepository;
import com.javeriana.drpaws.proyecto.repositorio.TratamientoRepository;
import com.javeriana.drpaws.proyecto.repositorio.VeterinarioRepository;
import com.javeriana.drpaws.proyecto.servicio.Tratamiento.TratamientoServiceImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("test")
public class TratamientoServiceMock {

    @InjectMocks
    private TratamientoServiceImpl tratamientoService;

    @Mock
    private TratamientoRepository tratamientoRepository;

    @Mock
    private MedicamentoRepository medicamentoRepository;

    @Mock
    private VeterinarioRepository veterinarioRepository;
    

    @Test
    public void TratamientoService_SearchById_Tratamiento(){
        // Arrange
        when(tratamientoRepository.findById(1l)).thenReturn(Optional.ofNullable(new Tratamiento()));

        // Act
        Tratamiento tratamiento = tratamientoService.searchById(1l);

        // Assert
        Assertions.assertThat(tratamiento).isNotNull();

    }

    @Test 
    public void TratamientoService_GetAll_TratamientoList(){
        // Arrange
        when(tratamientoRepository.findAll()).thenReturn(
            List.of(
                new Tratamiento(),
                new Tratamiento(),
                new Tratamiento()
            )
        );

        // Act

        List<Tratamiento> tratamientos  = tratamientoService.getAll();


        // Assert

        Assertions.assertThat(tratamientos.size()).isEqualTo(3);

    }

    @Test
    public void TratamientoService_countTratamientosAdminsitradosEnUltimoMes_Long() {
        // Arrange
        List<Tratamiento> tratamientos = List.of(
                new Tratamiento(1L,
                        "Tratamiento 1",
                        "Tratamiento",
                        LocalDate.now().minusMonths(1).plusDays(1),
                        LocalDate.now().minusDays(1),
                        0,
                        "Mensual"),
                new Tratamiento(2L,
                        "Tratamiento 1",
                        "Tratamiento",
                        LocalDate.now().minusMonths(1).plusDays(10),
                        LocalDate.now().minusDays(2),
                        0,
                        "Mensual")

        );

        LocalDate currentDate = LocalDate.now();
        LocalDate lastMonth = currentDate.minusMonths(1);

        when(tratamientoRepository.countTratamientosAdminsitradosEnUltimoMes(lastMonth, currentDate)).thenReturn(
                tratamientos.stream().filter(t -> (t.getFechaInicio().compareTo(lastMonth) >= 0
                        && t.getFechaInicio().compareTo(currentDate) <= 0)).count());

        // Act
        Long cantidad = tratamientoService.countTratamientosAdminsitradosEnUltimoMes();

        // Assert
        Assertions.assertThat(cantidad).isGreaterThanOrEqualTo(2);

    }

    @Test
    public void TratamientoService_findTop3Treatments_ObjectArray(){

        // Arrange

        Object[] tratamiento1 = new Object[]{"Droga 1",3};
        Object[] tratamiento2 = new Object[]{"Droga 2",3};
        Object[] tratamiento3 = new Object[]{"Droga 2",2};


        ArrayList<Object[]> topTratamientos = new ArrayList<Object[]>();
        topTratamientos.add(tratamiento1);
        topTratamientos.add(tratamiento2);
        topTratamientos.add(tratamiento3);


        List<Object[]> topTratamientosList = new ArrayList<Object[]>(topTratamientos);

        
        when(tratamientoRepository.findTop3Treatments()).thenReturn(
            topTratamientosList
        );


        // Act
        List<Object[]> top3Tratamientos = tratamientoService.findTop3Treatments();

        // Assert
        Assertions.assertThat(top3Tratamientos.size()).isGreaterThan(0);
        Assertions.assertThat(top3Tratamientos).isNotNull();

    }

    @Test
    public void TratamientoService_obtenerCantidadTratamientosPorMedicamentoEnUltimoMes_ObjectList(){
        // Arrange
        Object[] trataMedi1 = new Object[]{"Droga 1", 3};
        Object[] trataMedi2 = new Object[]{"Droga 2", 2};
        Object[] trataMedi3 = new Object[]{"Droga 3", 1};

        ArrayList<Object[]> trataMedis = new ArrayList<Object[]>();
        trataMedis.add(trataMedi1);
        trataMedis.add(trataMedi2);
        trataMedis.add(trataMedi3);


        // Act
        List<Object[]> trataMedisList = new ArrayList<Object[]>(trataMedis);

        LocalDate currentDate = LocalDate.now();
        LocalDate lastMonth = currentDate.minusMonths(1);

        when(tratamientoRepository.countTratamientosPorMedicamentoEnUltimoMes(lastMonth, currentDate)).thenReturn(
            trataMedisList
        );

        List<Object[]> medicamentosFrecuencia = tratamientoService.obtenerCantidadTratamientosPorMedicamentoEnUltimoMes();
        // Assert
        Assertions.assertThat(medicamentosFrecuencia).isNotNull();
        Assertions.assertThat(medicamentosFrecuencia.size()).isEqualTo(3);
    
    }

    @Test
    public void TratamientoService_ComputeSales_Object(){
        // Arrange
        Object sales = "12000";
        when(tratamientoRepository.computeSales()).thenReturn(sales);

        // Act
        
        Object ganancias = tratamientoService.computeSales();

        // Assert
        Assertions.assertThat(ganancias).isNotNull();


    }


}


