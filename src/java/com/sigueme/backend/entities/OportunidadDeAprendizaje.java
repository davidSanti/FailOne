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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Santi
 */
@Entity
@Table(name = "OportunidadesDeAprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OportunidadDeAprendizaje.findAll", query = "SELECT o FROM OportunidadDeAprendizaje o")
    , @NamedQuery(name = "OportunidadDeAprendizaje.findByOportunidadID", query = "SELECT o FROM OportunidadDeAprendizaje o WHERE o.oportunidadID = :oportunidadID")
    , @NamedQuery(name = "OportunidadDeAprendizaje.findByNombre", query = "SELECT o FROM OportunidadDeAprendizaje o WHERE o.nombre = :nombre")
    , @NamedQuery(name = "OportunidadDeAprendizaje.findByFechaInicio", query = "SELECT o FROM OportunidadDeAprendizaje o WHERE o.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "OportunidadDeAprendizaje.findByFechaFin", query = "SELECT o FROM OportunidadDeAprendizaje o WHERE o.fechaFin = :fechaFin")
    , @NamedQuery(name = "OportunidadDeAprendizaje.findByNumIntentos", query = "SELECT o FROM OportunidadDeAprendizaje o WHERE o.numIntentos = :numIntentos")})
public class OportunidadDeAprendizaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "OportunidadID")
    private Integer oportunidadID;
    
    @Size(max = 70)
    @Column(name = "Nombre")
    private String nombre;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "Descripcion")
    private String descripcion;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "Razon")
    private String razon;
    
    @Column(name = "NumIntentos")
    private Integer numIntentos = 1;
    
    @JoinColumn(name = "IdEstado", referencedColumnName = "EstadoID", insertable = false)
    @ManyToOne(optional = false)
    private EstadoOportunidad idEstado;
    
    @JoinTable(name = "OportunidadesUsuarios", joinColumns = {
        @JoinColumn(name = "CedulaUsuario", referencedColumnName = "Cedula")}, inverseJoinColumns = {
        @JoinColumn(name = "IdOportunidad", referencedColumnName = "OportunidadID")})
    @ManyToMany (fetch=FetchType.EAGER)
    private List<Usuario> usuariosOportunidad;
    
    @ManyToMany (mappedBy = "oportunidadesDeAprendizajeIncidencia")
    private List<Incidencia> incidenciasOportunidad;
    
///////Aquí debemos poner la relación con la tabla ternaria ObservacionRespuesta  
 //    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oportunidadID")
//    private List<ObservacionRespuesta> observacionRespuestaList;
        
    public OportunidadDeAprendizaje() {
    }

    public OportunidadDeAprendizaje(Integer oportunidadID) {
        this.oportunidadID = oportunidadID;
    }

    public OportunidadDeAprendizaje(Integer oportunidadID, String nombre,
            Date fechaInicio, Date fechaFin, String descripcion, 
            String razon, List<Usuario> usuariosOportunidad) 
    {
        this.oportunidadID = oportunidadID;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.razon = razon;
        this.usuariosOportunidad = usuariosOportunidad;
    }

    public OportunidadDeAprendizaje(Integer oportunidadID, String nombre, Date fechaInicio, Date fechaFin, String descripcion, String razon, List<Usuario> usuariosOportunidad, List<Incidencia> incidenciasOportunidad) {
        this.oportunidadID = oportunidadID;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.razon = razon;
        this.usuariosOportunidad = usuariosOportunidad;
        this.incidenciasOportunidad = incidenciasOportunidad;
    }

    public Integer getOportunidadID() {
        return oportunidadID;
    }

    public void setOportunidadID(Integer oportunidadID) {
        this.oportunidadID = oportunidadID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public Integer getNumIntentos() {
        return numIntentos;
    }

    public void setNumIntentos(Integer numIntentos) {
        this.numIntentos = numIntentos;
    }

    public EstadoOportunidad getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoOportunidad idEstado) {
        this.idEstado = idEstado;
    }

    public List<Usuario> getUsuariosOportunidad() {
        return usuariosOportunidad;
    }

    public void setUsuariosOportunidad(List<Usuario> usuariosOportunidad) {
        this.usuariosOportunidad = usuariosOportunidad;
    }

    public List<Incidencia> getIncidenciasOportunidad() {
        return incidenciasOportunidad;
    }

    public void setIncidenciasOportunidad(List<Incidencia> incidenciasOportunidad) {
        this.incidenciasOportunidad = incidenciasOportunidad;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oportunidadID != null ? oportunidadID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OportunidadDeAprendizaje)) {
            return false;
        }
        OportunidadDeAprendizaje other = (OportunidadDeAprendizaje) object;
        if ((this.oportunidadID == null && other.oportunidadID != null) || (this.oportunidadID != null && !this.oportunidadID.equals(other.oportunidadID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigueme.backend.entities.OportunidadDeAprendizaje[ oportunidadID=" + oportunidadID + " ]";
    }
    
}
