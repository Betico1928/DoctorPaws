package com.javeriana.drpaws.proyecto.entidad;

import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Medicamento {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private float precio;

    @OneToMany(mappedBy = "medicamento")
    private List<Tratamiento> tratamientos = new ArrayList<>();

    public Medicamento(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Medicamento() {

    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

}
