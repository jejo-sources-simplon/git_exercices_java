package com.company;

public class Main {

    public static void main(String[] args){

        Pays[] pays = new Pays[4];

        pays[0] = new Pays("France", 67, "FR");
        pays[0].toString();
        pays[1] = new Ville("Londres", true, "Angleterre", 50, "UK");
        pays[1].toString();
        pays[2] = new Monument("Empire States", "New york", true, "Etats Unis");
        pays[2].toString();

        System.out.println("***********************************************");

        pays[0].setCode("FR");
        pays[0].toString();
        pays[1].setNbHabitant(17);
        pays[1].toString();
        pays[2].setCode("US");
        pays[2].toString();
        pays[2].setNbHabitant(10);
        pays[2].toString();

        System.out.println("***********************************************");

        pays[3] = new Conservateur("Toto", "Tour Eiffel", "Paris2", false, "France2");
        pays[3].toString();
        pays[3].setCode("FR2");
        pays[3].toString();

    }

}

