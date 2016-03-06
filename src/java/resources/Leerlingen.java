/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import domein.Leerling;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Matthias
 */
@RequestScoped
@Path("leerlingen")
public class Leerlingen {
    
    @PersistenceContext
    private EntityManager em;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Leerling> getAllLeerlingen(){
        TypedQuery<Leerling> queryFindAll = em.createNamedQuery("Leerling.findAll", Leerling.class);
        return queryFindAll.getResultList();
    }
    
    @Path("nummer/{nummer}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Leerling getLeerlingByNummer(@PathParam("nummer") String nummer){
        Leerling l = em.find(Leerling.class, nummer);
        if (l == null) {
            throw new NotFoundException("Gebruiker niet gevonden");
        }
        return l;
    }
    
//    @Path("naam/{naam}")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Leerling getLeerlingByNaam(@PathParam("naam") String naam){
//        TypedQuery<Leerling> queryFindAll = em.createNamedQuery("Leerling.findByName", Leerling.class);
//        return queryFindAll.getSingleResult();
//    }
}
