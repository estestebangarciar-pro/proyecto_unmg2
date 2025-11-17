package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.IUMarca;


public class MarcaController implements ActionListener {

    private IUMarca vista;

    public MarcaController(IUMarca vista){
        this.vista = vista;

        
        this.vista.guardar.addActionListener(this);
        this.vista.consultar.addActionListener(this);
        this.vista.eliminar.addActionListener(this);
        this.vista.consultar_todos.addActionListener(this);

        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae){

        
        if (ae.getSource().equals(this.vista.guardar)) {

            try {
                int idMarca = Integer.parseInt(this.vista.jidentificacion.getText());
                String marca = this.vista.jmarca.getText();

                if (marca.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El campo 'Marca' está vacío");
                    return;
                }

               
                JOptionPane.showMessageDialog(null, "Marca guardada correctamente");

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "La identificación debe ser numérica");
            }
        }

        
        if (ae.getSource().equals(this.vista.consultar)) {

            try {
                int idMarca = Integer.parseInt(this.vista.jidentificacion.getText());

                

                JOptionPane.showMessageDialog(null, "Consulta realizada (simulada)");

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar una identificación válida");
            }
        }

        
        if (ae.getSource().equals(this.vista.eliminar)) {

            try {
                int idMarca = Integer.parseInt(this.vista.jidentificacion.getText());

                

                JOptionPane.showMessageDialog(null, "Marca eliminada correctamente");

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar una identificación válida");
            }
        }

        
        if (ae.getSource().equals(this.vista.consultar_todos)) {

            

            JOptionPane.showMessageDialog(null, "Consulta general realizada (simulada)");
        }
    }
}