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
public class fcuenta {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar (String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {
            "ID cuenta",
            "ID venta",
            "Nombre Cliente",
            "Descripcion",
            "Total Medida",
            "Abono",
            "Fecha Abono",
            "Saldo",
            "Fecha Venta",
            "Total Inicial",
            "Estado"
        };
        
        String [] registro = new String [11];
        
            totalregistros = 0;
            modelo = new DefaultTableModel(null,titulos);
            
            sSQL = "select c.idcuenta, c.idventa, "
                    + "(select nombre from persona where idpersona = c.idcliente) as clienten,"
                    + "(select apellido from persona where idpersona = c.dicliente) as clienteap,"
                    + "c.descripcion, v.totalmedida, "
                    + "c.abono, c.fechaabono, c.saldo,"
                    + "v.fechaventa,v.totalventa,v.estado "
                    + "from cuenta c inner join ventas v on c.idventas = v.idventas "
                    + "where c.clienten like '%"
                    + buscar + "%' order by idreserva desc";
            try{
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sSQL);
                
                while(rs.next()){
                    registro[0] = rs.getString("idcuenta");
                    registro[1] = rs.getString("idventa");
                    registro[2] = rs.getString("clienten")+" "+rs.getString("clienteap");
                    registro[3] = rs.getString("descripcion");
                    registro[4] = rs.getString("totalmedida");
                    registro[5] = rs.getString("abono");
                    registro[6] = rs.getString("fechaabono");
                    registro[7] = rs.getString("saldo");
                    registro[8] = rs.getString("fechaventa");
                    registro[9] = rs.getString("totalventa");
                    registro[10] = rs.getString("estado");
                   
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
