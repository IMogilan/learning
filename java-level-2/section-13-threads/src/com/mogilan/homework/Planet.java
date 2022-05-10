package com.mogilan.homework;

import java.util.Random;

public class Planet {

    private String name;
    private int redCrystalsOnPlanet = 0;
    private int whiteCrystalsOnPlanet = 0;
    private static Random random = new Random();


    public Planet(String name) {
        this.name = name;
    }

    public synchronized void addNewRedCrystal() {
        redCrystalsOnPlanet++;
        System.out.println("On planet " + name + " grown new Red crystal" );
    }

    public synchronized boolean addNewRedCrystal(Crystal crystal) {
       if (crystal == Crystal.RED) {
           redCrystalsOnPlanet++;
           System.out.println("On planet " + name + " grown new Red crystal" );
           return true;
       } else return false;

    }

    public synchronized void addNewWhiteCrystal() {
        whiteCrystalsOnPlanet++;
        System.out.println("On planet " + name + " grown new White crystal" );
    }

    public synchronized boolean addNewWhiteCrystal(Crystal crystal) {
        if (crystal == Crystal.WHITE) {
            whiteCrystalsOnPlanet++;
            System.out.println("On planet " + name + " grown new White crystal" );
            return true;
        } else return false;
    }

    public synchronized Crystal getRedCrystal () {
        if (redCrystalsOnPlanet > 0 ) {
            redCrystalsOnPlanet--;
            return Crystal.RED;
        } else {
            return null;
        }
    }

    public synchronized Crystal getWhiteCrystal () {
        if (whiteCrystalsOnPlanet > 0 ) {
            whiteCrystalsOnPlanet--;
            return Crystal.WHITE;
        } else {
            return null;
        }
    }

    public synchronized Crystal getRandomCrystal () {
         return random.nextInt(2) == 0 ? getRedCrystal(): getWhiteCrystal();
    }

    public int getRedCrystalsOnPlanet() {
        return redCrystalsOnPlanet;
    }

    public int getWhiteCrystalsOnPlanet() {
        return whiteCrystalsOnPlanet;
    }
}
