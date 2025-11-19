package modelo.dto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author esgar
 */
public class Vendedores_ventasdto implements Serializable{

    private int id_vendedor;
    private String vendedor;
    private int factura;
    private LocalDate fecha_venta;
    private double total_pagar;
    private int id_vehiculo;
    private String marca;
    private String nombre;
    
    public int getId_vendedor(){
    return id_vendedor;
    }
    
    public String getVendedor(){
    return vendedor;
    }
    
    public int getFactura(){
    return factura;
    }
    
    public LocalDate getFecha_venta(){
    return fecha_venta;
    }
    
    public double getTotal_pagar() {
    return total_pagar;
    }
    
    public int getId_vehiculo(){
    return id_vehiculo;
    }
    
    public String getMarca() {
    return marca;
    }
    public String getNombre() {
    return nombre;
    }
    
    public void setId_vendedor(int id_vendedor) {
    this.id_vendedor = id_vendedor;
    } 
    
    public void setVendedor(String vendedor) {
    this.vendedor = vendedor;
    } 
    
    public void setFactura(int factura) {
    this.factura = factura;
    }
    
    public void setFecha_venta(LocalDate fecha_venta) {
    this.fecha_venta = fecha_venta;
    }
    
    public void setTotal_pagar(double total_pagar) {
    this.total_pagar = total_pagar;
    }
    
    public void setId_vehiculo(int id_vehiculo) {
    this.id_vehiculo = id_vehiculo;
    }
    
    public void setMarca(String marca) {
    this.marca = marca;
    }
    
    public void setNombre(String nombre) {
    this.nombre = nombre;
    }
}
