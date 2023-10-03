/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lestanitest.logica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Juanma
 */

@Entity
public class Servicios implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="ID_SERVICIO",nullable=false,unique=true)
    private int id_servicio;
    @Column(name="SERVICIO", length=50)
    private String servicio;
    @Column(name="PRECIO")
    private Double precio;
    @Column(name="DESCRIPCION", length=50)
    private String descripcion;

    public Servicios() {
    }

    public Servicios(int id_servicio, String servicio, Double precio, String descripcion) {
        this.id_servicio = id_servicio;
        this.servicio = servicio;
        this.precio = precio;
        this.descripcion = descripcion;
    }

      public Servicios(String servicio) {
        this.servicio = servicio;    
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return  servicio;
    }
    
}
