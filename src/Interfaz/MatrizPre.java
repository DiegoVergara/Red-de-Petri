/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
// importación de bibliotecas y objetos
import objetos.Circulo;
import objetos.Transicion;
import objetos.Linea;
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
public class MatrizPre extends JFrame {
    TableRowSorter<TableModel> sorter;
    // metodo para crear las tablas de la matriz Pre
    public MatrizPre(ArrayList<Circulo> circulo, ArrayList<Transicion> transicion ,ArrayList<Linea> linea, JTable jTablePre, int b) {
        //título y tamaño
        super("Matriz Pre");
	this.setSize(900,500);
         // se crea un vector columnas 
        Vector columnas = new Vector();
        
        columnas.add("");
        
        for (Transicion t: transicion){ // se agragan los encabezados
            columnas.add(t.getEtiqueta());
        }
        // se crea el vector fila para el almacenaje de las filas
        Vector filas = new Vector();
        
        for (Circulo c: circulo){ // se recorren las plazas
            Vector fila = new Vector();// se crea un vector fila para el almacenaje de las restas
            fila.setSize(transicion.size()+1);
            fila.set(0, c.getEtiqueta());       
            
            for(int i=1; i<fila.size();i++){// se setea la fila en cero
                fila.set(i, 0);
            }
            
             if(linea!=null){
                for(Linea l: linea){//se recorren los arcos
                    if(l.getOrden1().equals("p") && l.getOrden2().equals("t")){ // mientras sea pre
                         if (l.getNombre1().equals(c.getEtiqueta())){
                             int j = indice(transicion,l.getNombre2()); // se obtiene el indice de la transicion
                             fila.set(j, l.getPeso()); // almacenar en post
                         }
                             
                    }
                }
             }
            
            filas.add(fila);// se agrega la fila a las filas
         
        }
        if(b==1){// si se desea imprimir en una ventana externa
            JTable tbl = new JTable(filas,columnas);
            tbl.setEnabled(false);
            tbl.setRowHeight(20);

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
            DefaultTableModel dftm = new DefaultTableModel(filas, columnas);
            jTablePre.setModel(dftm);
            sorter = new TableRowSorter<TableModel>(dftm);
            jTablePre.setRowSorter(sorter);
            jTablePre.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       }        

    }
    // metodo para obtener los indices en el arraylist transicion dado una transición
    public int indice(ArrayList<Transicion> transicion, String objetivo){
        int indice=1;
        for(Transicion t: transicion){
            if (objetivo.equals(t.getEtiqueta())){
                break;
            }
            indice++;
        }
        return indice;

    }
    
    
    
}
