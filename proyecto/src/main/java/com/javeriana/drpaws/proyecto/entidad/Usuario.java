package com.javeriana.drpaws.proyecto.entidad;

import java.util.List;

public class Usuario {
    private int id;
    private String contraseña;
    private String especialidad;
    private String foto;
    private int noAtenciones;
    private List<Mascota> mascotas;

    public Usuario() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getNoAtenciones() {
        return noAtenciones;
    }

    public void setNoAtenciones(int noAtenciones) {
        this.noAtenciones = noAtenciones;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public Usuario(int id, String contraseña, String especialidad, String foto, int noAtenciones,
            List<Mascota> mascotas) {

    }

}
