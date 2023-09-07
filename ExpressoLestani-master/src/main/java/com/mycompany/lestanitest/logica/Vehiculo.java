package com.mycompany.lestanitest.logica;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_VEHICULO", nullable = false, unique = true)
    private int id_Vehiculo;
    //fechas
    @Column(name = "FECHA_TECNICA")
    @Temporal(TemporalType.DATE)
    private Date fechaTecnica;

    @Column(name = "FECHA_RUTA")
    @Temporal(TemporalType.DATE)
    private Date fechaRuta;

    @Column(name = "VEHICULO", length = 50)
    private String vehiculo;
    @Column(name = "PATENTE", length = 50)
    private String patente;
    @Column(name = "CHOFER", length = 50)
    private String chofer;

    public Vehiculo() {
    }

    public Vehiculo(int id_Vehiculo, String vehiculo, String patente, String chofer, Date fechaTecnica, Date fechaRuta) {
        this.id_Vehiculo = id_Vehiculo;
        this.vehiculo = vehiculo;
        this.patente = patente;
        this.chofer = chofer;
        this.fechaTecnica = fechaTecnica;
        this.fechaRuta = fechaRuta;
    }

    public Date getFechaTecnica() {
        return fechaTecnica;
    }

    public void setFechaTecnica(Date fechaTecnica) {
        this.fechaTecnica = fechaTecnica;
    }

    public Date getFechaRuta() {
        return fechaRuta;
    }

    public void setFechaRuta(Date fechaRuta) {
        this.fechaRuta = fechaRuta;
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

    private static final String FORMATO_FECHA_TABLA = "dd/MM/yyyy";

    public String getFechaTecnicaFormateada() {
        SimpleDateFormat formato = new SimpleDateFormat(FORMATO_FECHA_TABLA);
        return formato.format(fechaTecnica);
    }

    public String getFechaRutaFormateada() {
        SimpleDateFormat formato = new SimpleDateFormat(FORMATO_FECHA_TABLA);
        return formato.format(fechaRuta);
    }

   

    @Override
    public String toString() {
        return vehiculo;
    }

}
