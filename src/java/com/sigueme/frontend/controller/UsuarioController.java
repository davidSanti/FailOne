/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.frontend.controller;

import com.sigueme.backend.entities.Usuario;
import com.sigueme.backend.model.UsuarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Santi
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    @EJB
    private UsuarioFacadeLocal usuarioFacadelocal;
    private Usuario usuario;
    
       
    public UsuarioController() {
    }
    
    @PostConstruct
    public void init(){
        usuario =new Usuario();
        
    }
    
    public String autenticarse(){
        Usuario usuarioValidado;
        FacesContext context = FacesContext.getCurrentInstance();
        
        try{
            
           usuarioValidado =  usuarioFacadelocal.iniciarSesion(usuario);
            System.out.println("contraseña:: "+usuario.getContraseña());
            System.out.println("cedula:: "+usuario.getCedula());
            if(usuario!=null){
                //context.getExternalContext().getSessionMap().put("usuario", usuarioValidado);
                //String redirect = "sigueme";
                return "sigueme";
            }
        }catch(Exception e){
            context.addMessage(
                    null, new FacesMessage (FacesMessage.SEVERITY_FATAL, "Error", "Datos incorrectos") ); 
        }
        return "";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
