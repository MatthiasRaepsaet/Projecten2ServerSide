/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Matthias
 */
@Entity
@Table(name = "TBL_RIJONDERDEEL")
public class RijOnderdeel extends Onderdeel{
    
    @Id
    @GeneratedValue
    private String onderdeelId;
    private String naam;
    
    @Column(nullable = true)
    private List<String> opmerkingen = new ArrayList<>();
    private Kleuren kleur;

    @ManyToOne
    private EvaluatieMoment evaluatieMoment;
    
    public RijOnderdeel() {
        
    }

    public EvaluatieMoment getEvaluatieMoment() {
        return evaluatieMoment;
    }

    public void setEvaluatieMoment(EvaluatieMoment evaluatieMoment) {
        this.evaluatieMoment = evaluatieMoment;
    }

    
    
    public RijOnderdeel(String naam) {
        this.naam = naam;
        this.kleur = Kleuren.WIT;
    }
    
    public RijOnderdeel(String naam, Kleuren kleur) {
        this.naam = naam;
        this.kleur = kleur;
    }

    public String getOnderdeelId() {
        return onderdeelId;
    }

    public void setOnderdeelId(String onderdeelId) {
        this.onderdeelId = onderdeelId;
    }
    
    

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public List<String> getOpmerkingen() {
        return opmerkingen;
    }

    public void setOpmerkingen(List<String> opmerkingen) {
        this.opmerkingen = opmerkingen;
    }

    public Kleuren getKleur() {
        return kleur;
    }

    public void setKleur(Kleuren kleur) {
        this.kleur = kleur;
    }
    
}
