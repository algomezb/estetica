package Moduloproveedores;

import Miembros.Conexion;
import Miembros.Proveedor;
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
public class ManejadorProveedor {

    Conexion conpg;
    Connection conn;

    public ManejadorProveedor() {
        conpg = new Conexion();
        conn = conpg.postgresConn();
    }

    public boolean insertar(Object obj) {
        boolean var = false;

        if (obj instanceof Proveedor) {

            Proveedor usutemp = new Proveedor();
            usutemp = (Proveedor) obj;
            String consultaSQL = "insert into proveedor(nic,cedula,codigo,nombre,apellido,telefono,direccion,correo,fechanac,estado)"
                    + " values ('"
                    + usutemp.getNic() + "',"
                    + usutemp.getCedula() + "," + usutemp.getCodigo() + ",'"
                    + usutemp.getNombre() + "','" + usutemp.getApellido() + "',"
                    + usutemp.getTelefono()+ ",'" + usutemp.getDirección() + "','"
                    + usutemp.getCorreo() + "','" + usutemp.getFechaNacimiento() + "','"
                    + usutemp.getEstado() + "')";

            try {

                Statement st = conn.createStatement();
                st.executeUpdate(consultaSQL);
                JOptionPane.showMessageDialog(null, "Proveedor ingresado");
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

    public Object consultar(int id) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            Conexion pg = new Conexion();
            conn = pg.postgresConn();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT  cedula,nombre,codigo,direccion,correo,fechanac,tiempo,nic,telefono,apellido,estado\n"
                    + "from proveedor\n"
                    + "where cedula=" + id + " ");
        } catch (SQLException ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;

    }

    public Object modificar(Object obj) {
        if (obj instanceof Proveedor) {

            Proveedor usutemp = new Proveedor();
            usutemp = (Proveedor) obj;
            String consultaSQL = "UPDATE proveedor SET nic = '" + usutemp.getNic()
                    + "',cedula = " + usutemp.getCedula()
                    + ",nombre = '" + usutemp.getNombre() 
                    +"',apellido = '" + usutemp.getApellido()
                    + "',codigo = " + usutemp.getCodigo()
                    + ",telefono = " + usutemp.getTelefono()
                    + ",direccion = '" + usutemp.getDirección()
                    + "',correo = '" + usutemp.getCorreo()
                    + "',fechanac = '" + usutemp.getFechaNacimiento()
                    + "',estado = '" + usutemp.getEstado()
                    + "' WHERE cedula = " + usutemp.getCedula() + " ;";
            try {
                Statement st = conn.createStatement();
                st.executeUpdate(consultaSQL);
                JOptionPane.showMessageDialog(null, "Proveedor Modificado");
                System.out.println(st);

            } catch (SQLException ex) {

                ex.printStackTrace();

            }
        }
        return null;

    }
    public boolean inhabilitar(int id, String Estado) {
        Connection conn = null;
        Statement st = null;
        
        try {

            Conexion pg = new Conexion();
            conn = pg.postgresConn();
            st = conn.createStatement();
            st.executeUpdate ("UPDATE proveedor SET estado = '" + Estado + "' WHERE cedula = " + id + " ;");
                    
             JOptionPane.showMessageDialog(null,"Proveedor Inhabilitado");
        } catch (SQLException ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    public ResultSet ValidarProveedor(int cedula) {
       Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            Conexion pg = new Conexion();
            conn = pg.postgresConn();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT  *\n"
                    + "from proveedor\n"
                    + "where cedula=" + cedula + " ");
        } catch (SQLException ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
 
    }
}
