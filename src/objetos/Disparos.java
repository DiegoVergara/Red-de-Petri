/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author Diego
 */

//Objeto que representa los disparos que tiene cada transición
public class Disparos {
    String transicion;
    int disparos;

    public Disparos(String transicion, int disparos) {
        this.transicion = transicion;
        this.disparos = disparos;
    }

    public String getTransicion() {
        return transicion;
    }

    public int getDisparos() {
        return disparos;
    }

    public void setTransicion(String transicion) {
        this.transicion = transicion;
    }

    public void setDisparos(int disparos) {
        this.disparos = disparos;
    }
    
    
    
}
