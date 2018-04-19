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
public class vdetalleventa {
    private int iddetalleventa;
    private int idcliente;
    private int idempleado;
    private int idproducto;
    private Double medida;
    private Double subtotal;

    public vdetalleventa() {
    }

    public vdetalleventa(int iddetalleventa, int idcliente, int idempleado, int idproducto, Double medida, Double subtotal) {
        this.iddetalleventa = iddetalleventa;
        this.idcliente = idcliente;
        this.idempleado = idempleado;
        this.idproducto = idproducto;
        this.medida = medida;
        this.subtotal = subtotal;
    }

    public int getIddetalleventa() {
        return iddetalleventa;
    }

    public void setIddetalleventa(int iddetalleventa) {
        this.iddetalleventa = iddetalleventa;
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

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public Double getMedida() {
        return medida;
    }

    public void setMedida(Double medida) {
        this.medida = medida;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}
