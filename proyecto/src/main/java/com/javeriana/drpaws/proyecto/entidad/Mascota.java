package com.javeriana.drpaws.proyecto.entidad;

import java.util.ArrayList;

public class Mascota {
    private Integer id;
    private String nombre;
    private String raza;
    private int edad;
    private float peso;
    private String enfermedad;
    private String imagen;

    public Mascota(Integer id, String nombre, String raza, int edad, float peso, String enfermedad, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.enfermedad = enfermedad;
        this.imagen = elegirRandom();
    }


    private String elegirRandom(){
        ArrayList<String> razas = new ArrayList<>();
        razas.add("beagle");
        razas.add("pug");
        razas.add("shiba");
        razas.add("samoyed");

        int min = 0; // Minimum value of range
        int max = razas.size()-1; // Maximum value of range

        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);

        return razas.get(random_int);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
