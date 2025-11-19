package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.dao.Vendedoresdao;
import Modelo.dto.Vendedoresdto;
import vista.IUVendedores;

public class VendedoresController implements ActionListener {
    private IUVendedores vista;
    private Vendedoresdao modelo;
    private Vendedoresdto vendedor;
    
    public VendedoresController(IUVendedores vista){
        
        this.vista = vista;
        
        this.modelo = new Vendedoresdao();
        
        this.vista.jGuardarm.addActionListener(this);
        this.vista.Jbconsultar.addActionListener(this);
        this.vista.jborrar.addActionListener(this);
        this.vista.consultar_todos.addActionListener(this);
        
        this.vista.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       
       if(ae.getSource().equals(this.vista.jGuardarm)){
           guardar();
       }
       if(ae.getSource().equals(this.vista.Jbconsultar)){
           consultar();
       }
       if(ae.getSource().equals(this.vista.jborrar)){
           eliminar();
       }
       if(ae.getSource().equals(this.vista.consultar_todos)){
           consultar_todos();
       }
    }
    
    public void guardar(){
        vendedor = new Vendedoresdto();

        vendedor.setJidenti(Integer.valueOf(this.vista.jidenti.getText()));
        vendedor.setJjnombre(vista.jjnombre.getText());
        vendedor.setjprofesio(vista.jProfesio.getText());

        if (modelo.create(vendedor) > 0){
            JOptionPane.showMessageDialog(null, "Nuevo vendedor registrado");
        } else {
            JOptionPane.showInternalMessageDialog(null, "No se pudo registrar el vendedor");
        } 
    }
    
    public void consultar(){
        vendedor = modelo.read(Integer.valueOf(vista.jidenti.getText()));
        
        if(vendedor != null){
            vista.jidenti.setText(String.valueOf(vendedor.getJidenti()));
            vista.jjnombre.setText(vendedor.getJjnombre());
            vista.jProfesio.setText(vendedor.getjprofesio());
        }
    }
    
    public void actualizar(){
        int respuesta = JOptionPane.showConfirmDialog(null,
                "¿Seguro que deseas actualizar?",
                "Confirmar", 
                JOptionPane.YES_NO_OPTION);
        
        if(respuesta == JOptionPane.YES_OPTION){
            
            if(modelo.update(vendedor) > 0)
                JOptionPane.showMessageDialog(null, "Vendedor modificado");
            else
                JOptionPane.showMessageDialog(null, "No se pudo modificar el vendedor");
        }
    }
    
    public void eliminar(){
        int respuesta = JOptionPane.showConfirmDialog(null, 
                "¿Seguro que deseas eliminar?");
        
        if(respuesta == JOptionPane.YES_OPTION){
            
            if(modelo.delete(vendedor) > 0)
                JOptionPane.showMessageDialog(null, "Vendedor eliminado");
            else
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el vendedor");
        }
    }

    private void consultar_todos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}