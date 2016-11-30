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
@Table(name = "Respuestas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r")
    , @NamedQuery(name = "Respuesta.findByRespuestasID", query = "SELECT r FROM Respuesta r WHERE r.respuestasID = :respuestasID")
    , @NamedQuery(name = "Respuesta.findByRespuesta", query = "SELECT r FROM Respuesta r WHERE r.respuesta = :respuesta")})
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "RespuestasID")
    private Integer respuestasID;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Respuesta")
    private String respuesta;
//    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "respuesta")
//    private List<ObservacionRespuesta> observacionRespuestaList;

    public Respuesta() {
    }

    public Respuesta(Integer respuestasID) {
        this.respuestasID = respuestasID;
    }

    public Respuesta(Integer respuestasID, String respuesta) {
        this.respuestasID = respuestasID;
        this.respuesta = respuesta;
    }

    public Integer getRespuestasID() {
        return respuestasID;
    }

    public void setRespuestasID(Integer respuestasID) {
        this.respuestasID = respuestasID;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (respuestasID != null ? respuestasID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.respuestasID == null && other.respuestasID != null) || (this.respuestasID != null && !this.respuestasID.equals(other.respuestasID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigueme.backend.entities.Respuesta[ respuestasID=" + respuestasID + " ]";
    }
    
}
