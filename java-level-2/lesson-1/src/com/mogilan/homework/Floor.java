package com.mogilan.homework;

import java.util.Scanner;

public class Floor extends Accommodation {

    private Flat [] flats;

    public Floor (int flourNumber) {
        super("Floor", flourNumber);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Describing of the Flour №"+ flourNumber + ".\nEnter the amount of flats on the " + getAccommodationType() + " N" + getNumber() + ": ");
        this.flats = new Flat[scanner.nextInt()];
        System.out.print("Describing of the 1st flat on the Flour №"+ flourNumber + ". ");
        flats[0] = new Flat();
        int currentNumberOfFlat = flats[0].getNumber() + 1;
        for (int i = 1; i < flats.length; i++) {
            System.out.println("Describing of the Flat N" + currentNumberOfFlat + " on the Flour №" + flourNumber);
            flats[i] = new Flat(currentNumberOfFlat++);
        }
    }

    public Floor (int flourNumber, int lastFlatNumber) {
        super("Floor", flourNumber);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Describing of the Flour №"+ flourNumber + ".\nEnter the amount of flats on the " + getAccommodationType() + " N" + getNumber() + ": ");
        this.flats = new Flat[scanner.nextInt()];
        int currentNumberOfFlat = lastFlatNumber;
        for (int i = 0; i < flats.length; i++) {
            System.out.println("Describing of the Flat N" + currentNumberOfFlat + " on the Flour №" + flourNumber);
            flats[i] = new Flat(currentNumberOfFlat++);
        }
    }

    public Flat[] getFlats() {
        return flats;
    }

    @Override
    public void print () {
        super.print();
        System.out.println(flats.length + " flats. ");
    }

    public int getLastFlatNumber () {
        return flats[flats.length - 1].getNumber();
    }
}
