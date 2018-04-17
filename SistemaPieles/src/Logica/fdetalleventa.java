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
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {
            "ID",
            "ID Producto",
            "ID Ventas",
            "Medidas",
            "Subtotal"
        };
        
        String [] registro = new String[5];
        
            totalregistros = 0;
            modelo = new DefaultTableModel(null, titulos);
            
            sSQL = "select dv.iddetalle_venta, p.idproducto, v.idventas,"
                    + " dv.medidas, dv.subtotal form detalle_venta dv inner join producto p, ventas v "
                    + "on dv.iddetalle_venta = v.idventas where dv.iddetalle_venta like '%"
                    + buscar+"%' order by iddetalle_venta desc";
            try{
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sSQL);
                
                while(rs.next()){
                    registro[0] = rs.getString("iddetalle_venta");
                    registro[1] = rs.getString("idproducto");
                    registro[2] = rs.getString("idventas");
                    registro[3] = rs.getString("medidas");
                    registro[4] = rs.getString("subtotal");
                    
                    totalregistros = totalregistros + 1;
                    modelo.addRow(registro);
                }
                return modelo;
            }catch(Exception e){
                JOptionPane.showConfirmDialog(null, e);
                return null;
            }
    }
    
    public boolean insertar(vdetalleventa dts){
        sSQL = "insert into detalle_venta(iddetalle_venta,idproducto,idventas,medidas,subtotal) "
                + "values(?,?,?,?,?)";
        
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
