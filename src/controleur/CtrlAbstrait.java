/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

/**
 *
 * @author Carmona
 */

public abstract class CtrlAbstrait {
    protected VueAbstraite vue = null;
    protected CtrlPrincipal ctrlprincipal = null;
    
    protected CtrlAbstrait(CtrlPrincipal ctrlprincipal){
        this.ctrlprincipal = ctrlprincipal;
    }

    public VueAbstraite getVue() {
        return vue;
    }

    public void setVue(VueAbstraite vue) {
        this.vue = vue;
    }

    public CtrlPrincipal getCtrlprincipal() {
        return ctrlprincipal;
    }

    public void setCtrlprincipal(CtrlPrincipal ctrlprincipal) {
        this.ctrlprincipal = ctrlprincipal;
    }  
}
