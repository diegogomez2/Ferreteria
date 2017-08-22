/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import entities.EntityClientes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import org.eclipse.persistence.exceptions.DatabaseException;

/**
 *
 * @author diego
 */
public class ClientQuery {
    EntityManager em;
    EntityManagerFactory emf;
    
    public ClientQuery(){
        emf = Persistence.createEntityManagerFactory("FerreteriaPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    public List<EntityClientes> getClientes() throws NoResultException{
        try{
            return em.createNamedQuery("EntityClientes.findAll", EntityClientes.class).getResultList();
        }catch(NoResultException e){
            throw e;
        }catch(DatabaseException e){
            throw e;
        }
    }
    
    public EntityClientes getCliente() throws NoResultException{
        return em.createNamedQuery("EntityClientes.findByRutCli", EntityClientes.class).setParameter("rutCli", "1").getSingleResult();
    }
    
}
