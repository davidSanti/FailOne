/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.backend.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santi
 */
@Entity
@Table(name = "ObservacionesRespuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObservacionRespuesta.findAll", query = "SELECT o FROM ObservacionRespuesta o")
    , @NamedQuery(name = "ObservacionRespuesta.findByOportunidadID", query = "SELECT o FROM ObservacionRespuesta o WHERE o.observacionRespuestaPK.oportunidadID = :oportunidadID")
    , @NamedQuery(name = "ObservacionRespuesta.findByObservacionID", query = "SELECT o FROM ObservacionRespuesta o WHERE o.observacionRespuestaPK.observacionID = :observacionID")
    , @NamedQuery(name = "ObservacionRespuesta.findByRespuestaID", query = "SELECT o FROM ObservacionRespuesta o WHERE o.observacionRespuestaPK.respuestaID = :respuestaID")})
public class ObservacionRespuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ObservacionRespuestaPK observacionRespuestaPK;
    @JoinColumn(name = "ObservacionID", referencedColumnName = "ObservacionID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ObservacionOportunidad observacionOportunidad;
    @JoinColumn(name = "OportunidadID", referencedColumnName = "OportunidadID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OportunidadDeAprendizaje oportunidadDeAprendizaje;
    @JoinColumn(name = "RespuestaID", referencedColumnName = "RespuestasID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Respuesta respuesta;

    public ObservacionRespuesta() {
    }

    public ObservacionRespuesta(ObservacionRespuestaPK observacionRespuestaPK) {
        this.observacionRespuestaPK = observacionRespuestaPK;
    }

    public ObservacionRespuesta(int oportunidadID, int observacionID, int respuestaID) {
        this.observacionRespuestaPK = new ObservacionRespuestaPK(oportunidadID, observacionID, respuestaID);
    }

    public ObservacionRespuestaPK getObservacionRespuestaPK() {
        return observacionRespuestaPK;
    }

    public void setObservacionRespuestaPK(ObservacionRespuestaPK observacionRespuestaPK) {
        this.observacionRespuestaPK = observacionRespuestaPK;
    }

    public ObservacionOportunidad getObservacionOportunidad() {
        return observacionOportunidad;
    }

    public void setObservacionOportunidad(ObservacionOportunidad observacionOportunidad) {
        this.observacionOportunidad = observacionOportunidad;
    }

    public OportunidadDeAprendizaje getOportunidadDeAprendizaje() {
        return oportunidadDeAprendizaje;
    }

    public void setOportunidadDeAprendizaje(OportunidadDeAprendizaje oportunidadDeAprendizaje) {
        this.oportunidadDeAprendizaje = oportunidadDeAprendizaje;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (observacionRespuestaPK != null ? observacionRespuestaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObservacionRespuesta)) {
            return false;
        }
        ObservacionRespuesta other = (ObservacionRespuesta) object;
        if ((this.observacionRespuestaPK == null && other.observacionRespuestaPK != null) || (this.observacionRespuestaPK != null && !this.observacionRespuestaPK.equals(other.observacionRespuestaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigueme.backend.entities.ObservacionRespuesta[ observacionRespuestaPK=" + observacionRespuestaPK + " ]";
    }
    
}
