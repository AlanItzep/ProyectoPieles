/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vdetalleventa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alan Itzep
 */
public class fdetalleventa {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;
    public Double totalconsumo;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {
            "ID",
            "ID Producto",
            "ID Ventas",
            "Producto",
            "Medidas",
            "Precio venta",
            "Subtotal"
        };
        
        String [] registro = new String[7];
        
            totalregistros = 0;
            totalconsumo = 0.0;
            modelo = new DefaultTableModel(null, titulos);
            
            sSQL = "select d.iddetalle_venta, d.idproducto, d.idventas,p.nombre,"
                    + " d.medida,p.precio_venta, d.subtotal from detalle_venta d inner join producto p "
                    + "on d.idproducto = p.idproducto where d.idventas="
                    + buscar+" order by d.iddetalle_venta desc";
            try{
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sSQL);
                
                while(rs.next()){
                    registro[0] = rs.getString("iddetalle_venta");
                    registro[1] = rs.getString("idproducto");
                    registro[2] = rs.getString("idventas");
                    registro[3] = rs.getString("nombre");
                    registro[4] = rs.getString("medida");
                    registro[5] = rs.getString("precio_venta");
                    registro[6] = rs.getString("subtotal");
                    
                    totalregistros = totalregistros + 1;
                    //operacion total de la suma de subtotales
                    totalconsumo = totalconsumo+(rs.getDouble("medida")*rs.getDouble("precio_venta"));
                    modelo.addRow(registro);
                }
                return modelo;
            }catch(Exception e){
                JOptionPane.showConfirmDialog(null, e);
                return null;
            }
    }
    
    public boolean insertar(vdetalleventa dts){
        sSQL = "insert into detalle_venta(idproducto,idventas,medida,subtotal) "
                + "values(?,?,?,?)";
        
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdproducto());
            pst.setInt(2, dts.getIdventas());
            pst.setDouble(3, dts.getMedida());
            pst.setDouble(4, dts.getSubtotal());
            
            int n = pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean editar(vdetalleventa dts){
        sSQL = "update detalle_venta set iddetalle_venta=?,idproducto=?,idventas=?,medidas=?,subtotal=? "
                + "where iddetalle_venta=?";
        
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdproducto());
            pst.setInt(2, dts.getIdventas());
            pst.setDouble(3, dts.getMedida());
            pst.setDouble(4, dts.getSubtotal());
            
            pst.setInt(5, dts.getIddetalle_venta());
            
            int n = pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null,e);
            return false;
        }
    }
    
    public boolean eliminar(vdetalleventa dts){
        sSQL = "delete from vdetalleventa where iddetallevetna = ?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIddetalle_venta());
            
            int n = pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null,e);
            return false;
        }
    }
}
