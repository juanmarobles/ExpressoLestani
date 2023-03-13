
package com.mycompany.lestanitest.persistencia;

import com.mycompany.lestanitest.logica.Cliente;


public class ControladoraPersistencia {
    ClienteJpaController clienteJpa = new ClienteJpaController();

    public void guardar(Cliente cliente) {
        clienteJpa.create(cliente);
    }
    
}
