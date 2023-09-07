
package com.mycompany.lestanitest.logica;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="ID_CLIENTE",nullable=false,unique=true)
    private int id;
    
    @Column(name="NOMBRE", length=50)
    private String nombre;
    
    @Column(name="DIRECCION", length=50)
    private String direccion;
    
    @Column(name="TELEFONO", length=50)
    private String telefono;
    
    @Column(name="EMAIL", length=50)
    private String email;
    
    @Column(name="CUIT")
    private String cuit;
    
    @Column(name="LOCALIDAD", length=50)
    private String localidad;
    
    public Cliente() {
    }

    public Cliente(int id, String nombre, String direccion, String telefono, String email, String cuit, String localidad) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.cuit = cuit;
        this.localidad = localidad;
    }

    public Cliente(String nombre) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return  nombre;
    }
    
}
