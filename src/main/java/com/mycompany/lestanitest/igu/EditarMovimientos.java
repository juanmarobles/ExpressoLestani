/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.lestanitest.igu;

import com.mycompany.lestanitest.logica.Cliente;
import com.mycompany.lestanitest.logica.Controladora;
import com.mycompany.lestanitest.logica.ModeloCliente;
import com.mycompany.lestanitest.logica.ModeloRepresentante;
import com.mycompany.lestanitest.logica.ModeloServicio;

import com.mycompany.lestanitest.logica.Movimientos;
import com.mycompany.lestanitest.logica.Representantes;
import com.mycompany.lestanitest.logica.Servicios;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Marco
 */
public class EditarMovimientos extends javax.swing.JFrame {

    Controladora control = null;
    Movimientos mov = new Movimientos();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");

    public EditarMovimientos(int idMovimiento) {
        control = new Controladora();
        initComponents();
        cargarClientes();
        cargarDestinos();
        cargarRepresentantes();
        cargarServicios();
        cargarDatosMovimiento(idMovimiento);
        
        
        
        
        ComboBoxStyle(cbClientes);
        ComboBoxStyle(cbDestinos);
        ComboBoxStyle(cbRepresentantes);
        ComboBoxStyle(cbServicios);
        
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
        
        //Focuses TAB
        txtDia.setNextFocusableComponent(txtMes);
        txtMes.setNextFocusableComponent(txtAnio);
        txtAnio.setNextFocusableComponent(cbDestinos);
        
        cbfOrigen.setNextFocusableComponent(cbfDestino);
        
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
         
    }

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
     ModeloCliente modClientes = new ModeloCliente();
    ArrayList<Cliente> listaClientes = modClientes.getClientes();

    private void cargarDestinos() {
        ModeloCliente modClientes = new ModeloCliente();
        ArrayList<Cliente> listaClientes = modClientes.getClientes();

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

                    // Normaliza el texto de búsqueda a mayúsculas y elimina caracteres no deseados excepto espacios en blanco
                    textoBusqueda = textoBusqueda.toUpperCase().replaceAll("[^A-ZÑñ.\\s]", "");

                    mostrarResultadosBusqueda(cbDestinos, textoBusqueda);

                }
            }
        });
    }

    private void cargarServicios() {
        ModeloServicio modServ = new ModeloServicio();
        ArrayList<Servicios> listaServ = modServ.getServicios();
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

        // Agregar ActionListener para capturar el evento "Enter"
        cbClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoBusqueda = cbClientes.getEditor().getItem().toString();
                mostrarResultadosBusqueda(cbClientes, textoBusqueda);
                if (cbClientes.getSelectedIndex() != -1) {
                    // Normaliza el texto de búsqueda a mayúsculas
                    textoBusqueda = textoBusqueda.toUpperCase();

                    
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        buttonGroup1 = new javax.swing.ButtonGroup();
        panelCargaMovimientos = new javax.swing.JPanel();
        bulto = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBulto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbCuentaCorriente = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        txtRemito = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbfDestino = new javax.swing.JCheckBox();
        cbfOrigen = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        cbmontoPagado = new javax.swing.JCheckBox();
        cbMontoRendido = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cbfleteRendido = new javax.swing.JCheckBox();
        cbfletePagado = new javax.swing.JCheckBox();
        txtFlete = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbClientes = new javax.swing.JComboBox<>();
        cbDestinos = new javax.swing.JComboBox<>();
        cbServicios = new javax.swing.JComboBox<>();
        txtDia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMes = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        txtObservaciones = new javax.swing.JTextField();
        cbRepresentantes = new javax.swing.JComboBox<>();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Expreso Lestani S.R.L - Editar Movimientos");

        panelCargaMovimientos.setBackground(new java.awt.Color(66, 66, 66));

        bulto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        bulto.setForeground(new java.awt.Color(255, 255, 255));
        bulto.setText("Servicios");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Bulto");

        txtBulto.setText("1");
        txtBulto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBultoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Representante");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cliente");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Fecha");

        cbCuentaCorriente.setBackground(new java.awt.Color(66, 66, 66));
        cbCuentaCorriente.setForeground(new java.awt.Color(255, 255, 255));
        cbCuentaCorriente.setText("Cuenta Corriente");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Destino");

        txtRemito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRemitoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Remito N°");

        btnGuardar.setBackground(new java.awt.Color(51, 51, 51));
        btnGuardar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Guardar_24px.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(51, 51, 51));
        btnCancelar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/X_24px.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Flete a Cargo");

        cbfDestino.setBackground(new java.awt.Color(66, 66, 66));
        buttonGroup1.add(cbfDestino);
        cbfDestino.setForeground(new java.awt.Color(255, 255, 255));
        cbfDestino.setText("Destino");

        cbfOrigen.setBackground(new java.awt.Color(66, 66, 66));
        buttonGroup1.add(cbfOrigen);
        cbfOrigen.setForeground(new java.awt.Color(255, 255, 255));
        cbfOrigen.setText("Origen");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Observaciones");

        jPanel1.setBackground(new java.awt.Color(66, 66, 66));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dinero_24px.png"))); // NOI18N
        jLabel5.setText("Monto");

        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });

        cbmontoPagado.setBackground(new java.awt.Color(66, 66, 66));
        cbmontoPagado.setForeground(new java.awt.Color(255, 255, 255));
        cbmontoPagado.setText("Pagado");

        cbMontoRendido.setBackground(new java.awt.Color(66, 66, 66));
        cbMontoRendido.setForeground(new java.awt.Color(255, 255, 255));
        cbMontoRendido.setText("Rendido");

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("$");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbmontoPagado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbMontoRendido))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(txtMonto)))
                .addGap(9, 9, 9))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbmontoPagado)
                    .addComponent(cbMontoRendido))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(66, 66, 66));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbfleteRendido.setBackground(new java.awt.Color(66, 66, 66));
        cbfleteRendido.setForeground(new java.awt.Color(255, 255, 255));
        cbfleteRendido.setText("Rendido");

        cbfletePagado.setBackground(new java.awt.Color(66, 66, 66));
        cbfletePagado.setForeground(new java.awt.Color(255, 255, 255));
        cbfletePagado.setText("Pagado");

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("$");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/camion_24px.png"))); // NOI18N
        jLabel6.setText("Flete");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFlete, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbfletePagado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbfleteRendido)))
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(50, 50, 50))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFlete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbfleteRendido)
                    .addComponent(cbfletePagado))
                .addGap(19, 19, 19))
        );

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("/");

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setText("/");

        javax.swing.GroupLayout panelCargaMovimientosLayout = new javax.swing.GroupLayout(panelCargaMovimientos);
        panelCargaMovimientos.setLayout(panelCargaMovimientosLayout);
        panelCargaMovimientosLayout.setHorizontalGroup(
            panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCargaMovimientosLayout.createSequentialGroup()
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bulto))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBulto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                        .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE))
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbClientes, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbDestinos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbServicios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(35, 35, 35)))
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCargaMovimientosLayout.createSequentialGroup()
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRemito, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbCuentaCorriente)
                                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                        .addComponent(cbfOrigen)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbfDestino))
                                    .addComponent(cbRepresentantes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))))
        );
        panelCargaMovimientosLayout.setVerticalGroup(
            panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCargaMovimientosLayout.createSequentialGroup()
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCargaMovimientosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbDestinos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bulto)
                    .addComponent(cbServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBulto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbRepresentantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbCuentaCorriente)
                .addGap(11, 11, 11)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbfOrigen)
                            .addComponent(cbfDestino))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRemito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCargaMovimientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCargaMovimientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBultoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBultoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBultoActionPerformed

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActionPerformed

    private void txtRemitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRemitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRemitoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String fPagado = "";
        String fRendido = "";

        String tFlete = "";
        String tMontoP = "";
        String tMontoR = "";
        String tFleteP = "";
        String tFleteR = "";
        String cC = "";
        String obs = txtObservaciones.getText();
        String remito;
        
        
        // Obtener los valores de los campos de texto
        int dia = Integer.parseInt(txtDia.getText());
        int mes = Integer.parseInt(txtMes.getText());
        int anio = Integer.parseInt(txtAnio.getText());

        // Crear una instancia de LocalDate si la fecha es válida
        LocalDate fechaArmada = LocalDate.of(anio, mes, dia);

        // Convertir LocalDate a Date
        Instant instant = fechaArmada.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date fechaFormateada = Date.from(instant);
        
        Date fecha = fechaFormateada;
        
        String cliente = (String) cbClientes.getSelectedItem();
        String destino = (String) cbDestinos.getSelectedItem();
        String servicio = (String) cbServicios.getSelectedItem();
        String representante = (String) cbRepresentantes.getSelectedItem();
        int bulto = 0;
        try {
            bulto = Integer.parseInt(txtBulto.getText());
        } catch (NumberFormatException e) {
            mostrarMensaje("Elija un bulto correctamente" + e, "Error", "Error");
        }
        String monto = txtMonto.getText();
        String flete = txtFlete.getText();
        //verif flete origen/destino
        if (cbfOrigen.isSelected() && cbfDestino.isSelected()) {
            tFlete = "Origen/Destino";
        } else if (cbfDestino.isSelected()) {
            tFlete = "Destino";
        } else if (cbfOrigen.isSelected()) {
            tFlete = "Origen";
        }
        //verif Cuenta Corriente
        if (cbCuentaCorriente.isSelected()) {
            cC = "Si";
        } else {
            cC = "No";
        }
        //verif remito
        remito = txtRemito.getText();
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
        System.out.println("el tipo de flete es: "+tFlete);
        control.editarMovimiento(mov, cliente, destino, servicio, representante, bulto, monto, flete, tFlete, remito, tMontoP, tMontoR, tFleteP, tFleteR, fecha, cC, obs);

        mostrarMensaje("Movimiento modificado correctamente", "Info", "Edicion exitosa!");

        this.dispose();
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel bulto;
    private javax.swing.ButtonGroup buttonGroup1;
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel panelCargaMovimientos;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtBulto;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtFlete;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtObservaciones;
    private javax.swing.JTextField txtRemito;
    // End of variables declaration//GEN-END:variables

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
    
  private void cargarDatosMovimiento(int idMovimiento) {
        // Busco id en la bd
        mov = control.traerMovimiento(idMovimiento);
        // Seteo los valores de ese id
        cbClientes.setSelectedItem(mov.getCliente());
        
        
      // Supongamos que tienes una fecha en formato 10/02/2023 almacenada en mov.getFecha()
      String fechaStr = formatoFecha.format(mov.getFecha());

      try {
          // Crea un formato de fecha para el formato "dd/MM/yyyy"
          SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

          // Analiza la fecha en el formato especificado
          Date fecha = dateFormat.parse(fechaStr);

          // Extrae el día, el mes y el año de la fecha analizada
          SimpleDateFormat diaFormat = new SimpleDateFormat("dd");
          SimpleDateFormat mesFormat = new SimpleDateFormat("MM");
          SimpleDateFormat anioFormat = new SimpleDateFormat("yyyy");

       
         txtDia.setText(diaFormat.format(fecha));
         txtMes.setText(mesFormat.format(fecha));
         txtAnio.setText(anioFormat.format(fecha));
         
          
      } catch (ParseException e) {
          // Manejar excepciones si la fecha no se puede analizar correctamente
          e.printStackTrace();
      }
        
        cbDestinos.setSelectedItem(mov.getDestino());
        cbServicios.setSelectedItem(mov.getServicio());
        txtBulto.setText(Integer.toString(mov.getBultos()));
        cbRepresentantes.setSelectedItem(mov.getRepresentante());
        txtRemito.setText(mov.getRemito());

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
        txtMonto.setText(montoBigDecimal.toString());
        txtFlete.setText(fleteBigDecimal.toString());

        txtRemito.setText(mov.getRemito());
        txtObservaciones.setText(mov.getObservaciones());

        // Setear los valores de los checkboxes
        cbfDestino.setSelected(mov.getFleteDestinoOrigen().equals("Destino"));
        cbfOrigen.setSelected(mov.getFleteDestinoOrigen().equals("Origen"));
        cbCuentaCorriente.setSelected(mov.getCuentaCorriente().equals("Si"));
        cbmontoPagado.setSelected(mov.getTipoMontoP().equals("Si"));
        cbMontoRendido.setSelected(mov.getTipoMontoR().equals("Si"));
        cbfletePagado.setSelected(mov.getTipoFleteP().equals("Si"));
        cbfleteRendido.setSelected(mov.getTipoFleteR().equals("Si"));
        
    }




    public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
    }
    public Date getDate(String fechaStr) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(fechaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
