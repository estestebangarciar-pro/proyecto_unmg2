/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.IUVentas_credito_concesionario;

/**
 *
 * @author cristobal
 */
public class Ventas_credito_concesionarioController implements ActionListener{
    private IUVentas_credito_concesionario vista;
    
    public Ventas_credito_concesionarioController(IUVentas_credito_concesionario vista){
        this.vista = vista;
                
        this.vista.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
    }
}

