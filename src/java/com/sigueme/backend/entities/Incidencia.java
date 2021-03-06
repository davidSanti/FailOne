/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.backend.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santi
 */
@Entity
@Table(name = "Incidencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incidencia.findAll", query = "SELECT i FROM Incidencia i")
    , @NamedQuery(name = "Incidencia.findByIncidenciaID", query = "SELECT i FROM Incidencia i WHERE i.incidenciaID = :incidenciaID")
    , @NamedQuery(name = "Incidencia.findByNumeroDeCaso", query = "SELECT i FROM Incidencia i WHERE i.numeroDeCaso = :numeroDeCaso")
    , @NamedQuery(name = "Incidencia.findByFechaRegistro", query = "SELECT i FROM Incidencia i WHERE i.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Incidencia.findByEstado", query = "SELECT i FROM Incidencia i WHERE i.estado = :estado")})
public class Incidencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IncidenciaID", insertable = false)
    private int incidenciaID;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumeroDeCaso")
    private Integer numeroDeCaso;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaRegistro", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "Descripcion")
    private String descripcion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private boolean estado = true;
  
    @JoinColumn(name = "IdCategoria", referencedColumnName = "ServicioID")
    @ManyToOne(optional = false)
    private Servicio idCategoria;
    
    @JoinColumn(name = "Agente", referencedColumnName = "Cedula")
    @ManyToOne(optional = false)
    private Usuario agente;
    
    @JoinTable(name = "ErroresIncidencia", joinColumns = {
        @JoinColumn(name = "IdError", referencedColumnName = "ErrorID")}, inverseJoinColumns = {
        @JoinColumn(name = "NumCasoIncidencia", referencedColumnName = "NumeroDeCaso")})
    @ManyToMany (fetch = FetchType.EAGER)
    private List<ErrorFrecuente> erroresFrecuentes;    
    
    @JoinTable(name = "IncidenciasOportunidad", joinColumns = {
       @JoinColumn(name = "IdOportunidad", referencedColumnName = "OportunidadID")}, inverseJoinColumns = {
       @JoinColumn(name = "NumCasoIncidencia", referencedColumnName = "NumeroDeCaso")})
    @ManyToMany (fetch = FetchType.EAGER)
    private List<OportunidadDeAprendizaje> oportunidadesDeAprendizajeIncidencia; 
    
    
    public Incidencia() {
    }

    public Incidencia(Integer numeroDeCaso) {
        this.numeroDeCaso = numeroDeCaso;
    }

    public Incidencia(Integer numeroDeCaso, String descripcion, 
                      Servicio idCategoria, Usuario agente) 
    {
        this.numeroDeCaso = numeroDeCaso;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.agente = agente;
    }

    public int getIncidenciaID() {
        return incidenciaID;
    }

    public void setIncidenciaID(int incidenciaID) {
        this.incidenciaID = incidenciaID;
    }

    public Integer getNumeroDeCaso() {
        return numeroDeCaso;
    }

    public void setNumeroDeCaso(Integer numeroDeCaso) {
        this.numeroDeCaso = numeroDeCaso;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Servicio getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Servicio idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Usuario getAgente() {
        return agente;
    }

    public void setAgente(Usuario agente) {
        this.agente = agente;
    }

    public List<OportunidadDeAprendizaje> getOportunidadesDeAprendizajeIncidencia() {
        return oportunidadesDeAprendizajeIncidencia;
    }

    public void setOportunidadesDeAprendizajeIncidencia(List<OportunidadDeAprendizaje> oportunidadesDeAprendizajeIncidencia) {
        this.oportunidadesDeAprendizajeIncidencia = oportunidadesDeAprendizajeIncidencia;
    }

    public List<ErrorFrecuente> getErroresFrecuentes() {
        return erroresFrecuentes;
    }

    public void setErroresFrecuentes(List<ErrorFrecuente> erroresFrecuentes) {
        this.erroresFrecuentes = erroresFrecuentes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroDeCaso != null ? numeroDeCaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incidencia)) {
            return false;
        }
        Incidencia other = (Incidencia) object;
        if ((this.numeroDeCaso == null && other.numeroDeCaso != null) || (this.numeroDeCaso != null && !this.numeroDeCaso.equals(other.numeroDeCaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigueme.backend.entities.Incidencia[ numeroDeCaso=" + numeroDeCaso + " ]";
    }
    
}
