package com.javeriana.drpaws.proyecto.controlador.DTO;

public class CedulaDTO {
    /*
     * Cedula DTO
     * El servidor recibe la petición de autenticación del usuario
     * Se envia en el cuerpo de la petición la cedula
     */

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
