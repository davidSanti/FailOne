/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.backend.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Santi
 */
@Entity
@Table(name = "ObservacionesOportunidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObservacionOportunidad.findAll", query = "SELECT o FROM ObservacionOportunidad o")
    , @NamedQuery(name = "ObservacionOportunidad.findByObservacionID", query = "SELECT o FROM ObservacionOportunidad o WHERE o.observacionID = :observacionID")
    , @NamedQuery(name = "ObservacionOportunidad.findByObservacion", query = "SELECT o FROM ObservacionOportunidad o WHERE o.observacion = :observacion")})
public class ObservacionOportunidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ObservacionID")
    private Integer observacionID;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Observacion")
    private String observacion;
    
    //Mapeo con la tabla  ternaria observacion respuesta
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "observacionOportunidad")
//    private List<ObservacionRespuesta> observacionRespuestaList;

    public ObservacionOportunidad() {
    }

    public ObservacionOportunidad(Integer observacionID) {
        this.observacionID = observacionID;
    }

    public ObservacionOportunidad(Integer observacionID, String observacion) {
        this.observacionID = observacionID;
        this.observacion = observacion;
    }

    public Integer getObservacionID() {
        return observacionID;
    }

    public void setObservacionID(Integer observacionID) {
        this.observacionID = observacionID;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (observacionID != null ? observacionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObservacionOportunidad)) {
            return false;
        }
        ObservacionOportunidad other = (ObservacionOportunidad) object;
        if ((this.observacionID == null && other.observacionID != null) || (this.observacionID != null && !this.observacionID.equals(other.observacionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigueme.backend.entities.ObservacionOportunidad[ observacionID=" + observacionID + " ]";
    }
    
}
