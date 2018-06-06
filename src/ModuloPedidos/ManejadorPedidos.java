/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloPedidos;

import Miembros.Conexion;
import Miembros.Proveedor;
import Negocio.Pedido;
import Negocio.ArticuloPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        if (obj instanceof ArticuloPedido) {

            ArticuloPedido usutemp = new ArticuloPedido();
            usutemp = (ArticuloPedido) obj;
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

    public Object modificarpedido(Pedido pedido) {

        String modificarSql
                = "UPDATE pedido SET "
                + "codigo = ?, "
                + "fecha = ?, "
                + "cantidad = ?, "
                + "valor = ?, "
                + "iva = ?, "
                + "valortotal = ?, "
                + "estado = ?, "
                + "cedulaproveedor = ? "
                + "WHERE codigo = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(modificarSql);
            pst.setInt(1, pedido.getCodigo());
            pst.setDate(2, new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(pedido.getFecha()).getTime()));
            pst.setInt(3, pedido.getCantidad());
            pst.setInt(4, pedido.getValor());
            pst.setString(5, pedido.getIva());
            pst.setInt(6, pedido.getValortotal());
            pst.setString(7, pedido.getEstado());
            pst.setInt(8, pedido.getProveedor());
            pst.setInt(9, pedido.getCodigo());
            pst.executeUpdate();
            System.out.println(pst);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(ManejadorPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    public boolean inhabilitarpedido(String codigo, String estado) {
        
        String inhabilitarSql =
                "UPDATE pedido " + 
                "SET estado = ? " +
                "WHERE codigo = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(inhabilitarSql);
            pst.setString(1, estado);
            pst.setInt(2, Integer.parseInt(codigo));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "pedido Inhabilitado");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
}
