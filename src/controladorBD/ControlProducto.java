/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Producto;

/**
 *
 * @author Mauro
 */
public class ControlProducto {
    Conexion conpg;
    Connection conn;

    public ControlProducto() {
        conpg = new Conexion();
        conn=conpg.postgresConn();
    }
    
    public boolean insertar(){
        
        return true;
    }
    
    public Producto consultar(int id){
        Producto prod= new Producto();
        try{
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from producto where id="+id+";");

            while (rs.next()){
            prod=new Producto(rs.getInt("id"),rs.getString("nombre"),rs.getString("descripcion"),
                    rs.getString("fechavencimiento"),rs.getInt("cantidad"),rs.getInt("preciocompra"),
                    rs.getInt("precioventa"));
            }
        }catch(SQLException ex) {
            Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    return prod;
    }
    
    public boolean modificar(Producto prod){
        boolean res=false;
        String consultaSQL="update producto set id="+prod.getId()+",nombre='"+prod.getNombre()+
                "',descripcion='"+prod.getDescripcion()+"',fechavencimiento='"+prod.getFechaVencimiento()+
                "',cantidad="+prod.getCantidad()+",preciocompra="+prod.getPrecioCompra()+
                ",precioventa="+prod.getPrecioVenta()+"where id='"+prod.getId()+"';";
        try {    
            Statement st=conn.createStatement();
            st.executeUpdate(consultaSQL);
            res=true;
        }catch(SQLException ex) {
            res=false;
            Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public boolean modificarTodo(ArrayList<Producto> arrayProd){
        boolean res=true;
        int n=arrayProd.size();
        for (int i = 0; i < n; i++) {
            if (!modificar(arrayProd.get(i)))
                res=false;
        }
        return res;
    }
    
    public boolean eliminar(){
        return true;
    }
    
}
