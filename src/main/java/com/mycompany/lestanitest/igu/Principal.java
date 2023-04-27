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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;

public class Principal extends javax.swing.JFrame {

    Controladora control = new Controladora();
    TableRowSorter trs;
    DefaultTableModel dtm = new DefaultTableModel();

    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setTitle("Expreso Lestani S.R.L - [Panel Principal]");
        llenarClientes();
        cargarSugerencias();
        testSugerencias();
        llenarRepresentantes();
        llenarServicios();
        llenarDestinos();
        txtFecha.setText(fechaActual());
    }

    //LLENAR COMBOBOX
    private void llenarClientes() {
        ModeloCliente modClientes = new ModeloCliente();
        ArrayList<Cliente> listaClientes = modClientes.getClientes();
        cmbCliente.removeAllItems();

        for (int i = 0; i < listaClientes.size(); i++) {
            cmbCliente.addItem(new Cliente(listaClientes.get(i).getNombre()));
        }
    }

    private void llenarDestinos() {
        ModeloDestinos modDestinos = new ModeloDestinos();
        ArrayList<Destinos> listaDestinos = modDestinos.getDestinos();
        cmbDestino.removeAllItems();

        for (int i = 0; i < listaDestinos.size(); i++) {
            cmbDestino.addItem(new Destinos(listaDestinos.get(i).getLocaliad()));
        }
    }

    private void llenarServicios() {
        ModeloServicio modServicio = new ModeloServicio();
        ArrayList<Servicios> listaServicios = modServicio.getServicios();
        cmbServicio.removeAllItems();

        for (int i = 0; i < listaServicios.size(); i++) {
            cmbServicio.addItem(new Servicios(listaServicios.get(i).getServicio()));
        }
    }

    private void llenarRepresentantes() {
        ModeloRepresentante modRepresentante = new ModeloRepresentante();
        ArrayList<Representantes> listaRepresentantes = modRepresentante.getRepresentantes();
        cmbRepresentante.removeAllItems();

        for (int i = 0; i < listaRepresentantes.size(); i++) {
            cmbRepresentante.addItem(new Representantes(listaRepresentantes.get(i).getNombre()));
        }
    }

    private void cargarSugerencias() {
        AutoCompleteDecorator.decorate(cmbCliente);
        AutoCompleteDecorator.decorate(cmbDestino);

    }

    //LLENAR TEXTFIELD
    private void testSugerencias() {
        ModeloCliente modClientes = new ModeloCliente();
        ArrayList<Cliente> listaClientes = modClientes.getClientes();
        AutoCompleteDecorator.decorate(tCliente, listaClientes, false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMovimientos = new javax.swing.JTable();
        panelCargaMovimientos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtFlete = new javax.swing.JTextField();
        cmbDestino = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        bulto = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbServicio = new javax.swing.JComboBox<>();
        txtBulto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbRepresentante = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jCheckBox9 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();
        cbRemito = new javax.swing.JCheckBox();
        txtMonto = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        txtRemito = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbmontoPagado = new javax.swing.JCheckBox();
        cbMontoRendido = new javax.swing.JCheckBox();
        cbfletePagado = new javax.swing.JCheckBox();
        cbfleteRendido = new javax.swing.JCheckBox();
        btnEliminarMovimiento = new javax.swing.JButton();
        btnEditarMovimiento = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JFormattedTextField();
        cbfOrigen = new javax.swing.JCheckBox();
        cbfDestino = new javax.swing.JCheckBox();
        tCliente = new javax.swing.JTextField();
        PanelMenu = new javax.swing.JPanel();
        btnClientes = new javax.swing.JButton();
        btnServicios = new javax.swing.JButton();
        btnVehiculos = new javax.swing.JButton();
        btnRepresentantes = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnHR = new javax.swing.JButton();
        btnRecibos = new javax.swing.JButton();
        btnConsultas = new javax.swing.JButton();
        PanelBusquedas = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtFiltroCliente = new javax.swing.JTextField();
        txtFiltroRemito = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Expreso Lestani SRL - Menu Principal");
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));

        tablaMovimientos.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
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

        panelCargaMovimientos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Monto");

        cmbDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDestinoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Flete");

        bulto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        bulto.setText("Servicios");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Bulto");

        cmbServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbServicioActionPerformed(evt);
            }
        });

        txtBulto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBultoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Representante");

        cmbRepresentante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRepresentanteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Cliente");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Fecha");

        jCheckBox9.setText("Cuenta Corriente");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Destino");

        cmbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteActionPerformed(evt);
            }
        });

        cbRemito.setText("Generar Remito");
        cbRemito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRemitoActionPerformed(evt);
            }
        });

        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
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
        jLabel12.setText("Remito");

        cbmontoPagado.setText("Pagado");

        cbMontoRendido.setText("Rendido");

        cbfletePagado.setText("Pagado");

        cbfleteRendido.setText("Rendido");

        btnEliminarMovimiento.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnEliminarMovimiento.setText("Borrar");
        btnEliminarMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMovimientoActionPerformed(evt);
            }
        });

        btnEditarMovimiento.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnEditarMovimiento.setText("Editar");
        btnEditarMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarMovimientoActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel15.setText("$");

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel16.setText("$");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel17.setText("Flete a Cargo");

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

        cbfOrigen.setText("Origen");

        cbfDestino.setText("Destino");

        javax.swing.GroupLayout panelCargaMovimientosLayout = new javax.swing.GroupLayout(panelCargaMovimientos);
        panelCargaMovimientos.setLayout(panelCargaMovimientosLayout);
        panelCargaMovimientosLayout.setHorizontalGroup(
            panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCargaMovimientosLayout.createSequentialGroup()
                                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(14, 14, 14)))
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFlete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(cbfletePagado)
                                .addGap(18, 18, 18)
                                .addComponent(cbfleteRendido))
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRemito, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(cbRemito))
                                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(cbmontoPagado)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbMontoRendido))))
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox9)
                                    .addComponent(cmbRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbfOrigen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbfDestino)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditarMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCargaMovimientosLayout.createSequentialGroup()
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bulto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbServicio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                        .addComponent(txtBulto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCargaMovimientosLayout.createSequentialGroup()
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addGap(25, 25, 25)
                                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 9, Short.MAX_VALUE)))))
                        .addGap(49, 49, 49)
                        .addComponent(tCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelCargaMovimientosLayout.setVerticalGroup(
            panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cmbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bulto)
                    .addComponent(cmbServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBulto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(23, 23, 23)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox9)
                .addGap(20, 20, 20)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cbfOrigen)
                    .addComponent(cbfDestino))
                .addGap(35, 35, 35)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel15)
                    .addComponent(cbmontoPagado)
                    .addComponent(cbMontoRendido))
                .addGap(18, 18, 18)
                .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCargaMovimientosLayout.createSequentialGroup()
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtFlete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16)))
                        .addGap(32, 32, 32)
                        .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRemito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbRemito)))
                    .addGroup(panelCargaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbfletePagado)
                        .addComponent(cbfleteRendido)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCargaMovimientosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditarMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        PanelMenu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnClientes.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnServicios.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnServicios.setText("Servicios");
        btnServicios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServiciosActionPerformed(evt);
            }
        });

        btnVehiculos.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnVehiculos.setText("Vehiculos");
        btnVehiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVehiculosActionPerformed(evt);
            }
        });

        btnRepresentantes.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnRepresentantes.setText("Representantes");
        btnRepresentantes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRepresentantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepresentantesActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Menu");
        jLabel2.setToolTipText("");

        btnHR.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnHR.setText("Hoja de Ruta");
        btnHR.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnHR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHRActionPerformed(evt);
            }
        });

        btnRecibos.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnRecibos.setText("Recibos");
        btnRecibos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRecibos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecibosActionPerformed(evt);
            }
        });

        btnConsultas.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnConsultas.setText("Consultas");
        btnConsultas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuLayout.createSequentialGroup()
                        .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRecibos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRepresentantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVehiculos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnServicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166)))
                .addGap(38, 38, 38))
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHR, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRecibos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(btnVehiculos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRepresentantes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        PanelBusquedas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("Busqueda por CLIENTE");

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

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel11.setText("Busqueda por REMITO");

        javax.swing.GroupLayout PanelBusquedasLayout = new javax.swing.GroupLayout(PanelBusquedas);
        PanelBusquedas.setLayout(PanelBusquedasLayout);
        PanelBusquedasLayout.setHorizontalGroup(
            PanelBusquedasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedasLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(PanelBusquedasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11)
                    .addComponent(txtFiltroRemito, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        PanelBusquedasLayout.setVerticalGroup(
            PanelBusquedasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedasLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFiltroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFiltroRemito, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelCargaMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                        .addComponent(PanelBusquedas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(197, 197, 197)
                        .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCargaMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PanelBusquedas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(636, 636, 636)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1908, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(841, 841, 841))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasActionPerformed
        Consultas cons = new Consultas();
        cons.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnConsultasActionPerformed

    private void btnHRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHRActionPerformed
        HojaDeRuta hd = new HojaDeRuta();
        hd.setVisible(true);
    }//GEN-LAST:event_btnHRActionPerformed

    private void btnRecibosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecibosActionPerformed
        Recibos reb = new Recibos();
        reb.setVisible(true);
    }//GEN-LAST:event_btnRecibosActionPerformed

    private void txtFiltroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroClienteActionPerformed

    private void btnServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServiciosActionPerformed
        VerDatosServicios s = new VerDatosServicios();
        s.setVisible(true);
        s.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnServiciosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        VerDatosCliente cl = new VerDatosCliente();
        cl.setVisible(true);
        cl.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVehiculosActionPerformed
        VerDatosVehiculos v = new VerDatosVehiculos();
        v.setVisible(true);
        v.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnVehiculosActionPerformed

    private void btnRepresentantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepresentantesActionPerformed
        VerDatosRepresentantes r = new VerDatosRepresentantes();
        r.setVisible(true);
        r.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRepresentantesActionPerformed

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
        String titulos[] = {"MOVIMIENTO", "FECHA", "CLIENTE", "DESTINO", "REMITO", "BULTOS", "MONTO", "TIPO_MONTO", "FLETE", "TIPO_FLETE", "A_CARGO_DE", "REPRESENTANTE"};
        tabla.setColumnIdentifiers(titulos);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tabla);
        tablaMovimientos.setRowSorter(sorter);
        sorter.setSortKeys(java.util.Arrays.asList(new RowSorter.SortKey(1, SortOrder.DESCENDING)));
        //carga de los datos desde la bd
        List<Movimientos> listaMovimientos = control.traerMovimientos();

        //recorrer lista y mostrar elementos en la tabla
        if (listaMovimientos != null) {
            for (Movimientos mov : listaMovimientos) {
                Object[] objeto = {mov.getId_movimientos(), mov.getFechaFormateada(), mov.getCliente(), mov.getDestino(), mov.getRemito(), mov.getBultos(), mov.getMonto(), mov.getTipoMonto(), mov.getFlete(), mov.getTipoFlete(), mov.getFleteDestinoOrigen(), mov.getRepresentante()};

                tabla.addRow(objeto);

            }
        }
        tablaMovimientos.setModel(tabla);
        tablaMovimientos.getModel();

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
        int remito = 0;
        Date fecha = getDate();
        //String cliente = (String) cmbCliente.getSelectedItem().toString();
        String cliente = tCliente.getText();
        String destino = (String) cmbDestino.getSelectedItem().toString();
        String servicio = (String) cmbServicio.getSelectedItem().toString();
        String representante = (String) cmbRepresentante.getSelectedItem().toString();
        int bulto = Integer.parseInt(txtBulto.getText());
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

        //remito
        if (cbRemito.isSelected()) {
            remito = (int) (Math.random() * 10000);
        } else {
            remito = Integer.parseInt(txtRemito.getText());
        }

        //verif de monto pagado/rendido
        if (cbmontoPagado.isSelected() && cbMontoRendido.isSelected()) {
            tMonto = "Pagado/Rendido";
        } else if (cbmontoPagado.isSelected()) {
            tMonto = "Pagado";
        } else if (cbMontoRendido.isSelected()) {
            tMonto = "Rendido";
        }
        //verif de flete pagado/rendido
        if (cbfletePagado.isSelected() && cbfleteRendido.isSelected()) {
            fPr = "Pagado/Rendido";
        } else if (cbfleteRendido.isSelected()) {
            fPr = "Rendido";
        } else if (cbfletePagado.isSelected()) {
            fPr = "Pagado";
        }

        control.cargarMovimiento(cliente, destino, servicio, representante, bulto, monto, flete, remito, fPr, fecha, tFlete, tMonto);
        mostrarMensaje("Movimiento agregado correctamente", "Info", "Agregado con exito!");

        Principal verAnterior = new Principal();
        verAnterior.setVisible(true);
        verAnterior.setLocationRelativeTo(null);

        dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActionPerformed

    private void cbRemitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRemitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbRemitoActionPerformed

    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed

    }//GEN-LAST:event_cmbClienteActionPerformed

    private void cmbRepresentanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRepresentanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRepresentanteActionPerformed

    private void txtBultoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBultoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBultoActionPerformed

    private void cmbServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbServicioActionPerformed

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

    private void cmbDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDestinoActionPerformed

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
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnConsultas;
    private javax.swing.JButton btnEditarMovimiento;
    private javax.swing.JButton btnEliminarMovimiento;
    private javax.swing.JButton btnHR;
    private javax.swing.JButton btnRecibos;
    private javax.swing.JButton btnRepresentantes;
    private javax.swing.JButton btnServicios;
    private javax.swing.JButton btnVehiculos;
    private javax.swing.JLabel bulto;
    private javax.swing.JCheckBox cbMontoRendido;
    private javax.swing.JCheckBox cbRemito;
    private javax.swing.JCheckBox cbfDestino;
    private javax.swing.JCheckBox cbfOrigen;
    private javax.swing.JCheckBox cbfletePagado;
    private javax.swing.JCheckBox cbfleteRendido;
    private javax.swing.JCheckBox cbmontoPagado;
    private javax.swing.JComboBox<Cliente
    > cmbCliente;
    private javax.swing.JComboBox<Destinos> cmbDestino;
    private javax.swing.JComboBox<Representantes> cmbRepresentante;
    private javax.swing.JComboBox<Servicios> cmbServicio;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelCargaMovimientos;
    private javax.swing.JTextField tCliente;
    private javax.swing.JTable tablaMovimientos;
    private javax.swing.JTextField txtBulto;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JTextField txtFiltroCliente;
    private javax.swing.JTextField txtFiltroRemito;
    private javax.swing.JTextField txtFlete;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtRemito;
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
