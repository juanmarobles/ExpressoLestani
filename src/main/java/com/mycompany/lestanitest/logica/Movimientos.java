package com.mycompany.lestanitest.logica;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Movimientos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_MOVIMIENTO", nullable = false, unique = true)
    private int id_movimientos;

    @Column(name = "FECHA", nullable = true)
    private Date fecha;

    @Column(name = "DESTINO", length = 50)
    private String destino;
    @Column(name = "REMITO", length = 50)
    private int remito;
    @Column(name = "BULTOS", length = 50)
    private int bultos;
    @Column(name = "MONTO", length = 50)
    private String monto;
    @Column(name = "MONTO_PAGADO_RENDIDO", length = 50)
    private String tipoMonto;
    @Column(name = "FLETE", length = 50)
    private String flete;
    @Column(name = "FLETE_PAGADO_RENDIDO", length = 50)
    private String tipoFlete;
    @Column(name = "REPRESENTANTE", nullable = false)
    private String representante;
    @Column(name = "CLIENTE", nullable = false)
    private String cliente;
    @Column(name = "SERVICIO", nullable = false)
    private String servicio;
    @Column(name = "FLETE_DESTINO_ORIGEN", nullable = false)
    private String fleteDestinoOrigen;
    @Column(name = "CC", nullable = false)
    private String cuentaCorriente;
    @Column(name = "OBSERVACIONES", nullable = false)
    private String observaciones;

    public Movimientos() {
    }

    public Movimientos(int id_movimientos, Date fecha, String destino, int remito, int bultos, String monto, String tipoMonto, String flete, String tipoFlete, String representante, String cliente, String servicio, String fleteDestinoOrigen, String cuentaCorriente, String observaciones) {
        this.id_movimientos = id_movimientos;
        this.fecha = fecha;
        this.destino = destino;
        this.remito = remito;
        this.bultos = bultos;
        this.monto = monto;
        this.tipoMonto = tipoMonto;
        this.flete = flete;
        this.tipoFlete = tipoFlete;
        this.representante = representante;
        this.cliente = cliente;
        this.servicio = servicio;
        this.fleteDestinoOrigen = fleteDestinoOrigen;
        this.cuentaCorriente = cuentaCorriente;
        this.observaciones = observaciones;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    

    public String getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(String cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }
    
    public Movimientos(String cliente) {
        this.cliente = cliente;
    }

    public int getId_movimientos() {
        return id_movimientos;
    }

    public void setId_movimientos(int id_movimientos) {
        this.id_movimientos = id_movimientos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;

    }

    private static final String FORMATO_FECHA_TABLA = "dd/MM/yyyy";

    public String getFechaFormateada() {
        SimpleDateFormat formato = new SimpleDateFormat(FORMATO_FECHA_TABLA);
        return formato.format(fecha);
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getRemito() {
        return remito;
    }

    public void setRemito(int remito) {
        this.remito = remito;
    }

    public int getBultos() {
        return bultos;
    }

    public void setBultos(int bultos) {
        this.bultos = bultos;
    }

    public String getMonto() {

        BigDecimal montoBigDecimal = new BigDecimal(monto);
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator(',');
        simbolos.setGroupingSeparator('.');
        DecimalFormat formato = new DecimalFormat("#,##0.00", simbolos);
        String montoFormateado = formato.format(montoBigDecimal);
        monto = montoFormateado;
        return "$" + monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getTipoMonto() {
        return tipoMonto;
    }

    public void setTipoMonto(String tipoMonto) {
        this.tipoMonto = tipoMonto;
    }

    public String getFlete() {
        BigDecimal fleteBigDecimal = new BigDecimal(flete);
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator(',');
        simbolos.setGroupingSeparator('.');
        DecimalFormat formato = new DecimalFormat("#,##0.00", simbolos);
        String fleteFormateado = formato.format(fleteBigDecimal);
        flete = fleteFormateado;
        return "$" + flete;
    }

    public void setFlete(String flete) {
        this.flete = flete;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getFleteDestinoOrigen() {
        return fleteDestinoOrigen;
    }

    public void setFleteDestinoOrigen(String fleteDestinoOrigen) {
        this.fleteDestinoOrigen = fleteDestinoOrigen;
    }

    public String getTipoFlete() {
        return tipoFlete;
    }

    public void setTipoFlete(String tipoFlete) {
        this.tipoFlete = tipoFlete;
    }

    @Override
    public String toString() {
        return cliente;
    }

}
