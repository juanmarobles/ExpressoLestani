/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.lestanitest.igu;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.mycompany.lestanitest.logica.Cliente;
import com.mycompany.lestanitest.logica.Controladora;
import com.mycompany.lestanitest.logica.ModeloCliente;
import com.mycompany.lestanitest.logica.Movimientos;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
import java.util.Scanner;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.swing.JOptionPane;
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
    private int numeroRecibo = 0;

    /**
     * Creates new form Recibos
     */
    public Recibos(String cliente, List<Movimientos> listaFiltrada, String fechaDesde, String fechaHasta) {
        this.cliente = cliente;
        this.listaFiltrada = listaFiltrada;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        initComponents();
        txtCliente.setText(cliente);
        cargarClientes();
        // Cargar el número de recibo desde el archivo (si existe)
        cargarNumeroRecibo();
        txtReciboNro.setText(String.format("%05d", numeroRecibo));
        cargarTablaMovimientos();
    }

    private void guardarNumeroRecibo() {
        try {
            // Crear un archivo de texto para almacenar el número de recibo
            File archivo = new File("numerorecibo.txt");

            // Escribir el valor del número de recibo en el archivo
            FileWriter escritor = new FileWriter(archivo);
            escritor.write(Integer.toString(numeroRecibo));
            escritor.close();
        } catch (IOException e) {
            // Manejar el error de escritura del archivo
            e.printStackTrace();
        }
    }

    private void cargarNumeroRecibo() {
        try {
            // Abrir el archivo de texto para cargar el número de recibo (si existe)
            File archivo = new File("numerorecibo.txt");
            if (archivo.exists()) {
                // Leer el valor del número de recibo desde el archivo
                FileReader lector = new FileReader(archivo);
                BufferedReader buffer = new BufferedReader(lector);
                String linea = buffer.readLine();
                if (linea != null && !linea.isEmpty()) {
                    numeroRecibo = Integer.parseInt(linea);
                }
                buffer.close();
            }
        } catch (IOException e) {
            // Manejar el error de lectura del archivo
            e.printStackTrace();
        }
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
        txtReciboNro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDomicilio = new javax.swing.JTextField();
        txtConcepto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtRecibi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTotalMonto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTotalFlete = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMovimientos = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        btnGenerarPdf = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Domicilio:");

        txtConcepto.setText("PAGO CONTRAREEMBOLSO");

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

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(236, 240, 241));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/X_24px.png"))); // NOI18N
        jButton3.setText("Quitar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnGenerarPdf.setBackground(new java.awt.Color(51, 51, 51));
        btnGenerarPdf.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnGenerarPdf.setForeground(new java.awt.Color(236, 240, 241));
        btnGenerarPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pdf_24px-pdf.png"))); // NOI18N
        btnGenerarPdf.setText("Generar PDF");
        btnGenerarPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPdfActionPerformed(evt);
            }
        });

        btnImprimir.setBackground(new java.awt.Color(51, 51, 51));
        btnImprimir.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(236, 240, 241));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/imprimir_24px.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

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
                                .addComponent(txtConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtRecibi, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtReciboNro, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 429, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbReciboSin)
                                .addGap(34, 34, 34)
                                .addComponent(cbReciboCon))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnGenerarPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(txtReciboNro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRecibi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTotalMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtTotalFlete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerarPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        imprimir();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void imprimir() {
        Document document = new Document();
        // Incrementar el contador de recibo
        numeroRecibo++;
        // Generar el número de recibo en formato de 5 dígitos
        String numeroReciboString = String.format("%05d", numeroRecibo);
        try {
            //DIRECTORIO
            String outputPath = System.getProperty("user.home") + File.separator + "Recibo.pdf";
            File outputFile = new File(outputPath);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputFile));
            document.open();

            //FUENTES
            Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
            Font fontColumnas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
            Font fontTotales = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
            Font fontFecha = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
            Font fontFilas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, Font.NORMAL, BaseColor.BLACK);

            //FECHAS
            Chunk chunkFechas = new Chunk("Fecha: " + fechaActual(), fontFecha);
            Paragraph fecha = new Paragraph(chunkFechas);
            fecha.setAlignment(Element.ALIGN_RIGHT);
            fecha.setSpacingAfter(5f); // Espacio después de las fechas (en puntos)
            //RECIBO
            Paragraph nroRecibo = new Paragraph("RECIBO Nro: " + String.format("%05d", numeroRecibo), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL));
            nroRecibo.setAlignment(Element.ALIGN_RIGHT);
            nroRecibo.setSpacingAfter(10f); // Espacio después del título (en puntos)
            // TITULO RECIBO
            Paragraph titulo = new Paragraph("RECIBO", FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD));
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(10f); // Espacio después del título (en puntos)

            // LOGO
            Image logo = Image.getInstance("src/main/java/com/imagenes/ivacuit.jpg");
            logo.scaleToFit(530, 800);
            logo.setAlignment(Element.ALIGN_LEFT);

            // DOC NO VALIDO COMO FACTURA
            Paragraph subtitulo = new Paragraph("DOCUMENTO NO VALIDO COMO FACTURA", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL));
            subtitulo.setAlignment(Element.ALIGN_CENTER);
            subtitulo.setSpacingAfter(10f); // Espacio después del título (en puntos)

            document.add(titulo);
            document.add(fecha);
            document.add(nroRecibo);
            document.add(logo);
            document.add(subtitulo);

            // Crear una tabla para los senores y domicilio         
            PdfPTable senoresdomicilio = new PdfPTable(2);
            senoresdomicilio.setWidthPercentage(100);

            // SENORES
            Phrase senores = new Phrase("SEÑORES: " + txtCliente.getText(), font);
            Paragraph senoresParagraph = new Paragraph(senores);
            senoresParagraph.setAlignment(Element.ALIGN_LEFT);
            document.add(senoresParagraph);

            // DOMICILIO
            Phrase domicilio = new Phrase("DOMICILIO: " + txtDomicilio.getText(), font);
            Paragraph domicilioParagraph = new Paragraph(domicilio);
            domicilioParagraph.setAlignment(Element.ALIGN_LEFT);
            document.add(domicilioParagraph);
            senoresdomicilio.setSpacingBefore(10f);

            // Crear una tabla para recibi y concepto        
            PdfPTable recibiconcepto = new PdfPTable(2);
            recibiconcepto.setWidthPercentage(100);
            // RECIBI LA SUMA D PESOS...
            Phrase texto = new Phrase("\nRECIBÍ DE EXPRESO LESTANI LA SUMA DE PESOS: " + txtRecibi.getText(), font);
            Paragraph textoRecibi = new Paragraph(texto);
            textoRecibi.setAlignment(Element.ALIGN_LEFT);
            document.add(textoRecibi);

            // CONCEPTO DE
            Phrase textodos = new Phrase("\nEN CONCEPTO DE: " + txtConcepto.getText(), font);
            Paragraph textoConcepto = new Paragraph(textodos);
            textoConcepto.setAlignment(Element.ALIGN_LEFT);
            document.add(textoConcepto);

            //TABLA
            // Obtener las filas seleccionadas de la tabla
            int[] filasSeleccionadas = tablaMovimientos.getSelectedRows();

            if (filasSeleccionadas.length > 0) { // Verificar que se hayan seleccionado filas
                PdfPTable table = new PdfPTable(6); // Número de columnas de la tabla
                table.setSpacingBefore(10f); // Espacio antes de la tabla (en puntos)
                table.setSpacingAfter(10f);

                // Ajustar espacio horizontal
                float[] columnWidths = {0.8f, 1f, 0.6f, 0.6f, 1f, 0.6f}; // Anchos de las columnas (proporciones)
                table.setWidths(columnWidths);
                table.setWidthPercentage(100); // Establecer ancho total de la tabla al 100%

                // Agregar las celdas de encabezado a la tabla
                for (int i = 0; i < tablaMovimientos.getColumnCount(); i++) {
                    String col = tablaMovimientos.getColumnName(i);
                    if (!col.equals("REPRESENTANTE") && !col.equals("FLETE") && !col.equals("PAGADO") && !col.equals("CLIENTE") && !col.equals("A_CARGO_DE") && !col.equals("CC") && !col.equals("MOVIMIENTO")) {
                        PdfPCell cell = new PdfPCell(new Phrase(col, fontColumnas));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPaddingBottom(3f); // Espacio inferior de la celda (en puntos)
                        table.addCell(cell);
                    }
                }

                // Obtener los datos de las filas seleccionadas y agregar las celdas de datos a la tabla
                for (int fila : filasSeleccionadas) {
                    for (int col = 0; col < tablaMovimientos.getColumnCount(); col++) {
                        String colName = tablaMovimientos.getColumnName(col);
                        if (!colName.equals("REPRESENTANTE") && !colName.equals("FLETE") && !colName.equals("PAGADO") && !colName.equals("CLIENTE") && !colName.equals("A_CARGO_DE") && !colName.equals("CC") && !colName.equals("MOVIMIENTO")) {
                            Object value = tablaMovimientos.getValueAt(fila, col);
                            if (value != null) {
                                PdfPCell cell = new PdfPCell(new Phrase(value.toString(), fontFilas));
                                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                cell.setPaddingBottom(3f); // Espacio inferior de la celda (en puntos)
                                table.addCell(cell);
                            }
                        }
                    }
                }

                document.add(table);
            } else {
                // Si no se ha seleccionado ninguna fila, mostrar un mensaje de error o realizar alguna acción adecuada.
            }

            recibiconcepto.setSpacingBefore(10f);

            document.add(senoresdomicilio);
            document.add(recibiconcepto);

            // Crear una tabla para los montos totales
            PdfPTable totalsTable = new PdfPTable(2);
            totalsTable.setWidthPercentage(100);

            // Monto total
            // Establecer la fuente deseada
            Phrase montoTotalPhrase = new Phrase("TOTAL MONTO: $" + txtTotalMonto.getText(), fontTotales);
            PdfPCell montoTotalCell = new PdfPCell(montoTotalPhrase);
            montoTotalCell.setBorder(Rectangle.NO_BORDER);
            montoTotalCell.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear la celda al centro
            totalsTable.addCell(montoTotalCell);

            // Flete total
            Phrase fleteTotalPhrase = new Phrase("TOTAL FLETE: $" + txtTotalFlete.getText(), fontTotales);
            PdfPCell fleteTotalCell = new PdfPCell(fleteTotalPhrase);
            fleteTotalCell.setBorder(Rectangle.NO_BORDER);
            fleteTotalCell.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear la celda al centro
            totalsTable.addCell(fleteTotalCell);

            totalsTable.setSpacingBefore(10f);
            document.add(totalsTable);

            imprimirPdf(outputPath);
            document.close();

            JOptionPane.showMessageDialog(null, "El archivo se generó correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (DocumentException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el archivo PDF.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void imprimirPdf(String filePath) {
        try {
            // Obtener la impresora predeterminada
            PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

            // Obtener las preferencias de impresión del usuario
            PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
            attributeSet.add(new Copies(1));

            // Crear el documento a imprimir
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc doc = new SimpleDoc(new FileInputStream(filePath), flavor, null);

            // Crear el trabajo de impresión
            DocPrintJob printJob = defaultPrintService.createPrintJob();

            // Enviar el documento a imprimir
            printJob.print(doc, attributeSet);

            System.out.println("El archivo PDF se ha enviado a imprimir correctamente.");
        } catch (PrintException | FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al imprimir el archivo PDF.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void btnGenerarPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPdfActionPerformed
        if (cbReciboSin.isSelected()) {
            generarPdf();
        } else if (cbReciboCon.isSelected()) {
            boolean incluirFlete = cbReciboCon.isSelected();
            generarPDF(incluirFlete);
        }

    }//GEN-LAST:event_btnGenerarPdfActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed
    private void generarPdf() {
        Document document = new Document();
        // Incrementar el contador de recibo
        numeroRecibo++;
        // Generar el número de recibo en formato de 5 dígitos
        String numeroReciboString = String.format("%05d", numeroRecibo);
        try {
            //DIRECTORIO
            String outputPath = System.getProperty("user.home") + File.separator + "Recibo.pdf";
            File outputFile = new File(outputPath);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputFile));
            document.open();

            //FUENTES
            Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
            Font fontColumnas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
            Font fontTotales = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
            Font fontFecha = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
            Font fontFilas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, Font.NORMAL, BaseColor.BLACK);

            //FECHAS
            Chunk chunkFechas = new Chunk("Fecha: " + fechaActual(), fontFecha);
            Paragraph fecha = new Paragraph(chunkFechas);
            fecha.setAlignment(Element.ALIGN_RIGHT);
            fecha.setSpacingAfter(5f); // Espacio después de las fechas (en puntos)
            //RECIBO NRO
            Paragraph nroRecibo = new Paragraph("RECIBO Nro: " + String.format("%05d", numeroRecibo), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL));
            guardarNumeroRecibo();
            nroRecibo.setAlignment(Element.ALIGN_RIGHT);
            nroRecibo.setSpacingAfter(10f); // Espacio después del título (en puntos)
            // TITULO RECIBO
            Paragraph titulo = new Paragraph("RECIBO", FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD));
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(10f); // Espacio después del título (en puntos)

            // LOGO
            Image logo = Image.getInstance("src/main/java/com/imagenes/ivacuit.jpg");
            logo.scaleToFit(530, 800);
            logo.setAlignment(Element.ALIGN_LEFT);
            // FIRMASELLO
            Image firmasello = Image.getInstance("src/main/java/com/imagenes/firmasello.jpg");
            firmasello.scaleToFit(150, 150);
            firmasello.setAlignment(Element.ALIGN_RIGHT);

            // DOC NO VALIDO COMO FACTURA
            Paragraph subtitulo = new Paragraph("DOCUMENTO NO VALIDO COMO FACTURA", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL));
            subtitulo.setAlignment(Element.ALIGN_CENTER);
            subtitulo.setSpacingAfter(10f); // Espacio después del título (en puntos)

            document.add(titulo);
            document.add(fecha);
            document.add(nroRecibo);
            document.add(logo);
            document.add(subtitulo);

            // Crear una tabla para los senores y domicilio         
            PdfPTable senoresdomicilio = new PdfPTable(2);
            senoresdomicilio.setWidthPercentage(100);

            // Ajustar los anchos de las columnas
            float[] colSenDom = {0.2f, 1f}; // Ancho relativo de las columnas (proporciones)
            senoresdomicilio.setWidths(colSenDom);

            // Columna "Señores"
            Phrase senoresLabel = new Phrase("SEÑORES", font);
            PdfPCell senoresLabelCell = new PdfPCell(new Paragraph(senoresLabel));
            senoresLabelCell.setBorder(Rectangle.BOX);
            senoresLabelCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            senoresLabelCell.setPaddingBottom(5f); // Espacio después de la celda
            senoresdomicilio.addCell(senoresLabelCell);

            // Contenido de la columna "Señores"
            Phrase senoresValue = new Phrase(txtCliente.getText(), font);
            PdfPCell senoresValueCell = new PdfPCell(new Paragraph(senoresValue));
            senoresValueCell.setBorder(Rectangle.BOX);
            senoresValueCell.setPadding(5f);
            senoresValueCell.setPaddingBottom(5f); // Espacio después de la celda
            senoresdomicilio.addCell(senoresValueCell);

            // Columna "Domicilio"
            Phrase domicilioLabel = new Phrase("DOMICILIO", font);
            PdfPCell domicilioLabelCell = new PdfPCell(new Paragraph(domicilioLabel));
            domicilioLabelCell.setBorder(Rectangle.BOX);
            domicilioLabelCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            domicilioLabelCell.setPaddingBottom(5f); // Espacio después de la celda
            senoresdomicilio.addCell(domicilioLabelCell);

            // Contenido de la columna "Domicilio"
            Phrase domicilioValue = new Phrase(txtDomicilio.getText(), font);
            PdfPCell domicilioValueCell = new PdfPCell(new Paragraph(domicilioValue));
            domicilioValueCell.setBorder(Rectangle.BOX);
            domicilioValueCell.setPadding(5f);
            domicilioValueCell.setPaddingBottom(5f); // Espacio después de la celda
            senoresdomicilio.addCell(domicilioValueCell);

            senoresdomicilio.setSpacingBefore(0.1f);
            document.add(senoresdomicilio);

            // Crear una tabla para recibi y concepto        
            PdfPTable recibiconcepto = new PdfPTable(2);
            recibiconcepto.setWidthPercentage(100);
            // RECIBI LA SUMA D PESOS...
            Phrase texto = new Phrase("\nRECIBÍ DE EXPRESO LESTANI LA SUMA DE PESOS: " + txtRecibi.getText(), font);
            Paragraph textoRecibi = new Paragraph(texto);
            textoRecibi.setAlignment(Element.ALIGN_LEFT);
            document.add(textoRecibi);

            // CONCEPTO DE
            Phrase textodos = new Phrase("\nEN CONCEPTO DE: " + txtConcepto.getText(), font);
            Paragraph textoConcepto = new Paragraph(textodos);
            textoConcepto.setAlignment(Element.ALIGN_LEFT);
            document.add(textoConcepto);

            recibiconcepto.setSpacingBefore(8f);

            document.add(recibiconcepto);

            //TABLA
            // Obtener las filas seleccionadas de la tabla
            int[] filasSeleccionadas = tablaMovimientos.getSelectedRows();

            if (filasSeleccionadas.length > 0) { // Verificar que se hayan seleccionado filas
                // Calcular el número de columnas en la tabla
                int numColumnasTabla = 6;

                // Crear la tabla con el número correcto de columnas
                PdfPTable table = new PdfPTable(numColumnasTabla);
                table.setSpacingBefore(10f); // Espacio antes de la tabla (en puntos)
                table.setSpacingAfter(10f);

                // Ajustar espacio horizontal
                float[] columnWidths = {0.8f, 1f, 0.6f, 0.6f, 1f, 0.6f}; // Anchos de las columnas (proporciones)
                table.setWidths(columnWidths);
                table.setWidthPercentage(100); // Establecer ancho total de la tabla al 100%

                // Agregar las celdas de encabezado a la tabla, excluyendo las columnas suprimidas
                for (int i = 0; i < tablaMovimientos.getColumnCount(); i++) {
                    String col = tablaMovimientos.getColumnName(i);
                    if (!col.equals("REPRESENTANTE") && !col.equals("CLIENTE") && !col.equals("PAGADO") && !col.equals("CC") && !col.equals("FLETE") && !col.equals("A_CARGO_DE")) {
                        PdfPCell cell = new PdfPCell(new Phrase(col, fontColumnas));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPaddingBottom(3f); // Espacio inferior de la celda (en puntos)
                        table.addCell(cell);
                    }
                }

                // Obtener los datos de las filas seleccionadas y agregar las celdas de datos a la tabla
                for (int fila : filasSeleccionadas) {
                    // Agregar las celdas de datos excluyendo las columnas suprimidas
                    for (int col = 0; col < tablaMovimientos.getColumnCount(); col++) {
                        String colName = tablaMovimientos.getColumnName(col);
                        if (!colName.equals("REPRESENTANTE") && !colName.equals("CLIENTE") && !colName.equals("PAGADO") && !colName.equals("CC") && !colName.equals("FLETE") && !colName.equals("A_CARGO_DE")) {
                            Object value = tablaMovimientos.getValueAt(fila, col);
                            if (value != null) {
                                PdfPCell cell = new PdfPCell(new Phrase(value.toString(), fontFilas));
                                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                cell.setPaddingBottom(3f); // Espacio inferior de la celda (en puntos)
                                table.addCell(cell);
                            }
                        }
                    }

                }

                document.add(table);
            } else {
                // Si no se ha seleccionado ninguna fila, mostrar un mensaje de error o realizar alguna acción adecuada.
            }

            // Crear una tabla para los montos totales
            PdfPTable totalsTable = new PdfPTable(1);
            totalsTable.setWidthPercentage(100);

            // Monto total
            // Establecer la fuente deseada
            Phrase montoTotalPhrase = new Phrase("TOTAL MONTO: $" + txtTotalMonto.getText(), fontTotales);
            PdfPCell montoTotalCell = new PdfPCell(montoTotalPhrase);
            montoTotalCell.setBorder(Rectangle.NO_BORDER);
            montoTotalCell.setHorizontalAlignment(Element.ALIGN_LEFT); // Alinear la celda a la izq
            totalsTable.addCell(montoTotalCell);


            totalsTable.setSpacingBefore(10f);
            document.add(totalsTable);
            document.add(firmasello);

            document.close();
            txtReciboNro.setText(String.valueOf(numeroRecibo));
            JOptionPane.showMessageDialog(null, "El archivo se generó correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (DocumentException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el archivo PDF.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void generarPDF(boolean incluirFlete) {
        Document document = new Document();
        // Incrementar el contador de recibo
        numeroRecibo++;
        // Generar el número de recibo en formato de 5 dígitos
        String numeroReciboString = String.format("%05d", numeroRecibo);

        try {

            //DIRECTORIO
            String outputPath = System.getProperty("user.home") + File.separator + "Recibo.pdf";
            File outputFile = new File(outputPath);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputFile));
            document.open();

            //FUENTES
            Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
            Font fontColumnas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);
            Font fontTotales = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
            Font fontFecha = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
            Font fontFilas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, Font.NORMAL, BaseColor.BLACK);

            //FECHAS
            Chunk chunkFechas = new Chunk("Fecha: " + fechaActual(), fontFecha);
            Paragraph fecha = new Paragraph(chunkFechas);
            fecha.setAlignment(Element.ALIGN_RIGHT);
            fecha.setSpacingAfter(5f); // Espacio después de las fechas (en puntos)
            //RECIBO NRO
            Paragraph nroRecibo = new Paragraph("RECIBO Nro: " + String.format("%05d", numeroRecibo), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL));
            guardarNumeroRecibo();
            nroRecibo.setAlignment(Element.ALIGN_RIGHT);
            nroRecibo.setSpacingAfter(10f); // Espacio después del título (en puntos)
            // TITULO RECIBO
            Paragraph titulo = new Paragraph("RECIBO", FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD));
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(10f); // Espacio después del título (en puntos)

            // LOGO
            Image logo = Image.getInstance("src/main/java/com/imagenes/ivacuit.jpg");
            logo.scaleToFit(530, 800);
            logo.setAlignment(Element.ALIGN_LEFT);
            // FIRMASELLO
            Image firmasello = Image.getInstance("src/main/java/com/imagenes/firmasello.jpg");
            firmasello.scaleToFit(150, 150);
            firmasello.setAlignment(Element.ALIGN_RIGHT);

            // DOC NO VALIDO COMO FACTURA
            Paragraph subtitulo = new Paragraph("DOCUMENTO NO VALIDO COMO FACTURA", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL));
            subtitulo.setAlignment(Element.ALIGN_CENTER);
            subtitulo.setSpacingAfter(10f); // Espacio después del título (en puntos)

            document.add(titulo);
            document.add(fecha);
            document.add(nroRecibo);
            document.add(logo);
            document.add(subtitulo);

            // Crear una tabla para los senores y domicilio         
            PdfPTable senoresdomicilio = new PdfPTable(2);
            senoresdomicilio.setWidthPercentage(100);

            // Ajustar los anchos de las columnas
            float[] colSenDom = {0.2f, 1f}; // Ancho relativo de las columnas (proporciones)
            senoresdomicilio.setWidths(colSenDom);

            // Columna "Señores"
            Phrase senoresLabel = new Phrase("SEÑORES", font);
            PdfPCell senoresLabelCell = new PdfPCell(new Paragraph(senoresLabel));
            senoresLabelCell.setBorder(Rectangle.BOX);
            senoresLabelCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            senoresLabelCell.setPaddingBottom(5f); // Espacio después de la celda
            senoresdomicilio.addCell(senoresLabelCell);

            // Contenido de la columna "Señores"
            Phrase senoresValue = new Phrase(txtCliente.getText(), font);
            PdfPCell senoresValueCell = new PdfPCell(new Paragraph(senoresValue));
            senoresValueCell.setBorder(Rectangle.BOX);
            senoresValueCell.setPadding(5f);
            senoresValueCell.setPaddingBottom(5f); // Espacio después de la celda
            senoresdomicilio.addCell(senoresValueCell);

            // Columna "Domicilio"
            Phrase domicilioLabel = new Phrase("DOMICILIO", font);
            PdfPCell domicilioLabelCell = new PdfPCell(new Paragraph(domicilioLabel));
            domicilioLabelCell.setBorder(Rectangle.BOX);
            domicilioLabelCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            domicilioLabelCell.setPaddingBottom(5f); // Espacio después de la celda
            senoresdomicilio.addCell(domicilioLabelCell);

            // Contenido de la columna "Domicilio"
            Phrase domicilioValue = new Phrase(txtDomicilio.getText(), font);
            PdfPCell domicilioValueCell = new PdfPCell(new Paragraph(domicilioValue));
            domicilioValueCell.setBorder(Rectangle.BOX);
            domicilioValueCell.setPadding(5f);
            domicilioValueCell.setPaddingBottom(5f); // Espacio después de la celda
            senoresdomicilio.addCell(domicilioValueCell);

            senoresdomicilio.setSpacingBefore(0.1f);
            document.add(senoresdomicilio);

            // Crear una tabla para recibi y concepto        
            PdfPTable recibiconcepto = new PdfPTable(2);
            recibiconcepto.setWidthPercentage(100);
            // RECIBI LA SUMA D PESOS...
            Phrase texto = new Phrase("\nRECIBÍ DE EXPRESO LESTANI LA SUMA DE PESOS: " + txtRecibi.getText(), font);
            Paragraph textoRecibi = new Paragraph(texto);
            textoRecibi.setAlignment(Element.ALIGN_LEFT);
            document.add(textoRecibi);

            // CONCEPTO DE
            Phrase textodos = new Phrase("\nEN CONCEPTO DE: " + txtConcepto.getText(), font);
            Paragraph textoConcepto = new Paragraph(textodos);
            textoConcepto.setAlignment(Element.ALIGN_LEFT);
            document.add(textoConcepto);

            recibiconcepto.setSpacingBefore(8f);

            document.add(recibiconcepto);
            
           //TABLA
            // Obtener las filas seleccionadas de la tabla
            int[] filasSeleccionadas = tablaMovimientos.getSelectedRows();

            if (filasSeleccionadas.length > 0) { // Verificar que se hayan seleccionado filas
                // Calcular el número de columnas en la tabla
                int numColumnasTabla = 8;

                // Crear la tabla con el número correcto de columnas
                PdfPTable table = new PdfPTable(numColumnasTabla);
                table.setSpacingBefore(10f); // Espacio antes de la tabla (en puntos)
                table.setSpacingAfter(10f);

                // Ajustar espacio horizontal
                float[] columnWidths = {0.8f, 1f, 0.7f, 0.7f, 1f,1f,1f, 1f}; // Anchos de las columnas (proporciones)
                table.setWidths(columnWidths);
                table.setWidthPercentage(100); // Establecer ancho total de la tabla al 100%

                // Agregar las celdas de encabezado a la tabla, excluyendo las columnas suprimidas
                for (int i = 0; i < tablaMovimientos.getColumnCount(); i++) {
                    String col = tablaMovimientos.getColumnName(i);
                    if (!col.equals("PAGADO") && !col.equals("REPRESENTANTE") && !col.equals("CLIENTE") && !col.equals("CC")) {
                        PdfPCell cell = new PdfPCell(new Phrase(col, fontColumnas));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPaddingBottom(3f); // Espacio inferior de la celda (en puntos)
                        table.addCell(cell);
                    }
                }

                // Obtener los datos de las filas seleccionadas y agregar las celdas de datos a la tabla
                for (int fila : filasSeleccionadas) {
                    // Agregar las celdas de datos excluyendo las columnas suprimidas
                    for (int col = 0; col < tablaMovimientos.getColumnCount(); col++) {
                        String colName = tablaMovimientos.getColumnName(col);
                        if (!colName.equals("REPRESENTANTE") && !colName.equals("CLIENTE") && !colName.equals("PAGADO") && !colName.equals("CC")) {
                            Object value = tablaMovimientos.getValueAt(fila, col);
                            if (value != null) {
                                PdfPCell cell = new PdfPCell(new Phrase(value.toString(), fontFilas));
                                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                cell.setPaddingBottom(3f); // Espacio inferior de la celda (en puntos)
                                table.addCell(cell);
                            }
                        }
                    }

                }

                document.add(table);
            } else {
                // Si no se ha seleccionado ninguna fila, mostrar un mensaje de error o realizar alguna acción adecuada.
            }

            // Crear una tabla para los montos totales
            PdfPTable totalsTable = new PdfPTable(2);
            totalsTable.setWidthPercentage(100);

            // Monto total
            // Establecer la fuente deseada
            Phrase montoTotalPhrase = new Phrase("TOTAL MONTO: $" + txtTotalMonto.getText(), fontTotales);
            PdfPCell montoTotalCell = new PdfPCell(montoTotalPhrase);
            montoTotalCell.setBorder(Rectangle.NO_BORDER);
            montoTotalCell.setHorizontalAlignment(Element.ALIGN_LEFT); // Alinear la celda al centro
            totalsTable.addCell(montoTotalCell);

            // Flete total
            Phrase fleteTotalPhrase = new Phrase("TOTAL FLETE: $" + txtTotalFlete.getText(), fontTotales);
            PdfPCell fleteTotalCell = new PdfPCell(fleteTotalPhrase);
            fleteTotalCell.setBorder(Rectangle.NO_BORDER);
            fleteTotalCell.setHorizontalAlignment(Element.ALIGN_RIGHT); // Alinear la celda al centro
            totalsTable.addCell(fleteTotalCell);

            totalsTable.setSpacingBefore(10f);
            document.add(totalsTable);
            document.add(firmasello);

            document.close();
            txtReciboNro.setText(String.valueOf(numeroRecibo));
            JOptionPane.showMessageDialog(null, "El archivo se generó correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (DocumentException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el archivo PDF.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(Recibos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recibos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recibos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recibos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnGenerarPdf;
    private javax.swing.JButton btnImprimir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cbReciboCon;
    private javax.swing.JRadioButton cbReciboSin;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JTable tablaMovimientos;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtConcepto;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtRecibi;
    private javax.swing.JTextField txtReciboNro;
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

    //FECHA ACTUAL
    public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
    }

}
