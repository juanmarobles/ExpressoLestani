package com.mycompany.lestanitest.igu;

import java.awt.print.PrinterException;
//import com.google.protobuf.TextFormat.Printer;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
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
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import static com.mycompany.lestanitest.igu.Recibos.fechaActual;
import com.mycompany.lestanitest.logica.Cliente;
import com.mycompany.lestanitest.logica.Controladora;
import com.mycompany.lestanitest.logica.Destinos;
import com.mycompany.lestanitest.logica.ModeloCliente;
import com.mycompany.lestanitest.logica.ModeloDestinos;
import com.mycompany.lestanitest.logica.ModeloRepresentante;
import com.mycompany.lestanitest.logica.ModeloServicio;
import com.mycompany.lestanitest.logica.Movimientos;
import com.mycompany.lestanitest.logica.Representantes;
import com.mycompany.lestanitest.logica.Servicios;
import com.mycompany.lestanitest.logica.TextPrompt;
import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.TableColumn;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.SimpleBookmark;
import com.mycompany.lestanitest.logica.GenerarPDFDuplicado;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.TextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.awt.print.Pageable;
import java.awt.print.Paper;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Time;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.DateTimeException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Principal extends javax.swing.JFrame {

    Controladora control = new Controladora();
    TableRowSorter trs;
    DefaultTableModel dtm = new DefaultTableModel();
    private Cliente clienteSeleccionado;
    private Cliente destinatarioSeleccionado;
    private Movimientos movimientoSeleccionado;
    private Servicios servicioSeleccionado;
    int numeroRemito = 0;

    public Principal() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setTitle("Expreso Lestani S.R.L - [Panel Principal]");
        //Cargar Combobox
        cargarClientes();
        cargarDestinos();
        cargarRepresentantes();
        cargarServicios();

        actualizarFlete();

        txtBulto.setText("1");
        txtMonto.setText("0");
        txtFlete.setText("0");
        txtSeguro.setText("0");
        txtContrarembolso.setText("0");
        txtRedespacho.setText("0");
        txtValDeclarado.setText("0");

        //FECHA
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Mostrar la fecha actual en los campos de texto correspondientes
        txtDia.setText(String.valueOf(fechaActual.getDayOfMonth()));
        txtMes.setText(String.valueOf(fechaActual.getMonthValue()));
        txtAnio.setText(String.valueOf(fechaActual.getYear()));

        // Obtener los valores de los campos de texto
        int dia = Integer.parseInt(txtDia.getText());
        int mes = Integer.parseInt(txtMes.getText());
        int anio = Integer.parseInt(txtAnio.getText());

        try {
            // Crear una instancia de LocalDate si la fecha es válida
            LocalDate fechaArmada = LocalDate.of(anio, mes, dia);

            // Formatear la fecha en el formato deseado
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaFormateada = fechaArmada.format(formatter);

            // Realizar otras operaciones con fechaArmada aquí
            System.out.println("Fecha  válida: " + fechaFormateada);

        } catch (DateTimeException e) {
            // Manejar el caso en que la fecha no sea válida
            System.out.println("Fecha inválida.");
        }

        TextPrompt filtroCl = new TextPrompt("Busqueda por cliente", txtFiltroCliente);
        TextPrompt filtroRe = new TextPrompt("Busqueda por remito", txtFiltroRemito);

        // Tabulador cambiar Default
        // Establecer el siguiente componente enfocable para el campo de texto del JComboBox
        txtAnio.setNextFocusableComponent(cbClientes);
        JTextField textCliente = (JTextField) cbClientes.getEditor().getEditorComponent();
        textCliente.setNextFocusableComponent(cbDestinos);
        JTextField textDestinos = (JTextField) cbDestinos.getEditor().getEditorComponent();
        textDestinos.setNextFocusableComponent(cbServicios);
        JTextField textServicios = (JTextField) cbServicios.getEditor().getEditorComponent();
        textServicios.setNextFocusableComponent(txtRemito);

        txtRemito.setNextFocusableComponent(txtBulto);
        txtBulto.setNextFocusableComponent(cbfOrigen);
        cbfOrigen.setNextFocusableComponent(cbfDestino);
        cbfDestino.setNextFocusableComponent(cbCuentaCorriente);
        txtMonto.setNextFocusableComponent(cbmontoPagado);
        cbmontoPagado.setNextFocusableComponent(cbMontoRendido);
        cbfleteRendido.setNextFocusableComponent(cbRepresentantes);

        JTextField textRepre = (JTextField) cbRepresentantes.getEditor().getEditorComponent();
        textRepre.setNextFocusableComponent(txtObservaciones);

        cbCuentaCorriente.setNextFocusableComponent(txtMonto);
        txtObservaciones.setNextFocusableComponent(btnAgregar);
        btnAgregar.setNextFocusableComponent(btnEditarMovimiento);
        btnEditarMovimiento.setNextFocusableComponent(btnEliminarMovimiento);
        btnEliminarMovimiento.setNextFocusableComponent(btnGenerarRemito);
        btnGenerarRemito.setNextFocusableComponent(btnGenerarRemitoDuplicado);
        btnGenerarRemitoDuplicado.setNextFocusableComponent(txtDia);

        //Borde al seleccionar TEXFIELD
        SwingUtilities.invokeLater(() -> {
            // Define el borde de enfoque
            Border normalBorder = txtRemito.getBorder();
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
            txtRemito.addFocusListener(focusAdapter);
            txtBulto.addFocusListener(focusAdapter);
            txtObservaciones.addFocusListener(focusAdapter);
            txtMonto.addFocusListener(focusAdapter);
            txtFlete.addFocusListener(focusAdapter);
        });
        //CHECKBOX
        SwingUtilities.invokeLater(() -> {

            // Cambia la apariencia del checkbox cuando obtiene el enfoque
            FocusAdapter focusAdapter = new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    JCheckBox checkBox = (JCheckBox) e.getComponent();
                    checkBox.setBorderPainted(true);
                    checkBox.setForeground(Color.BLUE);
                }

                @Override
                public void focusLost(FocusEvent e) {
                    JCheckBox checkBox = (JCheckBox) e.getComponent();
                    checkBox.setBorderPainted(false);
                    checkBox.setForeground(Color.WHITE);
                }
            };

            cbCuentaCorriente.addFocusListener(focusAdapter);
            cbfOrigen.addFocusListener(focusAdapter);
            cbfDestino.addFocusListener(focusAdapter);
            cbmontoPagado.addFocusListener(focusAdapter);
            cbMontoRendido.addFocusListener(focusAdapter);
            cbfletePagado.addFocusListener(focusAdapter);
            cbfleteRendido.addFocusListener(focusAdapter);

        });

        //Combobox
       
       ComboBoxStyle(cbClientes);
       ComboBoxStyle(cbDestinos);
       ComboBoxStyle(cbServicios);
       ComboBoxStyle(cbRepresentantes);


        
        

        
        //Botones
        SwingUtilities.invokeLater(() -> {
            // Define la apariencia normal
            Color normalFont = btnAgregar.getForeground();
            Color normalBackgroundColor = btnAgregar.getBackground();
            Border normalBorder = btnAgregar.getBorder();

            // Define la apariencia de enfoque
            Color focusBackgroundColor = Color.LIGHT_GRAY;
            Border focusBorder = new LineBorder(Color.BLUE, 3);

            FocusAdapter focusAdapter = new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    JButton button = (JButton) e.getComponent();
                    button.setBackground(focusBackgroundColor);
                    button.setBorder(focusBorder);
                    button.setForeground(Color.black);
                }

                @Override
                public void focusLost(FocusEvent e) {
                    JButton button = (JButton) e.getComponent();
                    button.setBackground(normalBackgroundColor);
                    button.setBorder(normalBorder);
                    button.setForeground(normalFont);
                }
            };

            btnAgregar.addFocusListener(focusAdapter);
            btnEditarMovimiento.addFocusListener(focusAdapter);
            btnEliminarMovimiento.addFocusListener(focusAdapter);
            btnGenerarRemito.addFocusListener(focusAdapter);
            btnGenerarRemitoDuplicado.addFocusListener(focusAdapter);
        });

        // Listener al mause para editar con doble click el movimiento.
        tablaMovimientos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    // Acción a realizar cuando se haga doble clic en un elemento de la tabla
                    int filaSeleccionada = tablaMovimientos.getSelectedRow();
                    int id = (int) tablaMovimientos.getValueAt(filaSeleccionada, 0);
                    // Realizar la acción deseada con el ID obtenido
                    System.out.println("ID seleccionado: " + id);
                    EditarMovimientos editar = new EditarMovimientos(id);
                    editar.setVisible(true);
                    editar.setLocationRelativeTo(null);

                }
            }
        });

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

        txtMonto.addKeyListener(keyListener);
        txtFlete.addKeyListener(keyListener);

        // Obtén la fecha y hora actual
        LocalDateTime now = LocalDateTime.now();

        // Comprueba si es después de las 17:00 horas
        if (now.getHour() >= 17) {
            // Añade un día a la fecha actual
            LocalDate tomorrow = now.toLocalDate().plusDays(1);

            // Formatea la fecha en el formato deseado (por ejemplo, "dd/MM/yyyy")
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = tomorrow.format(formatter);

            // Asigna los componentes de la fecha a los campos de texto
            txtDia.setText(String.valueOf(tomorrow.getDayOfMonth()));
            txtMes.setText(String.valueOf(tomorrow.getMonthValue()));
            txtAnio.setText(String.valueOf(tomorrow.getYear()));

            System.out.println("Fecha cambiada a: " + formattedDate);
        }

        cargarNumeroRemito();

        // Agregar un ActionListener al combobox cbServicios
        cbServicios.addActionListener(e -> {
            actualizarFlete();
        });

// Agregar un listener al campo txtServicio
        cbServicios.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                actualizarFlete();
            }
        });

        // Agregar un listener al campo txtBulto
        txtBulto.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarFlete();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarFlete();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarFlete();
            }
        });

    }
    
    
     private static void ComboBoxStyle(JComboBox<String> comboBox) {
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    
                    comboBox.getEditor().selectAll();
                }
            }
        });     
    }
    
   
    

    
   

    //Actualizar flete nuevo
    private void actualizarFlete() {
        String bultoText = txtBulto.getText().trim();
        if (!bultoText.isEmpty()) {
            int bulto = Integer.parseInt(bultoText);

            // Cargar los datos desde la base de datos
            List<Servicios> listaServicios = control.traerServicios();

            // Buscar el servicio correspondiente en la lista
            Object selectedItem = cbServicios.getSelectedItem();
            if (selectedItem != null) {
                String nombreServicio = selectedItem.toString().trim().toLowerCase();

                for (Servicios s : listaServicios) {
                    if (s.getServicio().toLowerCase().equals(nombreServicio)) {
                        // Calcular el flete multiplicando el precio del servicio por la cantidad de bultos
                        BigDecimal precio = BigDecimal.valueOf(s.getPrecio());
                        BigDecimal montoFlete = precio.multiply(BigDecimal.valueOf(bulto));

                        // Mostrar el archivo en el campo txtFlete
                        txtFlete.setText(montoFlete.toString());

                        return;
                    }
                }
            } else {
                // Handle the case where no item is selected
                // Maybe display an error message or set a default value for txtFlete
                // For example, if txtFlete is a JTextField, you could set it to an empty string:
                // txtFlete.setText("");
            }
        }
    }

    ModeloCliente modClientes = new ModeloCliente();
    ArrayList<Cliente> listaClientes = modClientes.getClientes();

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

        // Si no se encontró ninguna coincidencia parcial, mantener el texto de búsqueda tal como lo ingresó el usuario
        if (!encontradoParcial) {
            combobox.getEditor().setItem(textoBusqueda);
            combobox.setPopupVisible(true);
        }
    }
}

    private void cargarDestinos() {
        cbDestinos.setEditable(true);

        // Ordenar la lista de clientes alfabéticamente por el nombre
        listaClientes.sort((cliente1, cliente2) -> cliente1.getNombre().compareToIgnoreCase(cliente2.getNombre()));

        // Agregar los clientes al combobox
        for (Cliente cliente : listaClientes) {
            cbDestinos.addItem(cliente.getNombre());
        }

        // Eliminar la opción en blanco después de configurar el decorador
        cbDestinos.removeItem("");

        // Establecer el índice seleccionado a -1 para no mostrar ninguna selección
        cbDestinos.setSelectedIndex(-1);

        cbDestinos.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_TAB) {
                    String textoBusqueda = cbDestinos.getEditor().getItem().toString();
                    mostrarResultadosBusqueda(cbDestinos, textoBusqueda);

                    // Normaliza el texto de búsqueda a mayúsculas
                    textoBusqueda = textoBusqueda.toUpperCase();

                    // Busca el cliente seleccionado en la lista de clientes
                    destinatarioSeleccionado = null; // Restablece el destinatario seleccionado

                    for (Cliente cliente : listaClientes) {
                        // Normaliza el nombre del cliente a mayúsculas y elimina caracteres no deseados
                        String nombreCliente = cliente.getNombre().toUpperCase().replaceAll("[^A-Z]", "");

                        if (nombreCliente.contains(textoBusqueda)) {
                            destinatarioSeleccionado = cliente;
                            System.out.println("Cliente seleccionado: " + destinatarioSeleccionado);
                            break;
                        }
                    }

                    // Si no se encontró un cliente, destinatarioSeleccionado se mantiene en null
                    if (destinatarioSeleccionado == null) {
                        System.out.println("No se encontró un cliente correspondiente.");
                    }
                }
            }
        });
    }
   
    private void cargarServicios() {
        ModeloServicio modServ = new ModeloServicio();
        ArrayList<Servicios> listaServ = modServ.getServicios();
        cbServicios.setEditable(true);

        // Agregar los clientes al combobox
        for (Servicios Servicios : listaServ) {
            cbServicios.addItem(Servicios.getServicio());
        }   
        
         // Ordenar la lista de clientes alfabéticamente por el nombre
        listaServ.sort((servicio1, servicio2) -> servicio1.getServicio().compareToIgnoreCase(servicio2.getServicio()));

        // Eliminar la opción en blanco después de configurar el decorador
        cbServicios.removeItem("");
        
       

        // Establecer el índice seleccionado a -1 para no mostrar ninguna selección
        cbServicios.setSelectedIndex(-1);

        // Agregar ActionListener para capturar el evento "Enter"
        cbServicios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoBusqueda = cbServicios.getEditor().getItem().toString();
                mostrarResultadosBusqueda(cbServicios, textoBusqueda);
            }
        });

        // Agregar KeyListener para capturar el evento "Enter"
        cbServicios.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String textoBusqueda = cbServicios.getEditor().getItem().toString();
                    mostrarResultadosBusqueda(cbServicios, textoBusqueda);
                }
            }
        });
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
        
        // Ordenar la lista de clientes alfabéticamente por el nombre
        listaRepresentantes.sort((representante1, representante2) -> representante1.getNombre().compareToIgnoreCase(representante2.getNombre()));

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

    private void cargarClientes() {
        cbClientes.setEditable(true);

        // Carga de los datos desde la base de datos
        List<Cliente> listaClientes = control.traerClientes();

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

        // Agregar ActionListener para capturar el evento "Enter"
        cbClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoBusqueda = cbClientes.getEditor().getItem().toString();
                mostrarResultadosBusqueda(cbClientes, textoBusqueda);
                if (cbClientes.getSelectedIndex() != -1) {
                 // Normaliza el texto de búsqueda a mayúsculas
                textoBusqueda = textoBusqueda.toUpperCase();

                     clienteSeleccionado = null; // Restablece el destinatario seleccionado
                for (Cliente cliente : listaClientes) {
                    if (cliente.getNombre().toUpperCase().equals(textoBusqueda)) {
                        clienteSeleccionado = cliente;
                        
                        break;
                    }
                }
                }
            }
        });

        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMovimientos = new javax.swing.JTable();
        panelCargaMovimientos = new javax.swing.JPanel();
        bulto = new javax.swing.JLabel();
        cbCuentaCorriente = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnEliminarMovimiento = new javax.swing.JButton();
        btnEditarMovimiento = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnAgregarCliente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        cbfDestino = new javax.swing.JCheckBox();
        cbfOrigen = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtFlete = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cbfletePagado = new javax.swing.JCheckBox();
        cbfleteRendido = new javax.swing.JCheckBox();
        btnGenerarRemito = new javax.swing.JButton();
        btnGenerarRemitoDuplicado = new javax.swing.JButton();
        cbClientes = new javax.swing.JComboBox<>();
        cbDestinos = new javax.swing.JComboBox<>();
        cbServicios = new javax.swing.JComboBox<>();
        txtObservaciones = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMes = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtRemito = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtSeguro = new javax.swing.JTextField();
        txtContrarembolso = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBulto = new javax.swing.JTextField();
        txtValDeclarado = new javax.swing.JTextField();
        txtRedespacho = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cbmontoPagado = new javax.swing.JCheckBox();
        cbMontoRendido = new javax.swing.JCheckBox();
        cbRepresentantes = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        PanelBusquedas = new javax.swing.JPanel();
        txtFiltroCliente = new javax.swing.JTextField();
        txtFiltroRemito = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Expreso Lestani S.R.L - Cargar Movimientos");
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(66, 66, 66));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));

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
        jScrollPane2.setViewportView(tablaMovimientos);

        panelCargaMovimientos.setBackground(new java.awt.Color(66, 66, 66));
        panelCargaMovimientos.setForeground(new java.awt.Color(255, 255, 255));

        bulto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bulto.setForeground(new java.awt.Color(236, 240, 241));
        bulto.setText("Servicios");

        cbCuentaCorriente.setBackground(new java.awt.Color(66, 66, 66));
        cbCuentaCorriente.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        cbCuentaCorriente.setForeground(new java.awt.Color(236, 240, 241));
        cbCuentaCorriente.setText("Cuenta Corriente");
        cbCuentaCorriente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCuentaCorrienteActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(236, 240, 241));
        jLabel10.setText("Destino");

        btnAgregar.setBackground(new java.awt.Color(51, 51, 51));
        btnAgregar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(236, 240, 241));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/agregar_32px.png"))); // NOI18N
        btnAgregar.setText("Cargar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminarMovimiento.setBackground(new java.awt.Color(51, 51, 51));
        btnEliminarMovimiento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEliminarMovimiento.setForeground(new java.awt.Color(236, 240, 241));
        btnEliminarMovimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/borrar_32px.png"))); // NOI18N
        btnEliminarMovimiento.setText("Eliminiar");
        btnEliminarMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMovimientoActionPerformed(evt);
            }
        });

        btnEditarMovimiento.setBackground(new java.awt.Color(51, 51, 51));
        btnEditarMovimiento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEditarMovimiento.setForeground(new java.awt.Color(236, 240, 241));
        btnEditarMovimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/editar_32px.png"))); // NOI18N
        btnEditarMovimiento.setText("Editar");
        btnEditarMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarMovimientoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(236, 240, 241));
        jLabel13.setText("Cliente");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(236, 240, 241));
        jLabel14.setText("Observaciones");

        btnAgregarCliente.setBackground(new java.awt.Color(51, 51, 51));
        btnAgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/agregar-usuario.png"))); // NOI18N
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(66, 66, 66));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        jLabel17.setBackground(new java.awt.Color(66, 66, 66));
        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(236, 240, 241));
        jLabel17.setText("Flete a Cargo");

        cbfDestino.setBackground(new java.awt.Color(66, 66, 66));
        cbfDestino.setForeground(new java.awt.Color(236, 240, 241));
        cbfDestino.setText("Destino");
        cbfDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbfDestinoActionPerformed(evt);
            }
        });

        cbfOrigen.setBackground(new java.awt.Color(66, 66, 66));
        cbfOrigen.setForeground(new java.awt.Color(236, 240, 241));
        cbfOrigen.setText("Origen");
        cbfOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbfOrigenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbfOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(cbfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbfDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(cbfOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        jPanel4.setBackground(new java.awt.Color(66, 66, 66));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(236, 240, 241));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/camion_24px.png"))); // NOI18N
        jLabel6.setText("Flete");

        txtFlete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFleteActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(236, 240, 241));
        jLabel16.setText("$");

        cbfletePagado.setBackground(new java.awt.Color(66, 66, 66));
        cbfletePagado.setForeground(new java.awt.Color(236, 240, 241));
        cbfletePagado.setText("Pagado");

        cbfleteRendido.setBackground(new java.awt.Color(66, 66, 66));
        cbfleteRendido.setForeground(new java.awt.Color(236, 240, 241));
        cbfleteRendido.setText("Rendido");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFlete, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(cbfletePagado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbfleteRendido, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFlete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbfleteRendido, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbfletePagado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        btnGenerarRemito.setBackground(new java.awt.Color(51, 51, 51));
        btnGenerarRemito.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGenerarRemito.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarRemito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/imprimir_16px.png"))); // NOI18N
        btnGenerarRemito.setText("Agregar + Remito");
        btnGenerarRemito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarRemitoActionPerformed(evt);
            }
        });

        btnGenerarRemitoDuplicado.setBackground(new java.awt.Color(51, 51, 51));
        btnGenerarRemitoDuplicado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGenerarRemitoDuplicado.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarRemitoDuplicado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/imprimir_16px.png"))); // NOI18N
        btnGenerarRemitoDuplicado.setText("Agregar + Remito x2");
        btnGenerarRemitoDuplicado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarRemitoDuplicadoActionPerformed(evt);
            }
        });

        cbClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClientesActionPerformed(evt);
            }
        });

        cbServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbServiciosActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(66, 66, 66));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(236, 240, 241));
        jLabel9.setText("Fecha:");

        txtDia.setMinimumSize(new java.awt.Dimension(15, 25));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("/");

        txtMes.setMinimumSize(new java.awt.Dimension(15, 25));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("/");

        txtAnio.setMinimumSize(new java.awt.Dimension(15, 25));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAnio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDia, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addComponent(txtMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(66, 66, 66));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(236, 240, 241));
        jLabel12.setText("Remito N°");

        txtRemito.setText("0");
        txtRemito.setMargin(new java.awt.Insets(1, 0, 0, 0));
        txtRemito.setPreferredSize(new java.awt.Dimension(22, 25));
        txtRemito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRemitoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Seguro");

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("$");

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("<html>    Com.<br>Contrarembolso");

        txtSeguro.setPreferredSize(new java.awt.Dimension(15, 25));

        jLabel21.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("$");

        jLabel22.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Redespacho");

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("<html>Valor <br> Declarado</html>");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(236, 240, 241));
        jLabel7.setText("Bulto");

        txtBulto.setMargin(new java.awt.Insets(1, 0, 0, 0));
        txtBulto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBultoActionPerformed(evt);
            }
        });

        txtValDeclarado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValDeclaradoActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("$");

        jLabel25.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("$");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel22))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtRemito, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBulto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtContrarembolso, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel24)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRedespacho, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtValDeclarado, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)))
                .addGap(12, 12, 12))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRedespacho, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(jLabel18)
                        .addComponent(txtRemito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(jLabel24)
                        .addComponent(txtContrarembolso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtBulto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValDeclarado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(66, 66, 66));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(236, 240, 241));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dinero_24px.png"))); // NOI18N
        jLabel5.setText("Monto");

        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(236, 240, 241));
        jLabel15.setText("$");

        cbmontoPagado.setBackground(new java.awt.Color(66, 66, 66));
        cbmontoPagado.setForeground(new java.awt.Color(236, 240, 241));
        cbmontoPagado.setText("Pagado");

        cbMontoRendido.setBackground(new java.awt.Color(66, 66, 66));
        cbMontoRendido.setForeground(new java.awt.Color(236, 240, 241));
        cbMontoRendido.setText("Rendido");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cbmontoPagado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbMontoRendido, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMontoRendido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbmontoPagado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(236, 240, 241));
        jLabel8.setText("Representante");

        javax.swing.GroupLayout panelCargaMovimientosLayout = new javax.swing.GroupLayout(panelCargaMovimientos);
        panelCargaMovimientos.setLayout(panelCargaMovimientosLayout);
        panelCargaMovimientosLayout.setHorizontalGroup(
            panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(291, 291, 291)
                        .addComponent(cbCuentaCorriente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bulto)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbClientes, javax.swing.GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE)
                                    .addComponent(cbDestinos, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbServicios, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAgregarCliente)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbRepresentantes, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(50, 50, 50)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnGenerarRemito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addComponent(btnEliminarMovimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditarMovimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnGenerarRemitoDuplicado, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        panelCargaMovimientosLayout.setVerticalGroup(
            panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addComponent(cbCuentaCorriente, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbRepresentantes, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addComponent(btnEditarMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminarMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGenerarRemito, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGenerarRemitoDuplicado, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbDestinos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bulto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        PanelBusquedas.setBackground(new java.awt.Color(66, 66, 66));

        txtFiltroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroClienteActionPerformed(evt);
            }
        });
        txtFiltroCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltroClienteKeyTyped(evt);
            }
        });

        txtFiltroRemito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroRemitoActionPerformed(evt);
            }
        });
        txtFiltroRemito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltroRemitoKeyTyped(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/busqueda-de-lupa.png"))); // NOI18N

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/busqueda-de-lupa.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Busquedas");

        javax.swing.GroupLayout PanelBusquedasLayout = new javax.swing.GroupLayout(PanelBusquedas);
        PanelBusquedas.setLayout(PanelBusquedasLayout);
        PanelBusquedasLayout.setHorizontalGroup(
            PanelBusquedasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedasLayout.createSequentialGroup()
                .addGroup(PanelBusquedasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBusquedasLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(PanelBusquedasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelBusquedasLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFiltroRemito))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelBusquedasLayout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFiltroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelBusquedasLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        PanelBusquedasLayout.setVerticalGroup(
            PanelBusquedasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedasLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(PanelBusquedasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFiltroCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(PanelBusquedasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltroRemito, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(236, 240, 241));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/actualizar.png"))); // NOI18N
        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelCargaMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelBusquedas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(688, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelCargaMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelBusquedas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 2160, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFiltroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroClienteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        mostrarTablaMovimientos();
    }//GEN-LAST:event_formWindowOpened
    private void mostrarTablaMovimientos() {
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
        // Ordenar los datos por el ID en forma descendente
        Collections.sort(listaMovimientos, Comparator.comparingInt(Movimientos::getId_movimientos).reversed());

        //recorrer lista y mostrar elementos en la tabla
        if (listaMovimientos != null) {
            for (Movimientos mov : listaMovimientos) {
                Object[] objeto = {mov.getId_movimientos(), mov.getHora(), mov.getFechaFormateada(), mov.getCliente(), mov.getDestino(), mov.getRemito(), mov.getBultos(), mov.getMonto(), mov.getTipoMontoP(), mov.getTipoMontoR(), mov.getFlete(), mov.getTipoFleteP(), mov.getTipoFleteR(), mov.getFleteDestinoOrigen(), mov.getRepresentante(), mov.getCuentaCorriente(), mov.getObservaciones()};

                tabla.addRow(objeto);

            }
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
                columna.setCellRenderer(renderer);
                // Renderizador personalizado para centrar el título de las columnas
                DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tablaMovimientos.getTableHeader().getDefaultRenderer();
                headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            }
        }
    }


    private void txtFiltroClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroClienteKeyTyped

        txtFiltroCliente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtFiltroCliente.getText(), 3));
            }

        });
        trs = new TableRowSorter(tablaMovimientos.getModel());
        tablaMovimientos.setRowSorter(trs);
    }//GEN-LAST:event_txtFiltroClienteKeyTyped
    public void mostrarMensaje(String mensaje, String tipo, String titulo) {
        JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equals("Info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);

        } else if (tipo.equals("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }


    private void txtFiltroRemitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroRemitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroRemitoActionPerformed

    private void txtFiltroRemitoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroRemitoKeyTyped
        txtFiltroRemito.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtFiltroRemito.getText(), 5));
            }

        });
        trs = new TableRowSorter(tablaMovimientos.getModel());
        tablaMovimientos.setRowSorter(trs);
    }//GEN-LAST:event_txtFiltroRemitoKeyTyped

    private void txtRemitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRemitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRemitoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        String fPagado = "";
        String fRendido = "";
        String tFlete = "";
        String tMontoP = "";
        String tMontoR = "";
        String tFleteP = "";
        String tFleteR = "";
        String cC = "";
        String remito;
        //FECHA
        Date fecha = getFecha();
        //HORA
        LocalTime horaActual = LocalTime.now().withSecond(0);
        Time horaSQL = Time.valueOf(horaActual);
        //Verifica dato del Combobox
        String cliente = (cbClientes.getSelectedItem() != null) ? cbClientes.getSelectedItem().toString() : "";
        String destino = (cbDestinos.getSelectedItem() != null) ? cbDestinos.getSelectedItem().toString() : "";
        String servicio = (cbServicios.getSelectedItem() != null) ? cbServicios.getSelectedItem().toString() : "";
        String representante = (cbRepresentantes.getSelectedItem() != null) ? cbRepresentantes.getSelectedItem().toString() : "";
       

        int bulto = Integer.parseInt(txtBulto.getText());
        //txt monto
        String txtMontoValor = txtMonto.getText();
        String monto;
        //remito
        remito = txtRemito.getText();

        // Si hay campos faltantes, mostrar el mensaje de alerta
        if (!txtMontoValor.isEmpty()) {
            monto = txtMontoValor;
        } else {
            monto = "0";
        }
        String flete = txtFlete.getText();
        String obs = txtObservaciones.getText();
        //verif flete origen/destino
        if (cbfDestino.isSelected()) {
            tFlete = "Destino";
            cbfOrigen.setSelected(false);

        }
        if (cbfOrigen.isSelected()) {
            tFlete = "Origen";
            cbfDestino.setSelected(false);
        }

        //verif Cuenta Corriente
        if (cbCuentaCorriente.isSelected()) {
            cC = "Si";
        } else {
            cC = "No";
        }

        //verif de monto pagado/rendido
        if (cbmontoPagado.isSelected() && cbMontoRendido.isSelected()) {
            tMontoP = "Si";
            tMontoR = "Si";
        } else if (cbmontoPagado.isSelected()) {
            tMontoP = "Si";
            tMontoR = "No";
        } else if (cbMontoRendido.isSelected()) {
            tMontoR = "Si";
            tMontoP = "No";
        } else {
            tMontoR = "No";
            tMontoP = "No";
        }
        //verif de flete pagado/rendido
        if (cbfletePagado.isSelected() && cbfleteRendido.isSelected()) {
            tFleteP = "Si";
            tFleteR = "Si";
        } else if (cbfleteRendido.isSelected()) {
            tFleteR = "Si";
            tFleteP = "No";
        } else if (cbfletePagado.isSelected()) {
            tFleteR = "No";
            tFleteP = "Si";
        } else {
            tFleteR = "No";
            tFleteP = "No";
        }
        // Verificar campos vacíos y almacenar los nombres de los campos vacíos en una lista
        List<String> camposFaltantes = new ArrayList<>();
        if (cbClientes.getSelectedItem() == null || cbClientes.getSelectedItem().toString().isEmpty()) {
            camposFaltantes.add("Cliente");
        }
        if (cbDestinos.getSelectedItem() == null || cbDestinos.getSelectedItem().toString().isEmpty()) {
            camposFaltantes.add("Destino");
        }
        if (cbServicios.getSelectedItem() == null || cbServicios.getSelectedItem().toString().isEmpty()) {
            camposFaltantes.add("Servicio");
        }
        if (cbRepresentantes.getSelectedItem() == null || cbRepresentantes.getSelectedItem().toString().isEmpty()) {
            camposFaltantes.add("Representante");
        }
        if (txtBulto.getText().isEmpty()) {
            camposFaltantes.add("Bulto");
        }
        if (txtFlete.getText().isEmpty()) {
            camposFaltantes.add("Flete");
        }
        if (remito.isEmpty()) {
            camposFaltantes.add("Remito");
        }

        if (!camposFaltantes.isEmpty()) {
            String mensaje = "Por favor, complete los siguientes campos obligatorios:\n";
            for (String campo : camposFaltantes) {
                mensaje += "- " + campo + "\n";
            }

            mostrarMensaje(mensaje, "Error", "Campos faltantes");
            return; // Detener la ejecución para no agregar el movimiento
        }

        control.cargarMovimiento(cliente, destino, servicio, representante, bulto, monto, flete, tFlete, remito, tMontoP, tMontoR, tFleteP, tFleteR, fecha, cC, obs, horaSQL);
        System.out.println("Movimiento agregado correctamente"+ "Info"+ "Agregado con exito!");

        // Actualizar la tabla
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaMovimientos.getModel();
        modeloTabla.setRowCount(0);
        List<Movimientos> movimientos = control.traerMovimientos();
        // Ordenar los datos por el ID en forma descendente
        Collections.sort(movimientos, Comparator.comparingInt(Movimientos::getId_movimientos).reversed());
        for (Movimientos mov : movimientos) {
            Object[] objeto = {mov.getId_movimientos(), mov.getHora(), mov.getFechaFormateada(), mov.getCliente(), mov.getDestino(), mov.getRemito(), mov.getBultos(), mov.getMonto(), mov.getTipoMontoP(), mov.getTipoMontoR(), mov.getFlete(), mov.getTipoFleteP(), mov.getTipoFleteR(), mov.getFleteDestinoOrigen(), mov.getRepresentante(), mov.getCuentaCorriente(), mov.getObservaciones()};

            modeloTabla.addRow(objeto);
        }

        //Limpiar Combobox
        // Remover los ActionListeners y KeyListeners de cbRepresentantes
        ActionListener[] repActionListeners = cbRepresentantes.getActionListeners();
        KeyListener[] repKeyListeners = cbRepresentantes.getEditor().getEditorComponent().getKeyListeners();

        for (ActionListener listener : repActionListeners) {
            cbRepresentantes.removeActionListener(listener);
        }

        for (KeyListener listener : repKeyListeners) {
            cbRepresentantes.getEditor().getEditorComponent().removeKeyListener(listener);
        }

        // Remover los ActionListeners y KeyListeners de cbDestinos
        ActionListener[] destActionListeners = cbDestinos.getActionListeners();
        KeyListener[] destKeyListeners = cbDestinos.getEditor().getEditorComponent().getKeyListeners();

        for (ActionListener listener : destActionListeners) {
            cbDestinos.removeActionListener(listener);
        }

        for (KeyListener listener : destKeyListeners) {
            cbDestinos.getEditor().getEditorComponent().removeKeyListener(listener);
        }

        cbRepresentantes.setSelectedIndex(-1); // Deselecciona cualquier elemento en el combo box
        cbDestinos.setSelectedIndex(-1); // Deselecciona cualquier elemento en cbDestinos

        // Volver a agregar los ActionListeners y KeyListeners a cbRepresentantes
        for (ActionListener listener : repActionListeners) {
            cbRepresentantes.addActionListener(listener);
        }

        for (KeyListener listener : repKeyListeners) {
            cbRepresentantes.getEditor().getEditorComponent().addKeyListener(listener);
        }

        // Volver a agregar los ActionListeners y KeyListeners a cbDestinos
        for (ActionListener listener : destActionListeners) {
            cbDestinos.addActionListener(listener);
        }

        for (KeyListener listener : destKeyListeners) {
            cbDestinos.getEditor().getEditorComponent().addKeyListener(listener);
        }

        //Limpiar datos
        txtRemito.setText("0");
        txtBulto.setText("1");
        cbCuentaCorriente.setSelected(false); // Desmarca la casilla de verificación
        txtMonto.setText("0");
        cbmontoPagado.setSelected(false);
        cbMontoRendido.setSelected(false);
        cbfletePagado.setSelected(false);
        cbfleteRendido.setSelected(false);
        txtObservaciones.setText("");
        txtSeguro.setText("0");
        txtContrarembolso.setText("0");
        txtRedespacho.setText("0");
        txtValDeclarado.setText("0");


    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed

    }//GEN-LAST:event_txtMontoActionPerformed

    private void txtBultoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBultoActionPerformed

    }//GEN-LAST:event_txtBultoActionPerformed

    private void btnEliminarMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMovimientoActionPerformed
       // Control para verificar que la tabla no esté vacía
if (tablaMovimientos.getRowCount() > 0) {
    // Validar que se hayan seleccionado registros
    int[] selectedRows = tablaMovimientos.getSelectedRows();
    if (selectedRows.length > 0) {
        int confirmResult = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas borrar los registros seleccionados?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
        if (confirmResult == JOptionPane.YES_OPTION) {
            for (int selectedRow : selectedRows) {
                int idMovimiento = Integer.parseInt(String.valueOf(tablaMovimientos.getValueAt(selectedRow, 0)));
                control.borrarMovimiento(idMovimiento);
            }
            mostrarMensaje("Movimientos borrados correctamente", "Info", "Borrados con éxito");
            mostrarTablaMovimientos();
        }
    } else {
        mostrarMensaje("No seleccionaste registros para eliminar", "Error", "Error al eliminar");
    }
} else {
    mostrarMensaje("La tabla está vacía, no se puede eliminar", "Error", "Error al eliminar");
}
    }//GEN-LAST:event_btnEliminarMovimientoActionPerformed

    private void btnEditarMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarMovimientoActionPerformed
        if (tablaMovimientos.getRowCount() > 0) {
            //validar q se haya seleccionado un registro
            if (tablaMovimientos.getSelectedRow() != -1) {
                //obtener la id de lo q quiero editar
                int idMovimiento = Integer.parseInt(String.valueOf(tablaMovimientos.getValueAt(tablaMovimientos.getSelectedRow(), 0)));
                EditarMovimientos editar = new EditarMovimientos(idMovimiento);
                editar.setVisible(true);
                editar.setLocationRelativeTo(null);
                this.dispose();
            } else {
                mostrarMensaje("No seleccinó un Registro para editar", "Error", "Error al editar");
            }
        }

    }//GEN-LAST:event_btnEditarMovimientoActionPerformed

    private void cbfDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbfDestinoActionPerformed
        String tFlete = "";
        if (cbfDestino.isSelected()) {
            cbfOrigen.setSelected(false);
            tFlete = "Destino";
        }


    }//GEN-LAST:event_cbfDestinoActionPerformed

    private void cbfOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbfOrigenActionPerformed
        String tFlete = "";
        if (cbfOrigen.isSelected()) {
            cbfDestino.setSelected(false);
            tFlete = "Origen";
        }
    }//GEN-LAST:event_cbfOrigenActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Principal pn = new Principal();
        pn.setVisible(true);
        dispose();

    }//GEN-LAST:event_jButton2ActionPerformed
    private PNuevoCliente ventanaCliente;
    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        // Verificar si la ventana ya está abierta
        if (ventanaCliente == null || !ventanaCliente.isVisible()) {
            // Si la ventana no está abierta o está oculta, crea una nueva instancia
            ventanaCliente = new PNuevoCliente();
        }

        // Mostrar la ventana y enfocarla (llevarla al frente)
        ventanaCliente.setVisible(true);
        ventanaCliente.toFront();

    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void cbCuentaCorrienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCuentaCorrienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCuentaCorrienteActionPerformed

    private void btnGenerarRemitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarRemitoActionPerformed

        String fPagado = "";
        String fRendido = "";
        String tFlete = "";
        String tMontoP = "";
        String tMontoR = "";
        String tFleteP = "";
        String tFleteR = "";
        String cC = "";
        String remito;
        //FECHA
        Date fecha = getFecha();
        //HORA
        LocalTime horaActual = LocalTime.now().withSecond(0);
        Time horaSQL = Time.valueOf(horaActual);

        String cliente = (cbClientes.getSelectedItem() != null) ? cbClientes.getSelectedItem().toString() : "";
        String destino = (cbDestinos.getSelectedItem() != null) ? cbDestinos.getSelectedItem().toString() : "";
        String servicio = (cbServicios.getSelectedItem() != null) ? cbServicios.getSelectedItem().toString() : "";
        String representante = (cbRepresentantes.getSelectedItem() != null) ? cbRepresentantes.getSelectedItem().toString() : "";
        
         //bandera 1
        System.out.println(cliente);
        System.out.println(destino);
        System.out.println(servicio);

        int bulto = Integer.parseInt(txtBulto.getText());
        //txt monto
        String txtMontoValor = txtMonto.getText();
        String monto;
        //remito
        remito = txtRemito.getText();

        // Si hay campos faltantes, mostrar el mensaje de alerta
        if (!txtMontoValor.isEmpty()) {
            monto = txtMontoValor;
        } else {
            monto = "0";
        }
        String flete = txtFlete.getText();
        String obs = txtObservaciones.getText();
        //verif flete origen/destino
        if (cbfDestino.isSelected()) {
            tFlete = "Destino";
            cbfOrigen.setSelected(false);

        }
        if (cbfOrigen.isSelected()) {
            tFlete = "Origen";
            cbfDestino.setSelected(false);
        }

        //verif Cuenta Corriente
        if (cbCuentaCorriente.isSelected()) {
            cC = "Si";
        } else {
            cC = "No";
        }

        //verif de monto pagado/rendido
        if (cbmontoPagado.isSelected() && cbMontoRendido.isSelected()) {
            tMontoP = "Si";
            tMontoR = "Si";
        } else if (cbmontoPagado.isSelected()) {
            tMontoP = "Si";
            tMontoR = "No";
        } else if (cbMontoRendido.isSelected()) {
            tMontoR = "Si";
            tMontoP = "No";
        } else {
            tMontoR = "No";
            tMontoP = "No";
        }
        //verif de flete pagado/rendido
        if (cbfletePagado.isSelected() && cbfleteRendido.isSelected()) {
            tFleteP = "Si";
            tFleteR = "Si";
        } else if (cbfleteRendido.isSelected()) {
            tFleteR = "Si";
            tFleteP = "No";
        } else if (cbfletePagado.isSelected()) {
            tFleteR = "No";
            tFleteP = "Si";
        } else {
            tFleteR = "No";
            tFleteP = "No";
        }
        // Verificar campos vacíos y almacenar los nombres de los campos vacíos en una lista
        List<String> camposFaltantes = new ArrayList<>();
        if (cbClientes.getSelectedItem() == null || cbClientes.getSelectedItem().toString().isEmpty()) {
            camposFaltantes.add("Cliente");
        }
        if (cbDestinos.getSelectedItem() == null || cbDestinos.getSelectedItem().toString().isEmpty()) {
            camposFaltantes.add("Destino");
        }
        if (cbServicios.getSelectedItem() == null || cbServicios.getSelectedItem().toString().isEmpty()) {
            camposFaltantes.add("Servicio");
        }
        if (cbRepresentantes.getSelectedItem() == null || cbRepresentantes.getSelectedItem().toString().isEmpty()) {
            camposFaltantes.add("Representante");
        }
        if (txtBulto.getText().isEmpty()) {
            camposFaltantes.add("Bulto");
        }
        // Verificar el resto de campos obligatorios que desees
        if (txtMonto.getText().isEmpty()) {
            camposFaltantes.add("Monto");
        }
        if (txtFlete.getText().isEmpty()) {
            camposFaltantes.add("Flete");
        }
        if (remito.isEmpty()) {
            camposFaltantes.add("Remito");
        }

        if (!camposFaltantes.isEmpty()) {
            String mensaje = "Por favor, complete los siguientes campos obligatorios:\n";
            for (String campo : camposFaltantes) {
                mensaje += "- " + campo + "\n";
            }

            mostrarMensaje(mensaje, "Error", "Campos faltantes");
            return; // Detener la ejecución para no agregar el movimiento
        }

        control.cargarMovimiento(cliente, destino, servicio, representante, bulto, monto, flete, tFlete, remito, tMontoP, tMontoR, tFleteP, tFleteR, fecha, cC, obs, horaSQL);
        //mostrarMensaje("Movimiento agregado correctamente", "Info", "Agregado con exito!");
        generarPdf();

        // Actualizar la tabla
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaMovimientos.getModel();
        modeloTabla.setRowCount(0);
        List<Movimientos> movimientos = control.traerMovimientos();

        // Ordenar los datos por el ID en forma descendente
        Collections.sort(movimientos, Comparator.comparingInt(Movimientos::getId_movimientos).reversed());
        for (Movimientos mov : movimientos) {
            Object[] objeto = {mov.getId_movimientos(), mov.getHora(), mov.getFechaFormateada(), mov.getCliente(), mov.getDestino(), mov.getRemito(), mov.getBultos(), mov.getMonto(), mov.getTipoMontoP(), mov.getTipoMontoR(), mov.getFlete(), mov.getTipoFleteP(), mov.getTipoFleteR(), mov.getFleteDestinoOrigen(), mov.getRepresentante(), mov.getCuentaCorriente(), mov.getObservaciones()};

            modeloTabla.addRow(objeto);
        }

        //Limpiar Combobox
        // Remover los ActionListeners y KeyListeners de cbRepresentantes
        ActionListener[] repActionListeners = cbRepresentantes.getActionListeners();
        KeyListener[] repKeyListeners = cbRepresentantes.getEditor().getEditorComponent().getKeyListeners();

        for (ActionListener listener : repActionListeners) {
            cbRepresentantes.removeActionListener(listener);
        }

        for (KeyListener listener : repKeyListeners) {
            cbRepresentantes.getEditor().getEditorComponent().removeKeyListener(listener);
        }

        // Remover los ActionListeners y KeyListeners de cbDestinos
        ActionListener[] destActionListeners = cbDestinos.getActionListeners();
        KeyListener[] destKeyListeners = cbDestinos.getEditor().getEditorComponent().getKeyListeners();

        for (ActionListener listener : destActionListeners) {
            cbDestinos.removeActionListener(listener);
        }

        for (KeyListener listener : destKeyListeners) {
            cbDestinos.getEditor().getEditorComponent().removeKeyListener(listener);
        }

        cbRepresentantes.setSelectedIndex(-1); // Deselecciona cualquier elemento en el combo box
        cbDestinos.setSelectedIndex(-1); // Deselecciona cualquier elemento en cbDestinos

        // Volver a agregar los ActionListeners y KeyListeners a cbRepresentantes
        for (ActionListener listener : repActionListeners) {
            cbRepresentantes.addActionListener(listener);
        }

        for (KeyListener listener : repKeyListeners) {
            cbRepresentantes.getEditor().getEditorComponent().addKeyListener(listener);
        }

        // Volver a agregar los ActionListeners y KeyListeners a cbDestinos
        for (ActionListener listener : destActionListeners) {
            cbDestinos.addActionListener(listener);
        }

        for (KeyListener listener : destKeyListeners) {
            cbDestinos.getEditor().getEditorComponent().addKeyListener(listener);
        }

        //Limpiar datos
        txtRemito.setText("0");
        txtBulto.setText("1");
        cbCuentaCorriente.setSelected(false); // Desmarca la casilla de verificación
        txtMonto.setText("0");
        cbmontoPagado.setSelected(false);
        cbMontoRendido.setSelected(false);
        cbfletePagado.setSelected(false);
        cbfleteRendido.setSelected(false);
        txtObservaciones.setText("");
        txtSeguro.setText("0");
        txtContrarembolso.setText("0");
        txtRedespacho.setText("0");
        txtValDeclarado.setText("0");

    }//GEN-LAST:event_btnGenerarRemitoActionPerformed

    private void txtFleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFleteActionPerformed

    private void btnGenerarRemitoDuplicadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarRemitoDuplicadoActionPerformed

        String fPagado = "";
        String fRendido = "";
        String tFlete = "";
        String tMontoP = "";
        String tMontoR = "";
        String tFleteP = "";
        String tFleteR = "";
        String cC = "";
        String remito;
        //FECHA
        Date fecha = getFecha();
        //HORA
        LocalTime horaActual = LocalTime.now().withSecond(0);
        Time horaSQL = Time.valueOf(horaActual);

        String cliente = (cbClientes.getSelectedItem() != null) ? cbClientes.getSelectedItem().toString() : "";
        String destino = (cbDestinos.getSelectedItem() != null) ? cbDestinos.getSelectedItem().toString() : "";
        String servicio = (cbServicios.getSelectedItem() != null) ? cbServicios.getSelectedItem().toString() : "";
        String representante = (cbRepresentantes.getSelectedItem() != null) ? cbRepresentantes.getSelectedItem().toString() : "";

        int bulto = Integer.parseInt(txtBulto.getText());
        //txt monto
        String txtMontoValor = txtMonto.getText();
        String monto;
        //remito
        remito = txtRemito.getText();

        // Si hay campos faltantes, mostrar el mensaje de alerta
        if (!txtMontoValor.isEmpty()) {
            monto = txtMontoValor;
        } else {
            monto = "0";
        }
        String flete = txtFlete.getText();
        String obs = txtObservaciones.getText();
        //verif flete origen/destino
        if (cbfDestino.isSelected()) {
            tFlete = "Destino";
            cbfOrigen.setSelected(false);

        }
        if (cbfOrigen.isSelected()) {
            tFlete = "Origen";
            cbfDestino.setSelected(false);
        }

        //verif Cuenta Corriente
        if (cbCuentaCorriente.isSelected()) {
            cC = "Si";
        } else {
            cC = "No";
        }

        //verif de monto pagado/rendido
        if (cbmontoPagado.isSelected() && cbMontoRendido.isSelected()) {
            tMontoP = "Si";
            tMontoR = "Si";
        } else if (cbmontoPagado.isSelected()) {
            tMontoP = "Si";
            tMontoR = "No";
        } else if (cbMontoRendido.isSelected()) {
            tMontoR = "Si";
            tMontoP = "No";
        } else {
            tMontoR = "No";
            tMontoP = "No";
        }
        //verif de flete pagado/rendido
        if (cbfletePagado.isSelected() && cbfleteRendido.isSelected()) {
            tFleteP = "Si";
            tFleteR = "Si";
        } else if (cbfleteRendido.isSelected()) {
            tFleteR = "Si";
            tFleteP = "No";
        } else if (cbfletePagado.isSelected()) {
            tFleteR = "No";
            tFleteP = "Si";
        } else {
            tFleteR = "No";
            tFleteP = "No";
        }
        // Verificar campos vacíos y almacenar los nombres de los campos vacíos en una lista
        List<String> camposFaltantes = new ArrayList<>();
        if (cbClientes.getSelectedItem() == null || cbClientes.getSelectedItem().toString().isEmpty()) {
            camposFaltantes.add("Cliente");
        }
        if (cbDestinos.getSelectedItem() == null || cbDestinos.getSelectedItem().toString().isEmpty()) {
            camposFaltantes.add("Destino");
        }
        if (cbServicios.getSelectedItem() == null || cbServicios.getSelectedItem().toString().isEmpty()) {
            camposFaltantes.add("Servicio");
        }
        if (cbRepresentantes.getSelectedItem() == null || cbRepresentantes.getSelectedItem().toString().isEmpty()) {
            camposFaltantes.add("Representante");
        }
        if (txtBulto.getText().isEmpty()) {
            camposFaltantes.add("Bulto");
        }
        // Verificar el resto de campos obligatorios que desees
        if (txtMonto.getText().isEmpty()) {
            camposFaltantes.add("Monto");
        }
        if (txtFlete.getText().isEmpty()) {
            camposFaltantes.add("Flete");
        }
        if (remito.isEmpty()) {
            camposFaltantes.add("Remito");
        }

        if (!camposFaltantes.isEmpty()) {
            String mensaje = "Por favor, complete los siguientes campos obligatorios:\n";
            for (String campo : camposFaltantes) {
                mensaje += "- " + campo + "\n";
            }

            mostrarMensaje(mensaje, "Error", "Campos faltantes");
            return; // Detener la ejecución para no agregar el movimiento
        }

        control.cargarMovimiento(cliente, destino, servicio, representante, bulto, monto, flete, tFlete, remito, tMontoP, tMontoR, tFleteP, tFleteR, fecha, cC, obs, horaSQL);
        //mostrarMensaje("Movimiento agregado correctamente", "Info", "Agregado con exito!");
        generarPdfDuplicado();

        // Actualizar la tabla
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaMovimientos.getModel();
        modeloTabla.setRowCount(0);
        List<Movimientos> movimientos = control.traerMovimientos();
        // Ordenar los datos por el ID en forma descendente
        Collections.sort(movimientos, Comparator.comparingInt(Movimientos::getId_movimientos).reversed());
        for (Movimientos mov : movimientos) {
            Object[] objeto = {mov.getId_movimientos(), mov.getHora(), mov.getFechaFormateada(), mov.getCliente(), mov.getDestino(), mov.getRemito(), mov.getBultos(), mov.getMonto(), mov.getTipoMontoP(), mov.getTipoMontoR(), mov.getFlete(), mov.getTipoFleteP(), mov.getTipoFleteR(), mov.getFleteDestinoOrigen(), mov.getRepresentante(), mov.getCuentaCorriente(), mov.getObservaciones()};

            modeloTabla.addRow(objeto);
        }

        //Limpiar Combobox
        // Remover los ActionListeners y KeyListeners de cbRepresentantes
        ActionListener[] repActionListeners = cbRepresentantes.getActionListeners();
        KeyListener[] repKeyListeners = cbRepresentantes.getEditor().getEditorComponent().getKeyListeners();

        for (ActionListener listener : repActionListeners) {
            cbRepresentantes.removeActionListener(listener);
        }

        for (KeyListener listener : repKeyListeners) {
            cbRepresentantes.getEditor().getEditorComponent().removeKeyListener(listener);
        }

        // Remover los ActionListeners y KeyListeners de cbDestinos
        ActionListener[] destActionListeners = cbDestinos.getActionListeners();
        KeyListener[] destKeyListeners = cbDestinos.getEditor().getEditorComponent().getKeyListeners();

        for (ActionListener listener : destActionListeners) {
            cbDestinos.removeActionListener(listener);
        }

        for (KeyListener listener : destKeyListeners) {
            cbDestinos.getEditor().getEditorComponent().removeKeyListener(listener);
        }

        cbRepresentantes.setSelectedIndex(-1); // Deselecciona cualquier elemento en el combo box
        cbDestinos.setSelectedIndex(-1); // Deselecciona cualquier elemento en cbDestinos

        // Volver a agregar los ActionListeners y KeyListeners a cbRepresentantes
        for (ActionListener listener : repActionListeners) {
            cbRepresentantes.addActionListener(listener);
        }

        for (KeyListener listener : repKeyListeners) {
            cbRepresentantes.getEditor().getEditorComponent().addKeyListener(listener);
        }

        // Volver a agregar los ActionListeners y KeyListeners a cbDestinos
        for (ActionListener listener : destActionListeners) {
            cbDestinos.addActionListener(listener);
        }

        for (KeyListener listener : destKeyListeners) {
            cbDestinos.getEditor().getEditorComponent().addKeyListener(listener);
        }

        //Limpiar datos
        txtRemito.setText("0");
        txtBulto.setText("1");
        cbCuentaCorriente.setSelected(false); // Desmarca la casilla de verificación
        txtMonto.setText("0");
        cbmontoPagado.setSelected(false);
        cbMontoRendido.setSelected(false);
        cbfletePagado.setSelected(false);
        cbfleteRendido.setSelected(false);
        txtObservaciones.setText("");
        txtSeguro.setText("0");
        txtContrarembolso.setText("0");
        txtRedespacho.setText("0");
        txtValDeclarado.setText("0");
    }//GEN-LAST:event_btnGenerarRemitoDuplicadoActionPerformed

    private void cbClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbClientesActionPerformed

    private void cbServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbServiciosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbServiciosActionPerformed

    private void txtValDeclaradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValDeclaradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValDeclaradoActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBusquedas;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnEditarMovimiento;
    private javax.swing.JButton btnEliminarMovimiento;
    private javax.swing.JButton btnGenerarRemito;
    private javax.swing.JButton btnGenerarRemitoDuplicado;
    private javax.swing.JLabel bulto;
    private javax.swing.JComboBox<String> cbClientes;
    private javax.swing.JCheckBox cbCuentaCorriente;
    private javax.swing.JComboBox<String> cbDestinos;
    private javax.swing.JCheckBox cbMontoRendido;
    private javax.swing.JComboBox<String> cbRepresentantes;
    private javax.swing.JComboBox<String> cbServicios;
    private javax.swing.JCheckBox cbfDestino;
    private javax.swing.JCheckBox cbfOrigen;
    private javax.swing.JCheckBox cbfletePagado;
    private javax.swing.JCheckBox cbfleteRendido;
    private javax.swing.JCheckBox cbmontoPagado;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelCargaMovimientos;
    private javax.swing.JTable tablaMovimientos;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtBulto;
    private javax.swing.JTextField txtContrarembolso;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtFiltroCliente;
    private javax.swing.JTextField txtFiltroRemito;
    private javax.swing.JTextField txtFlete;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtObservaciones;
    private javax.swing.JTextField txtRedespacho;
    private javax.swing.JTextField txtRemito;
    private javax.swing.JTextField txtSeguro;
    private javax.swing.JTextField txtValDeclarado;
    // End of variables declaration//GEN-END:variables

  /*  public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
    }*/
    
   

    public Date getFecha() {
        int dia = Integer.parseInt(txtDia.getText());
        int mes = Integer.parseInt(txtMes.getText());
        int anio = Integer.parseInt(txtAnio.getText());

        Calendar calendar = Calendar.getInstance();
        // Los meses en Calendar van de 0 a 11, así que resta 1 al mes
        calendar.set(anio, mes - 1, dia);

        Date date = calendar.getTime();

        return date;
    }

    private void generarPdf() {
        Document document = new Document();

        // Incrementar el contador de remito
        numeroRemito++;
        // Generar el número de remito en formato de 8 dígitos
        String numeroRemitoString = String.format("%08d", numeroRemito);
        try {
            // Obtener la ruta del escritorio del usuario
            String userHome = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
            // Especificar la ruta de salida del archivo PDF en el escritorio
            String outputPath = userHome + File.separator + "archivo.pdf";

            // Crear el archivo de salida
            File outputFile = new File(outputPath);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputFile));

            document.open();

            // Crear un PdfTemplate para agregar el contenido dentro del marco
            PdfContentByte canvas = writer.getDirectContent();
            PdfTemplate template = canvas.createTemplate(document.getPageSize().getWidth() - 40, document.getPageSize().getHeight() - 40);

            //FUENTES
            Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
            Font fontColumnas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
            Font fontTotales = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
            Font fontFecha = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
            Font fontFilas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, Font.NORMAL, BaseColor.BLACK);
            Font fontR = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
            // Crear una tabla para organizar los elementos
            PdfPTable table = new PdfPTable(3); // 2 columnas
            table.setWidthPercentage(100); // Ancho de la tabla en porcentaje del ancho de página

            // LOGO
            InputStream logoStream = getClass().getClassLoader().getResourceAsStream("imagenes/logoreportes.jpg");
            BufferedImage bufferedImage = ImageIO.read(logoStream);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", baos);
            byte[] logoBytes = baos.toByteArray();

            Image logo = Image.getInstance(logoBytes);
            logo.scaleAbsolute(150, 120);
            logo.setAlignment(Element.ALIGN_LEFT);

            // TEXTO
            InputStream textoStream = getClass().getClassLoader().getResourceAsStream("imagenes/texto.png");
            Image texto = Image.getInstance(ImageIO.read(textoStream), null);
            texto.scaleToFit(150, 120);
            texto.setAlignment(Element.ALIGN_LEFT);

            // REMITO NO VALIDO
            InputStream remStream = getClass().getClassLoader().getResourceAsStream("imagenes/Remito.jpg");
            Image rem = Image.getInstance(ImageIO.read(remStream), null);
            rem.scaleToFit(50, 50);
            rem.setAlignment(Element.ALIGN_CENTER);

            // REMITO
            InputStream remitoStream = getClass().getClassLoader().getResourceAsStream("imagenes/remito_cuit.jpg");
            Image remito = Image.getInstance(ImageIO.read(remitoStream), null);
            remito.scaleToFit(150, 180);
            remito.setAlignment(Element.ALIGN_RIGHT);

            // FECHAS
            // Obtener los valores de los campos de texto
        int dia = Integer.parseInt(txtDia.getText());
        int mes = Integer.parseInt(txtMes.getText());
        int anio = Integer.parseInt(txtAnio.getText());

            // Crear una instancia de LocalDate si la fecha es válida
            LocalDate fechaArmada = LocalDate.of(anio, mes, dia);
            
            // Formatear la fecha en el formato deseado
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String fechaFormat = fechaArmada.format(formatter);

            
            Chunk chunkFechas = new Chunk("Fecha: " + fechaFormat, fontFecha);
            Paragraph fecha = new Paragraph(chunkFechas);
            fecha.setAlignment(Element.ALIGN_RIGHT);
            //REMITO NRO
            Paragraph nroRemito = new Paragraph("REMITO N° " + String.format("%08d", numeroRemito), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD));
            guardarNumeroRemito();
            nroRemito.setAlignment(Element.ALIGN_RIGHT);

            // Celda 1: Logo + Texto relacionado al logo + Fecha
            PdfPCell cell1 = new PdfPCell();
            cell1.addElement(logo);
            cell1.addElement(texto);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear a la izquierda
            cell1.setVerticalAlignment(Element.ALIGN_RIGHT); // Alinear arriba
            cell1.setBorder(Rectangle.NO_BORDER); // Sin bordes

            table.addCell(cell1);

            // Celda 3: Remito
            PdfPCell cell3 = new PdfPCell(rem);
            cell3.addElement(rem);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear a la derecha
            cell3.setVerticalAlignment(Element.ALIGN_RIGHT); // Alinear abajo
            cell3.setBorder(Rectangle.NO_BORDER); // Sin bordes
            table.addCell(cell3);

            // Celda 2: Hector Alejandro Espindola
            PdfPCell cell2 = new PdfPCell(remito);
            cell2.addElement(fecha);
            cell2.addElement(nroRemito);
            cell2.addElement(remito);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear a la derecha
            cell2.setVerticalAlignment(Element.ALIGN_RIGHT); // Alinear abajo
            cell2.setBorder(Rectangle.NO_BORDER); // Sin bordes
            table.addCell(cell2);

            document.add(table);
            // Crear una tabla contenedora con 2 columnas
            PdfPTable tablaContenedora = new PdfPTable(2);
            tablaContenedora.setWidthPercentage(100);
            float[] columnWidths = {1, 1}; // Ajusta los valores según tu necesidad
            tablaContenedora.setWidths(columnWidths);

            PdfPCell remitenteCell = new PdfPCell();
            remitenteCell.setBorder(Rectangle.BOX);

            String nombreCliente = clienteSeleccionado != null && clienteSeleccionado.getNombre() != null
                    ? clienteSeleccionado.getNombre().toUpperCase()
                    : cbClientes.getSelectedItem().toString().toUpperCase();

            String direccion = clienteSeleccionado != null && clienteSeleccionado.getDireccion() != null
                    ? clienteSeleccionado.getDireccion().toUpperCase()
                    : "";

            String localidad = clienteSeleccionado != null && clienteSeleccionado.getLocalidad() != null
                    ? clienteSeleccionado.getLocalidad().toUpperCase()
                    : cbDestinos.getSelectedItem().toString().toUpperCase();

            String cuit = clienteSeleccionado != null && clienteSeleccionado.getCuit() != null
                    ? clienteSeleccionado.getCuit().toUpperCase()
                    : "";

            String tel = clienteSeleccionado != null && clienteSeleccionado.getTelefono() != null
                    ? clienteSeleccionado.getTelefono().toUpperCase()
                    : "";
            //Bandera 1
            System.out.println("Bandera 1:");
            System.out.println("");
            System.out.println(nombreCliente);
            System.out.println(direccion);
            System.out.println(localidad);
            System.out.println(tel);
            System.out.println(cuit);
            

            Paragraph nombreParagraph = new Paragraph("REMITENTE: " + nombreCliente, fontR);
            nombreParagraph.setAlignment(Element.ALIGN_LEFT);
            remitenteCell.addElement(nombreParagraph);

            Paragraph direccionParagraph = new Paragraph("DIRECCION: " + direccion, fontR);
            direccionParagraph.setAlignment(Element.ALIGN_LEFT);
            remitenteCell.addElement(direccionParagraph);

            Paragraph localidadParagraph = new Paragraph("LOCALIDAD: " + localidad, fontR);
            localidadParagraph.setAlignment(Element.ALIGN_LEFT);
            remitenteCell.addElement(localidadParagraph);

            Paragraph telParagraph = new Paragraph("TELEFONO: " + tel, fontR);
            telParagraph.setAlignment(Element.ALIGN_LEFT);
            remitenteCell.addElement(telParagraph);

            Paragraph cuitParagraph = new Paragraph("CUIT: " + cuit, fontR);
            cuitParagraph.setAlignment(Element.ALIGN_LEFT);
            remitenteCell.addElement(cuitParagraph);

            remitenteCell.setHorizontalAlignment(Element.ALIGN_LEFT); // Alineación horizontal de la celda
            tablaContenedora.addCell(remitenteCell);

            // Crear la celda del destinatario
            PdfPCell destinatarioCell = new PdfPCell();
            destinatarioCell.setBorder(Rectangle.BOX);

            String nombreDestinatario = "";
            String direccionDestinatario = "";
            String localidadDestinatario = "";
            String cuitDestinatario = "";
            String telDestinatario = "";

            if (destinatarioSeleccionado != null && destinatarioSeleccionado.getDireccion() != null && destinatarioSeleccionado.getLocalidad() != null
                    && destinatarioSeleccionado.getCuit() != null && destinatarioSeleccionado.getNombre() != null && destinatarioSeleccionado.getTelefono() != null) {
                nombreDestinatario = destinatarioSeleccionado.getNombre().toUpperCase();
                direccionDestinatario = destinatarioSeleccionado.getDireccion().toUpperCase();
                localidadDestinatario = destinatarioSeleccionado.getLocalidad().toUpperCase();
                cuitDestinatario = destinatarioSeleccionado.getCuit().toUpperCase();
                telDestinatario = destinatarioSeleccionado.getTelefono().toUpperCase();
                 //Bandera 2
            System.out.println("Bandera 2 Destinatario:");
            System.out.println("");
            System.out.println(nombreDestinatario);
            System.out.println(direccionDestinatario);
            System.out.println(localidadDestinatario);
            System.out.println(telDestinatario);
            System.out.println(cuitDestinatario);
            

            } else {
                nombreDestinatario = cbDestinos.getSelectedItem().toString().toUpperCase();
                direccionDestinatario = "";
                localidadDestinatario = "";
                cuitDestinatario = "";
                telDestinatario = "";
            }

            Paragraph nombreDestinatarioParagraph = new Paragraph("DESTINATARIO: " + nombreDestinatario, fontR);
            nombreDestinatarioParagraph.setAlignment(Element.ALIGN_LEFT);
            destinatarioCell.addElement(nombreDestinatarioParagraph);

            Paragraph direccionDestinatarioParagraph = new Paragraph("DIRECCION: " + direccionDestinatario, fontR);
            direccionDestinatarioParagraph.setAlignment(Element.ALIGN_LEFT);
            destinatarioCell.addElement(direccionDestinatarioParagraph);

            Paragraph localidadDestinatarioParagraph = new Paragraph("LOCALIDAD: " + localidadDestinatario, fontR);
            localidadDestinatarioParagraph.setAlignment(Element.ALIGN_LEFT);
            destinatarioCell.addElement(localidadDestinatarioParagraph);

            Paragraph telDestinatarioParagraph = new Paragraph("TELEFONO: " + telDestinatario, fontR);
            telDestinatarioParagraph.setAlignment(Element.ALIGN_LEFT);
            destinatarioCell.addElement(telDestinatarioParagraph);

            Paragraph cuitDestinatarioParagraph = new Paragraph("CUIT: " + cuitDestinatario, fontR);
            cuitDestinatarioParagraph.setAlignment(Element.ALIGN_LEFT);
            destinatarioCell.addElement(cuitDestinatarioParagraph);

            destinatarioCell.setHorizontalAlignment(Element.ALIGN_LEFT); // Alineación horizontal de la celda
            tablaContenedora.addCell(destinatarioCell);

            document.add(tablaContenedora);

            // Agregar espacio arriba de la tabla
            Paragraph espacio = new Paragraph(1f, " "); // tamaño del espacio
            document.add(espacio);

            // Crear la tabla con 6 columnas
            PdfPTable tablaa = new PdfPTable(6);
            tablaa.setWidthPercentage(100);

            // Establecer el borde de las celdas de las filas como NO_BORDER
            PdfPCell bordeTop = new PdfPCell();
            bordeTop.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.RIGHT);
            PdfPCell celdaConBorde = new PdfPCell();
            celdaConBorde.setBorder(Rectangle.BOTTOM | Rectangle.LEFT | Rectangle.RIGHT);

            // Agregar las celdas a la tabla
            tablaa.addCell(createCell("Descripción", font, bordeTop));
            tablaa.addCell(createCell("Seguro", font, bordeTop));
            tablaa.addCell(createCell("Comision contrarrembolso", font, bordeTop));
            tablaa.addCell(createCell("Redespacho", font, bordeTop));
            tablaa.addCell(createCell("Valor Declarado", font, bordeTop));
            tablaa.addCell(createCell("Observaciones", font, bordeTop));

            // Obtener los valores de los campos de texto
            String descripcion = txtBulto.getText() + " bultos";
            String observaciones = txtObservaciones.getText();
            String seguro = txtSeguro.getText();
            String comContrarembolso = txtContrarembolso.getText();
            String redespacho = txtRedespacho.getText();
            String valDeclarado = txtValDeclarado.getText();

            // Agregar los valores a la tabla
            tablaa.addCell(createCell(descripcion, font, celdaConBorde));
            tablaa.addCell(createCell("$" + seguro, font, celdaConBorde)); // Columna "Seguro"
            tablaa.addCell(createCell("$" + comContrarembolso, font, celdaConBorde)); // Columna "Com. Contrarrembolso"
            tablaa.addCell(createCell("$" + redespacho, font, celdaConBorde)); // Columna "Redespacho"
            tablaa.addCell(createCell("$" + valDeclarado, font, celdaConBorde)); // Columna "Valor Declarado"
            tablaa.addCell(createCell(observaciones, font, celdaConBorde));

            // Agregar la tabla al documento
            document.add(tablaa);
            Paragraph recibenB = new Paragraph("SE RECIBEN LOS BULTOS SIN ESPECIFICAR SU CONTENIDO", fontR);
            recibenB.setAlignment(Element.ALIGN_CENTER);
            document.add(recibenB);
            // Crear la tabla con 2 columnas
            PdfPTable tabla = new PdfPTable(2);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{1, 0.5f}); // Ajustar el ancho de las columnas

            // Agregar la imagen a la primera celda
            PdfPCell imagenCell = new PdfPCell();
            InputStream firmaStream = getClass().getClassLoader().getResourceAsStream("imagenes/firma_aclaracion.png");
            Image firmasello = Image.getInstance(ImageIO.read(firmaStream), null);
            firmasello.scaleToFit(300, 200);
            firmasello.setAlignment(Element.ALIGN_LEFT);
            imagenCell.addElement(firmasello);
            imagenCell.setBorder(Rectangle.NO_BORDER);
            tabla.addCell(imagenCell);

            // Agregar el texto a la segunda celda
            String condicionFlete = cbCuentaCorriente.isSelected() ? "CUENTA CORRIENTE" : "CONTADO";
            String flete = "";
            if (cbfOrigen.isSelected()) {
                flete = "origen";
            } else if (cbfDestino.isSelected()) {
                flete = "destino";
            }

            PdfPCell textoCell = new PdfPCell();
            textoCell.setBorder(Rectangle.NO_BORDER);
            // Crear una tabla interna para el texto
            PdfPTable tablaTexto = new PdfPTable(1);
            tablaTexto.setWidthPercentage(100);

            // Crea una instancia personalizada de Font con tus preferencias
            Font fontPersonalizado = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);

            // Crea el párrafo con el texto y la fuente personalizada
            Paragraph c = new Paragraph("CONTRAREEMBOLSO: $" + txtMonto.getText(), fontPersonalizado);

            // Resto del código
            c.setAlignment(Element.ALIGN_LEFT);
            PdfPCell celdaC = new PdfPCell(c);
            celdaC.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP | Rectangle.BOTTOM);
            celdaC.setPadding(3f);
            celdaC.setPaddingBottom(4f);
            tablaTexto.addCell(celdaC);

            Paragraph b = new Paragraph("FLETE: $" + txtFlete.getText(), fontR);
            b.setAlignment(Element.ALIGN_LEFT);
            PdfPCell celdaB = new PdfPCell(b);
            celdaB.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM); // Agregar borde alrededor de la celda "b"
            celdaB.setPadding(1f); // Ajustar el relleno de la celda "b"
            celdaB.setPaddingBottom(4f); // Ajustar el relleno de la celda "b"
            tablaTexto.addCell(celdaB);

            // Crear una instancia personalizada de Font con subrayado y negrita
            Font fontSubrayadoNegrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD | Font.UNDERLINE, BaseColor.BLACK);
            Font fontNegrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);

            // Crear un Chunk con el texto "Condicion de venta:" y aplicarle el estilo de negrita
            Chunk textoCondicionVenta = new Chunk("Condicion de venta: ", fontNegrita);

            // Crear un Chunk con el texto de condicionFlete y aplicarle el estilo de subrayado y negrita
            Chunk condicionChunk = new Chunk(condicionFlete, fontSubrayadoNegrita);

            // Crear el Paragraph con los Chunks de "Condicion de venta:" y la variable condicionFlete
            Paragraph a = new Paragraph();
            a.add(textoCondicionVenta);
            a.add(condicionChunk); // Agregar el Chunk al Paragraph
            a.setAlignment(Element.ALIGN_RIGHT);

            PdfPCell celdaA = new PdfPCell(a);
            celdaA.setBorder(Rectangle.NO_BORDER);
            celdaA.setPaddingBottom(2);
            tablaTexto.addCell(celdaA);

            // Crear una instancia personalizada de Font con negrita y subrayado
            Font fontNegritaSubrayado = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD | Font.UNDERLINE, BaseColor.BLACK);

            // Crear un Chunk con el texto "Flete: a cobrar en" y aplicarle el estilo de negrita
            Chunk fleteChunk = new Chunk("Flete: a cobrar en ", FontFactory.getFont(FontFactory.TIMES_BOLD, 12));

            // Crear un Chunk con el texto de la variable flete y aplicarle el estilo de negrita y subrayado
            Chunk fleteValorChunk = new Chunk(flete, fontNegritaSubrayado);

            // Crear el Paragraph con los Chunks de "Flete: a cobrar en" y la variable flete
            Paragraph f = new Paragraph();
            f.add(fleteChunk);
            f.add(fleteValorChunk);
            f.setAlignment(Element.ALIGN_RIGHT);

            PdfPCell celdaF = new PdfPCell(f);
            celdaF.setBorder(Rectangle.NO_BORDER);
            celdaF.setPaddingBottom(2);
            tablaTexto.addCell(celdaF);

            Paragraph facturaremito = new Paragraph("Factura/Remito N°: " + txtRemito.getText(), fontR);
            facturaremito.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell celdafacturaremito = new PdfPCell(facturaremito);
            celdafacturaremito.setBorder(Rectangle.NO_BORDER); // Sin borde para la celda "f"
            celdafacturaremito.setPaddingBottom(2); // Ajustar el espacio inferior de la celda "f"
            tablaTexto.addCell(celdafacturaremito);

            double monto = Double.parseDouble(txtMonto.getText());
            double fletee = Double.parseDouble(txtFlete.getText());
            double seguroo = Double.parseDouble(txtSeguro.getText());
            double comContra = Double.parseDouble(txtContrarembolso.getText());
            double redespa = Double.parseDouble(txtRedespacho.getText());
            double valDecla = Double.parseDouble(txtValDeclarado.getText());
            double total = monto + fletee + seguroo + comContra + redespa + valDecla;
            Paragraph totalMonto = new Paragraph("TOTAL: $" + total, fontR);
            totalMonto.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell celdaTotal = new PdfPCell(totalMonto);
            celdaTotal.setBorder(Rectangle.NO_BORDER); // Sin borde para la celda "total"
            celdaTotal.setPaddingBottom(2); // Ajustar el espacio inferior de la celda "total"
            tablaTexto.addCell(celdaTotal);

            textoCell.addElement(tablaTexto);
            tabla.addCell(textoCell);

            // Ajustar el espacio entre las filas de la tabla
            tabla.setSpacingAfter(3);
            document.add(tabla);

            // Cerrar el template y añadirlo al contenido del documento
            template.closePathFillStroke();
            canvas.addTemplate(template, 20, 20);

            // Obtener el tamaño exacto del contenido
            float contentWidth = template.getWidth();
            float contentHeight = template.getHeight();

            // Crear un rectángulo que servirá como marco alrededor del contenido
            PdfContentByte canvasForBorders = writer.getDirectContentUnder();
            Rectangle marco = new Rectangle(20, 440, 20 + contentWidth, 20 + contentHeight);
            marco.setBorder(Rectangle.BOX); // Establecer el tipo de borde
            marco.setBorderWidth(1); // Establecer el ancho del borde
            marco.setBorderColor(BaseColor.BLACK); // Establecer el color del borde
            canvasForBorders.rectangle(marco);

            document.close();
            writer.close();

            // Imprimir el archivo PDF automáticamente
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

                JOptionPane.showMessageDialog(null, "El remito se generó e imprimió correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al generar o imprimir el remito.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al generar el remito.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void generarPdfDuplicado() {
        Document document = new Document();
        // Incrementar el contador de remito
        numeroRemito++;
        // Generar el número de remito en formato de 8 dígitos
        String numeroRemitoString = String.format("%08d", numeroRemito);
        try {
            // Obtener la ruta del escritorio del usuario
            String userHome = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
            // Especificar la ruta de salida del archivo PDF en el escritorio
            String outputPath = userHome + File.separator + "archivo.pdf";

            // Crear el archivo de salida
            File outputFile = new File(outputPath);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputFile));

            document.open();

            // Crear un PdfTemplate para agregar el contenido dentro del marco
            PdfContentByte canvas = writer.getDirectContent();
            PdfTemplate template = canvas.createTemplate(document.getPageSize().getWidth() - 40, document.getPageSize().getHeight() - 40);

            //FUENTES
            Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
            Font fontColumnas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
            Font fontTotales = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
            Font fontFecha = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
            Font fontFilas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, Font.NORMAL, BaseColor.BLACK);
            Font fontR = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
            // Crear una tabla para organizar los elementos
            PdfPTable table = new PdfPTable(3); // 2 columnas
            table.setWidthPercentage(100); // Ancho de la tabla en porcentaje del ancho de página

            // LOGO
            InputStream logoStream = getClass().getClassLoader().getResourceAsStream("imagenes/logoreportes.jpg");
            BufferedImage bufferedImage = ImageIO.read(logoStream);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", baos);
            byte[] logoBytes = baos.toByteArray();

            Image logo = Image.getInstance(logoBytes);
            logo.scaleAbsolute(150, 120);
            logo.setAlignment(Element.ALIGN_LEFT);

            // TEXTO
            InputStream textoStream = getClass().getClassLoader().getResourceAsStream("imagenes/texto.png");
            Image texto = Image.getInstance(ImageIO.read(textoStream), null);
            texto.scaleToFit(150, 120);
            texto.setAlignment(Element.ALIGN_LEFT);

            // REMITO NO VALIDO
            InputStream remStream = getClass().getClassLoader().getResourceAsStream("imagenes/Remito.jpg");
            Image rem = Image.getInstance(ImageIO.read(remStream), null);
            rem.scaleToFit(50, 50);
            rem.setAlignment(Element.ALIGN_CENTER);

            // REMITO
            InputStream remitoStream = getClass().getClassLoader().getResourceAsStream("imagenes/remito_cuit.jpg");
            Image remito = Image.getInstance(ImageIO.read(remitoStream), null);
            remito.scaleToFit(150, 180);
            remito.setAlignment(Element.ALIGN_RIGHT);
            // FECHAS
            Chunk chunkFechas = new Chunk("Fecha: " + fechaActual(), fontFecha);
            Paragraph fecha = new Paragraph(chunkFechas);
            fecha.setAlignment(Element.ALIGN_RIGHT);
            //REMITO NRO
            Paragraph nroRemito = new Paragraph("REMITO N° " + String.format("%08d", numeroRemito), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD));
            guardarNumeroRemito();
            nroRemito.setAlignment(Element.ALIGN_RIGHT);

            // Celda 1: Logo + Texto relacionado al logo + Fecha
            PdfPCell cell1 = new PdfPCell();
            cell1.addElement(logo);
            cell1.addElement(texto);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear a la izquierda
            cell1.setVerticalAlignment(Element.ALIGN_RIGHT); // Alinear arriba
            cell1.setBorder(Rectangle.NO_BORDER); // Sin bordes

            table.addCell(cell1);

            // Celda 3: Remito
            PdfPCell cell3 = new PdfPCell(rem);
            cell3.addElement(rem);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear a la derecha
            cell3.setVerticalAlignment(Element.ALIGN_RIGHT); // Alinear abajo
            cell3.setBorder(Rectangle.NO_BORDER); // Sin bordes
            table.addCell(cell3);

            // Celda 2: 
            PdfPCell cell2 = new PdfPCell(remito);
            cell2.addElement(fecha);
            cell2.addElement(nroRemito);
            cell2.addElement(remito);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear a la derecha
            cell2.setVerticalAlignment(Element.ALIGN_RIGHT); // Alinear abajo
            cell2.setBorder(Rectangle.NO_BORDER); // Sin bordes
            table.addCell(cell2);

            document.add(table);
            // Crear una tabla contenedora con 2 columnas
            PdfPTable tablaContenedora = new PdfPTable(2);
            tablaContenedora.setWidthPercentage(100);
            float[] columnWidths = {1, 1}; // Ajusta los valores según tu necesidad
            tablaContenedora.setWidths(columnWidths);

            PdfPCell remitenteCell = new PdfPCell();
            remitenteCell.setBorder(Rectangle.BOX);

            String nombreCliente = clienteSeleccionado != null && clienteSeleccionado.getNombre() != null
                    ? clienteSeleccionado.getNombre().toUpperCase()
                    : cbClientes.getSelectedItem().toString().toUpperCase();

            String direccion = clienteSeleccionado != null && clienteSeleccionado.getDireccion() != null
                    ? clienteSeleccionado.getDireccion().toUpperCase()
                    : "";

            String localidad = clienteSeleccionado != null && clienteSeleccionado.getLocalidad() != null
                    ? clienteSeleccionado.getLocalidad().toUpperCase()
                    : cbDestinos.getSelectedItem().toString().toUpperCase();

            String cuit = clienteSeleccionado != null && clienteSeleccionado.getCuit() != null
                    ? clienteSeleccionado.getCuit().toUpperCase()
                    : "";

            String tel = clienteSeleccionado != null && clienteSeleccionado.getTelefono() != null
                    ? clienteSeleccionado.getTelefono().toUpperCase()
                    : "";

            Paragraph nombreParagraph = new Paragraph("REMITENTE: " + nombreCliente, fontR);
            nombreParagraph.setAlignment(Element.ALIGN_LEFT);
            remitenteCell.addElement(nombreParagraph);

            Paragraph direccionParagraph = new Paragraph("DIRECCION: " + direccion, fontR);
            direccionParagraph.setAlignment(Element.ALIGN_LEFT);
            remitenteCell.addElement(direccionParagraph);

            Paragraph localidadParagraph = new Paragraph("LOCALIDAD: " + localidad, fontR);
            localidadParagraph.setAlignment(Element.ALIGN_LEFT);
            remitenteCell.addElement(localidadParagraph);

            Paragraph telParagraph = new Paragraph("TELEFONO: " + tel, fontR);
            telParagraph.setAlignment(Element.ALIGN_LEFT);
            remitenteCell.addElement(telParagraph);

            Paragraph cuitParagraph = new Paragraph("CUIT: " + cuit, fontR);
            cuitParagraph.setAlignment(Element.ALIGN_LEFT);
            remitenteCell.addElement(cuitParagraph);

            remitenteCell.setHorizontalAlignment(Element.ALIGN_LEFT); // Alineación horizontal de la celda
            tablaContenedora.addCell(remitenteCell);

            // Crear la celda del destinatario
            PdfPCell destinatarioCell = new PdfPCell();
            destinatarioCell.setBorder(Rectangle.BOX);

            String nombreDestinatario = "";
            String direccionDestinatario = "";
            String localidadDestinatario = "";
            String cuitDestinatario = "";
            String telDestinatario = "";

            if (destinatarioSeleccionado != null && destinatarioSeleccionado.getDireccion() != null && destinatarioSeleccionado.getLocalidad() != null
                    && destinatarioSeleccionado.getCuit() != null && destinatarioSeleccionado.getNombre() != null && destinatarioSeleccionado.getTelefono() != null) {
                nombreDestinatario = destinatarioSeleccionado.getNombre().toUpperCase();
                direccionDestinatario = destinatarioSeleccionado.getDireccion().toUpperCase();
                localidadDestinatario = destinatarioSeleccionado.getLocalidad().toUpperCase();
                cuitDestinatario = destinatarioSeleccionado.getCuit().toUpperCase();
                telDestinatario = destinatarioSeleccionado.getTelefono().toUpperCase();

            } else {
                nombreDestinatario = cbDestinos.getSelectedItem().toString().toUpperCase();
                direccionDestinatario = "";
                localidadDestinatario = "";
                cuitDestinatario = "";
                telDestinatario = "";
            }

            Paragraph nombreDestinatarioParagraph = new Paragraph("DESTINATARIO: " + nombreDestinatario, fontR);
            nombreDestinatarioParagraph.setAlignment(Element.ALIGN_LEFT);
            destinatarioCell.addElement(nombreDestinatarioParagraph);

            Paragraph direccionDestinatarioParagraph = new Paragraph("DIRECCION: " + direccionDestinatario, fontR);
            direccionDestinatarioParagraph.setAlignment(Element.ALIGN_LEFT);
            destinatarioCell.addElement(direccionDestinatarioParagraph);

            Paragraph localidadDestinatarioParagraph = new Paragraph("LOCALIDAD: " + localidadDestinatario, fontR);
            localidadDestinatarioParagraph.setAlignment(Element.ALIGN_LEFT);
            destinatarioCell.addElement(localidadDestinatarioParagraph);

            Paragraph telDestinatarioParagraph = new Paragraph("TELEFONO: " + telDestinatario, fontR);
            telDestinatarioParagraph.setAlignment(Element.ALIGN_LEFT);
            destinatarioCell.addElement(telDestinatarioParagraph);

            Paragraph cuitDestinatarioParagraph = new Paragraph("CUIT: " + cuitDestinatario, fontR);
            cuitDestinatarioParagraph.setAlignment(Element.ALIGN_LEFT);
            destinatarioCell.addElement(cuitDestinatarioParagraph);

            destinatarioCell.setHorizontalAlignment(Element.ALIGN_LEFT); // Alineación horizontal de la celda
            tablaContenedora.addCell(destinatarioCell);

            document.add(tablaContenedora);

            // Agregar espacio arriba de la tabla
            Paragraph espacio = new Paragraph(1f, " "); // 20f es el tamaño del espacio
            document.add(espacio);

            // Crear la tabla con 6 columnas
            PdfPTable tablaa = new PdfPTable(6);
            tablaa.setWidthPercentage(100);

            // Establecer el borde de las celdas de las filas como NO_BORDER
            PdfPCell bordeTop = new PdfPCell();
            bordeTop.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.RIGHT);
            PdfPCell celdaConBorde = new PdfPCell();
            celdaConBorde.setBorder(Rectangle.BOTTOM | Rectangle.LEFT | Rectangle.RIGHT);

            // Agregar las celdas a la tabla
            tablaa.addCell(createCell("Descripción", font, bordeTop));
            tablaa.addCell(createCell("Seguro", font, bordeTop));
            tablaa.addCell(createCell("Comision contrarrembolso", font, bordeTop));
            tablaa.addCell(createCell("Redespacho", font, bordeTop));
            tablaa.addCell(createCell("Valor Declarado", font, bordeTop));
            tablaa.addCell(createCell("Observaciones", font, bordeTop));

            // Obtener los valores de los campos de texto
            String descripcion = txtBulto.getText() + " bultos";
            String observaciones = txtObservaciones.getText();
            String seguro = txtSeguro.getText();
            String comContrarembolso = txtContrarembolso.getText();
            String redespacho = txtRedespacho.getText();
            String valDeclarado = txtValDeclarado.getText();

            // Agregar los valores a la tabla
            tablaa.addCell(createCell(descripcion, font, celdaConBorde));
            tablaa.addCell(createCell("$" + seguro, font, celdaConBorde)); // Columna "Seguro"
            tablaa.addCell(createCell("$" + comContrarembolso, font, celdaConBorde)); // Columna "Com. Contrarrembolso"
            tablaa.addCell(createCell("$" + redespacho, font, celdaConBorde)); // Columna "Redespacho"
            tablaa.addCell(createCell("$" + valDeclarado, font, celdaConBorde)); // Columna "Valor Declarado"
            tablaa.addCell(createCell(observaciones, font, celdaConBorde));

            // Agregar la tabla al documento
            document.add(tablaa);
            Paragraph recibenB = new Paragraph("SE RECIBEN LOS BULTOS SIN ESPECIFICAR SU CONTENIDO", fontR);
            recibenB.setAlignment(Element.ALIGN_CENTER);
            document.add(recibenB);
            // Crear la tabla con 2 columnas
            PdfPTable tabla = new PdfPTable(2);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{1, 0.5f}); // Ajustar el ancho de las columnas

            // Agregar la imagen a la primera celda
            PdfPCell imagenCell = new PdfPCell();
            InputStream firmaStream = getClass().getClassLoader().getResourceAsStream("imagenes/firma_aclaracion.png");
            Image firmasello = Image.getInstance(ImageIO.read(firmaStream), null);
            firmasello.scaleToFit(300, 200);
            firmasello.setAlignment(Element.ALIGN_LEFT);
            imagenCell.addElement(firmasello);
            imagenCell.setBorder(Rectangle.NO_BORDER);
            tabla.addCell(imagenCell);

            // Agregar el texto a la segunda celda
            String condicionFlete = cbCuentaCorriente.isSelected() ? "CUENTA CORRIENTE" : "CONTADO";
            String flete = "";
            if (cbfOrigen.isSelected()) {
                flete = "origen";
            } else if (cbfDestino.isSelected()) {
                flete = "destino";
            }

            PdfPCell textoCell = new PdfPCell();
            textoCell.setBorder(Rectangle.NO_BORDER);
            // Crear una tabla interna para el texto
            PdfPTable tablaTexto = new PdfPTable(1);
            tablaTexto.setWidthPercentage(100);

            // Crea una instancia personalizada de Font con tus preferencias
            Font fontPersonalizado = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);

            // Crea el párrafo con el texto y la fuente personalizada
            Paragraph c = new Paragraph("CONTRAREEMBOLSO: $" + txtMonto.getText() + ".0", fontPersonalizado);

            // Resto del código
            c.setAlignment(Element.ALIGN_LEFT);
            PdfPCell celdaC = new PdfPCell(c);
            celdaC.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP | Rectangle.BOTTOM);
            celdaC.setPadding(3f);
            celdaC.setPaddingBottom(4f);
            tablaTexto.addCell(celdaC);

            Paragraph b = new Paragraph("FLETE: $" + txtFlete.getText(), fontR);
            b.setAlignment(Element.ALIGN_LEFT);
            PdfPCell celdaB = new PdfPCell(b);
            celdaB.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM); // Agregar borde alrededor de la celda "b"
            celdaB.setPadding(1f); // Ajustar el relleno de la celda "b"
            celdaB.setPaddingBottom(4f); // Ajustar el relleno de la celda "b"
            tablaTexto.addCell(celdaB);

            // Crear una instancia personalizada de Font con subrayado y negrita
            Font fontSubrayadoNegrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD | Font.UNDERLINE, BaseColor.BLACK);
            Font fontNegrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);

            // Crear un Chunk con el texto "Condicion de venta:" y aplicarle el estilo de negrita
            Chunk textoCondicionVenta = new Chunk("Condicion de venta: ", fontNegrita);

            // Crear un Chunk con el texto de condicionFlete y aplicarle el estilo de subrayado y negrita
            Chunk condicionChunk = new Chunk(condicionFlete, fontSubrayadoNegrita);

            // Crear el Paragraph con los Chunks de "Condicion de venta:" y la variable condicionFlete
            Paragraph a = new Paragraph();
            a.add(textoCondicionVenta);
            a.add(condicionChunk); // Agregar el Chunk al Paragraph
            a.setAlignment(Element.ALIGN_RIGHT);

            PdfPCell celdaA = new PdfPCell(a);
            celdaA.setBorder(Rectangle.NO_BORDER);
            celdaA.setPaddingBottom(2);
            tablaTexto.addCell(celdaA);

            // Crear una instancia personalizada de Font con negrita y subrayado
            Font fontNegritaSubrayado = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD | Font.UNDERLINE, BaseColor.BLACK);

            // Crear un Chunk con el texto "Flete: a cobrar en" y aplicarle el estilo de negrita
            Chunk fleteChunk = new Chunk("Flete: a cobrar en ", FontFactory.getFont(FontFactory.TIMES_BOLD, 12));

            // Crear un Chunk con el texto de la variable flete y aplicarle el estilo de negrita y subrayado
            Chunk fleteValorChunk = new Chunk(flete, fontNegritaSubrayado);

            // Crear el Paragraph con los Chunks de "Flete: a cobrar en" y la variable flete
            Paragraph f = new Paragraph();
            f.add(fleteChunk);
            f.add(fleteValorChunk);
            f.setAlignment(Element.ALIGN_RIGHT);

            PdfPCell celdaF = new PdfPCell(f);
            celdaF.setBorder(Rectangle.NO_BORDER);
            celdaF.setPaddingBottom(2);
            tablaTexto.addCell(celdaF);

            Paragraph facturaremito = new Paragraph("Factura/Remito N°: " + txtRemito.getText(), fontR);
            facturaremito.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell celdafacturaremito = new PdfPCell(facturaremito);
            celdafacturaremito.setBorder(Rectangle.NO_BORDER); // Sin borde para la celda "f"
            celdafacturaremito.setPaddingBottom(2); // Ajustar el espacio inferior de la celda "f"
            tablaTexto.addCell(celdafacturaremito);

            double monto = Double.parseDouble(txtMonto.getText());
            double fletee = Double.parseDouble(txtFlete.getText());
            double seguroo = Double.parseDouble(txtSeguro.getText());
            double comContra = Double.parseDouble(txtContrarembolso.getText());
            double redespa = Double.parseDouble(txtRedespacho.getText());
            double valDecla = Double.parseDouble(txtValDeclarado.getText());
            double total = monto + fletee + seguroo + comContra + redespa + valDecla;
            Paragraph totalMonto = new Paragraph("TOTAL: $" + total, fontR);
            totalMonto.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell celdaTotal = new PdfPCell(totalMonto);
            celdaTotal.setBorder(Rectangle.NO_BORDER); // Sin borde para la celda "total"
            celdaTotal.setPaddingBottom(2); // Ajustar el espacio inferior de la celda "total"
            tablaTexto.addCell(celdaTotal);

            textoCell.addElement(tablaTexto);
            tabla.addCell(textoCell);

            // Ajustar el espacio entre las filas de la tabla
            tabla.setSpacingAfter(3);
            document.add(tabla);

            // Cerrar el template y añadirlo al contenido del documento
            template.closePathFillStroke();
            canvas.addTemplate(template, 20, 20);

            // Obtener el tamaño exacto del contenido
            float contentWidth = template.getWidth();
            float contentHeight = template.getHeight();

            // Crear un rectángulo que servirá como marco alrededor del contenido
            PdfContentByte canvasForBorders = writer.getDirectContentUnder();
            Rectangle marco = new Rectangle(20, 440, 20 + contentWidth, 20 + contentHeight);
            marco.setBorder(Rectangle.BOX); // Establecer el tipo de borde
            marco.setBorderWidth(1); // Establecer el ancho del borde
            marco.setBorderColor(BaseColor.BLACK); // Establecer el color del borde
            canvasForBorders.rectangle(marco);

            document.close();
            writer.close();

            // Clonar el contenido de la primera página y agregarlo debajo
            PDDocument pdfDocument = PDDocument.load(new File(outputPath));
            pdfDocument.addPage(pdfDocument.getPage(0));

            // Imprimir el archivo PDF automáticamente
            PrinterJob printerJob = PrinterJob.getPrinterJob();
            PDFPageable pageable = new PDFPageable(pdfDocument);
            printerJob.setPageable(pageable);
            printerJob.print();

            pdfDocument.close();

            JOptionPane.showMessageDialog(null, "El remito se generó e imprimió correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al generar o imprimir el remito.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void imprimirPDF(String rutaArchivoPDF) {
        try {
            // Cargamos el archivo PDF en un objeto File
            File pdfFile = new File(rutaArchivoPDF);

            // Verificamos si Desktop es compatible con esta plataforma
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();

                // Verificamos si el archivo PDF existe
                if (pdfFile.exists()) {
                    // Abrimos el archivo PDF con la aplicación predeterminada
                    desktop.print(pdfFile);
                } else {
                    // El archivo PDF no existe
                    JOptionPane.showMessageDialog(null, "El archivo PDF no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // La plataforma no admite Desktop, no se puede abrir la ventana de impresión
                JOptionPane.showMessageDialog(null, "La plataforma no admite la apertura de la ventana de impresión.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            // Error al intentar abrir el archivo PDF
            JOptionPane.showMessageDialog(null, "Error al abrir la ventana de impresión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método auxiliar para crear una celda con el contenido y fuente especificados
    private PdfPCell createCell(String text, Font font, PdfPCell cell) {
        PdfPCell newCell = new PdfPCell(new Phrase(text, font));
        newCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        newCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        newCell.setBorder(cell.getBorder());
        return newCell;
    }

    //remito
    private void guardarNumeroRemito() {
        try {
            // Crear un archivo de texto para almacenar el número de remito
            File archivo = new File("numeroremito.txt");

            // Escribir el valor del número de remito en el archivo
            FileWriter escritor = new FileWriter(archivo);
            escritor.write(Integer.toString(numeroRemito));
            escritor.close();
        } catch (IOException e) {
            // Manejar el error de escritura del archivo
            e.printStackTrace();
        }
    }

    private void cargarNumeroRemito() {
        try {
            // Abrir el archivo de texto para cargar el número de remito (si existe)
            File archivo = new File("numeroremito.txt");
            if (archivo.exists()) {
                // Leer el valor del número de recibo desde el archivo
                FileReader lector = new FileReader(archivo);
                BufferedReader buffer = new BufferedReader(lector);
                String linea = buffer.readLine();
                if (linea != null && !linea.isEmpty()) {
                    numeroRemito = Integer.parseInt(linea);
                }
                buffer.close();
            }
        } catch (IOException e) {
            // Manejar el error de lectura del archivo
            e.printStackTrace();
        }
    }

}
