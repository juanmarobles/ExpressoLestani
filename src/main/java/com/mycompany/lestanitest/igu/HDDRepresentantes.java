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
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import com.mycompany.lestanitest.logica.Cliente;
import com.mycompany.lestanitest.logica.Controladora;
import com.mycompany.lestanitest.logica.ModeloCliente;
import com.mycompany.lestanitest.logica.ModeloRepresentante;
import com.mycompany.lestanitest.logica.ModeloVehiculo;
import com.mycompany.lestanitest.logica.Movimientos;
import com.mycompany.lestanitest.logica.Representantes;
import com.mycompany.lestanitest.logica.Vehiculo;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterJob;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

/**
 *
 * @author Usuario
 */
public class HDDRepresentantes extends javax.swing.JFrame {

    Controladora control = new Controladora();
    TableRowSorter trs;

    /**
     * Creates new form HDDRepresentantes
     */
    public HDDRepresentantes() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        llenarVehiculo();
        llenarChofer();
        cargarRepresentantes();

        //FECHA
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Mostrar la fecha actual en los campos de texto correspondientes
        txtDia.setText(String.valueOf(fechaActual.getDayOfMonth()));
        txtMes.setText(String.valueOf(fechaActual.getMonthValue()));
        txtAnio.setText(String.valueOf(fechaActual.getYear()));

        // Agregar evento de selección a la tabla
        tablaMovimientos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Obtener los índices de las filas seleccionadas
                    int[] selectedRows = tablaMovimientos.getSelectedRows();
                    List<Movimientos> movimientosFiltrados = control.traerMovimientos();

                    // Calcular y actualizar el total de montos de los elementos seleccionados
                    calcularTotalMonto(movimientosFiltrados, selectedRows);
                    calcularTotalFlete(movimientosFiltrados, selectedRows);
                    calcularTotalBultos(movimientosFiltrados, selectedRows);

                }
            }
        });

        //Borde al seleccionar TEXFIELD
        SwingUtilities.invokeLater(() -> {
            // Define el borde de enfoque
            Border normalBorder = txtDia.getBorder();
            Border focusBorder = new LineBorder(Color.BLUE, 3);

            FocusAdapter focusAdapter = new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    ((JComponent) e.getComponent()).setBorder(focusBorder);
                    if (e.getComponent() instanceof JTextField) {
                        ((JTextField) e.getComponent()).selectAll();
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    ((JComponent) e.getComponent()).setBorder(normalBorder);
                }
            };
            txtDia.addFocusListener(focusAdapter);
            txtMes.addFocusListener(focusAdapter);
            txtAnio.addFocusListener(focusAdapter);

        });

    }
//LLENAR TEXTFIELD REPRESENTANTES

    private static void mostrarResultadosBusqueda(JComboBox<String> combobox, String textoBusqueda) {
        // Limpiar selección previa
        combobox.setSelectedIndex(-1);

        // Buscar resultados de búsqueda exacta
        boolean encontradoExacta = false;

        for (int i = 0; i < combobox.getItemCount(); i++) {
            String item = combobox.getItemAt(i).toString();
            if (item.equalsIgnoreCase(textoBusqueda)) {
                combobox.setSelectedItem(item);
                combobox.getEditor().setItem(item);
                encontradoExacta = true;
                break; // Terminar la búsqueda cuando se encuentra una coincidencia exacta
            }
        }

        // Si no se encontró una coincidencia exacta, buscar coincidencias parciales
        if (!encontradoExacta) {
            boolean encontradoParcial = false;
            for (int i = 0; i < combobox.getItemCount(); i++) {
                String item = combobox.getItemAt(i).toString();
                if (item.toLowerCase().contains(textoBusqueda.toLowerCase())) {
                    combobox.setSelectedIndex(i);
                    combobox.getEditor().setItem(item);
                    encontradoParcial = true;
                    break; // Terminar la búsqueda cuando se encuentra una coincidencia parcial
                }
            }

            // Si no se encontró ninguna coincidencia parcial, mostrar el desplegable
            if (!encontradoParcial) {
                combobox.setPopupVisible(true);
                combobox.getEditor().setItem(textoBusqueda); // Deja el ComboBox con el texto de búsqueda
            }
        }
    }

    private void cargarRepresentantes() {
        ModeloRepresentante modRepre = new ModeloRepresentante();
        ArrayList<Representantes> listaRepresentantes = modRepre.getRepresentantes();
        cbRepresentantes.setEditable(true);
        // Ordenar la lista de clientes alfabéticamente por el nombre
        listaRepresentantes.sort((representante1, representante2) -> representante1.getNombre().compareToIgnoreCase(representante2.getNombre()));

        // Agregar los clientes al combobox
        for (Representantes Repre : listaRepresentantes) {
            cbRepresentantes.addItem(Repre.getNombre());
        }

// Eliminar la opción en blanco después de configurar el decorador
        cbRepresentantes.removeItem("");

        // Establecer el índice seleccionado a -1 para no mostrar ninguna selección
        cbRepresentantes.setSelectedIndex(-1);

        // Agregar ActionListener para capturar el evento "Enter"
        cbRepresentantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoBusqueda = cbRepresentantes.getEditor().getItem().toString();
                mostrarResultadosBusqueda(cbRepresentantes, textoBusqueda);
            }
        });

        // Agregar KeyListener para capturar el evento "Enter"
        cbRepresentantes.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String textoBusqueda = cbRepresentantes.getEditor().getItem().toString();
                    mostrarResultadosBusqueda(cbRepresentantes, textoBusqueda);
                }
            }
        });

    }

    //llenar vehiculo
    private void llenarVehiculo() {
        ModeloVehiculo modVehiculo = new ModeloVehiculo();
        ArrayList<Vehiculo> listaVehiculo = modVehiculo.getVehiculos();
        cbVehiculo.removeAllItems(); // Limpiar los elementos existentes en el ComboBox

        // Agregar los nuevos elementos del ArrayList al ComboBox
        for (int i = 0; i < listaVehiculo.size(); i++) {
            cbVehiculo.addItem(listaVehiculo.get(i));
        }
        // Agregar un listener al ComboBox para capturar la selección
        cbVehiculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el vehículo seleccionado
                Vehiculo vehiculoSeleccionado = (Vehiculo) cbVehiculo.getSelectedItem();

                // Actualizar el valor del TextField con la patente del vehículo seleccionado
                txtPatente.setText(vehiculoSeleccionado.getPatente());
            }
        });
    }

    //llenar chofer
    private void llenarChofer() {
        ModeloRepresentante modRepre = new ModeloRepresentante();
        ArrayList<Representantes> listaRepresentantes = modRepre.getRepresentantes();
        cbChofer.setEditable(true);

        // Agregar los clientes al combobox
        for (Representantes Repre : listaRepresentantes) {
            cbChofer.addItem(Repre.getNombre());
        }

// Eliminar la opción en blanco después de configurar el decorador
        cbChofer.removeItem("");

        // Establecer el índice seleccionado a -1 para no mostrar ninguna selección
        cbChofer.setSelectedIndex(-1);

        // Agregar ActionListener para capturar el evento "Enter"
        cbChofer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoBusqueda = cbChofer.getEditor().getItem().toString();
                mostrarResultadosBusqueda(cbChofer, textoBusqueda);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbVehiculo = new javax.swing.JComboBox<>();
        cbChofer = new javax.swing.JComboBox<>();
        txtPatente = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMes = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMovimientos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnImprimirHRP = new javax.swing.JButton();
        btnGenerarPdf = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cbCC = new javax.swing.JRadioButton();
        cbContado = new javax.swing.JRadioButton();
        cbTodos = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        btnMostrar = new javax.swing.JButton();
        cbRepresentantes = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtTotalMont = new javax.swing.JTextField();
        txtTotalFlet = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtCantBultos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Expreso Lestani SRL - Hoja de Ruta Por Representantes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(66, 66, 66));

        jPanel2.setBackground(new java.awt.Color(66, 66, 66));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Vehiculo:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Chofer:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Patente:");

        txtPatente.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPatente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbChofer, 0, 170, Short.MAX_VALUE)
                    .addComponent(cbVehiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbChofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPatente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(66, 66, 66));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(236, 240, 241));
        jLabel4.setText("Fecha:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("/");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("/");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Representante:");

        tablaMovimientos.setBackground(new java.awt.Color(66, 66, 66));
        tablaMovimientos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tablaMovimientos.setForeground(new java.awt.Color(236, 240, 241));
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
        jScrollPane1.setViewportView(tablaMovimientos);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hoja de Ruta Por Representantes");

        btnImprimirHRP.setBackground(new java.awt.Color(51, 51, 51));
        btnImprimirHRP.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnImprimirHRP.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimirHRP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/imprimir_24px.png"))); // NOI18N
        btnImprimirHRP.setText("Imprimir");
        btnImprimirHRP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImprimirHRP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirHRPActionPerformed(evt);
            }
        });

        btnGenerarPdf.setBackground(new java.awt.Color(51, 51, 51));
        btnGenerarPdf.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnGenerarPdf.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pdf_24px-pdf.png"))); // NOI18N
        btnGenerarPdf.setText("Generar PDF");
        btnGenerarPdf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPdfActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(66, 66, 66));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbCC.setBackground(new java.awt.Color(66, 66, 66));
        cbCC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbCC.setForeground(new java.awt.Color(255, 255, 255));
        cbCC.setText("Cuenta Corriente");
        cbCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCCActionPerformed(evt);
            }
        });

        cbContado.setBackground(new java.awt.Color(66, 66, 66));
        cbContado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbContado.setForeground(new java.awt.Color(255, 255, 255));
        cbContado.setText("Contado");
        cbContado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbContadoActionPerformed(evt);
            }
        });

        cbTodos.setBackground(new java.awt.Color(66, 66, 66));
        cbTodos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbTodos.setForeground(new java.awt.Color(255, 255, 255));
        cbTodos.setSelected(true);
        cbTodos.setText("Todos");
        cbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTodosActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cta Cte Clientes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbContado)
                    .addComponent(cbCC)
                    .addComponent(cbTodos))
                .addGap(15, 15, 15))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbCC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbContado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTodos)
                .addGap(12, 12, 12))
        );

        btnMostrar.setBackground(new java.awt.Color(51, 51, 51));
        btnMostrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Mostrar_24px.png"))); // NOI18N
        btnMostrar.setText("Mostrar");
        btnMostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        cbRepresentantes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jPanel7.setBackground(new java.awt.Color(66, 66, 66));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(236, 240, 241));
        jLabel23.setText("Total Monto $:");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(236, 240, 241));
        jLabel24.setText("Total Flete    $:");

        txtTotalMont.setEditable(false);
        txtTotalMont.setBackground(new java.awt.Color(51, 51, 51));
        txtTotalMont.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtTotalMont.setForeground(new java.awt.Color(0, 153, 51));
        txtTotalMont.setText("0");
        txtTotalMont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalMontActionPerformed(evt);
            }
        });

        txtTotalFlet.setEditable(false);
        txtTotalFlet.setBackground(new java.awt.Color(51, 51, 51));
        txtTotalFlet.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtTotalFlet.setForeground(new java.awt.Color(0, 153, 51));
        txtTotalFlet.setText("0");
        txtTotalFlet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalFletActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalMont, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalFlet)))
                .addGap(28, 28, 28))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalMont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalFlet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(66, 66, 66));

        jLabel25.setForeground(new java.awt.Color(236, 240, 241));
        jLabel25.setText("Cant. Bultos");

        txtCantBultos.setEditable(false);
        txtCantBultos.setBackground(new java.awt.Color(51, 51, 51));
        txtCantBultos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtCantBultos.setForeground(new java.awt.Color(0, 153, 51));
        txtCantBultos.setText("0");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantBultos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCantBultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(btnImprimirHRP, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnGenerarPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1866, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43)
                                        .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(124, 124, 124)
                                        .addComponent(jLabel6))
                                    .addComponent(cbRepresentantes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbRepresentantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnImprimirHRP, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(btnGenerarPdf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened
    boolean botonMostrarPresionado;
    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        botonMostrarPresionado = true;
        aplicarFiltros();
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void aplicarFiltros() {
        // Verificar si se ha presionado el botón "Mostrar"
        if (!botonMostrarPresionado) {
            return;
        }

        //Fecha
        // Obtener los valores de los campos de texto
        int dia = Integer.parseInt(txtDia.getText());
        int mes = Integer.parseInt(txtMes.getText());
        int anio = Integer.parseInt(txtAnio.getText());

        // Crear una instancia de LocalDate si la fecha es válida
        LocalDate fechaArmada = LocalDate.of(anio, mes, dia);

        // Formatear la fecha en el formato deseado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fechaArmada.format(formatter);

        boolean mostrarCuentaCorriente = cbCC.isSelected();
        boolean mostrarContado = cbContado.isSelected();
        boolean mostrarTodos = cbTodos.isSelected();

        List<Movimientos> listaMovimientos = control.traerMovimientos();
        List<Movimientos> listaFiltrada;

        if (mostrarTodos) {
            listaFiltrada = filtrarPorFecha(listaMovimientos, fechaFormateada);
        } else {
            listaFiltrada = filtrarMovimientos(listaMovimientos, fechaFormateada, mostrarCuentaCorriente, mostrarContado);
        }

        // Obtener el representante seleccionado
        Object representanteSeleccionado = cbRepresentantes.getSelectedItem();
        String representanteFiltrado = representanteSeleccionado != null ? representanteSeleccionado.toString() : "";

        // Filtrar por representante
        if (!representanteFiltrado.isEmpty()) {
            listaFiltrada = listaFiltrada.stream()
                    .filter(mov -> mov.getRepresentante().equals(representanteFiltrado))
                    .collect(Collectors.toList());
        }

        mostrarTablaMovimientos(listaFiltrada);
        //Total Monto
        int[] selectedRows = tablaMovimientos.getSelectedRows();
        calcularTotalMonto(listaFiltrada, selectedRows);
        calcularTotalFlete(listaFiltrada, selectedRows);
        calcularTotalBultos(listaFiltrada, selectedRows);
    }

    // Método para calcular el total de montos de los elementos seleccionados en la tabla
    private void calcularTotalMonto(List<Movimientos> movimientosFiltrados, int[] selectedRows) {

        if (selectedRows.length > 0) {
            // Si hay elementos seleccionados, calcular y mostrar el total de montos seleccionados
            double totalMonto = 0.0;

            // Supongamos que "Movimientos" tiene un método "getMonto()" para obtener el monto de cada movimiento.
            for (int rowIndex : selectedRows) {
                String monto = tablaMovimientos.getValueAt(rowIndex, 7).toString();
                monto = monto.replace("$", "").replace(".", "").replace(",", "."); // Eliminar símbolos y reemplazar la coma por el punto decimal
                try {
                    totalMonto += Double.parseDouble(monto);
                } catch (NumberFormatException e) {
                    // Manejar la excepción en caso de que no se pueda convertir el monto a número
                    e.printStackTrace();
                }
            }

            //Formato de Monto
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator(',');
            symbols.setGroupingSeparator('.');
            DecimalFormat decimalFormat = new DecimalFormat("###,###.00", symbols);
            String totalFormateado = decimalFormat.format(totalMonto);

            txtTotalMont.setText(totalFormateado);
        } else {
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

            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator(',');
            symbols.setGroupingSeparator('.');
            DecimalFormat decimalFormat = new DecimalFormat("###,###.00", symbols);
            String totalFormateado = decimalFormat.format(totalMonto);

            txtTotalMont.setText(totalFormateado);
        }
    }

    // Método para calcular el total de montos de los elementos seleccionados en la tabla
    private void calcularTotalFlete(List<Movimientos> movimientosFiltrados, int[] selectedRows) {

        if (selectedRows.length > 0) {
            // Si hay elementos seleccionados, calcular y mostrar el total de montos seleccionados
            double totalFlete = 0.0;

            // Supongamos que "Movimientos" tiene un método "getFlete()" para obtener el monto de cada movimiento.
            for (int rowIndex : selectedRows) {
                String flete = tablaMovimientos.getValueAt(rowIndex, 10).toString();
                flete = flete.replace("$", "").replace(".", "").replace(",", "."); // Eliminar símbolos y reemplazar la coma por el punto decimal
                try {
                    totalFlete += Double.parseDouble(flete);
                } catch (NumberFormatException e) {
                    // Manejar la excepción en caso de que no se pueda convertir el monto a número
                    e.printStackTrace();
                }
            }

            //Formato de Monto
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator(',');
            symbols.setGroupingSeparator('.');
            DecimalFormat decimalFormat = new DecimalFormat("###,###.00", symbols);
            String totalFormateado = decimalFormat.format(totalFlete);

            txtTotalFlet.setText(totalFormateado);
        } else {
            // Calcular el total de los Fletes
            double totalflete = movimientosFiltrados.stream()
                    .mapToDouble(mov -> {
                        String flete = mov.getFlete().replace(".", ""); // Eliminar el separador de miles (punto)
                        flete = flete.replace(",", "."); // Reemplazar la coma por punto decimal
                        flete = flete.replace("$", ""); // Eliminar el signo de dólar
                        try {
                            return Double.parseDouble(flete);
                        } catch (NumberFormatException e) {
                            return 0.0;
                        }
                    })
                    .sum();

            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator(',');
            symbols.setGroupingSeparator('.');
            DecimalFormat decimalFormat = new DecimalFormat("###,###.00", symbols);
            String totalFormateado = decimalFormat.format(totalflete);

            txtTotalFlet.setText(totalFormateado);
        }
    }

    private void calcularTotalBultos(List<Movimientos> movimientosFiltrados, int[] selectedRows) {

        if (selectedRows.length > 0) {

            // Si hay elementos seleccionados, calcular y mostrar el total de montos seleccionados
            int totalbulto = 0;

            // Supongamos que "Movimientos" tiene un método "getFlete()" para obtener el monto de cada movimiento.
            for (int rowIndex : selectedRows) {
                String bulto = tablaMovimientos.getValueAt(rowIndex, 6).toString();
                try {
                    totalbulto += Double.parseDouble(bulto);
                } catch (NumberFormatException e) {
                    // Manejar la excepción en caso de que no se pueda convertir el monto a número
                    e.printStackTrace();
                }
                txtCantBultos.setText(String.format("%,d", totalbulto));
            }
        } else {

            int sumaBultos = movimientosFiltrados.stream()
                    .mapToInt(Movimientos::getBultos)
                    .sum();

            txtCantBultos.setText(String.format("%,d", sumaBultos));

        }
    }

    public List<Movimientos> filtrarPorFecha(List<Movimientos> objetos, String fechaSeleccionada) {
        List<Movimientos> resultados = new ArrayList<>();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date fecha = formato.parse(fechaSeleccionada);

            for (Movimientos objeto : objetos) {
                Date fechaMovimiento = objeto.getFecha();
                String representanteMovimiento = objeto.getRepresentante();

                if (fechaMovimiento != null && formato.format(fechaMovimiento).equals(fechaSeleccionada)) {
                    resultados.add(objeto);
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultados;
    }

    public List<Movimientos> filtrarMovimientos(List<Movimientos> objetos, String fechaSeleccionada, boolean mostrarCuentaCorriente, boolean mostrarContado) {
        List<Movimientos> resultados = new ArrayList<>();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date fecha = formato.parse(fechaSeleccionada);

            for (Movimientos objeto : objetos) {
                Date fechaMovimiento = objeto.getFecha();
                String cuentaCorriente = objeto.getCuentaCorriente();
                boolean esCuentaCorriente = cuentaCorriente.equalsIgnoreCase("si");

                // Verificar si se debe mostrar el movimiento según los filtros
                boolean mostrarMovimiento = true;
                if (fechaMovimiento != null && !formato.format(fechaMovimiento).equals(fechaSeleccionada)) {
                    mostrarMovimiento = false; // No coincide con la fecha seleccionada
                }

                if (!mostrarCuentaCorriente && esCuentaCorriente) {
                    mostrarMovimiento = false; // Se debe mostrar solo movimientos no cuenta corriente
                }
                if (!mostrarContado && !esCuentaCorriente) {
                    mostrarMovimiento = false; // Se debe mostrar solo movimientos cuenta corriente
                }

                if (mostrarMovimiento) {
                    resultados.add(objeto);
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultados;
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
        String titulos[] = {"ID", "HORA", "FECHA", "CLIENTE", "DESTINO", "REMITO", "BULTOS", "MONTO", "PAGADO", "RENDIDO", "FLETE", "PAGADO", "RENDIDO", "A_CARGO_DE", "REPRESENTANTE", "CC", "OBS"};
        tabla.setColumnIdentifiers(titulos);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tabla);
        tablaMovimientos.setRowSorter(sorter);
        sorter.setSortKeys(java.util.Arrays.asList(new RowSorter.SortKey(1, SortOrder.DESCENDING)));

        // Ordenar los datos por el ID en forma descendente
        Collections.sort(listaMovimientos, Comparator.comparingInt(Movimientos::getId_movimientos).reversed());

        //carga de los datos desde la lista filtrada
        for (Movimientos mov : listaMovimientos) {
            Object[] objeto = {mov.getId_movimientos(), mov.getHora(), mov.getFechaFormateada(), mov.getCliente(), mov.getDestino(), mov.getRemito(), mov.getBultos(), mov.getMonto(), mov.getTipoMontoP(), mov.getTipoMontoR(), mov.getFlete(), mov.getTipoFleteP(), mov.getTipoFleteR(), mov.getFleteDestinoOrigen(), mov.getRepresentante(), mov.getCuentaCorriente(), mov.getObservaciones()};
            tabla.addRow(objeto);
        }
        tablaMovimientos.setModel(tabla);
        // Establecer el ancho específico de las columnas
        int[] anchos = {60, 80, 100, 100, 100, 70, 80, 100, 80, 80, 100, 80, 80, 120, 120, 40, 200}; // Anchos deseados para cada columna en píxeles

        if (anchos.length == tabla.getColumnCount()) {
            TableColumnModel columnModel = tablaMovimientos.getColumnModel();
            for (int i = 0; i < anchos.length; i++) {
                TableColumn columna = columnModel.getColumn(i);
                columna.setPreferredWidth(anchos[i]);

                // Renderizador personalizado para centrar el contenido de las celdas
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setHorizontalAlignment(SwingConstants.CENTER);
                tablaMovimientos.setDefaultRenderer(Object.class, renderer);

                // Renderizador personalizado para centrar el título de las columnas
                DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tablaMovimientos.getTableHeader().getDefaultRenderer();
                headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            }
        }

    }
    private void cbCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCCActionPerformed

        if (cbCC.isSelected()) {
            cbContado.setSelected(false);
            cbTodos.setSelected(false);
        }

    }//GEN-LAST:event_cbCCActionPerformed

    public List<Movimientos> filtrarPorFechayRep(List<Movimientos> objetos, String fechaSeleccionada, String representanteSeleccionado) {
        List<Movimientos> resultados = new ArrayList<>();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date fecha = formato.parse(fechaSeleccionada);

            for (Movimientos objeto : objetos) {
                Date fechaMovimiento = objeto.getFecha();
                String representanteMovimiento = objeto.getRepresentante();

                if (fechaMovimiento != null && formato.format(fechaMovimiento).equals(fechaSeleccionada)
                        && representanteMovimiento != null && representanteMovimiento.equalsIgnoreCase(representanteSeleccionado)) {
                    resultados.add(objeto);
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultados;
    }


    private void cbContadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbContadoActionPerformed

        if (cbContado.isSelected()) {
            cbCC.setSelected(false);
            cbTodos.setSelected(false);
        }
    }//GEN-LAST:event_cbContadoActionPerformed

    private void cbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTodosActionPerformed

        if (cbTodos.isSelected()) {
            cbCC.setSelected(false);
            cbContado.setSelected(false);
        }
    }//GEN-LAST:event_cbTodosActionPerformed

    private void btnGenerarPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPdfActionPerformed
        generarPDF();
    }//GEN-LAST:event_btnGenerarPdfActionPerformed

    private void btnImprimirHRPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirHRPActionPerformed
        imprimirPDF();
    }//GEN-LAST:event_btnImprimirHRPActionPerformed

    private void txtTotalMontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalMontActionPerformed

    }//GEN-LAST:event_txtTotalMontActionPerformed

    private void txtTotalFletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalFletActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalFletActionPerformed

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
            java.util.logging.Logger.getLogger(HDDRepresentantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HDDRepresentantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HDDRepresentantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HDDRepresentantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HDDRepresentantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarPdf;
    private javax.swing.JButton btnImprimirHRP;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JRadioButton cbCC;
    private javax.swing.JComboBox<String> cbChofer;
    private javax.swing.JRadioButton cbContado;
    private javax.swing.JComboBox<String> cbRepresentantes;
    private javax.swing.JRadioButton cbTodos;
    private javax.swing.JComboBox<Vehiculo> cbVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaMovimientos;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtCantBultos;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtPatente;
    private javax.swing.JTextField txtTotalFlet;
    private javax.swing.JTextField txtTotalMont;
    // End of variables declaration//GEN-END:variables

    public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
    }

    //GENERAR PDF HOJA DE RUTA POR REPRESENTANTE
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
                Font fontDatos = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, NORMAL);
                Font fontTotales = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
                Font fontFecha = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
                Font fontFilas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, Font.BOLD);
                // LOGO
                InputStream logoStream = getClass().getClassLoader().getResourceAsStream("imagenes/logosolo.jpg");
                Image logo = Image.getInstance(ImageIO.read(logoStream), null);
                logo.scaleToFit(250, 650);
                logo.setAlignment(Element.ALIGN_CENTER);
                document.add(logo);

                // Crea una tabla con 2 columnas
                float[] anchos = {1f, 0.25f};
                PdfPTable tablaPrincipal = new PdfPTable(anchos);
                tablaPrincipal.setWidthPercentage(100);

                // Celda 1: Título y Fecha (alineado al centro)
                PdfPCell celdaTituloFecha = new PdfPCell();
                celdaTituloFecha.setBorder(Rectangle.NO_BORDER);
                celdaTituloFecha.setHorizontalAlignment(Element.ALIGN_RIGHT);
                // Ajustar el padding horizontal de la celda
                celdaTituloFecha.setPaddingLeft(100f);
                Paragraph tituloFechaParagraph = new Paragraph();
                Chunk chunkTitulo = new Chunk("HOJA DE RUTA", FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK));
                tituloFechaParagraph.add(chunkTitulo);
                tituloFechaParagraph.add(Chunk.NEWLINE); // Agregar una nueva línea

                //Fecha
                // Obtener los valores de los campos de texto
                int dia = Integer.parseInt(txtDia.getText());
                int mes = Integer.parseInt(txtMes.getText());
                int anio = Integer.parseInt(txtAnio.getText());

                // Crear una instancia de LocalDate si la fecha es válida
                LocalDate fechaArmada = LocalDate.of(anio, mes, dia);

                // Formatear la fecha en el formato deseado
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String fechaFormateada = fechaArmada.format(formatter);

                Chunk chunkFechas = new Chunk("Fecha: " + fechaFormateada, fontFecha);
                tituloFechaParagraph.add(chunkFechas);
                tituloFechaParagraph.setAlignment(Element.ALIGN_CENTER);
                celdaTituloFecha.addElement(tituloFechaParagraph);
                tablaPrincipal.addCell(celdaTituloFecha);

                // Celda 2: Datos del Vehículo, Patente y Chofer (alineado a la derecha)
                PdfPCell celdaDatos = new PdfPCell();
                celdaDatos.setBorder(Rectangle.NO_BORDER);
                celdaDatos.setHorizontalAlignment(Element.ALIGN_RIGHT);

                Paragraph datosParagraph = new Paragraph();
                datosParagraph.setAlignment(Element.ALIGN_RIGHT);

                String vehiculoSeleccionado = cbVehiculo.getSelectedItem().toString();

                // Crear el Chunk para "Vehiculo: " en negrita
                Chunk chunkVehiculoLabel = new Chunk("Vehiculo: ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD));

                // Crear el Chunk para el valor del vehículo
                Chunk chunkVehiculoValue = new Chunk(vehiculoSeleccionado.toUpperCase(), fontDatos);

                // Agregar los Chunks al párrafo
                datosParagraph.add(chunkVehiculoLabel);
                datosParagraph.add(chunkVehiculoValue);
                datosParagraph.add(Chunk.NEWLINE); // Agregar una nueva línea

                String patenteSeleccionada = txtPatente.getText();

                // Crear el Chunk para "Patente: " en negrita
                Chunk chunkPatenteLabel = new Chunk("Patente: ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD));

                // Crear el Chunk para el valor de la patente
                Chunk chunkPatenteValue = new Chunk(patenteSeleccionada.toUpperCase(), fontDatos);

                // Agregar los Chunks al párrafo
                datosParagraph.add(chunkPatenteLabel);
                datosParagraph.add(chunkPatenteValue);
                datosParagraph.add(Chunk.NEWLINE); // Agregar una nueva línea

                String choferSeleccionado = cbChofer.getSelectedItem().toString();

                // Crear el Chunk para "Chofer: " en negrita
                Chunk chunkChoferLabel = new Chunk("Chofer: ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD));

                // Crear el Chunk para el valor del chofer
                Chunk chunkChoferValue = new Chunk(choferSeleccionado.toUpperCase(), fontDatos);

                // Agregar los Chunks al párrafo
                datosParagraph.add(chunkChoferLabel);
                datosParagraph.add(chunkChoferValue);

                celdaDatos.addElement(datosParagraph);
                tablaPrincipal.addCell(celdaDatos);

                // Agregar la tabla al documento
                document.add(tablaPrincipal);

                // REPRESENTANTE
                Paragraph rep = new Paragraph(cbRepresentantes.getSelectedItem().toString(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK));
                rep.setAlignment(Element.ALIGN_CENTER);
                document.add(rep);

                // Obtener las filas seleccionadas o todas las filas si no hay ninguna seleccionada
                int[] filasSeleccionadas = tablaMovimientos.getSelectedRows();
                boolean todasFilasSeleccionadas = filasSeleccionadas.length == 0;

                //CREACION DE TABLA
                PdfPTable table = new PdfPTable(tablaMovimientos.getColumnCount() - 7 + 1); // Excluir columnas MOVIMIENTO,FECHA,REPRESENTANTE,Y OBS
                table.setSpacingBefore(10f); // Espacio antes de la tabla (en puntos)
                table.setSpacingAfter(10f);

                // Ajustar espacio horizontal
                float[] columnWidths = {1.5f, 1.5f, 1f, 0.9f, 1f, 0.9f, 1f, 0.9f, 0.8f, 0.6f, 1.5f}; // Añadir un ancho para la nueva columna "observaciones"
                table.setWidths(columnWidths);
                table.setWidthPercentage(100); // Establecer ancho total de la tabla al 100%

                // Agregar las celdas a la tabla
                for (int i = 0; i < tablaMovimientos.getColumnCount(); i++) {
                    String col = tablaMovimientos.getColumnName(i);
                    if (!col.equals("ID") && !col.equals("HORA") && !col.equals("FECHA") && !col.equals("REPRESENTANTE") && !col.equals("OBS") && !col.equals("RENDIDO")) {
                        if (col.equals("CC")) { // Verificar si la columna es "CC"
                            col = "F.P"; // Cambiar el nombre de la columna a "F.P"
                        }
                        if (col.equals("A_CARGO_DE")) { // Verificar si la columna es "CC"
                            col = "Flet a Cargo"; // Cambiar el nombre de la columna a "F.P"
                        }
                        PdfPCell cell = new PdfPCell(new Phrase(col, font));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPaddingBottom(3f); // Espacio inferior de la celda (en puntos)
                        table.addCell(cell);
                    }
                }
                // Agregar columna "Observaciones"
                PdfPCell obsHeaderCell = new PdfPCell(new Phrase("Obs", font));
                obsHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                obsHeaderCell.setPaddingBottom(3f); // Espacio inferior de la celda (en puntos)
                table.addCell(obsHeaderCell);
                // Agregar filas a la tabla
                for (int row = 0; row < tablaMovimientos.getRowCount(); row++) {
                    if (todasFilasSeleccionadas || contains(filasSeleccionadas, row)) {
                        for (int col = 0; col < tablaMovimientos.getColumnCount(); col++) {
                            String colName = tablaMovimientos.getColumnName(col);
                            if (!colName.equals("ID") && !colName.equals("HORA") && !colName.equals("FECHA") && !colName.equals("REPRESENTANTE") && !colName.equals("OBS") && !colName.equals("RENDIDO")) {
                                Object value = tablaMovimientos.getValueAt(row, col);
                                if (value != null) {
                                    if (colName.equals("CC")) {
                                        if (value.toString().equals("Si")) {
                                            // Obtener el valor de la columna "A_CARGO_DE"
                                            Object aCargoDeValue = tablaMovimientos.getValueAt(row, tablaMovimientos.getColumn("A_CARGO_DE").getModelIndex());
                                            if (aCargoDeValue != null) {
                                                if (aCargoDeValue.toString().equals("Origen")) {
                                                    value = "CCO"; // Cambiar el valor de "F.P" a "CCO"
                                                } else if (aCargoDeValue.toString().equals("Destino")) {
                                                    value = "CCD"; // Cambiar el valor de "F.P" a "CCD"
                                                }
                                            }
                                        } else {
                                            value = "CON"; // Cambiar el valor de "F.P" a "CON" si "CC" es "No" o está en blanco
                                        }
                                    }
                                    if (colName.equals("CC")) {
                                        colName = "F.P"; // Cambiar el nombre de la columna a "F.P"
                                    }
                                    PdfPCell cell = new PdfPCell(new Phrase(value.toString(), fontFilas));
                                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                    cell.setPaddingBottom(3f); // Espacio inferior de la celda (en puntos)

                                    // Verificar si la columna es "CLIENTE" o "DESTINO" y alinear a la izquierda
                                    if (colName.equals("CLIENTE") || colName.equals("DESTINO")) {
                                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                                    }
                                    table.addCell(cell);
                                }
                            }
                        }
                        // Agregar celda vacía para la columna "Observaciones"
                        PdfPCell obsCell = new PdfPCell(new Phrase("", fontFilas));
                        obsCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        obsCell.setPaddingBottom(3f); // Espacio inferior de la celda (en puntos)
                        table.addCell(obsCell);
                    }
                }

                document.add(table);

                document.close();
                writer.close();

                JOptionPane.showMessageDialog(null, "Hoja de ruta se generó correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (DocumentException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el archivo PDF.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private boolean contains(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    private void imprimirPDF() {
        Document document = new Document();
        try {
            String userHome = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
            String outputPath = userHome + File.separator + "archivo.pdf";
            // Crear el archivo de salida
            File outputFile = new File(outputPath);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputFile));

            document.open();
            //FUENTES
            Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 8, Font.BOLD);
            Font fontDatos = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, NORMAL);
            Font fontTotales = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
            Font fontFecha = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
            Font fontFilas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, Font.BOLD);
            // LOGO
            InputStream logoStream = getClass().getClassLoader().getResourceAsStream("imagenes/logosolo.jpg");
            Image logo = Image.getInstance(ImageIO.read(logoStream), null);
            logo.scaleToFit(250, 650);
            logo.setAlignment(Element.ALIGN_CENTER);
            document.add(logo);

            // Crea una tabla con 2 columnas
            float[] anchos = {1f, 0.25f};
            PdfPTable tablaPrincipal = new PdfPTable(anchos);
            tablaPrincipal.setWidthPercentage(100);

            // Celda 1: Título y Fecha (alineado al centro)
            PdfPCell celdaTituloFecha = new PdfPCell();
            celdaTituloFecha.setBorder(Rectangle.NO_BORDER);
            celdaTituloFecha.setHorizontalAlignment(Element.ALIGN_RIGHT);
            // Ajustar el padding horizontal de la celda
            celdaTituloFecha.setPaddingLeft(100f);
            Paragraph tituloFechaParagraph = new Paragraph();
            Chunk chunkTitulo = new Chunk("HOJA DE RUTA", FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK));
            tituloFechaParagraph.add(chunkTitulo);
            tituloFechaParagraph.add(Chunk.NEWLINE); // Agregar una nueva línea

            //Fecha
            // Obtener los valores de los campos de texto
            int dia = Integer.parseInt(txtDia.getText());
            int mes = Integer.parseInt(txtMes.getText());
            int anio = Integer.parseInt(txtAnio.getText());

            // Crear una instancia de LocalDate si la fecha es válida
            LocalDate fechaArmada = LocalDate.of(anio, mes, dia);

            // Formatear la fecha en el formato deseado
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaFormateada = fechaArmada.format(formatter);

            Chunk chunkFechas = new Chunk("Fecha: " + fechaFormateada, fontFecha);
            tituloFechaParagraph.add(chunkFechas);
            tituloFechaParagraph.setAlignment(Element.ALIGN_CENTER);
            celdaTituloFecha.addElement(tituloFechaParagraph);
            tablaPrincipal.addCell(celdaTituloFecha);

            // Celda 2: Datos del Vehículo, Patente y Chofer (alineado a la derecha)
            PdfPCell celdaDatos = new PdfPCell();
            celdaDatos.setBorder(Rectangle.NO_BORDER);
            celdaDatos.setHorizontalAlignment(Element.ALIGN_RIGHT);

            Paragraph datosParagraph = new Paragraph();
            datosParagraph.setAlignment(Element.ALIGN_RIGHT);

            String vehiculoSeleccionado = cbVehiculo.getSelectedItem().toString();

            // Crear el Chunk para "Vehiculo: " en negrita
            Chunk chunkVehiculoLabel = new Chunk("Vehiculo: ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD));

            // Crear el Chunk para el valor del vehículo
            Chunk chunkVehiculoValue = new Chunk(vehiculoSeleccionado.toUpperCase(), fontDatos);

            // Agregar los Chunks al párrafo
            datosParagraph.add(chunkVehiculoLabel);
            datosParagraph.add(chunkVehiculoValue);
            datosParagraph.add(Chunk.NEWLINE); // Agregar una nueva línea

            String patenteSeleccionada = txtPatente.getText();

            // Crear el Chunk para "Patente: " en negrita
            Chunk chunkPatenteLabel = new Chunk("Patente: ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD));

            // Crear el Chunk para el valor de la patente
            Chunk chunkPatenteValue = new Chunk(patenteSeleccionada.toUpperCase(), fontDatos);

            // Agregar los Chunks al párrafo
            datosParagraph.add(chunkPatenteLabel);
            datosParagraph.add(chunkPatenteValue);
            datosParagraph.add(Chunk.NEWLINE); // Agregar una nueva línea

            String choferSeleccionado = cbChofer.getSelectedItem().toString();

            // Crear el Chunk para "Chofer: " en negrita
            Chunk chunkChoferLabel = new Chunk("Chofer: ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD));

            // Crear el Chunk para el valor del chofer
            Chunk chunkChoferValue = new Chunk(choferSeleccionado.toUpperCase(), fontDatos);

            // Agregar los Chunks al párrafo
            datosParagraph.add(chunkChoferLabel);
            datosParagraph.add(chunkChoferValue);

            celdaDatos.addElement(datosParagraph);
            tablaPrincipal.addCell(celdaDatos);

            // Agregar la tabla al documento
            document.add(tablaPrincipal);

            // REPRESENTANTE
            Paragraph rep = new Paragraph(cbRepresentantes.getSelectedItem().toString(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK));
            rep.setAlignment(Element.ALIGN_CENTER);
            rep.setSpacingAfter(1f); // Espacio después del título (en puntos)
            document.add(rep);

            // Obtener las filas seleccionadas o todas las filas si no hay ninguna seleccionada
            int[] filasSeleccionadas = tablaMovimientos.getSelectedRows();
            boolean todasFilasSeleccionadas = filasSeleccionadas.length == 0;

            //CREACION DE TABLA
            PdfPTable table = new PdfPTable(tablaMovimientos.getColumnCount() - 7 + 1); // Excluir columnas MOVIMIENTO,FECHA,REPRESENTANTE,Y OBS
            table.setSpacingBefore(10f); // Espacio antes de la tabla (en puntos)
            table.setSpacingAfter(0f);

            // Ajustar espacio horizontal
            float[] columnWidths = {2.3f, 2.3f, 1f, 1f, 1f, 1.1f, 1f, 1.1f, 0.8f, 0.7f, 1.5f}; // Añadir un ancho para la nueva columna "observaciones"
            table.setWidths(columnWidths);
            table.setWidthPercentage(100); // Establecer ancho total de la tabla al 100%

            // Agregar las celdas a la tabla
            for (int i = 0; i < tablaMovimientos.getColumnCount(); i++) {
                String col = tablaMovimientos.getColumnName(i);
                if (!col.equals("ID") && !col.equals("HORA") && !col.equals("FECHA") && !col.equals("REPRESENTANTE") && !col.equals("OBS") && !col.equals("RENDIDO")) {
                    if (col.equals("CC")) { // Verificar si la columna es "CC"
                        col = "F.P"; // Cambiar el nombre de la columna a "F.P"
                    }
                    if (col.equals("A_CARGO_DE")) { // Verificar si la columna es "CC"
                        col = "Flet a Cargo"; // Cambiar el nombre de la columna a "F.P"
                    }
                    PdfPCell cell = new PdfPCell(new Phrase(col, font));
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell.setPaddingBottom(3f); // Espacio inferior de la celda (en puntos)
                    table.addCell(cell);
                }
            }
            // Agregar columna "Observaciones"
            PdfPCell obsHeaderCell = new PdfPCell(new Phrase("Obs", font));
            obsHeaderCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            obsHeaderCell.setPaddingBottom(3f); // Espacio inferior de la celda (en puntos)
            table.addCell(obsHeaderCell);
            // Agregar filas a la tabla
            for (int row = 0; row < tablaMovimientos.getRowCount(); row++) {
                if (todasFilasSeleccionadas || contains(filasSeleccionadas, row)) {
                    for (int col = 0; col < tablaMovimientos.getColumnCount(); col++) {
                        String colName = tablaMovimientos.getColumnName(col);
                        if (!colName.equals("ID") && !colName.equals("HORA") && !colName.equals("FECHA") && !colName.equals("REPRESENTANTE") && !colName.equals("OBS") && !colName.equals("RENDIDO")) {
                            Object value = tablaMovimientos.getValueAt(row, col);
                            if (value != null) {
                                if (colName.equals("CC")) {
                                    if (value.toString().equals("Si")) {
                                        // Obtener el valor de la columna "A_CARGO_DE"
                                        Object aCargoDeValue = tablaMovimientos.getValueAt(row, tablaMovimientos.getColumn("A_CARGO_DE").getModelIndex());
                                        if (aCargoDeValue != null) {
                                            if (aCargoDeValue.toString().equals("Origen")) {
                                                value = "CCO"; // Cambiar el valor de "F.P" a "CCO"
                                            } else if (aCargoDeValue.toString().equals("Destino")) {
                                                value = "CCD"; // Cambiar el valor de "F.P" a "CCD"
                                            }
                                        }
                                    } else {
                                        value = "CON"; // Cambiar el valor de "F.P" a "CON" si "CC" es "No" o está en blanco
                                    }
                                }
                                if (colName.equals("CC")) {
                                    colName = "F.P"; // Cambiar el nombre de la columna a "F.P"
                                }
                                PdfPCell cell = new PdfPCell(new Phrase(value.toString(), fontFilas));
                                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                                cell.setPaddingBottom(3f); // Espacio inferior de la celda (en puntos)
                                // Verificar si la columna es "CLIENTE" o "DESTINO" y alinear a la izquierda
                                if (colName.equals("CLIENTE") || colName.equals("DESTINO")) {
                                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                                }
                                table.addCell(cell);
                            }
                        }
                    }
                    // Agregar celda vacía para la columna "Observaciones"
                    PdfPCell obsCell = new PdfPCell(new Phrase("", fontFilas));
                    obsCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    obsCell.setPaddingBottom(3f); // Espacio inferior de la celda (en puntos)
                    table.addCell(obsCell);

                }
            }

             document.add(table);

            //CREACION DE TABLA CON FILA VACIA PARA ESPACIO CON LINEAS VERTICALES
// Crear la tabla vacía con una celda para las líneas verticales
            PdfPTable emptyTable = new PdfPTable(tablaMovimientos.getColumnCount() - 7 + 1);
            emptyTable.setSpacingBefore(0f); // Espacio antes de la tabla (en puntos)
            emptyTable.setSpacingAfter(0f);
            float[] columnWidthss = {2.3f, 2.3f, 1f, 1f, 1f, 1.1f, 1f, 1.1f, 0.8f, 0.7f, 1.5f}; // Añadir un ancho para la nueva columna "observaciones"
            emptyTable.setWidths(columnWidthss);
            emptyTable.setWidthPercentage(100); // Establecer ancho total de la tabla al 100%

            // Calcular la altura de la fila vacía en función del número de filas seleccionadas
            float emptyRowHeight = 0f;

            if (filasSeleccionadas.length == 0) {
                emptyRowHeight = 460f; // Altura predeterminada cuando no se selecciona ninguna fila
            } else if (filasSeleccionadas.length >= 1 && filasSeleccionadas.length <= 34) {
                // Alturas para diferentes cantidades de filas seleccionadas
                float[] alturas = {460f, 440f, 420f, 400f, 380f, 360f, 340f, 320f, 300f, 280f, 260f, 240f, 220f, 200f, 180f, 160f, 140f, 120f, 120f, 120f, 120f, 120f, 120f, 80f, 60f, 40f, 20f, 60f, 60f, 60f, 60f, 60f, 60f, 60f};

                // Asegurarse de que el índice esté dentro del rango
                int index = Math.min(filasSeleccionadas.length, alturas.length) - 1;
                emptyRowHeight = alturas[index];
            }

            // Crear una fila vacía en la tabla vacía
            for (int col = 0; col < tablaMovimientos.getColumnCount() - 7 + 1; col++) {
                PdfPCell emptyTableCell = new PdfPCell();
                emptyTableCell.setFixedHeight(emptyRowHeight);
                emptyTableCell.setBorder(Rectangle.BOX);
                emptyTable.addCell(emptyTableCell);
            }

            document.add(emptyTable);
           
            document.close();
            writer.close();

            try {
                // Cargar el archivo PDF generado previamente
                PDDocument pdfDocument = PDDocument.load(new File(outputPath));

                // Obtener la impresora predeterminada y crear un objeto PDFPageable
                PrinterJob printerJob = PrinterJob.getPrinterJob();
                PDFPageable pageable = new PDFPageable(pdfDocument);

                // Establecer el objeto PDFPageable en el trabajo de impresión
                printerJob.setPageable(pageable);

                // Imprimir el documento
                printerJob.print();

                // Cerrar el documento PDF después de imprimir
                pdfDocument.close();

                JOptionPane.showMessageDialog(null, "La hoja de ruta se generó e imprimió correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al generar o imprimir la hoja de ruta.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (DocumentException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al imprimir.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
