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
public class Automovilesdto implements Serializable {
    private int id_vehiculo;
    private String modelo;
    private double precio_base;
    private String color;
    private String marca;
    private String tipo_motor;
    private String vendido;          
/*
    public Automovilesdto (int id_vehiculo, String modelo, double precio_base, String color, String marca, String tipo_motor, String vendido){
        this.id_vehiculo = id_vehiculo;
        this.modelo = modelo;
        this.precio_base = precio_base;
        this.color = color;
        this.marca = marca;
        this.tipo_motor = tipo_motor;
        this.vendido = vendido;
    }
 */   
    public int getId_vehiculo(){
    return id_vehiculo;
    }
    
    public String getModelo(){
    return modelo;
    }
    
    public double getPrecio_base(){
    return precio_base;
    }
    
    public String getColor(){
    return color;
    }
    
    public String getMarca() {
    return marca;
    }
    
    public String getTipo_motor(){
    return tipo_motor;
    }
    
    public String getVendido() {
    return vendido;
    }
    
    /////seters
    public void setId_vehiculo(int id_vehiculo) {
    this.id_vehiculo = id_vehiculo;
    }   

    public void setModelo(String modelo) {
    this.modelo = modelo;
    }   

    public void setPrecio_base(Double precio_base) {
    this.precio_base = precio_base;
    }
    
    public void setColor(String color) {
    this.color = color;
    }  

    public void setMarca(String marca) {
    this.marca = marca;
    }  

    public void setTipo_motor(String tipo_motor) {
    this.tipo_motor = tipo_motor;
    }
    
    public void setVendido(String vendido) {
    this.vendido = vendido;
    }  
    
}
