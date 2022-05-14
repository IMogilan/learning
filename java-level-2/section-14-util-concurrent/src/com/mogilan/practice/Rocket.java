package com.mogilan.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.mogilan.practice.Day.ONE_DAY_DURATION;

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
        while (day.isNotFinished()) {
            lockDay();
            if (race.isReachTheTargetValue()) {
                day.setAsFinished();
                unlockDay();
                break;
            }
            takeCrystals();
            carryCrystalToRace();
            race.printNumberOfCrystals(day.getCurrentDayNumber() - 1);
            unlockDay();
            try {
                Thread.sleep(ONE_DAY_DURATION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void takeCrystals () {
        int crystalsForThisDay = Math.max(MIN_NUMBER_OF_CRYSTAL_FOR_ONE_DAY, random.nextInt(MAX_NUMBER_OF_CRYSTAL_FOR_ONE_DAY));
        for (int i = 0; i < crystalsForThisDay; i++) {
            Crystal newCrystal = planet.getRandomCrystal();
            if (newCrystal != null) {
                listOfCrystalsOnRocket.add(newCrystal);
                System.out.println("Rocket of race " + race.getName() + " take crystal " + newCrystal);
            } else {
                System.out.println("Rocket of race " + race.getName() + " failed to take any crystal");
            }
        }
    }

    public void carryCrystalToRace() {
        if (!listOfCrystalsOnRocket.isEmpty()) {
            for (Crystal crystal : listOfCrystalsOnRocket) {
                if (crystal == Crystal.RED) {
                    race.incrementRedCrystal();
                } else {
                   race.incrementWhiteCrystal();
                }
                System.out.println("Race of magic " + race.getName() + " get crystal " + crystal);
            }
            listOfCrystalsOnRocket.clear();
        } else System.out.println("Rocket of race of magic "  + race.getName() + " didn't take any crystals");
    }

    public void lockDay () {
        boolean isLocked = false;
        while (!isLocked) {
            isLocked = day.getDayLock().tryLock();
        }
    }

    public void unlockDay () {
        day.getDayLock().unlock();
    }



}
