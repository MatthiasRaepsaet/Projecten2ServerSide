/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import domein.Evaluatie;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Matthias
 */
@RequestScoped
@Path("evaluaties")
public class Evaluaties {
    
    @PersistenceContext
    private EntityManager em;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Evaluatie> getAllEvaluaties(){
        TypedQuery<Evaluatie> queryFindAll = em.createNamedQuery("Evaluatie.findAll", Evaluatie.class);
        return queryFindAll.getResultList();
    }
    
}
