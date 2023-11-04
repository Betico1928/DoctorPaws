package com.javeriana.drpaws.proyecto.entidad;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tratamiento {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String descripcion;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private float costo;

    private String frecuencia;

    @JsonIgnore
    @ManyToOne
    private Mascota mascota;

    @JsonIgnore
    @ManyToOne
    private Veterinario veterinario;

    @JsonIgnore
    @ManyToOne
    private Medicamento medicamento;

    // Constructor
    public Tratamiento(Long id, String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin,
            float costo,
            String frecuencia) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
        this.frecuencia = frecuencia;
    }

    public Tratamiento(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, float costo,
            String frecuencia) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
        this.frecuencia = frecuencia;
    }

}
