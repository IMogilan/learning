package com.mogilan.homework;

import java.util.Random;

import static com.mogilan.practice.RobotProductionUtil.ONE_DAY_DURATION;

public class PlanetThread extends Thread {

    private final Day day;
    private final Planet planet;
    private static Random random = new Random();
    public static final int MIN_NUMBER_OF_CRYSTAL_FOR_ONE_DAY = 2;
    public static final int MAX_NUMBER_OF_CRYSTAL_FOR_ONE_DAY = 5;

    public PlanetThread(Day day, Planet planet) {
        this.day = day;
        this.planet = planet;
    }

    @Override
    public void run() {
        synchronized (planet) {
            while (day.isNotFinished()) {
                System.out.println("Number of Red crystal on the Planet:" + planet.getRedCrystalsOnPlanet() + "\nNumber of White crystal on the Planet:" + planet.getWhiteCrystalsOnPlanet());
                addRandomCrystals();
                System.out.println("Number of Red crystal on the Planet:" + planet.getRedCrystalsOnPlanet() + "\nNumber of White crystal on the Planet:" + planet.getWhiteCrystalsOnPlanet());
                planet.notifyAll();
                try {
                    planet.wait(ONE_DAY_DURATION);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void addRandomCrystals () {
        int crystalsForThisDay = Math.max(MIN_NUMBER_OF_CRYSTAL_FOR_ONE_DAY, random.nextInt(MAX_NUMBER_OF_CRYSTAL_FOR_ONE_DAY));
        synchronized (planet) {
            for (int i = 0; i < crystalsForThisDay; i++) {
                Crystal newCrystal = Crystal.createRandomCrystal();
                if (newCrystal == Crystal.RED) {
                    planet.addNewRedCrystal();
                } else {
                    planet.addNewWhiteCrystal();
                }
            }
        }
    }
}
