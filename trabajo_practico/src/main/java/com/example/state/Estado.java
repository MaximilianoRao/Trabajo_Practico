package com.example.state;

import com.example.context.Incidente;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


public interface Estado {
    
    public void apertura(Incidente t);

    public void asignar(Incidente t);

    public void resolver(Incidente t);

}
