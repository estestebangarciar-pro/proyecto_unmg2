package modelo.dao;

import Modelo.dto.Marcadto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Marcadao {
    
    private Connection conectar;
    
   
    public boolean create(Marcadto marca) throws SQLException {
        boolean rowCreate = false;
        try {
            String sql = "INSERT INTO Marca (jidentificacion, jmarca) VALUES (?, ?)";
            conectar = Conexion.conectar();
            
            PreparedStatement statement = conectar.prepareStatement(sql);
            statement.setInt(1, marca.getJidentificacion());
            statement.setString(2, marca.getJmarca());
            
            rowCreate = statement.executeUpdate() > 0;
            
            statement.close();
            Conexion.desconectar();
        } catch (Exception e) {
            System.out.println("error create marca");
        }
        return rowCreate;
    }
    
    
    
    public Marcadto read(int identificacion) throws SQLException {
        Marcadto marca = null;
        
        try {
            String sql = "SELECT * FROM Marca WHERE jidentificacion = ?";
            conectar = Conexion.conectar();
            
            PreparedStatement statement = conectar.prepareStatement(sql);
            statement.setInt(1, identificacion);
            
            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                marca = new Marcadto();
                marca.setJidentificacion(result.getInt("jidentificacion"));
                marca.setJmarca(result.getString("jmarca"));
            }
            
            result.close();
            statement.close();
            Conexion.desconectar();
            
        } catch (Exception e) {
            System.out.println("error read marca");
        }
        
        return marca;
    }
    
    
   
    public boolean update(Marcadto marca) throws SQLException {
        boolean rowUpdate = false;
        
        try {
            String sql = "UPDATE Marca SET jmarca = ? WHERE jidentificacion = ?";
            conectar = Conexion.conectar();
            
            PreparedStatement statement = conectar.prepareStatement(sql);
            statement.setString(1, marca.getJmarca());
            statement.setInt(2, marca.getJidentificacion());
            
            rowUpdate = statement.executeUpdate() > 0;
            
            statement.close();
            Conexion.desconectar();
            
        } catch (Exception e) {
            System.out.println("error update marca");
        }
        
        return rowUpdate;
    }
    
    
   
    public boolean delete(int identificacion) throws SQLException {
        boolean rowDelete = false;
        
        try {
            String sql = "DELETE FROM Marca WHERE jidentificacion = ?";
            conectar = Conexion.conectar();
            
            PreparedStatement statement = conectar.prepareStatement(sql);
            statement.setInt(1, identificacion);
            
            rowDelete = statement.executeUpdate() > 0;
            
            statement.close();
            Conexion.desconectar();
            
        } catch (Exception e) {
            System.out.println("error delete marca");
        }
        
        return rowDelete;
    }
    
    
    
    public List<Marcadto> listaMarcas() throws SQLException {
        List<Marcadto> lista = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM Marca";
            conectar = Conexion.conectar();
            
            Statement statement = conectar.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while (result.next()) {
                Marcadto marca = new Marcadto();
                marca.setJidentificacion(result.getInt("jidentificacion"));
                marca.setJmarca(result.getString("jmarca"));
                
                lista.add(marca);
            }
            
            result.close();
            statement.close();
            Conexion.desconectar();
            
        } catch (Exception e) {
            System.out.println("error lista marcas");
        }
        
        return lista;
    }
}