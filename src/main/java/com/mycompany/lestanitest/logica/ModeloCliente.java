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
public class ModeloCliente {
    
    public Cliente getClientePorNombre(String nombre) {
        Connection con = Conexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        Cliente cliente = null;

        try {
            ps = con.prepareStatement("SELECT * FROM cliente WHERE NOMBRE = ?");
            ps.setString(1, nombre);
            rs = ps.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("ID_CLIENTE"));
                cliente.setLocalidad(rs.getString("LOCALIDAD"));
               
            }

        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cliente;
    }
    
    public ArrayList<Cliente> getClientes(){       
        Connection con = Conexion.getConexion();
        
        Statement stmt;
        ResultSet rs;
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM cliente ");
            
            while(rs.next()){
                Cliente cl = new Cliente();
                cl.setId(rs.getInt("ID_CLIENTE"));
                cl.setNombre(rs.getString("NOMBRE"));
                cl.setLocalidad(rs.getString("LOCALIDAD"));
                listaClientes.add(cl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClientes;
    }
    
}
