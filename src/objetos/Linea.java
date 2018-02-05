/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

/**
 *
 * @author ramirodavid
 */

//Objeto que representa los arcos del modelo
public class Linea {
    int x1, y1, x2, y2, peso;
    String orden1, orden2, nombre1, nombre2;

    public Linea() {
    }

    public Linea(int x1, int y1, int x2, int y2, int peso, String orden1, String orden2, String nombre1, String nombre2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.peso = peso;
        this.orden1 = orden1;
        this.orden2 = orden2;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
    }

    public int getX1() {
        return x1;
    }
    

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getOrden1() {
        return orden1;
    }

    public void setOrden1(String orden1) {
        this.orden1 = orden1;
    }

    public String getOrden2() {
        return orden2;
    }

    public void setOrden2(String orden2) {
        this.orden2 = orden2;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    
    
}
