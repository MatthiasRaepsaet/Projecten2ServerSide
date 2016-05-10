/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Matthias
 */
@Entity
@Table(name = "TBL_EVALUATIE")
@NamedQueries({
    @NamedQuery(name = "Evaluatie.findAll", query = "SELECT e FROM Evaluatie e")
        
})
public class Evaluatie {
    
    @Id
    private String evaluatieNummer;
    
    private int rijtechniekenScore;
    private int verkeerstechniekenScore;
    private int algemeneScore;
    private String algemeneOpmerkingen;
    
    private Kleuren rotonde;
    private Kleuren steenweg;
    private Kleuren bebouwdeKom;
    private Kleuren autostrade;
    
    @OneToMany(mappedBy = "evaluatie")
    private List<EvaluatieMoment> evaLijst = new ArrayList<>();
    
    private Kleuren links1;
    private Kleuren links2;
    private Kleuren links3;
    
    private Kleuren rechts1;
    private Kleuren rechts2;
    private Kleuren rechts3;
    
    private double waardeProgress;
    
    @OneToOne(mappedBy="evaluatie")
    private Leerling leerling;

    public Evaluatie() {
    }
    
//    public Evaluatie(String evaluatieNummer, int rijtechniekenScore, int verkeerstechniekenScore, int algemeneScore, String algemeneOpmerkingen, Kleuren rotonde, Kleuren steenweg, Kleuren bebouwdeKom, Kleuren autostrade) {
//        this.evaluatieNummer = evaluatieNummer;
//        this.rijtechniekenScore = rijtechniekenScore;
//        this.verkeerstechniekenScore = verkeerstechniekenScore;
//        this.algemeneScore = algemeneScore;
//        this.algemeneOpmerkingen = algemeneOpmerkingen;
//        this.rotonde = rotonde;
//        this.steenweg = steenweg;
//        this.bebouwdeKom = bebouwdeKom;
//        this.autostrade = autostrade;
//        
//    }

    public Evaluatie(String evaluatieNummer, int rijtechniekenScore, int verkeerstechniekenScore, int algemeneScore, String algemeneOpmerkingen, Kleuren rotonde, Kleuren steenweg, Kleuren bebouwdeKom, Kleuren autostrade, Kleuren links1, Kleuren links2, Kleuren links3, Kleuren rechts1, Kleuren rechts2, Kleuren rechts3, double waardeProgress) {
        this.evaluatieNummer = evaluatieNummer;
        this.rijtechniekenScore = rijtechniekenScore;
        this.verkeerstechniekenScore = verkeerstechniekenScore;
        this.algemeneScore = algemeneScore;
        this.algemeneOpmerkingen = algemeneOpmerkingen;
        this.rotonde = rotonde;
        this.steenweg = steenweg;
        this.bebouwdeKom = bebouwdeKom;
        this.autostrade = autostrade;
        this.links1 = links1;
        this.links2 = links2;
        this.links3 = links3;
        this.rechts1 = rechts1;
        this.rechts2 = rechts2;
        this.rechts3 = rechts3;
        this.waardeProgress = waardeProgress;
    }

    public Leerling getLeerling() {
        return leerling;
    }

    public void setLeerling(Leerling leerling) {
        this.leerling = leerling;
    }


    @Id
    public String getEvaluatieNummer() {
        return evaluatieNummer;
    }

    public void setEvaluatieNummer(String evaluatieNummer) {
        this.evaluatieNummer = evaluatieNummer;
    }

    public int getRijtechniekenScore() {
        return rijtechniekenScore;
    }

    public void setRijtechniekenScore(int rijtechniekenScore) {
        this.rijtechniekenScore = rijtechniekenScore;
    }

    public int getVerkeerstechniekenScore() {
        return verkeerstechniekenScore;
    }

    public void setVerkeerstechniekenScore(int verkeerstechniekenScore) {
        this.verkeerstechniekenScore = verkeerstechniekenScore;
    }

    public int getAlgemeneScore() {
        return algemeneScore;
    }

    public void setAlgemeneScore(int algemeneScore) {
        this.algemeneScore = algemeneScore;
    }

    public String getAlgemeneOpmerkingen() {
        return algemeneOpmerkingen;
    }

    public void setAlgemeneOpmerkingen(String algemeneOpmerkingen) {
        this.algemeneOpmerkingen = algemeneOpmerkingen;
    }

    public Kleuren getRotonde() {
        return rotonde;
    }

    public void setRotonde(Kleuren rotonde) {
        this.rotonde = rotonde;
    }

    public Kleuren getSteenweg() {
        return steenweg;
    }

    public void setSteenweg(Kleuren steenweg) {
        this.steenweg = steenweg;
    }

    public Kleuren getBebouwdeKom() {
        return bebouwdeKom;
    }

    public void setBebouwdeKom(Kleuren bebouwdeKom) {
        this.bebouwdeKom = bebouwdeKom;
    }

    public Kleuren getAutostrade() {
        return autostrade;
    }

    public void setAutostrade(Kleuren autostrade) {
        this.autostrade = autostrade;
    }

    public List<EvaluatieMoment> getEvaLijst() {
        return evaLijst;
    }

    public void setEvaLijst(List<EvaluatieMoment> evaLijst) {
        this.evaLijst = evaLijst;
    }

    public Kleuren getLinks1() {
        return links1;
    }

    public void setLinks1(Kleuren links1) {
        this.links1 = links1;
    }

    public Kleuren getLinks2() {
        return links2;
    }

    public void setLinks2(Kleuren links2) {
        this.links2 = links2;
    }

    public Kleuren getLinks3() {
        return links3;
    }

    public void setLinks3(Kleuren links3) {
        this.links3 = links3;
    }

    public Kleuren getRechts1() {
        return rechts1;
    }

    public void setRechts1(Kleuren rechts1) {
        this.rechts1 = rechts1;
    }

    public Kleuren getRechts2() {
        return rechts2;
    }

    public void setRechts2(Kleuren rechts2) {
        this.rechts2 = rechts2;
    }

    public Kleuren getRechts3() {
        return rechts3;
    }

    public void setRechts3(Kleuren rechts3) {
        this.rechts3 = rechts3;
    }

    public double getWaardeProgress() {
        return waardeProgress;
    }

    public void setWaardeProgress(double waardeProgress) {
        this.waardeProgress = waardeProgress;
    }
    
    
    
//    @OneToOne(mappedBy = "evaluatie")
//    public Leerling getLeerling() {
//        return leerling;
//    }
//
//    public void setLeerling(Leerling leerling) {
//        this.leerling = leerling;
//    }

    
    
    
}
