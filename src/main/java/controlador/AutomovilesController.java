/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.IUAutomoviles;

/**
 *
 * @author cristobal
 */
public class AutomovilesController implements ActionListener{
    private IUAutomoviles vista;
    
    public AutomovilesController(IUAutomoviles vista){
        this.vista = vista;
        
        this.vista.setVisible(true);
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }

}
