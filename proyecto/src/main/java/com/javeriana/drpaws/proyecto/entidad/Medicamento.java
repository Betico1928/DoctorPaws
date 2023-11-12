package com.javeriana.drpaws.proyecto.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
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
    public Medicamento(String nombre, float precioVenta, float precioCompra, int unidadesDisponibles,
            int unidadesVendidas) {
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.unidadesDisponibles = unidadesDisponibles;
        this.unidadesVendidas = unidadesVendidas;
    }

}
