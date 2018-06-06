/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Miembros;

/**
 *
 * @author Lizet
 */
public class proveedor extends Usuarios{
    
    protected String nic;
    protected String tiempo;
    protected String estado;

   // public proveedor(int cedula, int codigo, String nombre, String apellido, int telefono, String dirección, String correo, String fechaNacimiento) {
        //super(cedula, codigo, nombre, apellido, telefono, dirección, correo, fechaNacimiento);
    //}

    public proveedor() {
    }

    public proveedor(String nic, String tiempo, String estado, int cedula, int codigo, String nombre, String apellido, int telefono, String dirección, String correo, String fechaNacimiento) {
        super(cedula, codigo, nombre, apellido, telefono, dirección, correo, fechaNacimiento);
        this.nic = nic;
        this.tiempo = tiempo;
        this.estado = estado;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
    
    
    
}
