/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lestanitest.logica;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Marco
 */


public class Conexion {
    public Connection conexion;
    public Statement sentencia;
    public ResultSet resultado;
    public CallableStatement cmd;
    public PreparedStatement pstm;
    public static Connection getConexion() {
    Connection con = null;
    String url = "jdbc:mysql://srv1433.hstgr.io:3306/u261556491_lestani_bd?zeroDateTimeBehavior=CONVERT_TO_NULL";
    String user = "u261556491_expresolestani";
    String password = "Expresolestani2024_";
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
   
   
}
