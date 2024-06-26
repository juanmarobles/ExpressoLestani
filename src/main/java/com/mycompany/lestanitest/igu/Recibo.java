/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.lestanitest.igu;


import com.mycompany.lestanitest.logica.Cliente;
import com.mycompany.lestanitest.logica.Controladora;
import com.mycompany.lestanitest.logica.Movimientos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Usuario
 */
public class Recibo extends javax.swing.JFrame {

    Controladora control = new Controladora();
    List<Cliente> listaClientes = control.traerClientes();

    /**
     * Creates new form Recibo
     */
    public Recibo() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());
        cargarClientes();
        this.setResizable(false);
        
        
        
        
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Mostrar la fecha actual en los campos de texto correspondientes
        txtDiaH.setText(String.valueOf(fechaActual.getDayOfMonth()));
        txtMesH.setText(String.valueOf(fechaActual.getMonthValue()));
        txtAnioH.setText(String.valueOf(fechaActual.getYear()));
        
         // Mostrar la fecha actual en los campos de texto correspondientes
        txtDiaD.setText(String.valueOf(fechaActual.getDayOfMonth()));
        txtMesD.setText(String.valueOf(fechaActual.getMonthValue()));
        txtAnioD.setText(String.valueOf(fechaActual.getYear()));
        
        
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
                        txtDiaH.setText(String.valueOf(tomorrow.getDayOfMonth()));
                        txtMesH.setText(String.valueOf(tomorrow.getMonthValue()));
                        txtAnioH.setText(String.valueOf(tomorrow.getYear()));

                        System.out.println("Fecha cambiada a: " + formattedDate);
                    } 
                    
                    
                    
                    //Borde al seleccionar TEXFIELD
         SwingUtilities.invokeLater(() -> {
            // Define el borde de enfoque
            Border normalBorder = txtDiaH.getBorder();
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
             txtDiaD.addFocusListener(focusAdapter);
             txtMesD.addFocusListener(focusAdapter);
             txtAnioD.addFocusListener(focusAdapter);
             txtDiaH.addFocusListener(focusAdapter);
             txtMesH.addFocusListener(focusAdapter);
             txtAnioH.addFocusListener(focusAdapter);
             
        });
         
         //Combobox
         ComboBoxStyle(cbClientes);
         
         //Botones
        SwingUtilities.invokeLater(() -> {
          // Define la apariencia normal
            Color normalFont = btnCancelar.getForeground();
            Color normalBackgroundColor = btnCancelar.getBackground();
            Border normalBorder = btnCancelar.getBorder();

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
        
            btnCancelar.addFocusListener(focusAdapter);
            btnVer.addFocusListener(focusAdapter);
            
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
    
    
    

    /// Método para inicializar y cargar clientes en el ComboBox
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

    

    // Método para auto-completar el cliente seleccionado en el ComboBox
    private void autoCompletarCliente(JComboBox<String> combobox) {
        String nombreCliente = (String) combobox.getSelectedItem();
        combobox.getEditor().setItem(nombreCliente);
        
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
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDiaD = new javax.swing.JTextField();
        txtMesD = new javax.swing.JTextField();
        txtAnioD = new javax.swing.JTextField();
        txtMesH = new javax.swing.JTextField();
        txtDiaH = new javax.swing.JTextField();
        txtAnioH = new javax.swing.JTextField();
        btnVer = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cbClientes = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Expreso Lestani SRL - Recibo");
        setBackground(new java.awt.Color(66, 66, 66));

        jPanel1.setBackground(new java.awt.Color(66, 66, 66));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cliente");

        jPanel6.setBackground(new java.awt.Color(66, 66, 66));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(236, 240, 241));
        jLabel2.setText("Fecha:");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(236, 240, 241));
        jLabel9.setText("Desde:");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(236, 240, 241));
        jLabel8.setText("Hasta:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("/");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("/");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("/");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("/");

        txtMesD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMesDActionPerformed(evt);
            }
        });

        txtMesH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMesHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDiaD, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(txtDiaH))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMesH))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMesD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAnioD, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAnioH)))))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDiaD, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtMesD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txtAnioD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtMesH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnioH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        btnVer.setBackground(new java.awt.Color(51, 51, 51));
        btnVer.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnVer.setForeground(new java.awt.Color(255, 255, 255));
        btnVer.setText("Ver");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(51, 51, 51));
        btnCancelar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cbClientes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(64, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
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

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
       // Obtener el cliente seleccionado
    String cliente = cbClientes.getEditor().getItem().toString();
    if (cliente.isEmpty()) {
        mostrarMensaje("Ingrese cliente correctamente", "Error", "Cliente incorrecto");
        return; // Salir del método sin continuar
    }
    
    try {
        // Convertir las fechas "Desde" y "Hasta" a LocalDate
        LocalDate fechaDesde = LocalDate.of(
                Integer.parseInt(txtAnioD.getText()),
                Integer.parseInt(txtMesD.getText()),
                Integer.parseInt(txtDiaD.getText())
        );

        LocalDate fechaHasta = LocalDate.of(
                Integer.parseInt(txtAnioH.getText()),
                Integer.parseInt(txtMesH.getText()),
                Integer.parseInt(txtDiaH.getText())
        );
        
          // Convertir las fechas "Desde" y "Hasta" a LocalDate
        LocalDate localDateDesde = LocalDate.of(
        Integer.parseInt(txtAnioD.getText()),
        Integer.parseInt(txtMesD.getText()),
        Integer.parseInt(txtDiaD.getText())
        );
        
        Date fechaDesdeDate = Date.from(localDateDesde.atStartOfDay(ZoneId.systemDefault()).toInstant());

        // Convertir fechaHasta de LocalDate a Date
        LocalDate localDateHasta = LocalDate.of(
                Integer.parseInt(txtAnioH.getText()),
                Integer.parseInt(txtMesH.getText()),
                Integer.parseInt(txtDiaH.getText())
        );
        Date fechaHastaDate = Date.from(localDateHasta.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        // Formatear las fechas en el formato deseado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaDesdeFormateada = fechaDesde.format(formatter);
        String fechaHastaFormateada = fechaHasta.format(formatter);
        System.out.println(fechaDesdeFormateada);
        System.out.println(fechaHastaFormateada);
        // aca esta bien

        // Validar si las fechas son correctas
        if (fechaDesde == null || fechaHasta == null) {
            mostrarMensaje("Ingrese fechas desde y hasta correctamente", "Error", "Fechas incorrectas");
            return; // Salir del método sin continuar
        }

        // Obtener los movimientos filtrados por fechas y cliente
        List<Movimientos> listaFiltrada = control.getMovimientoReciboFiltrado(fechaDesdeDate,fechaHastaDate,cliente);

        // Crear una instancia de la ventana de movimientos
        Recibos rc = new Recibos(cliente, listaFiltrada, fechaDesdeFormateada, fechaHastaFormateada);

        // Mostrar la ventana de movimientos en recibos
        rc.setVisible(true);

        dispose();
    } catch (DateTimeException ex) {
        mostrarMensaje("Ingrese fechas desde y hasta correctamente", "Error", "Error en el ingreso de fechas");
        Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtMesHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMesHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesHActionPerformed

    private void txtMesDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMesDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesDActionPerformed
   /* public List<Movimientos> filtrarPorFechasCliente(List<Movimientos> objetos, LocalDate fechaDesde, LocalDate fechaHasta, String cliente) {
        List<Movimientos> resultados = new ArrayList<>();
        /*
        System.out.println("Cliente seleccionado: " + cliente);
        System.out.println("Fecha desde: " + fechaDesde);
        System.out.println("Fecha hasta: " + fechaHasta);
        
        for (Movimientos objeto : objetos) {
            LocalDate fecha = objeto.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String clienteMovimiento = objeto.getCliente();
            String pagado = objeto.getTipoMontoP();
            String rendido = objeto.getTipoMontoR();
            if (fecha != null && clienteMovimiento != null && clienteMovimiento.equals(cliente)) {
                if (fecha.compareTo(fechaDesde) >= 0 && fecha.compareTo(fechaHasta) <= 0 && "Si".equalsIgnoreCase(pagado) && !"Si".equalsIgnoreCase(rendido)) {
                    resultados.add(objeto);
                    /*
                    System.out.println(objeto);
                    System.out.println(fecha);
                    System.out.println("Agregado movimiento con ID: " + objeto.getId_movimientos());
                    
                }
            }
        }

        return resultados;
    }*/

    private void mostrarMensaje(String mensaje, String titulo, String tipoMensaje) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(Recibo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recibo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recibo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recibo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recibo().setVisible(true);
            }
        });
    }

     public Date getFecha() {
    int dia = Integer.parseInt(txtDiaH.getText());
    int mes = Integer.parseInt(txtMesH.getText());
    int anio = Integer.parseInt(txtAnioH.getText());

    Calendar calendar = Calendar.getInstance();
    // Los meses en Calendar van de 0 a 11, así que resta 1 al mes
    calendar.set(anio, mes - 1, dia);

    Date date = calendar.getTime();

    return date;
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnVer;
    private javax.swing.JComboBox<String> cbClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField txtAnioD;
    private javax.swing.JTextField txtAnioH;
    private javax.swing.JTextField txtDiaD;
    private javax.swing.JTextField txtDiaH;
    private javax.swing.JTextField txtMesD;
    private javax.swing.JTextField txtMesH;
    // End of variables declaration//GEN-END:variables
}
