package com.example.context;

import com.example.entities.HelpDesk;
import com.example.entities.Servicio;
import com.example.entities.Tecnico;
import com.example.state.Estado;
import java.time.LocalDateTime;
import com.example.entities.TipoProblema;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.List;

@Entity
@Table(name = "incidentes")
public class Incidente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idIncidente;

    

    @Column
    private String notaCierre;

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

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "HelpDesk_idHelpDesk")
    private HelpDesk help_desk;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "Tecnico_idTecnico")
    private Tecnico tecnico;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "Servicios_idServicio")
    private Servicio servicio;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "incidentes_has_tipo_de_problema", joinColumns = @JoinColumn(name = "idIncidente"),
    inverseJoinColumns = @JoinColumn(name ="idTipo"))
    private List<TipoProblema> tiposDeProblemas;


    public Incidente(Estado state) {
        this.estado = state.getEstadoAsString();
        this.state = state;
    }



    public Integer getIdIncidente() {
        return idIncidente;
    }



    public void setIdIncidente(Integer idIncidente) {
        this.idIncidente = idIncidente;
    }

    public String getNotaCiere() {
        return notaCierre;
    }



    public void setNotaCiere(String notaCierre) {
        this.notaCierre = notaCierre;
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



    public HelpDesk getHelp_desk() {
        return help_desk;
    }



    public void setHelp_desk(HelpDesk help_desk) {
        this.help_desk = help_desk;
    }



    public Tecnico getTecnico() {
        return tecnico;
    }



    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }



    public Servicio getServicio() {
        return servicio;
    }



    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }



    public String getNotaCierre() {
        return notaCierre;
    }



    public void setNotaCierre(String notaCierre) {
        this.notaCierre = notaCierre;
    }



    public List<TipoProblema> getTiposDeProblemas() {
        return tiposDeProblemas;
    }



    public void setTiposDeProblemas(List<TipoProblema> tiposDeProblemas) {
        this.tiposDeProblemas = tiposDeProblemas;
    }

        

}
