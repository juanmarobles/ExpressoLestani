/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.lestanitest.igu;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;

/**
 *
 * @author Usuario
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private static VentanaPrincipal instancia;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        instancia = this;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuMovimientos = new javax.swing.JMenu();
        CargaMovimiento = new javax.swing.JMenuItem();
        Consultas = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        MenuLocalidades = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        MenuClientes = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        MenuVehiculos = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        MenuServicios = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        Recibos = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Fondo de pantalla.png"))); // NOI18N

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.setMinimumSize(new java.awt.Dimension(505, 38));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(505, 40));

        MenuMovimientos.setText("Movimientos   ");
        MenuMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuMovimientosActionPerformed(evt);
            }
        });

        CargaMovimiento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CargaMovimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/camiones.png"))); // NOI18N
        CargaMovimiento.setText("Cargar Movimientos");
        CargaMovimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CargaMovimiento.setPreferredSize(new java.awt.Dimension(173, 36));
        CargaMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargaMovimientoActionPerformed(evt);
            }
        });
        MenuMovimientos.add(CargaMovimiento);

        jMenuBar1.add(MenuMovimientos);

        Consultas.setText("Consultas");
        Consultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultasActionPerformed(evt);
            }
        });

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/camionatras.png"))); // NOI18N
        jMenuItem1.setText("Consultar Movimientos");
        jMenuItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem1.setPreferredSize(new java.awt.Dimension(191, 36));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Consultas.add(jMenuItem1);

        jMenuBar1.add(Consultas);

        jMenu2.setText("    Hoja de Ruta   ");

        jMenuItem6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/equipo.png"))); // NOI18N
        jMenuItem6.setText("Por Representante   ");
        jMenuItem6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem6.setPreferredSize(new java.awt.Dimension(164, 36));
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);
        jMenu2.add(jSeparator6);

        jMenuItem7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ruta.png"))); // NOI18N
        jMenuItem7.setText("Hoja de Ruta");
        jMenuItem7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem7.setPreferredSize(new java.awt.Dimension(127, 36));
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("      Datos Cargados   ");

        MenuLocalidades.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuLocalidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/localizacion.png"))); // NOI18N
        MenuLocalidades.setText("Localidades");
        MenuLocalidades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuLocalidades.setPreferredSize(new java.awt.Dimension(118, 36));
        MenuLocalidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuLocalidadesActionPerformed(evt);
            }
        });
        jMenu3.add(MenuLocalidades);
        jMenu3.add(jSeparator1);

        MenuClientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cliente.png"))); // NOI18N
        MenuClientes.setText("Clientes");
        MenuClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuClientes.setPreferredSize(new java.awt.Dimension(96, 36));
        MenuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuClientesActionPerformed(evt);
            }
        });
        jMenu3.add(MenuClientes);
        jMenu3.add(jSeparator2);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/equipo.png"))); // NOI18N
        jMenuItem3.setText("Representantes");
        jMenuItem3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem3.setPreferredSize(new java.awt.Dimension(142, 36));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);
        jMenu3.add(jSeparator3);

        MenuVehiculos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuVehiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/camiones.png"))); // NOI18N
        MenuVehiculos.setText("Vechiculos");
        MenuVehiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuVehiculos.setPreferredSize(new java.awt.Dimension(112, 36));
        MenuVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuVehiculosActionPerformed(evt);
            }
        });
        jMenu3.add(MenuVehiculos);
        jMenu3.add(jSeparator4);

        MenuServicios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuServicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/entrega-de-paquetes.png"))); // NOI18N
        MenuServicios.setText("Servicios");
        MenuServicios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuServicios.setPreferredSize(new java.awt.Dimension(100, 36));
        MenuServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuServiciosActionPerformed(evt);
            }
        });
        jMenu3.add(MenuServicios);

        jMenuBar1.add(jMenu3);

        jMenu4.setBorder(null);
        jMenu4.setText("   Recibos");

        Recibos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Recibos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/factura.png"))); // NOI18N
        Recibos.setText("Generar Recibo");
        Recibos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Recibos.setPreferredSize(new java.awt.Dimension(152, 36));
        Recibos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecibosActionPerformed(evt);
            }
        });
        jMenu4.add(Recibos);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuClientesActionPerformed
        VerDatosCliente cl = new VerDatosCliente();
        cl.setVisible(true);
    }//GEN-LAST:event_MenuClientesActionPerformed

    private void MenuMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuMovimientosActionPerformed

    }//GEN-LAST:event_MenuMovimientosActionPerformed

    private void ConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultasActionPerformed

    }//GEN-LAST:event_ConsultasActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        HojaDeRuta hd = new HojaDeRuta();
        hd.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void MenuLocalidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuLocalidadesActionPerformed
        VerDatosLocalidades lo = new VerDatosLocalidades();
        lo.setVisible(true);
    }//GEN-LAST:event_MenuLocalidadesActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        VerDatosRepresentantes repre = new VerDatosRepresentantes();
        repre.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void CargaMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargaMovimientoActionPerformed
        Principal pn = new Principal();
        pn.setVisible(true);
    }//GEN-LAST:event_CargaMovimientoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       Consultas cl = new Consultas();
       cl.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void RecibosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecibosActionPerformed
        Recibo rc = new Recibo();
        rc.setVisible(true);
    }//GEN-LAST:event_RecibosActionPerformed

    private void MenuServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuServiciosActionPerformed
        VerDatosServicios servi = new VerDatosServicios();
        servi.setVisible(true);
    }//GEN-LAST:event_MenuServiciosActionPerformed

    private void MenuVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuVehiculosActionPerformed
        VerDatosVehiculos vehiculo = new VerDatosVehiculos();
        vehiculo.setVisible(true);

    }//GEN-LAST:event_MenuVehiculosActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        HDDRepresentantes hdd = new HDDRepresentantes();
        hdd.setVisible(true);

    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CargaMovimiento;
    private javax.swing.JMenu Consultas;
    private javax.swing.JMenuItem MenuClientes;
    private javax.swing.JMenuItem MenuLocalidades;
    private javax.swing.JMenu MenuMovimientos;
    private javax.swing.JMenuItem MenuServicios;
    private javax.swing.JMenuItem MenuVehiculos;
    private javax.swing.JMenuItem Recibos;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    // End of variables declaration//GEN-END:variables
}
