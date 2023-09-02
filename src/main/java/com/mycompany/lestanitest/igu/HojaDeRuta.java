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
import static com.mycompany.lestanitest.igu.HDDRepresentantes.fechaActual;

import com.mycompany.lestanitest.logica.Controladora;
import com.mycompany.lestanitest.logica.ModeloRepresentante;
import com.mycompany.lestanitest.logica.ModeloVehiculo;
import com.mycompany.lestanitest.logica.Movimientos;
import com.mycompany.lestanitest.logica.Representantes;
import com.mycompany.lestanitest.logica.Vehiculo;
import java.awt.Color;
import static java.awt.Frame.NORMAL;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
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
 * @author Marco
 */
public class HojaDeRuta extends javax.swing.JFrame {

    Controladora control = new Controladora();
    TableRowSorter trs;

    /**
     * Creates new form HojaDeRuta
     */
    public HojaDeRuta() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        llenarVehiculo();
        llenarChofer();
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
    }

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

            txtTotalM.setText(totalFormateado);
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

            txtTotalM.setText(totalFormateado);
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

            txtTotalF.setText(totalFormateado);
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

            txtTotalF.setText(totalFormateado);
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

    public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
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

        // Agregar KeyListener para capturar el evento "Enter"
        cbChofer.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String textoBusqueda = cbChofer.getEditor().getItem().toString();
                    mostrarResultadosBusqueda(cbChofer, textoBusqueda);

                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMes = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtPatente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbChofer = new javax.swing.JComboBox<>();
        cbVehiculo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnImprimirHr = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMovimientos = new javax.swing.JTable();
        btnGenerarPdf = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cbCC = new javax.swing.JRadioButton();
        cbContado = new javax.swing.JRadioButton();
        cbTodos = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtTotalM = new javax.swing.JTextField();
        txtTotalF = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtCantBultos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Expreso Lestani SRL- Hoja de Ruta");
        setExtendedState(6);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(66, 66, 66));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hoja de Ruta");

        jPanel6.setBackground(new java.awt.Color(66, 66, 66));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(236, 240, 241));
        jLabel4.setText("Fecha:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("/");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("/");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel1.setBackground(new java.awt.Color(66, 66, 66));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Patente:");

        txtPatente.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Chofer:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Vehiculo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPatente, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbChofer, 0, 185, Short.MAX_VALUE)
                    .addComponent(cbVehiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbChofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPatente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        btnImprimirHr.setBackground(new java.awt.Color(51, 51, 51));
        btnImprimirHr.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnImprimirHr.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimirHr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/imprimir_24px.png"))); // NOI18N
        btnImprimirHr.setText("Imprimir");
        btnImprimirHr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImprimirHr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirHrActionPerformed(evt);
            }
        });

        tablaMovimientos.setBackground(new java.awt.Color(66, 66, 66));
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

        btnMostrar.setBackground(new java.awt.Color(51, 51, 51));
        btnMostrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Mostrar_24px.png"))); // NOI18N
        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(66, 66, 66));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbCC.setBackground(new java.awt.Color(66, 66, 66));
        buttonGroup1.add(cbCC);
        cbCC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbCC.setForeground(new java.awt.Color(255, 255, 255));
        cbCC.setText("Cuenta Corriente");

        cbContado.setBackground(new java.awt.Color(66, 66, 66));
        buttonGroup1.add(cbContado);
        cbContado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbContado.setForeground(new java.awt.Color(255, 255, 255));
        cbContado.setText("Contado");

        cbTodos.setBackground(new java.awt.Color(66, 66, 66));
        buttonGroup1.add(cbTodos);
        cbTodos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbTodos.setForeground(new java.awt.Color(255, 255, 255));
        cbTodos.setSelected(true);
        cbTodos.setText("Todos");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cta Cte Clientes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTodos)
                            .addComponent(cbContado)
                            .addComponent(cbCC)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel7)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(11, 11, 11)
                .addComponent(cbCC, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbContado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbTodos)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(66, 66, 66));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(236, 240, 241));
        jLabel23.setText("Total Monto $:");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(236, 240, 241));
        jLabel24.setText("Total Flete    $:");

        txtTotalM.setEditable(false);
        txtTotalM.setBackground(new java.awt.Color(51, 51, 51));
        txtTotalM.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtTotalM.setForeground(new java.awt.Color(0, 153, 51));
        txtTotalM.setText("0");
        txtTotalM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalMActionPerformed(evt);
            }
        });

        txtTotalF.setEditable(false);
        txtTotalF.setBackground(new java.awt.Color(51, 51, 51));
        txtTotalF.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtTotalF.setForeground(new java.awt.Color(0, 153, 51));
        txtTotalF.setText("0");
        txtTotalF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalFActionPerformed(evt);
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
                        .addComponent(txtTotalM, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalF)))
                .addGap(28, 28, 28))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnImprimirHr, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnGenerarPdf))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1870, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImprimirHr, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerarPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirHrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirHrActionPerformed
        imprimirPDF();
    }//GEN-LAST:event_btnImprimirHrActionPerformed

    private void btnGenerarPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPdfActionPerformed
        generarPdf();
    }//GEN-LAST:event_btnGenerarPdfActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened
    boolean botonMostrarPresionado;
    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed

        botonMostrarPresionado = true;
        aplicarFiltros();

    }//GEN-LAST:event_btnMostrarActionPerformed

    private void txtTotalMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalMActionPerformed

    }//GEN-LAST:event_txtTotalMActionPerformed

    private void txtTotalFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalFActionPerformed

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

        // Personalizar el tamaño de las celdas
        int cellHeight = 25; // Altura de las celdas
        tablaMovimientos.setRowHeight(cellHeight);

        // Personalizar la alineación del contenido en las celdas (opcional)
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tablaMovimientos.setDefaultRenderer(Object.class, centerRenderer);

        // Establecer el ancho específico de las columnas
        int[] anchos = {15, 50, 50, 120, 120, 40, 25, 80, 30, 30, 80, 30, 30, 50, 100, 30, 120}; // Anchos deseados para cada columna en píxeles

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

    private void cbCCActionPerformed(java.awt.event.ActionEvent evt) {
        updateCc();
        if (cbCC.isSelected()) {
            cbContado.setSelected(false);
            cbTodos.setSelected(false);
        }

    }

    private void updateCc() {
        DefaultTableModel tableModel = (DefaultTableModel) tablaMovimientos.getModel();
        tableModel.setRowCount(0); // Limpiar la tabla

        List<Movimientos> listaMovimientos = control.traerMovimientos();
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
        

        // Recorrer la lista y agregar filas a la tabla
        tableModel.setRowCount(0);
        for (Movimientos mov : listaMovimientos) {
            if ((!cbCC.isSelected() || mov.getCuentaCorriente().equals("Si"))
                    && filtrarPorFecha(Arrays.asList(mov), fechaFormateada).size() > 0) {
                Object[] row = {mov.getId_movimientos(), mov.getFechaFormateada(), mov.getCliente(), mov.getDestino(), mov.getRemito(), mov.getBultos(), mov.getMonto(), mov.getTipoMontoP(), mov.getTipoMontoR(), mov.getFlete(), mov.getTipoFleteP(), mov.getTipoFleteR(), mov.getFleteDestinoOrigen(), mov.getRepresentante(), mov.getCuentaCorriente(), mov.getObservaciones()};
                tableModel.addRow(row);
            }
        }
    }

    private void generarPdf() {
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
                Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 7, Font.BOLD);
                Font fontDatos = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, NORMAL);
                Font fontTotales = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
                Font fontFecha = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
                Font fontFilas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 7);

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
                
                
                // Agregar fechas desde y hasta al título
                Chunk chunkFechas = new Chunk("Fecha: " + fechaFormateada, fontFecha);
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

                // Obtener las filas seleccionadas o todas las filas si no hay ninguna seleccionada
                int[] filasSeleccionadas = tablaMovimientos.getSelectedRows();
                if (filasSeleccionadas.length == 0) {
                    filasSeleccionadas = new int[tablaMovimientos.getRowCount()];
                    for (int i = 0; i < tablaMovimientos.getRowCount(); i++) {
                        filasSeleccionadas[i] = i;
                    }
                }

                // CREACION DE TABLA
                PdfPTable table = new PdfPTable(tablaMovimientos.getColumnCount() - 7);
                table.setSpacingBefore(10f); // Espacio antes de la tabla (en puntos)
                table.setSpacingAfter(10f);

                // Ajustar espacio horizontal
                float[] columnWidths = {0.9f, 1f, 0.8f, 0.8f, 1f, 0.8f, 1f, 0.8f, 1f, 1f}; // Añadir un ancho para la nueva columna "observaciones"
                table.setWidths(columnWidths);
                table.setWidthPercentage(100); // Establecer ancho total de la tabla al 100%

                // Agregar las celdas a la tabla
                for (int i = 0; i < tablaMovimientos.getColumnCount(); i++) {
                    String col = tablaMovimientos.getColumnName(i);
                    if (!col.equals("FECHA") && !col.equals("HORA") && !col.equals("ID") && !col.equals("CC") && !col.equals("OBS") && !col.equals("RENDIDO") && !col.equals("RENDIDO")) {
                        // Cambiar el nombre de la columna "REPRESENTANTE" a "Rep."
                        if (col.equals("REPRESENTANTE")) {
                            col = "REP";
                        }
                        if (col.equals("A_CARGO_DE")) {
                            col = "FLETE A CARGO";
                        }
                        PdfPCell cell = new PdfPCell(new Phrase(col, font));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPaddingBottom(3f); // Espacio inferior de la celda (en puntos)
                        table.addCell(cell);
                    }
                }

                for (int row : filasSeleccionadas) {
                    for (int col = 0; col < tablaMovimientos.getColumnCount(); col++) {
                        String colName = tablaMovimientos.getColumnName(col);
                        if (!colName.equals("FECHA") && !colName.equals("HORA") && !colName.equals("CC") && !colName.equals("OBS") && !colName.equals("ID")
                                && !colName.equals("RENDIDO") && !colName.equals("RENDIDO")) {
                            Object value = tablaMovimientos.getValueAt(row, col);
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

            // Obtener las filas seleccionadas o todas las filas si no hay ninguna seleccionada
            int[] filasSeleccionadas = tablaMovimientos.getSelectedRows();
            if (filasSeleccionadas.length == 0) {
                filasSeleccionadas = new int[tablaMovimientos.getRowCount()];
                for (int i = 0; i < tablaMovimientos.getRowCount(); i++) {
                    filasSeleccionadas[i] = i;
                }
            }

            // CREACION DE TABLA
            PdfPTable table = new PdfPTable(tablaMovimientos.getColumnCount() - 7);
            table.setSpacingBefore(10f); // Espacio antes de la tabla (en puntos)
            table.setSpacingAfter(10f);

            // Ajustar espacio horizontal
            float[] columnWidths = {1.5f, 1.5f, 1f, 0.9f, 1f, 0.9f, 1f, 0.9f, 1f, 1f};
            table.setWidths(columnWidths);
            table.setWidthPercentage(100); // Establecer ancho total de la tabla al 100%

            // Agregar las celdas a la tabla
            for (int i = 0; i < tablaMovimientos.getColumnCount(); i++) {
                String col = tablaMovimientos.getColumnName(i);
                if (!col.equals("FECHA") && !col.equals("HORA") && !col.equals("ID") && !col.equals("CC") && !col.equals("OBS") && !col.equals("RENDIDO") && !col.equals("RENDIDO")) {
                    // Cambiar el nombre de la columna "REPRESENTANTE" a "Rep."
                    if (col.equals("REPRESENTANTE")) {
                        col = "REP";
                    }
                    if (col.equals("A_CARGO_DE")) {
                        col = "Flet a Cargo";
                    }
                    PdfPCell cell = new PdfPCell(new Phrase(col, font));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setPaddingBottom(3f); // Espacio inferior de la celda (en puntos)
                    table.addCell(cell);
                }
            }

            for (int row : filasSeleccionadas) {
                for (int col = 0; col < tablaMovimientos.getColumnCount(); col++) {
                    String colName = tablaMovimientos.getColumnName(col);
                    if (!colName.equals("FECHA") && !colName.equals("HORA") && !colName.equals("CC") && !colName.equals("OBS") && !colName.equals("ID")
                            && !colName.equals("RENDIDO") && !colName.equals("RENDIDO")) {
                        Object value = tablaMovimientos.getValueAt(row, col);
                        if (value != null) {
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
            java.util.logging.Logger.getLogger(HojaDeRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HojaDeRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HojaDeRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HojaDeRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HojaDeRuta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarPdf;
    private javax.swing.JButton btnImprimirHr;
    private javax.swing.JButton btnMostrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cbCC;
    private javax.swing.JComboBox<String> cbChofer;
    private javax.swing.JRadioButton cbContado;
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
    private javax.swing.JTextField txtTotalF;
    private javax.swing.JTextField txtTotalM;
    // End of variables declaration//GEN-END:variables

}
