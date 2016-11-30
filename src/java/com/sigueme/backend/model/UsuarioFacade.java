/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigueme.backend.model;

import com.sigueme.backend.entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Santi
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "SiguemePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    @Override
    public Usuario iniciarSesion (Usuario us){
        Usuario usuario = null;
        String consulta;
        
        try{
            consulta = "SELECT u FROM Usuario u WHERE u.cedula = :cedula AND u.contraseña = :contra";
            Query query = em.createQuery(consulta);
            query.setParameter("cedula",us.getCedula());
            query.setParameter("contra",us.getContraseña());
            
            List<Usuario> usuariolista = query.getResultList();
            if(!usuariolista.isEmpty()){
                usuario = usuariolista.get(0);
            }
            
        }catch(Exception e){
            throw e;
        }
        return usuario;
    }
    
}
