/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vventas;
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
public class fventas {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {
            "ID Ventas",
            "ID Cliente",
            "Cliente",
            "ID Empleado",
            "Empleado",
            "Total venta",
            "Fecha venta",
            "Tipo pago",
            "Estado"
        };
        
        String [] registro = new String [9];
        
            totalregistros = 0;
            modelo = new DefaultTableModel(null,titulos);
            
            sSQL = "select v.idventas, "
                    + "v.idcliente,(select nombre from persona where idpersona = v.idcliente)as clienten, "
                    + "(select apellido from persona where idpersona = v.idcliente) as clienteap, "
                    + "v.idempleado,(select nombre from persona where idpersona = v.idempleado) as empleadon, "
                    + "(select apellido from persona where idpersona = v.idempleado) as empleadoap "
                    + "v.total_venta, v.fecha_venta, v.tipo_pago, v.estado "
                    + "from ventas v where clienten like '%"
                    + buscar+"%' order  by idventas desc";
            
            try{
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sSQL);
                
                while(rs.next()){
                    registro[0] = rs.getString("idventas");
                    registro[1] = rs.getString("idcliente");
                    registro[2] = rs.getString("idempleado");
                    registro[3] = rs.getString("total_venta");
                    registro[4] = rs.getString("fecha_venta");
                    registro[5] = rs.getString("tipo_pago");
                    registro[6] = rs.getString("estado");
                    
                    totalregistros = totalregistros +1;
                    modelo.addRow(registro);
                }
                return modelo;
            }catch(Exception e){
                JOptionPane.showConfirmDialog(null,e);
                return null;
            }
    }
    
    public boolean insertar (vventas dts){
        sSQL = "insert into ventas (idcliente, idempleado, total_venta, fecha_venta,tipo_pago,estado)"
                + "values(?,?,?,?,?,?)";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1,dts.getIdcliente());
            pst.setInt(2,dts.getIdempleado());
            pst.setDouble(3,dts.getTotal_venta());
            pst.setDate(4,dts.getFecha_venta());
            pst.setString(5,dts.getTipo_pago());
            pst.setString(6,dts.getEstado());
            
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
    
    public boolean editar(vventas dts){
        sSQL = "update ventas set idcliente=?, idempleado=?, total_venta=?, fecha_venta=?,tipo_pago=?,estado=? "
                + "where idventas=?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdcliente());
            pst.setInt(2, dts.getIdempleado());
            pst.setDouble(3, dts.getTotal_venta());
            pst.setDate(4, dts.getFecha_venta());
            pst.setString(5, dts.getTipo_pago());
            pst.setString(6, dts.getEstado());
            
            pst.setInt(7, dts.getIdventas());
            
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
    
    public boolean eliminar(vventas dts){
        sSQL = "delete from ventas where idventas = ?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdventas());
            
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
