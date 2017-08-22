/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import entities.EntityUsuarios;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import org.eclipse.persistence.exceptions.DatabaseException;

/**
 *
 * @author diego
 */
public class UserQuery {
    EntityManager em; 
    EntityManagerFactory emf;
    
    public UserQuery(){
        emf = Persistence.createEntityManagerFactory("FerreteriaPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    public EntityUsuarios getPasswordByUser(String nombre) throws NoResultException{
        try{
            return em.createNamedQuery("EntityUsuarios.findByNameUser", EntityUsuarios.class).setParameter("nameUser", nombre).getSingleResult();
        }catch(NoResultException e){
            throw e;
        }catch(DatabaseException e){
            throw e;
        }
    }
    
    public String getPassByUser(String nombre) throws NoResultException{
        try{
            return em.createQuery("SELECT pass_user FROM Usuarios WHERE name_user = :nombre_user").setParameter("nombre_user", nombre).getSingleResult().toString();
        }catch(NoResultException e){
            throw e;
        }
    }
}
