/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.jdbc;

import java.sql.Connection;

/**
 *
 * @author Nero
 */
public class Jdbc implements JdbcInterface {

    // Instance du singleton Jdbc
    private static Jdbc singleton = null;
    
    // Paramètre de la connexion
    private String piloteJdbc = "";
    private String protocoleJdbc = "";
    private String serveurBd = "";
    private String nomBd = "";
    private String loginSgbd = "";
    private String mdpSgbd = "";
    
    // Connexion
    private Connection connexion = null; // java.sql.Connection
    
    private Jdbc() {
    }

    /**
     * @param pilote : classe du pilote Jdbc
     * @param protocole : préfixe l'URL du serveur ; dépend du type de SGBD
     * @param serveur : adresse du serveur + port (fini par un /, sauf pour
     * Oracle ; BD pour embarquée : chemin accès répertoire )
     * @param base : nom de la BD ou du DSN pour ODBC
     * @param login : utilisateur autorisé du SGBD (ou schéma Oracle)
     * @param mdp : son mot de passe
     */
    private Jdbc(String pilote, String protocole, String serveur, String base, String login, String mdp) {
        this.piloteJdbc = pilote;
        this.protocoleJdbc = protocole;
        this.serveurBd = serveur;
        this.nomBd = base;
        this.loginSgbd = login;
        this.mdpSgbd = mdp;
    }

    public static Jdbc creer(String pilote, String protocole, String serveur, String base, String login, String mdp) {
        if (singleton == null) {
            singleton = new Jdbc(pilote, protocole, serveur, base, login, mdp);
        }
        return singleton;
    }

    public static Jdbc getInstance() {
        return singleton;
        
    }
}
