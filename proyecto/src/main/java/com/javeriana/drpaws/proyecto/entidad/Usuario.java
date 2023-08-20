package com.javeriana.drpaws.proyecto.entidad;

import java.util.List;

public class Usuario
{
    private int id;
    private List<Mascota> mascotas;

    public Usuario() {

    }

    // Getters y setters

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public List<Mascota> getMascotas()
    {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas)
    {
        this.mascotas = mascotas;
    }


    // Constructor

    public Usuario(int id, List<Mascota> mascotas)
    {
        this.id = id;
        this.mascotas = mascotas;
    }
}
