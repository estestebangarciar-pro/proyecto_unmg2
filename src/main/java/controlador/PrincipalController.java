/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.IUAutomoviles;
import vista.IUPrincipal;

/**
 *
 * @author cristobal
 */
public class PrincipalController implements ActionListener{
    private IUPrincipal vista;
    
    public PrincipalController(IUPrincipal vista){
        this.vista = vista;
        
        this.vista.jautomoviles.addActionListener(this);
        
        this.vista.setVisible(true);
    
    
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(this.vista.jautomoviles)){
            AutomovilesController AutomovilesController = new AutomovilesController(new IUAutomoviles());
        
        
        }
        
    }

}    
