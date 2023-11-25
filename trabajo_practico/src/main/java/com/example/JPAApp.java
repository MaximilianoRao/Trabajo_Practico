package com.example;

import com.example.constant.TipoNotificacion;
import com.example.entities.Especialidad;
import com.example.entities.HelpDesk;
import com.example.entities.Servicio;
import com.example.entities.Tecnico;
import com.example.entities.TipoProblema;


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
            em.persist(s1);

            HelpDesk h1 = new HelpDesk();
            h1.setNombre("Maximiliano");
            em.persist(h1);

            TipoProblema t1 = new TipoProblema();
            t1.setTiempoEstResolucion(4);
            t1.setTiempoMaximo(6);
            t1.setDescProblema("Sin internet");
            em.persist(t1);

            Tecnico tc1 = new Tecnico();
            TipoNotificacion TipoEnum = TipoNotificacion.mail;
            tc1.setNombre("Ernesto");
            tc1.setNotificacion(TipoEnum);
            em.persist(tc1); 

            Especialidad e1 = new Especialidad();
            e1.setNombre("Windows");
            em.persist(e1); 

            Servicio s2 = new Servicio();
            s2.setNombre("Soporte SAP");
            

            TipoProblema ti2 = new TipoProblema();
            ti2.setTiempoMaximo(240);
            ti2.setTiempoEstResolucion(120);
            ti2.setDescProblema("Error de conexion");
            ti2.setServicio(s2);

            em.persist(s2);
            em.persist(ti2);
            */ 


            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            em.close();
        }
    }
    
}
