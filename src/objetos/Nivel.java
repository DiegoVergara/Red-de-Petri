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
public class Nivel {
    ArrayList<Rama> Niveles = new ArrayList();        
    
    public Nivel(){    
    }

    public ArrayList<Rama> getNivel() {
        return Niveles;
    }

    public void addNivel(Rama r) {
        this.Niveles.add(r);
    }    
    
    public void ClearNivel() {
        this.Niveles.clear();
    }    
    
    public int GetSize() {
        return this.Niveles.size();
    } 
    
}
