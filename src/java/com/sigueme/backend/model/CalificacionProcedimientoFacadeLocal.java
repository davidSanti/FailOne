/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.backend.model;

import com.sigueme.backend.entities.CalificacionProcedimiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Santi
 */
@Local
public interface CalificacionProcedimientoFacadeLocal {

    void create(CalificacionProcedimiento calificacionProcedimiento);

    void edit(CalificacionProcedimiento calificacionProcedimiento);

    void remove(CalificacionProcedimiento calificacionProcedimiento);

    CalificacionProcedimiento find(Object id);

    List<CalificacionProcedimiento> findAll();

    List<CalificacionProcedimiento> findRange(int[] range);

    int count();
    
}
