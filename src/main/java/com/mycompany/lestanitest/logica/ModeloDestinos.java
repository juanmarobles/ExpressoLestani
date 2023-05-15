/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lestanitest.logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class ModeloDestinos {

    public ArrayList<Destinos> getDestinos() {
        Connection con = Conexion.getConexion();

        Statement stmt;
        ResultSet rs;
        ArrayList<Destinos> listaDestinos = new ArrayList<>();

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM destinos");

            while (rs.next()) {
                Destinos des = new Destinos();
                des.setId(rs.getInt("ID_DESTINO"));
                des.setLocaliad(rs.getString("DESTINO"));
                listaDestinos.add(des);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDestinos;
    }

    
}
