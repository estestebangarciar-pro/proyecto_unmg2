/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.IUPrincipal;

/**
 *
 * @author esgar
 */
public class PincipalController implements ActionListener{
    private IUPrincipal vista;
    
    public PincipalController(IUPrincipal vista){
        this.vista = vista;

        this.vista.jMVentas.addActionListener(this);
        this.vista.jMFormasPago.addActionListener(this);
        
        this.vista.setVisible(true);
    }
            
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(this.vista.jMVentas)){
            VentasController ventasController = new  VentasController(new IUVentas());
        }
        
        
    }
    
}
