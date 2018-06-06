/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloPedidos;

import Miembros.Conexion;
import Miembros.Proveedor;
import Negocio.Pedido;
import Negocio.articulopedido;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lizet
 */
public class ManejadorPedidos {

    Conexion conpg;
    Connection conn;

    public ManejadorPedidos() {
        conpg = new Conexion();
        conn = conpg.postgresConn();
    }

    public boolean insertarpedido(Object obj) {
        boolean var = false;

        if (obj instanceof Pedido) {

            Pedido usutemp = new Pedido();
            usutemp = (Pedido) obj;
            String consultaSQL = "insert into pedido(codigo,fecha,cantidad,valor,iva,estado,valortotal,cedulaproveedor)"
                    + " values ("
                    + usutemp.getCodigo() + ",'" + usutemp.getFecha() + "',"
                    + usutemp.getCantidad() + "," + usutemp.getValor() + ",'"
                    + usutemp.getIva() + "','" + usutemp.getEstado() + "',"
                    + usutemp.getValor() + ",'" + usutemp.getProveedor() + "')";

            try {

                Statement st = conn.createStatement();
                st.executeUpdate(consultaSQL);
                JOptionPane.showMessageDialog(null, "pedido ingresado");
                System.out.println(st);
                var = true;
                return var;

            } catch (SQLException ex) {
                var = false;
                ex.printStackTrace();
                return var;

            }
        }

        return var;
    }

    public void insertararticulopedido(Object obj) {

        if (obj instanceof articulopedido) {

            articulopedido usutemp = new articulopedido();
            usutemp = (articulopedido) obj;
            String consultaSQL = "insert into articulopedido(id,codigo)"
                    + " values ("
                    + usutemp.getIdarticulo() + "," + usutemp.getCodigo() + ")";

            try {

                Statement st = conn.createStatement();
                st.executeUpdate(consultaSQL);

                System.out.println(st);

            } catch (SQLException ex) {

                ex.printStackTrace();

            }
        }

    }

    public Object consultarpedido() {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            Conexion pg = new Conexion();
            conn = pg.postgresConn();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT  count(codigo)\n"
                    + "from pedido\n"
                    + " ");
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;

    }

    public ResultSet consultarTodosm() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {

            Conexion pg = new Conexion();
            conn = pg.postgresConn();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * from producto");

        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);

        }
        return rs;
    }

    public Object consultarpedido(int id) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            Conexion pg = new Conexion();
            conn = pg.postgresConn();
            st = conn.createStatement();
            rs = st.executeQuery("select proveedor.nombre, \n"
                    + "  proveedor.apellido, \n"
                    + "  pedido.cedulaproveedor, \n"
                    + "  pedido.codigo, \n"
                    + "  pedido.fecha, \n"
                    + "  pedido.cantidad,\n"
                    + "  pedido.valor,\n"
                    + "  pedido.iva,\n"
                    + "  pedido.valortotal,\n"
                    + "  pedido.estado,\n"
                    + "  producto.nombre,\n"
                    + "  producto.id \n"
                    + "from proveedor\n"
                    + "join pedido on proveedor.cedula = pedido.cedulaproveedor\n"
                    + "join articulopedido on articulopedido.codigo = pedido.codigo\n"
                    + "join producto on producto.id = articulopedido.id\n"
                    + "where pedido.codigo=" + id + " ");
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;

    }

    public Object consultarpedidoModificar(int id) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            Conexion pg = new Conexion();
            conn = pg.postgresConn();
            st = conn.createStatement();
            rs = st.executeQuery("select codigo, \n"
                    + "  fecha, \n"
                    + "  cantidad, \n"
                    + "  cantidad, \n"
                    + "  valortotal, \n"
                    + "  estado\n"
                    + "from pedido\n"
                    + "where codigo=" + id + " ");
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;

    }
}
