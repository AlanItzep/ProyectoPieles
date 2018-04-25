/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

/**
 *
 * @author SONY
 */
public class vabono {
    private int idabono;
    private String descripcion;
    private Double abono;
    private Date fechaabono;

    public vabono() {
    }

    public vabono(int idabono, String descripcion, Double abono, Date fechaabono) {
        this.idabono = idabono;
        this.descripcion = descripcion;
        this.abono = abono;
        this.fechaabono = fechaabono;
    }

    public int getIdabono() {
        return idabono;
    }

    public void setIdabono(int idabono) {
        this.idabono = idabono;
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
    
    
}
