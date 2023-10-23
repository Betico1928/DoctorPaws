package com.javeriana.drpaws.proyecto.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javeriana.drpaws.proyecto.controlador.MascotaController;
import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.Tratamiento;
import com.javeriana.drpaws.proyecto.servicio.Mascota.MascotaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(MascotaController.class)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class MascotaControllerTest
{
    @MockBean
    // Pide servicio de mascota para testear.
    private MascotaService mascotaService;

    @Autowired
    // Pide request MVC para testear.
    private MockMvc mockMvc;

    @Autowired
    // Pide ObjectMapper para testear.
    private ObjectMapper objectMapper;


    // Test para obtener a todas las mascotas.
    @Test
    public void testGetAllMascotas() throws Exception {
        List<Mascota> mascotas = Arrays.asList(
                new Mascota("Emma", "Border Collie", 1, 2.9f, "Parásitos intestinales (como lombrices)", "path/to/image195"),
                new Mascota("Finn", "Pembroke Welsh Corgi", 13, 24.2f, "Sarna (ácaros)", "path/to/image182"));

        when(mascotaService.searchAll()).thenReturn(mascotas);

        ResultMatcher sizeMatcher = jsonPath("$.size()").value(2);

        mockMvc.perform(get("/mascota/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(sizeMatcher);
    }



    // Test para obtener a una mascota por su ID.
    @Test
    public void testGetMascotaById() throws Exception {
        Mascota mascota = new Mascota("Emma", "Border Collie", 1, 2.9f, "Parásitos intestinales (como lombrices)", "path/to/image195");
        mascota.setId(1L);
        when(mascotaService.searchById(1L)).thenReturn(mascota);

        mockMvc.perform(get("/mascota/find/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }


    // Agregar una mascota.
    @Test
    public void testAgregarMascota() throws Exception {
        Mascota mascota = new Mascota("Luis Carlos", "Border Collie", 1, 2.9f, "Parásitos intestinales.", "path/to/image195");

        mockMvc.perform(post("/mascota/agregar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mascota)))
                .andExpect(status().isOk());

        verify(mascotaService, times(1)).add(any(Mascota.class));
    }


    // Eliminar una mascota.
    @Test
    public void testDeleteMascota() throws Exception {
        mockMvc.perform(delete("/mascota/delete/1"))
                .andExpect(status().isOk());

        verify(mascotaService, times(1)).deleteById(1L);
    }


    // Actualizar una mascota.
    @Test
    public void testUpdateMascota() throws Exception {
        Mascota mascota = new Mascota("Luis Carlos", "Border Collie", 1, 2.9f, "Parásitos intestinales.", "path/to/image195");
        mascota.setId(23L);
        mascota.setNombre("Juan Carlos (Actualizado)");
        // Configura otros atributos según sea necesario

        mockMvc.perform(post("/mascota/update/23")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mascota)))
                .andExpect(status().isOk());

        verify(mascotaService, times(1)).update(any(Mascota.class));
    }

    @Test
    public void testGetTratamientosByNombreMascota() throws Exception {
        List<Tratamiento> tratamientos = Arrays.asList(new Tratamiento(1L, "Nombre del tratamiento #1", "Descripción del tratamiento #1", LocalDate.now(), LocalDate.now().plusDays(7), 100.32F, "Diario"), new Tratamiento(2L, "Nombre del tratamiento #2", "Descripción del tratamiento #2", LocalDate.now().minusDays(15), LocalDate.now(), 100.32F, "Diario"));
        when(mascotaService.getTratamientosByNombreMascota(1L)).thenReturn(tratamientos);

        mockMvc.perform(get("/mascota/tratamientos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

}
