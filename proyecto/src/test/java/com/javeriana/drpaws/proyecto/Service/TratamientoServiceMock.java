package com.javeriana.drpaws.proyecto.Service;

import static org.mockito.Mockito.when;

import java.lang.reflect.Array;
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
import com.javeriana.drpaws.proyecto.repositorio.TratamientoRepository;
import com.javeriana.drpaws.proyecto.servicio.Tratamiento.TratamientoServiceImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("test")
public class TratamientoServiceMock {
    
    @InjectMocks
    private TratamientoServiceImpl tratamientoService;

    @Mock
    private TratamientoRepository tratamientoRepository;

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
    public void TratamientoService_countTratamientosAdminsitradosEnUltimoMes_Long(){
        // Arrange
        Tratamiento tratamiento = new Tratamiento(1L,
                                                "Tratamiento 1",
                                                 "Tratamiento", 
                                                 LocalDate.of(2023,9,15),
                                                 LocalDate.of(2023,10,18),
                                                 0,
                                                 "Mensual"
                                                 );
       List<Tratamiento> tratamientos = List.of(
            tratamiento
        );


        LocalDate currentDate = LocalDate.of(2023,10,10);
        LocalDate lastMonth = LocalDate.of(2023,9,10);
        when(tratamientoRepository.countTratamientosAdminsitradosEnUltimoMes(lastMonth,currentDate)).thenReturn(
            Long.valueOf(tratamientos.size())
        );

        // Act
        Long cantidad = tratamientoService.countTratamientosAdminsitradosEnUltimoMes();

        // Assert
        Assertions.assertThat(cantidad).isEqualTo(1);

        
    }
}
