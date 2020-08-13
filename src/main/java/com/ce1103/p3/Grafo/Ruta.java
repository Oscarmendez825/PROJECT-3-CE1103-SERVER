package com.ce1103.p3.Grafo;
/***
 * Ruta class
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */public class Ruta {
    private String peso;
    private String name;
    private String a;

    /***
     * getter peso
     * @return String
     */
    public String getPeso() {
        return peso;
    }

    /***
     * setter peso
     * @param peso
     */
    public void setPeso(String peso) {
        this.peso = peso;
    }
    /***
     * getter name
     * @return String
     */
    public String getName() {
        return name;
    }
    /***
     * setter name
     * @param name
     */    public void setName(String name) {
        this.name = name;
    }
    /***
     * getter A
     * @return String
     */
    public String getA() {
        return a;
    }
    /***
     * setter a
     * @param a
     */
    public void setA(String a) {
        this.a = a;
    }
}
