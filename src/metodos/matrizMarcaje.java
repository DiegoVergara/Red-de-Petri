/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

/**
 *
 * @author Diego
 */
import java.util.ArrayList;
import objetos.Circulo;


/**
 *
 * @author Diego
 */
public class matrizMarcaje {
  
    
    public int[] matrizMarcaje(ArrayList<Circulo> circulo){
        int[] marcaje = new int[circulo.size()];
        int i = 0;
        for (Circulo c: circulo){
            marcaje[i] =  c.getNMarcas();
            i++;
        }        
        return marcaje;
    }
}