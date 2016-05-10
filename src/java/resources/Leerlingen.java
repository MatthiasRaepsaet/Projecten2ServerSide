/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import domein.Evaluatie;
import domein.EvaluatieMoment;
import domein.Kleuren;
import domein.Leerling;
import domein.RijOnderdeel;
import domein.VerkeersOnderdeel;
import java.net.URI;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Matthias
 */
         
@RequestScoped
@Path("leerlingen")
@Transactional(dontRollbackOn = {BadRequestException.class, NotFoundException.class})
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
    
    @Path("naam/{naam}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Leerling getLeerlingByNaam(@PathParam("naam") String naam){
        TypedQuery<Leerling> queryFindAll = em.createNamedQuery("Leerling.findAll", Leerling.class);
        Leerling res = null;
        for(Leerling l : queryFindAll.getResultList()){
            if(l.getNaam().endsWith(naam))
                res = l;
        }
        if (res == null) {
            throw new NotFoundException("Gebruiker niet gevonden");
        }
        return res;

    }
    
    @Path("voornaam/{naam}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Leerling getLeerlingByVoorNaam(@PathParam("naam") String naam){
        TypedQuery<Leerling> queryFindAll = em.createNamedQuery("Leerling.findAll", Leerling.class);
        Leerling res = null;
        for(Leerling l : queryFindAll.getResultList()){
            if(l.getNaam().startsWith(naam))
                res = l;
        }
        if (res == null) {
            throw new NotFoundException("Gebruiker niet gevonden");
        }
        return res;

    }
    
    @Path("volledigenaam/{naam}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Leerling getLeerlingByVolledigeNaam(@PathParam("naam") String naam){
        TypedQuery<Leerling> queryFindAll = em.createNamedQuery("Leerling.findAll", Leerling.class);
        Leerling res = null;
        for(Leerling l : queryFindAll.getResultList()){
            if(l.getNaam().equals(naam))
                res = l;
        }
        if (res == null) {
            throw new NotFoundException("Gebruiker niet gevonden");
        }
        return res;

    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLeerling(Leerling leerling)
    {
        
        if (leerling.getNaam() == null) {
            throw new BadRequestException("Paswoord ongeldig");
        }
        leerling.setNaam(leerling.getNaam().trim());
        if (leerling.getEmail()== null) {
            throw new BadRequestException("Paswoord ongeldig");
        }
        Evaluatie e = new Evaluatie();
        for(EvaluatieMoment evam : e.getEvaLijst()){
            for(RijOnderdeel ro : evam.getRijtechniekOnderdelen()){
                em.persist(ro);
            }
            for(VerkeersOnderdeel vo : evam.getVerkeerstechniekOnderdelen()){
                em.persist(vo);
            }
            em.persist(evam);
        }
        leerling.setEmail(leerling.getEmail().trim());
        leerling.setEvaluatie(e);
        em.persist(e);
        em.persist(leerling);
        
        return Response.created(URI.create("/" + leerling.getInschrijvingsNummer())).build();
    }
}
