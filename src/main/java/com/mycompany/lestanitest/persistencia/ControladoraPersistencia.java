package com.mycompany.lestanitest.persistencia;

import com.mycompany.lestanitest.logica.Cliente;
import com.mycompany.lestanitest.logica.Destinos;
import com.mycompany.lestanitest.logica.Movimientos;
import com.mycompany.lestanitest.logica.Representantes;
import com.mycompany.lestanitest.logica.Servicios;
import com.mycompany.lestanitest.logica.Usuario;
import com.mycompany.lestanitest.logica.Vehiculo;
import com.mycompany.lestanitest.persistencia.ClienteJpaController;
import com.mycompany.lestanitest.persistencia.RepresentantesJpaController;
import com.mycompany.lestanitest.persistencia.ServiciosJpaController;
import com.mycompany.lestanitest.persistencia.VehiculoJpaController;
import com.mycompany.lestanitest.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ControladoraPersistencia {

    ClienteJpaController clienteJpa = new ClienteJpaController();
    VehiculoJpaController vehiculoJpa = new VehiculoJpaController();
    RepresentantesJpaController representanteJpa = new RepresentantesJpaController();
    ServiciosJpaController servicioJpa = new ServiciosJpaController();
    MovimientosJpaController movJpa = new MovimientosJpaController();
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    DestinosJpaController desJpa = new DestinosJpaController();

    /**
     * --------------------------------------Verificacion
     * Usuario-------------------------------------------------
     */
    public List<Usuario> traerUsuarios() {
        return usuJpa.findUsuarioEntities();
    }

    /**
     * --------------------------------------CRUD PERSISTENCIA CLASE
     * CLIENTE-------------------------------------------------
     */
    /**
     * ----------------------------------------------GUARDAR-----------------------------------------------------------------
     */
    public void guardarCliente(Cliente cliente) {
        clienteJpa.create(cliente);
    }

    /**
     * ----------------------------------------------MOSTRAR----------------------------------------------------------------
     */
    public List<Cliente> traerClientes() {

        return clienteJpa.findClienteEntities();
    }

    /**
     * ----------------------------------------------BORRAR-----------------------------------------------------------------
     */
    public void borrarCliente(int idCliente) {
        try {
            clienteJpa.destroy(idCliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * ----------------------------------------------EDITAR-----------------------------------------------------------------
     */
    public Cliente traerClientes(int idCliente) {
        return clienteJpa.findCliente(idCliente);
    }

    public void modificarCliente(Cliente cliente) {
        try {
            clienteJpa.edit(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * --------------------------------------CRUD PERSISTENCIA CLASE
     * VEHICULO-------------------------------------------------
     */
    /**
     * ----------------------------------------------GUARDAR-----------------------------------------------------------------
     */
    public void guardarVehiculo(Vehiculo vehiculo) {
        vehiculoJpa.create(vehiculo);
    }

    /**
     * ----------------------------------------------MOSTRAR----------------------------------------------------------------
     */
    public List<Vehiculo> traerVehiculos() {
        return vehiculoJpa.findVehiculoEntities();
    }
    

    /**
     * ----------------------------------------------EDITAR-----------------------------------------------------------------
     */
    public Vehiculo traerVehiculo(int idVehiculo) {
        return vehiculoJpa.findVehiculo(idVehiculo);
    }

    public void modificarVehiculo(Vehiculo vehiculo) {
        try {
            vehiculoJpa.edit(vehiculo);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * ----------------------------------------------BORRAR-----------------------------------------------------------------
     */
    public void borrarVehiculo(int idVehiculo) {
        try {
            vehiculoJpa.destroy(idVehiculo);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * --------------------------------------CRUD PERSISTENCIA CLASE
     * REPRESENTANTE-------------------------------------------------
     */
    /**
     * ----------------------------------------------GUARDAR-----------------------------------------------------------------
     */
    public void guardarRepresentante(Representantes representante) {
        representanteJpa.create(representante);
    }

    /**
     * ----------------------------------------------MOSTRAR----------------------------------------------------------------
     */
    public List<Representantes> traerRepresentantes() {
        return representanteJpa.findRepresentantesEntities();
    }

    /**
     * ----------------------------------------------EDITAR-----------------------------------------------------------------
     */
    public Representantes traerRepresentantes(int idRepresentante) {
        return representanteJpa.findRepresentantes(idRepresentante);

    }

    public void modificarRepresentante(Representantes representante) {
        try {
            representanteJpa.edit(representante);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * ----------------------------------------------BORRAR-----------------------------------------------------------------
     */
    public void borrarRepresentante(int idRepresentante) {
        try {
            representanteJpa.destroy(idRepresentante);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * --------------------------------------CRUD PERSISTENCIA CLASE
     * SERVICIO-------------------------------------------------
     */
    /**
     * ----------------------------------------------GUARDAR-----------------------------------------------------------------
     */
    public void guardarServicios(Servicios s) {
        servicioJpa.create(s);
    }

    /**
     * ----------------------------------------------MOSTRAR----------------------------------------------------------------
     */
    public List<Servicios> traerServicios() {
        return servicioJpa.findServiciosEntities();
    }

    /**
     * ----------------------------------------------EDITAR-----------------------------------------------------------------
     */
    public Servicios traerServicio(int idServicio) {
        return servicioJpa.findServicios(idServicio);
    }

    public void modificarServicio(Servicios servicios) {
        try {
            servicioJpa.edit(servicios);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * ----------------------------------------------BORRAR-----------------------------------------------------------------
     */
    public void borrarServicio(int idServicio) {
        try {
            servicioJpa.destroy(idServicio);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * --------------------------------------CRUD PERSISTENCIA CLASE
     * MOVIMIENTOS-------------------------------------------------
     */
    /**
     * ----------------------------------------------GUARDAR-----------------------------------------------------------------
     */
    public void guardarMovimiento(Movimientos m) {
        movJpa.create(m);
    }

    /**
     * ----------------------------------------------MOSTRAR----------------------------------------------------------------
     */
    public List<Movimientos> traerMovimientos() {
        return movJpa.getMovimientos();
    }

    /**
     * ----------------------------------------------BORRAR-----------------------------------------------------------------
     */
    public void borrarMovimiento(int idM) {
        try {
            movJpa.destroy(idM);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * ----------------------------------------------EDITAR-----------------------------------------------------------------
     */
    public Movimientos traerMovimiento(int idMovimiento) {
        return movJpa.findMovimientos(idMovimiento);
    }

    public void modificarMovimiento(Movimientos mov) {
        try {
            movJpa.edit(mov);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
     public void ActualizarMovimientos(List<Movimientos> movimientos) {
    

    try {
        for (Movimientos movimiento : movimientos) {
            // Utiliza el controlador JPA para actualizar cada objeto Movimientos
            movJpa.edit(movimiento);
        }
    } catch (Exception ex) {
        ex.printStackTrace(); // Manejo adecuado de la excepción (log, mostrar mensaje, etc.)
    }
}
    
     

    /**
     * --------------------------------------CRUD PERSISTENCIA CLASE
     * DESTINOS-------------------------------------------------
     */
    /**
     * ----------------------------------------------GUARDAR-----------------------------------------------------------------
     */
    public void guardarDestino(Destinos d) {
        desJpa.create(d);
    }

    public List<Destinos> traerDestino() {
        return desJpa.findDestinosEntities();
    }

    public Destinos traerDestino(int idDestino) {
        return desJpa.findDestinos(idDestino);
    }

    public void modificarDestino(Destinos destino) {
        try {
            desJpa.edit(destino);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarDestino(int idDestino) {
        try {
            desJpa.destroy(idDestino);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


        public List<Movimientos> getMovimientos(String texto) {
            return clienteJpa.getMovimientos(texto);
        }

    public List<Movimientos> getMovimientos() {
     return clienteJpa.getMovimientos();   
    }
    }
    /**
     * ----------------------------------------------BORRAR-----------------------------------------------------------------
     * public void borrarCliente(int idCliente) { try {
     * clienteJpa.destroy(idCliente); } catch (NonexistentEntityException ex) {
     * Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE,
     * null, ex); } }
     */
    /**
     * ----------------------------------------------EDITAR-----------------------------------------------------------------
     * public Cliente traerClientes(int idCliente) { return
     * clienteJpa.findCliente(idCliente); } public void modificarCliente(Cliente
     * cliente) { try { clienteJpa.edit(cliente); } catch (Exception ex) {
     * Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE,
     * null, ex); }
     */


