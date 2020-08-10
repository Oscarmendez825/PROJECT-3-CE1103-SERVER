package com.ce1103.p3.Usuario;

public class Tiquete {
    private String name;
    private String email;
    private String apellido;
    private String de;
    private String a;
    private String[] fechas;
    private String cantidad;
    public String getName() {
        return name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String[] getFechas() {
        return fechas;
    }

    public void setFechas(String[] fechas) {
        this.fechas = fechas;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
