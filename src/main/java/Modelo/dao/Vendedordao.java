package modelo.dao;

import Modelo.dto.Vendedordto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Vendedordao {

    private Connection conectar;

    // CREATE
    public boolean create(Vendedordto vendedor) throws SQLException {
        boolean rowCreate = false;
        try {
            String sql = "INSERT INTO Marcas (jidenti, jjnombre, jProfesio) VALUES (?, ?, ?)";
            conectar = Conexion.conectar();

            PreparedStatement statement = conectar.prepareStatement(sql);
            statement.setInt(1, vendedor.getJidenti());
            statement.setString(2, vendedor.getJjnombre());
            statement.setString(3, vendedor.getjProfesio());

            rowCreate = statement.executeUpdate() > 0;

            statement.close();
            Conexion.cerrarconexion();

        } catch (Exception e) {
            System.out.println("error create: " + e.getMessage());
        }
        return rowCreate;
    }

    // READ
    public Vendedordto read(int identificacion) throws SQLException {
        Vendedordto vendedor = null;

        try {
            String sql = "SELECT * FROM Marcas WHERE jidenti = ?";
            conectar = Conexion.conectar();

            PreparedStatement statement = conectar.prepareStatement(sql);
            statement.setInt(1, identificacion);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                vendedor = new Vendedordto(
                    resultSet.getInt("jidenti"),
                    resultSet.getString("jjnombre"),
                    resultSet.getString("jProfesio")
                );
            }

            resultSet.close();
            statement.close();
            Conexion.cerrarconexion();

        } catch (Exception e) {
            System.out.println("error read: " + e.getMessage());
        }

        return vendedor;
    }

    // UPDATE
    public boolean update(Vendedordto vendedor) throws SQLException {
        boolean rowUpdate = false;

        try {
            String sql = "UPDATE Marcas SET jjnombre = ?, jProfesio = ? WHERE jidenti = ?";
            conectar = Conexion.conectar();

            PreparedStatement statement = conectar.prepareStatement(sql);
            statement.setString(1, vendedor.getJjnombre());
            statement.setString(2, vendedor.getjProfesio());
            statement.setInt(3, vendedor.getJidenti());

            rowUpdate = statement.executeUpdate() > 0;

            statement.close();
            Conexion.cerrarconexion();

        } catch (Exception e) {
            System.out.println("error update: " + e.getMessage());
        }

        return rowUpdate;
    }

    // DELETE
    public boolean delete(int identificacion) throws SQLException {
        boolean rowDelete = false;

        try {
            String sql = "DELETE FROM Marcas WHERE jidenti = ?";
            conectar = Conexion.conectar();

            PreparedStatement statement = conectar.prepareStatement(sql);
            statement.setInt(1, identificacion);

            rowDelete = statement.executeUpdate() > 0;

            statement.close();
            Conexion.cerrarconexion();

        } catch (Exception e) {
            System.out.println("error delete: " + e.getMessage());
        }

        return rowDelete;
    }

    // LISTAR
    public List<Vendedordto> listarVendedores() throws SQLException {
        List<Vendedordto> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Marcas";
            conectar = Conexion.conectar();

            Statement statement = conectar.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Vendedordto vendedor = new Vendedordto(
                    resultSet.getInt("jidenti"),
                    resultSet.getString("jjnombre"),
                    resultSet.getString("jProfesio")
                );
                lista.add(vendedor);
            }

            resultSet.close();
            statement.close();
            Conexion.cerrarconexion();

        } catch (Exception e) {
            System.out.println("error listar: " + e.getMessage());
        }

        return lista;
    }
}