/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import Modelo.dto.Vendedoresdto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Vendedoresdao{
    private Connection conexion;
    private Vendedoresdto vendedores;
    

/**
 *
 * @author esgar
 */

    public int create(Vendedoresdto vendedores) {
        try{
        conexion = Conexion.conectar();
        PreparedStatement statement = conexion.prepareStatement("Insert into automovil (id_vehiculo, id_marca, modelo, precio, id_tipo_motor, color, vendido) values (?,?,?,?,?,?,?)");

        statement.setInt(1, vendedores.getJidenti());
        statement.setString(2,vendedores.getJjnombre());
        statement.setString(3, vendedores.getjprofesio());
        

        return statement.executeUpdate();


            } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, 0);
                return 0;
            }
    }

    public Vendedoresdto read(int jidentificacion){
        try {
            conexion = Conexion.conectar();
            PreparedStatement statement = (PreparedStatement) conexion.prepareStatement("SELECT * FROM automovil where id_vehiculo = ? and estado = 'A'");

            statement.setInt(1, jidentificacion);

            ResultSet resultSet = statement.executeQuery();

            vendedores = new Vendedoresdto();

            if (resultSet.next()) {
                vendedores.setJidenti(resultSet.getInt("identificacion"));
                vendedores.setJjnombre(resultSet.getString("nombre"));
                vendedores.setjprofesio(resultSet.getString("profesion"));

            }else{
                JOptionPane.showMessageDialog(null, "No existe automovil");
                return null;
            }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, 0);
                return null;
            }
            return vendedores;
    }

    public int update(Vendedoresdto vendedores){
        try{
            conexion = Conexion.conectar();
            PreparedStatement statement = (PreparedStatement) conexion.prepareStatement("UPDATE automovil SET id_vehiculo = ?, id_marca = ?, modelo = ?, precio = ?, id_tipo_motor = ?, color = ?, vendido = ? WHERE id_vehiculo =? and estado = 'A'");

            statement.setString(1, vendedores.getJjnombre());
            statement.setString(2, vendedores.getjprofesio());
            statement.setInt(3, vendedores.getJidenti());



            return statement.executeUpdate();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, 0);
                return 0;
            }
    }

    public int delete(Vendedoresdto vendedores){
        try{
            conexion = Conexion.conectar();
            PreparedStatement statement = (PreparedStatement) conexion.prepareStatement("DELETE FROM automovil WHERE id_vehiculo = ?");
            //Update automovil set estado = 'C' where id_vehiculo = ?
            statement.setInt(1, vendedores.getJidenti());
            return statement.executeUpdate();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, 0);
                return 0;
            } 
    }

     public List<Vendedoresdto> readAll() {
        try {
            List<Vendedoresdto> lista = new ArrayList<>();

            conexion = Conexion.conectar();
            PreparedStatement statement = conexion.prepareStatement(
                "SELECT * FROM vendedores"
            );
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Vendedoresdto tmp = new Vendedoresdto();
                tmp.setJidenti(resultSet.getInt("identificacion"));
                tmp.setJjnombre(resultSet.getString("nombre"));
                tmp.setjprofesio(resultSet.getString("profesion"));
                lista.add(tmp);
            }

            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}