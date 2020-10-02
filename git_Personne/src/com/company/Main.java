package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Créer les personnes.
        Personne personneSeule = new Personne(Outils.scannerSaisieChaine("Saisir le nom de la personne seule : "));
        Personne ami1 = new Personne(Outils.scannerSaisieChaine("Saisir le nom de la personne ami1 : "));
        Personne ami2 = new Personne(Outils.scannerSaisieChaine("Saisir le nom de la personne ami2 : "));

        // Rendre les personnes ami1 et ami2 amies l'une de l'autre.
        ami1.setAmi(ami2);
        ami2.setAmi(ami1);

        // Affichage.
        System.out.println();
        System.out.println(personneSeule.toString("personneSeule"));
        System.out.println(ami1.toString("ami1"));
        System.out.println(ami2.toString("ami2"));

    }
}

/* **************************************
    Définition de la classe Personne.
* ***************************************/
class Personne {

    // Définition des attributs privés.
    private String nom;
    private Personne ami;

    // Constructeur avec un seul paramètre : le nom.
    // Dans ce cas, la personne créée n'aura pas d'ami.
    Personne(String nom){
        this.nom = nom;
    }

    // Constructeur avec deux paramètres : le nom et un objet Personne.
    // Dans ce cas, la personne aura un nom et un ami.
    Personne(String nom, Personne Ami){
        this.nom = nom;
        this.ami = ami;
    }

    // Asseseur : cette méthode permet de lire le contenu de l'attribut
    // ami, déclaré private et donc inaccessible depuis l'extérieur de l'objet.
    public Personne getAmi() {
        return ami;
    }

    // Mutateur : cette méthode permet de modifier le contenu de l'attribut
    // ami, déclaré private et donc inaccessible depuis l'extérieur de l'objet.
    public void setAmi(Personne ami) {
        this.ami = ami;
    }

    // Méthode d'affichage.
    public String toString(String nomPersonne){
        String message = "";

        message += "Le nom de la personne " + nomPersonne + " est " + nom;
        if (ami != null){
            // L'attibut ami est null (non initialisé : la personne n'a donc pas d'ami.
            message += "\n\tLe nom de son ami est " + ami.nom;
        } else {
            // L'attibut ami est initialisé (non null) : la personne a donc un ami.
            message += "\n\tCette personne n'a pas d'ami.";
        }
        return message;
    }

}

/* **************************************
    Définition de la classe outils.
* ***************************************/
class Outils {

    public static String scannerSaisieChaine(String message){

        /* Déclaration de variable
            chaineSaisie : la chaîne à saisir
        */
        String chaineSaisie;

        // Définir un Scanner.
        Scanner sc = new Scanner(System.in);

        // Afficher le message de saisie.
        System.out.println(message);

        // Lire la chaîne saisie au clavier.
        chaineSaisie = sc.nextLine();

        // Retourner la chaîne saisie.
        return chaineSaisie;

    }

}

