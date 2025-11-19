/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;


import modelo.dto.Vendedores_ventasdto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
//import java.time.LocalDate;

/**
 *
 * @author esgar
 */
public class Vendedores_ventasdao {
    private Connection conexion;
    private Vendedores_ventasdto vendedores_ventas;
    
    public List<Vendedores_ventasdto> readAll(){
        try {
             List<Vendedores_ventasdto> listaVendedoresVentas = new ArrayList<>();
         
             conexion = Conexion.conectar();
             
             PreparedStatement statement = (PreparedStatement) conexion.prepareStatement("select ve.id_vendedor, ve.vendedor, v.factura, v.fecha_venta, v.total_pagar, v.id_vehiculo, v.id_cliente from venta v left join  vendedor ve on ve.id_vendedor = v.id_vendedor left join  automovil a on a.id_vehiculo = v.id_vehiculo left join cliente c on c.id_cliente = v.id_cliente");
             
             ResultSet resultSet = statement.executeQuery();
             
             Vendedores_ventasdto vendedores_ventas = new Vendedores_ventasdto();
             
             while (resultSet.next()) {
                vendedores_ventas.setId_vendedor(resultSet.getInt("id_vendedor")); 
                vendedores_ventas.setVendedor(resultSet.getString("vendedor"));
                vendedores_ventas.setFactura(resultSet.getInt("factura"));
                vendedores_ventas.setFecha_venta(resultSet.getObject("fecha_venta", java.time.LocalDate.class));
                vendedores_ventas.setTotal_pagar(resultSet.getDouble("total_pagar"));
                vendedores_ventas.setId_vehiculo(resultSet.getInt("id_vehiculo"));
                vendedores_ventas.setMarca(resultSet.getString("marca"));
                vendedores_ventas.setNombre(resultSet.getString("nombre"));
   
                listaVendedoresVentas.add(vendedores_ventas);
             }
             return listaVendedoresVentas;    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }        
    
}

