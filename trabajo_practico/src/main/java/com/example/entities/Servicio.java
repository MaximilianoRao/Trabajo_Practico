package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idServicio;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private Integer Incidentes_idIncidentes;
    

    
    public Integer getIncidentes_idIncidentes() {
        return Incidentes_idIncidentes;
    }

    public void setIncidentes_idIncidentes(Integer incidentes_idIncidentes) {
        Incidentes_idIncidentes = incidentes_idIncidentes;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
