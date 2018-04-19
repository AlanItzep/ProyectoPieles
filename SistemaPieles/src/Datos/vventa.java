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
public class vventa {
    private int idventas;
    private int iddetalleventa;
    private Double totalventa;
    private Double totalmedida;
    private Date fechaventa;
    private String tipopago;
    private String estado;

    public vventa() {
    }

    public vventa(int idventas, int iddetalleventa, Double totalventa, Double totalmedida, Date fechaventa, String tipopago, String estado) {
        this.idventas = idventas;
        this.iddetalleventa = iddetalleventa;
        this.totalventa = totalventa;
        this.totalmedida = totalmedida;
        this.fechaventa = fechaventa;
        this.tipopago = tipopago;
        this.estado = estado;
    }

    public int getIdventas() {
        return idventas;
    }

    public void setIdventas(int idventas) {
        this.idventas = idventas;
    }

    public int getIddetalleventa() {
        return iddetalleventa;
    }

    public void setIddetalleventa(int iddetalleventa) {
        this.iddetalleventa = iddetalleventa;
    }

    public Double getTotalventa() {
        return totalventa;
    }

    public void setTotalventa(Double totalventa) {
        this.totalventa = totalventa;
    }

    public Double getTotalmedida() {
        return totalmedida;
    }

    public void setTotalmedida(Double totalmedida) {
        this.totalmedida = totalmedida;
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
