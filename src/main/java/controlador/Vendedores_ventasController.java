/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.sql.SQLException;
import vista.IUVentas_vendedores;
import modelo.dao.Vendedores_ventasdao;
import modelo.dto.Vendedores_ventasdto;
//import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cristobal
 */
public class Vendedores_ventasController implements ActionListener{
    private IUVentas_vendedores vista;
    private Vendedores_ventasdao modelo;
    private Vendedores_ventasdto vendedores_ventas;
    private DefaultTableModel modeloTable;
    
    
    public Vendedores_ventasController (IUVentas_vendedores vista){
        this.vista = vista;
        
        this.modelo = new Vendedores_ventasdao();
        
        this.vista.jbConsultar.addActionListener(this);
        
        modeloTable = (DefaultTableModel) this.vista.jtVentas_vendedores.getModel();
        this.vista.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(this.vista.jbConsultar)){
           List<Vendedores_ventasdto> lista = modelo.readAll();
        
           int filas = modeloTable.getRowCount();
           
           for(int i = 0; i < filas; i++){
           modeloTable.removeRow(0);
           }
           
           for(Vendedores_ventasdto vendedores_ventas : lista){
               Object[] fila = {vendedores_ventas.getId_vendedor(), vendedores_ventas.getVendedor(),vendedores_ventas.getFactura(), vendedores_ventas.getFecha_venta(), vendedores_ventas.getTotal_pagar(),vendedores_ventas.getId_vehiculo(), vendedores_ventas.getMarca(), vendedores_ventas.getNombre()};
               modeloTable.addRow(fila);
           }
        }
    }
    
}
