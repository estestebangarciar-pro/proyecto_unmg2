package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dao.Clientedao;
import modelo.dto.Clientedto;
import vista.IUCliente;

public class ClientesController implements ActionListener {

    private IUCliente vista;
    private Clientedao modelo;
    private DefaultTableModel modeloT;

    public ClientesController(IUCliente vista) {
        this.vista = vista;
        this.modelo = new Clientedao();

        
        this.vista.guardar.addActionListener(this);
        this.vista.actualizar.addActionListener(this);
        this.vista.borrar.addActionListener(this);
        this.vista.consultar.addActionListener(this);
        this.vista.consultar_todos.addActionListener(this);

        
        this.modeloT = (DefaultTableModel) this.vista.jtabla.getModel();

        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {

        
        if (evt.getSource().equals(vista.guardar)) {

            try {
                int id = Integer.parseInt(vista.identificacion.getText());
                String nombre = vista.nombre.getText();
                String correo = vista.correo.getText();
                int edad = Integer.parseInt(vista.edad.getText());

                Clientedto cliente = new Clientedto(id, nombre, correo, edad);

                if (modelo.create(cliente)) {
                    JOptionPane.showMessageDialog(null, "Cliente registrado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar cliente.");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Datos incorrectos");
            }
        }

        
        if (evt.getSource().equals(vista.consultar)) {
            try {
                int id = Integer.parseInt(vista.identificacion.getText());
                Clientedto cliente = modelo.read(id);

                if (cliente == null) {
                    JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                } else {
                    vista.nombre.setText(cliente.getNombre1());
                    vista.correo.setText(cliente.getCorreo1());
                    vista.edad.setText(String.valueOf(cliente.getEdad1()));
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al consultar.");
            }
        }

      
        if (evt.getSource().equals(vista.actualizar)) {

            try {
                int id = Integer.parseInt(vista.identificacion.getText());
                String nombre = vista.nombre.getText();
                String correo = vista.correo.getText();
                int edad = Integer.parseInt(vista.edad.getText());

                Clientedto cliente = new Clientedto(id, nombre, correo, edad);

                if (modelo.update(cliente)) {
                    JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar.");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al actualizar.");
            }
        }

       
        if (evt.getSource().equals(vista.borrar)) {

            try {
                int id = Integer.parseInt(vista.identificacion.getText());

                if (modelo.delete(id)) {
                    JOptionPane.showMessageDialog(null, "Cliente eliminado.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar.");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al eliminar.");
            }
        }

        
        if (evt.getSource().equals(vista.consultar_todos)) {

            try {
                List<Clientedto> lista = modelo.listaClientes();

                
                int filas = modeloT.getRowCount();
                for (int i = 0; i < filas; i++) {
                    modeloT.removeRow(0);
                }

                
                for (Clientedto cli : lista) {
                    Object[] fila = {
                        cli.getIdentificacion1(),
                        cli.getNombre1(),
                        cli.getCorreo1(),
                        cli.getEdad1()
                    };
                    modeloT.addRow(fila);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al listar clientes.");
            }
        }
    }
}