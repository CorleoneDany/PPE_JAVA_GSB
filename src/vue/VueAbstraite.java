/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

/**
 *
 * @author François ESPIASSE
 * @version 1.0
 */

import controleur.CtrlAbstrait;
import javax.swing.JFrame;

public abstract class VueAbstraite extends JFrame {
    
    // associations
    protected CtrlAbstrait controleur = null;
    
    public VueAbstraite(CtrlAbstrait ctrl) {
        this.controleur = ctrl;
    }   
    
}
