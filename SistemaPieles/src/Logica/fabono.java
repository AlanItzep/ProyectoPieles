/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vabono;
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
public class fabono {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos ={
            "ID abono",
            "ID Cliente",
            "Descripcion",
            "Fecha Abono",
            "Abono"            
        };
        
        String [] registro = new String [5];
            
            modelo = new DefaultTableModel(null,titulos);
            sSQL = "select a.idabono,a.idcliente,a.descripcion,a.fechaabono,a.abono "
                    + "from abono a where a.idabono like'%"
                    + buscar+ "%' order by idabono desc";
            try{
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sSQL);
                
                while(rs.next()){
                    registro[0] = rs.getString("idcliente");
                    registro[1] = rs.getString("idabono");
                    registro[2] = rs.getString("descripcion");
                    registro[3] = rs.getString("abono");
                    registro[4] = rs.getString("fechaabono");
                    
                    modelo.addRow(registro);
                }
                
                return modelo;
            }catch(Exception e){
                JOptionPane.showConfirmDialog(null, e);
                return null;
            }
    }
    
    public boolean insertar (vabono dts){
        sSQL = "insert into abono (idcliente,descripcion, abono, fechaabono)"
                + "values(?,?,?,?)";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdcliente());
            pst.setString(1,dts.getDescripcion());
            pst.setDate(3,dts.getFechaabono());
            pst.setDouble(2,dts.getAbono());
            
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
    
    public boolean editar(vabono dts){
        sSQL = "update abono set idcliente=?,descripcion=?, fechaabono=?,abono=?  "
                + "where idabono = ?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1,dts.getDescripcion());
            pst.setInt(2,dts.getIdcliente());
            pst.setDate(3,dts.getFechaabono());
            pst.setDouble(4,dts.getAbono());
            
            pst.setInt(5,dts.getIdabono());
            
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
    
    public boolean eliminar(vabono dts){
        sSQL = "delete form abono where idabono = ?";
        
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1,dts.getIdabono());
            
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
