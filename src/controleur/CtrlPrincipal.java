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

    private CtrlVisiteur ctrlVisiteur = null;
    private CtrlMenu     ctrlMenu     = null;

    /**
     * Utilise par défaut le contrôleur principal
     * Affiche la vue du menu
     */
    public void action() {
        if (ctrlMenu == null) ctrlMenu = new CtrlMenu(this);
        
        ctrlMenu.getVue().setEnabled(true);
        ctrlMenu.getVue().setVisible(true);
    }
   
}