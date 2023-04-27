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
 * @author Juanma
 */
public class ModeloServicio {
    
    public ArrayList<Servicios> getServicios(){       
        Connection con = Conexion.getConexion();
        
        Statement stmt;
        ResultSet rs;
        ArrayList<Servicios> listaServicios = new ArrayList<>();
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM servicios ");
            
            while(rs.next()){
                Servicios ser = new Servicios();               
                ser.setId_servicio(rs.getInt("ID_SERVICIO"));
                ser.setServicio(rs.getString("SERVICIO"));          
                listaServicios.add(ser);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaServicios;
    }
    
}
