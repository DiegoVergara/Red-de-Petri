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

// Objeto que representa las plazas del modelo
public class Circulo {
    int x, y;
    String etiqueta;
    int nmarcas;

    public Circulo() {
    }

    public Circulo(int x, int y, String etiqueta, int nmarcas) {
        this.x = x;
        this.y = y;
        this.etiqueta = etiqueta;
        this.nmarcas = nmarcas;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
     public int getNMarcas(){
         return nmarcas;
     }
    
     public void setNMarcas (int nmarcas){
         this.nmarcas = nmarcas;
     }
    
}
