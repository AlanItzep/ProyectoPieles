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
    public Double totalmedida;
    
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {
            "ID detalle venta",//0
            "ID Cliente",//1
            "Cliente",
            "ID Empleado",//3
            "Empleado",
            "ID Producto",//5
            "Producto",
            "Precio venta",
            "Medida",
            "Sub total"
        };
        
        String [] registro = new String [10];
        
            totalregistros = 0;
            totalconsumo = 0.0;
            totalmedida = 0.0;
            
            modelo = new DefaultTableModel(null,titulos);
            
            sSQL = "select d.iddetalleventa, d.idcliente,"
                    + "(select nombre from persona where idpersona = d.idcliente)as clienten, "
                    + "(select apellido from persona where idpersona = d.idcliente) as clienteap, "
                    + "d.idempleado,(select nombre from persona where idpersona = d.idempleado) as empleadon, "
                    + "(select apellido from persona where idpersona = d.idempleado) as empleadoap, "
                    + "d.idproducto,p.nombre, p.precioventa, d.medida, d.subtotal "
                    + "from detalleventa d inner join producto p on d.idproducto = p.idproducto "
                    + "where d.iddetalleventa like '%"
                    + buscar+"%' order  by iddetalleventa desc";
            
            try{
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sSQL);
                
                while(rs.next()){
                    registro[0] = rs.getString("iddetalleventa");
                    registro[1] = rs.getString("idcliente");
                    registro[2] = rs.getString("clienten")+" "+rs.getString("clienteap");
                    registro[3] = rs.getString("idempleado");
                    registro[4] = rs.getString("empleadon")+" "+rs.getString("empleadoap");
                    registro[5] = rs.getString("idproducto");
                    registro[6] = rs.getString("nombre");
                    registro[7] = rs.getString("precioventa");
                    registro[8] = rs.getString("medida");
                    registro[9] = rs.getString("subtotal");
                    
                    totalregistros = totalregistros +1;
                    totalconsumo = totalconsumo+(rs.getDouble("medida")*rs.getDouble("precioventa"));
                    totalmedida = totalmedida+(rs.getDouble("medida"));
                    
                    modelo.addRow(registro);
                }
                return modelo;
            }catch(Exception e){
                JOptionPane.showConfirmDialog(null,e);
                return null;
            }
    }
    
    public boolean insertar (vdetalleventa dts){
        sSQL = "insert into detalleventa (idcliente, idempleado, idproducto, medida,subtotal)"
                + "values(?,?,?,?,?)";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1,dts.getIdcliente());
            pst.setInt(2,dts.getIdempleado());
            pst.setInt(3,dts.getIdproducto());
            pst.setDouble(4,dts.getMedida());
            pst.setDouble(5,dts.getSubtotal());
            
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
    
    public boolean editar(vdetalleventa dts){
        sSQL = "update detalleventa set idcliente=?, idempleado=?, idproducto=?, medida=?,subtotal=? "
                + "where iddetalleventa=?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1,dts.getIdcliente());
            pst.setInt(2,dts.getIdempleado());
            pst.setInt(3,dts.getIdproducto());
            pst.setDouble(4,dts.getMedida());
            pst.setDouble(5,dts.getSubtotal());
            
            pst.setInt(6, dts.getIddetalleventa());
            
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
    
    public boolean eliminar(vdetalleventa dts){
        sSQL = "delete from detalleventa where iddetalleventa = ?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIddetalleventa());
            
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
    /*
    public boolean sumar(vdetalleventa dts){
        sSQL = "select sum(subtotal) as sumasubtotal from detalleventa";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }*/
    
    public boolean pagar(vdetalleventa dts){
    sSQL = "update vdetalleventa set estado='Pagado'"+
            " where idvdetalleventa=?";
    try{
        PreparedStatement pst = cn.prepareStatement(sSQL);
        
        pst.setInt(1, dts.getIddetalleventa());
        
        int n = pst.executeUpdate();
        
        if(n != 0){
            return true;
        }else{
            return false;
        }
    }catch(Exception e){
    JOptionPane.showConfirmDialog(null, e);
    return false;
    }
}

public boolean pendentear(vdetalleventa dts){
    sSQL = "update vdetalleventa set estado='Pendiente'"+
            " where idvdetalleventa=?";
    try{
        PreparedStatement pst = cn.prepareStatement(sSQL);
        
        pst.setInt(1, dts.getIddetalleventa());
        
        int n = pst.executeUpdate();
        
        if(n != 0){
            return true;
        }else{
            return false;
        }
    }catch(Exception e){
    JOptionPane.showConfirmDialog(null, e);
    return false;
    }
}
}
