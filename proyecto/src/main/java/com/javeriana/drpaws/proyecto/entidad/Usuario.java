package com.javeriana.drpaws.proyecto.entidad;

import java.util.ArrayList;

public class Usuario {
    private Integer id;
    private String nombre;
    private String correo;
    private String celular;
    private String contraseña;
    private String imagen;
    private ArrayList<Integer> mascotas;

    public Usuario(Integer id, String nombre, String correo, String celular, String contraseña, ArrayList<Integer> mascotas, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.contraseña = contraseña;
        this.mascotas = mascotas;
        this.imagen = imagen;
    }

    public Usuario(){
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public ArrayList<Integer> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Integer> mascotas) {
        this.mascotas = mascotas;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }



   

}
