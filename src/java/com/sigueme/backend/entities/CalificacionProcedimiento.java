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
@Table(name = "CalificacionesProcedimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CalificacionProcedimiento.findAll", query = "SELECT c FROM CalificacionProcedimiento c")
    , @NamedQuery(name = "CalificacionProcedimiento.findByCalificacionProcedimientoID", query = "SELECT c FROM CalificacionProcedimiento c WHERE c.calificacionProcedimientoID = :calificacionProcedimientoID")
    , @NamedQuery(name = "CalificacionProcedimiento.findByCalificacionProcedimiento", query = "SELECT c FROM CalificacionProcedimiento c WHERE c.calificacionProcedimiento = :calificacionProcedimiento")})
public class CalificacionProcedimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CalificacionProcedimientoID")
    private Integer calificacionProcedimientoID;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "CalificacionProcedimiento")
    private String calificacionProcedimiento;

    public CalificacionProcedimiento() {
    }

    public CalificacionProcedimiento(Integer calificacionProcedimientoID) {
        this.calificacionProcedimientoID = calificacionProcedimientoID;
    }

    public CalificacionProcedimiento(Integer calificacionProcedimientoID, String calificacionProcedimiento) {
        this.calificacionProcedimientoID = calificacionProcedimientoID;
        this.calificacionProcedimiento = calificacionProcedimiento;
    }

    public Integer getCalificacionProcedimientoID() {
        return calificacionProcedimientoID;
    }

    public void setCalificacionProcedimientoID(Integer calificacionProcedimientoID) {
        this.calificacionProcedimientoID = calificacionProcedimientoID;
    }

    public String getCalificacionProcedimiento() {
        return calificacionProcedimiento;
    }

    public void setCalificacionProcedimiento(String calificacionProcedimiento) {
        this.calificacionProcedimiento = calificacionProcedimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calificacionProcedimientoID != null ? calificacionProcedimientoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalificacionProcedimiento)) {
            return false;
        }
        CalificacionProcedimiento other = (CalificacionProcedimiento) object;
        if ((this.calificacionProcedimientoID == null && other.calificacionProcedimientoID != null) || (this.calificacionProcedimientoID != null && !this.calificacionProcedimientoID.equals(other.calificacionProcedimientoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigueme.backend.entities.CalificacionProcedimiento[ calificacionProcedimientoID=" + calificacionProcedimientoID + " ]";
    }
    
}
