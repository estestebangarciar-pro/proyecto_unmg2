/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.IUconsulta_ventas;

/**
 *
 * @author cristobal
 */
public class Consultar_ventasController implements ActionListener{
    private IUconsulta_ventas vista;
    
    public Consultar_ventasController(IUconsulta_ventas vista){
        this.vista = vista;
                
        this.vista.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
    }
}
