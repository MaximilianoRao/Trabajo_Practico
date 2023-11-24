package com.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HelpDesk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHelpDesk;

    private String nombre;

    public Integer getIdHelpDesk() {
        return idHelpDesk;
    }

    public void setIdHelpDesk(Integer idHelpDesk) {
        this.idHelpDesk = idHelpDesk;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
