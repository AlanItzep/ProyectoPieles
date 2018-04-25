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
public class vsaldo extends vabono{

    private int idsaldo;
    private int idcliente;
    private int idventa;
    private Double saldo;

    public vsaldo() {
    }

    public vsaldo(int idsaldo, int idcliente, int idventa, Double saldo) {
        this.idsaldo = idsaldo;
        this.idcliente = idcliente;
        this.idventa = idventa;
        this.saldo = saldo;
    }

    public int getIdsaldo() {
        return idsaldo;
    }

    public void setIdsaldo(int idsaldo) {
        this.idsaldo = idsaldo;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    
}
