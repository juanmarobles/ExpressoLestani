/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.lestanitest.igu;

import com.mycompany.lestanitest.logica.Cliente;
import com.mycompany.lestanitest.logica.Controladora;
import com.mycompany.lestanitest.logica.ModeloCliente;
import com.mycompany.lestanitest.logica.Movimientos;
import com.mycompany.lestanitest.logica.Servicios;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Usuario
 */
public class prueba extends javax.swing.JFrame {
    
     Controladora control = new Controladora();
    TableRowSorter trs;
    DefaultTableModel dtm = new DefaultTableModel();
    private Cliente cliente;
    private Cliente destinatario;
    private Movimientos movimientoSeleccionado;
    private Servicios servicioSeleccionado;
    int numeroRemito = 0;
    private int idSeleccionado = -1; // Inicializado con un valor negativo para indicar que no se ha seleccionado ningún movimiento.
    

    /**
     * Creates new form prueba
     */
    public prueba() {
        initComponents();
        cargarClientes();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbClientes = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(cbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(cbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(315, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new prueba().setVisible(true);
            }
         
        });
        
         
    }
    
   private void cargarClientes() {
      ModeloCliente modClientes = new ModeloCliente();
    ArrayList<Cliente> listaClientes = modClientes.getClientes();
    
    cbClientes.setEditable(true);

    // Ordenar la lista de clientes alfabéticamente por el nombre
    listaClientes.sort((cliente1, cliente2) -> cliente1.getNombre().compareToIgnoreCase(cliente2.getNombre()));

    // Limpiar el ComboBox
    cbClientes.removeAllItems();

    // Agregar los nombres de los clientes al ComboBox de forma ordenada
    for (Cliente cliente : listaClientes) {
        cbClientes.addItem(cliente.getNombre());
    }

    // Eliminar la opción en blanco después de configurar el decorador
    cbClientes.removeItem("");

    // Establecer el índice seleccionado a -1 para no mostrar ninguna selección
    cbClientes.setSelectedIndex(-1);

    // Agregar un campo de texto para la búsqueda
    JTextField campoBusqueda = new JTextField(20);
    campoBusqueda.addActionListener(e -> {
        String textoBusqueda = campoBusqueda.getText().trim().toUpperCase();
        mostrarResultadosBusqueda(cbClientes, listaClientes, textoBusqueda);
    });
    
    // Agregar el campo de búsqueda al componente
    JPanel panelBusqueda = new JPanel();
    panelBusqueda.add(new JLabel("Buscar cliente: "));
    panelBusqueda.add(campoBusqueda);
    
    // Agregar el panel de búsqueda antes del ComboBox
    getContentPane().add(panelBusqueda, BorderLayout.NORTH);
    
    // Agregar ActionListener para capturar el evento "Enter"
    cbClientes.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String textoBusqueda = cbClientes.getEditor().getItem().toString();
            mostrarResultadosBusqueda(cbClientes, listaClientes, textoBusqueda);
            if (cbClientes.getSelectedIndex() != -1) {
                // Normaliza el texto de búsqueda a mayúsculas
                textoBusqueda = textoBusqueda.toUpperCase();

                cliente = null; // Restablece el destinatario seleccionado
                for (Cliente cliente : listaClientes) {
                    if (cliente.getNombre().toUpperCase().equals(textoBusqueda)) {
                        cliente = cliente;
                        break;
                    }
                }
            }
        }
    });
}

private void mostrarResultadosBusqueda(JComboBox cb, ArrayList<Cliente> listaClientes, String textoBusqueda) {
    DefaultComboBoxModel modelo = (DefaultComboBoxModel) cb.getModel();
    modelo.removeAllElements();
    for (Cliente cliente : listaClientes) {
        if (cliente.getNombre().toUpperCase().contains(textoBusqueda)) {
            modelo.addElement(cliente.getNombre());
        }
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbClientes;
    // End of variables declaration//GEN-END:variables
}