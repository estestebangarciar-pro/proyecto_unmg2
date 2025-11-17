/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo.dao;

import Modelo.dto.Vendedor_mayor_ventadto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author danvall
 * 
 */
public class Vendedor_mayor_ventadao {
    
    private Connection conectar;

    // Método para obtener el vendedor con mayor total de ventas
    public Vendedor_mayor_ventadto obtenerMayorVendedor() throws SQLException {
        
        Vendedor_mayor_ventadto vendedor = null;

        try {
            String sql = "SELECT v.id_vendedor, ven.nombre, ven.profesion, SUM(v.totalventa) AS totalventa "
                       + "FROM venta v "
                       + "JOIN vendedor ven ON (v.id_vendedor = ven.id_vendedor) "
                       + "WHERE v.estado = 'A' "
                       + "GROUP BY v.id_vendedor, ven.nombre, ven.profesion "
                       + "ORDER BY totalventa DESC "
                       + "LIMIT 1";

            conectar = Conexion.conectar();
            PreparedStatement statement = conectar.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                vendedor = new Vendedor_mayor_ventadto();
                vendedor.setIdvendedor(resultSet.getInt("id_vendedor"));
                vendedor.setNombre(resultSet.getString("nombre"));
                vendedor.setProfesion(resultSet.getString("profesion"));
                vendedor.setTotalventa(resultSet.getDouble("totalventa"));
            }

            resultSet.close();
            statement.close();
            Conexion.cerrarconexion();

        } catch (Exception e) {
            System.out.println("error obtener Mayor "
                    + "Vendedor");
        }

        return vendedor;
    }
}