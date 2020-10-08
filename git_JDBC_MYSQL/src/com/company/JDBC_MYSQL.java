package com.company;

import java.sql.*;

/**
 * Classe JDBC  : accès et requêtes sur une  de données MYSQL.
 *
 * @see Main
 *
 * @author : JJONDEAU
 * @version : 1.0
 */
public class JDBC_MYSQL {

    /**
     * L'adresse de la base MySQL.
     *
     * <p>
     *     Formats de l'adresse : adresseIP:port, localhost:3306
     * </p>
     */
    private String ipBase;
    /**
     * Le nom de la base de données MySQL.
     */
    private String nomBase;
    /**
     * Le nom de connexion à la base de données MySQL.
     */
    private String loginBase;
    /**
     * Le mot de passe de connexion à la base de données MySQL.
     */
    private String passwordBase;
    /**
     * L'objet Connecion pour utiliser les accès à la base de données.
     */
    private Connection connexion;
    /**
     * L'objet ResulSet pour stocker les informations extraites de la base de donneés.
     */
    private ResultSet resultSet;
    /**
     * Un drapeau (true/false) pour indiquer si la connexion avec la base de données a été établie.
     */
    private boolean statutconnexion;

    /**
     * Le constructeur de la classe JDBC_MYSQL.
     *
     * @param ipBase
     *  L'adresse de la base MySQL.
     * @param nomBase
     *  Le nom de la base de données MySQL.
     * @param loginBase
     *  Le mot de passe de connexion à la base de données MySQL.
     * @param passwordBase
     *  Le mot de passe de connexion à la base de données MySQL.
     */
    public JDBC_MYSQL(String ipBase,  String nomBase, String loginBase, String passwordBase) {
        this.ipBase = ipBase;
        this.nomBase = nomBase;
        this.loginBase = loginBase;
        this.passwordBase = passwordBase;
        connexion = startConnexion();
   }

    /**
     * Créer la connexion à la base de données MySQL.
     *
     * @return Une instance Connection sur la base de donées MySQL.
     */
    private Connection startConnexion() {
        Connection connex;
        try {
            String protocol = "jdbc:";
            String sousProtocol = "mysql://";
            String ip = ipBase + "/";
            String base = nomBase;
            String parametres = "?useSSL=false&serverTimezone=Europe/Paris";
            String login = loginBase;
            String password = passwordBase;
            String url = protocol + sousProtocol + ip + base + parametres;
            connex= DriverManager.getConnection(url, login, password);
            System.out.println("=> Connecté à la base de données " + nomBase + ".");
            statutconnexion = true;
            return connex;
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données " + nomBase + ".");
            statutconnexion = false;
            return null;
        }
    }

    /**
     * Retourner le status de connexion à la base de données MySQL.
     *
     * @return Un drapeau : true pour connexion établie, false pour connexion non établie.
     */
    public boolean getStatutConnexion() {
        return statutconnexion;
    }

    /**
     * Préparer, exécuter et afficher la requête 'query' non paramétrée.
     *
     * @param requete
     *  La requête à exécuter.
     */
    public void exeReqSelectSansParametre(String requete) {
        if (connexion == null) {
            System.out.println("Non connecté à la base de données.");
        } else {
            resultSet = reqSelectSansParametre(requete);
            afficherResultSet();
        }
    }

    /**
     * Exécuter la requête 'query' non paramétrée.
     *
     * @return Un ResultSet contenant les informations extraites de la base de donneés.
     *
     * @param req
     *  La requête à exécuter.
     *
     *  <p>
     *      Retourne null si la requête n'a pas pu être exécutée.
     *  </p>
     *
     */
    private ResultSet reqSelectSansParametre(String req) {
        try {
            PreparedStatement etatPrepare;
            etatPrepare = connexion.prepareStatement(req);
            return etatPrepare.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Préparer, exécuter et afficher la requête 'query' paramétrée.
     *
     * @param requete
     *  La requête à exécuter.
     * @param param
     *  Les paramètres de requête, concaténés dans une chaîne de caractères et séparés par une virgule.
     */
    public void exeReqSelectAvecParametre(String requete, String param) {
        if (connexion == null) {
            System.out.println("Non connecté à la base de données.");
        } else {
            resultSet = reqSelectAvecParametres(requete, param);
            afficherResultSet();
        }
    }

    /**
     * Exécuter la requête 'query' paramétrée.
     *
     * @return Un ResultSet contenant les informations extraites de la base de donneés.
     *
     * @param req
     *  La requête à exécuter.
     * @param param
     *  Les paramètres de requête, concaténés dans une chaîne de caractères et séparés par une virgule.
     *
     *  <p>
     *      Retourne null si la requête n'a pas pu être exécutée.
     *  </p>
     *
     */
    private ResultSet reqSelectAvecParametres(String req, String param) {
        String[] tbParam = param.split(",");
        try {
            PreparedStatement etatPrepare;
            etatPrepare = connexion.prepareStatement(req);
            for (int c=0; c<tbParam.length; c++) {
                etatPrepare.setString(c+1, tbParam[c]);
            }
            return etatPrepare.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Préparer, exécuter et afficher la requête 'update' non paramétrée.
     *
     * @param requete
     *  La requête à exécuter.
     */
    public void exeReqUpdateSansParametre(String requete) {
        if (connexion == null) {
            System.out.println("Non connecté à la base de données.");
        } else {
            afficherRetourRequeteUpdate(reqUpdateSansParametre(requete));
        }
    }

    /**
     * Exécuter la requête 'update' non paramétrée.
     *
     * @return Un entier indiquant le nombre de lignes modifiées/créées.
     *
     * @param req
     *  La requête à exécuter.
     *
     *  <p>
     *      Retourne :
     *      <ul>
     *          <i>-1 pour indiquer qu'aucune modification n'a été enregistrée</i>
     *          <i>tout nombre >0 pour indiquer le nombre de modifications enregistrées</i>
     *      </ul>
     *  </p>
     *
     */
    private int reqUpdateSansParametre(String req) {
        try {
            PreparedStatement etatPrepare;
            etatPrepare = connexion.prepareStatement(req);
            return etatPrepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Préparer, exécuter et afficher la requête 'update' paramétrée.
     *
     * @param requete
     *  La requête à exécuter.
     * @param param1
     *  Les paramètres de requête, concaténés dans une chaîne de caractères et séparés par une virgule.
     * @param param2
     *  Le nombre de paramètres à utiliser pour chaque requête.
     */
    public void exeReqUpdateAvecParametre(String requete, String param1, String param2) {
        if (connexion == null) {
            System.out.println("Non connecté à la base de données.");
        } else {
            afficherRetourRequeteUpdate(reqUpdateAvecParametres(requete, param1, param2));
        }
    }

    /**
     * Exécuter la requête 'update' paramétrée.
     *
     * @return Un entier indiquant le nombre de lignes modifiées/créées.
     *
     * @param req
     *  La requête à exécuter.
     * @param param1
     *  Les paramètres de requête, concaténés dans une chaîne de caractères et séparés par une virgule.
     * @param param2
     *  Le nombre de paramètres à utiliser pour chaque requête.
     *
     *  <p>
     *      Retourne null si la requête n'a pas pu être exécutée.
     *  </p>
     *
     */
    private int reqUpdateAvecParametres(String req, String param1, String param2) {
        /**
         * Tableau de travail utilisé pour isoler les paramètres reçus.
         */
        String[] tbParam = param1.split(",");
        /**
         * Le cast en eninter du nombre de paramètres à utiliser pour chaque requête.
         */
        int nbParam = Integer.parseInt(param2);
        /**
         * Le cumul du nombre modifications enregistrées pour toutes les requêtes.
         */
        int nbModif = 0;
        /**
         * Le nombre modifications enregistrées pour chaque requête.
         */
        int nbM = 0;
        try {
            PreparedStatement etatPrepare;
            etatPrepare = connexion.prepareStatement(req);
            for (int c=0; c<tbParam.length; c+=nbParam) {
                for (int d=0; d<nbParam; d++) {
                    etatPrepare.setString(d+1, tbParam[c+d]);
                }
                nbM = etatPrepare.executeUpdate();
                if (nbM != -1) nbModif++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return nbModif;
    }

    /**
     * Afficher le résultat d'une requête 'query' paramétrée ou non paramétrée.
     */
    private void afficherResultSet() {
        try {
            /**
             * Métadonnées du ResultSet de la requête exécutée.
             */
            ResultSetMetaData resMeta = resultSet.getMetaData();
            for (int c = 1; c <= resMeta.getColumnCount(); c++) {
                System.out.print(resMeta.getColumnLabel(c) + " ");
            }
            System.out.println();
            while (resultSet.next()) {
                for (int c = 1; c <= resMeta.getColumnCount(); c++) {
                    switch (resMeta.getColumnTypeName(c)) {
                        case "CHAR":
                        case "VARCHAR":
                            System.out.print(resultSet.getString(c));
                            break;
                        case "TINYINT":
                            System.out.print(resultSet.getByte(c));
                            break;
                        case "SMALLINT":
                            System.out.print(resultSet.getShort(c));
                            break;
                        case "INTEGER":
                            System.out.print(resultSet.getInt(c));
                            break;
                        case "BIGINT":
                            System.out.print(resultSet.getLong(c));
                            break;
                        case "TIMESTAMP":
                            System.out.println(resultSet.getTimestamp(c));
                        default:
                            break;
                    }
                    System.out.print(" ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Afficher le résultat d'une requête 'update' paramétrée ou non paramétrée.
     */
    private static void afficherRetourRequeteUpdate(int nbModif){
        if (nbModif == -1) {
            System.out.println("Aucun enregistrement n'a été ajouté.");
        } else {
            System.out.println(nbModif + " enregistrement(s) ajouté(s).");
        }
    }
}
