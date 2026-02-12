package com.octa.backendportfolio.dto;

public class ContactRequest {
    private String nombre;
    private String apellido;
    private String asunto;
    private String mensaje;

    //getters y setters

    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getMensaje() {
        return mensaje;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
