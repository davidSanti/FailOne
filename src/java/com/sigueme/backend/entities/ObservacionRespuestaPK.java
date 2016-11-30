/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.backend.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Santi
 */
@Embeddable
public class ObservacionRespuestaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "OportunidadID")
    private int oportunidadID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ObservacionID")
    private int observacionID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RespuestaID")
    private int respuestaID;

    public ObservacionRespuestaPK() {
    }

    public ObservacionRespuestaPK(int oportunidadID, int observacionID, int respuestaID) {
        this.oportunidadID = oportunidadID;
        this.observacionID = observacionID;
        this.respuestaID = respuestaID;
    }

    public int getOportunidadID() {
        return oportunidadID;
    }

    public void setOportunidadID(int oportunidadID) {
        this.oportunidadID = oportunidadID;
    }

    public int getObservacionID() {
        return observacionID;
    }

    public void setObservacionID(int observacionID) {
        this.observacionID = observacionID;
    }

    public int getRespuestaID() {
        return respuestaID;
    }

    public void setRespuestaID(int respuestaID) {
        this.respuestaID = respuestaID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) oportunidadID;
        hash += (int) observacionID;
        hash += (int) respuestaID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObservacionRespuestaPK)) {
            return false;
        }
        ObservacionRespuestaPK other = (ObservacionRespuestaPK) object;
        if (this.oportunidadID != other.oportunidadID) {
            return false;
        }
        if (this.observacionID != other.observacionID) {
            return false;
        }
        if (this.respuestaID != other.respuestaID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigueme.backend.entities.ObservacionRespuestaPK[ oportunidadID=" + oportunidadID + ", observacionID=" + observacionID + ", respuestaID=" + respuestaID + " ]";
    }
    
}
