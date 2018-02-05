/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
// importación de bibliotecas y objetos
import objetos.Circulo;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Diego
 */
public class Marcaje extends JFrame {
    
    TableRowSorter<TableModel> sorter;
    // metodo para crear las tablas de marcaje
    public Marcaje(ArrayList<Circulo> circulo, JTable jTableMar, int b) {
        //título y tamaño
        super("Marcaje");
	this.setSize(300,500);
        // se crea un vector columnas y se agregan encabezados
        Vector columnas = new Vector();
	
        columnas.add("Plaza");
        columnas.add("Marcaje");
        // se crea el vector fila para el almacenaje de las filas
        Vector filas = new Vector();
        for (Circulo c: circulo){ // se recorren las plazas
            Vector fila = new Vector(); // vector fila para el almacenaje de las marcas
            fila.setSize(2);
            fila.set(0, c.getEtiqueta()); // se almacena la etiqueta
            int aux = c.getNMarcas();
            if (aux == 0){ // si no hay marcaje, se almacena cero, de lo contrario se almacena el marcaje
                fila.set(1, 0);
            }
            else{
                fila.set(1, aux);
            }
 
            filas.add(fila);
        }
        
        if (b==1){ // si se desea imprimir en una ventana externa
            //Se crea un objeto JTable con las filas y columnas antes construidas.
            //Se crea un JScrollPane  al que se le añade la tabla y por último
            //el panel se añade un a contenedor para visualizarlo en un JFrame.
            JTable tbl = new JTable(filas, columnas);
            tbl.setEnabled(false);
            tbl.setRowHeight(30);

            JScrollPane panel =new JScrollPane(tbl);
            TableColumn jtc = new TableColumn();
            tbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tbl.doLayout();

            for(int i=0; i<columnas.size();i++){
                jtc= tbl.getColumn(columnas.elementAt(i));
                jtc.setPreferredWidth(50);
            }

            this.getContentPane().add(panel);
            this.setVisible(true);
        }
        else if(b==0){//si se desea imprimir en una jTable establecida
            // se crea un modelo de tabla
            DefaultTableModel dftm = new DefaultTableModel(filas, columnas);
            jTableMar.setModel(dftm);
            sorter = new TableRowSorter<TableModel>(dftm);
            jTableMar.setRowSorter(sorter);
            jTableMar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }     
    }    
}
