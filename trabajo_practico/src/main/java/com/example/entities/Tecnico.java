package com.example.entities;

import java.util.List;

import com.example.constant.TipoNotificacion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany
    @JoinTable(name = "tecnico_has_especialidad", joinColumns = @JoinColumn(name = "idTecnico"),
    inverseJoinColumns = @JoinColumn(name ="idEspecialidad"))
    private List<Especialidad> especialidades;


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

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    
}
