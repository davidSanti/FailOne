/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.backend.model;

import com.sigueme.backend.entities.ObservacionRespuesta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Santi
 */
@Stateless
public class ObservacionRespuestaFacade extends AbstractFacade<ObservacionRespuesta> implements ObservacionRespuestaFacadeLocal {

    @PersistenceContext(unitName = "SiguemePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ObservacionRespuestaFacade() {
        super(ObservacionRespuesta.class);
    }
    
}
