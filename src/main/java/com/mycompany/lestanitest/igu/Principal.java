package com.mycompany.lestanitest.igu;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.TableColumn;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;

public class Principal extends javax.swing.JFrame {

    Controladora control = new Controladora();
    TableRowSorter trs;
    DefaultTableModel dtm = new DefaultTableModel();

    public Principal() {
        initComponents();

        setTitle("Expreso Lestani S.R.L - [Panel Principal]");

        cargarClientes();
        cargarDestinos();
        llenarRepresentantes();
        cargarServicios();
        txtServicio.setText("Normal");
        txtFecha.setText(fechaActual());
        TextPrompt filtroCl = new TextPrompt("Busqueda por cliente", txtFiltroCliente);
        TextPrompt filtroRe = new TextPrompt("Busqueda por remito", txtFiltroRemito);
    }

    private void cargarServicios() {
        ModeloServicio modServicio = new ModeloServicio();
        ArrayList<Servicios> listaServicios = modServicio.getServicios();
        AutoCompleteDecorator.decorate(txtServicio, listaServicios, false);

        // Agregar un listener al textfield del servicio
        txtServicio.getDocument().addDocumentListener(new DocumentListener() {
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

            private void actualizarFlete() {

                //carga de los datos desde la bd
                List<Servicios> listaServicios = control.traerServicios();
                // Buscar el servicio correspondiente en la lista
                String nombreServicio = txtServicio.getText().trim().toLowerCase();
                for (Servicios s : listaServicios) {
                    if (s.getServicio().toLowerCase().equals(nombreServicio)) {
                        // Mostrar la localidad en el textfield correspondiente
                        txtFlete.setText(Double.toString(s.getPrecio()));
                        return;
                    }
                }
            }
        });

    }

    /*
    private void cargarDestinos() {
        ModeloDestinos modDestino = new ModeloDestinos();
        ArrayList<Destinos> listaDestinos = modDestino.getDestinos();
        AutoCompleteDecorator.decorate(txtDestino, listaDestinos, false);
        for (Destinos destino : listaDestinos) {
            System.out.println(destino.getLocaliad());
        }
    }
     */
    private void llenarRepresentantes() {
        ModeloRepresentante modRepresentante = new ModeloRepresentante();
        ArrayList<Representantes> listaRepresentantes = modRepresentante.getRepresentantes();
        AutoCompleteDecorator.decorate(txtRepresentante, listaRepresentantes, false);

    }

    //LLENAR TEXTFIELD CLIENTES
    private void cargarClientes() {
        ModeloCliente modClientes = new ModeloCliente();
        ArrayList<Cliente> listaClientes = modClientes.getClientes();
        AutoCompleteDecorator.decorate(tCliente, listaClientes, false);

        // Agregar un listener al textfield del cliente
        tCliente.getDocument().addDocumentListener(new DocumentListener() {
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
                String nombreCliente = tCliente.getText().trim().toLowerCase();
                for (Cliente cliente : listaC) {
                    if (cliente.getNombre().toLowerCase().equals(nombreCliente)) {
                        // Mostrar la localidad en el textfield correspondiente
                        txtDestino.setText(cliente.getLocalidad());
                        return;
                    }
                }
            }
        });
    }

    private void cargarDestinos() {
        ModeloDestinos modDestino = new ModeloDestinos();
        ArrayList<Destinos> listaDestinos = modDestino.getDestinos();
        AutoCompleteDecorator.decorate(txtDestino, listaDestinos, false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMovimientos = new javax.swing.JTable();
        panelCargaMovimientos = new javax.swing.JPanel();
        bulto = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBulto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbCuentaCorriente = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        cbRemito = new javax.swing.JCheckBox();
        btnAgregar = new javax.swing.JButton();
        txtRemito = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnEliminarMovimiento = new javax.swing.JButton();
        btnEditarMovimiento = new javax.swing.JButton();
        txtFecha = new javax.swing.JFormattedTextField();
        tCliente = new javax.swing.JTextField();
        txtDestino = new javax.swing.JTextField();
        txtServicio = new javax.swing.JTextField();
        txtRepresentante = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnAgregarCliente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        cbfDestino = new javax.swing.JCheckBox();
        cbfOrigen = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cbmontoPagado = new javax.swing.JCheckBox();
        cbMontoRendido = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtFlete = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cbfletePagado = new javax.swing.JCheckBox();
        cbfleteRendido = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        PanelBusquedas = new javax.swing.JPanel();
        txtFiltroCliente = new javax.swing.JTextField();
        txtFiltroRemito = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Expreso Lestani SRL - Carga Movimientos");
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

        bulto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        bulto.setForeground(new java.awt.Color(236, 240, 241));
        bulto.setText("Servicios");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(236, 240, 241));
        jLabel7.setText("Bulto");

        txtBulto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBultoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(236, 240, 241));
        jLabel8.setText("Representante");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(236, 240, 241));
        jLabel9.setText("Fecha");

        cbCuentaCorriente.setBackground(new java.awt.Color(66, 66, 66));
        cbCuentaCorriente.setForeground(new java.awt.Color(236, 240, 241));
        cbCuentaCorriente.setText("Cuenta Corriente");
        cbCuentaCorriente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCuentaCorrienteActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(236, 240, 241));
        jLabel10.setText("Destino");

        cbRemito.setBackground(new java.awt.Color(66, 66, 66));
        cbRemito.setForeground(new java.awt.Color(236, 240, 241));
        cbRemito.setText("Generar Remito");
        cbRemito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRemitoActionPerformed(evt);
            }
        });

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

        txtRemito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRemitoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(236, 240, 241));
        jLabel12.setText("Remito N°");

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

        try {
            txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        tCliente.setForeground(new java.awt.Color(51, 51, 51));
        tCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tClienteActionPerformed(evt);
            }
        });

        txtDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDestinoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(236, 240, 241));
        jLabel13.setText("Cliente");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
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
        jLabel17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbfOrigen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbfDestino))
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbfDestino)
                    .addComponent(cbfOrigen))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(66, 66, 66));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
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
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(cbmontoPagado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbMontoRendido))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(39, 39, 39))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbmontoPagado)
                    .addComponent(cbMontoRendido))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(66, 66, 66));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(236, 240, 241));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/camion_24px.png"))); // NOI18N
        jLabel6.setText("Flete");

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
                .addGap(53, 53, 53)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFlete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(cbfletePagado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbfleteRendido)))
                .addGap(16, 16, 16))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFlete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbfletePagado)
                    .addComponent(cbfleteRendido))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        jScrollPane3.setViewportView(txtObservaciones);

        javax.swing.GroupLayout panelCargaMovimientosLayout = new javax.swing.GroupLayout(panelCargaMovimientos);
        panelCargaMovimientos.setLayout(panelCargaMovimientosLayout);
        panelCargaMovimientosLayout.setHorizontalGroup(
            panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(cbRemito))
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRemito, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bulto)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBulto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCargaMovimientosLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addComponent(tCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addComponent(jLabel14))
                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCuentaCorriente)
                            .addComponent(txtRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(102, 102, 102)
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEditarMovimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEliminarMovimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panelCargaMovimientosLayout.setVerticalGroup(
            panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel14))
                    .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(21, 21, 21)
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bulto)
                                    .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBulto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addComponent(txtRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbCuentaCorriente)
                                .addGap(39, 39, 39)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtRemito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(cbRemito))
                                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                        .addComponent(btnEditarMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEliminarMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))))
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

        javax.swing.GroupLayout PanelBusquedasLayout = new javax.swing.GroupLayout(PanelBusquedas);
        PanelBusquedas.setLayout(PanelBusquedasLayout);
        PanelBusquedasLayout.setHorizontalGroup(
            PanelBusquedasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedasLayout.createSequentialGroup()
                .addGroup(PanelBusquedasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelBusquedasLayout.createSequentialGroup()
                        .addGap(0, 89, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFiltroRemito, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelBusquedasLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFiltroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        PanelBusquedasLayout.setVerticalGroup(
            PanelBusquedasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedasLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(PanelBusquedasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFiltroCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(PanelBusquedasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFiltroRemito, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setForeground(new java.awt.Color(236, 240, 241));
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1668, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelCargaMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(PanelBusquedas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelCargaMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelBusquedas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
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
        String titulos[] = {"MOVIMIENTO", "FECHA", "CLIENTE", "DESTINO", "REMITO", "BULTOS", "MONTO", "PAGADO", "FLETE", "PAGADO", "A_CARGO_DE", "REPRESENTANTE", "CC", "OBS"};
        tabla.setColumnIdentifiers(titulos);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tabla);
        tablaMovimientos.setRowSorter(sorter);
        sorter.setSortKeys(java.util.Arrays.asList(new RowSorter.SortKey(1, SortOrder.DESCENDING)));
        //carga de los datos desde la bd
        List<Movimientos> listaMovimientos = control.traerMovimientos();

        //recorrer lista y mostrar elementos en la tabla
        if (listaMovimientos != null) {
            for (Movimientos mov : listaMovimientos) {
                Object[] objeto = {mov.getId_movimientos(), mov.getFechaFormateada(), mov.getCliente(), mov.getDestino(), mov.getRemito(), mov.getBultos(), mov.getMonto(), mov.getTipoMonto(), mov.getFlete(), mov.getTipoFlete(), mov.getFleteDestinoOrigen(), mov.getRepresentante(), mov.getCuentaCorriente(), mov.getObservaciones()};

                tabla.addRow(objeto);

            }
        }
        tablaMovimientos.setModel(tabla);
        // Establecer el ancho específico de las columnas
        int[] anchos = {60, 50, 100, 100, 40, 30, 100, 30, 100, 30, 60, 100, 5, 200}; // Anchos deseados para cada columna en píxeles

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
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtFiltroCliente.getText(), 2));
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
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtFiltroRemito.getText(), 4));
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
        //String fOrigen="";
        // String fDestino="";
        String tFlete = "";
        String tMonto = "";
        String fPr = "";
        String cC = "";
        int remito = 0;
        Date fecha = getDate();
        //String cliente = (String) cmbCliente.getSelectedItem().toString();
        String cliente = tCliente.getText();
        String destino = (String) txtDestino.getText();
        String servicio = (String) txtServicio.getText();
        String representante = txtRepresentante.getText();
        int bulto = Integer.parseInt(txtBulto.getText());
        String monto = txtMonto.getText();
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
        //remito
        if (cbRemito.isSelected()) {
            remito = (int) (Math.random() * 99999);
        } else {
            remito = Integer.parseInt(txtRemito.getText());
        }

        //verif de monto pagado/rendido
        if (cbmontoPagado.isSelected() && cbMontoRendido.isSelected()) {
            tMonto = "Si";
        } else if (cbmontoPagado.isSelected()) {
            tMonto = "Si";
        } else if (cbMontoRendido.isSelected()) {
            tMonto = "Si";
        } else {
            tMonto = "No";
        }
        //verif de flete pagado/rendido
        if (cbfletePagado.isSelected() && cbfleteRendido.isSelected()) {
            fPr = "Si";
        } else if (cbfleteRendido.isSelected()) {
            fPr = "Si";
        } else if (cbfletePagado.isSelected()) {
            fPr = "Si";
        } else {
            fPr = "No";
        }

        control.cargarMovimiento(cliente, destino, servicio, representante, bulto, monto, flete, tFlete, remito, fPr, fecha, tMonto, cC, obs);
        mostrarMensaje("Movimiento agregado correctamente", "Info", "Agregado con exito!");

        // Actualizar la tabla
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaMovimientos.getModel();
        modeloTabla.setRowCount(0);
        List<Movimientos> movimientos = control.traerMovimientos();
        for (Movimientos mov : movimientos) {
            Object[] objeto = {mov.getId_movimientos(), mov.getFechaFormateada(), mov.getCliente(), mov.getDestino(), mov.getRemito(), mov.getBultos(), mov.getMonto(), mov.getTipoMonto(), mov.getFlete(), mov.getTipoFlete(), mov.getFleteDestinoOrigen(), mov.getRepresentante(), mov.getCuentaCorriente(), mov.getObservaciones()};

            modeloTabla.addRow(objeto);
        }
        //vaciar los elementos de la interfaz gráfica
        tCliente.setText("");
        txtDestino.setText("");
        txtServicio.setText("");
        txtRepresentante.setText("");
        txtBulto.setText("");
        txtMonto.setText("");
        txtFlete.setText("");
        txtObservaciones.setText("");
        cbfOrigen.setSelected(false);
        cbfDestino.setSelected(false);
        cbRemito.setSelected(false);
        cbmontoPagado.setSelected(false);
        cbMontoRendido.setSelected(false);
        cbfletePagado.setSelected(false);
        cbfleteRendido.setSelected(false);
        cbCuentaCorriente.setSelected(false);
        txtRemito.setEnabled(true);


    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActionPerformed

    private void cbRemitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRemitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbRemitoActionPerformed

    private void txtBultoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBultoActionPerformed

    }//GEN-LAST:event_txtBultoActionPerformed

    private void btnEliminarMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMovimientoActionPerformed
        // Control de q la tabla no este vacia
        if (tablaMovimientos.getRowCount() > 0) {
            //validar q se haya seleccionado un registro
            if (tablaMovimientos.getSelectedRow() != -1) {
                //obtener la id de lo q quiero borrar
                int idMovimiento = Integer.parseInt(String.valueOf(tablaMovimientos.getValueAt(tablaMovimientos.getSelectedRow(), 0)));

                control.borrarMovimiento(idMovimiento);
                mostrarMensaje("Movimiento borrado correctamente", "Info", "Borrado con exito!");
                mostrarTablaMovimientos();
            } else {
                mostrarMensaje("No seleccinó un Registro para eliminar", "Error", "Error al eliminar");
            }
        } else {
            mostrarMensaje("La tabla esta vacia, no se puede eliminar", "Error", "Error al eliminar");
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

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed

    }//GEN-LAST:event_txtFechaActionPerformed

    private void tClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tClienteActionPerformed

    }//GEN-LAST:event_tClienteActionPerformed

    private void txtDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDestinoActionPerformed

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

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        NuevoCliente nc = new NuevoCliente();
        nc.setVisible(true);

    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void cbCuentaCorrienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCuentaCorrienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCuentaCorrienteActionPerformed

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
    private javax.swing.JLabel bulto;
    private javax.swing.JCheckBox cbCuentaCorriente;
    private javax.swing.JCheckBox cbMontoRendido;
    private javax.swing.JCheckBox cbRemito;
    private javax.swing.JCheckBox cbfDestino;
    private javax.swing.JCheckBox cbfOrigen;
    private javax.swing.JCheckBox cbfletePagado;
    private javax.swing.JCheckBox cbfleteRendido;
    private javax.swing.JCheckBox cbmontoPagado;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelCargaMovimientos;
    private javax.swing.JTextField tCliente;
    private javax.swing.JTable tablaMovimientos;
    private javax.swing.JTextField txtBulto;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JTextField txtFiltroCliente;
    private javax.swing.JTextField txtFiltroRemito;
    private javax.swing.JTextField txtFlete;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JTextField txtRemito;
    private javax.swing.JTextField txtRepresentante;
    private javax.swing.JTextField txtServicio;
    // End of variables declaration//GEN-END:variables

    public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
    }

    public Date getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(txtFecha.getText());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
