/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

/**
 *
 * @author Matthias
 */
public enum Kleuren {
    WIT ("#FFFFFF"),
    ROOD ("#FF0000"),
    ORANJE ("#FFA500"),
    GROEN ("#00FF00");
    
    private final String hexValue;

    private Kleuren(String hexValue) {
        this.hexValue = hexValue;
    }

    public String getHexValue() {
        return hexValue;
    }
    
    public Kleuren getByValue(String kleur){
        if(kleur == "#FFFFFF")
            return Kleuren.WIT;
        if(kleur == "#FF0000")
            return Kleuren.ROOD;
        if(kleur == "FFA500")
            return Kleuren.ORANJE;
        if(kleur == "#00FF00")
            return Kleuren.GROEN;
        else
            return Kleuren.WIT;
    }
}
