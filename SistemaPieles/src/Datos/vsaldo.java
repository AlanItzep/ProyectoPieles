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
public class vsaldo extends vcliente{

    private int idsaldo;
    private int idventa;
    private int idabono;
    private Double saldo;

    public vsaldo() {
    }

    public vsaldo(int idsaldo, int idventa, int idabono, Double saldo) {
        this.idsaldo = idsaldo;
        this.idventa = idventa;
        this.idabono = idabono;
        this.saldo = saldo;
    }

    public int getIdsaldo() {
        return idsaldo;
    }

    public void setIdsaldo(int idsaldo) {
        this.idsaldo = idsaldo;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdabono() {
        return idabono;
    }

    public void setIdabono(int idabono) {
        this.idabono = idabono;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

        
}
