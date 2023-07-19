/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.lestanitest.igu;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.mycompany.lestanitest.logica.Controladora;
import com.mycompany.lestanitest.logica.ModeloMovimientos;
import com.mycompany.lestanitest.logica.Movimientos;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfAnnotation;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class Consultas extends javax.swing.JFrame {

    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    Controladora control = new Controladora();
    TableRowSorter trs;
    DefaultTableModel tabla = new DefaultTableModel();
    private SimpleDateFormat sdf;
    private String montoTotalImpreso;
    private String fleteTotalImpreso;
    //Nuevo
   // private List<Movimientos> listaFiltrada;
    private boolean mostrarPagados = false;
    private boolean mostrarNoPagados = false;
    private boolean mostrarTodos = true;
    private boolean botonMostrarPresionado = false;
    private boolean mostrarFPagados = false;
private boolean mostrarFNoPagados = false;
private boolean mostrarFTodos = true;

    public Consultas() {
        initComponents();
         mostrarTablaMovimientos(control.traerMovimientos());
        cargarSugerencias();
        txtFechaHasta.setText(fechaActual());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
         txtTotalMonto.setEditable(false);
         txtTotalFlete.setEditable(false);
         txtCantBultos.setEditable(false);
         
         //Listener para evitar que pongan letras en Fletes
         KeyListener keyListener = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                JTextField textField = (JTextField) e.getSource();
                char c = e.getKeyChar();

                // Verificar si el carácter no es un número o un punto
                if (!Character.isDigit(c) && c != '.') {
                    // Mostrar una alerta solo si la cadena no contiene solo números y puntos

                    if (!textField.getText().matches("[\\d.]*")) {
                        JOptionPane.showMessageDialog(null, "Solo se permiten números y puntos decimales.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    // Consumir el evento para evitar que el carácter se ingrese en el JTextField
                    e.consume();
                }
            }
        };

        txtFleteCambio.addKeyListener(keyListener);
        
        
    }

    private void cargarSugerencias() {
        ModeloMovimientos modClientes = new ModeloMovimientos();
        ArrayList<Movimientos> listaClientes = modClientes.getMovimientos();
        AutoCompleteDecorator.decorate(txtCliente, listaClientes, false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Grupo2 = new javax.swing.ButtonGroup();
        Grupo1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnMostrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbPagados = new javax.swing.JRadioButton();
        cbNoPagados = new javax.swing.JRadioButton();
        cbmTodos = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbFletePagado = new javax.swing.JRadioButton();
        cbFleteNoPagado = new javax.swing.JRadioButton();
        cbfTodos = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConsultas = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtTotalMonto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTotalFlete = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtCantBultos = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtFechaDesde = new javax.swing.JFormattedTextField();
        txtFechaHasta = new javax.swing.JFormattedTextField();
        CuentaCorriente = new javax.swing.JCheckBox();
        btnImprimir = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        btnMPFletes = new javax.swing.JButton();
        btnMPMontos = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btnMRFletes = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtFleteCambio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnCambiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Expreso Lestani S.R.L - Consultas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(66, 66, 66));
        jPanel1.setForeground(new java.awt.Color(66, 66, 66));

        jLabel1.setBackground(new java.awt.Color(66, 66, 66));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(236, 240, 241));
        jLabel1.setText("Cliente");

        btnMostrar.setBackground(new java.awt.Color(51, 51, 51));
        btnMostrar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(236, 240, 241));
        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Mostrar_24px.png"))); // NOI18N
        btnMostrar.setText("Mostrar");
        btnMostrar.setBorder(null);
        btnMostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(66, 66, 66));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel3.setBackground(new java.awt.Color(66, 66, 66));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(236, 240, 241));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dinero_24px.png"))); // NOI18N
        jLabel3.setText("Monto");

        cbPagados.setBackground(new java.awt.Color(66, 66, 66));
        Grupo1.add(cbPagados);
        cbPagados.setForeground(new java.awt.Color(236, 240, 241));
        cbPagados.setText("Pagados");
        cbPagados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPagadosActionPerformed(evt);
            }
        });

        cbNoPagados.setBackground(new java.awt.Color(66, 66, 66));
        Grupo1.add(cbNoPagados);
        cbNoPagados.setForeground(new java.awt.Color(236, 240, 241));
        cbNoPagados.setText("No Pagados");
        cbNoPagados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNoPagadosActionPerformed(evt);
            }
        });

        cbmTodos.setBackground(new java.awt.Color(66, 66, 66));
        Grupo1.add(cbmTodos);
        cbmTodos.setForeground(new java.awt.Color(236, 240, 241));
        cbmTodos.setText("Todos");
        cbmTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbNoPagados, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPagados, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbmTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbPagados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbNoPagados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbmTodos)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(66, 66, 66));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setBackground(new java.awt.Color(66, 66, 66));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/camion_24px.png"))); // NOI18N
        jLabel4.setText("Flete");

        cbFletePagado.setBackground(new java.awt.Color(66, 66, 66));
        Grupo2.add(cbFletePagado);
        cbFletePagado.setForeground(new java.awt.Color(236, 240, 241));
        cbFletePagado.setText("Pagados");
        cbFletePagado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFletePagadoActionPerformed(evt);
            }
        });

        cbFleteNoPagado.setBackground(new java.awt.Color(66, 66, 66));
        Grupo2.add(cbFleteNoPagado);
        cbFleteNoPagado.setForeground(new java.awt.Color(236, 240, 241));
        cbFleteNoPagado.setText("No Pagados");
        cbFleteNoPagado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFleteNoPagadoActionPerformed(evt);
            }
        });

        cbfTodos.setBackground(new java.awt.Color(66, 66, 66));
        Grupo2.add(cbfTodos);
        cbfTodos.setForeground(new java.awt.Color(236, 240, 241));
        cbfTodos.setText("Todos");
        cbfTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbfTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbFleteNoPagado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbFletePagado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbfTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(cbFletePagado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbFleteNoPagado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbfTodos)
                .addGap(26, 26, 26))
        );

        tablaConsultas.setBackground(new java.awt.Color(66, 66, 66));
        tablaConsultas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tablaConsultas.setForeground(new java.awt.Color(236, 240, 241));
        tablaConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaConsultas);

        jPanel4.setBackground(new java.awt.Color(66, 66, 66));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel4.setForeground(new java.awt.Color(236, 240, 241));

        txtTotalMonto.setText("0");
        txtTotalMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalMontoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(236, 240, 241));
        jLabel11.setText("Total Monto   $:");

        txtTotalFlete.setText("0");
        txtTotalFlete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalFleteActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(236, 240, 241));
        jLabel12.setText("Total Flete     $:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotalMonto, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(txtTotalFlete))
                .addGap(17, 17, 17))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalFlete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(66, 66, 66));

        jLabel13.setForeground(new java.awt.Color(236, 240, 241));
        jLabel13.setText("Cant. Bultos");

        txtCantBultos.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantBultos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(txtCantBultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(66, 66, 66));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(236, 240, 241));
        jLabel2.setText("Fecha:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(236, 240, 241));
        jLabel9.setText("Desde");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(236, 240, 241));
        jLabel8.setText("Hasta");

        try {
            txtFechaDesde.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtFechaHasta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFechaHasta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)))
                .addGap(19, 19, 19))
        );

        CuentaCorriente.setBackground(new java.awt.Color(66, 66, 66));
        CuentaCorriente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CuentaCorriente.setForeground(new java.awt.Color(236, 240, 241));
        CuentaCorriente.setText("Cuenta Corriente");
        CuentaCorriente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaCorrienteActionPerformed(evt);
            }
        });

        btnImprimir.setBackground(new java.awt.Color(51, 51, 51));
        btnImprimir.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(236, 240, 241));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pdf_24px-pdf.png"))); // NOI18N
        btnImprimir.setText("Generar PDF");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(66, 66, 66));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel14.setForeground(new java.awt.Color(236, 240, 241));
        jLabel14.setText("Marcar como Pagados");

        btnMPFletes.setBackground(new java.awt.Color(51, 51, 51));
        btnMPFletes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnMPFletes.setForeground(new java.awt.Color(236, 240, 241));
        btnMPFletes.setText("Fletes");
        btnMPFletes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMPFletes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMPFletesActionPerformed(evt);
            }
        });

        btnMPMontos.setBackground(new java.awt.Color(51, 51, 51));
        btnMPMontos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnMPMontos.setForeground(new java.awt.Color(236, 240, 241));
        btnMPMontos.setText("Montos");
        btnMPMontos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMPMontos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMPMontosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMPFletes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMPMontos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMPFletes, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMPMontos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jPanel8.setBackground(new java.awt.Color(66, 66, 66));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel15.setForeground(new java.awt.Color(236, 240, 241));
        jLabel15.setText("Marcar como Rendidos");

        btnMRFletes.setBackground(new java.awt.Color(51, 51, 51));
        btnMRFletes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnMRFletes.setForeground(new java.awt.Color(236, 240, 241));
        btnMRFletes.setText("Fletes");
        btnMRFletes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMRFletes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMRFletesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnMRFletes, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(btnMRFletes, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

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

        jButton1.setBackground(new java.awt.Color(66, 66, 66));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/imprimir_24px.png"))); // NOI18N
        jButton1.setText("Imprimir");

        btnLimpiar.setBackground(new java.awt.Color(51, 51, 51));
        btnLimpiar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(236, 240, 241));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(null);
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(66, 66, 66));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel16.setForeground(new java.awt.Color(236, 240, 241));
        jLabel16.setText("Cambiar precio de Flete");

        jLabel5.setText("$");

        btnCambiar.setBackground(new java.awt.Color(51, 51, 51));
        btnCambiar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnCambiar.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiar.setText("Cambiar");
        btnCambiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCambiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFleteCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFleteCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CuentaCorriente, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 415, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CuentaCorriente)
                        .addGap(24, 24, 24)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMPFletesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMPFletesActionPerformed
        cambiarTipoFlete();
    }//GEN-LAST:event_btnMPFletesActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed

        botonMostrarPresionado = true;
          aplicarFiltros();
  
    
    }//GEN-LAST:event_btnMostrarActionPerformed
   
    
    private void aplicarFiltros() {
        // Verificar si se ha presionado el botón "Mostrar"
        if (!botonMostrarPresionado) {
            return;
        }
        List<Movimientos> movimientosFiltrados = control.traerMovimientos();

        // Aplicar los filtros seleccionados
        String clienteFiltrado = txtCliente.getText();
        boolean cuentaCorrienteFiltrada = CuentaCorriente.isSelected();
        // ... otros filtros ...

        // Filtrar por cliente
        if (!clienteFiltrado.isEmpty()) {
            movimientosFiltrados = movimientosFiltrados.stream()
                    .filter(mov -> mov.getCliente().equals(clienteFiltrado))
                    .collect(Collectors.toList());
        }

        // Filtrar por cuenta corriente
        if (cuentaCorrienteFiltrada) {
            movimientosFiltrados = movimientosFiltrados.stream()
                    .filter(mov -> mov.getCuentaCorriente().equals("Si"))
                    .collect(Collectors.toList());
        }

        // Filtrar por fechas
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final Date desdeFecha;
        final Date hastaFecha;

        try {
            desdeFecha = dateFormat.parse(txtFechaDesde.getText());
            hastaFecha = dateFormat.parse(txtFechaHasta.getText());
        } catch (ParseException ex) {
            // Manejar la excepción en caso de que el formato de fecha sea incorrecto
            ex.printStackTrace();
            return; // Salir del método o agregar otro manejo de error según sea necesario
        }

        if (desdeFecha != null && hastaFecha != null) {
             movimientosFiltrados = movimientosFiltrados.stream()
             .filter(mov -> {
            Date fechaMovimiento = mov.getFecha();
            return fechaMovimiento != null && fechaMovimiento.compareTo(desdeFecha) >= 0 && fechaMovimiento.compareTo(hastaFecha) <= 0;
        })
        .collect(Collectors.toList());
}       //Chechbox
        boolean mostrarPagados = cbPagados.isSelected();
        boolean mostrarNoPagados = cbNoPagados.isSelected();
        boolean mostrarFPagados = cbFletePagado.isSelected();
        boolean mostrarFNoPagados = cbFleteNoPagado.isSelected();
        
        //Filtrado de Fletes y Montos
      movimientosFiltrados = movimientosFiltrados.stream()
    .filter(mov -> {
        boolean estadoPagoCumple = true;
        boolean fletesCumple = true;

        // Filtrar por estado de pago
        if (mostrarPagados && !mov.getTipoMontoP().equals("Si")) {
            estadoPagoCumple = false;
        } else if (mostrarNoPagados && !mov.getTipoMontoP().equals("No")) {
            estadoPagoCumple = false;
        }

        // Filtrar por fletes
        if (mostrarFPagados && !mov.getTipoFleteP().equals("Si")) {
            fletesCumple = false;
        } else if (mostrarFNoPagados && !mov.getTipoFleteP().equals("No")) {
            fletesCumple = false;
        }

        return estadoPagoCumple && fletesCumple;
    })
    .collect(Collectors.toList());
      

        // Mostrar la tabla con los movimientos filtrados
        mostrarTablaMovimientos(movimientosFiltrados);
        calcularTotalMonto(movimientosFiltrados);
        calcularTotalFlete(movimientosFiltrados);
        calcularTotalBultos(movimientosFiltrados);
        
        
    }
      private void calcularTotalMonto(List<Movimientos> movimientosFiltrados) {
        // Calcular el total de los montos
        double totalMonto = movimientosFiltrados.stream()
                .mapToDouble(mov -> {
                        String monto = mov.getMonto().replace(".", ""); // Eliminar el separador de miles (punto)
                         monto = monto.replace(",", "."); // Reemplazar la coma por punto decimal
                         monto = monto.replace("$", ""); // Eliminar el signo de dólar
                    try {
                        return Double.parseDouble(monto);
                    } catch (NumberFormatException e) {
                        return 0.0;
                    }
                })
                .sum();
                //Formato de Monto
          DecimalFormatSymbols symbols = new DecimalFormatSymbols();
          symbols.setDecimalSeparator(',');
          symbols.setGroupingSeparator('.');
          DecimalFormat decimalFormat = new DecimalFormat("###,###.00", symbols);
          String totalFormateado = decimalFormat.format(totalMonto);
          
          txtTotalMonto.setText(totalFormateado);
    }
      
      private void calcularTotalFlete(List<Movimientos> movimientosFiltrados) {
    // Calcular el total de los montos
    double totalFlete = movimientosFiltrados.stream()
            .mapToDouble(mov -> {
                String monto = mov.getFlete().replace(".", ""); // Eliminar el separador de miles (punto)
                monto = monto.replace(",", "."); // Reemplazar la coma por punto decimal
                monto = monto.replace("$", ""); // Eliminar el signo de dólar
                try {
                    return Double.parseDouble(monto);
                } catch (NumberFormatException e) {
                    return 0.0;
                }
            })
            .sum();

    DecimalFormatSymbols symbols = new DecimalFormatSymbols();
    symbols.setDecimalSeparator(',');
    symbols.setGroupingSeparator('.');
    DecimalFormat decimalFormat = new DecimalFormat("###,###.00", symbols);
    String totalFormateado = decimalFormat.format(totalFlete);

    txtTotalFlete.setText(totalFormateado);
}
      
    private void calcularTotalBultos(List<Movimientos> movimientosFiltrados){
        int sumaBultos = movimientosFiltrados.stream()
                .mapToInt(Movimientos::getBultos)
                .sum();

        txtCantBultos.setText(String.format("%,d", sumaBultos));
    }

    
    
  
    private void mostrarTablaMovimientos(List<Movimientos> listaMovimientos) {
        //filas y columnas no editables
        DefaultTableModel tabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        //nombres de columnas
        String titulos[] = {"MOVIMIENTO", "FECHA","HORA", "CLIENTE", "DESTINO", "REMITO", "BULTOS", "MONTO", "PAGADO", "RENDIDO", "FLETE", "PAGADO", "RENDIDO", "A_CARGO_DE", "REPRESENTANTE", "CC", "OBS"};
        tabla.setColumnIdentifiers(titulos);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tabla);
        tablaConsultas.setRowSorter(sorter);
        sorter.setSortKeys(java.util.Arrays.asList(new RowSorter.SortKey(1, SortOrder.DESCENDING)));
        //carga de los datos desde la lista filtrada
        if (listaMovimientos != null) {
            for (Movimientos mov : listaMovimientos) {
                Object[] objeto = {mov.getId_movimientos(), mov.getFechaFormateada(),mov.getHora(), mov.getCliente(), mov.getDestino(), mov.getRemito(), mov.getBultos(), mov.getMonto(), mov.getTipoMontoP(), mov.getTipoMontoR(), mov.getFlete(), mov.getTipoFleteP(), mov.getTipoFleteR(), mov.getFleteDestinoOrigen(), mov.getRepresentante(), mov.getCuentaCorriente(), mov.getObservaciones()};
                tabla.addRow(objeto);
            }
        }
        tablaConsultas.setModel(tabla);

        // Establecer el ancho específico de las columnas
        int[] anchos = {60, 50, 100, 100, 40, 30, 100, 30, 30, 100, 30, 30, 60, 100, 5, 200}; // Anchos deseados para cada columna en píxeles

        if (anchos.length == tabla.getColumnCount()) {
            TableColumnModel columnModel = tablaConsultas.getColumnModel();
            for (int i = 0; i < anchos.length; i++) {
                TableColumn columna = columnModel.getColumn(i);
                columna.setPreferredWidth(anchos[i]);

                // Renderizador personalizado para centrar el contenido de las celdas
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setHorizontalAlignment(SwingConstants.CENTER);
                tablaConsultas.setDefaultRenderer(Object.class, renderer);

                // Renderizador personalizado para centrar el título de las columnas
                DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tablaConsultas.getTableHeader().getDefaultRenderer();
                headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            }
        }

    }



    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void txtClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyTyped
     

    }//GEN-LAST:event_txtClienteKeyTyped
    /**
     * CHECK BOX PAGADOS
     * 
     */
     
    private void cbPagadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPagadosActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_cbPagadosActionPerformed

    private void cbNoPagadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNoPagadosActionPerformed
       aplicarFiltros();
    }//GEN-LAST:event_cbNoPagadosActionPerformed

    private void cbmTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmTodosActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_cbmTodosActionPerformed

    private void cbFletePagadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFletePagadoActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_cbFletePagadoActionPerformed

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed

    }//GEN-LAST:event_txtClienteActionPerformed

    private void btnMPMontosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMPMontosActionPerformed
        cambiarTipoMonto();
    }//GEN-LAST:event_btnMPMontosActionPerformed

    private void cbfTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbfTodosActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_cbfTodosActionPerformed

    private void cbFleteNoPagadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFleteNoPagadoActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_cbFleteNoPagadoActionPerformed

    private void btnMRFletesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMRFletesActionPerformed
        cambiarTipoFleteRendido();
    }//GEN-LAST:event_btnMRFletesActionPerformed

    private void txtTotalFleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalFleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalFleteActionPerformed

    private void CuentaCorrienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaCorrienteActionPerformed
        
    }//GEN-LAST:event_CuentaCorrienteActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        generarPDF();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
      /*  txtFechaDesde.setText("");
       // txtFechaHasta.setText("");
        txtCliente.setText("");
        txtTotalMonto.setText("");
        txtTotalFlete.setText("");
        txtCantBultos.setText("");*/
        dispose();
        Consultas con = new Consultas();
        con.setVisible(true);
        
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
       String nuevoMontoFlete = txtFleteCambio.getText();
        double montoDouble = Double.parseDouble(nuevoMontoFlete);// Obtener el nuevo monto de flete ingresado
        cambiarValorFlete(montoDouble);
    }//GEN-LAST:event_btnCambiarActionPerformed

    private void txtTotalMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalMontoActionPerformed
      
    }//GEN-LAST:event_txtTotalMontoActionPerformed
    private void cambiarValorFlete(double nuevoMontoFlete) {
    int[] filasSeleccionadas = tablaConsultas.getSelectedRows(); // Obtener índices de las filas seleccionadas
    String nuevoValorFleteTexto = txtFleteCambio.getText().trim(); // Obtener el nuevo valor del campo de texto
    double nuevoValorFlete = Double.parseDouble(nuevoValorFleteTexto); // Convertir a tipo numérico

    if (filasSeleccionadas.length > 0) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaConsultas.getModel();
        int columnaFlete = 9; // Índice de la columna "Flete" en el modelo de tabla

        for (int filaSeleccionada : filasSeleccionadas) {
            int fila = filaSeleccionada; // Declarar y asignar el valor de filaSeleccionada a fila
            modeloTabla.setValueAt(nuevoMontoFlete, fila, columnaFlete);

            int idMovimientos = (int) modeloTabla.getValueAt(fila, 0);
            Movimientos movimiento = control.traerMovimiento(idMovimientos);

            if (movimiento != null) {
                movimiento.setFlete(nuevoValorFleteTexto); // Guardar el valor sin el signo "$"
                control.actualizarPrecioFlete(movimiento, nuevoValorFleteTexto); // Utilizar el método actualizarPrecioFlete() de la controladora
                String nuevoValorFleteConSigno = "$" + nuevoValorFleteTexto; // Agregar el signo "$"
                modeloTabla.setValueAt(nuevoValorFleteConSigno, fila, columnaFlete); // Actualizar el valor en la columna "FLETE"
            }
        }

        modeloTabla.fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Se cambió el monto de los fletes seleccionados con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, "No se pudo cambiar el monto cargado", "Error", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(Consultas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consultas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consultas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consultas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CuentaCorriente;
    private javax.swing.ButtonGroup Grupo1;
    private javax.swing.ButtonGroup Grupo2;
    private javax.swing.JButton btnCambiar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMPFletes;
    private javax.swing.JButton btnMPMontos;
    private javax.swing.JButton btnMRFletes;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JRadioButton cbFleteNoPagado;
    private javax.swing.JRadioButton cbFletePagado;
    private javax.swing.JRadioButton cbNoPagados;
    private javax.swing.JRadioButton cbPagados;
    private javax.swing.JRadioButton cbfTodos;
    private javax.swing.JRadioButton cbmTodos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaConsultas;
    private javax.swing.JTextField txtCantBultos;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JFormattedTextField txtFechaDesde;
    private javax.swing.JFormattedTextField txtFechaHasta;
    private javax.swing.JTextField txtFleteCambio;
    private javax.swing.JTextField txtTotalFlete;
    private javax.swing.JTextField txtTotalMonto;
    // End of variables declaration//GEN-END:variables

    public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
 
    }
    //Nueva funcion de marcar como pagados Monto
   private void cambiarTipoMonto() {
    int[] filasSeleccionadas = tablaConsultas.getSelectedRows();
    if (filasSeleccionadas.length > 0) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaConsultas.getModel();

        for (int filaSeleccionada : filasSeleccionadas) {
            int idMovimientos = (int) modeloTabla.getValueAt(filaSeleccionada, 0);

            Movimientos movimiento = control.traerMovimiento(idMovimientos); // Reemplaza el método traerMovimiento() según corresponda

            if (movimiento != null) {
                String tipoMonto = (String) modeloTabla.getValueAt(filaSeleccionada, 7);

                if (tipoMonto.equals("No")) {
                    control.actualizarMonto(movimiento, "Si");
                    modeloTabla.setValueAt("Si", filaSeleccionada, 7);
                }
            }
        }

        modeloTabla.fireTableDataChanged();
    }
}
    
    

     //Nuevo metodo para marcar como pagados fletes
   private void cambiarTipoFlete() {
    int[] filasSeleccionadas = tablaConsultas.getSelectedRows();
    if (filasSeleccionadas.length > 0) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaConsultas.getModel();

        for (int filaSeleccionada : filasSeleccionadas) {
            int idMovimientos = (int) modeloTabla.getValueAt(filaSeleccionada, 0);

            Movimientos movimiento = control.traerMovimiento(idMovimientos); // Reemplaza el método traerMovimiento() según corresponda

            if (movimiento != null) {
                String tipoFlete = (String) modeloTabla.getValueAt(filaSeleccionada, 10);

                if (tipoFlete.equals("No")) {
                    control.actualizarFlete(movimiento, "Si");
                    modeloTabla.setValueAt("Si", filaSeleccionada, 10);
                }
            }
        }

        modeloTabla.fireTableDataChanged();
    }
}
   
    private void cambiarTipoFleteRendido() {
        int[] filasSeleccionadas = tablaConsultas.getSelectedRows();
        if (filasSeleccionadas.length > 0) {
            DefaultTableModel modeloTabla = (DefaultTableModel) tablaConsultas.getModel();
            for (int i = 0; i < filasSeleccionadas.length; i++) {
                int filaSeleccionada = filasSeleccionadas[i];
                int idMovimientos = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
                Movimientos movimiento = null;

               

                if (movimiento != null) {
                    String tipoFlete = (String) modeloTabla.getValueAt(filaSeleccionada, 11);
                    if (!tipoFlete.equals("Si")) {
                        movimiento.setTipoFleteR("Si");
                        control.actualizarFlete(movimiento, "Si");
                        modeloTabla.setValueAt("Si", filaSeleccionada, 11);
                    }
                }
            }
            modeloTabla.fireTableDataChanged();
        }

    }

    //IMPRIMIR CONSULTAS
    private void generarPDF() {
        Document document = new Document();
        try {
            // Crear un diálogo de selección de archivo
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar PDF");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            // Mostrar el diálogo de selección de archivo
            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                // Obtener el archivo seleccionado por el usuario
                File selectedFile = fileChooser.getSelectedFile();
                String outputPath = selectedFile.getAbsolutePath();

                // Agregar la extensión ".pdf" al nombre del archivo si no está presente
                if (!outputPath.toLowerCase().endsWith(".pdf")) {
                    outputPath += ".pdf";
                }

                // Crear el archivo de salida
                File outputFile = new File(outputPath);
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputFile));
                document.open();

                //FUENTES
                Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 8, Font.BOLD);
                Font fontTotales = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
                Font fontFecha = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
                Font fontFilas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 8);

                // LOGO
                Image logo = Image.getInstance("src/main/java/com/imagenes/logo.jpg");
                logo.scaleToFit(450, 800);
                logo.setAlignment(Element.ALIGN_CENTER);
                document.add(logo);
                // TITULO
                Paragraph titulo = new Paragraph("DETALLE DE MOVIMIENTOS", FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK));
                titulo.setAlignment(Element.ALIGN_CENTER);
                titulo.setSpacingAfter(10f); // Espacio después del título (en puntos)

                // FECHAS
                String fechaDesde = txtFechaDesde.getText();
                String fechaHasta = txtFechaHasta.getText();

                // Agregar fechas desde y hasta al título
                Chunk chunkFechas = new Chunk("Desde " + fechaDesde + " \nHasta " + fechaHasta, fontFecha);
                Paragraph fechas = new Paragraph(chunkFechas);
                fechas.setAlignment(Element.ALIGN_CENTER);
                fechas.setSpacingAfter(5f); // Espacio después de las fechas (en puntos)

                document.add(titulo);
                document.add(fechas);

                //creacion de la TABLA
                PdfPTable table = new PdfPTable(tablaConsultas.getColumnCount() - 6); // Excluir las 6 columnas A_CARGO_DE, CC, OBS, MOVIMIENTO, RENDIDO_1 y RENDIDO_2
                table.setSpacingBefore(10f); // Espacio antes de la tabla (en puntos)
                table.setSpacingAfter(10f);

                // Ajustar espacio horizontal
                float[] columnWidths = {0.9f, 1f, 1f, 0.7f, 0.7f, 1f, 0.7f, 1f, 0.7f, 1.3f}; // Anchos de las columnas (proporciones)
                table.setWidths(columnWidths);

                table.setWidthPercentage(100); // Establecer ancho total de la tabla al 100%

                table.setWidths(columnWidths);

                // Agregar las celdas a la tabla
                for (int i = 0; i < tablaConsultas.getColumnCount(); i++) {
                    String col = tablaConsultas.getColumnName(i);
                    if (!col.equals("A_CARGO_DE") && !col.equals("CC") && !col.equals("OBS") && !col.equals("MOVIMIENTO")
                            && !col.equals("RENDIDO") && !col.equals("RENDIDO")) {
                        PdfPCell cell = new PdfPCell(new Phrase(col, font));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPaddingBottom(3f); // Espacio inferior de la celda (en puntos)
                        table.addCell(cell);
                    }
                }
                for (int row = 0; row < tablaConsultas.getRowCount(); row++) {
                    for (int col = 0; col < tablaConsultas.getColumnCount(); col++) {
                        String colName = tablaConsultas.getColumnName(col);
                        if (!colName.equals("A_CARGO_DE") && !colName.equals("CC") && !colName.equals("OBS") && !colName.equals("MOVIMIENTO")
                                && !colName.equals("RENDIDO") && !colName.equals("RENDIDO")) {
                            Object value = tablaConsultas.getValueAt(row, col);
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
                // Crear una tabla para los montos totales
                PdfPTable totalsTable = new PdfPTable(2);
                totalsTable.setWidthPercentage(100);

                // Monto total
                // Establecer la fuente deseada
                Phrase montoTotalPhrase = new Phrase("Monto total: $" + txtTotalMonto.getText(), fontTotales);
                PdfPCell montoTotalCell = new PdfPCell(montoTotalPhrase);
                montoTotalCell.setBorder(Rectangle.NO_BORDER);
                montoTotalCell.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear la celda al centro
                totalsTable.addCell(montoTotalCell);

                // Flete total
                Phrase fleteTotalPhrase = new Phrase("Flete total: $" + txtTotalFlete.getText(), fontTotales);
                PdfPCell fleteTotalCell = new PdfPCell(fleteTotalPhrase);
                fleteTotalCell.setBorder(Rectangle.NO_BORDER);
                fleteTotalCell.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear la celda al centro
                totalsTable.addCell(fleteTotalCell);

                totalsTable.setSpacingBefore(10f);
                document.add(totalsTable);
                document.close();
                writer.close();

                JOptionPane.showMessageDialog(null, "El archivo se generó correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (DocumentException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el archivo PDF.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
