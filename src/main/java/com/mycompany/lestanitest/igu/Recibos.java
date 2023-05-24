/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.lestanitest.igu;

import com.mycompany.lestanitest.logica.Cliente;
import com.mycompany.lestanitest.logica.Controladora;
import com.mycompany.lestanitest.logica.ModeloCliente;
import com.mycompany.lestanitest.logica.Movimientos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.text.DecimalFormatSymbols;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author Marco
 */
public class Recibos extends javax.swing.JFrame {

    Controladora control = new Controladora();
    TableRowSorter trs;
    DefaultTableModel tabla = new DefaultTableModel();
    private String cliente;
    private String fechaDesde;
    private String fechaHasta;
    private List<Movimientos> listaFiltrada;

    /**
     * Creates new form Recibos
     */
    public Recibos(String cliente, List<Movimientos> listaFiltrada, String fechaDesde, String fechaHasta) {
        this.cliente = cliente;
        this.listaFiltrada = listaFiltrada;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        initComponents();
        cargarClientes();
        txtCliente.setText(cliente);
        cargarTablaMovimientos();
    }

    public void cargarTablaMovimientos() {
        DefaultTableModel tabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String titulos[] = {"FECHA", "CLIENTE", "DESTINO", "REMITO", "BULTOS", "MONTO", "PAGADO", "FLETE", "PAGADO", "A_CARGO_DE", "REPRESENTANTE", "CC", "OBS"};
        tabla.setColumnIdentifiers(titulos);

        for (Movimientos mov : listaFiltrada) {
            Object[] objeto = {mov.getFechaFormateada(), mov.getCliente(), mov.getDestino(), mov.getRemito(), mov.getBultos(), mov.getMonto(), mov.getTipoMonto(), mov.getFlete(), mov.getTipoFlete(), mov.getFleteDestinoOrigen(), mov.getRepresentante(), mov.getCuentaCorriente(), mov.getObservaciones()};
            tabla.addRow(objeto);
        }

        tablaMovimientos.setModel(tabla);
    }

    private void mostrarTablaMovimientos(List<Movimientos> listaMovimientos) {
        // Filas y columnas no editables
        DefaultTableModel tabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Nombres de columnas
        String titulos[] = {"FECHA", "CLIENTE", "DESTINO", "REMITO", "BULTOS", "MONTO", "PAGADO", "FLETE", "PAGADO", "A_CARGO_DE", "REPRESENTANTE", "CC", "OBS"};
        tabla.setColumnIdentifiers(titulos);

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tabla);
        tablaMovimientos.setRowSorter(sorter);
        sorter.setSortKeys(java.util.Arrays.asList(new RowSorter.SortKey(1, SortOrder.DESCENDING)));

        // Carga de los datos desde la lista filtrada
        for (Movimientos mov : listaMovimientos) {
            Object[] objeto = {mov.getFechaFormateada(), mov.getCliente(), mov.getDestino(), mov.getRemito(), mov.getBultos(), mov.getMonto(), mov.getTipoMonto(), mov.getFlete(), mov.getTipoFlete(), mov.getFleteDestinoOrigen(), mov.getRepresentante(), mov.getCuentaCorriente(), mov.getObservaciones()};

            tabla.addRow(objeto);
        }

        tablaMovimientos.setModel(tabla);
    }

    //LLENAR TEXTFIELD CLIENTES
    private void cargarClientes() {
        ModeloCliente modClientes = new ModeloCliente();
        ArrayList<Cliente> listaClientes = modClientes.getClientes();
        AutoCompleteDecorator.decorate(txtCliente, listaClientes, false);

        // Agregar un listener al textfield del cliente
        txtCliente.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarLocalidad();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarLocalidad();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarLocalidad();
            }

            private void actualizarLocalidad() {

                //carga de los datos desde la bd
                List<Cliente> listaC = control.traerClientes();
                // Buscar el cliente correspondiente en la lista
                String nombreCliente = txtCliente.getText().trim().toLowerCase();
                for (Cliente cliente : listaC) {
                    if (cliente.getNombre().toLowerCase().equals(nombreCliente)) {
                        // Mostrar la localidad en el textfield correspondiente
                        txtDomicilio.setText(cliente.getDireccion());
                        return;
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        cbReciboSin = new javax.swing.JRadioButton();
        cbReciboCon = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDomicilio = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTotalMonto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTotalFlete = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMovimientos = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recibos Expreso Lestani SRL");
        setBackground(new java.awt.Color(66, 66, 66));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(66, 66, 66));
        jPanel1.setFocusable(false);

        buttonGroup1.add(cbReciboSin);
        cbReciboSin.setForeground(new java.awt.Color(255, 255, 255));
        cbReciboSin.setText("Recibo Sin Flete");
        cbReciboSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbReciboSinActionPerformed(evt);
            }
        });

        buttonGroup1.add(cbReciboCon);
        cbReciboCon.setForeground(new java.awt.Color(255, 255, 255));
        cbReciboCon.setText("Recibo Con Flete");
        cbReciboCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbReciboConActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Señores:");

        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });
        txtCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClienteKeyTyped(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Recibo N°");

        jTextField2.setText("0001");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Domicilio:");

        jTextField1.setText("PAGO CONTRAREEMBOLSO");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("En Concepto de:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("RECIBI DE EXPRESSO LESTANI LA SUMA DE: ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("TOTAL MONTO:  $ ");

        txtTotalMonto.setText("0");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("TOTAL FLETE:  $");

        txtTotalFlete.setText("0");

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tablaMovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaMovimientos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalFlete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 429, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbReciboSin)
                                .addGap(34, 34, 34)
                                .addComponent(cbReciboCon))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbReciboSin)
                    .addComponent(cbReciboCon))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTotalMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtTotalFlete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //mostrarTablaMovimientos(List<Movimientos> listaMovimientos);
    }//GEN-LAST:event_formWindowOpened

    private void txtClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyTyped

    }//GEN-LAST:event_txtClienteKeyTyped

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed

    }//GEN-LAST:event_txtClienteActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int[] filasSeleccionadas = tablaMovimientos.getSelectedRows();
                double sumaMontos = 0.0;
                double sumaFletes = 0.0;

                boolean reciboSinFlete = cbReciboSin.isSelected();

                for (int fila : filasSeleccionadas) {
                    String montoStr = tablaMovimientos.getValueAt(fila, 5).toString().substring(1).replace(".", "").replace(",", ".");

                    double monto = Double.parseDouble(montoStr);
                    sumaMontos += monto;

                    if (!reciboSinFlete) {
                        String fleteStr = tablaMovimientos.getValueAt(fila, 7).toString().substring(1).replace(".", "").replace(",", ".");
                        double flete = Double.parseDouble(fleteStr);
                        sumaFletes += flete;
                    }
                }

                System.out.println("Suma de montos: " + sumaMontos);
                System.out.println("Suma de fletes: " + sumaFletes);
                // Crear un objeto DecimalFormatSymbols con los símbolos personalizados
                DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
                simbolos.setGroupingSeparator('.');
                simbolos.setDecimalSeparator(',');
                DecimalFormat decimalFormat = new DecimalFormat("###,###.##", simbolos);

                // Crear el objeto DecimalFormat con el formato y los símbolos personalizados
                //DecimalFormat decimalFormat = new DecimalFormat("#,###.###", new DecimalFormatSymbols(Locale.US));
                // Formatear el resultado con tres decimales
                String fleteTotalFormateado = decimalFormat.format(sumaFletes);
                String montoTotalFormateado = decimalFormat.format(sumaMontos);

                txtTotalMonto.setText(montoTotalFormateado);
                txtTotalMonto.setEditable(false);

                txtTotalFlete.setText(fleteTotalFormateado);
                txtTotalFlete.setEditable(false);
            }
        });

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cbReciboSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbReciboSinActionPerformed
        boolean reciboSinFlete = cbReciboSin.isSelected();

        TableColumn fleteColumn = tablaMovimientos.getColumnModel().getColumn(7);
        TableColumn pagadoColumn = tablaMovimientos.getColumnModel().getColumn(8);

        if (reciboSinFlete) {
            // Ocultar las columnas "flete" y "pagado"
            fleteColumn.setMinWidth(0);
            fleteColumn.setMaxWidth(0);
            fleteColumn.setWidth(0);
            pagadoColumn.setMinWidth(0);
            pagadoColumn.setMaxWidth(0);
            pagadoColumn.setWidth(0);
        } else {
            // Mostrar nuevamente las columnas "flete" y "pagado"
            fleteColumn.setMinWidth(75);  // Ajusta los tamaños de columna según tus necesidades
            fleteColumn.setMaxWidth(100);
            fleteColumn.setWidth(100);
            pagadoColumn.setMinWidth(75);
            pagadoColumn.setMaxWidth(100);
            pagadoColumn.setWidth(100);
        }

        // Actualizar el cálculo del flete total
        if (!reciboSinFlete) {
            calcularTotales();
        } else {
            txtTotalFlete.setText("");
        }

        // Actualizar la tabla para reflejar los cambios
        tablaMovimientos.getTableHeader().resizeAndRepaint();
        tablaMovimientos.repaint();
    }//GEN-LAST:event_cbReciboSinActionPerformed

    private void cbReciboConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbReciboConActionPerformed
        boolean reciboConFlete = cbReciboCon.isSelected();

        TableColumn fleteColumn = tablaMovimientos.getColumnModel().getColumn(7);
        TableColumn pagadoColumn = tablaMovimientos.getColumnModel().getColumn(8);

        if (reciboConFlete) {
            // Mostrar las columnas "flete" y "pagado"
            fleteColumn.setMinWidth(75);  // Ajusta los tamaños de columna según tus necesidades
            fleteColumn.setMaxWidth(100);
            fleteColumn.setWidth(100);
            pagadoColumn.setMinWidth(75);
            pagadoColumn.setMaxWidth(100);
            pagadoColumn.setWidth(100);
        } else {
            // Ocultar las columnas "flete" y "pagado"
            fleteColumn.setMinWidth(0);
            fleteColumn.setMaxWidth(75);
            fleteColumn.setWidth(75);
            pagadoColumn.setMinWidth(0);
            pagadoColumn.setMaxWidth(75);
            pagadoColumn.setWidth(75);
        }

        // Actualizar la tabla para reflejar los cambios
        tablaMovimientos.getTableHeader().resizeAndRepaint();
        tablaMovimientos.repaint();
    }//GEN-LAST:event_cbReciboConActionPerformed

    private void calcularTotales() {
        int rowCount = tablaMovimientos.getRowCount();
        double sumaMontos = 0.0;
        double sumaFletes = 0.0;

        for (int fila = 0; fila < rowCount; fila++) {
            String montoStr = tablaMovimientos.getValueAt(fila, 5).toString().substring(1).replace(".", "").replace(",", ".");
            String fleteStr = tablaMovimientos.getValueAt(fila, 7).toString().substring(1).replace(".", "").replace(",", ".");

            double monto = Double.parseDouble(montoStr);
            double flete = Double.parseDouble(fleteStr);

            sumaMontos += monto;

            if (cbReciboCon.isSelected()) {
                sumaFletes += flete;
            }

        }
        // Crear un objeto DecimalFormatSymbols con los símbolos personalizados
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setGroupingSeparator('.');
        simbolos.setDecimalSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat("###,###.##", simbolos);

        // Crear el objeto DecimalFormat con el formato y los símbolos personalizados
        //DecimalFormat decimalFormat = new DecimalFormat("#,###.###", new DecimalFormatSymbols(Locale.US));
        // Formatear el resultado con tres decimales
        String fleteTotalFormateado = decimalFormat.format(sumaFletes);

        if (cbReciboCon.isSelected()) {
            txtTotalFlete.setText(fleteTotalFormateado);
            txtTotalFlete.setEditable(false);
        } else {
            txtTotalFlete.setText("");
            txtTotalFlete.setEditable(true);
        }
    }

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
            java.util.logging.Logger.getLogger(Recibos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recibos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recibos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recibos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Recibos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cbReciboCon;
    private javax.swing.JRadioButton cbReciboSin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tablaMovimientos;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtTotalFlete;
    private javax.swing.JTextField txtTotalMonto;
    // End of variables declaration//GEN-END:variables
//TABLA CONSULTAS
    private JTable mostrarTablaMovimientos() {
        //filas y columnas no editables
        DefaultTableModel tabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        //nombres de columnas
        String titulos[] = {"FECHA", "CLIENTE", "DESTINO", "REMITO", "BULTOS", "MONTO", "PAGADO", "A_CARGO_DE", "REPRESENTANTE", "CC", "OBS"};
        tabla.setColumnIdentifiers(titulos);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tabla);
        tablaMovimientos.setRowSorter(sorter);
        sorter.setSortKeys(java.util.Arrays.asList(new RowSorter.SortKey(1, SortOrder.DESCENDING)));
        //carga de los datos desde la bd
        List<Movimientos> listaMovimientos = control.traerMovimientos();

        //recorrer lista y mostrar elementos en la tabla
        if (listaMovimientos != null) {
            for (Movimientos mov : listaMovimientos) {
                Object[] objeto = {mov.getFechaFormateada(), mov.getCliente(), mov.getDestino(), mov.getRemito(), mov.getBultos(), mov.getMonto(), mov.getTipoMonto(), mov.getFleteDestinoOrigen(), mov.getRepresentante(), mov.getCuentaCorriente(), mov.getObservaciones()};

                tabla.addRow(objeto);

            }
        }
        tablaMovimientos.setModel(tabla);
        tablaMovimientos.getModel();
        JTable tab = new JTable(tabla);
        return tab;
    }

}
