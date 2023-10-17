package com.javeriana.drpaws.proyecto.controlador.DTO;

public class MedicamentoDTO {

     /*
     * Medicamento DTO
     * El servidor recibe la petición de autenticación del administrador o veterianario
     * Se envia en el cuerpo de la petición el correo y la contraseña 
     */

    private Long id;
    private String nombre;
    private int cantidadTratamientos;

    public MedicamentoDTO(Long id, String nombre, int cantidadTratamientos) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadTratamientos = cantidadTratamientos;
    }

    public MedicamentoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadTratamientos() {
        return cantidadTratamientos;
    }

    public void setCantidadTratamientos(int cantidad) {
        this.cantidadTratamientos = cantidad;
    }

}
