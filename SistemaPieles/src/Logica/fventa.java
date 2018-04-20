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
public class fventa {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {
            "ID venta",//0
            "ID detalle venta",//1
            "Cliente",
            "Total Venta",
            "Total Medida",
            "Fecha Venta",
            "Tipo Pago",
            "Estado",
        };
        
        String [] registro = new String[8 ];
        
            modelo = new DefaultTableModel(null, titulos);
            
            sSQL = "select v.idventa,v.iddetalleventa, "
                    + "(select clienten from detalleventa where iddetalleventa = v.iddetalleventa) as nombrec, "
                    + "v.totalventa,v.totalmedida,v.fechaventa,v.tipopago,v.estado, "
                    + "from venta v inner join producto p "
                    + "on d.idproducto = p.idproducto where d.idventas="
                    + buscar+" order by d.idventa desc";
            try{
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sSQL);
                
                while(rs.next()){
                    registro[0] = rs.getString("idventa");
                    registro[1] = rs.getString("iddetalleventa");
                    registro[2] = rs.getString("nombrec");
                    registro[3] = rs.getString("totalventa");
                    registro[4] = rs.getString("totalmedida");
                    registro[5] = rs.getString("fechaventa");
                    registro[6] = rs.getString("subtotal");
                    
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
        sSQL = "update detalle_venta set iddetalleventa=?,idproducto=?,idventas=?,medidas=?,subtotal=? "
                + "where iddetalleventa=?";
        
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
