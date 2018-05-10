/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.fcliente;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author SONY
 */
public final class Pruebas extends javax.swing.JFrame {

    /**
     * Creates new form Pruebas
     */
    public Pruebas() {
        initComponents();
        mostrarclientes();
    }

    
    public void mostrarclientes(){
        try{
            fcliente func = new fcliente();
            func.cargarclientes();
        }catch(Exception e){
            JOptionPane.showConfirmDialog(rootPane,e);
        }
    }
    
    public void mostrarid(String buscar){
        try{
            fcliente func = new fcliente();
            func.cargaridclientes(buscar);
        }catch(Exception e){
            JOptionPane.showConfirmDialog(rootPane,e);
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

        txtid = new javax.swing.JTextField();
        cbocliente = new javax.swing.JComboBox<>();
        btnfiltrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablafiltrar = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbocliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbocliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboclienteMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cboclienteMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cboclienteMouseReleased(evt);
            }
        });

        btnfiltrar.setText("Filtrar");

        tablafiltrar.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablafiltrar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnfiltrar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnfiltrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboclienteMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cboclienteMouseClicked

    private void cboclienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboclienteMousePressed
        // TODO add your handling code here:
        //txtid.setText(cbocliente.getSelectedItem().toString());
    }//GEN-LAST:event_cboclienteMousePressed

    private void cboclienteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboclienteMouseReleased
        // TODO add your handling code here:
        mostrarid(cbocliente.getSelectedItem().toString());
    }//GEN-LAST:event_cboclienteMouseReleased

    /**
     * @param args the command line arguments
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    public static void main(String args[]) throws InstantiationException, IllegalAccessException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    try {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    } catch (UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Pruebas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnfiltrar;
    public static javax.swing.JComboBox<String> cbocliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablafiltrar;
    public static javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}