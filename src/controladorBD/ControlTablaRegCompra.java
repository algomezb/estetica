/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorBD;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;

/**
 *
 * @author Mauro
 */
public class ControlTablaRegCompra {
    Conexion conpg;
    Connection conn;
    protected ControlProducto controlProd;

    public ControlTablaRegCompra() {
        conpg = new Conexion();
        conn=conpg.postgresConn();
        controlProd=new ControlProducto();
    }
    
    public void insertar(JTable tabla,Producto prod){
        DefaultTableModel dtm=(DefaultTableModel)tabla.getModel();
        String [] val=new String [6];
        val[0]="0";
        val[1]=String.valueOf(prod.getId());
        val[2]=prod.getNombre();
        val[3]=String.valueOf(prod.getPrecioCompra());
        val[4]=String.valueOf(prod.getPrecioVenta());
        val[5]=prod.getFechaVencimiento();
        
        dtm.addRow(val);
    }
    
    public void eliminar(JTable tabla,int posicion){
        DefaultTableModel dtm=(DefaultTableModel)tabla.getModel();
        dtm.removeRow(posicion);
    }
    
    public void modificar(JTable tabla,ArrayList<Producto> arrayProd){
        DefaultTableModel dtm =(DefaultTableModel)tabla.getModel();
        int n=dtm.getRowCount();
        String temp;
        
        for (int i = 0; i < n; i++) {
            temp = (String)dtm.getValueAt(i,0);
            arrayProd.get(i).addCantidad((int) Double.parseDouble(temp));
            temp = (String)dtm.getValueAt(i,3);
            arrayProd.get(i).setPrecioCompra((int) Double.parseDouble(temp));
            temp = (String)dtm.getValueAt(i,4);
            arrayProd.get(i).setPrecioVenta((int) Double.parseDouble(temp));
            temp = (String)dtm.getValueAt(i,5);
            arrayProd.get(i).setFechaVencimiento(temp);
        }
    }
}
