/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dto;

import java.io.Serializable;

/**
 *
 * @author esgar
 */
public class Clientes implements Serializable{
    private int identificacion1;
    private String nombre1;
    private String correo1;
    private int edad1;

    public int getIdentificacion1() {
        return identificacion1;
    }

    public void setIdentificacion1(int identificacion1) {
        this.identificacion1 = identificacion1;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getCorreo1() {
        return correo1;
    }

    public void setCorreo1(String correo1) {
        this.correo1 = correo1;
    }

    public int getEdad1() {
        return edad1;
    }

    public void setEdad1(int edad1) {
        this.edad1 = edad1;
    }
    
           
}
