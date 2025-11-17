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

/**
 *
 * @author esgar
 */
public class Automovilesdao {
    private Connection conectar;
    private Automovilesdto automovil;
    
    public boolean create(Automovilesdto automovil) throws SQLException {
        boolean rowCreate = false;
        try {
            String sql = "Insert into automovil (id_vehiculo, id_marca, modelo, precio, id_tipo_motor, color, vendido) values (?,?,?,?,?,?,?)";
            conectar = Conexion.conectar();
            
            PreparedStatement statement = (PreparedStatement) conectar.prepareStatement(sql);
            
            statement.setInt(1, automovil.getId_vehiculo());
            statement.setString(2,automovil.getMarca());
            statement.setString(3, automovil.getModelo());
            statement.setDouble(4, automovil.getPrecio_base());
            statement.setString(5, automovil.getTipo_motor());
            statement.setString(6, automovil.getColor());
            statement.setString(7,automovil.getVendido());
            
            rowCreate = statement.executeUpdate() > 0;
            statement.close();
            Conexion.cerrarconexion(); 
        } catch (Exception e){
            System.out.println("error create");
        }
         return rowCreate;   
        }       
    
    public Automovilesdto read(int id_vehiculo) throws SQLException {
        Automovilesdto automovil = null;
        try {
            String sql = "SELECT * FROM automovil where id_vehiculo = ? and estado = 'A'";
            conectar = Conexion.conectar();
            
            PreparedStatement statement = (PreparedStatement) conectar.prepareStatement(sql);
            statement.setInt(1, id_vehiculo);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                automovil = new Automovilesdto(resultSet.getInt("id_vehiculo"), resultSet.getString("modelo"), 
                        resultSet.getDouble("precio_base"), resultSet.getString("color"), resultSet.getString("marca"),resultSet.getString("tipo_motor"),
                        resultSet.getString("vendido"));
            }
            
            resultSet.close();
            statement.close();
            Conexion.cerrarconexion();
        } catch (Exception e) {
            System.out.println("error read");
        }
        return automovil;
    }
    
       public boolean update(Automovilesdto automovil) throws SQLException {
        boolean rowUpdate = false;
        try {
            
            String sql = "UPDATE automovil SET id_vehiculo = ?, id_marca = ?, modelo = ?, precio = ?, id_tipo_motor = ?, color = ?, vendido = ? WHERE id_vehiculo =? and estado = 'A'";
            conectar = Conexion.conectar();
            PreparedStatement statement = conectar.prepareStatement(sql);
            
            statement.setInt(1, automovil.getId_vehiculo());
            statement.setString(2,automovil.getMarca());
            statement.setString(3, automovil.getModelo());
            statement.setDouble(4, automovil.getPrecio_base());
            statement.setString(5, automovil.getTipo_motor());
            statement.setString(6, automovil.getColor());
            statement.setString(7,automovil.getVendido());
            
            rowUpdate = statement.executeUpdate() > 0;
            statement.close();
            Conexion.cerrarconexion();

        } catch (Exception e) {
            System.out.println("error update");
        }
        return rowUpdate;
    }
    public boolean delete(int id_vehiculo)throws SQLException {
        boolean rowDelete = false;
        try {
            
            String sql = "DELETE FROM automovil WHERE id_vehiculo = ?";
            //Update automovil set estado = 'C' where id_vehiculo = ?
            conectar = Conexion.conectar();

            PreparedStatement statement = conectar.prepareStatement(sql);
            statement.setInt(1, id_vehiculo);

            rowDelete = statement.executeUpdate() > 0;
            
            statement.close();
            Conexion.cerrarconexion();

        } catch (Exception e) {
            System.out.println("error delete");
        }
        return rowDelete;
    }
    public List<Automovilesdto> listaAutomovil() throws SQLException{
        List<Automovilesdto> listaAutomovil = new ArrayList<>();
        try {
            String sql = "SELECT * FROM automovil where estado = 'A'";
            conectar = Conexion.conectar();
            
            Statement statement = (Statement) conectar.createStatement();
            ResultSet resulSet = statement.executeQuery(sql);

            while(resulSet.next()) {
                int id_vehiculo = resulSet.getInt("id_vehiculo");
                String modelo = resulSet.getString("modelo");
                double precio_base = resulSet.getDouble("precio_base");
                String color = resulSet.getString("color");
                String marca = resulSet.getString("marca");
                String tipo_motor = resulSet.getString("tipo_motor");
                String vendido = resulSet.getString("vendido");
                
                Automovilesdto automovil = new Automovilesdto(id_vehiculo,modelo,precio_base,color, marca, tipo_motor,vendido);
                
                listaAutomovil.add(automovil);
     
            }
            
                        
            statement.close();
            Conexion.cerrarconexion();

        } catch (Exception e) {
            System.out.println("error lista");
        }
        return listaAutomovil;
    }

}
