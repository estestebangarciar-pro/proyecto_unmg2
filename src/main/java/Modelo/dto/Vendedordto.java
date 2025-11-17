/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.dto;

/**
 *
 * @author cristobal
 */
public class Vendedordto {
    private int jidenti;
    private String jjnombre;
    private String jProfesio;
    
public Vendedordto(int jidenti, String jjnombre,String jProfesio ){
    this.jidenti = jidenti;
    this.jjnombre = jjnombre;
    this.jProfesio = jProfesio;
}     

    public int getJidenti() {
        return jidenti;
    }

    public void setJidenti(int jidenti) {
        this.jidenti = jidenti;
    }

    public String getJjnombre() {
        return jjnombre;
    }

    public void setJjnombre(String jjnombre) {
        this.jjnombre = jjnombre;
    }

    public String getjProfesio() {
        return jProfesio;
    }

    public void setjProfesio(String jProfesio) {
        this.jProfesio = jProfesio;
    }
    
    
          
    
}
