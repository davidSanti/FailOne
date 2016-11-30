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
@Table(name = "Procedimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procedimiento.findAll", query = "SELECT p FROM Procedimiento p")
    , @NamedQuery(name = "Procedimiento.findByProcedimientoID", query = "SELECT p FROM Procedimiento p WHERE p.procedimientoID = :procedimientoID")
    , @NamedQuery(name = "Procedimiento.findByNombre", query = "SELECT p FROM Procedimiento p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Procedimiento.findByFecha", query = "SELECT p FROM Procedimiento p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "Procedimiento.findByEstado", query = "SELECT p FROM Procedimiento p WHERE p.estado = :estado")})
public class Procedimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProcedimientoID")
    private Integer procedimientoID;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nombre")
    private String nombre;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "Descripcion")
    private String descripcion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private boolean estado = true;
    
    @JoinTable(name = "SolucionesProcedimiento", joinColumns = {
        @JoinColumn(name = "IdProcedimiento", referencedColumnName = "ProcedimientoID")}, inverseJoinColumns = {
        @JoinColumn(name = "IdSolucion", referencedColumnName = "SolucionID")})
    @ManyToMany (fetch = FetchType.EAGER)
    private List<Solucion> solucionProcedimiento;
    
    @JoinColumn(name = "Categoria", referencedColumnName = "ServicioID")
    @ManyToOne(optional = false)
    private Servicio categoria;
    
    @JoinColumn(name = "Agente", referencedColumnName = "Cedula")
    @ManyToOne(optional = false)
    private Usuario agente;
    
    @JoinColumn(name = "OportunidadID", referencedColumnName = "OportunidadID")
    @ManyToOne(optional = false)
    private OportunidadDeAprendizaje oportunidadID;
    
    public Procedimiento() {
    }

    public Procedimiento(Integer procedimientoID) {
        this.procedimientoID = procedimientoID;
    }

    public Procedimiento(Integer procedimientoID, String nombre, String descripcion) {
        this.procedimientoID = procedimientoID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getProcedimientoID() {
        return procedimientoID;
    }

    public void setProcedimientoID(Integer procedimientoID) {
        this.procedimientoID = procedimientoID;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Servicio getCategoria() {
        return categoria;
    }

    public void setCategoria(Servicio categoria) {
        this.categoria = categoria;
    }

    public Usuario getAgente() {
        return agente;
    }

    public void setAgente(Usuario agente) {
        this.agente = agente;
    }

    public List<Solucion> getSolucionProcedimiento() {
        return solucionProcedimiento;
    }

    public void setSolucionProcedimiento(List<Solucion> solucionProcedimiento) {
        this.solucionProcedimiento = solucionProcedimiento;
    }

    public OportunidadDeAprendizaje getOportunidadID() {
        return oportunidadID;
    }

    public void setOportunidadID(OportunidadDeAprendizaje oportunidadID) {
        this.oportunidadID = oportunidadID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (procedimientoID != null ? procedimientoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procedimiento)) {
            return false;
        }
        Procedimiento other = (Procedimiento) object;
        if ((this.procedimientoID == null && other.procedimientoID != null) || (this.procedimientoID != null && !this.procedimientoID.equals(other.procedimientoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigueme.backend.entities.Procedimiento[ procedimientoID=" + procedimientoID + " ]";
    }
    
}
