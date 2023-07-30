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
import com.itextpdf.text.pdf.PdfWriter;
import static com.mycompany.lestanitest.igu.Principal.fechaActual;
import com.mycompany.lestanitest.logica.Cliente;
import com.mycompany.lestanitest.logica.Controladora;
import com.mycompany.lestanitest.logica.ModeloCliente;
import com.mycompany.lestanitest.logica.ModeloRepresentante;
import com.mycompany.lestanitest.logica.ModeloVehiculo;
import com.mycompany.lestanitest.logica.Movimientos;
import com.mycompany.lestanitest.logica.Representantes;
import com.mycompany.lestanitest.logica.Vehiculo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

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
        llenarVehiculo();
        llenarChofer();
        cargarRepresentantes();
        txtFecha.setText(fechaActual());
    }
//LLENAR TEXTFIELD REPRESENTANTES
    private static void mostrarResultadosBusqueda(JComboBox<String> combobox, String textoBusqueda) {
       
    // Buscar el resultado de búsqueda
    boolean encontrado = false;
    for (int i = 0; i < combobox.getItemCount(); i++) {
        String item = combobox.getItemAt(i).toString();
        if (item.toLowerCase().contains(textoBusqueda.toLowerCase())) {
  
            combobox.setSelectedItem(item);
            combobox.getEditor().setItem(item);
            encontrado = true;
            break; // Terminar la búsqueda después de seleccionar el primer resultado
        }
    }
    if (!encontrado) {
        // Si no se encontró ningún resultado, mostrar el menú emergente
        combobox.setPopupVisible(true);
    }
}

    private void cargarRepresentantes() {
           ModeloRepresentante modRepre = new ModeloRepresentante();
        ArrayList<Representantes> listaRepresentantes = modRepre.getRepresentantes();
        cbRepresentantes.setEditable(true);

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
        ModeloVehiculo modVehiculo = new ModeloVehiculo();
        ArrayList<Vehiculo> listaVehiculo = modVehiculo.getVehiculos();
        cbChofer.removeAllItems(); // Limpiar los elementos existentes en el ComboBox

        // Agregar los nombres de los choferes al ComboBox
        for (int i = 0; i < listaVehiculo.size(); i++) {
            cbChofer.addItem(listaVehiculo.get(i).getChofer());
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
        txtFecha = new javax.swing.JFormattedTextField();
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
                    .addComponent(cbVehiculo, 0, 150, Short.MAX_VALUE)
                    .addComponent(cbChofer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPatente))
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

        try {
            txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(17, 17, 17))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Representante:");

        tablaMovimientos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(59, 59, 59)
                                        .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(124, 124, 124)
                                        .addComponent(jLabel6))
                                    .addComponent(cbRepresentantes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(btnImprimirHRP, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btnGenerarPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 467, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(cbRepresentantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImprimirHRP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGenerarPdf, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        String fecha = txtFecha.getText();
        String representante = cbRepresentantes.getSelectedItem().toString();
        boolean mostrarCuentaCorriente = cbCC.isSelected();
        boolean mostrarContado = cbContado.isSelected();
        boolean mostrarTodos = cbTodos.isSelected();

        List<Movimientos> listaMovimientos = control.traerMovimientos();
        List<Movimientos> listaFiltrada;

        if (mostrarTodos) {
            listaFiltrada = filtrarPorFechayRep(listaMovimientos, fecha, representante);
        } else {
            listaFiltrada = filtrarMovimientos(listaMovimientos, fecha, representante, mostrarCuentaCorriente, mostrarContado);
        }

        mostrarTablaMovimientos(listaFiltrada);
    }//GEN-LAST:event_btnMostrarActionPerformed

    public List<Movimientos> filtrarMovimientos(List<Movimientos> objetos, String fechaSeleccionada, String representante, boolean mostrarCuentaCorriente, boolean mostrarContado) {
        List<Movimientos> resultados = new ArrayList<>();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date fecha = formato.parse(fechaSeleccionada);

            for (Movimientos objeto : objetos) {
                Date fechaMovimiento = objeto.getFecha();
                String representanteMovimiento = objeto.getRepresentante();
                String cuentaCorriente = objeto.getCuentaCorriente();
                boolean esCuentaCorriente = cuentaCorriente.equalsIgnoreCase("si");

                // Verificar si se debe mostrar el movimiento según los filtros
                boolean mostrarMovimiento = true;
                if (fechaMovimiento != null && !formato.format(fechaMovimiento).equals(fechaSeleccionada)) {
                    mostrarMovimiento = false; // No coincide con la fecha seleccionada
                }
                if (representante != null && !representante.isEmpty() && !representanteMovimiento.equals(representante)) {
                    mostrarMovimiento = false; // No coincide con el representante seleccionado
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
        String titulos[] = {"MOV", "HORA", "FECHA", "CLIENTE", "DESTINO", "REMITO", "BULTOS", "MONTO", "PAGADO", "RENDIDO", "FLETE", "PAGADO", "RENDIDO", "A_CARGO_DE", "REPRESENTANTE", "CC", "OBS"};
        tabla.setColumnIdentifiers(titulos);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tabla);
        tablaMovimientos.setRowSorter(sorter);
        sorter.setSortKeys(java.util.Arrays.asList(new RowSorter.SortKey(1, SortOrder.DESCENDING)));
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaMovimientos;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JTextField txtPatente;
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
                Font fontFilas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 8);
                // LOGO
                InputStream logoStream = getClass().getClassLoader().getResourceAsStream("imagenes/logosolo.jpg");
                Image logo = Image.getInstance(ImageIO.read(logoStream), null);
                logo.scaleToFit(450, 800);
                logo.setAlignment(Element.ALIGN_CENTER);
                document.add(logo);

                // TITULO
                Paragraph titulo = new Paragraph("HOJA DE RUTA", FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK));
                titulo.setAlignment(Element.ALIGN_CENTER);
                titulo.setSpacingAfter(10f); // Espacio después del título (en puntos)
                document.add(titulo);
                // FECHAS
                String fecha = txtFecha.getText();
                // Agregar fechas desde y hasta al título
                Chunk chunkFechas = new Chunk("Fecha: " + fecha, fontFecha);
                Paragraph fechas = new Paragraph(chunkFechas);
                fechas.setAlignment(Element.ALIGN_CENTER);
                fechas.setSpacingAfter(5f); // Espacio después de las fechas (en puntos)
                document.add(fechas);

                // DATOS -> VEHICULO,PATENTE Y CHOFER
                // Crear una tabla para los datos
                PdfPTable datos = new PdfPTable(1);
                datos.setWidthPercentage(100);

                // Obtener el valor seleccionado del ComboBox VEHICULO
                String vehiculoSeleccionado = cbVehiculo.getSelectedItem().toString();
                Phrase vehiculo = new Phrase("Vehiculo: " + vehiculoSeleccionado, fontDatos);
                PdfPCell vehiculoCell = new PdfPCell(vehiculo);
                vehiculoCell.setBorder(Rectangle.NO_BORDER);
                vehiculoCell.setHorizontalAlignment(Element.ALIGN_RIGHT); // Alinear la celda al centro
                datos.addCell(vehiculoCell);

                // Obtener el valor seleccionado del ComboBox PATENTE
                String patenteSeleccionada = txtPatente.getText();
                Phrase patente = new Phrase("Patente: " + patenteSeleccionada, fontDatos);
                PdfPCell patenteCell = new PdfPCell(patente);
                patenteCell.setBorder(Rectangle.NO_BORDER);
                patenteCell.setHorizontalAlignment(Element.ALIGN_RIGHT); // Alinear la celda al centro
                datos.addCell(patenteCell);

                // Obtener el valor seleccionado del ComboBox CHOFER
                String choferSeleccionado = cbChofer.getSelectedItem().toString();
                Phrase chofer = new Phrase("Chofer: " + choferSeleccionado, fontDatos);
                PdfPCell choferCell = new PdfPCell(chofer);
                choferCell.setBorder(Rectangle.NO_BORDER);
                choferCell.setHorizontalAlignment(Element.ALIGN_RIGHT); // Alinear la celda al centro
                datos.addCell(choferCell);

                // Agregar la tabla al documento PDF
                document.add(datos);

                // REPRESENTANTE
                Paragraph rep = new Paragraph(cbRepresentantes.getSelectedItem().toString(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK));
                rep.setAlignment(Element.ALIGN_CENTER);
                rep.setSpacingAfter(10f); // Espacio después del título (en puntos)
                document.add(rep);

                //CREACION DE TABLA
                PdfPTable table = new PdfPTable(tablaMovimientos.getColumnCount() - 7 + 1); // Excluir columnas MOVIMIENTO,FECHA,REPRESENTANTE,Y OBS
                table.setSpacingBefore(10f); // Espacio antes de la tabla (en puntos)
                table.setSpacingAfter(10f);

                // Ajustar espacio horizontal
                // Ajustar espacio horizontal
                float[] columnWidths = {0.9f, 1f, 1f, 0.8f, 0.8f, 1f, 0.8f, 1f, 0.8f, 0.5f, 1.5f}; // Añadir un ancho para la nueva columna "observaciones"
                table.setWidths(columnWidths);

                table.setWidthPercentage(100); // Establecer ancho total de la tabla al 100%

                // Agregar las celdas a la tabla
                for (int i = 0; i < tablaMovimientos.getColumnCount(); i++) {
                    String col = tablaMovimientos.getColumnName(i);
                    if (!col.equals("MOV") && !col.equals("HORA") && !col.equals("FECHA") && !col.equals("REPRESENTANTE") && !col.equals("OBS") && !col.equals("RENDIDO")) {
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
                for (int row = 0; row < tablaMovimientos.getRowCount(); row++) {
                    for (int col = 0; col < tablaMovimientos.getColumnCount(); col++) {
                        String colName = tablaMovimientos.getColumnName(col);
                        if (!colName.equals("MOV") && !colName.equals("HORA") && !colName.equals("FECHA") && !colName.equals("REPRESENTANTE") && !colName.equals("OBS") && !colName.equals("RENDIDO")) {
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
            Font fontFilas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 8);

            // LOGO
            InputStream logoStream = getClass().getClassLoader().getResourceAsStream("imagenes/logosolo.jpg");
            Image logo = Image.getInstance(ImageIO.read(logoStream), null);
            logo.scaleToFit(450, 800);
            logo.setAlignment(Element.ALIGN_CENTER);
            document.add(logo);

            // TITULO
            Paragraph titulo = new Paragraph("HOJA DE RUTA", FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK));
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(10f); // Espacio después del título (en puntos)
            document.add(titulo);
            // FECHAS
            String fecha = txtFecha.getText();
            // Agregar fechas desde y hasta al título
            Chunk chunkFechas = new Chunk("Fecha: " + fecha, fontFecha);
            Paragraph fechas = new Paragraph(chunkFechas);
            fechas.setAlignment(Element.ALIGN_CENTER);
            fechas.setSpacingAfter(5f); // Espacio después de las fechas (en puntos)
            document.add(fechas);

            // DATOS -> VEHICULO,PATENTE Y CHOFER
            // Crear una tabla para los datos
            PdfPTable datos = new PdfPTable(1);
            datos.setWidthPercentage(100);

            // Obtener el valor seleccionado del ComboBox VEHICULO
            String vehiculoSeleccionado = cbVehiculo.getSelectedItem().toString();
            Phrase vehiculo = new Phrase("Vehiculo: " + vehiculoSeleccionado, fontDatos);
            PdfPCell vehiculoCell = new PdfPCell(vehiculo);
            vehiculoCell.setBorder(Rectangle.NO_BORDER);
            vehiculoCell.setHorizontalAlignment(Element.ALIGN_RIGHT); // Alinear la celda al centro
            datos.addCell(vehiculoCell);

            // Obtener el valor seleccionado del ComboBox PATENTE
            String patenteSeleccionada = txtPatente.getText();
            Phrase patente = new Phrase("Patente: " + patenteSeleccionada, fontDatos);
            PdfPCell patenteCell = new PdfPCell(patente);
            patenteCell.setBorder(Rectangle.NO_BORDER);
            patenteCell.setHorizontalAlignment(Element.ALIGN_RIGHT); // Alinear la celda al centro
            datos.addCell(patenteCell);

            // Obtener el valor seleccionado del ComboBox CHOFER
            String choferSeleccionado = cbChofer.getSelectedItem().toString();
            Phrase chofer = new Phrase("Chofer: " + choferSeleccionado, fontDatos);
            PdfPCell choferCell = new PdfPCell(chofer);
            choferCell.setBorder(Rectangle.NO_BORDER);
            choferCell.setHorizontalAlignment(Element.ALIGN_RIGHT); // Alinear la celda al centro
            datos.addCell(choferCell);

            // Agregar la tabla al documento PDF
            document.add(datos);

            // REPRESENTANTE
            Paragraph rep = new Paragraph(cbRepresentantes.getSelectedItem().toString(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK));
            rep.setAlignment(Element.ALIGN_CENTER);
            rep.setSpacingAfter(10f); // Espacio después del título (en puntos)
            document.add(rep);

            //CREACION DE TABLA
            PdfPTable table = new PdfPTable(tablaMovimientos.getColumnCount() - 7 + 1); // Excluir columnas MOVIMIENTO,FECHA,REPRESENTANTE,Y OBS
            table.setSpacingBefore(10f); // Espacio antes de la tabla (en puntos)
            table.setSpacingAfter(10f);

            // Ajustar espacio horizontal
            // Ajustar espacio horizontal
            float[] columnWidths = {0.9f, 1f, 1f, 0.8f, 0.8f, 1f, 0.8f, 1f, 0.8f, 0.5f, 1.5f}; // Añadir un ancho para la nueva columna "observaciones"
            table.setWidths(columnWidths);

            table.setWidthPercentage(100); // Establecer ancho total de la tabla al 100%

            // Agregar las celdas a la tabla
            for (int i = 0; i < tablaMovimientos.getColumnCount(); i++) {
                String col = tablaMovimientos.getColumnName(i);
                if (!col.equals("MOV") && !col.equals("HORA") && !col.equals("FECHA") && !col.equals("REPRESENTANTE") && !col.equals("OBS") && !col.equals("RENDIDO")) {
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
            for (int row = 0; row < tablaMovimientos.getRowCount(); row++) {
                for (int col = 0; col < tablaMovimientos.getColumnCount(); col++) {
                    String colName = tablaMovimientos.getColumnName(col);
                    if (!colName.equals("MOV") && !colName.equals("HORA") && !colName.equals("FECHA") && !colName.equals("REPRESENTANTE") && !colName.equals("OBS") && !colName.equals("RENDIDO")) {
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

            document.add(table);

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
