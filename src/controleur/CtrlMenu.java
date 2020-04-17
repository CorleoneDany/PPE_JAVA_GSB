/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import javax.swing.JOptionPane;
import vue.VueMenu;

/**
 *
 * @author Carmona
 */
public class CtrlMenu extends CtrlAbstrait {
    public CtrlMenu(CtrlPrincipal ctrlprincipal){
        super(ctrlprincipal);
        vue = new VueMenu(this);
    }
    
    public void MenuQuitter(){
        int rep = JOptionPane.showConfirmDialog(getVue(), "Quitter l'application\nEtes-vous sûr(e) ?", "GSB", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            this.getCtrlPrincipal().action(EnumAction.MENU_QUITTER);
        }
    }
    
    public MenuVisiteur(){
        this.getCtrlPrincipal().action(EnumAction.MENU_VISITEUR);
    }
    
    @Override
    public getVue(){
        return (VueMenu) vue;
    }
}
