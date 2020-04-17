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
public class Labo {
    
    private String code;
    private String nom;
    private String chefVente;

    public Labo() {
    }

    public Labo(String code, String nom, String chefVente) {
        this.code = code;
        this.nom = nom;
        this.chefVente = chefVente;
    }

    @Override
    public String toString() {
        return "Labo{" + "code=" + code + ", nom=" + nom + ", chefVente=" + chefVente + '}';
    }

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public String getChefVente() {
        return chefVente;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setChefVente(String chefVente) {
        this.chefVente = chefVente;
    }
    
    

}