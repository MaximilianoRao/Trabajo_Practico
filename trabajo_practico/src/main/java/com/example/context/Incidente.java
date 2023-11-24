package com.example.context;

import com.example.state.Estado;

public class Incidente {
    
    private Integer idIncidente;
    private Integer tiempoEstResol;
    private String notaCiere;

    private java.util.Date fechaApertura;

    private Boolean esComplejo;
    private java.util.Date fechaResolucion;
    private String descripcion;
    private String titulo;



    private Estado state;



    public Incidente(Integer idIncidente, Estado state) {
        this.idIncidente = idIncidente;
        this.state = state;
    }



    public Integer getIdIncidente() {
        return idIncidente;
    }



    public void setIdIncidente(Integer idIncidente) {
        this.idIncidente = idIncidente;
    }



    public Integer getTiempoEstResol() {
        return tiempoEstResol;
    }



    public void setTiempoEstResol(Integer tiempoEstResol) {
        this.tiempoEstResol = tiempoEstResol;
    }



    public String getNotaCiere() {
        return notaCiere;
    }



    public void setNotaCiere(String notaCiere) {
        this.notaCiere = notaCiere;
    }



    public java.util.Date getFechaApertura() {
        return fechaApertura;
    }



    public void setFechaApertura(java.util.Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }



    public Boolean getEsComplejo() {
        return esComplejo;
    }



    public void setEsComplejo(Boolean esComplejo) {
        this.esComplejo = esComplejo;
    }



    public java.util.Date getFechaResolucion() {
        return fechaResolucion;
    }



    public void setFechaResolucion(java.util.Date fechaResolucion) {
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

}
