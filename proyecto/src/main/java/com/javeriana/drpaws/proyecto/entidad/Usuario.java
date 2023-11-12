package com.javeriana.drpaws.proyecto.entidad;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity user;

    @Id
    @GeneratedValue
    private Long id;

    private String cedula;
    private String nombre;
    private String correo;
    private String celular;
    private String contrasenna;
    private String imagen;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    private List<Mascota> mascotas;

    public Usuario(String cedula, String nombre, String correo, String celular, String contrasenna,
            String imagen) {

        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.contrasenna = contrasenna;
        this.imagen = imagen;
    }


    @Override
    public String toString() {
        return "Usuario [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", correo=" + correo + ", celular="
                + celular + ", contraseña=" + contrasenna + ", imagen=" + imagen + ", mascotas=" + mascotas + "]";
    }

}
