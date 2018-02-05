package Interfaz;

import java.awt.*;
import javax.swing.*;

public class PanelConFondo extends javax.swing.JPanel {
    String imagen;
    public PanelConFondo(String imagen,int  largo,int ancho) {
        initComponents();
        this.imagen=imagen;
        this.setSize(largo, ancho);
    }
    @Override
    public void paintComponent(Graphics g){
        Dimension tam= getSize();
        ImageIcon imagenFondo= new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/"+imagen)).getImage());
        g.drawImage(imagenFondo.getImage(), 0, 0,tam.width,tam.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(254, 254, 254));
        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(700, 1500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1496, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
