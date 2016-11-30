/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.frontend.converters;

import com.sigueme.backend.entities.Rol;
import com.sigueme.backend.model.RolFacadeLocal;
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
@FacesConverter(value = "rolConverter")
@SessionScoped
public class RolConverter implements Converter{
     
    @EJB
    private RolFacadeLocal rolFacadeLocal;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        List<Rol> roles = rolFacadeLocal.findAll();
        for (Rol r: roles){
            if(r.getRolID() == Integer.parseInt(value)){
                return r;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null){
            return((Rol)value).getRolID().toString();
        }
        return "";
    }
    
    
}
