package com.company;

// La classe principale.
class Pays {

    private String   nom;
    private String   code;
    private int      nbHabitant;

    public int getNbHabitant() {
        return nbHabitant;
    }

    public void setNbHabitant(int nbHabitant) {
        this.nbHabitant = nbHabitant;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Pays(String nom) {
        this.nom = nom;
    }

    public Pays(String nom, int nbHabitant) {
        this.nom = nom;
        this.nbHabitant = nbHabitant;
    }

    public Pays(String nom, int nbHabitant, String code) {
        this.nom = nom;
        this.nbHabitant = nbHabitant;
        this.code = code;
    }

    public String toString() {
        System.out.println("Pays : " + this.nom);
        System.out.println("\tnombre d'habitants : " + this.nbHabitant);
        System.out.println("\tcode international : " + code);
        return null;
    }

}

