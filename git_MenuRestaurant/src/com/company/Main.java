package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ClasseMenu menu1 = new ClasseMenu();
        menu1.principal();
        menu1.afficherCommande();
    }

}

class ClasseMenu {

    /* ***** Déclaration des attributs ***** */
    /* ************************************* */
    private char menu, legume;
    private Character boisson;
    private String supplement = "";

    /* ***** Déclaration des méthodes ***** */
    /* ************************************ */
    // Méthode principale.
    public void principal() {
        menu = saisieMenu();
        switch (menu) {
            case 'P' :
                legume = saisieLegume();
                boisson = saisieBoisson();
                break;
            case 'B' :
                legume = saisieLegume();
                if (unSupplement("Souhaitez-vous un boissons en supplément (O/N) ?")) {
                    supplement += saisieBoisson();
                }
                break;
            case 'V' :
                legume = 'L';
                if (unSupplement("Souhaitez-vous un supplément de riz (O/N) ?")) {
                    supplement += "R";
                }
                boisson = saisieBoisson();
                break;
        }
    }

    // Choisir un menu.
    private char saisieMenu () {
        boolean saisieMenu = false;
        char menuChoisi;

        do {
            System.out.println("*** MENU ***");
            System.out.println();
            System.out.println("P ... menu poulet");
            System.out.println("B ... menu boeuf");
            System.out.println("V ... menu végétarien");
            System.out.println();

            menuChoisi = scannerSaisieChar("Votre choix : ");
        } while (menuChoisi != 'P' & menuChoisi != 'B' & menuChoisi != 'V');

        return  menuChoisi;
    }

    // Choisir un légumes.
    private char saisieLegume () {
        boolean saisieMenu = false;
        char legumeChoisi;

        do {
            System.out.println("*** ACCOMPAGNEMENTS ***");
            System.out.println();
            System.out.println("L ... légumes frais");
            System.out.println("F ... frites");
            System.out.println("R ... riz");
            System.out.println();

            legumeChoisi = scannerSaisieChar("Votre choix : ");
        } while (legumeChoisi != 'L' & legumeChoisi != 'F' & legumeChoisi != 'R');

        return  legumeChoisi;
    }

    // Choisir une boisson.
    private char saisieBoisson () {
        boolean saisieboisson = false;
        char boissonChoisie;

        do {
            System.out.println("*** BOISSONS ***");
            System.out.println();
            System.out.println("G ... eau gazeuse");
            System.out.println("E ... eau plate");
            System.out.println("S ... soda");
            System.out.println();

            boissonChoisie = scannerSaisieChar("Votre choix : ");
        } while (boissonChoisie != 'G' & boissonChoisie != 'E' & boissonChoisie != 'S');

        return  boissonChoisie;
    }

    // Poser la question d'un suppément.
    private boolean unSupplement (String message) {
        char supplementChoisi;

        do {
            supplementChoisi = scannerSaisieChar(message);
        } while (supplementChoisi != 'O' & supplementChoisi != 'N');

        return  (supplementChoisi == 'O');
    }

    // Afficher la commande.
    public void afficherCommande(){

        System.out.println("Menu sélectionné : " + menu);
        System.out.println("avec en légumes : " + legume);
        if (supplement != "") {
            System.out.println("avec en suplément : " + supplement);
        };
        if (boisson != null) {
            System.out.println("Boisson : " + supplement);
        };

    }

    // saisir une chaîne au clavier, tenir uniquement compte du premier caractère.
    private char scannerSaisieChar(String message){

        /* Déclaration de variable
            charSaisie : le caractère à saisir
        */
        String chaineSaisie;

        // Définir un Scanner.
        Scanner sc = new Scanner(System.in);

        // Afficher le message de saisie.
        System.out.println(message);

        // Lire la valeur saisie au clavier.
        chaineSaisie = sc.nextLine().toUpperCase();
        chaineSaisie.toUpperCase();

        return chaineSaisie.charAt(0);

    }
}

