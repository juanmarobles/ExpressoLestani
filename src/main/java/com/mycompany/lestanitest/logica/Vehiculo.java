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
    @Column(name = "FECHA_SEGURO", length = 50)
    private Date fechaSeguro;
    @Column(name = "FECHA_MATAFUEGO", length = 50)
    private Date fechaMatafuego;
    
    public Vehiculo() {
    }

    public Vehiculo(int id_Vehiculo, Date fechaTecnica, Date fechaRuta, String vehiculo, String patente, Date fechaSeguro, Date fechaMatafuego) {
        this.id_Vehiculo = id_Vehiculo;
        this.fechaTecnica = fechaTecnica;
        this.fechaRuta = fechaRuta;
        this.vehiculo = vehiculo;
        this.patente = patente;
        this.fechaSeguro = fechaSeguro;
        this.fechaMatafuego = fechaMatafuego;
    }

    public Date getFechaSeguro() {
        return fechaSeguro;
    }

    public void setFechaSeguro(Date fechaSeguro) {
        this.fechaSeguro = fechaSeguro;
    }

    public Date getFechaMatafuego() {
        return fechaMatafuego;
    }

    public void setFechaMatafuego(Date fechaMatafuego) {
        this.fechaMatafuego = fechaMatafuego;
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

    private static final String FORMATO_FECHA_TABLA = "dd/MM/yyyy";

    public String getFechaTecnicaFormateada() {
        SimpleDateFormat formato = new SimpleDateFormat(FORMATO_FECHA_TABLA);
        return formato.format(fechaTecnica);
    }

    public String getFechaRutaFormateada() {
        SimpleDateFormat formato = new SimpleDateFormat(FORMATO_FECHA_TABLA);
        return formato.format(fechaRuta);
    }
    
    public String getFechaSeguroFormateada() {
        SimpleDateFormat formato = new SimpleDateFormat(FORMATO_FECHA_TABLA);
        return formato.format(fechaSeguro);
    }
    
    public String getFechaMatafuegoFormateada() {
        SimpleDateFormat formato = new SimpleDateFormat(FORMATO_FECHA_TABLA);
        return formato.format(fechaMatafuego);
    }
    @Override
    public String toString() {
        return vehiculo;
    }

}
