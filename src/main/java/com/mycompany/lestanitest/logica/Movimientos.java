package com.mycompany.lestanitest.logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Movimientos implements Serializable {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_MOVIMIENTOS",nullable=false,unique=true)
    private int id_movimientos;
    
    
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
   
    @Column(name="DESTINO", length=50)
    private String destino;
    @Column(name="REMITO", length=50)
    private int remito;
    @Column(name="BULTOS", length=50)
    private int bultos;
    @Transient
    @Column(name="MONTO", length=50)
    private Double monto;
    @Column(name="PAGADO", nullable = false)
    private Boolean pagado = false;
    @Column(name="FLETE", length=50)
    @Transient
    private Double flete;
    @Column(name="FLETE_PAGADO", nullable = false)
       private Boolean flete_pagado = false;
    @Column(name="RENDIDO", nullable = false)
    private Boolean rendido=false;
    
    @OneToOne
    private Representantes representante;
    @OneToOne
    private Cliente cliente;
    public Movimientos() {
    }

    public Movimientos(int id_movimientos, Date fecha, Cliente cliente, String destino, int remito, int bultos, Double monto, Double flete, Representantes representante) {
        this.id_movimientos = id_movimientos;
        this.fecha = fecha;
        this.cliente = cliente;
        this.destino = destino;
        this.remito = remito;
        this.bultos = bultos;
        this.monto = monto;
        this.flete = flete;
        this.representante = representante;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

    public Double getFlete() {
        return flete;
    }

    public void setFlete(Double flete) {
        this.flete = flete;
    }

    public Boolean getFlete_pagado() {
        return flete_pagado;
    }

    public void setFlete_pagado(Boolean flete_pagado) {
        this.flete_pagado = flete_pagado;
    }

    public Boolean getRendido() {
        return rendido;
    }

    public void setRendido(Boolean rendido) {
        this.rendido = rendido;
    }

    public Representantes getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representantes representante) {
        this.representante = representante;
    }

    @Override
    public String toString() {
        return "Movimientos{" + "id_movimientos=" + id_movimientos + ", fecha=" + fecha + ", destino=" + destino + ", remito=" + remito + ", bultos=" + bultos + ", monto=" + monto + ", pagado=" + pagado + ", flete=" + flete + ", flete_pagado=" + flete_pagado + ", rendido=" + rendido + ", representante=" + representante + ", cliente=" + cliente + '}';
    }

   
    
}
