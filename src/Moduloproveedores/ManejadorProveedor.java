package Moduloproveedores;

import Miembros.Conexion;
import Miembros.Proveedor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lizet
 */
public class ManejadorProveedor {

    Conexion conpg;
    Connection conn;

    public ManejadorProveedor() {
        conpg = new Conexion();
        conn = conpg.postgresConn();
    }

    public boolean insertar(Object obj) {

        if (obj instanceof Proveedor) {

            Proveedor usutemp = new Proveedor();
            usutemp = (Proveedor) obj;
            String insertarSql
                    = "INSERT INTO proveedor "
                    + "(nic, cedula, codigo, nombre, apellido, telefono, direccion, correo, fechanac, estado)"
                    + "VALUES"
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try {
                if (this.existeProveedor(usutemp.getCedula())) {
                    return false;
                }
                PreparedStatement pst = conn.prepareStatement(insertarSql);
                pst.setString(1, usutemp.getNic());
                pst.setLong(2, Integer.parseInt(usutemp.getCedula()));
                pst.setLong(3, Long.parseLong(usutemp.getCodigo()));
                pst.setString(4, usutemp.getNombre());
                pst.setString(5, usutemp.getApellido());
                pst.setLong(6, Long.parseLong(usutemp.getTelefono()));
                pst.setString(7, usutemp.getDirección());
                pst.setString(8, usutemp.getCorreo());
                pst.setDate(9, new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(usutemp.getFechaNacimiento()).getTime()));
                pst.setString(10, usutemp.getEstado());
                pst.executeUpdate();
                System.out.println(pst);
                return true;

            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            } catch (ParseException ex) {
                ex.printStackTrace();
                return false;
            }
        }

        return false;
    }

    

    public Object modificar(Object obj) {
        if (obj instanceof Proveedor) {

            Proveedor usutemp = new Proveedor();
            usutemp = (Proveedor) obj;
            String modificarSql =
                    "UPDATE proveedor SET "
                    + "nic = ?, "
                    + "cedula = ?, "
                    + "codigo = ?, "
                    + "nombre = ?, "
                    + "apellido = ?, "
                    + "telefono = ?, "
                    + "direccion = ?, "
                    + "correo = ?, "
                    + "fechanac = ?, "
                    + "estado = ?"
                    + "WHERE cedula = ?";
            try {
                PreparedStatement pst = conn.prepareStatement(modificarSql);
                pst.setString(1, usutemp.getNic());
                pst.setLong(2, Integer.parseInt(usutemp.getCedula()));
                pst.setLong(3, Long.parseLong(usutemp.getCodigo()));
                pst.setString(4, usutemp.getNombre());
                pst.setString(5, usutemp.getApellido());
                pst.setLong(6, Long.parseLong(usutemp.getTelefono()));
                pst.setString(7, usutemp.getDirección());
                pst.setString(8, usutemp.getCorreo());
                pst.setDate(9, new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(usutemp.getFechaNacimiento()).getTime()));
                pst.setString(10, usutemp.getEstado());
                pst.setLong(11, Integer.parseInt(usutemp.getCedula()));
                pst.executeUpdate();
                System.out.println(pst);

            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        return null;

    }

    public boolean inhabilitar(String cedula, String estado) {
        
        String inhabilitarSql =
                "UPDATE pedido " + 
                "SET estado = ? " +
                "WHERE cedula = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(inhabilitarSql);
            pst.setString(1, estado);
            pst.setLong(2, Long.parseLong(cedula));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Proveedor Inhabilitado");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    
    public ResultSet consultar(String cedula) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String selectString
                = "SELECT "
                + "cedula, nombre, codigo, direccion, correo, fechanac,"
                + "tiempo, nic, telefono, apellido, estado "
                + "FROM proveedor "
                + "WHERE cedula = ?";

        try {
            Conexion pg = new Conexion();
            conn = pg.postgresConn();
            pst = conn.prepareStatement(selectString);
            pst.setLong(1, Long.parseLong(cedula));
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }

       return rs;

    }

    public boolean existeProveedor(String cedula) {
        ResultSet rs = this.consultar(cedula);
        try {
            return rs != null && rs.getFetchSize() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
