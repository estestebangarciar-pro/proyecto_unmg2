/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import modelo.dto.Automovilesdto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Automovilesdao{
    private Connection conexion;
    private Automovilesdto automovil;

/**
 *
 * @author esgar
 */

    public int create(Automovilesdto automovil) {
        try{
        conexion = Conexion.conectar();
        PreparedStatement statement = conexion.prepareStatement("Insert into automovil (id_vehiculo, id_marca, modelo, precio, id_tipo_motor, color, vendido) values (?,?,?,?,?,?,?)");

        statement.setInt(1, automovil.getId_vehiculo());
        statement.setString(2,automovil.getMarca());
        statement.setString(3, automovil.getModelo());
        statement.setDouble(4, automovil.getPrecio_base());
        statement.setString(5, automovil.getTipo_motor());
        statement.setString(6, automovil.getColor());
        statement.setString(7,automovil.getVendido());

        return statement.executeUpdate();


            } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, 0);
                return 0;
            }
    }

    public Automovilesdto read(int id_vehiculo){
        try {
            conexion = Conexion.conectar();
            PreparedStatement statement = (PreparedStatement) conexion.prepareStatement("SELECT * FROM automovil where id_vehiculo = ? and estado = 'A'");

            statement.setInt(1, id_vehiculo);

            ResultSet resultSet = statement.executeQuery();

            automovil = new Automovilesdto();

            if (resultSet.next()) {
                automovil.setId_vehiculo(resultSet.getInt("id_vehiculo")); 
                automovil.setModelo(resultSet.getString("modelo"));
                automovil.setPrecio_base(resultSet.getDouble("precio_base"));
                automovil.setColor(resultSet.getString("color"));
                automovil.setMarca(resultSet.getString("marca"));
                automovil.setTipo_motor(resultSet.getString("tipo_motor"));
                automovil.setVendido(resultSet.getString("vendido"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe automovil");
                return null;
            }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, 0);
                return null;
            }
            return automovil;
    }

    public int update(Automovilesdto automovil){
        try{
            conexion = Conexion.conectar();
            PreparedStatement statement = (PreparedStatement) conexion.prepareStatement("UPDATE automovil SET id_vehiculo = ?, id_marca = ?, modelo = ?, precio = ?, id_tipo_motor = ?, color = ?, vendido = ? WHERE id_vehiculo =? and estado = 'A'");

            //statement.setInt(1, automovil.getId_vehiculo());
            statement.setString(2,automovil.getMarca());
            statement.setString(3, automovil.getModelo());
            statement.setDouble(4, automovil.getPrecio_base());
            statement.setString(5, automovil.getTipo_motor());
            statement.setString(6, automovil.getColor());
            statement.setString(7,automovil.getVendido());

            return statement.executeUpdate();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, 0);
                return 0;
            }
    }

    public int delete(Automovilesdto automovil){
        try{
            conexion = Conexion.conectar();
            PreparedStatement statement = (PreparedStatement) conexion.prepareStatement("DELETE FROM automovil WHERE id_vehiculo = ?");
            //Update automovil set estado = 'C' where id_vehiculo = ?
            statement.setInt(1, automovil.getId_vehiculo());
            return statement.executeUpdate();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, 0);
                return 0;
            } 
    }

    public List<Automovilesdto> readAll(){
        try {
             List<Automovilesdto> listaAutomovil = new ArrayList<>();
             
             conexion = Conexion.conectar();
             
             PreparedStatement statement = (PreparedStatement) conexion.prepareStatement("SELECT * FROM automovil where estado = 'A'");
             
             ResultSet resultSet = statement.executeQuery();
             
             Automovilesdto automovil = new Automovilesdto();
             
             while (resultSet.next()) {
                automovil.setId_vehiculo(resultSet.getInt("id_vehiculo")); 
                automovil.setModelo(resultSet.getString("modelo"));
                automovil.setPrecio_base(resultSet.getDouble("precio_base"));
                automovil.setColor(resultSet.getString("color"));
                automovil.setMarca(resultSet.getString("marca"));
                automovil.setTipo_motor(resultSet.getString("tipo_motor"));
                automovil.setVendido(resultSet.getString("vendido"));
                
                listaAutomovil.add(automovil);
             }
             return listaAutomovil;    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }        
}
/*
*/
