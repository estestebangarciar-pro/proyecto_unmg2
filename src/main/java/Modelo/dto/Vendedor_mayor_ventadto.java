/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo.dto;

import java.io.Serializable;
/**
 *
 * @author danvall
 * 
 */

public class Vendedor_mayor_ventadto implements Serializable {
    
    private int idvendedor;
    private String nombre;
    private String profesion;
    private double totalventa;
    

    public int getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(int idvendedor) {
        this.idvendedor = idvendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public double getTotalventa() {
        return totalventa;
    }

    public void setTotalventa(double totalventa) {
        this.totalventa = totalventa;
    }
   
}
