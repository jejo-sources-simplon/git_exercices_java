package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /* =========================================================================
        Objectif    : calculer le nombre de pièces de monnaie pour un montant saisi au clavier.
        Variables   :
            montant     : le montant à diviser en pièces
            montantCalc : copie du montant à diviser en pièces, utilisée pour le calcul du nombre
                          de pièces et déclarée static pour être accessible globalement
            tbPieces    : tableau à deux entrées :
                - 1° : la valeur des pièces
                - 2° : le nombre calculé pour chaque pièce
     ========================================================================= */
    static float montantCalc;

    public static void main(String[] args) {
        float montant;
        float[][] tbPieces  = {{0.5f,0.2f,0.1f, 0.05f, 0.02f, 0.01f},{0,0,0,0,0,0}};

        // Affichage de départ et saisie du montant à diviser.
        System.out.println("Payer en pièces de monnaie");

        // Saisir le montant à diviser.
        do {
            montant = montantCalc =SaisieFloat("Saisir le montant à payer : : ");
        } while (erreurValNumSaisie((double)montant, 0, (byte)4));

        //  Diviser le montant saisi en pièces de monnaie.
        for (int c=0;c<6;c++){
            // Calculer le nombre de chaque pièces dans le montant saisi.
            // Ce nombre est stocké dans la deuxième entrée corrrespodante du tableau [tbPieces].
            // A chaque exécution, la valeur du nombre de pièces calculé est soustrait de [montantCalc].
            tbPieces[1][c] = nombrePieces(tbPieces[0][c]);
            if (montantCalc == 0) break;
        }

        // Affichage final.
        System.out.println();
        System.out.println("Pour payer " + montant +", il faut disposer : ");
        for (int c=0;c<6;c++){
            // Lister le nombre nécessaire pour chaque pièce de monnaie.
            if (tbPieces[1][c]!=0){
                System.out.println("de " + tbPieces[1][c] + " pièce(s) de " + tbPieces[0][c]);
            }
        }

    }

    /* =========================================================================
        Objectif    : calculer un nombre de pièces
        Paramètre   : la valeur d'une pièce
        Variables   :
            nbPieces    : le nombre calculé de pièces (int)
     ========================================================================= */
    public static int nombrePieces(float valPiece){
        // Calculer le nombre de pièces.
        int nbPieces = (int)(montantCalc/valPiece);

        // Soustraire la valeur calculée en pièces du montant à diviser.
        montantCalc-=nbPieces*valPiece;

        // Limiter à trois déccimales.
        montantCalc=(float)Math.round(montantCalc*1000)/1000;

        // Retourner le nombre calculé de pièces.
        return nbPieces;
    }

    /* =========================================================================
        Objectif    : saisir une valeur float au clavier
        Paramètre   : le message de saisie à afficher (String)
        Variables   :
            floatSaisi  : la valeur float saisie (float)
            scan        : la variable Scanner utilisée pour la saisie au clavier (Scanner)
     ========================================================================= */
    public static float SaisieFloat(String message){
        float floatSaisi;

        do{
            // Initialiser la lecture au clavier.
            Scanner scan = new Scanner(System.in);
            // Afficher le message de saisie.
            System.out.println(message);
            try{
                // Récupérer la valeur saisie.
                floatSaisi = scan.nextFloat();
                // Retourner la valeur float saisie.
                return floatSaisi;
            } catch (InputMismatchException e) {
                // La valeur saisie n'est pas numérique : afficher un message et recommencer la saisie.
                System.out.println("La valeur saisie doit être une valeur numérique !");
            }
        } while (true);
    }

    /* =========================================================================
        Objectif    : tester une valeur numérique
        Paramètres  :
            + valSaisie : la valeur numérique à tester (double)
            + valTest   : la valeur numérique de comparaison (double)
            + casTest   : le cas de test (byte)
                + 0 : valSaisie < valTest
                + 1 : valSaisie <= valTest
                + 2 : valSaisie != valTest
                + 3 : valSaisie >= valTest
                + 4 : valSaisie > valTest
        Variables   :
            + message   : le message d'erreur à afficher (String)
            + valCalcul : variable de calcul (double)
     ========================================================================= */
    public static boolean erreurValNumSaisie(double valSaisie, double valTest, byte casTest){
        String message = "";
        double valCalcul = valSaisie - valTest;

        // Sélectionner et vérifier le cas de test.
        switch (casTest){
            case 0 :
                if (valCalcul>=0) message = "strictement inférieure";
                break;
            case 1:
                if (valCalcul>0) message = "inférieure ou égale";
                break;
            case 2 :
                if (valCalcul==0) message = "différente de";
                break;
            case 3 :
                if (valCalcul<0) message = "supérieure";
                break;
            case 4 :
                if (valCalcul<=0) message = "strictement supérieure";
        }

        // Exploiter le résultat du cas de test.
        if (message == ""){
            // Le test est vérifié.
            return false;
        } else {
            // Le test n'est pas vérifié.
            System.out.println("Saisir une valeur " + message + " à " + valTest + ".");
            return true;
        }
    }

}
