
package com.mycompany.lestanitest.logica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="representantes")
public class Representantes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="ID_REPRESENTANTE",nullable=false,unique=true)
    private int id;
    @Column(name="NOMBRE", length=50)
    private String nombre;
    @Column(name="LOCALIDAD", length=50)
    private String localidad;
    @Column(name="DIRECCION", length=50)
    private String direccion;
    @Column(name="TELEFONO", length=50)
    private String telefono;

    public Representantes() {
    }

    public Representantes(int id, String nombre, String localidad, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.localidad = localidad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Representantes(String nombre) {
        this.nombre = nombre;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre ;
    }

  
    
}

