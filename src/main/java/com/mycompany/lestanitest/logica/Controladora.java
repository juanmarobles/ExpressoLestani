package com.mycompany.lestanitest.logica;

import com.mycompany.lestanitest.persistencia.ControladoraPersistencia;

public class Controladora {
    ControladoraPersistencia ctrlCliente = new ControladoraPersistencia();

    public void cargarCliente(String nombre, String direccion, String cuit, String email, String localidad, String telefono) {
        //creamos al cliente y asignamos valores
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setCuit(cuit);
        cliente.setDireccion(direccion);
        cliente.setLocalidad(localidad);
        cliente.setTelefono(telefono);
        cliente.setEmail(email);
        
        ctrlCliente.guardar(cliente);
    }
}
