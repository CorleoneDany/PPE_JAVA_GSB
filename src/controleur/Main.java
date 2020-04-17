/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import javax.swing.JOptionPane;
import modele.jdbc.Jdbc;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import modele.jdbc.FabriqueJdbc;
import modele.jdbc.Jdbc;
/**
 *
 * @author Nero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Variable contenant le nom du fichier properties
        String ficPropertiesJdbc = "gsbJdbc.properties";
        Ctrlprincipal ctrlprincipal;
        
        if(args.length > 0){
            ficPropertiesJdbc = args[0];
        }
        
        // Singleton de connexion Jdbc
        try {
          FabriqueJdbc.creer(ficPropertiesJdbc);
        }
        catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Lanceur Main - Fichier de propriétés JDBC introuvable", JOptionPane.ERROR_MESSAGE);
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Lanceur Main - Erreur lors du chargement du fichier de propriétés JDBC", JOptionPane.ERROR_MESSAGE);
        }
        
        // Ouverture de la connection avec Jdbc
        try{
            Jdbc.getInstance().connecter();
        }
        catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Lanceur Main - connexion à la BDD - pilote JDBC non trouvé", JOptionPane.ERROR_MESSAGE);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Lanceur Main - connexion à la BDD", JOptionPane.ERROR_MESSAGE);
        }
        
        // Lancement de l'application instancier par la class CtrlPrincipal
        ctrlPrincipal = new CtrlPrincipal();
        ctrlPrincipal.action();
        
        
        
    }
    
}
