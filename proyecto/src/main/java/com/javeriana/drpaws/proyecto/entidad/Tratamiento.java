package com.javeriana.drpaws.proyecto.entidad;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Tratamiento {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String descripcion;

    private String fechaInicio;

    private String fechaFin;

    private float costo;

    private String frecuencia;

    @ManyToOne
    private Mascota mascota;

    @ManyToOne
    private Veterinario veterinario;

    @ManyToOne
    private Medicamento medicamento;



    // Constructor
    public Tratamiento(Long id, String nombre, String descripcion, String fechaInicio, String fechaFin, float costo, String frecuencia) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
        this.frecuencia = frecuencia;
    }


    // Constructor Vacío
    public Tratamiento() {}


    // Getters y Setters
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getFechaInicio()
    {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio)
    {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin()
    {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin)
    {
        this.fechaFin = fechaFin;
    }

    public float getCosto()
    {
        return costo;
    }

    public void setCosto(float costo)
    {
        this.costo = costo;
    }

    public String getFrecuencia()
    {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia)
    {
        this.frecuencia = frecuencia;
    }

    public Mascota getMascota()
    {
        return mascota;
    }

    public void setMascota(Mascota mascota)
    {
        this.mascota = mascota;
    }

    public Veterinario getVeterinario()
    {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario)
    {
        this.veterinario = veterinario;
    }

    public Medicamento getMedicamento()
    {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento)
    {
        this.medicamento = medicamento;
    }
}
