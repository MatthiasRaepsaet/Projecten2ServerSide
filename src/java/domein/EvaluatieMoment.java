/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Matthias
 */
@Entity
@Table(name = "TBL_EVALUATIEMOMENT")
public class EvaluatieMoment implements Serializable {
    
    @Id
    @GeneratedValue
    private String id;
    
    private String naam;
    
    @OneToMany(mappedBy="evaluatieMoment")
    private List<RijOnderdeel> rijtechniekOnderdelen = new ArrayList<>();
    
    @OneToMany(mappedBy="evaluatieMoment")
    private List<VerkeersOnderdeel> verkeerstechniekOnderdelen = new ArrayList<>();

    @ManyToOne
    private Evaluatie evaluatie;
    
    public EvaluatieMoment() {
        
    }

    
    
    public EvaluatieMoment(String naam) {
        this.naam = naam;
        verkeerstechniekOnderdelen.add(new VerkeersOnderdeel("Richtingaanwijzers", Kleuren.WIT));
        verkeerstechniekOnderdelen.add(new VerkeersOnderdeel("openbareweg", Kleuren.WIT));
        verkeerstechniekOnderdelen.add(new VerkeersOnderdeel("voorrang", Kleuren.WIT));
        verkeerstechniekOnderdelen.add(new VerkeersOnderdeel("borden", Kleuren.WIT));
        verkeerstechniekOnderdelen.add(new VerkeersOnderdeel("snelheid", Kleuren.WIT));
        verkeerstechniekOnderdelen.add(new VerkeersOnderdeel("fille", Kleuren.WIT));
        verkeerstechniekOnderdelen.add(new VerkeersOnderdeel("overgaan", Kleuren.WIT));
        verkeerstechniekOnderdelen.add(new VerkeersOnderdeel("kruisen", Kleuren.WIT));
        verkeerstechniekOnderdelen.add(new VerkeersOnderdeel("links", Kleuren.WIT));
        verkeerstechniekOnderdelen.add(new VerkeersOnderdeel("rechts", Kleuren.WIT));
        
        rijtechniekOnderdelen.add(new RijOnderdeel("zithouding", Kleuren.WIT));
        rijtechniekOnderdelen.add(new RijOnderdeel("ontkoppeling", Kleuren.WIT));
        rijtechniekOnderdelen.add(new RijOnderdeel("remmen", Kleuren.WIT));
        rijtechniekOnderdelen.add(new RijOnderdeel("stuur", Kleuren.WIT));
        rijtechniekOnderdelen.add(new RijOnderdeel("schakelen", Kleuren.WIT));
        rijtechniekOnderdelen.add(new RijOnderdeel("waakzaam", Kleuren.WIT));
        rijtechniekOnderdelen.add(new RijOnderdeel("parkeren", Kleuren.WIT));
        rijtechniekOnderdelen.add(new RijOnderdeel("keren", Kleuren.WIT));
        rijtechniekOnderdelen.add(new RijOnderdeel("g", Kleuren.WIT));
        rijtechniekOnderdelen.add(new RijOnderdeel("r", Kleuren.WIT));
        rijtechniekOnderdelen.add(new RijOnderdeel("bochten", Kleuren.WIT));
        rijtechniekOnderdelen.add(new RijOnderdeel("helling", Kleuren.WIT));
        
    }

    public Evaluatie getEvaluatie() {
        return evaluatie;
    }

    public void setEvaluatie(Evaluatie evaluatie) {
        this.evaluatie = evaluatie;
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    
    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public List<RijOnderdeel> getRijtechniekOnderdelen() {
        return rijtechniekOnderdelen;
    }

    public void setRijtechniekOnderdelen(List<RijOnderdeel> rijtechniekOnderdelen) {
        this.rijtechniekOnderdelen = rijtechniekOnderdelen;
    }

    public List<VerkeersOnderdeel> getVerkeerstechniekOnderdelen() {
        return verkeerstechniekOnderdelen;
    }

    public void setVerkeerstechniekOnderdelen(List<VerkeersOnderdeel> verkeerstechniekOnderdelen) {
        this.verkeerstechniekOnderdelen = verkeerstechniekOnderdelen;
    }
    
    
}
