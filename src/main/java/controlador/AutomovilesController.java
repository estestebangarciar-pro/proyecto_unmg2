/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.List;
import java.sql.SQLException;
import vista.IUAutomoviles;
import modelo.dao.Automovilesdao;
import modelo.dto.Automovilesdto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author cristobal
 */
public class AutomovilesController implements ActionListener{
    private IUAutomoviles vista;
    private Automovilesdao modelo;
    private Automovilesdto automoviles;
    private DefaultTableModel modeloTable;
    
    public AutomovilesController(IUAutomoviles vista){
        
        this.vista = vista;
        
        this.modelo = new Automovilesdao();
        
        
        this.vista.guardar.addActionListener(this);
        this.vista.actualizar.addActionListener(this);
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
       if(ae.getSource().equals(this.vista.actualizar)){
           actualizar();
       }
       if(ae.getSource().equals(this.vista.eliminar)){
           eliminar();
       }
       if(ae.getSource().equals(this.vista.consultar)){
           consultar();
       }
      // if(ae.getSource().equals(this.vista.consultar_todos)){
       //    consultar_todos();
      // }
    }
    
    public void guardar(){
            automoviles =new Automovilesdto();

            automoviles.setId_vehiculo(Integer.valueOf(this.vista.id_automovil.getText()));
            automoviles.setModelo(vista.modelo.getText());
            automoviles.setPrecio_base(Double.valueOf(this.vista.precio_base.getText()));
            automoviles.setColor(vista.color.getText());
            automoviles.setMarca(this.vista.marca.getSelectedItem().toString());
            automoviles.setTipo_motor(this.vista.tipo_motor.getSelectedItem().toString());

            if (modelo.create(automoviles) > 0){
                JOptionPane.showMessageDialog(null, "un nuevo automovil fue registrado");
            } else {
                JOptionPane.showInternalMessageDialog(null, "No se puede registrar el automovil");
            } 
}
    
    public void consultar(){
        automoviles = modelo.read(Integer.valueOf(vista.id_automovil.getText()));
        
        if(automoviles != null){
            vista.modelo.setText(automoviles.getModelo());
            vista.precio_base.setText(String.valueOf(automoviles.getPrecio_base()));
            vista.color.setText(automoviles.getColor());
            vista.marca.setSelectedItem(automoviles.getMarca());
            vista.tipo_motor.setSelectedItem(automoviles.getTipo_motor());
            
        }
    }
    
    public void actualizar(){
        int respuesta = JOptionPane.showConfirmDialog(null,"Estas seguro de actualizar", "Confirmar", JOptionPane.YES_NO_OPTION);
        if(respuesta == JOptionPane.YES_OPTION){
        if(modelo.update(automoviles) > 0)
            JOptionPane.showMessageDialog(null, "El automovil fue modificado");
        else
            JOptionPane.showMessageDialog(null, "No se pudo modificar el automovil");
        }
        }
    public void eliminar(){
        int respuesta = JOptionPane.showConfirmDialog(null,"");
        if(respuesta == JOptionPane.YES_OPTION){
        if(modelo.delete(automoviles) > 0)
            JOptionPane.showMessageDialog(null, "El automovil fue eliminado");
        else
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el automovil");
        }
    }
}
