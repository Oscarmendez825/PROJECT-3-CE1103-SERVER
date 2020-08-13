package com.ce1103.p3.Usuario;
/***
 * Precio class
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class Precio {
    private String name;
    private String email;
    private String apellido;
    private String de;
    private String a;
    private String cantidad;
    private int precio;

    /***
     * get the name of the client
     * @return
     */
    public String getName() {
        return name;
    }

    /***
     * set the name of the client
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /***
     * get the email of the client
     * @return
     */
    public String getEmail() {
        return email;
    }

    /***
     * set the email of the client
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /***
     * get the last name of the client
     * @return
     */
    public String getApellido() {
        return apellido;
    }

    /***
     * set the last name of the client
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * get the departure station
     * @return
     */
    public String getDe() {
        return de;
    }

    /***
     * set the departure station
     * @param de
     */
    public void setDe(String de) {
        this.de = de;
    }

    /***
     * get the arrival station
     * @return
     */
    public String getA() {
        return a;
    }

    /***
     * set the arrival station
     * @param a
     */
    public void setA(String a) {
        this.a = a;
    }

    /***
     * get the quantity o tickets
     * @return
     */
    public String getCantidad() {
        return cantidad;
    }

    /***
     * set the quantity of tickets
     * @param cantidad
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /***
     * get the total
     * @return
     */
    public int getPrecio() {
        return precio;
    }

    /***
     * set the total
     * @param precio
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
