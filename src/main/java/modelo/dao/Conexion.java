/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author esgar
 */
public class Conexion {
    private static final String BASEDATOS = "consesionariodb";
    private static final String URL = "jdbc:postgresql://localhost:5432/consesionariodb";
    private static final String USER = "egrodriguez";
    private static final String PASSWORD = "J3FF3RV4LL3CR1ST";
    private static Connection conectar = null;
    
    public static Connection conectar(){
        try{
        Class.forName("org.postgresql.Driver");
        conectar = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        JOptionPane.showMessageDialog(null, "conexión exitosa");
        return conectar;
    }
    
    public static void cerrarconexion() {
        try{
            if (conectar != null && ! conectar.isClosed()){
            conectar.close();
            System.out.println("conexión cerrada exitosamente");
            }
        }catch(SQLException e){
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
    
    public static void main(String[] args){
        conectar();
    }
}
