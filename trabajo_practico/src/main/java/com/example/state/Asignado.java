package com.example.state;

import com.example.context.Incidente;





public class Asignado implements Estado {

    

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
        t.setEstado(getEstadoAsString());
        
    }

    @Override
    public String getEstadoAsString() {
        return "ASIGNADO";
    }

    
}
