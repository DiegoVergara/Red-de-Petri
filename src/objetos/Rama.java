/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.ArrayList;

/**
 *
 * @author Willy
 */
public class Rama {
    String transicion;
    int [] padre;
    int [] hijo;
    
    public Rama(int numPlazas) {
        padre = new int [numPlazas];                
        hijo = new int  [numPlazas];                
    }

    public void setTransicion(String nivel) {
        this.transicion = nivel;
    }

    public void setPadre(int[] padre) {
        this.padre = padre;
    }

    public void setHijo(int[] hijo) {
        this.hijo = hijo;
    }

    public String getTransicion() {
        return transicion;
    }

    public int[] getPadre() {
        return padre;
    }

    public int[] getHijo() {
        return hijo;
    }            
}
