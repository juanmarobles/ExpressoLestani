
package com.mycompany.lestanitest.logica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Representantes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_REPRESENTANTE",nullable=false,unique=true)
    private int id;
    @Column(name="NOMBRE", length=50)
    private String nombre;
    @Column(name="LOCALIDAD", length=50)
    private int id_Localidad;
    @Column(name="TELEFONO", length=50)
    private String telefono;

    public Representantes() {
    }

    public Representantes(int id, String nombre, int id_Localidad, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.id_Localidad = id_Localidad;
        this.telefono = telefono;
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

    public int getId_Localidad() {
        return id_Localidad;
    }

    public void setId_Localidad(int id_Localidad) {
        this.id_Localidad = id_Localidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
