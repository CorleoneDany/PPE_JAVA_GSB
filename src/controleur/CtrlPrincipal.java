/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

/**
 * @author François ESPIASSE
 */
public class CtrlPrincipal {

    private CtrlMedicament ctrlMedicament = null;
    private CtrlPracticien ctrlPraticien  = null;
    private CtrlVisiteur   ctrlVisiteur   = null;
    private CtrlMenu       ctrlMenu       = null;

    /**
     * Utilise par défaut le contrôleur principal
     * Affiche la vue du menu
     */
    public void action() {
        if (ctrlMenu == null) ctrlMenu = new CtrlMenu(this);
        
        ctrlMenu.getVue().setEnabled(true);
        ctrlMenu.getVue().setVisible(true);
    }
   
    /**
     * Fait appel au contrôleur correspondant à l'action passée en paramètre
     * Fonctionnement :
     * MENU_NOMCONTROLEUR permet d'afficher la vue correspondant au contrôleur depuis le menu,
     * NOMCONTROLEUR_ACTION permet d'effectuer une action depuis la vue active.
     * @param action 
     */
    public void action(EnumAction action) {
        switch (action) {
            
            // RAPPORTS DE VISITES
            case MENU_RAPPORTVISITE: 
                menuRapportVisite();
                break;
            case RAPPORTVISITE_FERMER:
                rapportVisiteFermer();
                break;
                
            // VISITEURS
            case MENU_VISITEUR: 
                menuVisiteur();
                break;
            case VISITEUR_FERMER:
                visiteurFermer();
                break;
                
            // PRATICIENS
            case MENU_PRATICIEN:
                menuPraticien();
                break;
            case PRATICIEN_FERMER: 
                praticienFermer();
                break;
                
            // MÉDICAMENTS
            case MENU_MEDICAMENT:
                menuMedicament();
                break;
            case MEDICAMENT_FERMER: 
                medicamentFermer();
                break;
                
            case MENU_QUITTER:
                menuQuitter();
                break;
        }
    }
    
    // TODO: méthodes appelées dans action(EnumAction enum)
}