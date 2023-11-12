package com.javeriana.drpaws.proyecto.DTO.InputDTO;

public class CredencialesDTO {

    /*
     * Credenciales DTO
     * El servidor recibe la petición de autenticación del administrador o veterianario
     * Se envia en el cuerpo de la petición el correo y la contraseña 
     */
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
