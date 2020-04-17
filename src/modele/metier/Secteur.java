/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author Nero
 */
public class Secteur {
    private String code;
    private String libelle ;

    public Secteur() {
    }

    public Secteur(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Secteur{" + "code=" + code + ", libelle=" + libelle + '}';
    }

    public String getCode() {
        return code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
}
