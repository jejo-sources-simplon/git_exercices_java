package com.company;

public class Conservateur extends Monument {

    private String nom;
    private int age;

    public Conservateur (String nom, String monument, String nomVille, Boolean capitale, String nomPays) {
        super(monument, nomVille, capitale, nomPays);
        this.nom = nom;
    }

    public  Conservateur (String nom, int age, String monument, String nomVille, Boolean capitale, String nomPays) {
        super(monument, nomVille, capitale, nomPays);
        this.nom = nom;
        this.age = age;
    }

    public String toString() {
        super.toString();
        System.out.println("\tconservateur : ");
        System.out.println("\t\tnom : " + this.nom);
        System.out.println("\t\tâge : " + this.age);
        return null;
    }

}
