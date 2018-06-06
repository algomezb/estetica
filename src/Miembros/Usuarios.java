/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Miembros;

import java.util.ArrayList;

/**
 *
 * @author Lizet
 */
public class Usuarios {

    protected String cedula;
    protected String codigo;
    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected String dirección;
    protected String correo;
    protected String fechaNacimiento;

    public Usuarios() {
    }

    public Usuarios(String cedula, String codigo, String nombre, String apellido, String telefono, String dirección, String correo, String fechaNacimiento) {
        this.cedula = cedula;
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.dirección = dirección;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String validar() {
        ArrayList<String> errors = new ArrayList<String>();
        if (this.cedula.isEmpty()) {
            errors.add("Cedula: No debe estar vacío");
        }
        if (this.codigo.isEmpty()) {
            errors.add("Codigo: No debe estar vacío");
        }
        if (this.nombre.isEmpty()) {
            errors.add("Nombre: No debe estar vacío");
        }
        if (this.apellido.isEmpty()) {
            errors.add("Apellido: No debe estar vacío");
        }
        if (this.telefono.isEmpty()) {
            errors.add("Telefono: No debe estar vacío");
        }
        if (this.dirección.isEmpty()) {
            errors.add("Dirección: No debe estar vacío");
        }
        if (this.correo.isEmpty()) {
            errors.add("Correo: No debe estar vacío");
        }
        if (this.fechaNacimiento.isEmpty()) {
            errors.add("Fecha nacimiento: No debe estar vacío");
        }
        StringBuilder sb = new StringBuilder();
        for (String error : errors) {
            sb.append(error);
            sb.append('\n');
        }
        return sb.toString();
    }
}
