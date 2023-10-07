package com.javeriana.drpaws.proyecto.controlador.DTO;

public class CredencialesDTO {
    private String correo;
    private String contrasenna;

    public CredencialesDTO() {
    }

    public CredencialesDTO(String correo, String contrasena) {
        this.correo = correo;
        this.contrasenna = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasenna(String contrasena) {
        this.contrasenna = contrasena;
    }

}
