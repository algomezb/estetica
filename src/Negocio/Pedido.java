/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Lizet
 */
public class Pedido {
    int codigo;
    String fecha;
    int cantidad;
    int valor;
    String iva;
    String estado;
    int valortotal;
    int proveedor;
         

    public Pedido() {
    }

    public Pedido(int codigo, String fecha, int cantidad, int valor, String iva, String estado, int valortotal, int proveedor) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.valor = valor;
        this.iva = iva;
        this.estado = estado;
        this.valortotal = valortotal;
        this.proveedor = proveedor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getValortotal() {
        return valortotal;
    }

    public void setValortotal(int valortotal) {
        this.valortotal = valortotal;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public String validar() {
        StringBuilder errors = new StringBuilder();
        if (this.codigo < 0) {
            errors.append("Código: No debe ser menor que cero");
            errors.append("\n");
        }
        if (this.fecha.isEmpty()) {
            errors.append(" No debe estar vacío");
            errors.append("\n");
        }
        if (this.cantidad < 0) {
            errors.append("Cantidad: No debe ser menor que cero");
            errors.append("\n");
        }
        if (this.valor < 0) {
            errors.append("Valor: No debe ser menor que cero");
            errors.append("\n");
        }
        if (this.iva.isEmpty()) {
            errors.append("IVA: No debe estar vacío");
            errors.append("\n");
        }
        if (this.estado.isEmpty()) {
            errors.append("Estado: No debe estar vacío");
            errors.append("\n");
        }
        if (this.valortotal < 0) {
            errors.append("Valor total: No debe ser menor que cero");
            errors.append("\n");
        }
        return errors.toString();
    }
}
