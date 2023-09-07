/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lestanitest.logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanm
 */
public class ModeloVehiculo {
    public ArrayList<Vehiculo> getVehiculos(){       
        Connection con = Conexion.getConexion();
        
        Statement stmt;
        ResultSet rs;
        ArrayList<Vehiculo> listaVehiculo = new ArrayList<>();
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM vehiculo ");
            
            while(rs.next()){
                Vehiculo v = new Vehiculo();               
                v.setId_Vehiculo(rs.getInt("ID_VEHICULO"));
                v.setVehiculo(rs.getString("VEHICULO"));        
                v.setPatente(rs.getString("PATENTE")); 
                v.setChofer(rs.getString("CHOFER"));
                listaVehiculo.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVehiculo;
    }
}
