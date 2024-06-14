/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.lestanitest.logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juanmarobles
 */
public class TestMySQLConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://srv1433.hstgr.io:3306/u261556491_lestani_bd?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "u261556491_expresolestani";
        String password = "Expresolestani2024_"; // Reemplaza con la contraseña real

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos");
                connection.close();
            } else {
                System.out.println("No se pudo conectar a la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("Fallo en la conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }
}