package com.javeriana.drpaws.proyecto.entidad;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;

@Entity
@Data
@NoArgsConstructor
public class Mascota {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String raza;
    private Integer edad;
    private float peso;
    private String enfermedad;
    private String imagen;
    private boolean activo = true;

    @JsonIgnore
    @ManyToOne
    private Usuario usuario;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "tratamiento", joinColumns = @JoinColumn(name = "mascota_id"), inverseJoinColumns = @JoinColumn(name = "veterinario_id"))

    private List<Veterinario> veterinarios;

    public Mascota(String nombre, String raza, int edad, float peso, String enfermedad, String imagen) {

        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.enfermedad = enfermedad;
        this.imagen = imagen;
    }
    
    @Override
    public String toString() {
        return "Mascota [nombre=" + nombre + ", raza=" + raza + ", edad=" + edad + ", peso=" + peso + ", enfermedad="
                + enfermedad + ", imagen=" + imagen + ", id=" + id + ", usuario=" + usuario + "]";
    }


}
