/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import controlador.PrincipalController;
import vista.IUPrincipal;

/**
 *
 * @author esgar
 */
public class Principal {
    
    public static void main(String[] args){
    PrincipalController principalController =new PrincipalController(new IUPrincipal());
    }
    
}