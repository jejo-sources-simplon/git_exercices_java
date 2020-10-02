package com.company;

public class Main {

    static int[][] tbA = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
    static int[][] tbB = {{8,9},{10,11,12,13,14,15,16,17},{18,19}};
    static double[][] intSomme;
    static int[][] tbTranspose;
    static double[][] intMultiplication;

    public static void main(String[] args) {

        intSomme = sommeOuMultiplication(tbA, tbB, (byte)0);
        echange(tbA, 0, 2, 1, 2);
        tbTranspose = retournertTransposee(tbA);
        echangeLignes (tbB, 0,2);
        intMultiplication = sommeOuMultiplication(tbA, tbB, (byte)1);

    }

    public static double[][] sommeOuMultiplication(int[][] tbA, int[][] tbB, byte cas){
        double[][] intSommeOuMuliplicationTb = {{0.0},{0.0}};
        String message;

        if (cas==0) {
            message = "Somme";
        } else {
            message ="Muliplication";
            intSommeOuMuliplicationTb[0][0] = intSommeOuMuliplicationTb[1][0] = 1;
        }
        message += " des valeurs par tableaux d'entiers :";
        System.out.println(message);

        System.out.println("afficher les valeurs du premier tableau de tableaux :");
        for (int c=0 ; c<tbA.length ; c++) {
            for (int d=0 ; d<tbA[c].length; d++) {
                System.out.print(tbA[c][d] + " ");
                if (cas == 0){
                    intSommeOuMuliplicationTb[0][0] += tbA[c][d];
                } else {
                    intSommeOuMuliplicationTb[0][0] *= tbA[c][d];
                }
            }
            System.out.println();
        }
        System.out.println("afficher les valeurs du second tableau de tableaux :");
        for (int c=0 ; c<tbB.length ; c++) {
            for (int d=0 ; d<tbB[c].length; d++) {
                System.out.print(tbB[c][d] + " ");
                if (cas == 0){
                    intSommeOuMuliplicationTb[1][0] += tbB[c][d];
                } else {
                    intSommeOuMuliplicationTb[1][0] *= tbB[c][d];
                }
            }
            System.out.println();
        }
        System.out.println();

        return intSommeOuMuliplicationTb;
    }

    public static void echange (int[][] tbA, int i1, int j1, int i2, int j2){
        int permut;

        System.out.println("Permutation de valeurs :");

        System.out.println("Afficher les valeurs du tableau de tableaux :");
        for (int c=0 ; c<tbA.length ; c++) {
            for (int d=0 ; d<tbA[c].length; d++) {
                System.out.print(tbA[c][d] + " ");
            }
            System.out.println();
        }

        System.out.println("Permutation des valeurs " + i1 + " et " + j1 + " dans le premier sous-tableau.");
        permut = tbA[0][i1] ; tbA[0][i1] = tbA[0][j1] ; tbA[0][j1] = permut;
        System.out.println("Permutation des valeurs " + i2 + " et " + j2 + " dans le second sous-tableau.");
        permut = tbA[1][i2] ; tbA[1][i2] = tbA[1][j2] ; tbA[1][j2] = permut;

        System.out.println("Afficher les valeurs du tableau de tableaux :");
        for (int c=0 ; c<tbA.length ; c++) {
            for (int d=0 ; d<tbA[c].length; d++) {
                System.out.print(tbA[c][d] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] retournertTransposee(int[][] tbA){
        int [][] tbTranspose = new int[tbA[0].length][tbA.length];

        System.out.println("Afficher les valeurs du tableau de tableaux :");
        for (int c=0 ; c<tbA.length ; c++) {
            for (int d=0 ; d<tbA[c].length; d++) {
                System.out.print(tbA[c][d] + " ");
            }
            System.out.println();
        }

        System.out.println("Calcul du tableau transposé.");
        for (int c=0 ; c<tbA.length ; c++){
            for (int d=0 ; d<tbA[0].length ; d++) {
                tbTranspose[d][c] = tbA[c][d];
            }
        }

        System.out.println();
        System.out.println("Afficher les valeurs du tableau de tableaux transposé :");
        for (int c=0 ; c<tbTranspose.length ; c++) {
            for (int d=0 ; d<tbTranspose[c].length; d++) {
                System.out.print(tbTranspose[c][d] + " ");
            }
            System.out.println();
        }

        return tbTranspose;
    }

    public static void echangeLignes (int[][] tbB, int i1, int i2){

        System.out.println("Echanger deux sous-tableaux d'un tableau.");

        if (tbB[i1].length != tbB[i2].length){

            System.out.println("Les deux sous-tableaux d'index " + i1 + " et " + i2 + " n'ont pas la même dimension !");
            System.out.println("L'échange ne peut pas être réalisé.");

        } else {

            int nbCol = tbB[i1].length;

            System.out.println("Afficher les valeurs initiales du tableau de tableaux :");
            for (int c=0 ; c<tbB.length ; c++) {
                for (int d=0 ; d<tbB[c].length; d++) {
                    System.out.print(tbB[c][d] + " ");
                }
                System.out.println();
            }

            System.out.println("Echange des sous-tableaux.");
            int [] tbTmp = new int[nbCol];
            for (int c=0 ; c<nbCol ; c++){
                tbTmp[c] = tbB[i1][c];
            }
            for (int c=0 ; c<nbCol ; c++){
                tbB[i1][c] = tbB[i2][c];
            }
            for (int c=0 ; c<nbCol ; c++){
                tbB[i2][c] = tbTmp[c];
            }

            System.out.println("Afficher les valeurs échangées du tableau de tableaux :");
            for (int c=0 ; c<tbB.length ; c++) {
                for (int d=0 ; d<tbB[c].length; d++) {
                    System.out.print(tbB[c][d] + " ");
                }
                System.out.println();
            }

        }
    }

}
