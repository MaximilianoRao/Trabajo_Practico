package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Tipo_de_Problema")
public class TipoProblema {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idTipo;

    @Column
    private Integer tiempoMaximo;

    @Column
    private Integer tiempoEstResolucion;

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public Integer getTiempoMaximo() {
        return tiempoMaximo;
    }

    public void setTiempoMaximo(Integer tiempoMaximo) {
        this.tiempoMaximo = tiempoMaximo;
    }

    public Integer getTiempoEstResolucion() {
        return tiempoEstResolucion;
    }

    public void setTiempoEstResolucion(Integer tiempoEstResolucion) {
        this.tiempoEstResolucion = tiempoEstResolucion;
    }

    public String getDescProblema() {
        return descProblema;
    }

    public void setDescProblema(String descProblema) {
        this.descProblema = descProblema;
    }

    @Column
    private String descProblema;
}
