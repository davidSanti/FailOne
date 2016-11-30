/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.backend.model;

import com.sigueme.backend.entities.ObservacionRespuesta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Santi
 */
@Local
public interface ObservacionRespuestaFacadeLocal {

    void create(ObservacionRespuesta observacionRespuesta);

    void edit(ObservacionRespuesta observacionRespuesta);

    void remove(ObservacionRespuesta observacionRespuesta);

    ObservacionRespuesta find(Object id);

    List<ObservacionRespuesta> findAll();

    List<ObservacionRespuesta> findRange(int[] range);

    int count();
    
}
