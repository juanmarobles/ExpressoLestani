/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.lestanitest.igu;

import com.mycompany.lestanitest.logica.Conexion;
import com.mycompany.lestanitest.logica.Controladora;
import com.mycompany.lestanitest.logica.Movimientos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author juanm
 */
public class PagadosFrame extends javax.swing.JFrame {

    private JCheckBox pagadosCheckBox;
    private JTable pagosTable;
    Controladora control = new Controladora();
    public PagadosFrame() {
        pagadosCheckBox = new JCheckBox("Pagados");
        pagadosCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTable();
            }
        });
        
        DefaultTableModel tableModel = new DefaultTableModel();
        String titulos[] = {"MOVIMIENTO", "FECHA", "CLIENTE", "TIPO_MONTO"};
        tableModel.setColumnIdentifiers(titulos);
        
        pagosTable = new JTable(tableModel);
            List<Movimientos> listaMovimientos = control.traerMovimientos();

        //recorrer lista y mostrar elementos en la tabla
        if (listaMovimientos != null) {
            for (Movimientos mov : listaMovimientos) {
                Object[] objeto = {mov.getId_movimientos(), mov.getFechaFormateada(), mov.getCliente(),mov.getTipoMonto()};

                tableModel.addRow(objeto);

            }
        }
        pagosTable.setModel(tableModel);
        pagosTable.getModel();
        JScrollPane scrollPane = new JScrollPane(pagosTable);
        getContentPane().add(pagadosCheckBox, "North");
        getContentPane().add(scrollPane, "Center");

        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
private void updateTable() {
    DefaultTableModel tableModel = (DefaultTableModel) pagosTable.getModel();
    tableModel.setRowCount(0); // Limpiar la tabla

    List<Movimientos> listaMovimientos = control.traerMovimientos();
    // Recorrer la lista y agregar filas a la tabla
    for (Movimientos mov : listaMovimientos) {
        if (!pagadosCheckBox.isSelected() || mov.getTipoMonto().equals("Pagado")) {
            Object[] row = {mov.getId_movimientos(), mov.getFechaFormateada(), mov.getCliente(), mov.getTipoMonto()};
            tableModel.addRow(row);
        }
    }
}
  private Object[][] getData() {
         Connection con = Conexion.getConexion();
        
        Statement stmt = null;
        ResultSet rs = null;
    try {

        // Ejecutar una consulta SQL para obtener los datos
        stmt = con.createStatement();
        String sql = "SELECT ID_MOVIMIENTO, FECHA, CLIENTE, MONTO_PAGADO_RENDIDO FROM movimientos";
        rs = stmt.executeQuery(sql);

        // Convertir los datos obtenidos en un arreglo de objetos
         List<Object[]> dataList = new ArrayList<>();
        while (rs.next()) {
            Object[] row = new Object[4];
            row[0] = rs.getInt("ID_MOVIMIENTO");
            row[1] = rs.getString("FECHA");
            row[2] = rs.getString("CLIENTE");
            row[3] = rs.getString("MONTO_PAGADO_RENDIDO");
            dataList.add(row);
        }
        return dataList.toArray(new Object[0][0]);

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return null;
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PagadosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagadosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagadosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagadosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new PagadosFrame();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
