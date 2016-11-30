/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.backend.model;

import com.sigueme.backend.entities.ObservacionOportunidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Santi
 */
@Local
public interface ObservacionOportunidadFacadeLocal {

    void create(ObservacionOportunidad observacionOportunidad);

    void edit(ObservacionOportunidad observacionOportunidad);

    void remove(ObservacionOportunidad observacionOportunidad);

    ObservacionOportunidad find(Object id);

    List<ObservacionOportunidad> findAll();

    List<ObservacionOportunidad> findRange(int[] range);

    int count();
    
}
