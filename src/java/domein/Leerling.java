/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.io.File;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Matthias
 */
@Entity
@Table(name = "TBL_LEERLING")
@NamedQueries({
    @NamedQuery(name = "Leerling.findAll", query = "SELECT l FROM Leerling l"),
    @NamedQuery(name = "Leerling.findByName", query = "SELECT l FROM Leerling l WHERE l.naam = :naam"),
    @NamedQuery(name = "Leerling.findByNummer", query = "SELECT l FROM Leerling l WHERE l.inschrijvingsNummer = :nummer")
        
})
public class Leerling {

    public Leerling() {
    }

    public Leerling(String inschrijvingsNummer, String naam, String email) {
        this.inschrijvingsNummer = inschrijvingsNummer;
        this.naam = naam;
        this.email = email;
    }
    
    
    
    @Id
    private String inschrijvingsNummer;
    private String naam;
    private File fotoPath;
    private String email;
    
    @OneToOne
    private Evaluatie evaluatie;
    
    public String getInschrijvingsNummer() {
        return inschrijvingsNummer;
    }

    public void setInschrijvingsNummer(String inschrijvingsNummer) {
        this.inschrijvingsNummer = inschrijvingsNummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public File getFotoPath() {
        return fotoPath;
    }

    public void setFotoPath(File fotoPath) {
        this.fotoPath = fotoPath;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Evaluatie getEvaluatie() {
        return evaluatie;
    }

    public void setEvaluatie(Evaluatie evaluatie) {
        this.evaluatie = evaluatie;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.inschrijvingsNummer);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Leerling other = (Leerling) obj;
        if (!Objects.equals(this.inschrijvingsNummer, other.inschrijvingsNummer)) {
            return false;
        }
        return true;
    }
    
    
}
