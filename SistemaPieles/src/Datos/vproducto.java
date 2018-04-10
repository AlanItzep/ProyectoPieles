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
public class vproducto {
    private int idproducto;
    private String nombre;
    private String descripcion;
    private Double precio_venta;
    private Double precio_costo;

    public vproducto(int idproducto, String nombre, String descripcion, Double precio_venta, Double precio_costo) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_venta = precio_venta;
        this.precio_costo = precio_costo;
    }

    public vproducto() {
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public Double getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(Double precio_costo) {
        this.precio_costo = precio_costo;
    }
    
    
}
