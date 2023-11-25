package com.example;

import java.time.LocalDateTime;
import java.time.Month;

import com.example.constant.TipoNotificacion;
import com.example.context.Incidente;
import com.example.entities.Especialidad;
import com.example.entities.HelpDesk;
import com.example.entities.Servicio;
import com.example.entities.Tecnico;
import com.example.entities.TipoProblema;
import com.example.state.Abierto;

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

         /* 

          

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
            HelpDesk h1 = new HelpDesk();
            h1.setNombre("Maximiliano");
            em.persist(h1);

            Servicio  s1 = new Servicio();
            s1.setNombre("AWS");
            em.persist(s1);

            Tecnico tc1 = new Tecnico();
            TipoNotificacion TipoEnum = TipoNotificacion.mail;
            tc1.setNombre("Ernesto");
            tc1.setNotificacion(TipoEnum);
            em.persist(tc1); 

            Incidente i1 = new Incidente(new Abierto());
            i1.setDescripcion("Problema de internet");
            i1.setEsComplejo(false);
            i1.setFechaApertura(LocalDateTime.now());
            i1.setTitulo("WINDOWS - SIN INTERNET");
            i1.setHelp_desk(h1);
            i1.setServicio(s1);
            i1.setTecnico(tc1);
            em.persist(i1);
            i1.asignar();

            
            

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            em.close();
        }
    }
    
}
