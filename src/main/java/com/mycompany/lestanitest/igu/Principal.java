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
import java.awt.event.FocusListener;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
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
    private Cliente cliente;
    private Cliente destinatario;
    private Movimientos movimientoSeleccionado;
    private Servicios servicioSeleccionado;
    List<Cliente> listaClientes = control.traerClientes();
    List<Servicios> listaServ = control.getServicios();
    List<Representantes> listaRepresentantes = control.getRepresentantes();

    
    int numeroRemito = 0;
    private int idSeleccionado = -1; // Inicializado con un valor negativo para indicar que no se ha seleccionado ningún movimiento.    

    public Principal() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());
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
            //System.out.println("Fecha  válida: " + fechaFormateada);

        } catch (DateTimeException e) {
            // Manejar el caso en que la fecha no sea válida
            //System.out.println("Fecha inválida.");
        }

        TextPrompt filtroCl = new TextPrompt("Busqueda por Cliente, Destino o Remito", txtFiltroCliente);
        
         // Guardar el color original del botón
        Color originalColor = btnBuscarClienteYDestino.getBackground();
        Color lighterColor = originalColor.brighter();
        


        // Agregar un KeyListener al campo de texto para detectar la tecla Enter
        txtFiltroCliente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Cambiar el color del botón cuando se presiona Enter
                    btnBuscarClienteYDestino.setBackground(lighterColor);
                    // Forzar el botón a tomar el foco (esto dispara focusGained)
                    btnBuscarClienteYDestino.requestFocus();
                    // Simular un clic en el botón de búsqueda
                    btnBuscarClienteYDestino.doClick();
                }
            }
        });

        // Agregar un FocusListener al botón para detectar cuando obtiene y pierde el foco
        btnBuscarClienteYDestino.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Cambiar el color del botón cuando obtiene el foco
                btnBuscarClienteYDestino.setBackground(lighterColor);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Restaurar el color original del botón cuando pierde el foco
                btnBuscarClienteYDestino.setBackground(originalColor);
            }
        });

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
        textRepre.setNextFocusableComponent(btnAgregar);

        cbCuentaCorriente.setNextFocusableComponent(txtMonto);
        txtObservaciones.setNextFocusableComponent(btnAgregar);
        btnAgregar.setNextFocusableComponent(btnEliminarMovimiento);
        btnEliminarMovimiento.setNextFocusableComponent(btnGenerarRemito);
        btnGenerarRemito.setNextFocusableComponent(btnGenerarRemitoDuplicado);
        btnGenerarRemitoDuplicado.setNextFocusableComponent(btnRemitoTabla);
        btnRemitoTabla.setNextFocusableComponent(txtDia);
        
        //Text Area
        txtObservaciones.setLineWrap(true);
        txtObservaciones.setWrapStyleWord(true);

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
            txtContrarembolso.addFocusListener(focusAdapter);
            txtSeguro.addFocusListener(focusAdapter);
            txtRedespacho.addFocusListener(focusAdapter);
            txtValDeclarado.addFocusListener(focusAdapter);
           
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
            btnEliminarMovimiento.addFocusListener(focusAdapter);
            btnGenerarRemito.addFocusListener(focusAdapter);
            btnGenerarRemitoDuplicado.addFocusListener(focusAdapter);
            btnRemitoTabla.addFocusListener(focusAdapter);
        });
        
        //Editar 2click 
        tablaMovimientos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaMovimientos.getSelectedRow();
                if (filaSeleccionada != -1) {
                    int id = (int) tablaMovimientos.getValueAt(filaSeleccionada, 0);

                    // Realizar la acción deseada con el ID obtenido al dar un clic
                    System.out.println("ID seleccionado al dar un clic: " + id);
                    idSeleccionado = id;

                    if (e.getClickCount() == 2) {
                        // Acción a realizar cuando se haga doble clic en un elemento de la tabla
                        System.out.println("ID seleccionado al dar doble clic: " + id);
                        EditarMovimientos editar = new EditarMovimientos(id);
                        editar.setVisible(true);
                        editar.setLocationRelativeTo(null);
                    }
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
                    // Mostrar una alerta solo si la cadena no contiene solo números y puntos decimales

                    if (!textField.getText().matches("[\\d]*(\\.[\\d]*)?") || c == ',') {
                        JOptionPane.showMessageDialog(null, "Solo se permiten números y puntos decimales.", "Error", JOptionPane.ERROR_MESSAGE);
                        e.consume();
                    }
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
        comboBox.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                SwingUtilities.invokeLater(() -> {
                    JTextField editor = (JTextField) comboBox.getEditor().getEditorComponent();
                    editor.selectAll();
                });
            }
        });

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    JTextField editor = (JTextField) comboBox.getEditor().getEditorComponent();
                    editor.selectAll();
                });
            }
        });
    }

    //Actualizar flete nuevo
    private void actualizarFlete() {
        String bultoText = txtBulto.getText().trim();
        if (!bultoText.isEmpty()) {
            int bulto = Integer.parseInt(bultoText);


            // Buscar el servicio correspondiente en la lista
            Object selectedItem = cbServicios.getSelectedItem();
            if (selectedItem != null) {
                String nombreServicio = selectedItem.toString().trim().toLowerCase();

                for (Servicios s : listaServ) {
                    if (s.getServicio().toLowerCase().equals(nombreServicio)) {
                        // Calcular el flete multiplicando el precio del servicio por la cantidad de bultos
                        Double precioDouble = s.getPrecio(); // Utiliza el Double directamente
                        BigDecimal precio = BigDecimal.valueOf(precioDouble);
                        BigDecimal montoFlete = precio.multiply(BigDecimal.valueOf(bulto));

                        // Formatear el montoFlete como cadena sin decimales ".0"
                        String montoFleteStr = String.format("%.0f", montoFlete.doubleValue());

                        // Mostrar el montoFlete en el campo txtFlete
                        txtFlete.setText(montoFleteStr);

                        return;
                    }
                }
            } else {
                // Handle the case where no item is selected
                // Maybe display an error message or set a default value for txtFlete
                // For example, if txtFlete is a JTextField, you could set it to an empty string:
                txtFlete.setText("");
            }
        }
    }

 
    
 
    
    
    
    
/*CODIGO VIEJO (ANDA)
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
*/
    private void cargarDestinos() {
      

        cbDestinos.setEditable(true);

        // Ordenar la lista de clientes alfabéticamente por el nombre
        listaClientes.sort((cliente1, cliente2) -> cliente1.getNombre().compareToIgnoreCase(cliente2.getNombre()));

        // Limpiar el ComboBox
        cbDestinos.removeAllItems();

        // Agregar los nombres de los clientes al ComboBox de forma ordenada
        for (Cliente cliente : listaClientes) {
            cbDestinos.addItem(cliente.getNombre());
        }

        // Establecer el índice seleccionado a -1 para no mostrar ninguna selección
        cbDestinos.setSelectedIndex(-1);

        // Agregar KeyListener al editor del JComboBox
        cbDestinos.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_TAB) {
                    autoCompletarDestino(cbDestinos);
                    cbDestinos.setPopupVisible(false); // Cerrar el popup después de seleccionar el cliente
                    e.consume(); // Consumir el evento para evitar que se procese nuevamente
                } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
                    cbDestinos.setPopupVisible(false);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP) {
                    cbDestinos.setPopupVisible(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No realizar la búsqueda si se está usando las teclas de flecha
                if (e.getKeyCode() != KeyEvent.VK_DOWN && e.getKeyCode() != KeyEvent.VK_UP) {
                    // Realizar la búsqueda cada vez que se libera una tecla
                    realizarBusquedaDestinos();
                     if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_TAB) {
                    autoCompletarDestino(cbDestinos);  
                    cbDestinos.setPopupVisible(false); // Cerrar el popup después de seleccionar el cliente
                    
                }
                    
                }
            }
        });

        // Agregar ActionListener para manejar la selección del ComboBox
        cbDestinos.addActionListener(e -> {
            if (cbDestinos.isPopupVisible()) {
                seleccionarDestino(cbDestinos.getSelectedItem().toString());
            }
        });
    }
    
    
    // Método para realizar la búsqueda
    private void realizarBusquedaDestinos() {
        // Obtener el texto ingresado por el usuario
        String textoBusqueda = cbDestinos.getEditor().getItem().toString().toUpperCase();

        // Si el texto de búsqueda está vacío, establecer el ComboBox en blanco y salir del método
        if (textoBusqueda.isEmpty()) {
            cbDestinos.setPopupVisible(false);
            return;
        }

        // Obtener el modelo del ComboBox
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        // Buscar resultados de búsqueda exacta
        boolean encontradoExacta = false;

        for (Cliente cliente : listaClientes) {
            String nombreCliente = cliente.getNombre().toUpperCase();
            if (nombreCliente.equals(textoBusqueda)) {
                model.addElement(cliente.getNombre());
                encontradoExacta = true;
                break; // Terminar la búsqueda cuando se encuentra una coincidencia exacta
            }
        }

        // Si no se encontró una coincidencia exacta, buscar coincidencias parciales
        if (!encontradoExacta) {
            for (Cliente cliente : listaClientes) {
                String nombreCliente = cliente.getNombre().toUpperCase();
                if (nombreCliente.contains(textoBusqueda)) {
                    model.addElement(cliente.getNombre());
                }
            }
        }

        // Actualizar el modelo del ComboBox
        cbDestinos.setModel(model);
        cbDestinos.getEditor().setItem(textoBusqueda);

        // Mostrar el menú desplegable si hay resultados
        cbDestinos.setPopupVisible(model.getSize() > 0);
    }

    // Método para seleccionar el cliente en el ComboBox
    private void seleccionarDestino(String nombreCliente) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                this.destinatario = cliente;
                cbDestinos.setSelectedItem(cliente.getNombre());
                System.out.println(this.destinatario);
                break;
            }
        }
    }

   private void cargarServicios() {

        cbServicios.setEditable(true);
        // Ordenar la lista de clientes alfabéticamente por el nombre
        listaServ.sort((servicio1, servicio2) -> servicio1.getServicio().compareToIgnoreCase(servicio2.getServicio()));

        // Agregar los clientes al combobox
        for (Servicios Servicios : listaServ) {
            cbServicios.addItem(Servicios.getServicio());
        }

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

         // Agregar KeyListener al editor del JComboBox
        cbRepresentantes.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_TAB) {
                    autoCompletarRepresentante(cbRepresentantes);  
                    cbRepresentantes.setPopupVisible(false); // Cerrar el popup después de seleccionar el Representante
                    
                } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
                    cbRepresentantes.setPopupVisible(false);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP) {
                    cbRepresentantes.setPopupVisible(true);
                    
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No realizar la búsqueda si se está usando las teclas de flecha
                if (e.getKeyCode() != KeyEvent.VK_DOWN && e.getKeyCode() != KeyEvent.VK_UP) {
                    // Realizar la búsqueda cada vez que se libera una tecla
                    realizarBusquedaRepresentantes();
                     if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_TAB) {
                    autoCompletarRepresentante(cbRepresentantes);  
                    cbRepresentantes.setPopupVisible(false); // Cerrar el popup después de seleccionar el Representante
                    
                }
                    
                }
            }
        });
 
    }
    
    // Método para realizar la búsqueda
    private void realizarBusquedaRepresentantes() {
        // Obtener el texto ingresado por el usuario
        String textoBusqueda = cbRepresentantes.getEditor().getItem().toString().toUpperCase();

        // Si el texto de búsqueda está vacío, establecer el ComboBox en blanco y salir del método
        if (textoBusqueda.isEmpty()) {
            cbRepresentantes.setPopupVisible(false);
            return;
        }

        // Obtener el modelo del ComboBox
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        // Buscar resultados de búsqueda exacta
        boolean encontradoExacta = false;

        for (Representantes repre : listaRepresentantes) {
            String nombreCliente = repre.getNombre().toUpperCase();
            if (nombreCliente.equals(textoBusqueda)) {
                model.addElement(repre.getNombre());
                encontradoExacta = true;
                break; // Terminar la búsqueda cuando se encuentra una coincidencia exacta
            }
        }

        // Si no se encontró una coincidencia exacta, buscar coincidencias parciales
        if (!encontradoExacta) {
            for (Representantes repre : listaRepresentantes) {
                String nombreRepre = repre.getNombre().toUpperCase();
                if (nombreRepre.contains(textoBusqueda)) {
                    model.addElement(repre.getNombre());
                }
            }
        }

        // Actualizar el modelo del ComboBox
        cbRepresentantes.setModel(model);
        cbRepresentantes.getEditor().setItem(textoBusqueda);

        // Mostrar el menú desplegable si hay resultados
        cbRepresentantes.setPopupVisible(model.getSize() > 0);
        
    }

   // Método para inicializar y cargar clientes en el ComboBox
    private void cargarClientes() {
        cbClientes.setEditable(true);

        // Ordenar la lista de clientes alfabéticamente por el nombre
        listaClientes.sort((cliente1, cliente2) -> cliente1.getNombre().compareToIgnoreCase(cliente2.getNombre()));

        // Limpiar el ComboBox
        cbClientes.removeAllItems();

        // Agregar los nombres de los clientes al ComboBox de forma ordenada
        for (Cliente cliente : listaClientes) {
            cbClientes.addItem(cliente.getNombre());
        }

        // Establecer el índice seleccionado a -1 para no mostrar ninguna selección
        cbClientes.setSelectedIndex(-1);

        // Agregar KeyListener al editor del JComboBox
        cbClientes.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_TAB) {
                    autoCompletarCliente(cbClientes);  
                    cbClientes.setPopupVisible(false); // Cerrar el popup después de seleccionar el cliente
                    
                } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
                    cbClientes.setPopupVisible(false);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP) {
                    cbClientes.setPopupVisible(true);
                    
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No realizar la búsqueda si se está usando las teclas de flecha
                if (e.getKeyCode() != KeyEvent.VK_DOWN && e.getKeyCode() != KeyEvent.VK_UP) {
                    // Realizar la búsqueda cada vez que se libera una tecla
                    realizarBusquedaClientes();
                     if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_TAB) {
                    autoCompletarCliente(cbClientes);  
                    cbClientes.setPopupVisible(false); // Cerrar el popup después de seleccionar el cliente
                    
                }
                    
                }
            }
        });

        // Agregar ActionListener para manejar la selección del ComboBox
        cbClientes.addActionListener(e -> {
            if (cbClientes.isPopupVisible()) {
                seleccionarCliente(cbClientes.getSelectedItem().toString());
            }
        });
    }

    // Método para realizar la búsqueda
    private void realizarBusquedaClientes() {
        // Obtener el texto ingresado por el usuario
        String textoBusqueda = cbClientes.getEditor().getItem().toString().toUpperCase();

        // Si el texto de búsqueda está vacío, establecer el ComboBox en blanco y salir del método
        if (textoBusqueda.isEmpty()) {
            cbClientes.setPopupVisible(false);
            return;
        }

        // Obtener el modelo del ComboBox
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        // Buscar resultados de búsqueda exacta
        boolean encontradoExacta = false;

        for (Cliente cliente : listaClientes) {
            String nombreCliente = cliente.getNombre().toUpperCase();
            if (nombreCliente.equals(textoBusqueda)) {
                model.addElement(cliente.getNombre());
                encontradoExacta = true;
                break; // Terminar la búsqueda cuando se encuentra una coincidencia exacta
            }
        }

        // Si no se encontró una coincidencia exacta, buscar coincidencias parciales
        if (!encontradoExacta) {
            for (Cliente cliente : listaClientes) {
                String nombreCliente = cliente.getNombre().toUpperCase();
                if (nombreCliente.contains(textoBusqueda)) {
                    model.addElement(cliente.getNombre());
                }
            }
        }

        // Actualizar el modelo del ComboBox
        cbClientes.setModel(model);
        cbClientes.getEditor().setItem(textoBusqueda);

        // Mostrar el menú desplegable si hay resultados
        cbClientes.setPopupVisible(model.getSize() > 0);
    }

    // Método para seleccionar el cliente en el ComboBox
    private void seleccionarCliente(String nombreCliente) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                this.cliente = cliente;
                cbClientes.setSelectedItem(cliente.getNombre());
                System.out.println(this.cliente);
                break;
            }
        }
    }

    // Método para auto-completar el cliente seleccionado en el ComboBox
    private void autoCompletarCliente(JComboBox<String> combobox) {
        String nombreCliente = (String) combobox.getSelectedItem();
        combobox.getEditor().setItem(nombreCliente);
        seleccionarCliente(nombreCliente); // Seleccionar el cliente en la variable
    }
    
     // Método para auto-completar el cliente seleccionado en el ComboBox
    private void autoCompletarDestino(JComboBox<String> combobox) {
         String nombreDestino = (String) combobox.getSelectedItem();
    
    // Verificar si el cliente seleccionado está en la lista de clientes cargados
    boolean clienteValido = listaClientes.stream()
            .anyMatch(cliente -> cliente.getNombre().equalsIgnoreCase(nombreDestino));
    
    // Si el cliente es válido, proceder con la selección
    if (clienteValido) {
        combobox.getEditor().setItem(nombreDestino);
        seleccionarDestino(nombreDestino); // Seleccionar el cliente en la variable
    }
    }
    
    // Método para auto-completar el cliente seleccionado en el ComboBox
    private void autoCompletarRepresentante(JComboBox<String> combobox) {
        String nombreRepresentante = (String) combobox.getSelectedItem();
        combobox.getEditor().setItem(nombreRepresentante);
        
    }
    
 
    
        // Método para mostrar los resultados de la búsqueda
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





        
        
       
        

        //Codigo viejo (anda)
        /*
        // Agregar ActionListener para capturar el evento "Enter"
        cbClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoBusqueda = cbClientes.getEditor().getItem().toString();
                mostrarResultadosBusqueda(cbClientes, textoBusqueda);
                if (cbClientes.getSelectedIndex() != -1) {
                    // Normaliza el texto de búsqueda a mayúsculas
                    textoBusqueda = textoBusqueda.toUpperCase();

                    cliente = null; // Restablece el destinatario seleccionado
                    for (Cliente cliente : listaClientes) {
                        if (cliente.getNombre().toUpperCase().equals(textoBusqueda)) {
                            Principal.this.cliente = cliente;

                            break;
                        }
                    }
                }
            }
        });
        
        */
        
    
   

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
        btnRemitoTabla = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        PanelBusquedas = new javax.swing.JPanel();
        txtFiltroCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarClienteYDestino = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

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
        panelCargaMovimientos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
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
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        cbClientes.setForeground(new java.awt.Color(0, 0, 0));
        cbClientes.setMaximumRowCount(6);
        cbClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClientesActionPerformed(evt);
            }
        });

        cbDestinos.setForeground(new java.awt.Color(0, 0, 0));
        cbDestinos.setMaximumRowCount(6);

        cbServicios.setForeground(new java.awt.Color(0, 0, 0));
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
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        cbRepresentantes.setMaximumRowCount(6);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(236, 240, 241));
        jLabel8.setText("Representante");

        btnRemitoTabla.setBackground(new java.awt.Color(51, 51, 51));
        btnRemitoTabla.setForeground(new java.awt.Color(255, 255, 255));
        btnRemitoTabla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/imprimir_16px.png"))); // NOI18N
        btnRemitoTabla.setText("Generar Remito");
        btnRemitoTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemitoTablaActionPerformed(evt);
            }
        });

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        jScrollPane1.setViewportView(txtObservaciones);

        javax.swing.GroupLayout panelCargaMovimientosLayout = new javax.swing.GroupLayout(panelCargaMovimientos);
        panelCargaMovimientos.setLayout(panelCargaMovimientosLayout);
        panelCargaMovimientosLayout.setHorizontalGroup(
            panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbDestinos, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(btnAgregarCliente)
                                .addGap(54, 54, 54))
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(cbServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel10))
                                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(bulto)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCuentaCorriente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbRepresentantes, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(45, 45, 45)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnGenerarRemito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(btnEliminarMovimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(btnGenerarRemitoDuplicado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRemitoTabla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        panelCargaMovimientosLayout.setVerticalGroup(
            panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCargaMovimientosLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                                .addComponent(btnEliminarMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGenerarRemito, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGenerarRemitoDuplicado, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRemitoTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbDestinos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bulto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 6, Short.MAX_VALUE))
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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Busquedas");

        btnBuscarClienteYDestino.setBackground(new java.awt.Color(51, 51, 51));
        btnBuscarClienteYDestino.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnBuscarClienteYDestino.setForeground(new java.awt.Color(236, 240, 241));
        btnBuscarClienteYDestino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/busqueda-de-lupa.png"))); // NOI18N
        btnBuscarClienteYDestino.setText("Buscar");
        btnBuscarClienteYDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteYDestinoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBusquedasLayout = new javax.swing.GroupLayout(PanelBusquedas);
        PanelBusquedas.setLayout(PanelBusquedasLayout);
        PanelBusquedasLayout.setHorizontalGroup(
            PanelBusquedasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedasLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(PanelBusquedasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBusquedasLayout.createSequentialGroup()
                        .addComponent(txtFiltroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarClienteYDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        PanelBusquedasLayout.setVerticalGroup(
            PanelBusquedasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedasLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelBusquedasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarClienteYDestino)
                    .addComponent(txtFiltroCliente))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        btnActualizar.setBackground(new java.awt.Color(51, 51, 51));
        btnActualizar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(236, 240, 241));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
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
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(PanelBusquedas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(537, Short.MAX_VALUE))
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
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelBusquedas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE))
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
       /* String cliente = txtFiltroCliente.getText();
        List<Movimientos> clientes = control.getClientes(cliente);
        trs = new TableRowSorter(tablaMovimientos.getModel());
        tablaMovimientos.setRowSorter(trs);

        txtFiltroCliente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String textoFiltro = txtFiltroCliente.getText();
                // Crear un filtro que busque en las columnas "Clientes" (columna 3) y "Destinos" (columna 4)
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + textoFiltro, 3, 4));
            }
        });
*/

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

               
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        cargarNumeroRemito();
        List<Movimientos> movimientosFiltrados = control.getMovimientos();
        
    actualizarTablaMovimientos(movimientosFiltrados);
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
    } else {
        // Si no es después de las 17:00 horas, simplemente asigna la fecha actual
        txtDia.setText(String.valueOf(now.getDayOfMonth()));
        txtMes.setText(String.valueOf(now.getMonthValue()));
        txtAnio.setText(String.valueOf(now.getYear()));
    }
       

        if (cbfDestino.isSelected()) {
            cbfDestino.setSelected(false);
        }
        if (cbfOrigen.isSelected()) {
            cbfOrigen.setSelected(false);
        }
        if (cbCuentaCorriente.isSelected()) {
            cbCuentaCorriente.setSelected(false);
        }
        if (cbmontoPagado.isSelected()) {
            cbmontoPagado.setSelected(false);
        }
         if (cbMontoRendido.isSelected()) {
            cbMontoRendido.setSelected(false);
        }
         if (cbfletePagado.isSelected()) {
            cbfletePagado.setSelected(false);
        }
        if (cbfleteRendido.isSelected()) {
            cbfleteRendido.setSelected(false);
        }
        cargarClientes();
        cargarDestinos();
        cargarRepresentantes();
        cargarServicios();

    //cbServicios.removeItem("");
    cbServicios.getEditor().setItem("");
    txtBulto.setText("1");
        txtMonto.setText("0");
        txtFlete.setText("0");
        txtSeguro.setText("0");
        txtContrarembolso.setText("0");
        txtRedespacho.setText("0");
        txtValDeclarado.setText("0");
        txtObservaciones.setText("");
        
    listaClientes = control.traerClientes();
    listaServ = control.getServicios();
    listaRepresentantes = control.getRepresentantes();


    }                                        
private DefaultTableModel tablaModelo; // Declarar como campo de clase para reutilización

private void actualizarTablaMovimientos(List<Movimientos> movimientos) {
    DefaultTableModel tablaModelo = (DefaultTableModel) tablaMovimientos.getModel();
    tablaModelo.setRowCount(0); // Limpiar filas existentes

    if (movimientos != null && !movimientos.isEmpty()) {
        // Ordenar los datos por el ID en forma descendente
        Collections.sort(movimientos, Comparator.comparingInt(Movimientos::getId_movimientos).reversed());

        // Agregar datos a la tabla
        for (Movimientos mov : movimientos) {
            Object[] objeto = {
                mov.getId_movimientos(), 
                mov.getHora(), 
                mov.getFechaFormateada(), 
                mov.getCliente(), 
                mov.getDestino(), 
                mov.getRemito(), 
                mov.getBultos(), 
                mov.getMonto(), 
                mov.getTipoMontoP(), 
                mov.getTipoMontoR(), 
                mov.getFlete(), 
                mov.getTipoFleteP(), 
                mov.getTipoFleteR(), 
                mov.getFleteDestinoOrigen(), 
                mov.getRepresentante(), 
                mov.getCuentaCorriente(), 
                mov.getObservaciones()
            };
            tablaModelo.addRow(objeto);
        }
    } else {
        // Manejo caso donde no hay datos para mostrar
        System.out.println("No hay datos para mostrar en la tabla.");
    }
}





    private void btnRemitoTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemitoTablaActionPerformed
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        Movimientos mov = new Movimientos();
        if (idSeleccionado != -1) {
            // Busco id en la bd
            mov = control.traerMovimiento(idSeleccionado);

            // Debes implementar el código para acceder a tu base de datos y obtener los datos del cliente y destino
            String cliente = mov.getCliente();
            String destino = mov.getDestino();
            String fecha = formatoFecha.format(mov.getFecha());
            String servicio = mov.getServicio();
            String bulto = Integer.toString(mov.getBultos());
            String representante = mov.getRepresentante();
            String remito = mov.getRemito();

            // Eliminar el símbolo "$" y el formato de los campos monto y flete
            String montoSinSimbolo = mov.getMonto().replaceAll("[$]", "");
            String fleteSinSimbolo = mov.getFlete().replaceAll("[$]", "");

            // Aplicar el formateo para que los números tengan el formato correcto
            String montoFormateado = montoSinSimbolo.replace(".", "").replace(",", ".");
            String fleteFormateado = fleteSinSimbolo.replace(".", "").replace(",", ".");

            // Crear objetos BigDecimal a partir de las cadenas formateadas
            BigDecimal montoBigDecimal = new BigDecimal(montoFormateado);
            BigDecimal fleteBigDecimal = new BigDecimal(fleteFormateado);

            // Asignar los valores de los BigDecimal a los campos de texto
            String monto = montoBigDecimal.toString();
            String flete = fleteBigDecimal.toString();

            String obs = mov.getObservaciones();
            String origenDestino = mov.getFleteDestinoOrigen();
            String cc = mov.getCuentaCorriente();

            boolean cuentaCorriente;

            if (remito.equals("0")) {
                // Usando String.valueOf()
                remito = String.valueOf(numeroRemito + 1);
                // Actualizar la tabla en la base de datos
                if (remito.equals("0")) {
                    // Incrementar el número de remito
                    int nuevoNumeroRemito = numeroRemito + 1;
                    remito = String.valueOf(nuevoNumeroRemito);
                    //numeroRemito++;
                }

            } else {

                // Asignar el valor de txtRemito a remito si no es igual a "0"
                remito = remito;
                System.out.println("remito else " + remito);
                // JOptionPane.showMessageDialog(null, "El valor de remito no puede ser 0", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if ("Si".equalsIgnoreCase(cc)) {
                cuentaCorriente = true;
            } else if ("No".equalsIgnoreCase(cc)) {
                cuentaCorriente = false;
            } else {
                // Manejar un caso no válido si es necesario
                cuentaCorriente = false; // Puedes asignar un valor predeterminado
            }
            System.out.println("cuenta corriente:");
            System.out.println(cuentaCorriente);

            String montoPagado = mov.getTipoMontoP();
            String montoRendido = mov.getTipoMontoR();
            String fletePagado = mov.getTipoFleteP();
            String fleteRendido = mov.getTipoFleteR();

            control.editarMovimiento(mov, remito);
            generarRemito(fecha, cliente, destino, servicio, remito, bulto, representante, monto, montoPagado, montoRendido, flete, fletePagado, fleteRendido, origenDestino, cuentaCorriente, obs);

        } else {
            // No hay ningún ID seleccionado en la tabla, muestra un JOptionPane
            JOptionPane.showMessageDialog(this, "Selecciona algún movimiento en la tabla", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnRemitoTablaActionPerformed

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed

    }//GEN-LAST:event_txtMontoActionPerformed

    private void txtValDeclaradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValDeclaradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValDeclaradoActionPerformed

    private void txtBultoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBultoActionPerformed

    }//GEN-LAST:event_txtBultoActionPerformed

    private void txtRemitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRemitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRemitoActionPerformed

    private void cbServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbServiciosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbServiciosActionPerformed

    private void cbClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbClientesActionPerformed

    private void btnGenerarRemitoDuplicadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarRemitoDuplicadoActionPerformed
        cargarNumeroRemito();

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
        // Obtener el valor del campo de texto txtRemito
        String textoRemito = txtRemito.getText();

        if (!textoRemito.equals("0")) {
            // Asignar el valor de txtRemito a remito si no es igual a "0"
            remito = textoRemito;
        } else {

            // Usando String.valueOf()
            remito = String.valueOf(numeroRemito + 1);
            numeroRemito++;
            // JOptionPane.showMessageDialog(null, "El valor de remito no puede ser 0", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Si hay campos faltantes, mostrar el mensaje de alerta
        if (!txtMontoValor.isEmpty()) {
            monto = txtMontoValor;
        } else {
            monto = "0";
        }
        String fleteTexto = txtFlete.getText();
        BigDecimal flete = new BigDecimal(fleteTexto);
        String sTexto = txtSeguro.getText();
        String rTexto = txtRedespacho.getText();
        String ccTexto = txtContrarembolso.getText();
        BigDecimal s = new BigDecimal(sTexto);
        BigDecimal r = new BigDecimal(rTexto);
        BigDecimal cc = new BigDecimal(ccTexto);
        BigDecimal resultado = flete.add(s).add(r).add(cc);
        String fletenuevo = resultado.toString();

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

        control.cargarMovimiento(cliente, destino, servicio, representante, bulto, monto, fletenuevo, tFlete, remito, tMontoP, tMontoR, tFleteP, tFleteR, fecha, cC, obs, horaSQL, numeroRemito);
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

    private void btnGenerarRemitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarRemitoActionPerformed
        cargarNumeroRemito();
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
        // Obtener el valor del campo de texto txtRemito
        String textoRemito = txtRemito.getText();

        if (!textoRemito.equals("0")) {
            // Asignar el valor de txtRemito a remito si no es igual a "0"
            remito = textoRemito;
        } else {

            // Usando String.valueOf()
            remito = String.valueOf(numeroRemito + 1);
            numeroRemito++;
            // JOptionPane.showMessageDialog(null, "El valor de remito no puede ser 0", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Si hay campos faltantes, mostrar el mensaje de alerta
        if (!txtMontoValor.isEmpty()) {
            monto = txtMontoValor;
        } else {
            monto = "0";
        }
        String fleteTexto = txtFlete.getText();
        BigDecimal flete = new BigDecimal(fleteTexto);
        String sTexto = txtSeguro.getText();
        String rTexto = txtRedespacho.getText();
        String ccTexto = txtContrarembolso.getText();
        BigDecimal s = new BigDecimal(sTexto);
        BigDecimal r = new BigDecimal(rTexto);
        BigDecimal cc = new BigDecimal(ccTexto);
        BigDecimal resultado = flete.add(s).add(r).add(cc);
        String fletenuevo = resultado.toString();

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
        
        control.cargarMovimiento(cliente, destino, servicio, representante, bulto, monto, fletenuevo, tFlete, remito, tMontoP, tMontoR, tFleteP, tFleteR, fecha, cC, obs, horaSQL,numeroRemito);
        //mostrarMensaje("Movimiento agregado correctamente", "Info", "Agregado con exito!");

        //Llama la funcion generar
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

    private void cbfOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbfOrigenActionPerformed
        String tFlete = "";
        if (cbfOrigen.isSelected()) {
            cbfDestino.setSelected(false);
            tFlete = "Origen";
        }
    }//GEN-LAST:event_cbfOrigenActionPerformed

    private void cbfDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbfDestinoActionPerformed
        String tFlete = "";
        if (cbfDestino.isSelected()) {
            cbfOrigen.setSelected(false);
            tFlete = "Destino";
        }

    }//GEN-LAST:event_cbfDestinoActionPerformed

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

        String fleteTexto = txtFlete.getText();
        BigDecimal flete = new BigDecimal(fleteTexto);
        String sTexto = txtSeguro.getText();
        String rTexto = txtRedespacho.getText();
        String ccTexto = txtContrarembolso.getText();
        BigDecimal s = new BigDecimal(sTexto);
        BigDecimal r = new BigDecimal(rTexto);
        BigDecimal cc = new BigDecimal(ccTexto);
        BigDecimal resultado = flete.add(s).add(r).add(cc);
        String fletenuevo = resultado.toString();

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

        control.cargarMovimiento(cliente, destino, servicio, representante, bulto, monto, fletenuevo, tFlete, remito, tMontoP, tMontoR, tFleteP, tFleteR, fecha, cC, obs, horaSQL, numeroRemito);
        System.out.println("Movimiento agregado correctamente" + "Info" + "Agregado con exito!");

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

    private void cbCuentaCorrienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCuentaCorrienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCuentaCorrienteActionPerformed

    private void btnBuscarClienteYDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteYDestinoActionPerformed
         String texto = txtFiltroCliente.getText();
       List<Movimientos> movimientosFiltrados = control.getMovimientos(texto);
        
    actualizarTablaMovimientos(movimientosFiltrados);
    }//GEN-LAST:event_btnBuscarClienteYDestinoActionPerformed
    private PNuevoCliente ventanaCliente;
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
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnBuscarClienteYDestino;
    private javax.swing.JButton btnEliminarMovimiento;
    private javax.swing.JButton btnGenerarRemito;
    private javax.swing.JButton btnGenerarRemitoDuplicado;
    private javax.swing.JButton btnRemitoTabla;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelCargaMovimientos;
    private javax.swing.JTable tablaMovimientos;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtBulto;
    private javax.swing.JTextField txtContrarembolso;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtFiltroCliente;
    private javax.swing.JTextField txtFlete;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextArea txtObservaciones;
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

    private void generarRemito(String fecha, String clientee, String destinoo, String servicio, String remitoo, String bulto, String representantes,
            String monto, String montoPagado, String montoRendido, String flete, String fletePagado, String fleteRendido, String origenDestino, boolean cuentaCorriente, String obs) {

        Document document = new Document();

      

        String clienteSelect = clientee;
        String destinoSelect = destinoo;

        String nombreClienteImpresion = clienteSelect;
        // Buscar el cliente por nombre
        Cliente clienteEncontrado = null;
        for (Cliente cliente : listaClientes) {
            if (cliente.getNombre().equalsIgnoreCase(clienteSelect)) {
                clienteEncontrado = cliente;
                break; // Terminar el bucle una vez que se encuentra el cliente
            }
        }

        if (clienteEncontrado != null) {
            // El cliente fue encontrado, ahora puedes usar "clienteEncontrado" como un objeto Cliente
            // Realiza las acciones necesarias con el objeto cliente, por ejemplo:
            System.out.println("Nombre del cliente: " + clienteEncontrado.getNombre());
            System.out.println("Dirección: " + clienteEncontrado.getDireccion());
            // Y así sucesivamente...
        } else {
            // El cliente no fue encontrado en la lista
            System.out.println("Cliente no encontrado: " + clienteSelect);
        }

        Cliente destinoEncontrado = null;
        String nombreDestinoImpresion = destinoSelect; // Variable auxiliar para almacenar el nombre

        for (Cliente destino : listaClientes) {
            if (destino.getNombre().equalsIgnoreCase(destinoSelect)) {
                destinoEncontrado = destino;
                nombreDestinoImpresion = destino.getNombre(); // Actualiza el nombre desde el objeto Cliente
                break; // Terminar el bucle una vez que se encuentra el cliente
            }
        }

        if (destinoEncontrado != null) {
            // El cliente fue encontrado en la lista y destinoEncontrado contiene toda la información del cliente
            // Realiza las acciones necesarias con el objeto cliente, por ejemplo:
            System.out.println("Nombre del cliente: " + destinoEncontrado.getNombre());
            System.out.println("Dirección: " + destinoEncontrado.getDireccion());
            // Y así sucesivamente...
        } else {
            // El cliente no fue encontrado en la lista, pero aún tienes acceso al nombre almacenado en nombreDestinoImpresion
            System.out.println("Cliente no encontrado: " + nombreDestinoImpresion);
        }

        // Incrementar el contador de remito
        //numeroRemito++;
        int remitoInt = Integer.parseInt(remitoo);
        String numeroRemitoString = String.format("%08d", remitoInt);
        try {
            // Obtener la ruta del escritorio del usuario
            String userHome = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
            // Especificar la ruta de salida del archivo PDF en el escritorio
            String outputPath = userHome + File.separator + "archivo.pdf";

            // Crear el archivo de salida
            File outputFile = new File(outputPath);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputFile));

            document.open();

            // Crear una tabla que simule el marco
            PdfPTable tablaMarco = new PdfPTable(1);
            tablaMarco.setWidthPercentage(100);

            // Crea una celda para el contenido
            PdfPCell cellContenido = new PdfPCell();
            cellContenido.setBorder(Rectangle.BOX); // Establecer el borde de la celda
            cellContenido.setPadding(10);

            //FUENTES
            Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 8, Font.BOLD);
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
            //alpicar fecha 
            Chunk chunkFechas = new Chunk("Fecha: " + fecha, fontFecha);
            Paragraph dfecha = new Paragraph(chunkFechas);
            dfecha.setAlignment(Element.ALIGN_RIGHT);
            //REMITO NRO
            Paragraph nroRemito = new Paragraph("REMITO N° " + String.format("%08d", remitoInt), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD));
            //guardarNumeroRemito();
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

            // Celda 2: Remito
            PdfPCell cell2 = new PdfPCell(remito);
            cell2.addElement(dfecha);
            cell2.addElement(nroRemito);
            cell2.addElement(remito);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear a la derecha
            cell2.setVerticalAlignment(Element.ALIGN_RIGHT); // Alinear abajo
            cell2.setBorder(Rectangle.NO_BORDER); // Sin bordes
            table.addCell(cell2);

            //document.add(table);
            cellContenido.addElement(table);
            // Crear una tabla contenedora con 2 columnas
            PdfPTable tablaContenedora = new PdfPTable(2);
            tablaContenedora.setWidthPercentage(100);
            float[] columnWidths = {1, 1}; // Ajusta los valores según tu necesidad
            tablaContenedora.setWidths(columnWidths);

            PdfPCell remitenteCell = new PdfPCell();
            remitenteCell.setBorder(Rectangle.BOX);

            String nombreCliente = clienteEncontrado != null && clienteEncontrado.getNombre() != null
                    ? clienteEncontrado.getNombre().toUpperCase() : "";

            String direccion = clienteEncontrado != null && clienteEncontrado.getDireccion() != null
                    ? clienteEncontrado.getDireccion().toUpperCase()
                    : "";

            String localidad = clienteEncontrado != null && clienteEncontrado.getLocalidad() != null
                    ? clienteEncontrado.getLocalidad().toUpperCase()
                    : "";

            String cuit = clienteEncontrado != null && clienteEncontrado.getCuit() != null
                    ? clienteEncontrado.getCuit().toUpperCase()
                    : "";

            String tel = clienteEncontrado != null && clienteEncontrado.getTelefono() != null
                    ? clienteEncontrado.getTelefono().toUpperCase()
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

            String nombreDestinatario = nombreClienteImpresion;
            String direccionDestinatario = "";
            String localidadDestinatario = "";
            String cuitDestinatario = "";
            String telDestinatario = "";

            if (destinoEncontrado != null && destinoEncontrado.getDireccion() != null && destinoEncontrado.getLocalidad() != null
                    && destinoEncontrado.getCuit() != null && destinoEncontrado.getNombre() != null && destinoEncontrado.getTelefono() != null) {
                nombreDestinatario = destinoEncontrado.getNombre().toUpperCase();
                direccionDestinatario = destinoEncontrado.getDireccion().toUpperCase();
                localidadDestinatario = destinoEncontrado.getLocalidad().toUpperCase();
                cuitDestinatario = destinoEncontrado.getCuit().toUpperCase();
                telDestinatario = destinoEncontrado.getTelefono().toUpperCase();

            } else {
                nombreDestinatario = nombreDestinoImpresion;
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

            //document.add(tablaContenedora);
            cellContenido.addElement(tablaContenedora);
            // Agregar espacio arriba de la tabla
            Paragraph espacio = new Paragraph(1f, " "); // tamaño del espacio
            //document.add(espacio);
            cellContenido.addElement(espacio);
            
            // Crear la tabla con 6 columnas
            PdfPTable tablaa = new PdfPTable(6);
            tablaa.setWidthPercentage(100);

// Definir el ancho de las columnas
            float[] anchosColumnas = new float[]{1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 2.5f};
            tablaa.setWidths(anchosColumnas);

// Establecer el borde de las celdas de las filas como NO_BORDER
            PdfPCell bordeTop = new PdfPCell();
            bordeTop.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.RIGHT);
            bordeTop.setPadding(6f); // Ajusta el padding según sea necesario

            PdfPCell celdaConBorde = new PdfPCell();
            celdaConBorde.setBorder(Rectangle.BOTTOM | Rectangle.LEFT | Rectangle.RIGHT);
            celdaConBorde.setPadding(6f); // Ajusta el padding según sea necesario

// Agregar las celdas a la tabla
            tablaa.addCell(createCell("Descripción", font, bordeTop));
            tablaa.addCell(createCell("Seguro", font, bordeTop));
            tablaa.addCell(createCell("Comision contrarrembolso", font, bordeTop));
            tablaa.addCell(createCell("Redespacho", font, bordeTop));
            tablaa.addCell(createCell("Valor Declarado", font, bordeTop));
            tablaa.addCell(createCell("Observaciones", font, bordeTop));

// Obtener los valores de los campos de texto
            String descripcion = bulto + " bultos";
            String observaciones = obs;
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
//tablaa.addCell(createCell(observaciones, font, celdaConBorde)); //Columna "Observaciones"
            tablaa.addCell(createCellWithMultipleLines(observaciones, font, celdaConBorde));

// Agregar la tabla al documento
//document.add(tablaa);
            cellContenido.addElement(tablaa);
            
            
            //TEXTO
            Paragraph recibenB = new Paragraph("SE RECIBEN LOS BULTOS SIN ESPECIFICAR SU CONTENIDO", fontR);
            recibenB.setAlignment(Element.ALIGN_CENTER);
            //document.add(recibenB);
            cellContenido.addElement(recibenB);
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
            String condicionFlete = cuentaCorriente ? "CUENTA CORRIENTE" : "CONTADO";

            if (origenDestino == "origen") {
                origenDestino = "origen";
            } else if (origenDestino == "destino") {
                origenDestino = "destino";
            }

            PdfPCell textoCell = new PdfPCell();
            textoCell.setBorder(Rectangle.NO_BORDER);
            // Crear una tabla interna para el texto
            PdfPTable tablaTexto = new PdfPTable(1);
            tablaTexto.setWidthPercentage(100);

            // Crea una instancia personalizada de Font con tus preferencias
            Font fontPersonalizado = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);

            // Crea el párrafo con el texto y la fuente personalizada
            Paragraph c = new Paragraph("CONTRAREEMBOLSO: $" + monto, fontPersonalizado);

            // Resto del código
            c.setAlignment(Element.ALIGN_LEFT);
            PdfPCell celdaC = new PdfPCell(c);
            celdaC.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP | Rectangle.BOTTOM);
            celdaC.setPadding(3f);
            celdaC.setPaddingBottom(4f);
            tablaTexto.addCell(celdaC);

            Paragraph b = new Paragraph("FLETE: $" + flete, fontR);
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
            Chunk fleteValorChunk = new Chunk(origenDestino, fontNegritaSubrayado);

            // Crear el Paragraph con los Chunks de "Flete: a cobrar en" y la variable flete
            Paragraph f = new Paragraph();
            f.add(fleteChunk);
            f.add(fleteValorChunk);
            f.setAlignment(Element.ALIGN_RIGHT);

            PdfPCell celdaF = new PdfPCell(f);
            celdaF.setBorder(Rectangle.NO_BORDER);
            celdaF.setPaddingBottom(2);
            tablaTexto.addCell(celdaF);

            Paragraph facturaremito = new Paragraph("Factura/Remito N°: " + remitoo, fontR);
            facturaremito.setAlignment(Element.ALIGN_RIGHT);
            PdfPCell celdafacturaremito = new PdfPCell(facturaremito);
            celdafacturaremito.setBorder(Rectangle.NO_BORDER); // Sin borde para la celda "f"
            celdafacturaremito.setPaddingBottom(2); // Ajustar el espacio inferior de la celda "f"
            tablaTexto.addCell(celdafacturaremito);

            double dmonto = Double.parseDouble(monto);
            double fletee = Double.parseDouble(flete);
            //double seguroo = Double.parseDouble(txtSeguro.getText());
            //double comContra = Double.parseDouble(txtContrarembolso.getText());
            //double redespa = Double.parseDouble(txtRedespacho.getText());
            //double valDecla = Double.parseDouble(txtValDeclarado.getText());
            double total = dmonto + fletee;
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
            //document.add(tabla);
            cellContenido.addElement(tabla);

            tablaMarco.addCell(cellContenido);
            document.add(tablaMarco);

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
    
    
    private void generarPdf() {
        //bandera 1
        System.out.println(cliente);
        System.out.println(destinatario);
        Document document = new Document();

        // Incrementar el contador de remito
        //numeroRemito++;
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

            // Crear una tabla que simule el marco
            PdfPTable tablaMarco = new PdfPTable(1);
            tablaMarco.setWidthPercentage(100);

            // Crea una celda para el contenido
            PdfPCell cellContenido = new PdfPCell();
            cellContenido.setBorder(Rectangle.BOX); // Establecer el borde de la celda
            cellContenido.setPadding(10);

            //FUENTES
            Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 8, Font.BOLD);
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
            Paragraph nroRemito = new Paragraph("REMITO N° " + numeroRemitoString , FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD));
           // guardarNumeroRemito();
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

            cellContenido.addElement(table);
            // Crear una tabla contenedora con 2 columnas
            PdfPTable tablaContenedora = new PdfPTable(2);
            tablaContenedora.setWidthPercentage(100);
            float[] columnWidths = {1, 1}; // Ajusta los valores según tu necesidad
            tablaContenedora.setWidths(columnWidths);

            PdfPCell remitenteCell = new PdfPCell();
            remitenteCell.setBorder(Rectangle.BOX);

            String nombreCliente = cliente != null && cliente.getNombre() != null
                    ? cliente.getNombre().toUpperCase()
                    : cbClientes.getSelectedItem().toString().toUpperCase();

            String direccion = cliente != null && cliente.getDireccion() != null
                    ? cliente.getDireccion().toUpperCase()
                    : "";

            String localidad = cliente != null && cliente.getLocalidad() != null
                    ? cliente.getLocalidad().toUpperCase()
                    : cbDestinos.getSelectedItem().toString().toUpperCase();

            String cuit = cliente != null && cliente.getCuit() != null
                    ? cliente.getCuit().toUpperCase()
                    : "";

            String tel = cliente != null && cliente.getTelefono() != null
                    ? cliente.getTelefono().toUpperCase()
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
            System.out.println("Bandera 1 Destinatario en pdf: " + destinatario);

            String nombreDestinatario = "";
            String direccionDestinatario = "";
            String localidadDestinatario = "";
            String cuitDestinatario = "";
            String telDestinatario = "";
            

            if (destinatario != null && destinatario.getDireccion() != null && destinatario.getLocalidad() != null
                    && destinatario.getCuit() != null && destinatario.getNombre() != null && destinatario.getTelefono() != null) {
                nombreDestinatario = destinatario.getNombre().toUpperCase();
                direccionDestinatario = destinatario.getDireccion().toUpperCase();
                localidadDestinatario = destinatario.getLocalidad().toUpperCase();
                cuitDestinatario = destinatario.getCuit().toUpperCase();
                telDestinatario = destinatario.getTelefono().toUpperCase();

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

            //document.add(tablaContenedora);
            cellContenido.addElement(tablaContenedora);

            // Agregar espacio arriba de la tabla
            Paragraph espacio = new Paragraph(1f, " "); // tamaño del espacio
            //document.add(espacio);
            cellContenido.addElement(espacio);

               // Crear la tabla con 6 columnas
            PdfPTable tablaa = new PdfPTable(6);
            tablaa.setWidthPercentage(100);

// Definir el ancho de las columnas
            float[] anchosColumnas = new float[]{1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 2.5f};
            tablaa.setWidths(anchosColumnas);

// Establecer el borde de las celdas de las filas como NO_BORDER
            PdfPCell bordeTop = new PdfPCell();
            bordeTop.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.RIGHT);
            bordeTop.setPadding(6f); // Ajusta el padding según sea necesario

            PdfPCell celdaConBorde = new PdfPCell();
            celdaConBorde.setBorder(Rectangle.BOTTOM | Rectangle.LEFT | Rectangle.RIGHT);
            celdaConBorde.setPadding(6f); // Ajusta el padding según sea necesario

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
            //tablaa.addCell(createCell(observaciones, font, celdaConBorde)); //Columna "Observaciones"
            tablaa.addCell(createCellWithMultipleLines(observaciones, font,celdaConBorde));
            // Agregar la tabla al documento
            //document.add(tablaa);
            cellContenido.addElement(tablaa);

            Paragraph recibenB = new Paragraph("SE RECIBEN LOS BULTOS SIN ESPECIFICAR SU CONTENIDO", fontR);
            recibenB.setAlignment(Element.ALIGN_CENTER);
            //document.add(recibenB);
            cellContenido.addElement(recibenB);
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
            //double valDecla = Double.parseDouble(txtValDeclarado.getText());
            double total = monto + fletee + seguroo + comContra + redespa;
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
            //document.add(tabla);
            cellContenido.addElement(tabla);

            tablaMarco.addCell(cellContenido);
            document.add(tablaMarco);

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
        //numeroRemito++;
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

            // Crear una tabla que simule el marco
            PdfPTable tablaMarco = new PdfPTable(1);
            tablaMarco.setWidthPercentage(100);

            // Crea una celda para el contenido
            PdfPCell cellContenido = new PdfPCell();
            cellContenido.setBorder(Rectangle.BOX); // Establecer el borde de la celda
            cellContenido.setPadding(10);

            //FUENTES
            Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 8, Font.BOLD);
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
            //guardarNumeroRemito();
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

            //document.add(table);
            cellContenido.addElement(table);
            // Crear una tabla contenedora con 2 columnas
            PdfPTable tablaContenedora = new PdfPTable(2);
            tablaContenedora.setWidthPercentage(100);
            float[] columnWidths = {1, 1}; // Ajusta los valores según tu necesidad
            tablaContenedora.setWidths(columnWidths);

            PdfPCell remitenteCell = new PdfPCell();
            remitenteCell.setBorder(Rectangle.BOX);

            String nombreCliente = cliente != null && cliente.getNombre() != null
                    ? cliente.getNombre().toUpperCase()
                    : cbClientes.getSelectedItem().toString().toUpperCase();

            String direccion = cliente != null && cliente.getDireccion() != null
                    ? cliente.getDireccion().toUpperCase()
                    : "";

            String localidad = cliente != null && cliente.getLocalidad() != null
                    ? cliente.getLocalidad().toUpperCase()
                    : cbDestinos.getSelectedItem().toString().toUpperCase();

            String cuit = cliente != null && cliente.getCuit() != null
                    ? cliente.getCuit().toUpperCase()
                    : "";

            String tel = cliente != null && cliente.getTelefono() != null
                    ? cliente.getTelefono().toUpperCase()
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

            if (destinatario != null && destinatario.getDireccion() != null && destinatario.getLocalidad() != null
                    && destinatario.getCuit() != null && destinatario.getNombre() != null && destinatario.getTelefono() != null) {
                nombreDestinatario = destinatario.getNombre().toUpperCase();
                direccionDestinatario = destinatario.getDireccion().toUpperCase();
                localidadDestinatario = destinatario.getLocalidad().toUpperCase();
                cuitDestinatario = destinatario.getCuit().toUpperCase();
                telDestinatario = destinatario.getTelefono().toUpperCase();

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

            //document.add(tablaContenedora);
            cellContenido.addElement(tablaContenedora);
            // Agregar espacio arriba de la tabla
            Paragraph espacio = new Paragraph(1f, " "); // 20f es el tamaño del espacio
            //document.add(espacio);
            cellContenido.addElement(espacio);
            
            // Crear la tabla con 6 columnas
            PdfPTable tablaa = new PdfPTable(6);
            tablaa.setWidthPercentage(100);

// Definir el ancho de las columnas
            float[] anchosColumnas = new float[]{1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 2.5f};
            tablaa.setWidths(anchosColumnas);

// Establecer el borde de las celdas de las filas como NO_BORDER
            PdfPCell bordeTop = new PdfPCell();
            bordeTop.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.RIGHT);
            bordeTop.setPadding(6f); // Ajusta el padding según sea necesario

            PdfPCell celdaConBorde = new PdfPCell();
            celdaConBorde.setBorder(Rectangle.BOTTOM | Rectangle.LEFT | Rectangle.RIGHT);
            celdaConBorde.setPadding(6f); // Ajusta el padding según sea necesario


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
            //tablaa.addCell(createCell(observaciones, font, celdaConBorde)); //Columna "Observaciones"
            tablaa.addCell(createCellWithMultipleLines(observaciones, font,celdaConBorde));
            // Agregar la tabla al documento
            //document.add(tablaa);
            cellContenido.addElement(tablaa);
            Paragraph recibenB = new Paragraph("SE RECIBEN LOS BULTOS SIN ESPECIFICAR SU CONTENIDO", fontR);
            recibenB.setAlignment(Element.ALIGN_CENTER);
            //document.add(recibenB);
            cellContenido.addElement(recibenB);
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
            double total = monto + fletee + seguroo + comContra + redespa;
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
            //document.add(tabla);
            cellContenido.addElement(tabla);

            tablaMarco.addCell(cellContenido);
            document.add(tablaMarco);

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

    
    private PdfPCell createCell(String text, Font font, PdfPCell cell) {
        PdfPCell newCell = new PdfPCell(new Phrase(text, font));
        newCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        newCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        newCell.setBorder(cell.getBorder()); 
        newCell.setNoWrap(false);
        return newCell;
    }
    // Método auxiliar para crear una celda con el contenido, fuente y borde especificados

    private PdfPCell createCellWithMultipleLines(String text, Font font, PdfPCell cell) {
        PdfPCell newCell = new PdfPCell();
        newCell.setBorder(cell.getBorder());
        newCell.setPadding(5f);
        newCell.setPaddingBottom(8f); // Ajusta el espacio entre líneas según lo necesites
        newCell.setUseAscender(true);
        newCell.setUseDescender(true);
        newCell.setNoWrap(false);

        // Define el interlineado (leading) adicional
        float leading = font.getSize() * 1.3f; // Ajusta este valor para el espacio entre líneas

        // Crea un Paragraph con el texto y ajusta el interlineado
        Paragraph paragraph = new Paragraph(text, font);
        paragraph.setLeading(leading); // Ajusta el interlineado
        
       // Añade un espacio adicional debajo del párrafo
        paragraph.setSpacingAfter(1f);
        // Agrega el Paragraph a la celda
        newCell.addElement(paragraph);

        return newCell;
    }

    //remito


    
    private void cargarNumeroRemito() {
         Integer secuenciaRemito = control.getSecuenciaRemito();
         numeroRemito = secuenciaRemito++;    
    }
}

