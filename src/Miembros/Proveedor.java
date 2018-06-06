/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Miembros;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Lizet
 */
public class Proveedor extends Usuarios{
    
    protected String nic;
    protected String estado;

   // public proveedor(int cedula, int codigo, String nombre, String apellido, int telefono, String dirección, String correo, String fechaNacimiento) {
        //super(cedula, codigo, nombre, apellido, telefono, dirección, correo, fechaNacimiento);
    //}

    public Proveedor() {
    }

    public Proveedor(String nic, String estado, int cedula, int codigo, String nombre, String apellido, int telefono, String dirección, String correo) {
        super(cedula, codigo, nombre, apellido, telefono, dirección, correo,
                DateTimeFormatter.ofPattern("yyyy/MM/dd").format(LocalDate.now()));
        this.nic = nic;
        this.estado = estado;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
    
    
    
}
