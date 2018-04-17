/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

/**
 *
 * @author Alan Itzep
 */
public class vventas {
    private int idventas;
    private int idcliente;
    private int idempleado;
    private Double total_venta;
    private Date fecha_venta;
    private String tipo_pago;
    private String estado;

    public vventas() {
    }

    public vventas(int idventas, int idcliente, int idempleado, Double total_venta, Date fecha_venta, String tipo_pago, String estado) {
        this.idventas = idventas;
        this.idcliente = idcliente;
        this.idempleado = idempleado;
        this.total_venta = total_venta;
        this.fecha_venta = fecha_venta;
        this.tipo_pago = tipo_pago;
        this.estado = estado;
    }

    public int getIdventas() {
        return idventas;
    }

    public void setIdventas(int idventas) {
        this.idventas = idventas;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public Double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(Double total_venta) {
        this.total_venta = total_venta;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }    
}
