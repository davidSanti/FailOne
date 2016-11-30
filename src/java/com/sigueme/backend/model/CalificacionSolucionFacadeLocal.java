/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.backend.model;

import com.sigueme.backend.entities.CalificacionSolucion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Santi
 */
@Local
public interface CalificacionSolucionFacadeLocal {

    void create(CalificacionSolucion calificacionSolucion);

    void edit(CalificacionSolucion calificacionSolucion);

    void remove(CalificacionSolucion calificacionSolucion);

    CalificacionSolucion find(Object id);

    List<CalificacionSolucion> findAll();

    List<CalificacionSolucion> findRange(int[] range);

    int count();
    
}
