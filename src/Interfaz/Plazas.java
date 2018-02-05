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
public class Plazas extends JFrame {
    
    TableRowSorter<TableModel> sorter;
    // metodo para crear las tablas del vector de plazas
    public Plazas(ArrayList<Circulo> circulo, JTable jTablePlazas, int b ) {
        //título y tamaño
        super("Plazas");
	this.setSize(900,100);
        // se crea un vector columnas 
        Vector columnas = new Vector();
	
        columnas.add("P: {");
        
	for(Circulo c: circulo){//Llena la primera columna con las plazas del modelos
            columnas.add(c.getEtiqueta()); 
        }
        
       columnas.add("}");


	if(b==1){// si se desea imprimir en una ventana externa
            //Se crea un objeto JTable con las filas y columnas antes construidas.
            //Se crea un JScrollPane  al que se le añade la tabla y por último
            //el panel se añade un a contenedor para visualizarlo en un JFrame.
            JTable tbl = new JTable(null, columnas);
            tbl.setEnabled(false);
            tbl.setRowHeight(30);

            JScrollPane panel =new JScrollPane(tbl);
            TableColumn jtc = new TableColumn();
            tbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tbl.doLayout();

            for(int i=0; i<columnas.size();i++){
                jtc= tbl.getColumn(columnas.elementAt(i));
                jtc.setPreferredWidth(30);
            }

            this.getContentPane().add(panel);
            this.setVisible(true);
        }
        else if(b==0){//si se desea imprimir en una jTable establecida
             DefaultTableModel dftm = new DefaultTableModel(null, columnas);
            jTablePlazas.setModel(dftm);
            sorter = new TableRowSorter<TableModel>(dftm);
            jTablePlazas.setRowSorter(sorter);
            jTablePlazas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        }   
    }    
}
