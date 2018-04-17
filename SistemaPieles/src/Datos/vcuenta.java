/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Alan Itzep
 */
public class vcuenta {
    private int idcliente;
    private String descripcion;
    private String cantidad;
    private String haber;
    private String debe;
    private String total;

    public vcuenta() {
    }

    public vcuenta(int idcliente, String descripcion, String cantidad, String haber, String debe, String total) {
        this.idcliente = idcliente;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.haber = haber;
        this.debe = debe;
        this.total = total;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getHaber() {
        return haber;
    }

    public void setHaber(String haber) {
        this.haber = haber;
    }

    public String getDebe() {
        return debe;
    }

    public void setDebe(String debe) {
        this.debe = debe;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }    
}
