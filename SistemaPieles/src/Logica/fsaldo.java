/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vsaldo;
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
public class fsaldo {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar (String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {
            "ID saldo",
            "ID cliente",
            "Nombre Cliente",
            "Saldo",
            
            "ID abono",
            "Descripcion",
            "Abono",
            "Fecha Abono",
            
            "ID venta",
            "Total Medida",
            "Total venta",
        };
        
        String [] registro = new String [11];
        
            totalregistros = 0;
            modelo = new DefaultTableModel(null,titulos);
            
            sSQL = "select s.idsaldo, s.idcliente, "
                    + "(select nombre from persona where idpersona = s.idcliente) as clienten,"
                    + "(select apellido from persona where idpersona = s.idcliente) as clienteap,"
                    + "s.saldo,"
                    + "a.idabono,a.descripcion,a.abono,a.fechaabono, "
                    + "(select idventa from venta where idventa = s.idventa) as idventas,"
                    + "(select totalmedida from venta where idventa = s.idventa) as totalmedidas,"
                    + "(select totalventa from venta where idventa = s.idventa) as totalventas "
                    + "from saldo s inner join abono a on s.idabono = a.idabono "
                    + "where s.idabono like '%"
                    + buscar + "%' order by idabono desc";
            try{
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sSQL);
                
                while(rs.next()){
                    registro[0] = rs.getString("idsaldo");
                    registro[1] = rs.getString("idcliente");
                    registro[2] = rs.getString("clienten")+" "+rs.getString("clienteap");
                    registro[3] = rs.getString("saldo");
                    registro[4] = rs.getString("idabono");
                    registro[5] = rs.getString("descripcion");
                    registro[6] = rs.getString("abono");
                    registro[7] = rs.getString("fechaabono");
                    registro[8] = rs.getString("idventa");
                    registro[9] = rs.getString("totalmedida");
                    registro[10] = rs.getString("totalventa");
                   
                    totalregistros = totalregistros + 1;
                    modelo.addRow(registro);
                }
                return modelo;
            }catch(Exception e){
                JOptionPane.showConfirmDialog(null, e);
                return null;
            }
    }
    
    
    public boolean insertar (vsaldo dts){
        sSQL = "insert into cuenta (idventa, descripcion,abono,fechaabono,saldo)"
                + "values(?,?,?,?,?)";
        sSQL = "insert into cliente (idcuenta) "
                + "values (select idcuenta from cuenta orde by idpersona)";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);          
            pst.setInt(1, dts.getIdcuenta());
            pst.setInt(2, dts.getIdventa());
            pst.setString(3, dts.getDescripcion());
            pst.setDouble(4, dts.getAbono());
            pst.setDate(5, dts.getFechaabono());
            pst.setDouble(6, dts.getSaldo());
            
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
    
    public boolean editar(vsaldo dts){
        sSQL = "update cuenta set idcliente=?, descripcion+?,cantidad=?,haber=?,debe=?,total=? "
                + "where idcliente = ?";
        
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdcuenta());
            pst.setInt(2, dts.getIdventa());
            pst.setString(3, dts.getDescripcion());
            pst.setDouble(4, dts.getAbono());
            pst.setDate(5, dts.getFechaabono());
            pst.setDouble(6, dts.getSaldo());
            
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
    
    public boolean eliminar(vsaldo dts){
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
