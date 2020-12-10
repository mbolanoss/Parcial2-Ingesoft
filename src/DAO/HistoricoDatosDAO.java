/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.HistoricoDatos;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author user
 */
public class HistoricoDatosDAO {
    private static EntityManagerFactory 
            emf = Persistence.createEntityManagerFactory("Parcial2PU");
    
    public void crear(HistoricoDatos historico){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(historico);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally{
            em.close();
        }
    }
    
    public boolean eliminar(HistoricoDatos historico){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            em.remove(historico);
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
    
    public HistoricoDatos leer(HistoricoDatos par){
        EntityManager em = emf.createEntityManager();
        HistoricoDatos historico = null;
        Query q = em.createQuery("SELECT h FROM HistoricosDatos h " +
                        " WHERE h.id = :id")
                        .setParameter("id", par.getId());
        
        try {
            historico = (HistoricoDatos) q.getSingleResult();
        } catch (NonUniqueResultException e){
            historico = (HistoricoDatos) q.getResultList().get(0);
        }catch (Exception e) {
            e.printStackTrace();
        } finally{
            em.close();
            return historico;
        }
    }
    
    public boolean actualizar(HistoricoDatos historico, HistoricoDatos nuevoHistorico){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            historico = leer(historico);
            historico.setValorTomado(nuevoHistorico.getValorTomado());
            historico.setFecha(nuevoHistorico.getFecha());
            historico.setHora(nuevoHistorico.getHora());
            historico.setProcesamiento(nuevoHistorico.getProcesamiento());
            
            em.merge(historico);
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
