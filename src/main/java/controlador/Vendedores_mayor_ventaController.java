/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.IUVendedor_mayor_venta;

/**
 *
 * @author cristobal
 */
public class Vendedores_mayor_ventaController implements ActionListener{
    private IUVendedor_mayor_venta vista;
    
    public Vendedores_mayor_ventaController (IUVendedor_mayor_venta vista){
        this.vista = vista;
        
        this.vista.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
    }
    
}
