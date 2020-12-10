/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.TipoSensor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author user
 */
public class TipoSensorDAO {
    private static EntityManagerFactory 
            emf = Persistence.createEntityManagerFactory("Parcial2PU");
    
    public void crear(TipoSensor tipo){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(tipo);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally{
            em.close();
        }
    }
    
    public boolean eliminar(TipoSensor tipo){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            em.remove(tipo);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally{
            em.close();
            return ret;
        }
    }
    
    public TipoSensor leer(TipoSensor par){
        EntityManager em = emf.createEntityManager();
        TipoSensor tipo = null;
        Query q = em.createQuery("SELECT t FROM TipoSensor t " +
                        " WHERE t.tipo LIKE :tipo")
                        .setParameter("tipo", par.getTipo());
        
        try {
            tipo = (TipoSensor) q.getSingleResult();
        } catch (NonUniqueResultException e){
            tipo = (TipoSensor) q.getResultList().get(0);
        }catch (Exception e) {
            e.printStackTrace();
        } finally{
            em.close();
            return tipo;
        }
    }
    
    public boolean actualizar(TipoSensor tipo, TipoSensor nuevoTipo){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            tipo = leer(tipo);
            tipo.setNombre(nuevoTipo.getNombre());
            tipo.setMaximoPermitido(nuevoTipo.getMaximoPermitido());
            tipo.setMinimoPermitido(nuevoTipo.getMinimoPermitido());
            tipo.setPromedio(nuevoTipo.isPromedio());
            tipo.setNumeroHoras(nuevoTipo.getNumeroHoras());
            em.merge(tipo);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally{
            em.close();
            return ret;
        }
    }
}
