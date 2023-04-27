package com.mycompany.lestanitest.logica;

import com.mycompany.lestanitest.persistencia.ControladoraPersistencia;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Controladora {

    ControladoraPersistencia ctrl = new ControladoraPersistencia();

    /**
     * --------------------------------------Verificacion Usuario-------------------------------------------------
     */
    public String validarUsuario(String usuario, String password) {
        String mensaje = "";
        List<Usuario> listaUsuarios = ctrl.traerUsuarios();
        for (Usuario usu : listaUsuarios) {
            if (usu.getUsuario().equals(usuario)) {
                if (usu.getContraseña().equals(password)) {
                    mensaje = "Bienvenido";
                } else {
                    mensaje = "Contraseña incorrecta";
                }
            } else {
                mensaje = "Usuario incorrecto";
            }

        }
        return mensaje;
    }

    /**
     * --------------------------------------CRUD CONTROLADORA CLASE CLIENTE-------------------------------------------------
     */

    /**
     * ----------------------------------------------GUARDAR-----------------------------------------------------------------
     */
    public void cargarCliente(String nombre, String direccion, String cuit, String email, String localidad, String telefono) {
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setCuit(cuit);
        cliente.setDireccion(direccion);
        cliente.setLocalidad(localidad);
        cliente.setTelefono(telefono);
        cliente.setEmail(email);

        ctrl.guardarCliente(cliente);
    }

    /**
     * ----------------------------------------------MOSTRAR----------------------------------------------------------------
     */
    public List<Cliente> traerClientes() {
        return ctrl.traerClientes();
    }

    /**
     * ----------------------------------------------EDITAR-----------------------------------------------------------------
     */
    public Cliente traerCliente(int idCliente) {
        return ctrl.traerClientes(idCliente);
    }

    public void editarCliente(Cliente cliente, String nombre, String direccion, String cuit, String email, String localidad, String telefono) {
        cliente.setNombre(nombre);
        cliente.setCuit(cuit);
        cliente.setDireccion(direccion);
        cliente.setLocalidad(localidad);
        cliente.setTelefono(telefono);
        cliente.setEmail(email);

        ctrl.modificarCliente(cliente);
    }

    /**
     * ----------------------------------------------BORRAR-----------------------------------------------------------------
     */
    public void borrarCliente(int idCliente) {
        ctrl.borrarCliente(idCliente);
    }

    /**
     * --------------------------------------CRUD CONTROLADORA CLASE VEHICULO-------------------------------------------------
     */
    /**
     * ----------------------------------------------GUARDAR-----------------------------------------------------------------
     */
    public void cargarVehiculo(String vehiculo, String chofer, String patente) {
        Vehiculo v = new Vehiculo();
        v.setChofer(chofer);
        v.setVehiculo(vehiculo);
        v.setPatente(patente);
        ctrl.guardarVehiculo(v);
    }

    /**
     * ----------------------------------------------MOSTRAR----------------------------------------------------------------
     */
    public List<Vehiculo> traerVehiculos() {
        return ctrl.traerVehiculos();
    }

    /**
     * ----------------------------------------------EDITAR-----------------------------------------------------------------
     */
    public Vehiculo traerVehiculo(int idVehiculo) {
        return ctrl.traerVehiculo(idVehiculo);

    }

    public void editarVehiculo(Vehiculo vehiculo, String v, String chofer, String patente) {
        vehiculo.setVehiculo(v);
        vehiculo.setPatente(patente);
        vehiculo.setChofer(chofer);
        ctrl.modificarVehiculo(vehiculo);
    }

    /**
     * ----------------------------------------------BORRAR-----------------------------------------------------------------
     */
    public void borrarVehiculo(int idVehiculo) {
        ctrl.borrarVehiculo(idVehiculo);
    }

    /**
     * --------------------------------------CRUD CONTROLADORA DE CLASE REPRESENTANTE-------------------------------------------------
     */
    /**
     * ----------------------------------------------GUARDAR-----------------------------------------------------------------
     */
    public void cargarRepresentante(String nombre, String direccion, String localidad, String telefono) {
        Representantes representante = new Representantes();
        representante.setNombre(nombre);
        representante.setDireccion(direccion);
        representante.setLocalidad(localidad);
        representante.setTelefono(telefono);
        ctrl.guardarRepresentante(representante);
    }

    /**
     * ----------------------------------------------MOSTRAR----------------------------------------------------------------
     */
    public List<Representantes> traerRepresentantes() {
        return ctrl.traerRepresentantes();
    }

    /**
     * ----------------------------------------------BORRAR-----------------------------------------------------------------
     */
    public void borrarRepresentante(int idRepresentante) {
        ctrl.borrarRepresentante(idRepresentante);
    }

    /**
     * ----------------------------------------------EDITAR-----------------------------------------------------------------
     */
    public Representantes traerRepresentante(int idRepresentante) {
        return ctrl.traerRepresentantes(idRepresentante);
    }

    public void editarRepresentante(Representantes representante, String nombre, String localidad, String direccion, String telefono) {
        representante.setNombre(nombre);
        representante.setDireccion(direccion);
        representante.setLocalidad(localidad);
        representante.setTelefono(telefono);

        ctrl.modificarRepresentante(representante);
    }

    /**
     * --------------------------------------CRUD CONTROLADORA DE CLASE SERVICIO-------------------------------------------------
     */
    /**
     * ----------------------------------------------GUARDAR-----------------------------------------------------------------
     */
    public void cargarServicio(String servicio, String descripcion, Double precio) {
        Servicios s = new Servicios();
        s.setServicio(servicio);
        s.setDescripcion(descripcion);
        s.setPrecio(precio);
        ctrl.guardarServicios(s);
    }

    /**
     * ----------------------------------------------MOSTRAR----------------------------------------------------------------
     */
    public List<Servicios> traerServicios() {
        return ctrl.traerServicios();
    }

    /**
     * ----------------------------------------------EDITAR-----------------------------------------------------------------
     */
    public void editarServicio(Servicios servicios, String servicio, String descripcion, Double precio) {
        servicios.setDescripcion(descripcion);
        servicios.setServicio(servicio);
        servicios.setPrecio(precio);
        ctrl.modificarServicio(servicios);

    }

    public Servicios traerServicio(int idServicio) {
        return ctrl.traerServicio(idServicio);
    }

    /**
     * ----------------------------------------------BORRAR-----------------------------------------------------------------
     */
    public void borrarServicio(int idServicio) {
        ctrl.borrarServicio(idServicio);
    }

    /**
     * --------------------------------------CRUD CONTROLADORA CLASE MOVIMIENTOS-------------------------------------------------
     */
    /**
     * ----------------------------------------------GUARDAR-----------------------------------------------------------------
     */
    public void cargarMovimiento(String cliente, String destino, String servicio, String representante, int bulto, String monto, String flete, int remito, String fPr, Date fecha, String tFlete, String tMonto) {
        Movimientos m = new Movimientos();
        m.setCliente(cliente);
        m.setDestino(destino);
        m.setServicio(servicio);
        m.setRepresentante(representante);
        m.setBultos(bulto);
        m.setMonto(monto);
        m.setFlete(flete);
        m.setRemito(remito);
        m.setFecha(fecha);
        m.setTipoFlete(fPr);
        m.setTipoMonto(tMonto);
        m.setFleteDestinoOrigen(tFlete);
        ctrl.guardarMovimiento(m);
    }

    /**
     * ----------------------------------------------BORRAR-----------------------------------------------------------------
     */
    public void borrarMovimiento(int idM) {
        ctrl.borrarMovimiento(idM);
    }

    /**
     * ----------------------------------------------MOSTRAR----------------------------------------------------------------
     */
    public List<Movimientos> traerMovimientos() {
        return ctrl.traerMovimientos();
    }

    public void cargarDestino(String destino) {
        Destinos d = new Destinos();
        d.setLocaliad(destino);
        ctrl.guardarDestino(d);
    }

    /**
     * ----------------------------------------------EDITAR-----------------------------------------------------------------
     */
    public Movimientos traerMovimiento(int idMovimiento) {
        return ctrl.traerMovimiento(idMovimiento);
    }

    public void editarMovimiento(Movimientos mov, String cliente, String destino, String servicio, String representante, int bulto, String monto, String flete, int remito, String fPr, Date fecha, String tFlete, String tMonto) {
        mov.setCliente(cliente);
        mov.setDestino(destino);
        mov.setServicio(servicio);
        mov.setRepresentante(representante);
        mov.setBultos(bulto);
        mov.setMonto(monto);
        mov.setFlete(flete);
        mov.setRemito(remito);
        mov.setFecha(fecha);
        mov.setTipoFlete(fPr);
        mov.setTipoMonto(tMonto);
        mov.setFleteDestinoOrigen(tFlete);
        ctrl.modificarMovimiento(mov);
    }

    /**
     * ----------------------------------------------CLASE CONSULTAS METODOS!!-----------------------------------------------------------------
     */
    
}
/**
 * ----------------------------------------------EDITAR-----------------------------------------------------------------
 * public Vehiculo traerVehiculo(int idVehiculo) { return
 * ctrl.traerVehiculo(idVehiculo);
 *
 *
 * }
 *
 * public void editarVehiculo(Vehiculo vehiculo, String v, String chofer, String
 * patente) { vehiculo.setVehiculo(v); vehiculo.setPatente(patente);
 * vehiculo.setChofer(chofer); ctrl.modificarVehiculo(vehiculo); }
 */


