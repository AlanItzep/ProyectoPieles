/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vinventario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SONY
 */
public class finventario {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        String [] titulos = {
            "ID Inventario",
            "ID Empleado",
            "Nombre",
            "ID Producto",
            "Producto",
            "Presentacion",
            "Fecha",
            "Cantidad",
            "Estado"
        };
        String [] registro = new String[9];
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "select i.idinventario, "
                + "i.idempleado,(select completo from persona where idpersona = i.idempleado) as empleado, "
                + "i.idproducto, (select nombre from producto where idproducto = i.idproducto) as producto, "
                + "i.presentacion, i.fecha,i.cantidad,i.estado from inventario i "
                + "order by i.idinventario desc ";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0] = rs.getString("idinventario");
                registro[1] = rs.getString("idempleado");
                registro[2] = rs.getString("empleado");
                registro[3] = rs.getString("idproducto");
                registro[4] = rs.getString("producto");
                registro[5] = rs.getString("presentacion");
                registro[6] = rs.getString("fecha");
                registro[7] = rs.getString("cantidad");
                registro[8] = rs.getString("estado");
                
                modelo.addRow(registro);
            }
            return modelo;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public boolean insertar (vinventario dts){
        sSQL = "insert into inventario (idempleado,idproducto,presentacion,fecha,cantidad,estado) "
                + "values (?,?,?,?,?,?)";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1,dts.getIdempleado());
            pst.setInt(2,dts.getIdproducto());
            pst.setString(3,dts.getPresentacion());
            pst.setDate(4, dts.getFecha());
            pst.setDouble(5,dts.getCantidad());
            pst.setString(6,dts.getEstado());
            
            int n = pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            return false;
        }
    }
    
    public boolean editar(vinventario dts){
        sSQL = "update inventario set idempleado=?,idproducto=?,presentacion=?,fecha=?,cantidad=?,estado=?"
                + "where idinventario=?";
        try{
            PreparedStatement pst =cn.prepareStatement(sSQL);
            pst.setInt(1,dts.getIdempleado());
            pst.setInt(2,dts.getIdproducto());
            pst.setString(3,dts.getPresentacion());
            pst.setDate(4, dts.getFecha());
            pst.setDouble(5,dts.getCantidad());
            pst.setString(6,dts.getEstado());
            
            pst.setInt(7,dts.getIdinventario());
            
            int n = pst.executeUpdate();
            if(n!=0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            return false;
        }
    }
    
    public boolean eliminar(vinventario dts){
        sSQL = "delete from inventario where idinventario = ?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1,dts.getIdinventario());
            
            int n = pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
}
