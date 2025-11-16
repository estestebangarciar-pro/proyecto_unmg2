/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import modelo.dto.Clientes;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author esgar
 */
public class ClientesDao {
    private Connection coneccion;
    private Clientes clientes;
    
public int create(Clientes clientes){
    try {
        coneccion = Conexion.conectar();
        PreparedStatment ps = conexion.preparedStatement ("INSERT INTO Clientes (identificacion, nombre, edad, correo) values (?,?,?,?)");
        
        ps.setInt(1, clientes.getIdentificacion());
        ps.setString(2, clientes.getNombre());
        ps.setInt(3, clientes.getEdad());
        ps.setString(4, clientes.getCorreo());
        
        return ps.excecuteUpdate();
        
    } catch (SQLException e){
    JOptionPane.showMessageDialog(null, e);
    return 0;
    }
}
    
}
