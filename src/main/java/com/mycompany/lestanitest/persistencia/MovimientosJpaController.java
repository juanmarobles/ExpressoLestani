/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lestanitest.persistencia;

import com.mycompany.lestanitest.logica.Movimientos;
import com.mycompany.lestanitest.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author juanm
 */
public class MovimientosJpaController implements Serializable {

    public MovimientosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public MovimientosJpaController() {
        emf = Persistence.createEntityManagerFactory("expressoJPAPU");

    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movimientos movimientos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(movimientos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movimientos movimientos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            movimientos = em.merge(movimientos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = movimientos.getId_movimientos();
                if (findMovimientos(id) == null) {
                    throw new NonexistentEntityException("The movimientos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movimientos movimientos;
            try {
                movimientos = em.getReference(Movimientos.class, id);
                movimientos.getId_movimientos();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movimientos with id " + id + " no longer exists.", enfe);
            }
            em.remove(movimientos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movimientos> findMovimientosEntities() {
        return findMovimientosEntities(true, -1, -1);
    }

    public List<Movimientos> findMovimientosEntities(int maxResults, int firstResult) {
        return findMovimientosEntities(false, maxResults, firstResult);
    }

    private List<Movimientos> findMovimientosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movimientos.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Movimientos findMovimientos(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movimientos.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovimientosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movimientos> rt = cq.from(Movimientos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

   public List<Movimientos> getMovimientos() {
        EntityManager em = getEntityManager(); 

        try {
            String jpql = "SELECT m FROM Movimientos m ORDER BY m.id_movimientos DESC";
            TypedQuery<Movimientos> query = em.createQuery(jpql, Movimientos.class)
                    .setMaxResults(500); 

            return query.getResultList();
        } finally {
            em.close(); 
        }
    }
   
    public List<Movimientos> getMovimientosRecibo() {
        EntityManager em = getEntityManager(); 

        try {
            String jpql = "SELECT m FROM Movimientos m ORDER BY m.id_movimientos DESC";
            TypedQuery<Movimientos> query = em.createQuery(jpql, Movimientos.class); 

            return query.getResultList();
        } finally {
            em.close(); 
        }
    }
   
    public List<Movimientos> getMovimientosConsulta(Date fechaDesde, Date fechaHasta) {
           EntityManager em = getEntityManager();
    
    try {
        String jpql = "SELECT m FROM Movimientos m WHERE m.fecha >= :fechaDesde AND m.fecha <= :fechaHasta ORDER BY m.fecha DESC";
        TypedQuery<Movimientos> query = em.createQuery(jpql, Movimientos.class);
        query.setParameter("fechaDesde", fechaDesde);
        query.setParameter("fechaHasta", fechaHasta);
        
        return query.getResultList();
    } finally {
        em.close();
    }
    
    }
     public List<Movimientos> getMovimientosConsulta(Date fecha) {
           EntityManager em = getEntityManager();
    
    try {
        String jpql = "SELECT m FROM Movimientos m WHERE m.fecha >= :fecha ORDER BY m.fecha DESC";
        TypedQuery<Movimientos> query = em.createQuery(jpql, Movimientos.class);
        query.setParameter("fecha", fecha);
        return query.getResultList();
    } finally {
        em.close();
    }
    }

     public Integer getSecuenciaRemito() {
        EntityManager em = getEntityManager();
        try {
            String jpql = "SELECT m.secuenciaRemito FROM Movimientos m ORDER BY m.secuenciaRemito DESC";
            TypedQuery<Integer> query = em.createQuery(jpql, Integer.class);
            query.setMaxResults(1); // Solo queremos el primer resultado
            return query.getSingleResult();
        } finally {
            em.close();
        }
    }

  List<Movimientos> getMovimientosConsultaOrigenFiltrado(Date fechaDesde, Date fechaHasta, String origenFiltrado) {
    EntityManager em = getEntityManager();

    try {
        String jpql = "SELECT m FROM Movimientos m " +
                      "WHERE m.fecha >= :fechaDesde " +
                      "AND m.fecha <= :fechaHasta " +
                      "AND m.cliente LIKE CONCAT('%', :origenFiltrado, '%') " + 
                      "ORDER BY m.fecha DESC";

        TypedQuery<Movimientos> query = em.createQuery(jpql, Movimientos.class);
        query.setParameter("fechaDesde", fechaDesde);
        query.setParameter("fechaHasta", fechaHasta);
        query.setParameter("origenFiltrado", origenFiltrado);

        return query.getResultList();
    } finally {
        em.close();
    }
}

    List<Movimientos> getMovimientoReciboFiltrado(Date fechaDesde, Date fechaHasta, String cliente) {
        EntityManager em = getEntityManager();

    try {
        String jpql = "SELECT m FROM Movimientos m " +
                      "WHERE m.fecha >= :fechaDesde " +
                      "AND m.fecha <= :fechaHasta " +
                      "AND m.cliente LIKE CONCAT('%', :cliente, '%') " +
                      "AND m.tipoMontoP = 'Si' " +
                      "AND m.tipoMontoR <> 'Si' " +  
                      "ORDER BY m.fecha DESC";

        TypedQuery<Movimientos> query = em.createQuery(jpql, Movimientos.class);
        query.setParameter("fechaDesde", fechaDesde);
        query.setParameter("fechaHasta", fechaHasta);
        query.setParameter("cliente", cliente);

        return query.getResultList();
    } finally {
        em.close();
    }
    }

    List<Movimientos> getMovimientosConsultaDestinoFiltrado(Date fechaDesde, Date fechaHasta, String destinoFiltrado) {
        EntityManager em = getEntityManager();

            try {
                String jpql = "SELECT m FROM Movimientos m " +
                              "WHERE m.fecha >= :fechaDesde " +
                              "AND m.fecha <= :fechaHasta " +
                              "AND m.destino LIKE CONCAT('%', :destinoFiltrado, '%') " + 
                              "ORDER BY m.fecha DESC";

                TypedQuery<Movimientos> query = em.createQuery(jpql, Movimientos.class);
                query.setParameter("fechaDesde", fechaDesde);
                query.setParameter("fechaHasta", fechaHasta);
                query.setParameter("destinoFiltrado", destinoFiltrado);

                return query.getResultList();
            } finally {
                em.close();
            }  
    }

  public void actualizarFletes(String ids, String nuevoValorFlete) {
    EntityManager em = getEntityManager();
    try {
        em.getTransaction().begin();
        
        StoredProcedureQuery query = em.createStoredProcedureQuery("sp_actualizarFlete");
        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        query.setParameter(1, ids);
        query.setParameter(2, nuevoValorFlete);
        
        query.execute();
        
        em.getTransaction().commit(); // Commit para aplicar los cambios
        
    } catch (Exception ex) {
        em.getTransaction().rollback();
        Logger.getLogger(MovimientosJpaController.class.getName()).log(Level.SEVERE, "Error al ejecutar SP", ex);
        throw new RuntimeException("Error al ejecutar SP", ex);
    } finally {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}

     public List<Movimientos> getMovActualizados(String ids) {
    EntityManager em = getEntityManager();
    try {
        em.getTransaction().begin();
        
        // Convertir ids a un arreglo de enteros
        String[] idStrings = ids.split(",");
        List<Integer> idMovimientos = new ArrayList<>();
        for (String idString : idStrings) {
            idMovimientos.add(Integer.parseInt(idString.trim())); // Asegúrate de eliminar espacios en blanco alrededor de los IDs
        }

        // Construir la consulta JPQL con IN (:ids)
        TypedQuery<Movimientos> query = em.createQuery(
            "SELECT m FROM Movimientos m WHERE m.id_movimientos IN (:ids)", Movimientos.class);
        query.setParameter("ids", idMovimientos);

        List<Movimientos> movimientosActualizados = query.getResultList();
        em.getTransaction().commit();
        return movimientosActualizados;
    } catch (Exception ex) {
        em.getTransaction().rollback();
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error al obtener los valores actualizados de FLETE", ex);
        return Collections.emptyList(); // O maneja el error según tu lógica de aplicación
    } finally {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}

   
}





