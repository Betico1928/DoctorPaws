package com.javeriana.drpaws.proyecto.entidad;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Medicamento {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private float precioVenta;
    private float precioCompra;
    private int unidadesDisponibles;
    private int unidadesVendidas;


    @JsonIgnore
    @OneToMany(mappedBy = "medicamento")
    private List<Tratamiento> tratamientos;
    // Constructor
    public Medicamento(String nombre, float precioVenta, float precioCompra, int unidadesDisponibles, int unidadesVendidas) {
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.unidadesDisponibles = unidadesDisponibles;
        this.unidadesVendidas = unidadesVendidas;
    }

    // Constructor Vacío
    public Medicamento() {}


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

    public float getPrecioVenta()
    {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta)
    {
        this.precioVenta = precioVenta;
    }

    public float getPrecioCompra()
    {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra)
    {
        this.precioCompra = precioCompra;
    }

    public int getUnidadesDisponibles()
    {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles)
    {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public int getUnidadesVendidas()
    {
        return unidadesVendidas;
    }

    public void setUnidadesVendidas(int unidadesVendidas)
    {
        this.unidadesVendidas = unidadesVendidas;
    }


    public List<Tratamiento> getTratamientos()
    {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos)
    {
        this.tratamientos = tratamientos;
    }
}
