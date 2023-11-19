package com.javeriana.drpaws.proyecto.DTO.InputDTO;

public class CredencialesDTO {

    /*
     * Credenciales DTO
     * El servidor recibe la petición de autenticación del administrador o veterianario
     * Se envia en el cuerpo de la petición el correo y la contraseña 
     */
    private String correo;
    private String password;

    public CredencialesDTO() {
    }

    public CredencialesDTO(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPassword(String contrasena) {
        this.password = contrasena;
    }

}
