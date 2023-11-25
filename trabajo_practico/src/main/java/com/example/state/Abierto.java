package com.example.state;

import com.example.context.Incidente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "estados")
public class Abierto implements Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstado;

    @Override
    public void apertura(Incidente t) {
        System.out.println("El incidente ya está abierto.");
        
    }

    @Override
    public void asignar(Incidente t) {
        System.out.println("Asignando incidente "+ t.getIdIncidente() + " ...");
        t.setState(new Asignado());
        
    }

    @Override
    public void resolver(Incidente t) {
        System.out.println("No se puede resolver un ticket que está abierto.");
    }



    
    
}
