/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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

    @Override
    public void connecter() throws ClassNotFoundException, SQLException {
        Class.forName(this.getPiloteJdbc());
        setConnexion(DriverManager.getConnection(this.getProtocoleJdbc() + this.getServeurBd() + this.getNomBd(), this.getLoginSgbd(), this.getMdpSgbd()));
        getConnexion().setAutoCommit(true);
    }

    @Override
    public void deconnecter() throws SQLException {
        getConnexion().close();
    }

    @Override
    public void debuterTransaction() throws SQLException {
        getConnexion().setAutoCommit(false);
    }

    @Override
    public void validerTransaction() throws SQLException {
        getConnexion().commit();
        getConnexion().setAutoCommit(true);
    }

    @Override
    public void annulerTransaction() throws SQLException {
        getConnexion().rollback();
    }

    @Override
    public ResultSet consulter(String requete) throws SQLException {
        ResultSet rs;
        Statement st = getConnexion().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = st.executeQuery(requete);
        return rs;
    }

    @Override
    public ResultSet consulter(String requete, List param) throws SQLException {
        ResultSet rs;
        int index = 0;
        PreparedStatement ps = this.getConnexion().prepareStatement(requete, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        for (Object o : param) {
            ps.setObject(++index, o);
        }
        rs = ps.executeQuery();
        return rs;
    }

    @Override
    public int mettreAJour(String requete) throws SQLException {
        int nb;
        Statement st = getConnexion().createStatement();
        nb = st.executeUpdate(requete);
        return nb;
    }

    @Override
    public int mettreAJour(String requete, List param) throws SQLException {
        int nb;
        int index = 0;
        PreparedStatement ps = this.getConnexion().prepareStatement(requete);
        for (Object o : param) {
            ps.setObject(++index, o);
        }
        nb = ps.executeUpdate();
        return nb;
    }

    @Override
    public ResultSet mettreAJourAvecClefsGenereesRetournees(String requete) throws SQLException {
        ResultSet rsGK;
        int nb;
        Statement st = getConnexion().createStatement();
        nb = st.executeUpdate(requete, Statement.RETURN_GENERATED_KEYS);
        rsGK = st.getGeneratedKeys();
        return rsGK;
    }

    @Override
    public ResultSet mettreAJourAvecClefsGenereesRetournees(String requete, List param) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getNomColonnes(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //Getter & Setters

    public static Jdbc getInstance() {
        return singleton;
    }
    
    public String getPiloteJdbc() {
        return piloteJdbc;
    }

    public void setPiloteJdbc(String piloteJdbc) {
        this.piloteJdbc = piloteJdbc;
    }

    public String getProtocoleJdbc() {
        return protocoleJdbc;
    }

    public void setProtocoleJdbc(String protocoleJdbc) {
        this.protocoleJdbc = protocoleJdbc;
    }

    public String getServeurBd() {
        return serveurBd;
    }

    public void setServeurBd(String serveurBd) {
        this.serveurBd = serveurBd;
    }

    public String getNomBd() {
        return nomBd;
    }

    public void setNomBd(String nomBd) {
        this.nomBd = nomBd;
    }

    public String getLoginSgbd() {
        return loginSgbd;
    }

    public void setLoginSgbd(String loginSgbd) {
        this.loginSgbd = loginSgbd;
    }

    public String getMdpSgbd() {
        return mdpSgbd;
    }

    public void setMdpSgbd(String mdpSgbd) {
        this.mdpSgbd = mdpSgbd;
    }

    public Connection getConnexion() {
        return connexion;
    }

    public void setConnexion(Connection connexion) {
        this.connexion = connexion;
    }
    
}
