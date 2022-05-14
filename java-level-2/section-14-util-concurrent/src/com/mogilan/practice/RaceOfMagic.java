package com.mogilan.practice;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceOfMagic {

    private final String name;
    private AtomicInteger redCrystalsNumber = new AtomicInteger(0);
    private AtomicInteger whiteCrystalNumber = new AtomicInteger(0);
    public static final int TARGET_NUMBER_OF_CRYSTALS = 500;

    public RaceOfMagic(String name) {
        this.name = name;
    }

    public boolean isReachTheTargetValue () {
        return (redCrystalsNumber.get() >= TARGET_NUMBER_OF_CRYSTALS) && (whiteCrystalNumber.get() >= TARGET_NUMBER_OF_CRYSTALS);
    }

   public void incrementRedCrystal() {
       redCrystalsNumber.incrementAndGet();
   }

    public void incrementWhiteCrystal() {
        whiteCrystalNumber.incrementAndGet();
    }

    @Override
    public String toString() {
        return "RaceOfMagic{" +
                "name='" + name + '\'' +
                ", redCrystalsNumber=" + redCrystalsNumber +
                ", whiteCrystalNumber=" + whiteCrystalNumber +
                '}';
    }

    public String getName() {
        return name;
    }

    public void printNumberOfCrystals(int currentDayNumber) {
        System.out.println("Race of Magic " + name + " on the " + currentDayNumber + " day has at all:\n" +
                "Red crystals = " + redCrystalsNumber.get() + " crystals;\n" +
                "White crystals = " + whiteCrystalNumber.get() + " crystals;");
    }
}
