package com.mogilan.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.mogilan.practice.RobotProductionUtil.ONE_DAY_DURATION;

public class Rocket extends Thread {

    List<Crystal> listOfCrystalsOnRocket = new ArrayList<>();
    private final Day day;
    private final Planet planet;
    private final RaceOfMagic race;
    private static Random random = new Random();
    public static final int MIN_NUMBER_OF_CRYSTAL_FOR_ONE_DAY = 2;
    public static final int MAX_NUMBER_OF_CRYSTAL_FOR_ONE_DAY = 5;

    public Rocket(Day day, Planet planet, RaceOfMagic race) {
        this.day = day;
        this.planet = planet;
        this.race = race;
    }

    @Override
    public void run() {
//        synchronized (day) {
            while (day.isNotFinished()) {
                synchronized (race) {
                    if (race.isReachTheTargetValue()) {
                        day.setAsFinished();
                        break;}
                }
                takeCrystals();
                race.carryCrystalToRace(listOfCrystalsOnRocket);
                listOfCrystalsOnRocket.clear();
                synchronized (day) {
                    try {
                        day.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

    }

    private void takeCrystals () {
        int crystalsForThisDay = Math.max(MIN_NUMBER_OF_CRYSTAL_FOR_ONE_DAY, random.nextInt(MAX_NUMBER_OF_CRYSTAL_FOR_ONE_DAY));
        synchronized (planet) {
            for (int i = 0; i < crystalsForThisDay; i++) {
                   Crystal newCrystal = planet.getRandomCrystal();
                   if (newCrystal != null) {
                       listOfCrystalsOnRocket.add(newCrystal);
                       System.out.println("Rocket of race " + race.getName() + " take crystal " + newCrystal);
                   } else {
                       System.out.println("Rocket of race " + race.getName() + " failed to take crystal");
                   }
                }
        }
        }




}
