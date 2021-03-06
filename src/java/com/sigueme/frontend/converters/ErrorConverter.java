/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.frontend.converters;

import com.sigueme.backend.entities.ErrorFrecuente;
import com.sigueme.backend.model.ErrorFrecuenteFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Santi
 */
@FacesConverter (value = "errorConverter")
@SessionScoped
public class ErrorConverter implements Converter{
    
    @EJB
    private ErrorFrecuenteFacadeLocal errorFrecuenteFacadeLocal;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        List<ErrorFrecuente> errores = errorFrecuenteFacadeLocal.findAll();
        for (ErrorFrecuente e: errores){
            if(e.getErrorID() == Integer.parseInt(value)){
                return e ;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null){
            return((ErrorFrecuente)value).getErrorID().toString();
        }
        return "";
    }
    
}
