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
public class Visiteur {
    private String matricule;
    private String nom;
    private String prenom;
    private String adresse;
    private String cp;
    private String ville;
    private String dateEmbauche;
    private Secteur secteur;
    private Labo labo;

    public Visiteur() {
    }

    public Visiteur(String matricule, String nom, String prenom, String adresse, String cp, String ville, String dateEmbauche, Secteur secteur, Labo labo) {
    this.matricule = matricule;
    this.nom = nom;
    this.prenom = prenom;
    this.adresse = adresse;
    this.cp = cp;
    this.ville = ville;
    this.dateEmbauche = dateEmbauche;
    this.secteur = secteur;
    this.labo = labo;
    }

    
    @Override
    public String toString() {
        return "Visiteur{" + "matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", cp=" + cp + ", ville=" + ville + ", dateEmbauche=" + dateEmbauche + ", secteur=" + secteur + ", labo=" + labo + '}';
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getCp() {
        return cp;
    }

    public String getVille() {
        return ville;
    }

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public Labo getLabo() {
        return labo;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public void setLabo(Labo labo) {
        this.labo = labo;
    }
    
    
}
