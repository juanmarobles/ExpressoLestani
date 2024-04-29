/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.lestanitest.igu;

import com.mycompany.lestanitest.logica.Controladora;
import com.mycompany.lestanitest.logica.Vehiculo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author juanm
 */
public class DateAlertApp extends javax.swing.JFrame {

    private Timer timer;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Date currentDate;
    private boolean showAlert = true;
    // Conjunto para almacenar IDs de vehículos alertados
    private Set<Integer> vehiculosAlertadosRuta = new HashSet<>();
    private Set<Integer> vehiculosAlertadosTecnica = new HashSet<>();
    private Set<Integer> vehiculosAlertadosSeguro = new HashSet<>();
    private Set<Integer> vehiculosAlertadosMatafuego = new HashSet<>();

    Controladora control;
    private static DateAlertApp instance;
    
    
    public DateAlertApp() {
        control = new Controladora();
        // Simulamos una fecha actual (puedes obtenerla realmente usando new Date() u otras fuentes)
        currentDate = new Date();

        int delay = 1000; // Tiempo de espera entre comprobaciones en milisegundos (1 segundo)
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTablaVehiculos();
            }
        });
        timer.start();
        instance = this;
    }

    public void mostrarTablaVehiculos() {
        //filas y columnas no editables
        DefaultTableModel tabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //nombres de columnas
        String titulos[] = {"Id_Vehiculo", "Vehiculo", "Patente", "Rev. Tenica", "Fecha ruta", "Seguro", "Matafuego"};
        tabla.setColumnIdentifiers(titulos);

        //carga de los datos desde la bd
        List<Vehiculo> listaVehiculos = control.traerVehiculos();

        //recorrer lista y mostrar elementos en la tabla
        if (listaVehiculos != null) {
            for (Vehiculo v : listaVehiculos) {
                // Verificar si la fecha de Ruta está cerca (por ejemplo, dentro de 31 días)
                if (isDateNear(v.getFechaRutaFormateada(), 31) && !vehiculosAlertadosRuta.contains(v.getId_Vehiculo())) {
                    String mensaje = "El vehículo: " + v.getVehiculo().toUpperCase() + " dominio: " + v.getPatente().toUpperCase() + " tiene una Ruta por vencer el: " + v.getFechaRutaFormateada();
                    mostrarAlerta(mensaje);
                    // Agregar el ID del vehículo al conjunto de vehículos alertados por ruta
                    vehiculosAlertadosRuta.add(v.getId_Vehiculo());
                }

                // Verificar si la fecha de Revisión Técnica está cerca (por ejemplo, dentro de 31 días)
                if (isDateNear(v.getFechaTecnicaFormateada(), 31) && !vehiculosAlertadosTecnica.contains(v.getId_Vehiculo())) {
                    String mensaje = "El vehículo: " + v.getVehiculo().toUpperCase() + " dominio: " + v.getPatente().toUpperCase() + " tiene una Revisión Técnica por vencer el: " + v.getFechaTecnicaFormateada();
                    mostrarAlerta(mensaje);
                    // Agregar el ID del vehículo al conjunto de vehículos alertados por revisión técnica
                    vehiculosAlertadosTecnica.add(v.getId_Vehiculo());
                }
                 if (isDateNear(v.getFechaSeguroFormateada(), 31) && !vehiculosAlertadosSeguro.contains(v.getId_Vehiculo())) {
                    String mensaje = "El vehículo: " + v.getVehiculo().toUpperCase() + " dominio: " + v.getPatente().toUpperCase() + " tiene un Seguro por vencer el: " + v.getFechaSeguroFormateada();
                    mostrarAlerta(mensaje);
                    vehiculosAlertadosSeguro.add(v.getId_Vehiculo());
                }
                  if (isDateNear(v.getFechaMatafuegoFormateada(), 31) && !vehiculosAlertadosMatafuego.contains(v.getId_Vehiculo())) {
                    String mensaje = "El vehículo: " + v.getVehiculo().toUpperCase() + " dominio: " + v.getPatente().toUpperCase() + " tiene un Matafuego por vencer el: " + v.getFechaMatafuegoFormateada();
                    mostrarAlerta(mensaje);
                    vehiculosAlertadosMatafuego.add(v.getId_Vehiculo());
                }
            }
        }

    }

    private boolean isDateNear(String fechaFormateada, int daysBeforeAlert) {
        if (fechaFormateada.isEmpty()) {
            // Si la fecha formateada está vacía, no podemos calcular la cercanía, así que devolvemos false.
            return false;
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Ajustar el formato aquí
            Date fecha = dateFormat.parse(fechaFormateada);
            long timeDiff = fecha.getTime() - currentDate.getTime();
            int daysDiff = (int) (timeDiff / (1000 * 60 * 60 * 24));
            return daysDiff <= daysBeforeAlert;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void mostrarAlertaPublico(String mensaje) {
        if (instance != null) {
            instance.mostrarAlerta(mensaje);
        }
    }

    private void mostrarAlerta(String mensaje) {
        JDialog dialog = new JDialog(this, "Alerta de Vencimiento",true); // El tercer argumento (true) hace que el diálogo sea modal
        JLabel label = new JLabel(mensaje);
        JButton okButton = new JButton("OK");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(okButton);

        dialog.add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(null); // Centrar la ventana de alerta con respecto a la ventana principal
        dialog.setVisible(true);
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DateAlertApp app = new DateAlertApp();
                app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                app.pack();
                app.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
