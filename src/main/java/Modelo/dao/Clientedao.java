package modelo.dao;

import modelo.dto.Clientes; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Clientedao {
    private Connection conectar;
                
    public boolean create(Clientes clientes) throws SQLException {
        boolean rowCreate=false;
        try {
            
            String sql = "INSERT INTO Clientes (identificacion1,nombre1,correo1,edad1) VALUES(?,?,?,?)";
            conectar = Conexion.conectar();
            
            PreparedStatement statement = conectar.prepareStatement(sql);
            
            statement.setInt(1, clientes.getIdentificacion1());
            statement.setString(2, clientes.getNombre1());
            statement.setString(3, clientes.getCorreo1());
            statement.setInt(4, clientes.getEdad1());
            
            rowCreate = statement.executeUpdate() > 0;
            statement.close();
            Conexion.desconectar();
            
        } catch (Exception e) {
            System.out.println("error create");
        }
        return rowCreate;
    }

    public Clientes read(int identificacion) throws SQLException {
        Clientes cliente = null;
        try {
            
            String sql = "SELECT * FROM Clientes WHERE identificacion1 = ?";
            conectar = Conexion.conectar();	
            
            PreparedStatement statement = conectar.prepareStatement(sql);
            statement.setInt(1, identificacion);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                cliente = new Clientes();
                cliente.setIdentificacion1(resultSet.getInt("identificacion1"));
                cliente.setNombre1(resultSet.getString("nombre1"));
                cliente.setCorreo1(resultSet.getString("correo1"));
                cliente.setEdad1(resultSet.getInt("edad1"));
            }

            resultSet.close();
            statement.close();
            Conexion.desconectar();
        } catch (Exception e) {
            System.out.println("error read");
        }
        return cliente;
    }

    public boolean update(Clientes clientes) throws SQLException {
        boolean rowUpdate = false;
        try {
            
            String sql = "UPDATE Clientes SET nombre1=?, correo1=?, edad1=? WHERE identificacion1=?";
            conectar = Conexion.conectar();

            PreparedStatement statement = conectar.prepareStatement(sql);
            
            statement.setString(1, clientes.getNombre1());
            statement.setString(2, clientes.getCorreo1());
            statement.setInt(3, clientes.getEdad1());
            statement.setInt(4, clientes.getIdentificacion1());
            
            rowUpdate = statement.executeUpdate() > 0;
            statement.close();
            Conexion.desconectar();

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
            Conexion.desconectar();

        } catch (Exception e) {
            System.out.println("error delete");
        }
        return rowDelete;
    } 

    public List<Clientes> listaClientes() throws SQLException{
        List<Clientes> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Clientes";
            conectar = Conexion.conectar();
            
            Statement statement = conectar.createStatement();
            ResultSet resulSet = statement.executeQuery(sql);

            while(resulSet.next()) {
                Clientes cliente = new Clientes();
                cliente.setIdentificacion1(resulSet.getInt("identificacion1"));
                cliente.setNombre1(resulSet.getString("nombre1"));
                cliente.setCorreo1(resulSet.getString("correo1"));
                cliente.setEdad1(resulSet.getInt("edad1"));

                lista.add(cliente);
            }
            statement.close();
            Conexion.desconectar();

        } catch (Exception e) {
            System.out.println("error lista");
        }
        return lista;
    }
}

    

