package com.mogilan.homework;

import java.util.List;

public class RaceOfMagic {

    private final String name;
    private int redCrystalsNumber;
    private int whiteCrystalNumber;
    public static final int TARGET_NUMBER_OF_CRYSTALS = 500;

    public RaceOfMagic(String name) {
        this.name = name;
    }

    public void carryCrystalToRace(List<Crystal> crystals) {
        if (!crystals.isEmpty()) {
            for (Crystal crystal : crystals) {
                if (crystal == Crystal.RED) {
                    redCrystalsNumber++;
                } else {
                    whiteCrystalNumber++;
                }
                System.out.println("Race of magic " + name + " get crystal " + crystal);
            }
        } else System.out.println("Rocket of race of magic "  + name + " didn't take any crystals");
    }

    public boolean isReachTheTargetValue () {
        return (redCrystalsNumber >= TARGET_NUMBER_OF_CRYSTALS) && (whiteCrystalNumber >= TARGET_NUMBER_OF_CRYSTALS);
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
}
