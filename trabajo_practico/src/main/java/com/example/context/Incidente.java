package com.example.context;

import com.example.state.Estado;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "incidentes")
public class Incidente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idIncidente;

    

    @Column
    private String notaCiere;

    @Column
    private LocalDateTime fechaApertura;

    @Column
    private Boolean esComplejo;

    @Column
    private LocalDateTime fechaResolucion;

    @Column
    private String descripcion;

    @Column
    private String titulo;

    @Column(name = "estado")
    private String estado;

    @Transient
    private Estado state;



    public Incidente(Integer idIncidente, Estado state) {
        this.idIncidente = idIncidente;
        this.estado = state.getEstadoAsString();
    }



    public Integer getIdIncidente() {
        return idIncidente;
    }



    public void setIdIncidente(Integer idIncidente) {
        this.idIncidente = idIncidente;
    }

    public String getNotaCiere() {
        return notaCiere;
    }



    public void setNotaCiere(String notaCiere) {
        this.notaCiere = notaCiere;
    }



    public LocalDateTime getFechaApertura() {
        return fechaApertura;
    }



    public void setFechaApertura(LocalDateTime fechaApertura) {
        this.fechaApertura = fechaApertura;
    }



    public Boolean getEsComplejo() {
        return esComplejo;
    }



    public void setEsComplejo(Boolean esComplejo) {
        this.esComplejo = esComplejo;
    }



    public LocalDateTime getFechaResolucion() {
        return fechaResolucion;
    }



    public void setFechaResolucion(LocalDateTime fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }



    public String getDescripcion() {
        return descripcion;
    }



    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public String getTitulo() {
        return titulo;
    }



    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }



    public Estado getState() {
        return state;
    }



    public void setState(Estado state) {
        this.state = state;
    }


    public void apertura(){
        this.state.apertura(this);
    }

    public void asignar(){
        this.state.asignar(this);
    }
    

    public void resolver(){

        this.state.resolver(null);

    }

    public String getEstado() {
        return estado;
    }



    public void setEstado(String estado) {
        this.estado = estado;
    }

    

}
