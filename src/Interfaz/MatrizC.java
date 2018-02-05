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
public class MatrizC extends JFrame {
    
    TableRowSorter<TableModel> sorter;
    // metodo para crear las tablas de la matriz C
    public MatrizC(ArrayList<Circulo> circulo, ArrayList<Transicion> transicion ,ArrayList<Linea> linea, JTable jTableC, int b) {
        //título y tamaño
        super("Matriz C");
	this.setSize(500,500);
        // se crea un vector columnas 
        Vector columnas = new Vector();
        
        columnas.add("");
        
        for (Transicion t: transicion){ // se agregan encabezados
            columnas.add(t.getEtiqueta());
        }
        // se crea el vector fila para el almacenaje de las filas
        Vector filas = new Vector();
        for (Circulo c: circulo){ // se recorren las plazas
            Vector fila = new Vector(); // se crea un vector fila para el almacenaje de las restas
            fila.setSize(transicion.size()+1);
            fila.set(0, c.getEtiqueta());
            Vector filaPost = new Vector(); // vector Post para el almacenaje de la matriz post
            filaPost.setSize(transicion.size()+1);
            filaPost.set(0, c.getEtiqueta());
            
            Vector filaPre = new Vector();// vector Pre para el almacenaje de la matriz pre
            filaPre.setSize(transicion.size()+1);
            filaPre.set(0, c.getEtiqueta());  
            
            for(int i=1; i<filaPost.size();i++){ // se setean en cero
                filaPost.set(i, 0);
                filaPre.set(i, 0);
            }
            
             if(linea!=null){ // se recorren los arcos
                for(Linea l: linea){
                    if(l.getOrden1().equals("t") && l.getOrden2().equals("p")){ // si es post
                         if (l.getNombre2().equals(c.getEtiqueta())){
                             int i = indice(transicion,l.getNombre1()); // obtener indice de la transicion
                             filaPost.set(i, l.getPeso()); // almacenar en post
                         }                          
                    }
                    else if (l.getOrden1().equals("p") && l.getOrden2().equals("t")){ // si es pre
                            if (l.getNombre1().equals(c.getEtiqueta())){
                                int i = indice(transicion,l.getNombre2());// obtener indice de la transicion
                                filaPre.set(i, l.getPeso()); // almacenar en pre
                            }
                    } 
                }
             }
            for(int j=1; j<filaPost.size();j++){ // se recorre una de las matrices
                int num = (Integer.parseInt(filaPost.get(j).toString()) - Integer.parseInt(filaPre.get(j).toString())); // se realiza la resta
                fila.set(j,num);// se almacena en una fila
            }
            filas.add(fila); // se agrega a las filas
         
        }

        if (b==1){// si se desea imprimir en una ventana externa
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
            jTableC.setModel(dftm);
            sorter = new TableRowSorter<TableModel>(dftm);
            jTableC.setRowSorter(sorter);
            jTableC.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
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
