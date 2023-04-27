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
public class ModeloMovimientos {
    
    public ArrayList<Movimientos> getMovimientos(){       
        //conectandose a la bd
        Connection con = Conexion.getConexion();
        
        Statement stmt;
        ResultSet rs;
        ArrayList<Movimientos> listaMovimientos = new ArrayList<>();
        
        try {
            stmt = con.createStatement();
            //consulta de sql
            rs = stmt.executeQuery("SELECT * FROM movimientos");
            
            while(rs.next()){
                Movimientos mov = new Movimientos();
                mov.setId_movimientos(rs.getInt("ID_MOVIMIENTO"));
                mov.setCliente(rs.getString("CLIENTE"));
                listaMovimientos.add(mov);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaMovimientos;
    }
    
}
