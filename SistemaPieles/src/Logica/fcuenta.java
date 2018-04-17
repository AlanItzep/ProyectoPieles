/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vcuenta;
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
public class fcuenta {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar (String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {
            "ID cliente",
            "Nombre",
            "Descripcion",
            "Cantidad",
            "Haber",
            "Debe",
            "Total"            
        };
        
        String [] registro = new String [7];
        
            totalregistros = 0;
            modelo = new DefaultTableModel(null,titulos);
            
            sSQL = "select c.idcliente, "
                    + "(select nombre from persona where idpersona = c.idcliente) as clienten,"
                    + "(select apellido from persona where idpersona = c.dicliente) as clienteap,"
                    + "c.descripcion, c.cantidad, c.haber, c.debe, c.total"
                    + "from cuenta c where c.clienten like '%"
                    + buscar + "%' order by idreserva desc";
            try{
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sSQL);
                
                while(rs.next()){
                    registro[0] = rs.getString("idcliente");
                    registro[1] = rs.getString("clienten")+" "+rs.getString("clienteap");
                    registro[2] = rs.getString("descripcion");
                    registro[3] = rs.getString("cantidad");
                    registro[4] = rs.getString("haber");
                    registro[5] = rs.getString("debe");
                    registro[0] = rs.getString("total");
                    
                    totalregistros = totalregistros + 1;
                    modelo.addRow(registro);
                }
                return modelo;
            }catch(Exception e){
                JOptionPane.showConfirmDialog(null, e);
                return null;
            }
    }
    public boolean insertar (vcuenta dts){
        sSQL = "insert into cuenta (idcliente, descripcion,cantidad,haber,debe,total)"
                + "values(?,?,?,?,?,?)";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdcliente());
            pst.setString(2, dts.getDescripcion());
            pst.setString(3, dts.getCantidad());
            pst.setString(4, dts.getHaber());
            pst.setString(5, dts.getDebe());
            pst.setString(6, dts.getTotal());
            
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
    
    public boolean editar(vcuenta dts){
        sSQL = "update cuenta set idcliente=?, descripcion+?,cantidad=?,haber=?,debe=?,total=? "
                + "where idcliente = ?";
        
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdcliente());
            pst.setString(2, dts.getDescripcion());
            pst.setString(3, dts.getCantidad());
            pst.setString(4, dts.getHaber());
            pst.setString(5, dts.getDebe());
            pst.setString(6, dts.getTotal());
            
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
    
    public boolean eliminar(vcuenta dts){
        sSQL = "delete from cuenta where idcliente = ?";
        
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdcliente());
            
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
