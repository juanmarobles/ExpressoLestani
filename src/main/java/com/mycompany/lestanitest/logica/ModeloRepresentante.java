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
public class ModeloRepresentante {
    public ArrayList<Representantes> getRepresentantes(){       
        Connection con = Conexion.getConexion();
        
        Statement stmt;
        ResultSet rs;
        ArrayList<Representantes> listaRepresentantes = new ArrayList<>();
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM representantes ");
            
            while(rs.next()){
                Representantes r = new Representantes();
                r.setId(rs.getInt("ID_REPRESENTANTE"));
                r.setNombre(rs.getString("NOMBRE"));
                listaRepresentantes.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloRepresentante.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRepresentantes;
    }
}
