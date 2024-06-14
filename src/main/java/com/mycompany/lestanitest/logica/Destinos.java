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
import javax.persistence.Table;

/**
 *
 * @author Juanma
 */
@Entity
@Table(name ="destinos")
public class Destinos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="ID_DESTINO",nullable=false,unique=true)
    private int id;
    
    @Column(name="DESTINO", length=50) 
    private String localiad;

    public Destinos() {
    }

    public Destinos(int id, String localiad) {
        this.id = id;
        this.localiad = localiad;
    }
 public Destinos(String localiad) {
        this.localiad = localiad;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocaliad() {
        return localiad;
    }

    public void setLocaliad(String localiad) {
        this.localiad = localiad;
    }

    @Override
    public String toString() {
        return localiad ;
    }
    
    
    
}
