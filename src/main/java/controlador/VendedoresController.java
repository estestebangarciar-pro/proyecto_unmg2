/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.IUVendedores;

/**
 *
 * @author cristobal
 */
public class VendedoresController implements ActionListener{
    private IUVendedores vista;
    
    public VendedoresController(IUVendedores vista){
        this.vista = vista;
        
        this.vista.setVisible(true);
    
    }
    

    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       
    }
    
    
}
