package com.company;

import java.sql.*;
import java.util.ArrayList;

/**
 * Classe de démonstration  : requêtes SQL sur base de données MYSQL.
 * <p>
 * Types de requêtes testées :
 * requêtes 'query' non paramétrées
 * requêtes 'query' paramétrées 1 à n String
 * requêtes 'update' non paramétrées
 * requêtes 'update' paramétrées 1 à n String
 * </p>
 *
 * @see JDBC_MYSQL
 *
 * @author : JJONDEAU
 * @version : 1.0
 */
public class Main {
    public static void main(String[] args) throws SQLException {

        /**
         * Connexion sur une base de dommées MySQL.
         */
        JDBC_MYSQL jdbc_mysql = new JDBC_MYSQL("localhost:3306", "sakila", "root", "root");
        if (jdbc_mysql.getStatutConnexion() == true) {

            // Requêtes 'query' sans paramètre.
                /**
                 * Liste des requêtes SQL 'query' non paramétrées.
                 */
                ArrayList<String> listeReqSelectSansParametre = new ArrayList<String>();
                /**
                 * Initialiser la table des requêtes SQL 'query' non paramétrées.
                 *
                 * @param listeReqSelectSansParametre
                 *  La référence de la liste à initialiser.
                 */
                initlisteReqSelectSansParametre(listeReqSelectSansParametre);
                // Exécuter et afficher les requêtes.
                for (int c = 0; c < listeReqSelectSansParametre.size(); c+=2) {
                    System.out.println();
                    System.out.println("=> " + listeReqSelectSansParametre.get(c));
                    jdbc_mysql.exeReqSelectSansParametre(listeReqSelectSansParametre.get(c+1));
                }

            // Requêtes 'query' avec paramètre.
                /**
                 * Liste des requêtes SQL 'query' paramétrées.
                 */
                ArrayList<String> listeReqSelectAvecParametre = new ArrayList<String>();
                /**
                 * Initialiser la table des requêtes SQL 'query' paramétrées 1..n String.
                 *
                 * @param listeReqSelectSansParametre
                 *  La référence de la liste à initialiser.
                 */
                initlisteReqSelectAvecParametre(listeReqSelectAvecParametre);
                // Exécuter et afficher les requêtes.
                for (int c = 0; c < listeReqSelectAvecParametre.size(); c+=3) {
                    System.out.println();
                    System.out.println("=> " + listeReqSelectSansParametre.get(c));
                    jdbc_mysql.exeReqSelectAvecParametre(listeReqSelectAvecParametre.get(c+1), listeReqSelectAvecParametre.get(c+2));
                }

            // Requêtes 'update' sans paramètre.
                /**
                 * Liste des requêtes SQL 'update' non paramétrées.
                 */
                ArrayList<String> listeReqUpdateSansParametre = new ArrayList<String>();
                /**
                 * Initialiser la table des requêtes SQL 'update' non paramétrées.
                 *
                 * @param listeReqSelectSansParametre
                 *  La référence de la liste à initialiser.
                 */
                InitListeReqUpdateSansParametre(listeReqUpdateSansParametre);
                // Exécuter et afficher les requêtes.
                for (int c = 0; c < listeReqUpdateSansParametre.size(); c+=2) {
                    System.out.println();
                    System.out.println("=> " + listeReqUpdateSansParametre.get(c));
                    jdbc_mysql.exeReqUpdateSansParametre(listeReqUpdateSansParametre.get(c+1));
                }

            // Requêtes 'update' avec paramètre.
                /**
                 * Liste des requêtes SQL 'update' paramétrées.
                 */
                ArrayList<String> listeReqUpdateAvecParametre = new ArrayList<String>();
                /**
                 * Initialiser la table des requêtes SQL 'update' paramétrées 1..n String.
                 *
                 * @param listeReqSelectSansParametre
                 *  La référence de la liste à initialiser.
                 */
                InitListeReqUpdateAvecParametre(listeReqUpdateAvecParametre);
                // Exécuter et afficher les requêtes.
                for (int c = 0; c < listeReqUpdateAvecParametre.size(); c+=4) {
                    System.out.println();
                    System.out.println("=> " + listeReqUpdateAvecParametre.get(c));
                    jdbc_mysql.exeReqUpdateAvecParametre(listeReqUpdateAvecParametre.get(c+1), listeReqUpdateAvecParametre.get(c+2),
                            listeReqUpdateAvecParametre.get(c+3));
                }
        }
    }

    /**
     * Initialiser la liste de requêtes 'query' non paramétrées.
     *
     * @param listeReqSelectSansParametre
     *  La référence de la liste à initialiser.
     */
    public static void initlisteReqSelectSansParametre(ArrayList<String> listeReqSelectSansParametre) {
        listeReqSelectSansParametre.add("Récupérer le full_name des sept premiers acteurs de la table sous le format : first_name + ' ' + last_name");
        listeReqSelectSansParametre.add("SELECT ACTOR.FIRST_NAME, ACTOR.LAST_NAME FROM SAKILA.ACTOR LIMIT 7");
        listeReqSelectSansParametre.add("Récupérer le full_name des sept premiers acteurs de la table sous le format : first_name en minuscule + ' ' + last_name en majuscules");
        listeReqSelectSansParametre.add("SELECT LOWER(ACTOR.FIRST_NAME) AS LOWER_FIRSTNAME, UPPER(ACTOR.LAST_NAME) as UPPER_LASTNAME FROM SAKILA.ACTOR LIMIT 7");
        listeReqSelectSansParametre.add("Récupérer dans une colonne ACTOR_NAME le full_name des sept premiers acteurs de la table sous le format: last_name en majuscule + '.' + premiere lettre du first_name en majuscule");
        listeReqSelectSansParametre.add("SELECT CONCAT(upper(actor.last_name),'.',upper(substring(actor.first_name,1,1)),lower(substring(first_name,2,length(first_name)))) as ACTOR_NAME FROM sakila.actor LIMIT 7");
        listeReqSelectSansParametre.add("Trouver les sept premiers acteurs de la table ayant des prénoms de 3 charactères");
        listeReqSelectSansParametre.add("SELECT first_name, last_name FROM actor WHERE LENGTH(first_name)=3 LIMIT 7");
        listeReqSelectSansParametre.add("Afficher les sept premiers acteurs (first_name, last_name, nbre char first_name, nbre char last_name )par ordre décroissant de longueur de prénoms");
        listeReqSelectSansParametre.add("SELECT actor.first_name, actor.last_name, length(actor.first_name), length(actor.last_name) FROM sakila.actor ORDER BY length(actor.first_name) DESC LIMIT 7");
        listeReqSelectSansParametre.add("Afficher la liste des acteurs (first_name, last_name) dont le first_name est TEST11");
        listeReqSelectSansParametre.add("SELECT actor.first_name, actor.last_name FROM sakila.actor WHERE last_name='TEST11'");
    }

    /**
     * Initialiser la liste de requêtes 'query' paramétrées 1..n String.
     *
     * @param listeReqSelectAvecParametre
     *  La référence de la liste à initialiser.
     */
    private static void initlisteReqSelectAvecParametre(ArrayList<String> listeReqSelectAvecParametre) {
        listeReqSelectAvecParametre.add("Trouver dans la table country les countries 'China', 'Afghanistan' et 'Bangladesh");
        listeReqSelectAvecParametre.add("SELECT * FROM sakila.country WHERE country.country=? OR country.country=? OR country.country=?");
        listeReqSelectAvecParametre.add("China,Afghanistan,Bangladesh");
        listeReqSelectAvecParametre.add("Trouver les acteurs dont le last_name est 'DAVIS' ou 'GABLE'");
        listeReqSelectAvecParametre.add("SELECT actor_id, first_name, last_name FROM sakila.actor WHERE last_name=? OR  last_name=?");
        listeReqSelectAvecParametre.add("DAVIS,GABLE");
    }

    /**
     * Initialiser la liste de requêtes 'update' non paramétrées 1..n String.
     *
     * @param listeReqUpdateSansParametre
     *  La référence de la liste à initialiser.
     */
    private static void InitListeReqUpdateSansParametre(ArrayList<String> listeReqUpdateSansParametre) {
        listeReqUpdateSansParametre.add("Insérer un nouvel acteur dont le last_name est DURAND et le prénom DURAND_0");
        listeReqUpdateSansParametre.add("INSERT INTO SAKILA.ACTOR VALUE(ACTOR_ID, 'DURAND_0', 'DURAND', LAST_UPDATE)");
    }

    /**
     * Initialiser la liste de requêtes 'query' non paramétrées 1..n String.
     *
     * @param listeReqUpdateAvecParametre
     *  La référence de la liste à initialiser.
     */
    private static void InitListeReqUpdateAvecParametre(ArrayList<String> listeReqUpdateAvecParametre) {
        listeReqUpdateAvecParametre.add("Insérer quatre nouveaux acteurs dont le last_name est DURAND et le prénom DURAND_1 à DURAND_4");
        listeReqUpdateAvecParametre.add("INSERT INTO SAKILA.ACTOR VALUE(ACTOR_ID, ?, ?, LAST_UPDATE)");
        listeReqUpdateAvecParametre.add("DURAND_1,DURAND,DURAND_2,DURAND,DURAND_3,DURAND,DURAND_4,DURAND");
        listeReqUpdateAvecParametre.add("2");
    }
}

