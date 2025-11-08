/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.IUAutomoviles;
import vista.IUPrincipal;
import vista.IUCliente;
import vista.IUMarca;
import vista.IUVentas;
import vista.IUVendedores;
import vista.IUVendedor_mayor_venta;
import vista.IUVentas_credito_concesionario;
import vista.IUVentas_vendedores;
import vista.IUconsulta_ventas;

/**
 *
 * @author cristobal
 */
public class PrincipalController implements ActionListener {
    
    private IUPrincipal vista;
    
    public PrincipalController(IUPrincipal vista) {
        this.vista = vista;
        
        this.vista.jautomoviles.addActionListener(this);
        this.vista.jcliente.addActionListener(this);
        
        this.vista.jmarca.addActionListener(this);
        
        this.vista.jvendedores.addActionListener(this);
        
        this.vista.jmayorventa.addActionListener(this);
        
        this.vista.jventass.addActionListener(this);
        
        this.vista.jcredito_concesionario.addActionListener(this);
        
        this.vista.jventasvende.addActionListener(this);
        
        this.vista.jconsultar_ventas.addActionListener(this);
        
        
        this.vista.jMSALIR.addActionListener(this);
        
        this.vista.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(this.vista.jautomoviles)) {
            new AutomovilesController(new IUAutomoviles());
        }
        if (ae.getSource().equals(this.vista.jcliente)) {
            new ClientesController(new IUCliente());
        }    
        if (ae.getSource().equals(this.vista.jmarca)) {
            new MarcaController(new IUMarca());
        }
        if (ae.getSource().equals(this.vista.jventass)) {
            new VentasController(new IUVentas());
        }
        if (ae.getSource().equals(this.vista.jvendedores)) {
            new VendedoresController(new IUVendedores());
        }
        if (ae.getSource().equals(this.vista.jmayorventa)) {
            new Vendedores_mayor_ventaController(new IUVendedor_mayor_venta());
        }
        if (ae.getSource().equals(this.vista.jcredito_concesionario)) {
            new Ventas_credito_concesionarioController(new IUVentas_credito_concesionario());
        }
        if (ae.getSource().equals(this.vista.jventasvende)) {
            new Vendedores_ventasController(new IUVentas_vendedores());
        }
        if (ae.getSource().equals(this.vista.jconsultar_ventas)) {
            new Consultar_ventasController(new IUconsulta_ventas());
        }

        if (ae.getSource().equals(this.vista.jMSALIR)) {
            System.exit(0);
        }
    }
}
