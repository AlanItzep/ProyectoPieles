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
public class vcuenta {

    private int idcuenta;
    private int idventa;
    private String descripcion;
    private Double abono;
    private Date fechaabono;
    private Double saldo;

    public vcuenta() {
    }

    public vcuenta(int idcuenta, int idventa, String descripcion, Double abono, Date fechaabono, Double saldo) {
        this.idcuenta = idcuenta;
        this.idventa = idventa;
        this.descripcion = descripcion;
        this.abono = abono;
        this.fechaabono = fechaabono;
        this.saldo = saldo;
    }

    public int getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getAbono() {
        return abono;
    }

    public void setAbono(Double abono) {
        this.abono = abono;
    }

    public Date getFechaabono() {
        return fechaabono;
    }

    public void setFechaabono(Date fechaabono) {
        this.fechaabono = fechaabono;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

}
