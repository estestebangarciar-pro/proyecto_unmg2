/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import modelo.dto.Automovilesdto;
import javax.swing.JOptionPane;
import modelo.dao.Clientedao;
import modelo.dto.Clientedto;
import vista.IUCliente;

/**
 *
 * @author cristobal
 */
public class ClientesController implements ActionListener{
    private IUCliente vista;
    private Clientedao modelo;
    private Clientedto cliente;
    
    public ClientesController(IUCliente vista){
        
        this.vista = vista;
        
        this.modelo = new Clientedao();
        
        
        this.vista.guardar.addActionListener(this);
        this.vista.actualizar.addActionListener(this);
        this.vista.borrar.addActionListener(this);
        this.vista.consultar.addActionListener(this);
        this.vista.consultar_todos.addActionListener(this);
        
        this.vista.setVisible(true);
        
    }

    @Override

    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource().equals(this.vista.guardar)){
           guardar();
       }
       if(ae.getSource().equals(this.vista.actualizar)){
           actualizar();
       }
       if(ae.getSource().equals(this.vista.borrar)){
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
            cliente = new Clientedto();

            cliente.setIdentificacion(Integer.valueOf(this.vista.identificacion.getText()));
            cliente.setNombre(vista.nombre.getText());
            cliente.setCorreo(Double.valueOf(this.vista.correo.getText()));
            cliente.setEdad(vista.edad.getText());
            
           

            if (modelo.create(cliente) > 0){
                JOptionPane.showMessageDialog(null, "un nuevo automovil fue registrado");
            } else {
                JOptionPane.showInternalMessageDialog(null, "No se puede registrar el automovil");
            } 
}
    
    public void consultar(){
        cliente = modelo.read(Integer.valueOf(vista.identificacion.getText()));
        
        if(cliente != null){
            vista.identificacion.setText(String.valueOf(cliente.getIdentificacion()));
            vista.nombre.setText(String.valueOf(cliente.getNombre()));
            vista.correo.setText(cliente.getCorreo());
            vista.edad.setText(String.valueOf(cliente.getEdad()));


            
        }
    }
    
    public void actualizar(){
        int respuesta = JOptionPane.showConfirmDialog(null,"Estas seguro de actualizar", "Confirmar", JOptionPane.YES_NO_OPTION);
        if(respuesta == JOptionPane.YES_OPTION){
        if(modelo.update(cliente) > 0)
            JOptionPane.showMessageDialog(null, "El automovil fue modificado");
        else
            JOptionPane.showMessageDialog(null, "No se pudo modificar el automovil");
        }
        }
    public void eliminar(){
        int respuesta = JOptionPane.showConfirmDialog(null,"");
        if(respuesta == JOptionPane.YES_OPTION){
        if(modelo.delete(cliente) > 0)
            JOptionPane.showMessageDialog(null, "El automovil fue eliminado");
        else
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el automovil");
        }
    }

    private void consultar_todos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

