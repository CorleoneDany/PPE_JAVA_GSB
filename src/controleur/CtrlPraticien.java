/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;
import java.util.List;
import javax.swing.JOptionPane;
import modele.dao.*;
import modele.metier.*;
import vue.VuePraticien;


/**
 *
 * @author Matthias CARMONA, François ESPIASSE
 */
public class CtrlPraticien extends CtrlAbstrait {
    private DaoPraticien daoPraticien = new DaoPraticien();
    
    public CtrlPraticien(CtrlPrincipal ctrlprincipal){
        super(ctrlPrincipal);
        vue = new VuePraticien(this);
        actualiser();
    }
    
    public final void actualiser(){
        try{
            chargerListeVisiteurs();
        }
        catch(DaoException ex){
            JOptionPane.showMessageDialog(getVue(), "CtrlVisiteur - actualiser - " + ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void praticienFermer(){
        this.getCtrlPrincipal().action(EnumAction.PRATICIEN_FERMER);
    }
    
    public void praticienSuivant(){
        int index = getVue().getjComboBoxPraticien().getSelectedIndex()+1;
        if(index== getVue().getjComboBoxPraticien().getItemCount())index=0;
        getVue().getjComboBoxPraticien().setSelectedIndex(index);
    }
    
    public void praticienPrecedent(){
        int index = getVue().getjComboBoxPraticien().getSelectedIndex()-1;
        if(index== -1) index=getVue() .getjComboBoxPraticien().getItemCount() -1;
        getVue().getjComboBoxPraticien().setSelectedIndex(index);
    }
    
    private void chargerListeVisiteurs() throws DaoException {
        List<Praticien> desPraticiens = daoPraticien.getAll();
        getVue().getModeleJComboBoxPraticien().removeAllElements();
        for (Praticien unPraticien : desPraticiens) {
            getVue().getModeleJComboBoxPraticien().addElement(unPraticien);
        }
    }
    
    public void visiteurSelectionner (){
        Praticien praticienSelect = (Praticien) getVue().getjComboBoxPraticien().getSelectedItem();
        if (PraticienSelect != null){
            
            getVue().getTxtNom().setText(praticienSelect.getNom());
            getVue().getTxtPrenom().setText(praticienSelect.getPrenom());
            getVue().getTxtAdrs().setText(praticienSelect.getAdresse());
            getVue().getTxtVille().setText(praticienSelect.getVille());
            getVue().getTxtCp().setText(praticienSelect.getCp());
            getVue().getTxtCoefNotoriete().setSelectedItem(praticienSelect.getCoefNotoriete());
            getVue().getTxtCode().setSelectedItem(praticienSelect.getCode());
        }
        
        @Override
        public VuePraticien getVue() {
            return (VuePraticien) vue;
        }
    }
}
