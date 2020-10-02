package com.company;

public class Main {

    public static void main(String[] args) {

        int result1 = 7-4+2;
        int result2 = (7-4)+2;

        System.out.println("Associativité des opérateurs");
        System.out.println("\t expression considérée : 7-4+2");
        System.out.println("\t valeur calculée par Java : " +  result1);
        System.out.println("\t valeur calculée comme (7-4)+2 : " + result2);
        if (result1==result2){
            System.out.println("\t => les valeurs sont identiques : l'opérateur '-' est associatif à gauche sous Java.");
            System.out.println("\t => pour comparaison : 7-(4+2) = " + (7-(4+2))) ;
        } else {
            System.out.println("\t\t NE DOIT PAS S'AFFICHER : contraire aux règles Java.");
        }
        System.out.println();

        result1 = 7*4+2;
        result2 = (7*4)+2;

        System.out.println("Priorité des opérateurs");
        System.out.println("\t expression considérée : 7*4+2");
        System.out.println("\t valeur calculée par Java : " +  result1);
        System.out.println("\t valeur calculée comme (7*4)+2 : " + result2);
        if (result1==result2){
            System.out.println("\t => les valeurs sont identiques : l'opérateur 'x' est prioritaire sur l'opérateur '+';");
            System.out.println("\t => pour comparaison : 7*(4+2) ; = "+ (7*(4+2))) ;
        } else {
            System.out.println("\t\t NE DOIT PAS S'AFFICHER : contraire aux règles Java.");
        }

    }
}
