/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.IUVentas_vendedores;

/**
 *
 * @author cristobal
 */
public class Vendedores_ventasController implements ActionListener{
    private IUVentas_vendedores vista;
    
    public Vendedores_ventasController (IUVentas_vendedores vista){
        this.vista = vista;
        
        this.vista.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
    }
    
}
