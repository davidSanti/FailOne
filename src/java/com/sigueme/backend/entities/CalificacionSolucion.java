/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.backend.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santi
 */
@Entity
@Table(name = "CalificacionesSolucion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CalificacionSolucion.findAll", query = "SELECT c FROM CalificacionSolucion c")
    , @NamedQuery(name = "CalificacionSolucion.findByCalificacionSolucionID", query = "SELECT c FROM CalificacionSolucion c WHERE c.calificacionSolucionID = :calificacionSolucionID")
    , @NamedQuery(name = "CalificacionSolucion.findByCalificacionSolucion", query = "SELECT c FROM CalificacionSolucion c WHERE c.calificacionSolucion = :calificacionSolucion")})
public class CalificacionSolucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CalificacionSolucionID")
    private Integer calificacionSolucionID;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "CalificacionSolucion")
    private String calificacionSolucion;

    public CalificacionSolucion() {
    }

    public CalificacionSolucion(Integer calificacionSolucionID) {
        this.calificacionSolucionID = calificacionSolucionID;
    }

    public CalificacionSolucion(Integer calificacionSolucionID, String calificacionSolucion) {
        this.calificacionSolucionID = calificacionSolucionID;
        this.calificacionSolucion = calificacionSolucion;
    }

    public Integer getCalificacionSolucionID() {
        return calificacionSolucionID;
    }

    public void setCalificacionSolucionID(Integer calificacionSolucionID) {
        this.calificacionSolucionID = calificacionSolucionID;
    }

    public String getCalificacionSolucion() {
        return calificacionSolucion;
    }

    public void setCalificacionSolucion(String calificacionSolucion) {
        this.calificacionSolucion = calificacionSolucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calificacionSolucionID != null ? calificacionSolucionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalificacionSolucion)) {
            return false;
        }
        CalificacionSolucion other = (CalificacionSolucion) object;
        if ((this.calificacionSolucionID == null && other.calificacionSolucionID != null) || (this.calificacionSolucionID != null && !this.calificacionSolucionID.equals(other.calificacionSolucionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigueme.backend.entities.CalificacionSolucion[ calificacionSolucionID=" + calificacionSolucionID + " ]";
    }
    
}
