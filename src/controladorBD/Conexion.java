/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorBD;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author MaUrO
 */
public class Conexion {
  
    public Connection postgresConn()
    {
            try{
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://localhost:5432/ingenieria2";
                String user = "postgres";
                String password = "123";
                Connection con = DriverManager.getConnection(url,user,password);
                return con;
            }
            catch(Exception e){
                   System.out.println(e.getMessage());
            }
     return null;       
    }
}
