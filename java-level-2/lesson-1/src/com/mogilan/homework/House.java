package com.mogilan.homework;

import java.util.Scanner;

public class House extends Accommodation{

    private Floor [] floors;

    public House() {
        super("House");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of floors in the " + getAccommodationType() + " N" + getNumber() + ": ");
        this.floors = new Floor [scanner.nextInt()];
        floors[0] = new Floor(1);
        int lastFlatNumber = floors[0].getLastFlatNumber() + 1;
        for (int i = 1; i < floors.length; i++) {
            floors[i] = new Floor(i + 1, lastFlatNumber++);
        }
    }

    public House(int houseNumber) {
        super("House", houseNumber);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of floors in the " + getAccommodationType() + " N" + getNumber() + ": ");
        this.floors = new Floor [scanner.nextInt()];
        floors[0] = new Floor(1);
        int lastFlatNumber = floors[0].getLastFlatNumber() + 1;
        for (int i = 1; i < floors.length; i++) {
            floors[i] = new Floor(i + 1, lastFlatNumber++);
        }
    }

    public Floor[] getFloors() {
        return floors;
    }

    @Override
    public void print () {
        super.print();
        System.out.println(floors.length + " floors");
    }


}
