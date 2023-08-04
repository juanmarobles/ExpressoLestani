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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import javax.imageio.ImageIO;
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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

/**
 *
 * @author Marco
 */
public class Recibos extends javax.swing.JFrame {

    Controladora control = new Controladora();
    TableRowSorter trs;
    DefaultTableModel tabla = new DefaultTableModel();
    private Cliente clienteSeleccionado;
    private String cliente;
    private String fechaDesde;
    private String fechaHasta;
    private List<Movimientos> listaFiltrada;
    private int numeroRecibo = 0;
    private Set<Integer> recibosEliminados = new HashSet<>();
    private List<Movimientos> listaVisible;

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
        actualizarLocalidad();
        // Cargar el número de recibo desde el archivo (si existe)
        cargarNumeroRecibo();
        txtReciboNro.setText(String.format("%05d", numeroRecibo));
        // Cargar los IDs eliminados desde el archivo (si existe)
        cargarRecibosEliminados();
        // Cargar datos en la tabla (suponiendo que carga los datos en la listaFiltrada)
        cargarTablaMovimientos();
        // Agregar el WindowListener para guardar los IDs eliminados antes de cerrar la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                guardarRecibosEliminados();
                // Luego cierra la ventana
                dispose();
            }
        });
        //Por defecto
        cbReciboCon.setSelected(true);

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (cbReciboCon.isSelected()) {
                    // Acciones para el radio button "Recibo con" seleccionado
                    TableColumn pagadoColumn = tablaMovimientos.getColumnModel().getColumn(12);
                    TableColumn rendidoColumn = tablaMovimientos.getColumnModel().getColumn(11);
                    TableColumn fleteColumn = tablaMovimientos.getColumnModel().getColumn(10);
                    // Mostrar las columnas "rendido" y "pagado"
                    rendidoColumn.setMinWidth(75);  // Ajusta los tamaños de columna según tus necesidades
                    rendidoColumn.setMaxWidth(100);
                    rendidoColumn.setWidth(100);
                    pagadoColumn.setMinWidth(75);
                    pagadoColumn.setMaxWidth(100);
                    pagadoColumn.setWidth(100);
                    fleteColumn.setMinWidth(75);
                    fleteColumn.setMaxWidth(100);
                    fleteColumn.setWidth(100);

                } else if (cbReciboSin.isSelected()) {

                    TableColumn pagadoColumn = tablaMovimientos.getColumnModel().getColumn(12);
                    TableColumn rendidoColumn = tablaMovimientos.getColumnModel().getColumn(11);
                    TableColumn fleteColumn = tablaMovimientos.getColumnModel().getColumn(10);

                    // Ocultar las columnas "flete" y "pagado"
                    fleteColumn.setMinWidth(0);
                    fleteColumn.setMaxWidth(0);
                    fleteColumn.setWidth(0);
                    pagadoColumn.setMinWidth(0);
                    pagadoColumn.setMaxWidth(0);
                    pagadoColumn.setWidth(0);
                    rendidoColumn.setMinWidth(0);
                    rendidoColumn.setMaxWidth(0);
                    rendidoColumn.setWidth(0);
                    // Mostrar nuevamente las columnas "flete" y "pagado"
                    fleteColumn.setMinWidth(75);  // Ajusta los tamaños de columna según tus necesidades
                    fleteColumn.setMaxWidth(100);
                    fleteColumn.setWidth(100);
                    pagadoColumn.setMinWidth(75);
                    pagadoColumn.setMaxWidth(100);
                    pagadoColumn.setWidth(100);
                    rendidoColumn.setMinWidth(75);
                    rendidoColumn.setMaxWidth(100);
                    rendidoColumn.setWidth(100);

                    // Actualizar el cálculo del flete total
                    if (!cbReciboSin.isSelected()) {
                        calcularTotales();
                    } else {
                        txtTotalFlete.setText("");
                    }

                    // Actualizar la tabla para reflejar los cambios
                    tablaMovimientos.getTableHeader().resizeAndRepaint();
                    tablaMovimientos.repaint();

                }

                // Actualizar la tabla para reflejar los cambios
                tablaMovimientos.getTableHeader().resizeAndRepaint();
                tablaMovimientos.repaint();
            }
        };

        cbReciboCon.addActionListener(listener);
        cbReciboSin.addActionListener(listener);

        //Boton agregar
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int[] filasSeleccionadas = tablaMovimientos.getSelectedRows();
                double sumaMontos = 0.0;
                double sumaFletes = 0.0;

                boolean reciboSinFlete = cbReciboSin.isSelected();

                for (int fila : filasSeleccionadas) {
                    String montoStr = tablaMovimientos.getValueAt(fila, 7).toString().substring(1).replace(".", "").replace(",", ".");

                    double monto = Double.parseDouble(montoStr);
                    sumaMontos += monto;

                    if (!reciboSinFlete) {
                        String fleteStr = tablaMovimientos.getValueAt(fila, 10).toString().substring(1).replace(".", "").replace(",", ".");
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
        // Ocultar las filas con ID presentes en recibosEliminados
        ocultarFilasEliminadas();
        //BOTON IMPRIMIR
        btnImprimir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cbReciboSin.isSelected()) {
                    imprimirPdfSinFlete();
                } else if (cbReciboCon.isSelected()) {
                    boolean incluirFlete = cbReciboCon.isSelected();
                    imprimirPdfConFlete(incluirFlete);
                }

                // Obtiene los índices de las filas seleccionadas en la tabla
                int[] selectedRows = tablaMovimientos.getSelectedRows();

                // Verifica si hay filas seleccionadas
                if (selectedRows.length > 0) {
                    // Obtén el modelo de tabla asociado a la tabla
                    DefaultTableModel model = (DefaultTableModel) tablaMovimientos.getModel();

                    // Lista para almacenar los índices de las filas seleccionadas que serán eliminadas
                    List<Integer> filasAEliminar = new ArrayList<>();

                    // Recorre los índices de las filas seleccionadas en orden inverso
                    // para evitar conflictos en los índices al eliminar
                    for (int i = selectedRows.length - 1; i >= 0; i--) {
                        int rowIndex = selectedRows[i];

                        // Cambiar el valor "Rendido" y actualizar en la base de datos
                        cambiarValorRendido(model, rowIndex);

                        // Agrega el índice de la fila a la lista de filas a eliminar
                        filasAEliminar.add(rowIndex);

                        // Obtiene el ID del elemento que se va a eliminar
                        int id = (int) model.getValueAt(rowIndex, 0);

                        // Agrega el ID a la lista recibosEliminados
                        recibosEliminados.add(id);
                    }

                    // Eliminar las filas del modelo de tabla
                    for (int rowIndex : filasAEliminar) {
                        model.removeRow(rowIndex);
                    }

                    // Actualiza la visualización de la tabla
                    tablaMovimientos.repaint();

                   //imprimir();

                } else {
                    // No se ha seleccionado ninguna fila, muestra un mensaje de error o realiza alguna otra acción
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Oculta las filas eliminadas después de eliminar todas las filas seleccionadas
                ocultarFilasEliminadas();
            }
        });

        //BOTON GENERAR PDF
        btnGenerarPdf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cbReciboSin.isSelected()) {
                    generarPdfSinFlete();
                } else if (cbReciboCon.isSelected()) {
                    boolean incluirFlete = cbReciboCon.isSelected();
                    imprimirPdfConFlete(incluirFlete);
                }

                // Obtiene los índices de las filas seleccionadas en la tabla
                int[] selectedRows = tablaMovimientos.getSelectedRows();

                // Verifica si hay filas seleccionadas
                if (selectedRows.length > 0) {
                    // Obtén el modelo de tabla asociado a la tabla
                    DefaultTableModel model = (DefaultTableModel) tablaMovimientos.getModel();

                    // Lista para almacenar los índices de las filas seleccionadas que serán eliminadas
                    List<Integer> filasAEliminar = new ArrayList<>();

                    // Recorre los índices de las filas seleccionadas en orden inverso
                    // para evitar conflictos en los índices al eliminar
                    for (int i = selectedRows.length - 1; i >= 0; i--) {
                        int rowIndex = selectedRows[i];

                        // Cambiar el valor "Rendido" y actualizar en la base de datos
                        cambiarValorRendido(model, rowIndex);

                        // Agrega el índice de la fila a la lista de filas a eliminar
                        filasAEliminar.add(rowIndex);

                        // Obtiene el ID del elemento que se va a eliminar
                        int id = (int) model.getValueAt(rowIndex, 0);

                        // Agrega el ID a la lista recibosEliminados
                        recibosEliminados.add(id);
                    }

                    // Eliminar las filas del modelo de tabla
                    for (int rowIndex : filasAEliminar) {
                        model.removeRow(rowIndex);
                    }

                    // Actualiza la visualización de la tabla
                    tablaMovimientos.repaint();

                    //imprimir();

                } else {
                    // No se ha seleccionado ninguna fila, muestra un mensaje de error o realiza alguna otra acción
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Oculta las filas eliminadas después de eliminar todas las filas seleccionadas
                ocultarFilasEliminadas();
            }
        });

        actualizarTabla();
    }

    private List<Movimientos> filtrarMovimientos(List<Movimientos> movimientos) {
        List<Movimientos> resultados = new ArrayList<>();

        for (Movimientos mov : movimientos) {
            String rendido = mov.getTipoMontoR();
            if (!recibosEliminados.contains(mov.getId_movimientos()) && !"Si".equalsIgnoreCase(rendido)) {
                resultados.add(mov);
            }
        }

        return resultados;
    }
    // Método para cambiar el valor de "Rendido" en el modelo de tabla y en la base de datos

    private void cambiarValorRendido(DefaultTableModel model, int rowIndex) {
        model.setValueAt("Si", rowIndex, 8); // Establecer "Si" en la columna de "Rendido"

        int idMovimientos = (int) model.getValueAt(rowIndex, 0);
        Movimientos movimiento = control.traerMovimiento(idMovimientos);

        if (movimiento != null) {
            movimiento.setTipoMontoR("Si"); // Guardar el valor "Si" en la base de datos
            control.actualizarMontoR(movimiento, "Si"); // Utilizar el método actualizarMontoR() de la controladora
        }
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

        // Crear una nueva lista visible basada en listaFiltrada
        listaVisible = filtrarMovimientos(listaFiltrada);
        DefaultTableModel tabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String titulos[] = {"ID", "HORA", "FECHA", "CLIENTE", "DESTINO", "REMITO", "BULTOS", "MONTO", "PAGADO", "RENDIDO", "FLETE", "PAGADO", "RENDIDO", "A_CARGO_DE", "REPRESENTANTE", "CC", "OBS"};
        tabla.setColumnIdentifiers(titulos);

        for (Movimientos mov : listaFiltrada) {
            String rendido = mov.getTipoMontoR();
            // Verificar si el movimiento no está en la lista de recibosEliminados
            // y si la columna "Rendido" no tiene el valor "Si"
            if (!recibosEliminados.contains(mov.getId_movimientos()) && !"Si".equalsIgnoreCase(rendido)) {
                Object[] objeto = {mov.getId_movimientos(), mov.getHora(), mov.getFechaFormateada(), mov.getCliente(), mov.getDestino(), mov.getRemito(), mov.getBultos(), mov.getMonto(), mov.getTipoMontoP(), mov.getTipoMontoR(), mov.getFlete(), mov.getTipoFleteP(), mov.getTipoFleteR(), mov.getFleteDestinoOrigen(), mov.getRepresentante(), mov.getCuentaCorriente(), mov.getObservaciones()};
                tabla.addRow(objeto);
            }
        }

        tablaMovimientos.setModel(tabla);
        int[] anchos = {20, 80, 100, 100, 100, 70, 80, 100, 80, 80, 100, 80, 80, 120, 120, 40, 200}; // Anchos deseados para cada columna en píxeles

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

    //LLENAR TEXTFIELD CLIENTES
    private void cargarClientes() {
        ModeloCliente modClientes = new ModeloCliente();
        ArrayList<Cliente> listaClientes = modClientes.getClientes();
        AutoCompleteDecorator.decorate(txtCliente, listaClientes, false);

        // Agregar un listener al textfield del cliente
        txtCliente.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                actualizarLocalidad();
            }
        });
    }

    private void actualizarLocalidad() {
        // Carga de los datos desde la base de datos
        List<Cliente> listaC = control.traerClientes();
        // Buscar el cliente correspondiente en la lista
        String nombreCliente = txtCliente.getText().trim().toLowerCase();
        for (Cliente cliente : listaC) {
            if (cliente.getNombre().toLowerCase().equals(nombreCliente)) {
                clienteSeleccionado = cliente;
                // Mostrar la localidad en el textfield correspondiente
                txtDomicilio.setText(cliente.getDireccion());
                return;
            }
        }
        // Si no se encuentra el cliente, se establece el campo de texto del domicilio como vacío
        txtDomicilio.setText("");
    }

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
        btnQuitar = new javax.swing.JButton();
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
        setTitle("Expreso Lestani SRL - Recibos");
        setBackground(new java.awt.Color(66, 66, 66));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(66, 66, 66));
        jPanel1.setFocusable(false);

        cbReciboSin.setBackground(new java.awt.Color(66, 66, 66));
        buttonGroup1.add(cbReciboSin);
        cbReciboSin.setForeground(new java.awt.Color(255, 255, 255));
        cbReciboSin.setText("Recibo Sin Flete");
        cbReciboSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbReciboSinActionPerformed(evt);
            }
        });

        cbReciboCon.setBackground(new java.awt.Color(66, 66, 66));
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

        jLabel2.setBackground(new java.awt.Color(66, 66, 66));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Recibo N°");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Domicilio:");

        txtDomicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDomicilioActionPerformed(evt);
            }
        });

        txtConcepto.setText("PAGO CONTRAREEMBOLSO");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("En Concepto de:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("RECIBI DE EXPRESSO LESTANI LA SUMA DE: ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("TOTAL MONTO:  $ ");

        txtTotalMonto.setText("0");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TOTAL FLETE:  $");

        txtTotalFlete.setText("0");

        btnAgregar.setBackground(new java.awt.Color(51, 51, 51));
        btnAgregar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

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
        jScrollPane2.setViewportView(tablaMovimientos);

        btnQuitar.setBackground(new java.awt.Color(51, 51, 51));
        btnQuitar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnQuitar.setForeground(new java.awt.Color(236, 240, 241));
        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/X_24px.png"))); // NOI18N
        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
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
                        .addGap(0, 1060, Short.MAX_VALUE))
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
                .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerarPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cbReciboSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbReciboSinActionPerformed

    }//GEN-LAST:event_cbReciboSinActionPerformed

    private void cbReciboConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbReciboConActionPerformed

    }//GEN-LAST:event_cbReciboConActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed

    }//GEN-LAST:event_btnImprimirActionPerformed
    private void ocultarFilasEliminadas() {
        DefaultTableModel model = (DefaultTableModel) tablaMovimientos.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);

        // Crear un filtro para ocultar las filas eliminadas
        RowFilter<DefaultTableModel, Integer> filter = new RowFilter<DefaultTableModel, Integer>() {
            @Override
            public boolean include(Entry<? extends DefaultTableModel, ? extends Integer> entry) {
                int id = (int) entry.getValue(0); // Obtener el valor del ID en la columna 0
                return !recibosEliminados.contains(id);
            }
        };

        // Establecer el filtro en el TableRowSorter
        sorter.setRowFilter(filter);

        // Asignar el TableRowSorter a la tabla para que se aplique el filtro
        tablaMovimientos.setRowSorter(sorter);
    }

    private void guardarRecibosEliminados() {
        try {
            FileOutputStream fileOut = new FileOutputStream("recibosEliminados.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(recibosEliminados);
            out.close();
            fileOut.close();
            System.out.println("Lista recibosEliminados guardada en recibosEliminados.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarRecibosEliminados() {
        try {
            FileInputStream fileIn = new FileInputStream("recibosEliminados.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            recibosEliminados = (Set<Integer>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Lista recibosEliminados cargada desde recibosEliminados.ser");
        } catch (IOException | ClassNotFoundException e) {
            // Si el archivo no existe o hay un error en la lectura, simplemente inicializamos recibosEliminados como un nuevo HashSet
            recibosEliminados = new HashSet<>();
        }
    }

    public void actualizarTabla() {
        // Limpia el modelo de tabla
        DefaultTableModel model = (DefaultTableModel) tablaMovimientos.getModel();
        model.setRowCount(0);

        // Filtrar los movimientos excluyendo aquellos que estén presentes en recibosEliminados
        listaVisible.clear();
        for (Movimientos mov : listaFiltrada) {
            if (!recibosEliminados.contains(mov.getId_movimientos())) {
                listaVisible.add(mov);
            }
        }

        // Carga nuevamente la tabla usando la lista de movimientos filtrados (listaVisible)
        for (Movimientos mov : listaVisible) {
            Object[] objeto = {mov.getId_movimientos(), mov.getHora(), mov.getFechaFormateada(), mov.getCliente(), mov.getDestino(), mov.getRemito(), mov.getBultos(), mov.getMonto(), mov.getTipoMontoP(), mov.getTipoMontoR(), mov.getFlete(), mov.getTipoFleteP(), mov.getTipoFleteR(), mov.getFleteDestinoOrigen(), mov.getRepresentante(), mov.getCuentaCorriente(), mov.getObservaciones()};
            model.addRow(objeto);
        }

        // Oculta las filas eliminadas nuevamente
        ocultarFilasEliminadas();

        // Repinta la tabla para reflejar los cambios
        tablaMovimientos.repaint();
    }

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
                    if (!col.equals("RENDIDO") && !col.equals("RENDIDO") && !col.equals("REPRESENTANTE") && !col.equals("FLETE") && !col.equals("PAGADO") && !col.equals("CLIENTE") && !col.equals("A_CARGO_DE") && !col.equals("CC") && !col.equals("ID")) {
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
                        if (!colName.equals("RENDIDO") && !colName.equals("RENDIDO") && !colName.equals("REPRESENTANTE") && !colName.equals("FLETE") && !colName.equals("PAGADO") && !colName.equals("CLIENTE") && !colName.equals("A_CARGO_DE") && !colName.equals("CC") && !colName.equals("ID")) {
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
            JOptionPane.showMessageDialog(null, "", "", JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    private void btnGenerarPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPdfActionPerformed

    }//GEN-LAST:event_btnGenerarPdfActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        txtTotalMonto.setText("");
        txtTotalFlete.setText("");
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void txtDomicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDomicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomicilioActionPerformed
    private void generarPdfSinFlete() {
        Document document = new Document();
        // Incrementar el contador de recibo
        numeroRecibo++;
        // Generar el número de recibo en formato de 5 dígitos
        String numeroReciboString = String.format("%05d", numeroRecibo);
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
                Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
                Font fontColumnas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
                Font fontTotales = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
                Font fontFecha = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
                Font fontFilas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, Font.NORMAL, BaseColor.BLACK);
                // Crea una tabla con 2 columnas
                float[] anchos = {1f, 1f};
                PdfPTable tablaTitulos = new PdfPTable(anchos);
                tablaTitulos.setWidthPercentage(100);

                // TITULO RECIBO (primera columna)
                Paragraph titulo = new Paragraph("RECIBO", FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD));
                titulo.setAlignment(Element.ALIGN_RIGHT);
                PdfPCell tituloCell = new PdfPCell();
                tituloCell.addElement(titulo);
                tituloCell.setBorder(PdfPCell.NO_BORDER);
                tablaTitulos.addCell(tituloCell);

                // FECHAS y RECIBO NRO (segunda columna)
                Paragraph fechaRecibo = new Paragraph();
                Chunk chunkFechas = new Chunk("Fecha: " + fechaActual(), fontFecha);
                fechaRecibo.add(chunkFechas);
                fechaRecibo.add(Chunk.NEWLINE); // Agrega una nueva línea entre "Fecha" y "Recibo Nro"
                Chunk chunkNroRecibo = new Chunk("RECIBO Nro: " + String.format("%05d", numeroRecibo), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL));
                fechaRecibo.add(chunkNroRecibo);
                fechaRecibo.setAlignment(Element.ALIGN_RIGHT);

                PdfPCell fechaReciboCell = new PdfPCell();
                fechaReciboCell.addElement(fechaRecibo);
                fechaReciboCell.setBorder(PdfPCell.NO_BORDER);
                tablaTitulos.addCell(fechaReciboCell);

                // LOGO
                InputStream logoStream = getClass().getClassLoader().getResourceAsStream("imagenes/ivacuit.jpg");
                Image logo = Image.getInstance(ImageIO.read(logoStream), null);
                logo.scaleToFit(530, 800);
                logo.setAlignment(Element.ALIGN_LEFT);

                // DOC NO VALIDO COMO FACTURA
                Paragraph subtitulo = new Paragraph("DOCUMENTO NO VALIDO COMO FACTURA", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL));
                subtitulo.setAlignment(Element.ALIGN_CENTER);
                subtitulo.setSpacingAfter(5f); // Espacio después del título (en puntos)
                //document.add(titulo);
                document.add(tablaTitulos);
                //document.add(fecha);
                //document.add(nroRecibo);
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
                Phrase senoresValue = new Phrase(txtCliente.getText().toUpperCase(), font);
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
                Phrase domicilioValue = new Phrase(txtDomicilio.getText().toUpperCase(), font);
                PdfPCell domicilioValueCell = new PdfPCell(new Paragraph(domicilioValue));
                domicilioValueCell.setBorder(Rectangle.BOX);
                domicilioValueCell.setPadding(5f);
                domicilioValueCell.setPaddingBottom(5f); // Espacio después de la celda
                senoresdomicilio.addCell(domicilioValueCell);

                document.add(senoresdomicilio);

                // Crear una tabla para recibi y concepto
                PdfPTable recibiconcepto = new PdfPTable(2);
                recibiconcepto.setWidthPercentage(100);

                // RECIBI LA SUMA D PESOS...
                Phrase texto = new Phrase("\nRECIBÍ DE EXPRESO LESTANI LA SUMA DE PESOS: " + txtRecibi.getText().toUpperCase(), font);
                Paragraph textoRecibi = new Paragraph(texto);
                textoRecibi.setAlignment(Element.ALIGN_LEFT);

                // Reducir el interlineado (leading) del párrafo textoRecibi
                textoRecibi.setLeading(0f, 0.8f); // Ajusta el segundo parámetro según el espacio deseado

                document.add(textoRecibi);

                // CONCEPTO DE
                Phrase textodos = new Phrase("\nEN CONCEPTO DE: " + txtConcepto.getText().toUpperCase(), font);
                Paragraph textoConcepto = new Paragraph(textodos);
                textoConcepto.setAlignment(Element.ALIGN_LEFT);

                // Reducir el interlineado (leading) del párrafo textoConcepto
                textoConcepto.setLeading(0f, 0.8f); // Ajusta el segundo parámetro según el espacio deseado

                document.add(textoConcepto);

                document.add(recibiconcepto);

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
                        if (!col.equals("ID") && !col.equals("HORA") && !col.equals("RENDIDO") && !col.equals("RENDIDO") && !col.equals("REPRESENTANTE") && !col.equals("FLETE") && !col.equals("PAGADO") && !col.equals("CLIENTE") && !col.equals("A_CARGO_DE") && !col.equals("CC") && !col.equals("MOVIMIENTO")) {
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
                            if (!colName.equals("ID") && !colName.equals("HORA") && !colName.equals("RENDIDO") && !colName.equals("RENDIDO") && !colName.equals("REPRESENTANTE") && !colName.equals("FLETE") && !colName.equals("PAGADO") && !colName.equals("CLIENTE") && !colName.equals("A_CARGO_DE") && !colName.equals("CC") && !colName.equals("MOVIMIENTO")) {
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

                // Crear una tabla para los montos totales y firmasello
                PdfPTable totalFirmaTable = new PdfPTable(2);
                totalFirmaTable.setWidthPercentage(100);

                // Monto total
                Phrase montoTotalPhrase = new Phrase("TOTAL MONTO: $" + txtTotalMonto.getText(), fontTotales);
                PdfPCell montoTotalCell = new PdfPCell(montoTotalPhrase);
                montoTotalCell.setBorder(Rectangle.NO_BORDER);
                montoTotalCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                totalFirmaTable.addCell(montoTotalCell);

                // Agregar celda derecha para firmasello
                PdfPCell firmaSelloCell = new PdfPCell();
                firmaSelloCell.setBorder(Rectangle.NO_BORDER);
                firmaSelloCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                firmaSelloCell.setFixedHeight(150); // Ajusta la altura de acuerdo a tus necesidades

                // Crear tabla anidada para la imagen
                PdfPTable firmaSelloTable = new PdfPTable(1);
                firmaSelloTable.setWidthPercentage(100);

                // Agregar la imagen firmasello a la tabla anidada
                InputStream firmaselloStream = getClass().getClassLoader().getResourceAsStream("imagenes/firmasello.jpg");
                Image firmasello = Image.getInstance(ImageIO.read(firmaselloStream), null);
                firmasello.scaleToFit(150, 150);
                PdfPCell firmaSelloImageCell = new PdfPCell(firmasello);
                firmaSelloImageCell.setBorder(Rectangle.NO_BORDER);
                firmaSelloImageCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                firmaSelloTable.addCell(firmaSelloImageCell);

                // Agregar la tabla anidada a la celda derecha de la tabla principal
                firmaSelloCell.addElement(firmaSelloTable);

                // Agregar celda derecha a la tabla principal
                totalFirmaTable.addCell(firmaSelloCell);

                // Agregar la tabla totalFirmaTable al documento
                document.add(totalFirmaTable);

                document.close();
                txtReciboNro.setText(String.valueOf(numeroRecibo));
                writer.close();

                JOptionPane.showMessageDialog(null, "El archivo se generó correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (DocumentException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void generarPdfConFlete(boolean incluirFlete) {
        Document document = new Document();
        // Incrementar el contador de recibo
        numeroRecibo++;
        // Generar el número de recibo en formato de 5 dígitos
        String numeroReciboString = String.format("%05d", numeroRecibo);

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
                InputStream logoStream = getClass().getClassLoader().getResourceAsStream("imagenes/ivacuit.jpg");
                Image logo = Image.getInstance(ImageIO.read(logoStream), null);
                logo.scaleToFit(530, 800);
                logo.setAlignment(Element.ALIGN_LEFT);

                // FIRMASELLO
                InputStream firmaselloStream = getClass().getClassLoader().getResourceAsStream("imagenes/firmasello.jpg");
                Image firmasello = Image.getInstance(ImageIO.read(firmaselloStream), null);
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
                Phrase senoresLabel = new Phrase("SEÑORES: ", font);
                PdfPCell senoresLabelCell = new PdfPCell(new Paragraph(senoresLabel));
                senoresLabelCell.setBorder(Rectangle.BOX);
                senoresLabelCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                senoresLabelCell.setPaddingBottom(5f); // Espacio después de la celda
                senoresdomicilio.addCell(senoresLabelCell);

                // Contenido de la columna "Señores"
                Phrase senoresValue = new Phrase(txtCliente.getText().toUpperCase(), font);
                PdfPCell senoresValueCell = new PdfPCell(new Paragraph(senoresValue));
                senoresValueCell.setBorder(Rectangle.BOX);
                senoresValueCell.setPadding(5f);
                senoresValueCell.setPaddingBottom(5f); // Espacio después de la celda
                senoresdomicilio.addCell(senoresValueCell);

                // Columna "Domicilio"
                Phrase domicilioLabel = new Phrase("DOMICILIO: ", font);
                PdfPCell domicilioLabelCell = new PdfPCell(new Paragraph(domicilioLabel));
                domicilioLabelCell.setBorder(Rectangle.BOX);
                domicilioLabelCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                domicilioLabelCell.setPaddingBottom(5f); // Espacio después de la celda
                senoresdomicilio.addCell(domicilioLabelCell);

                // Contenido de la columna "Domicilio"
                Phrase domicilioValue = new Phrase(txtDomicilio.getText().toUpperCase(), font);
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
                Phrase texto = new Phrase("\nRECIBÍ DE EXPRESO LESTANI LA SUMA DE PESOS: " + txtRecibi.getText().toUpperCase(), font);
                Paragraph textoRecibi = new Paragraph(texto);
                textoRecibi.setAlignment(Element.ALIGN_LEFT);
                document.add(textoRecibi);

                // CONCEPTO DE
                Phrase textodos = new Phrase("\nEN CONCEPTO DE: " + txtConcepto.getText().toUpperCase(), font);
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
                    float[] columnWidths = {0.8f, 1f, 0.7f, 0.7f, 1f, 1f, 1f, 1f}; // Anchos de las columnas (proporciones)
                    table.setWidths(columnWidths);
                    table.setWidthPercentage(100); // Establecer ancho total de la tabla al 100%

                    // Agregar las celdas de encabezado a la tabla, excluyendo las columnas suprimidas
                    for (int i = 0; i < tablaMovimientos.getColumnCount(); i++) {
                        String col = tablaMovimientos.getColumnName(i);
                        if (!col.equals("ID") && !col.equals("HORA") && !col.equals("PAGADO") && !col.equals("REPRESENTANTE") && !col.equals("CLIENTE") && !col.equals("CC") && !col.equals("RENDIDO") && !col.equals("RENDIDO")) {
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
                            if (!colName.equals("ID") && !colName.equals("HORA") && !colName.equals("REPRESENTANTE") && !colName.equals("CLIENTE") && !colName.equals("PAGADO") && !colName.equals("CC") && !colName.equals("RENDIDO") && !colName.equals("RENDIDO")) {
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

                writer.close();

                JOptionPane.showMessageDialog(null, "El recibo se generó correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (DocumentException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void imprimirPdfSinFlete() {
        Document document = new Document();
        // Incrementar el contador de recibo
        numeroRecibo++;
        // Generar el número de recibo en formato de 5 dígitos
        String numeroReciboString = String.format("%05d", numeroRecibo);
        try {
            String userHome = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
            String outputPath = userHome + File.separator + "archivo.pdf";
            // Crear el archivo de salida
            File outputFile = new File(outputPath);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputFile));

            document.open();

            //FUENTES
            Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
            Font fontColumnas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
            Font fontTotales = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
            Font fontFecha = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
            Font fontFilas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, Font.NORMAL, BaseColor.BLACK);

            // Crea una tabla con 2 columnas
            float[] anchos = {1f, 1f};
            PdfPTable tablaTitulos = new PdfPTable(anchos);
            tablaTitulos.setWidthPercentage(100);

            // TITULO RECIBO (primera columna)
            Paragraph titulo = new Paragraph("RECIBO", FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD));
            titulo.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell tituloCell = new PdfPCell();
            tituloCell.addElement(titulo);
            tituloCell.setBorder(PdfPCell.NO_BORDER);
            tablaTitulos.addCell(tituloCell);

            // FECHAS y RECIBO NRO (segunda columna)
            Paragraph fechaRecibo = new Paragraph();
            Chunk chunkFechas = new Chunk("Fecha: " + fechaActual(), fontFecha);
            fechaRecibo.add(chunkFechas);
            fechaRecibo.add(Chunk.NEWLINE); // Agrega una nueva línea entre "Fecha" y "Recibo Nro"
            Chunk chunkNroRecibo = new Chunk("RECIBO Nro: " + String.format("%05d", numeroRecibo), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL));
            fechaRecibo.add(chunkNroRecibo);
            fechaRecibo.setAlignment(Element.ALIGN_RIGHT);

            PdfPCell fechaReciboCell = new PdfPCell();
            fechaReciboCell.addElement(fechaRecibo);
            fechaReciboCell.setBorder(PdfPCell.NO_BORDER);
            tablaTitulos.addCell(fechaReciboCell);

            // LOGO
            InputStream logoStream = getClass().getClassLoader().getResourceAsStream("imagenes/ivacuit.jpg");
            Image logo = Image.getInstance(ImageIO.read(logoStream), null);
            logo.scaleToFit(530, 800);
            logo.setAlignment(Element.ALIGN_LEFT);

            // DOC NO VALIDO COMO FACTURA
            Paragraph subtitulo = new Paragraph("DOCUMENTO NO VALIDO COMO FACTURA", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL));
            subtitulo.setAlignment(Element.ALIGN_CENTER);
            subtitulo.setSpacingAfter(10f); // Espacio después del título (en puntos)

            //document.add(titulo);
            document.add(tablaTitulos);
            //document.add(fecha);
            //document.add(nroRecibo);
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
            Phrase senoresValue = new Phrase(txtCliente.getText().toUpperCase(), font);
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
            Phrase domicilioValue = new Phrase(txtDomicilio.getText().toUpperCase(), font);
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
            Phrase texto = new Phrase("\nRECIBÍ DE EXPRESO LESTANI LA SUMA DE PESOS: " + txtRecibi.getText().toUpperCase(), font);
            Paragraph textoRecibi = new Paragraph(texto);
            textoRecibi.setAlignment(Element.ALIGN_LEFT);

            // Reducir el interlineado (leading) del párrafo textoRecibi
            textoRecibi.setLeading(0f, 0.8f); // Ajusta el segundo parámetro según el espacio deseado

            document.add(textoRecibi);

            // CONCEPTO DE
            Phrase textodos = new Phrase("\nEN CONCEPTO DE: " + txtConcepto.getText().toUpperCase(), font);
            Paragraph textoConcepto = new Paragraph(textodos);
            textoConcepto.setAlignment(Element.ALIGN_LEFT);

            // Reducir el interlineado (leading) del párrafo textoConcepto
            textoConcepto.setLeading(0f, 0.8f); // Ajusta el segundo parámetro según el espacio deseado

            document.add(textoConcepto);

            document.add(recibiconcepto);

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
                    if (!col.equals("ID") && !col.equals("HORA") && !col.equals("RENDIDO") && !col.equals("RENDIDO") && !col.equals("REPRESENTANTE") && !col.equals("FLETE") && !col.equals("PAGADO") && !col.equals("CLIENTE") && !col.equals("A_CARGO_DE") && !col.equals("CC") && !col.equals("MOVIMIENTO")) {
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
                        if (!colName.equals("ID") && !colName.equals("HORA") && !colName.equals("RENDIDO") && !colName.equals("RENDIDO") && !colName.equals("REPRESENTANTE") && !colName.equals("FLETE") && !colName.equals("PAGADO") && !colName.equals("CLIENTE") && !colName.equals("A_CARGO_DE") && !colName.equals("CC") && !colName.equals("MOVIMIENTO")) {
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

            // Crear una tabla para los montos totales y firmasello
            PdfPTable totalFirmaTable = new PdfPTable(2);
            totalFirmaTable.setWidthPercentage(100);

            // Monto total
            Phrase montoTotalPhrase = new Phrase("TOTAL MONTO: $" + txtTotalMonto.getText(), fontTotales);
            PdfPCell montoTotalCell = new PdfPCell(montoTotalPhrase);
            montoTotalCell.setBorder(Rectangle.NO_BORDER);
            montoTotalCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            totalFirmaTable.addCell(montoTotalCell);

            // Agregar celda derecha para firmasello
            PdfPCell firmaSelloCell = new PdfPCell();
            firmaSelloCell.setBorder(Rectangle.NO_BORDER);
            firmaSelloCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            firmaSelloCell.setFixedHeight(150); // Ajusta la altura de acuerdo a tus necesidades

            // Crear tabla anidada para la imagen
            PdfPTable firmaSelloTable = new PdfPTable(1);
            firmaSelloTable.setWidthPercentage(100);

            // Agregar la imagen firmasello a la tabla anidada
            InputStream firmaselloStream = getClass().getClassLoader().getResourceAsStream("imagenes/firmasello.jpg");
            Image firmasello = Image.getInstance(ImageIO.read(firmaselloStream), null);
            firmasello.scaleToFit(150, 150);
            PdfPCell firmaSelloImageCell = new PdfPCell(firmasello);
            firmaSelloImageCell.setBorder(Rectangle.NO_BORDER);
            firmaSelloImageCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            firmaSelloTable.addCell(firmaSelloImageCell);

            // Agregar la tabla anidada a la celda derecha de la tabla principal
            firmaSelloCell.addElement(firmaSelloTable);

            // Agregar celda derecha a la tabla principal
            totalFirmaTable.addCell(firmaSelloCell);

            // Agregar la tabla totalFirmaTable al documento
            document.add(totalFirmaTable);

            document.close();
            txtReciboNro.setText(String.valueOf(numeroRecibo));
            guardarNumeroRecibo();
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

                JOptionPane.showMessageDialog(null, "El recibo se generó e imprimió correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "", "Información", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (DocumentException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Impreso con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void imprimirPdfConFlete(boolean incluirFlete) {
        Document document = new Document();
        // Incrementar el contador de recibo
        numeroRecibo++;
        // Generar el número de recibo en formato de 5 dígitos
        String numeroReciboString = String.format("%05d", numeroRecibo);

        try {

            String userHome = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
            String outputPath = userHome + File.separator + "archivo.pdf";
            // Crear el archivo de salida
            File outputFile = new File(outputPath);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputFile));
            document.open();

            //FUENTES
            Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
            Font fontColumnas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);
            Font fontTotales = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
            Font fontFecha = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
            Font fontFilas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, Font.NORMAL, BaseColor.BLACK);

            // Crea una tabla con 2 columnas
            float[] anchos = {1f, 1f};
            PdfPTable tablaTitulos = new PdfPTable(anchos);
            tablaTitulos.setWidthPercentage(100);

            // TITULO RECIBO (primera columna)
            Paragraph titulo = new Paragraph("RECIBO", FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD));
            titulo.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell tituloCell = new PdfPCell();
            tituloCell.addElement(titulo);
            tituloCell.setBorder(PdfPCell.NO_BORDER);
            tablaTitulos.addCell(tituloCell);

            // FECHAS y RECIBO NRO (segunda columna)
            Paragraph fechaRecibo = new Paragraph();
            Chunk chunkFechas = new Chunk("Fecha: " + fechaActual(), fontFecha);
            fechaRecibo.add(chunkFechas);
            fechaRecibo.add(Chunk.NEWLINE); // Agrega una nueva línea entre "Fecha" y "Recibo Nro"
            Chunk chunkNroRecibo = new Chunk("RECIBO Nro: " + String.format("%05d", numeroRecibo), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL));
            fechaRecibo.add(chunkNroRecibo);
            fechaRecibo.setAlignment(Element.ALIGN_RIGHT);

            PdfPCell fechaReciboCell = new PdfPCell();
            fechaReciboCell.addElement(fechaRecibo);
            fechaReciboCell.setBorder(PdfPCell.NO_BORDER);
            tablaTitulos.addCell(fechaReciboCell);

            // LOGO
            InputStream logoStream = getClass().getClassLoader().getResourceAsStream("imagenes/ivacuit.jpg");
            Image logo = Image.getInstance(ImageIO.read(logoStream), null);
            logo.scaleToFit(530, 800);
            logo.setAlignment(Element.ALIGN_LEFT);

            // DOC NO VALIDO COMO FACTURA
            Paragraph subtitulo = new Paragraph("DOCUMENTO NO VALIDO COMO FACTURA", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL));
            subtitulo.setAlignment(Element.ALIGN_CENTER);
            subtitulo.setSpacingAfter(10f); // Espacio después del título (en puntos)

            //document.add(titulo);
            document.add(tablaTitulos);
            //document.add(fecha);
            //document.add(nroRecibo);
            document.add(logo);
            document.add(subtitulo);

            // Crear una tabla para los senores y domicilio         
            PdfPTable senoresdomicilio = new PdfPTable(2);
            senoresdomicilio.setWidthPercentage(100);

            // Ajustar los anchos de las columnas
            float[] colSenDom = {0.2f, 1f}; // Ancho relativo de las columnas (proporciones)
            senoresdomicilio.setWidths(colSenDom);

            // Columna "Señores"
            Phrase senoresLabel = new Phrase("SEÑORES: ", font);
            PdfPCell senoresLabelCell = new PdfPCell(new Paragraph(senoresLabel));
            senoresLabelCell.setBorder(Rectangle.BOX);
            senoresLabelCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            senoresLabelCell.setPaddingBottom(5f); // Espacio después de la celda
            senoresdomicilio.addCell(senoresLabelCell);

            // Contenido de la columna "Señores"
            Phrase senoresValue = new Phrase(txtCliente.getText().toUpperCase(), font);
            PdfPCell senoresValueCell = new PdfPCell(new Paragraph(senoresValue));
            senoresValueCell.setBorder(Rectangle.BOX);
            senoresValueCell.setPadding(5f);
            senoresValueCell.setPaddingBottom(5f); // Espacio después de la celda
            senoresdomicilio.addCell(senoresValueCell);

            // Columna "Domicilio"
            Phrase domicilioLabel = new Phrase("DOMICILIO: ", font);
            PdfPCell domicilioLabelCell = new PdfPCell(new Paragraph(domicilioLabel));
            domicilioLabelCell.setBorder(Rectangle.BOX);
            domicilioLabelCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            domicilioLabelCell.setPaddingBottom(5f); // Espacio después de la celda
            senoresdomicilio.addCell(domicilioLabelCell);

            // Contenido de la columna "Domicilio"
            Phrase domicilioValue = new Phrase(txtDomicilio.getText().toUpperCase(), font);
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
            Phrase texto = new Phrase("\nRECIBÍ DE EXPRESO LESTANI LA SUMA DE PESOS: " + txtRecibi.getText().toUpperCase(), font);
            Paragraph textoRecibi = new Paragraph(texto);
            textoRecibi.setAlignment(Element.ALIGN_LEFT);

            // Reducir el interlineado (leading) del párrafo textoRecibi
            textoRecibi.setLeading(0f, 0.8f); // Ajusta el segundo parámetro según el espacio deseado

            document.add(textoRecibi);

            // CONCEPTO DE
            Phrase textodos = new Phrase("\nEN CONCEPTO DE: " + txtConcepto.getText().toUpperCase(), font);
            Paragraph textoConcepto = new Paragraph(textodos);
            textoConcepto.setAlignment(Element.ALIGN_LEFT);

            // Reducir el interlineado (leading) del párrafo textoConcepto
            textoConcepto.setLeading(0f, 0.8f); // Ajusta el segundo parámetro según el espacio deseado

            document.add(textoConcepto);

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
                float[] columnWidths = {0.8f, 1f, 0.7f, 0.7f, 1f, 1f, 1f, 1f}; // Anchos de las columnas (proporciones)
                table.setWidths(columnWidths);
                table.setWidthPercentage(100); // Establecer ancho total de la tabla al 100%

                // Agregar las celdas de encabezado a la tabla, excluyendo las columnas suprimidas
                for (int i = 0; i < tablaMovimientos.getColumnCount(); i++) {
                    String col = tablaMovimientos.getColumnName(i);
                    if (!col.equals("ID") && !col.equals("HORA") && !col.equals("PAGADO") && !col.equals("REPRESENTANTE") && !col.equals("CLIENTE") && !col.equals("CC") && !col.equals("RENDIDO") && !col.equals("RENDIDO")) {
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
                        if (!colName.equals("ID") && !colName.equals("HORA") && !colName.equals("REPRESENTANTE") && !colName.equals("CLIENTE") && !colName.equals("PAGADO") && !colName.equals("CC") && !colName.equals("RENDIDO") && !colName.equals("RENDIDO")) {
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

            // Crear una tabla para los montos totales y firmasello
            PdfPTable totalFirmaTable = new PdfPTable(2);
            totalFirmaTable.setWidthPercentage(100);

            // Monto total
            Phrase montoTotalPhrase = new Phrase("TOTAL MONTO: $" + txtTotalMonto.getText(), fontTotales);
            PdfPCell montoTotalCell = new PdfPCell(montoTotalPhrase);
            montoTotalCell.setBorder(Rectangle.NO_BORDER);
            montoTotalCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            totalFirmaTable.addCell(montoTotalCell);

            // Agregar celda derecha para firmasello
            PdfPCell firmaSelloCell = new PdfPCell();
            firmaSelloCell.setBorder(Rectangle.NO_BORDER);
            firmaSelloCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            firmaSelloCell.setFixedHeight(150); // Ajusta la altura de acuerdo a tus necesidades

            // Crear tabla anidada para la imagen
            PdfPTable firmaSelloTable = new PdfPTable(1);
            firmaSelloTable.setWidthPercentage(100);

            // Agregar la imagen firmasello a la tabla anidada
            InputStream firmaselloStream = getClass().getClassLoader().getResourceAsStream("imagenes/firmasello.jpg");
            Image firmasello = Image.getInstance(ImageIO.read(firmaselloStream), null);
            firmasello.scaleToFit(150, 150);
            PdfPCell firmaSelloImageCell = new PdfPCell(firmasello);
            firmaSelloImageCell.setBorder(Rectangle.NO_BORDER);
            firmaSelloImageCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            firmaSelloTable.addCell(firmaSelloImageCell);

            // Agregar la tabla anidada a la celda derecha de la tabla principal
            firmaSelloCell.addElement(firmaSelloTable);

            // Agregar celda derecha a la tabla principal
            totalFirmaTable.addCell(firmaSelloCell);

            // Agregar la tabla totalFirmaTable al documento
            document.add(totalFirmaTable);

            document.close();
            txtReciboNro.setText(String.valueOf(numeroRecibo));
            guardarNumeroRecibo();

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

                JOptionPane.showMessageDialog(null, "El recibo se generó e imprimió correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (DocumentException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Impreso con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    private void calcularTotales() {
        int rowCount = tablaMovimientos.getRowCount();
        double sumaMontos = 0.0;
        double sumaFletes = 0.0;

        for (int fila = 0; fila < rowCount; fila++) {
            String montoStr = tablaMovimientos.getValueAt(fila, 7).toString().substring(1).replace(".", "").replace(",", ".");
            String fleteStr = tablaMovimientos.getValueAt(fila, 10).toString().substring(1).replace(".", "").replace(",", ".");

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
    private javax.swing.JButton btnQuitar;
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
    /*
    private JTable mostrarTablaMovimientos() {
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
        //carga de los datos desde la bd
        List<Movimientos> listaMovimientos = control.traerMovimientos();

        //recorrer lista y mostrar elementos en la tabla
        if (listaMovimientos != null) {
            for (Movimientos mov : listaMovimientos) {
                Object[] objeto = {mov.getId_movimientos(), mov.getHora(), mov.getFechaFormateada(), mov.getCliente(), mov.getDestino(), mov.getRemito(), mov.getBultos(), mov.getMonto(), mov.getTipoMontoP(), mov.getTipoMontoR(), mov.getFlete(), mov.getTipoFleteP(), mov.getTipoFleteR(), mov.getFleteDestinoOrigen(), mov.getRepresentante(), mov.getCuentaCorriente(), mov.getObservaciones()};

                tabla.addRow(objeto);

            }
        }
        tablaMovimientos.setModel(tabla);
        // Establecer el ancho específico de las columnas
        int[] anchos = {20, 80, 60, 60, 100, 100, 40, 40, 100, 40, 40, 100, 40, 40, 70, 100, 5, 200}; // Anchos deseados para cada columna en píxeles
        if (anchos.length == tabla.getColumnCount()) {
            TableColumnModel columnModel = tablaMovimientos.getColumnModel();
            for (int i = 0; i < anchos.length; i++) {
                TableColumn columna = columnModel.getColumn(i);
                columna.setPreferredWidth(anchos[i]);

                // Renderizador personalizado para centrar el contenido de las celdas
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setHorizontalAlignment(SwingConstants.CENTER);
                tablaMovimientos
                        .setDefaultRenderer(Object.class,
                                renderer);

                // Renderizador personalizado para centrar el título de las columnas
                DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tablaMovimientos.getTableHeader().getDefaultRenderer();
                headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            }
        }
        tablaMovimientos.getModel();
        JTable tab = new JTable(tabla);
        return tab;
    }
     */
    //FECHA ACTUAL
    public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
    }

}
