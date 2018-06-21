/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vdetalleventa;
import Datos.vventa;
import Logica.fdetalleventa;
import Logica.fventa;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alan Itzep
 */
public class frmventa extends javax.swing.JInternalFrame {
    

    
    /**
     * Creates new form frmdetalleventa
     */
    public frmventa() {
        initComponents();
        mostrar(idventa);
        this.setTitle("Detalle Venta");
        inhabilitar();
    }

    private String accion = "guardar";
    public static int idusuario;
    public static String idventa = "";  
    
    void ocultar_columnas() {
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(1).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(2).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(2).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(2).setPreferredWidth(0);
        //0,1,3,4,5
        tablaclientes.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaclientes.getColumnModel().getColumn(0).setMinWidth(0);
        tablaclientes.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        tablaclientes.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaclientes.getColumnModel().getColumn(1).setMinWidth(0);
        tablaclientes.getColumnModel().getColumn(1).setPreferredWidth(0);
        
        tablaclientes.getColumnModel().getColumn(3).setMaxWidth(0);
        tablaclientes.getColumnModel().getColumn(3).setMinWidth(0);
        tablaclientes.getColumnModel().getColumn(3).setPreferredWidth(0);
        
        tablaclientes.getColumnModel().getColumn(4).setMaxWidth(0);
        tablaclientes.getColumnModel().getColumn(4).setMinWidth(0);
        tablaclientes.getColumnModel().getColumn(4).setPreferredWidth(0);
        
        tablaclientes.getColumnModel().getColumn(6).setMaxWidth(0);
        tablaclientes.getColumnModel().getColumn(6).setMinWidth(0);
        tablaclientes.getColumnModel().getColumn(6).setPreferredWidth(0);
        
        tablaclientes.getColumnModel().getColumn(7).setMaxWidth(0);
        tablaclientes.getColumnModel().getColumn(7).setMinWidth(0);
        tablaclientes.getColumnModel().getColumn(7).setPreferredWidth(0);
        
        tablaclientes.getColumnModel().getColumn(8).setMaxWidth(0);
        tablaclientes.getColumnModel().getColumn(8).setMinWidth(0);
        tablaclientes.getColumnModel().getColumn(8).setPreferredWidth(0);
    }
        
    void inhabilitar() {
        txtidventa.setVisible(false);
        txtidcliente.setVisible(false);
        txtidempleado.setVisible(false);
        
        //Registro venta
        txtnombrecliente.setEnabled(false);
        txtnombreempleado.setEnabled(false);
        dcfechaventa.setEnabled(false);
        txttotalmedida.setEnabled(false);
        txttotalventa.setEnabled(false);
        cbotipopago.setEnabled(false);
        
        btnbuscarcliente.setEnabled(false);
                
        btnguardar.setEnabled(false);
        btncancelar.setEnabled(false);
        btneliminar.setEnabled(false);
        
        lblinstruccion.setVisible(false);
        
        btnsalir.setEnabled(true);
        
        //Ingreso productos
        txtiddetalleventa.setVisible(false);
        txtidventa2.setVisible(false);
        txtidproducto.setVisible(false);
        txtnombreproducto.setEnabled(false);
        txtmedida.setEnabled(false);
        txtprecioventa.setEnabled(false);
        txtsubtotal.setEnabled(false);
        
        btnguardarproducto.setEnabled(false);
        btnagregarproducto.setEnabled(false);
        btnbuscarproducto.setEnabled(false);

        txtidventa.setText("");
        txtidcliente.setText("");
        txtidproducto.setText("");
        
        txtnombrecliente.setText("");
        txttotalmedida.setText("");
        txttotalventa.setText("");
        
        txtnombreproducto.setText("");
        txtprecioventa.setText("");
        txtmedida.setText("");
        txtsubtotal.setText("");
    }
    void habilitar() {//registroventa
        txtidventa.setVisible(false);
        txtidcliente.setVisible(false);
        txtidempleado.setVisible(false);
        
        //Registro venta
        txtnombrecliente.setEnabled(false);
        txtnombreempleado.setEnabled(false);
        dcfechaventa.setEnabled(true);
        txttotalmedida.setEnabled(false);
        txttotalventa.setEnabled(false);
        cbotipopago.setEnabled(true);
        
        btnbuscarcliente.setEnabled(true);
        
        btnguardar.setEnabled(true);
        btncancelar.setEnabled(true);
        btneliminar.setEnabled(false);
        btnsalir.setEnabled(true);
        
        txtidventa.setText("");
        txtidcliente.setText("");
        txtidproducto.setText("");
        
        txttotalmedida.setText("0.00");
        txttotalventa.setText("0.00");
        
        txtnombrecliente.setText("");
    }
    
    void habilitarproducto(){
        
        
        //Ingreso productos
        txtiddetalleventa.setVisible(false);
        txtidventa2.setVisible(false);
        txtidproducto.setVisible(false);
        txtnombreproducto.setEnabled(false);
        txtmedida.setEnabled(true);
        txtprecioventa.setEnabled(false);
        txtsubtotal.setEnabled(false);

        btnguardarproducto.setEnabled(true);
        btnagregarproducto.setEnabled(true);
        btnbuscarproducto.setEnabled(true);
        
        txtnombreproducto.setText("");
        txtprecioventa.setText("");
        txtmedida.setText("");
        txtsubtotal.setText("");
}

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            fventa func = new fventa();
            modelo = func.mostrar(buscar);
            
            tablaclientes.setModel(modelo);
            
            //Mostrar consumos en ventas
            fdetalleventa func2 = new fdetalleventa();
            modelo = func2.mostrar(buscar);

            tablalistado.setModel(modelo);
            
            ocultar_columnas();
            
            lbltotalregistros.setText("Total Registros:  " + Integer.toString(func2.totalregistros));
            lblconsumo.setText("Consumo Total $. "+func2.totalconsumo);
            lbltotalmedida.setText("Medida Total "+Double.toString(func2.totalmedida));
            
            txttotalmedida.setText(Double.toString(func2.totalmedida));
            txttotalventa.setText(Double.toString(func2.totalconsumo));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtidventa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txtnombrecliente = new javax.swing.JTextField();
        txtidcliente = new javax.swing.JTextField();
        btnbuscarcliente = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtidempleado = new javax.swing.JTextField();
        txtnombreempleado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        dcfechaventa = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        txttotalmedida = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txttotalventa = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbotipopago = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaclientes = new javax.swing.JTable();
        lblinstruccion = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        lblconsumo = new javax.swing.JLabel();
        lbltotalmedida = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtsubtotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtidproducto = new javax.swing.JTextField();
        txtnombreproducto = new javax.swing.JTextField();
        btnbuscarproducto = new javax.swing.JButton();
        txtprecioventa = new javax.swing.JTextField();
        txtmedida = new javax.swing.JTextField();
        txtiddetalleventa = new javax.swing.JTextField();
        btnagregarproducto = new javax.swing.JButton();
        txtidventa2 = new javax.swing.JTextField();
        btnguardarproducto = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/devices_78336.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1010, 560));

        jLabel1.setText("Venta");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de venta"));

        txtidventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidventaActionPerformed(evt);
            }
        });

        jLabel2.setText("Cliente");

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnbuscarcliente.setText("...");
        btnbuscarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarclienteActionPerformed(evt);
            }
        });

        jLabel8.setText("Empleado");

        jLabel9.setText("Fecha venta");

        jLabel10.setText("Total medida");

        txttotalmedida.setText("0.00");
        txttotalmedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalmedidaActionPerformed(evt);
            }
        });

        jLabel11.setText("Total venta");

        txttotalventa.setText("0.00");
        txttotalventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalventaActionPerformed(evt);
            }
        });

        jLabel12.setText("Tipo pago");

        cbotipopago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cheque", "Efectivo" }));
        cbotipopago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotipopagoActionPerformed(evt);
            }
        });

        tablaclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaclientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaclientesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaclientesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaclientes);

        lblinstruccion.setText("Escoja un cliente de la lista por favo: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnnuevo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtidventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(2, 2, 2)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(btnguardar)
                                            .addGap(81, 81, 81)
                                            .addComponent(btncancelar))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtnombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnbuscarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(dcfechaventa, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                                .addComponent(cbotipopago, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtnombreempleado)
                                                .addComponent(txttotalmedida)
                                                .addComponent(txttotalventa))
                                            .addGap(43, 43, 43)))))
                            .addComponent(lblinstruccion))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtnombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnbuscarcliente)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtnombreempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dcfechaventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttotalmedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txttotalventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cbotipopago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnnuevo)
                            .addComponent(btnguardar)
                            .addComponent(btncancelar)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblinstruccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de productos"));

        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablalistadoMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tablalistado);

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        lbltotalregistros.setText("jLabel7");

        lblconsumo.setText("jLabel7");

        lbltotalmedida.setText("jLabel9");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltotalmedida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblconsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btneliminar)
                .addGap(42, 42, 42)
                .addComponent(btnsalir)
                .addGap(75, 75, 75))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsalir)
                    .addComponent(btneliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltotalregistros)
                    .addComponent(lblconsumo)
                    .addComponent(lbltotalmedida))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingreso productos"));

        txtsubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubtotalActionPerformed(evt);
            }
        });

        jLabel4.setText("Sub total");

        jLabel7.setText("Medida");

        jLabel5.setText("Precio venta");

        jLabel3.setText("Producto");

        txtidproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidproductoActionPerformed(evt);
            }
        });

        txtnombreproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreproductoActionPerformed(evt);
            }
        });

        btnbuscarproducto.setText("...");
        btnbuscarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarproductoActionPerformed(evt);
            }
        });

        txtprecioventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioventaActionPerformed(evt);
            }
        });

        txtmedida.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtmedidaInputMethodTextChanged(evt);
            }
        });
        txtmedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmedidaActionPerformed(evt);
            }
        });
        txtmedida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmedidaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmedidaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmedidaKeyTyped(evt);
            }
        });

        btnagregarproducto.setText("Agregar");
        btnagregarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarproductoActionPerformed(evt);
            }
        });

        btnguardarproducto.setText("Nuevo");
        btnguardarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarproductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(txtiddetalleventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtidventa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtnombreproducto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnbuscarproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtprecioventa, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtmedida)))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnguardarproducto)
                                .addGap(52, 52, 52)
                                .addComponent(btnagregarproducto))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(txtsubtotal)))
                        .addGap(186, 186, 186))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtidproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtiddetalleventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidventa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombreproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscarproducto)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtprecioventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnagregarproducto)
                    .addComponent(btnguardarproducto)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtsubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubtotalActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnguardar.setText("Guardar");
        accion = "guardar";
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        //validadion de ingreso de datos
        
        if(txtnombrecliente.getText().length() == 0){
            JOptionPane.showConfirmDialog(rootPane, "Debes seleccionar un cliente");
            btnbuscarproducto.requestFocus();
            return;
        }

        if((dcfechaventa.getDate().toString()).length() == 0){
            JOptionPane.showConfirmDialog(rootPane, "Debes Ingresar una medida");
            dcfechaventa.requestFocus();
            return;
        }
        
        
        vventa dts = new vventa();
        fventa func = new fventa();

        dts.setIdcliente(Integer.parseInt(txtidcliente.getText()));
        dts.setIdempleado(Integer.parseInt(txtidempleado.getText()));
        
        Calendar cal;
        int d,m,a;
        cal = dcfechaventa.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR)-1900;
        
        dts.setFechaventa(new Date(a,m,d));
        
        dts.setTotalmedida(Double.parseDouble(txttotalmedida.getText()));
        dts.setTotalventa(Double.parseDouble(txttotalventa.getText()));
        
        int seleccionado = cbotipopago.getSelectedIndex();
        dts.setTipopago((String)cbotipopago.getItemAt(seleccionado));
        
        if(accion.equals ("guardar")){
            if(func.insertar(dts)){
                JOptionPane.showMessageDialog(rootPane, "La venta "+txtnombreproducto.getText()+" del cliente "
                +txtnombrecliente.getText() +" fue registrado satisfactoriamente");
                mostrar(idventa);
                habilitarproducto();
            }
        }
        else if(accion.equals("editar")){
            dts.setIdventa(Integer.parseInt(txtidventa.getText()));

            if(func.editar(dts)){
                JOptionPane.showMessageDialog(rootPane, "El detalle del cliente "+txtnombrecliente.getText()
                        +" fue modificado satisfactoriamente");
                mostrar(idventa);
                habilitarproducto();
            }
        }

    }//GEN-LAST:event_btnguardarActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if(!txtiddetalleventa.getText().equals("")){
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de elimiar la habitacion?","Confirmar",2);
            if(confirmacion == 0){
                fdetalleventa func = new fdetalleventa();
                vdetalleventa dts = new vdetalleventa();

                dts.setIddetalleventa(Integer.parseInt(txtiddetalleventa.getText()));
                func.eliminar(dts);
                mostrar(idventa);
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtnombreproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreproductoActionPerformed

    private void btnbuscarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarproductoActionPerformed
        // TODO add your handling code here:
        frmvistaproducto.clave = "venta";
        frmvistaproducto form = new frmvistaproducto();
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_btnbuscarproductoActionPerformed

    private void txtmedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmedidaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtmedidaActionPerformed

    private void txtprecioventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioventaActionPerformed

    private void txtidproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidproductoActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        
        JOptionPane.showMessageDialog(rootPane, "El registro del fue cancelado");
        inhabilitar();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnbuscarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarclienteActionPerformed
        // TODO add your handling code here:
        frmvistacliente form = new frmvistacliente();
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_btnbuscarclienteActionPerformed

    private void txtmedidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmedidaKeyPressed
    }//GEN-LAST:event_txtmedidaKeyPressed

    private void txtmedidaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtmedidaInputMethodTextChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtmedidaInputMethodTextChanged

    private void txtmedidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmedidaKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtmedidaKeyTyped

    private void txtmedidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmedidaKeyReleased
        // TODO add your handling code here:
        Double resultado;
        resultado = Double.parseDouble(txtmedida.getText())*Double.parseDouble(txtprecioventa.getText());
        txtsubtotal.setText(resultado.toString());
    }//GEN-LAST:event_txtmedidaKeyReleased

    private void txttotalmedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalmedidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalmedidaActionPerformed

    private void txttotalventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalventaActionPerformed
        // TODO add your handling code here:
        txttotalventa.transferFocus();
    }//GEN-LAST:event_txttotalventaActionPerformed

    private void btnagregarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarproductoActionPerformed
        // TODO add your handling code here:
        
        if (txtnombreproducto.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes seleccionar un producto");
            btnbuscarproducto.requestFocus();
            return;
        }
        
        if (txtmedida.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar una medida");
            txtmedida.requestFocus();
            return;
        }
        
        vdetalleventa dts = new vdetalleventa();
        fdetalleventa func = new fdetalleventa();
        
        dts.setIdventa(Integer.parseInt(txtidventa2.getText()));
        dts.setIdproducto(Integer.parseInt(txtidproducto.getText()));
        dts.setMedida(Double.parseDouble(txtmedida.getText()));
        dts.setSubtotal(Double.parseDouble(txtsubtotal.getText()));
        
        if(accion.equals("guardar")){
            if(func.insertar(dts)){
                JOptionPane.showMessageDialog(rootPane,"Agregado!");
                mostrar(idventa);
                habilitarproducto();
                btnagregarproducto.setEnabled(false);
            }
        }else if(accion.equals("editar")){
            dts.setIddetalleventa(Integer.parseInt(txtiddetalleventa.getText()));
            
            if(func.editar(dts)){
                JOptionPane.showMessageDialog(rootPane,"editado!");
                mostrar(idventa);
                habilitarproducto();
            }
        }
    }//GEN-LAST:event_btnagregarproductoActionPerformed

    private void cbotipopagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipopagoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbotipopagoActionPerformed

    private void tablaclientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaclientesMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tablaclientesMouseClicked

    private void tablaclientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaclientesMousePressed
        // TODO add your handling code here:
        btnguardar.setText("Actualizar");
        inhabilitar();
        btnguardar.setEnabled(true); 
        btnguardarproducto.setEnabled(true);
        accion = "editar";
        
        int fila = tablaclientes.rowAtPoint(evt.getPoint());
        
        txtidventa.setText(tablaclientes.getValueAt(fila,0).toString());
        txtidcliente.setText(tablaclientes.getValueAt(fila,1).toString());
        txtidempleado.setText(tablaclientes.getValueAt(fila,3).toString());
                
        txtnombrecliente.setText(tablaclientes.getValueAt(fila,2).toString());
        txtnombreempleado.setText(tablaclientes.getValueAt(fila,4).toString());
        dcfechaventa.setDate(Date.valueOf(tablaclientes.getValueAt(fila,5).toString()));
        txttotalmedida.setText(tablaclientes.getValueAt(fila,6).toString());
        txttotalventa.setText(tablaclientes.getValueAt(fila,7).toString());
        cbotipopago.setSelectedItem(tablaclientes.getValueAt(fila, 8).toString());
        
        txtidventa2.setText(tablaclientes.getValueAt(fila,0).toString());
        
        idventa = txtidventa2.getText();
        mostrar(idventa);
    }//GEN-LAST:event_tablaclientesMousePressed

    private void btnguardarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarproductoActionPerformed
        // TODO add your handling code here:
        accion = "guardar";
        habilitarproducto();
    }//GEN-LAST:event_btnguardarproductoActionPerformed

    private void tablalistadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMousePressed
        // TODO add your handling code here:
        btnagregarproducto.setText("Editar");
        habilitarproducto();
        btneliminar.setEnabled(true);
        accion = "editar";

        int fila = tablalistado.rowAtPoint(evt.getPoint());
        
        txtiddetalleventa.setText(tablalistado.getValueAt(fila,0).toString());
        txtidventa2.setText(tablalistado.getValueAt(fila,1).toString());
        txtidproducto.setText(tablalistado.getValueAt(fila,2).toString());
        txtnombreproducto.setText(tablalistado.getValueAt(fila,3).toString());
        txtprecioventa.setText(tablalistado.getValueAt(fila,4).toString());
        txtmedida.setText(tablalistado.getValueAt(fila,5).toString());
        txtsubtotal.setText(tablalistado.getValueAt(fila,6).toString());
        
    }//GEN-LAST:event_tablalistadoMousePressed

    private void txtidventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidventaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmventa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregarproducto;
    private javax.swing.JButton btnbuscarcliente;
    private javax.swing.JButton btnbuscarproducto;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnguardarproducto;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cbotipopago;
    private com.toedter.calendar.JDateChooser dcfechaventa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblconsumo;
    private javax.swing.JLabel lblinstruccion;
    private javax.swing.JLabel lbltotalmedida;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTable tablaclientes;
    private javax.swing.JTable tablalistado;
    public static javax.swing.JTextField txtidcliente;
    private javax.swing.JTextField txtiddetalleventa;
    public static javax.swing.JTextField txtidempleado;
    public static javax.swing.JTextField txtidproducto;
    private javax.swing.JTextField txtidventa;
    private javax.swing.JTextField txtidventa2;
    private javax.swing.JTextField txtmedida;
    public static javax.swing.JTextField txtnombrecliente;
    public static javax.swing.JTextField txtnombreempleado;
    public static javax.swing.JTextField txtnombreproducto;
    public static javax.swing.JTextField txtprecioventa;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JTextField txttotalmedida;
    private javax.swing.JTextField txttotalventa;
    // End of variables declaration//GEN-END:variables
}
