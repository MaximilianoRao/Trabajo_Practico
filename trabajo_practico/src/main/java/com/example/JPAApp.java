package com.example;

import com.example.entities.HelpDesk;
import com.example.entities.Servicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAApp {

    public static EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-unit");
        EntityManager em = emf.createEntityManager();
        return em;

    }

    public static void main(String[] args) {
        
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();

         /*   Servicio  s1 = new Servicio();
            s1.setNombre("AWS");
            s1.setDescripcion("ESs");
            s1.setIncidentes_idIncidentes(1);
            
            em.persist(s1);*/ 

            HelpDesk h1 = new HelpDesk();
            h1.setNombre("Maximiliano");
            em.persist(h1);

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            em.close();
        }
    }
    
}
