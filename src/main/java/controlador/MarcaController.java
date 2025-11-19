package controlador;

import Modelo.dto.Marcadto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.dao.Marcadao;
import vista.IUMarca;

public class MarcaController implements ActionListener{
    private IUMarca vista;
    private Marcadao dao;
    private Marcadto marca;
    
    public MarcaController(IUMarca vista){
        this.vista = vista;
        this.dao = new Marcadao();
        
        this.vista.guardar.addActionListener(this);
        this.vista.eliminar.addActionListener(this);
        this.vista.consultar.addActionListener(this);
        this.vista.consultar_todos.addActionListener(this);
        
        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource().equals(this.vista.guardar)){
           guardar();
       }
       if(ae.getSource().equals(this.vista.eliminar)){
           eliminar();
       }
       if(ae.getSource().equals(this.vista.consultar)){
           consultar();
       }
       if(ae.getSource().equals(this.vista.consultar_todos)){
           consultar_todos();
       }
    }
    
    public void guardar(){
        marca = new Marcadto();

        marca.setJidentificacion(Integer.valueOf(this.vista.jidentificacion.getText()));
        marca.setJmarca(this.vista.jmarca.getText());

        if (dao.create(marca) > 0){
            JOptionPane.showMessageDialog(null, "Una nueva marca fue registrada");
        } else {
            JOptionPane.showInternalMessageDialog(null, "No se puede registrar la marca");
        } 
    }
    
    public void consultar(){
        marca = dao.read(Integer.valueOf(vista.jidentificacion.getText()));
        
        if(marca != null){
            vista.jidentificacion.setText(String.valueOf(marca.getJidentificacion()));
            vista.jmarca.setText(marca.getJmarca());
        }
    }
    
    public void actualizar(){
        int respuesta = JOptionPane.showConfirmDialog(null,"Estas seguro de actualizar", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if(respuesta == JOptionPane.YES_OPTION){
            if(dao.update(marca) > 0)
                JOptionPane.showMessageDialog(null, "La marca fue modificada");
            else
                JOptionPane.showMessageDialog(null, "No se pudo modificar la marca");
        }
    }
    
    public void eliminar(){
        int respuesta = JOptionPane.showConfirmDialog(null,"¿Eliminar esta marca?");
        
        if(respuesta == JOptionPane.YES_OPTION){
            if(dao.delete(marca) > 0)
                JOptionPane.showMessageDialog(null, "La marca fue eliminada");
            else
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la marca");
        }
    }

    private void consultar_todos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
