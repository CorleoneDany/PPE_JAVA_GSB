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
import vue.VuePracticien;


/**
 *
 * @author Carmona
 */
public class CtrlPracticien extends CtrlAbstrait {
    private DaoPracticien daoPracticien = new DaoPracticien();
    
    public CtrlPracticien(CtrlPrincipal ctrlprincipal){
        super(ctrlPrincipal);
        vue = new VuePracticien(this);
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
    public void practicienFermer(){
        this.getCtrlPrincipal().action(EnumAction.PRACTICIEN_FERMER);
    }
    
    public void practicienSuivant(){
        int index = getVue().getjComboBoxPracticien().getSelectedIndex()+1;
        if(index== getVue().getjComboBoxPracticien().getItemCount())index=0;
        getVue().getjComboBoxPracticien().setSelectedIndex(index);
    }
    
    public void practicienPrecedent(){
        int index = getVue().getjComboBoxPracticien().getSelectedIndex()-1;
        if(index== -1) index=getVue() .getjComboBoxPracticien().getItemCount() -1;
        getVue().getjComboBoxPracticien().setSelectedIndex(index);
    }
    
    private void chargerListeVisiteurs() throws DaoException {
        List<Practicien> desPracticiens = daoPracticien.getAll();
        getVue().getModeleJComboBoxPracticien().removeAllElements();
        for (Practicien unPracticien : desPracticiens) {
            getVue().getModeleJComboBoxPracticien().addElement(unPracticien);
        }
    }
    
    public void visiteurSelectionner (){
        Practicien practicienSelect = (Practicien) getVue().getjComboBoxPracticien().getSelectedItem();
        if (PracticienSelect != null){
            
            getVue().getTxtNom().setText(practicienSelect.getNom());
            getVue().getTxtPrenom().setText(practicienSelect.getPrenom());
            getVue().getTxtAdrs().setText(practicienSelect.getAdresse());
            getVue().getTxtVille().setText(practicienSelect.getVille());
            getVue().getTxtCp().setText(practicienSelect.getCp());
            getVue().getTxtCoefNotoriete().setSelectedItem(practicienSelect.getCoefNotoriete());
            getVue().getTxtCode().setSelectedItem(practicienSelect.getCode());
        }
        
        @Override
        public VuePracticien getVue() {
            return (VuePracticien) vue;
        }
    }
}
