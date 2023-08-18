package com.javeriana.drpaws.proyecto.entidad;

public class Mascota {
    private String nombre;
    private String raza;
    private int edad;
    private float peso;
    private String endfermedad;

    public Mascota(String nombre, String raza, int edad, float peso, String endfermedad) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.endfermedad = endfermedad;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getEndfermedad() {
        return endfermedad;
    }

    public void setEndfermedad(String endfermedad) {
        this.endfermedad = endfermedad;
    }

}
