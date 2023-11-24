package com.example.state;

import com.example.context.Incidente;

public class Abierto implements Estado {

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
