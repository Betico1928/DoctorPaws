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

    @ManyToOne
    private Veterinario veterinario;

    @ManyToOne
    private Mascota mascota;

    @OneToMany(mappedBy = "tratamiento")
    List<Medicamento> medicamentos = new ArrayList<>();

    private String nombre;

    public Tratamiento(String nombre) {
        this.nombre = nombre;
    }

    public Tratamiento() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
