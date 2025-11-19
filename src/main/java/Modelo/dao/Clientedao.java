/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.dto.Clientedto;

public class Clientedao{
    private Connection coneccion;
    private Clientedto Cliente;

/**
 *
 * @author esgar
 */

    public int create(Clientedto cliente) {
        try{
        coneccion = Conexion.conectar();
        PreparedStatement statement = coneccion.prepareStatement("Insert into automovil (id_vehiculo, id_marca, modelo, precio, id_tipo_motor, color, vendido) values (?,?,?,?,?,?,?)");

        statement.setInt(1, Cliente.getIdentificacion());
        statement.setString(2,Cliente.getNombre());
        statement.setString(3, Cliente.getCorreo());
        statement.setInt(4, (int) Cliente.geEdad());
        

        return statement.executeUpdate();


            } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, 0);
                return 0;
            }
    }

    public Clientedto read(int identificacion){
        try {
            coneccion = Conexion.conectar();
            PreparedStatement statement = (PreparedStatement) coneccion.prepareStatement("SELECT * FROM automovil where id_vehiculo = ? and estado = 'A'");

            statement.setInt(1, identificacion);

            ResultSet resultSet = statement.executeQuery();

            Cliente = new Clientedto();

            if (resultSet.next()) {
                Cliente.setIdentificacion(resultSet.getInt("identificacion")); 
                Cliente.setNombre(resultSet.getString("nombre"));
                Cliente.setCorreo(resultSet.getDouble("correo"));
                Cliente.setEdad(resultSet.getString("edad"));
                
            }else{
                JOptionPane.showMessageDialog(null, "No existe automovil");
                return null;
            }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, 0);
                return null;
            }
            return Cliente;
    }

    public int update(Clientedto cliente){
        try{
            coneccion = Conexion.conectar();
            PreparedStatement statement = (PreparedStatement) coneccion.prepareStatement("UPDATE automovil SET id_vehiculo = ?, id_marca = ?, modelo = ?, precio = ?, id_tipo_motor = ?, color = ?, vendido = ? WHERE id_vehiculo =? and estado = 'A'");

            statement.setInt(1, Cliente.getIdentificacion());
            statement.setString(2, Cliente.getNombre());
            statement.setString(3, Cliente.getCorreo());
            statement.setString(5, Cliente.getEdad());
            

            return statement.executeUpdate();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, 0);
                return 0;
            }
    }

    public int delete(Clientedto clientedto){
        try{
            coneccion = Conexion.conectar();
            PreparedStatement statement = (PreparedStatement) coneccion.prepareStatement("DELETE FROM automovil WHERE id_vehiculo = ?");
            //Update automovil set estado = 'C' where id_vehiculo = ?
            statement.setInt(1, Cliente.getIdenfificacion());
            return statement.executeUpdate();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, 0);
                return 0;
            } 
    }

    public List<Clientedto> readAll(){
        try {
             List<Clientedto> listaCliente = new ArrayList<>();
             
             coneccion = Conexion.conectar();
             
             PreparedStatement statement = (PreparedStatement) coneccion.prepareStatement("SELECT * FROM automovil where estado = 'A'");
             
             ResultSet resultSet = statement.executeQuery();
             
             Clientedto cliente = new Clientedto();
             
             while (resultSet.next()) {
                Cliente.setIdentificacion(resultSet.getInt("Identificacion")); 
                Cliente.setNombre(resultSet.getString("Nombre"));
                Cliente.setCorreo(resultSet.getDouble("correo"));
                Cliente.setEdad(resultSet.getString("color"));
                
                
                listaCliente.add(cliente);
             }
             return listaCliente;    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }        
}
/*
*/
