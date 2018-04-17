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
    private int iddetalle_venta;
    private int idproducto;
    private int idventas;
    private Double medida;
    private Double subtotal;

    public vdetalleventa() {
    }

    public vdetalleventa(int iddetalle_venta, int idproducto, int idventas, Double medida, Double subtotal) {
        this.iddetalle_venta = iddetalle_venta;
        this.idproducto = idproducto;
        this.idventas = idventas;
        this.medida = medida;
        this.subtotal = subtotal;
    }

    public int getIddetalle_venta() {
        return iddetalle_venta;
    }

    public void setIddetalle_venta(int iddetalle_venta) {
        this.iddetalle_venta = iddetalle_venta;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getIdventas() {
        return idventas;
    }

    public void setIdventas(int idventas) {
        this.idventas = idventas;
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
