package com.javeriana.drpaws.proyecto.entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Entity
@Data
@NoArgsConstructor
public class Veterinario {

    @JsonIgnore
    @OneToOne(cascade=CascadeType.ALL)
    private UserEntity user;

    @Id
    @GeneratedValue
    private Long id;

    private String especialidad;
    private String nombre;
    private String email;
    private String password;
    private String imagen;

    private boolean activo = true;

    @JsonIgnore
    @Exclude
    @ManyToMany
    @JoinTable(name = "tratamiento", joinColumns = @JoinColumn(name = "veterinario_id"), inverseJoinColumns = @JoinColumn(name = "mascota_id"))
    private List<Mascota> mascotas = new ArrayList<>();

    public Veterinario(String especialidad, String nombre, String email, String password, String imagen) {
        this.especialidad = especialidad;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.imagen = imagen;

    }

}
