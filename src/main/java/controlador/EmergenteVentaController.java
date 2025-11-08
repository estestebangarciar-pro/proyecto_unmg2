/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.IUEmergenteVenta;
import vista.IUVentas;

/**
 *
 * @author cristobal
 */
public class EmergenteVentaController implements ActionListener{
    private IUEmergenteVenta vista;
    
    public EmergenteVentaController(IUEmergenteVenta vista){
        this.vista = vista;
        
        this.vista.jsalir.addActionListener(this);
                
        this.vista.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource().equals(this.vista.jsalir)) {
            this.vista.setVisible(false);
            this.vista.dispose();
        //VentasController ventasController = new IUVentas();
        //new EmergenteVentaController(new IUEmergenteVenta());
        }
    }
}


