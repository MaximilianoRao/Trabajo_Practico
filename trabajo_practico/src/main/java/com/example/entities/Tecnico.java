package com.example.entities;

import com.example.constant.TipoNotificacion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idTecnico;

    @Column
    private String nombre;

    @Column
    @Enumerated(EnumType.STRING)
    private TipoNotificacion notificacion;

    public Integer getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Integer idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoNotificacion getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(TipoNotificacion notificacion) {
        this.notificacion = notificacion;
    }
}
