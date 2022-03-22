package com.mogilan.homework;

import java.util.Scanner;

public abstract class Accommodation {

    private String accommodationType;
    private int number;

    public Accommodation(String accommodationType) {
        this.accommodationType = accommodationType;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the \"" + accommodationType + "\": ");
        this.number = scanner.nextInt();
    }

    public Accommodation(String accommodationType, int number) {
        this.accommodationType = accommodationType;
        this.number = number;
    }

    public void setAccommodationType(String accommodationType) {
        this.accommodationType = accommodationType;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAccommodationType() {
        return accommodationType;
    }

    public int getNumber() {
        return number;
    }

    public void print () {
        System.out.print(getAccommodationType() + " number " + getNumber() + ". This " + getAccommodationType() + " has ");
    }

    public boolean isCorrectValue (int value) {
        if (value <= 0) System.out.println("Incorrect value!");
        return value > 0;
    }
}
