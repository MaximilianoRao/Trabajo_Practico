package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAApp {

    public static EntityManager gEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(null)
        EntityManager em = emf;


    }

    public static void main(String[] args) {
        
    }
    
}
