package modelo.dao;

import modelo.dto.Clientedto; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Clientedao {
    private Connection conectar;
   // private Clientedto cliente;
                
    public boolean create(Clientedto cliente) throws SQLException {
        boolean rowCreate=false;
        try {
            String sql = "INSERT INTO Clientes (identificacion,nombre,correo,edad) VALUES(?,?,?,?)";
            conectar = Conexion.conectar();
            
            PreparedStatement statement = (PreparedStatement) conectar.prepareStatement(sql);
            
            statement.setInt(1, cliente.getIdentificacion1());
            statement.setString(2, cliente.getNombre1());
            statement.setString(3, cliente.getCorreo1());
            statement.setInt(4, cliente.getEdad1());
            
            rowCreate = statement.executeUpdate() > 0;
            statement.close();
            Conexion.cerrarconexion();
            
        } catch (Exception e) {
            System.out.println("error create");
        }
        return rowCreate;
    }

    public Clientedto read(int identificacion) throws SQLException {
        Clientedto cliente = null;
        try {
            
            String sql = "SELECT * FROM Clientes WHERE identificacion1 = ?";
            conectar = Conexion.conectar();	
            
            PreparedStatement statement = (PreparedStatement) conectar.prepareStatement(sql);
            statement.setInt(1, identificacion);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                cliente = new Clientedto(resultSet.getInt("identificacion"), resultSet.getString("nombre"), 
                        resultSet.getString("correo"), resultSet.getInt("edad"));
            }

            resultSet.close();
            statement.close();
            Conexion.cerrarconexion();
        } catch (Exception e) {
            System.out.println("error read");
        }
        return cliente;
    }

    public boolean update(Clientedto cliente) throws SQLException {
        boolean rowUpdate = false;
        try {
            
            String sql = "UPDATE Clientes SET nombre1=?, correo1=?, edad1=? WHERE identificacion1=?";
            conectar = Conexion.conectar();
            PreparedStatement statement = conectar.prepareStatement(sql);
            
            statement.setString(1, cliente.getNombre1());
            statement.setString(2, cliente.getCorreo1());
            statement.setInt(3, cliente.getEdad1());
            statement.setInt(4, cliente.getIdentificacion1());
            
            rowUpdate = statement.executeUpdate() > 0;
            statement.close();
            Conexion.cerrarconexion();

        } catch (Exception e) {
            System.out.println("error update");
        }
        return rowUpdate;
    }

    public boolean delete(int identificacion)throws SQLException {
        boolean rowDelete = false;
        try {
            
            String sql = "DELETE FROM Clientes WHERE identificacion1=?";
            conectar = Conexion.conectar();

            PreparedStatement statement = conectar.prepareStatement(sql);
            statement.setInt(1, identificacion);

            rowDelete = statement.executeUpdate() > 0;
            
            statement.close();
            Conexion.cerrarconexion();

        } catch (Exception e) {
            System.out.println("error delete");
        }
        return rowDelete;
    } 

    public List<Clientedto> listaClientes() throws SQLException{
        List<Clientedto> listaClientes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Clientes";
            conectar = Conexion.conectar();
            
            Statement statement = (Statement) conectar.createStatement();
            ResultSet resulSet = statement.executeQuery(sql);

            while(resulSet.next()) {
                int identificacion1 = resulSet.getInt("identificacion");
                String nombre1 = resulSet.getString("nombre");
                String correo1 = resulSet.getString("correo");
                int edad1 = resulSet.getInt("edad");
                Clientedto cliente = new Clientedto(identificacion1,nombre1,correo1,edad1);
                listaClientes.add(cliente);
     
            }
            
                        
            statement.close();
            Conexion.cerrarconexion();

        } catch (Exception e) {
            System.out.println("error lista");
        }
        return listaClientes;
    }
}