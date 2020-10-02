package com.company;

public class Monument extends Ville {

    private String monument;

    public  Monument (String monument, String nomVille, Boolean capitale, String nomPays) {
        super(nomVille, capitale, nomPays);
        this.monument = monument;
    }

    public String toString() {
        super.toString();
        System.out.println("\t\tmonument : " + monument);
        return null;
    }

}
