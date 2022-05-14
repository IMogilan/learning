package com.mogilan.practice;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Planet {

    private String name;
    private AtomicInteger redCrystalsOnPlanet = new AtomicInteger(0);
    private AtomicInteger whiteCrystalsOnPlanet = new AtomicInteger(0);
    private static Random random = new Random();


    public Planet(String name) {
        this.name = name;
    }

    public void addNewRedCrystal() {
        redCrystalsOnPlanet.incrementAndGet();
        System.out.println("On planet " + name + " grown new Red crystal" );
    }

    public boolean addNewRedCrystal(Crystal crystal) {
       if (crystal == Crystal.RED) {
           addNewRedCrystal();
           return true;
       } else return false;
    }

    public void addNewWhiteCrystal() {
        whiteCrystalsOnPlanet.incrementAndGet();
        System.out.println("On planet " + name + " grown new White crystal" );
    }

    public boolean addNewWhiteCrystal(Crystal crystal) {
        if (crystal == Crystal.WHITE) {
            addNewWhiteCrystal();
            return true;
        } else return false;
    }

    public Crystal getRedCrystal () {
        if (redCrystalsOnPlanet.get() > 0 ) {
            redCrystalsOnPlanet.decrementAndGet();
            return Crystal.RED;
        } else {
            return null;
        }
    }

    public Crystal getWhiteCrystal () {
        if (whiteCrystalsOnPlanet.get() > 0 ) {
            whiteCrystalsOnPlanet.decrementAndGet();
            return Crystal.WHITE;
        } else {
            return null;
        }
    }

    public Crystal getRandomCrystal () {
         return random.nextInt(2) == 0 ? getRedCrystal(): getWhiteCrystal();
    }

    public void printNumberOfCrystalsOnPlanet() {
        System.out.println("Number of Red crystal on the Planet:" + redCrystalsOnPlanet.get() + "\nNumber of White crystal on the Planet:" + whiteCrystalsOnPlanet.get());
    }
}
