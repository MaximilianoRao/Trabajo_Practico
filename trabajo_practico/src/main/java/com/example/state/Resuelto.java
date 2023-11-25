package com.example.state;

import com.example.context.Incidente;





public class Resuelto implements Estado{


    @Override
    public void apertura(Incidente t) {
        System.out.println("No se puede abrir un ticket que ya está resuelto.");
    }

    @Override
    public void asignar(Incidente t) {
        System.out.println("No se puede asignar un ticket que ya está resuelto.");
    }

    @Override
    public void resolver(Incidente t) {
        System.out.println("El ticket ya está resuelto.");
        
    }

    @Override
    public String getEstadoAsString() {
        return "RESUELTO";
    }
    
    
}
