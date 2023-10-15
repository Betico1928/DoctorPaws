package com.javeriana.drpaws.proyecto.controlador.DTO;

public class CedulaDTO {
    private String cedula;

    public CedulaDTO() {
    }

    public CedulaDTO(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

}
