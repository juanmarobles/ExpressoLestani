
package com.mycompany.lestanitest.logica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehiculo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="ID_VEHICULO",nullable=false,unique=true)
    private int id_Vehiculo;
    
    @Column(name="VEHICULO", length=50)
    private String vehiculo;
    @Column(name="PATENTE", length=50)
    private String patente;
    @Column(name="CHOFER", length=50)
    private String chofer;   

    public Vehiculo() {
    }

    public Vehiculo(int id_Vehiculo, String vehiculo, String patente, String chofer) {
        this.id_Vehiculo = id_Vehiculo;
        this.vehiculo = vehiculo;
        this.patente = patente;
        this.chofer = chofer;
    }

    public int getId_Vehiculo() {
        return id_Vehiculo;
    }

    public void setId_Vehiculo(int id_Vehiculo) {
        this.id_Vehiculo = id_Vehiculo;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getChofer() {
        return chofer;
    }

    public void setChofer(String chofer) {
        this.chofer = chofer;
    }

    @Override
    public String toString() {
        return "Vehiculos{" + "id_Vehiculo=" + id_Vehiculo + ", vehiculo=" + vehiculo + ", patente=" + patente + ", chofer=" + chofer + '}';
    }
    
    
    
}
