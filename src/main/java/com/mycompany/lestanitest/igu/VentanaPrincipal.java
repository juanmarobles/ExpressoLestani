/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.lestanitest.igu;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
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
    private static DateAlertApp dateAlertApp;
    private DateAlertApp dateAlertAp;
    private boolean alertaMostrada = false;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        instancia = this;
        dateAlertAp = new DateAlertApp();
    }

    public void mostrarAlertaFechaVencimiento(String mensaje) {
        // Verificar si la alerta ya ha sido mostrada
        if (alertaMostrada) {
            DateAlertApp.mostrarAlertaPublico(mensaje);
            alertaMostrada = true; // Marcar la alerta como mostrada
        }
    }

    // Función para mostrar la ventana de alerta personalizada
    public static void mostrarVentanaAlerta(String mensaje) {
        if (dateAlertApp != null) {
            dateAlertApp.mostrarAlertaPublico(mensaje);
        }
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
        menuConsultas = new javax.swing.JMenuItem();
        HojaDRuta = new javax.swing.JMenu();
        MenuHDDRepresentante = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        HDD = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
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
        setTitle("Expreso Lestani S.R.L - Ventana Principal");
        setBackground(new java.awt.Color(51, 102, 255));
        setIconImages(null);

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

        menuConsultas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/camionatras.png"))); // NOI18N
        menuConsultas.setText("Consultar Movimientos");
        menuConsultas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuConsultas.setPreferredSize(new java.awt.Dimension(191, 36));
        menuConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultasActionPerformed(evt);
            }
        });
        Consultas.add(menuConsultas);

        jMenuBar1.add(Consultas);

        HojaDRuta.setText("    Hoja de Ruta   ");

        MenuHDDRepresentante.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuHDDRepresentante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/equipo.png"))); // NOI18N
        MenuHDDRepresentante.setText("Por Representante   ");
        MenuHDDRepresentante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuHDDRepresentante.setPreferredSize(new java.awt.Dimension(164, 36));
        MenuHDDRepresentante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuHDDRepresentanteActionPerformed(evt);
            }
        });
        HojaDRuta.add(MenuHDDRepresentante);
        HojaDRuta.add(jSeparator6);

        HDD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        HDD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ruta.png"))); // NOI18N
        HDD.setText("Hoja de Ruta");
        HDD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HDD.setPreferredSize(new java.awt.Dimension(127, 36));
        HDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HDDActionPerformed(evt);
            }
        });
        HojaDRuta.add(HDD);

        jMenuBar1.add(HojaDRuta);

        jMenu3.setText("      Carga de Datos   ");

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
        MenuVehiculos.setText("Vehiculos");
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
    private VerDatosCliente ventanaClientes;
    private void MenuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuClientesActionPerformed
        // Verificar si la ventana ya está abierta
        if (ventanaClientes == null || !ventanaClientes.isVisible()) {
            // Si la ventana no está abierta o está oculta, crea una nueva instancia
            ventanaClientes = new VerDatosCliente();
        }

        // Mostrar la ventana y enfocarla (llevarla al frente)
        ventanaClientes.setVisible(true);
        ventanaClientes.toFront();
    }//GEN-LAST:event_MenuClientesActionPerformed

    private void MenuMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuMovimientosActionPerformed

    }//GEN-LAST:event_MenuMovimientosActionPerformed

    private void ConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultasActionPerformed

    }//GEN-LAST:event_ConsultasActionPerformed
    private HojaDeRuta ventanaHDD;
    private void HDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HDDActionPerformed
        // Verificar si la ventana ya está abierta
        if (ventanaHDD == null || !ventanaHDD.isVisible()) {
            // Si la ventana no está abierta o está oculta, crea una nueva instancia
            ventanaHDD = new HojaDeRuta();
        }

        // Mostrar la ventana y enfocarla (llevarla al frente)
        ventanaHDD.setVisible(true);
        ventanaHDD.toFront();
    }//GEN-LAST:event_HDDActionPerformed
    private VerDatosRepresentantes ventanaDatosRepresentantes;
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // Verificar si la ventana ya está abierta
        if (ventanaDatosRepresentantes == null || !ventanaDatosRepresentantes.isVisible()) {
            // Si la ventana no está abierta o está oculta, crea una nueva instancia
            ventanaDatosRepresentantes = new VerDatosRepresentantes();
        }

        // Mostrar la ventana y enfocarla (llevarla al frente)
        ventanaDatosRepresentantes.setVisible(true);
        ventanaDatosRepresentantes.toFront();
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    private Principal ventanaPrincipal;
    private void CargaMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargaMovimientoActionPerformed
        // Verificar si la ventana ya está abierta
        if (ventanaPrincipal == null || !ventanaPrincipal.isVisible()) {
            // Si la ventana no está abierta o está oculta, crea una nueva instancia
            ventanaPrincipal = new Principal();
        }

        // Mostrar la ventana y enfocarla (llevarla al frente)
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.toFront();
    }//GEN-LAST:event_CargaMovimientoActionPerformed
    private Consultas ventanaConsultas;
    private void menuConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultasActionPerformed
        // Verificar si la ventana ya está abierta
        if (ventanaConsultas == null || !ventanaConsultas.isVisible()) {
            // Si la ventana no está abierta o está oculta, crea una nueva instancia
            ventanaConsultas = new Consultas();
        }

        // Mostrar la ventana y enfocarla (llevarla al frente)
        ventanaConsultas.setVisible(true);
        ventanaConsultas.toFront();
    }//GEN-LAST:event_menuConsultasActionPerformed
    private Recibo ventanaRecibos;
    private void RecibosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecibosActionPerformed
        // Verificar si la ventana ya está abierta
        if (ventanaRecibos == null || !ventanaRecibos.isVisible()) {
            // Si la ventana no está abierta o está oculta, crea una nueva instancia
            ventanaRecibos = new Recibo();
        }

        // Mostrar la ventana y enfocarla (llevarla al frente)
        ventanaRecibos.setVisible(true);
        ventanaRecibos.toFront();
    }//GEN-LAST:event_RecibosActionPerformed
    private VerDatosServicios ventanaServicios;
    private void MenuServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuServiciosActionPerformed
        // Verificar si la ventana ya está abierta
        if (ventanaServicios == null || !ventanaServicios.isVisible()) {
            // Si la ventana no está abierta o está oculta, crea una nueva instancia
            ventanaServicios = new VerDatosServicios();
        }

        // Mostrar la ventana y enfocarla (llevarla al frente)
        ventanaServicios.setVisible(true);
        ventanaServicios.toFront();
    }//GEN-LAST:event_MenuServiciosActionPerformed
    private VerDatosVehiculos ventanaVehiculos;
    private void MenuVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuVehiculosActionPerformed
        // Verificar si la ventana ya está abierta
        if (ventanaVehiculos == null || !ventanaVehiculos.isVisible()) {
            // Si la ventana no está abierta o está oculta, crea una nueva instancia
            ventanaVehiculos = new VerDatosVehiculos();
        }

        // Mostrar la ventana y enfocarla (llevarla al frente)
        ventanaVehiculos.setVisible(true);
        ventanaVehiculos.toFront();

    }//GEN-LAST:event_MenuVehiculosActionPerformed
    private HDDRepresentantes ventanaHDDRepresentantes;
    private void MenuHDDRepresentanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuHDDRepresentanteActionPerformed
        // Verificar si la ventana ya está abierta
        if (ventanaHDDRepresentantes == null || !ventanaHDDRepresentantes.isVisible()) {
            // Si la ventana no está abierta o está oculta, crea una nueva instancia
            ventanaHDDRepresentantes = new HDDRepresentantes();
        }

        // Mostrar la ventana y enfocarla (llevarla al frente)
        ventanaHDDRepresentantes.setVisible(true);
        ventanaHDDRepresentantes.toFront();
    }//GEN-LAST:event_MenuHDDRepresentanteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DateAlertApp app = new DateAlertApp();
                app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                app.pack();
                app.setVisible(true);

                // Guardar referencia a la instancia de DateAlertApp
                dateAlertApp = app;

                // Crear la instancia de VentanaPrincipal y mostrarla
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                ventanaPrincipal.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CargaMovimiento;
    private javax.swing.JMenu Consultas;
    private javax.swing.JMenuItem HDD;
    private javax.swing.JMenu HojaDRuta;
    private javax.swing.JMenuItem MenuClientes;
    private javax.swing.JMenuItem MenuHDDRepresentante;
    private javax.swing.JMenu MenuMovimientos;
    private javax.swing.JMenuItem MenuServicios;
    private javax.swing.JMenuItem MenuVehiculos;
    private javax.swing.JMenuItem Recibos;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JMenuItem menuConsultas;
    // End of variables declaration//GEN-END:variables
}
