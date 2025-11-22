package controlador;

import Modelo.dto.Marcadto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dao.Marcadao;
import vista.IUMarca;
import java.util.List;
import java.awt.event.ActionListener;

public class MarcaController implements ActionListener{
    private IUMarca vista;
    private Marcadao modelo;
    private Marcadto marca;
    private DefaultTableModel modeloTable;
    
    public MarcaController(IUMarca vista){
        this.vista = vista;
        this.modelo = new Marcadao();
        
        this.vista.guardar.addActionListener(this);
        this.vista.eliminar.addActionListener(this);
        this.vista.consultar.addActionListener(this);
        this.vista.consultar_todos.addActionListener(this);
        
        modeloTable = (DefaultTableModel) this.vista.jTablaMarca.getModel();
    
        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
     
       if(ae.getSource().equals(this.vista.consultar_todos)){
       List<Marcadto> listaMarca = modelo.readAll();
        

//int filas = modeloTable.getRowCount();
           
            while (modeloTable.getRowCount() > 0) {
               modeloTable.removeRow(0);
           }
           for(Marcadto marca : listaMarca){
               Object[] fila = {marca.getJidentificacion(),marca.getJmarca(), marca.getJfecha_grab()};
               modeloTable.addRow(fila);
           } 
       }
        
       if(ae.getSource().equals(this.vista.guardar)){
           guardar();
       }
       if(ae.getSource().equals(this.vista.eliminar)){
           eliminar();
       }
       if(ae.getSource().equals(this.vista.consultar)){
           consultar();
       }

    }
    
    public void guardar(){
        marca = new Marcadto();

        //marca.setJidentificacion(Integer.valueOf(this.vista.jidentificacion.getText()));
        marca.setJmarca(this.vista.jmarca1.getText());

        if (modelo.create(marca) > 0){
            JOptionPane.showMessageDialog(null, "Una nueva marca fue registrada");
        } else {
            JOptionPane.showInternalMessageDialog(null, "No se puede registrar la marca");
        } 
    }
    
    public void consultar(){
        marca = modelo.read(vista.jmarca1.getText());
        
        if(marca != null){
            vista.jidentificacion.setText(String.valueOf(marca.getJidentificacion()));
            vista.jConsultaMarca.setText(marca.getJmarca());
        }else {
        // 5. Manejo del fallo: Si el DAO retorna null (no existe o hubo error)
        JOptionPane.showMessageDialog(null, "La marca consultada no existe o no está activa.");
        }
    }
/*    
    public void actualizar(){
        int respuesta = JOptionPane.showConfirmDialog(null,"Estas seguro de actualizar", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if(respuesta == JOptionPane.YES_OPTION){
            if(modelo.update(marca) > 0)
                JOptionPane.showMessageDialog(null, "La marca fue modificada");
            else
                JOptionPane.showMessageDialog(null, "No se pudo modificar la marca");
        }
    }
*/    

    public void eliminar(){

        int respuesta = JOptionPane.showConfirmDialog(null,"¿Eliminar esta marca?");
        
        //marca = modelo.read(vista.jmarca1.getText());
        
        if(respuesta == JOptionPane.YES_OPTION){
            if(modelo.delete(marca) > 0)
                JOptionPane.showMessageDialog(null, "La marca fue eliminada");
            else
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la marca");
        }
    }
}
