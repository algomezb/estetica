/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author oscar
 */
public class ConstructorPedido {
    String codigo;
    String fecha;
    String cantidad;
    String valor;
    String iva;
    String estado;
    String valortotal;
    String proveedor;

    public ConstructorPedido() {}

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setValortotal(String valortotal) {
        this.valortotal = valortotal;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
    
    public String validar() {
        StringBuilder errors = new StringBuilder();
        if (this.codigo.isEmpty()) {
            errors.append("Código: No debe estar vacío");
            errors.append("\n");
        } else if (!this.codigo.matches("\\d+")) {
            errors.append("Codigo: Debe ser numérico");
            errors.append("\n");
        }
        if (this.fecha.isEmpty()) {
            errors.append("Fecha: No debe estar vacío");
            errors.append("\n");
        }
        if (this.cantidad.isEmpty()) {
            errors.append("Cantidad: No debe estar vacío");
            errors.append("\n");
        } else if (!this.cantidad.matches("\\d+")) {
            errors.append("Cantidad: Debe ser numérico");
            errors.append("\n");
        }
        if (this.valor.isEmpty()) {
            errors.append("Valor: No debe estar vacío");
            errors.append("\n");
        } else if (!this.valor.matches("\\d+")) {
            errors.append("Valor: Debe ser numérico");
            errors.append("\n");
        }
        if (this.valortotal.isEmpty()) {
            errors.append("Valor total: No debe estar vacío");
            errors.append("\n");
        } else if (!this.valortotal.matches("\\d+")) {
            errors.append("Valor Total: Debe ser numérico");
            errors.append("\n");
        }
        if (this.proveedor.isEmpty()) {
            errors.append("Proveedor: No debe estar vacío");
            errors.append("\n");
        }
        return errors.toString();
    }

    public Pedido construir() {
        return new Pedido(
            Integer.parseInt(this.codigo),
            this.fecha,
            Integer.parseInt(this.cantidad),
            Integer.parseInt(this.valor),
            this.iva,
            this.estado,
            Integer.parseInt(this.valortotal),
            Integer.parseInt(this.proveedor)
        );
    }
}
