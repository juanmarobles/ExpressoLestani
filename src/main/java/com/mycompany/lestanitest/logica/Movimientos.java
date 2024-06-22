package com.mycompany.lestanitest.logica;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="movimientos")
public class Movimientos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_MOVIMIENTO", nullable = false, unique = true)
    private int id_movimientos;

    @Column(name = "FECHA", nullable = true)
    private Date fecha;
    @Column(name = "HORA", nullable = true)
    private Time hora;

    @Column(name = "DESTINO", length = 50)
    private String destino;
    @Column(name = "REMITO", length = 50)
    private String remito;
    @Column(name = "BULTOS", length = 50)
    private int bultos;
    @Column(name = "MONTO", length = 50)
    private String monto;
    @Column(name = "MONTO_PAGADO", length = 10)
    private String tipoMontoP;
    @Column(name = "MONTO_RENDIDO", length = 10)
    private String tipoMontoR;
    @Column(name = "FLETE", length = 50)
    private String flete;
    @Column(name = "FLETE_PAGADO", length = 10)
    private String tipoFleteP;
    @Column(name = "FLETE_RENDIDO", length = 10)
    private String tipoFleteR;
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
    @Column(name = "SECUENCIA_REMITO", nullable = false)
    private Integer secuenciaRemito;
    
    
    //NUEVAS CARGAS
    

    public Movimientos() {
    }

    public Movimientos(int id_movimientos, Date fecha, String destino, String remito, int bultos, String monto, String tipoMontoP, String tipoMontoR, String flete, String tipoFleteP, String tipoFleteR, String representante, String cliente, String servicio, String fleteDestinoOrigen, String cuentaCorriente, String observaciones, Time hora) {
        this.id_movimientos = id_movimientos;
        this.fecha = fecha;
        this.destino = destino;
        this.remito = remito;
        this.bultos = bultos;
        this.monto = monto;
        this.tipoMontoP = tipoMontoP;
        this.tipoMontoR = tipoMontoR;
        this.flete = flete;
        this.tipoFleteP = tipoFleteP;
        this.tipoFleteR = tipoFleteR;
        this.representante = representante;
        this.cliente = cliente;
        this.servicio = servicio;
        this.fleteDestinoOrigen = fleteDestinoOrigen;
        this.cuentaCorriente = cuentaCorriente;
        this.observaciones = observaciones;
        this.hora = hora;
    }

    public Integer getSecuenciaRemito() {
        return secuenciaRemito;
    }

    public void setSecuenciaRemito(Integer secuenciaRemito) {
        this.secuenciaRemito = secuenciaRemito;
    }
    
    
    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getTipoMontoP() {
        return tipoMontoP;
    }

    public void setTipoMontoP(String tipoMontoP) {
        this.tipoMontoP = tipoMontoP;
    }

    public String getTipoMontoR() {
        return tipoMontoR;
    }

    public void setTipoMontoR(String tipoMontoR) {
        this.tipoMontoR = tipoMontoR;
    }

    public String getTipoFleteP() {
        return tipoFleteP;
    }

    public void setTipoFleteP(String tipoFleteP) {
        this.tipoFleteP = tipoFleteP;
    }

    public String getTipoFleteR() {
        return tipoFleteR;
    }

    public void setTipoFleteR(String tipoFleteR) {
        this.tipoFleteR = tipoFleteR;
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
    if (this.fecha == null) {
        return "";
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return sdf.format(this.fecha);
}


    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getRemito() {
        return remito;
    }

    public void setRemito(String remito) {
        this.remito = remito;
    }

    public int getBultos() {
        return bultos;
    }

    public void setBultos(int bultos) {
        this.bultos = bultos;
    }

   public String getMonto() {
    if (monto == null) {
        return ""; // Otra acción adecuada para manejar el valor nulo
    }

    BigDecimal montoBigDecimal = new BigDecimal(monto);
    DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
    simbolos.setGroupingSeparator('.');
    simbolos.setDecimalSeparator(',');
    DecimalFormat formatoPersonalizado = new DecimalFormat("###,###.##", simbolos);
    formatoPersonalizado.setParseBigDecimal(true);
    String montoFormateado = formatoPersonalizado.format(montoBigDecimal);
    return "$" + montoFormateado;
}


    public void setMonto(String monto) {
        // Reemplazar cualquier coma existente por un punto
        String montoConPunto = monto.replace(",", ".");

        // Asegurarse de que el valor sea numérico antes de asignarlo
        if (esNumero(montoConPunto)) {
            this.monto = montoConPunto;
        } else {
            // Manejar el caso en el que el valor no sea numérico
            throw new IllegalArgumentException("El valor no es numérico válido: " + monto);
        }
    }

// Método de utilidad para verificar si una cadena es numérica
    private boolean esNumero(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String getFlete() {
          if (flete == null) {
        return ""; // Otra acción adecuada para manejar el valor nulo
    }

        BigDecimal fleteBigDecimal = new BigDecimal(flete);
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setGroupingSeparator('.');
        simbolos.setDecimalSeparator(',');
        DecimalFormat formatoPersonalizado = new DecimalFormat("###,###.##", simbolos);
        formatoPersonalizado.setParseBigDecimal(true);
        String fleteFormateado = formatoPersonalizado.format(fleteBigDecimal);
        return "$" + fleteFormateado;
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

    @Override
    public String toString() {
        return cliente;
    }

}
