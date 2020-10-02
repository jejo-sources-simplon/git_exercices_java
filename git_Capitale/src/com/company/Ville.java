package com.company;

public class Ville extends Pays {

    private String nomVille, departement;
    private int     nbHabitant;
    private boolean capitale;

    public Ville(String nomCapitale, Boolean capitale, String nomPays) {
        super(nomPays);
        this.nomVille = nomCapitale;
        this.capitale = capitale;
    }

    public Ville(String nomCapitale, Boolean capitale, String nomPays, int nbHabitant, String code) {
        super(nomPays, nbHabitant, code);
        this.nomVille = nomCapitale;
        this.capitale = capitale;
    }

    public Ville(int nbHabitantCapitale, Boolean capitale, String nomCapitale, String nomPays, int nbHabitantPays, String code) {
        super(nomPays, nbHabitantPays, code);
        this.nomVille = nomCapitale;
        this.capitale = capitale;
        this.nbHabitant = nbHabitantCapitale;
    }

    @Override
    public int getNbHabitant() {
        return nbHabitant;
    }

    @Override
    public void setNbHabitant(int nbHabitant) {
        this.nbHabitant = nbHabitant;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public String toString() {
        super.toString();
        System.out.print("\tville : " + this.nomVille);
        if (this.capitale) {
            System.out.print(" (capitale)");
        }
        System.out.println();
        System.out.println("\t\tnombre d'habitants : " + this.nbHabitant);
        return null;
    }

}


