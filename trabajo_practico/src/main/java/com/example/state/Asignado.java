package com.example.state;

import com.example.context.Incidente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estados")
public class Asignado implements Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstado;

    @Override
    public void apertura(Incidente t) {
        System.out.println("No se puede abrir un ticket que ya está asignado.");
        
    }

    @Override
    public void asignar(Incidente t) {
        System.out.println("El ticket ya está asignado a un tecnico.");
        
    }

    @Override
    public void resolver(Incidente t) {
        System.out.println("Resolviendo ticket...");
        t.setState(new Resuelto());
        
    }

    
}
