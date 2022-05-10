package com.mogilan.homework;

public class CrystalRunner {

    public static void main(String[] args) {
        Day day = new Day();
        RaceOfMagic mageOfFire = new RaceOfMagic("Mage of Fire");
        RaceOfMagic mageOfAir = new RaceOfMagic("Mage of Air");
        Planet planetOfCrystals = new Planet("Planet of Crystals");
        PlanetThread planetThread = new PlanetThread(day, planetOfCrystals);
        Rocket rocketOfFire = new Rocket(day, planetOfCrystals, mageOfFire);
        Rocket rocketOfAir = new Rocket(day, planetOfCrystals, mageOfAir);

        day.start();
        planetThread.start();
        rocketOfFire.start();
        rocketOfAir.start();

        try {
            day.join();
            planetThread.join();
            rocketOfFire.join();
            rocketOfAir.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(mageOfFire);
        System.out.println(mageOfAir);
    }

}
