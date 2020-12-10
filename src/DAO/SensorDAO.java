/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Sensor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author user
 */
public class SensorDAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Parcial2PU");
    
    public void crear(Sensor sensor){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(sensor);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally{
            em.close();
        }
    }
    
    public boolean eliminar(Sensor sensor){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            em.remove(sensor);
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
    
    public Sensor leer(Sensor par){
        EntityManager em = emf.createEntityManager();
        Sensor sensor = null;
        Query q = em.createQuery("SELECT s FROM Sensor s " +
                        " WHERE s.id = :id")
                        .setParameter("id", par.getId());
        
        try {
            sensor = (Sensor) q.getSingleResult();
        } catch (NonUniqueResultException e){
            sensor = (Sensor) q.getResultList().get(0);
        }catch (Exception e) {
            e.printStackTrace();
        } finally{
            em.close();
            return sensor;
        }
    }
    
    public boolean actualizar(Sensor sensor, Sensor nuevoSensor){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            sensor = leer(sensor);
            sensor.setUbicacion(nuevoSensor.getUbicacion());
            em.merge(sensor);
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
