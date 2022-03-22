package com.mogilan.homework;

import java.util.Scanner;

public class Flat extends Accommodation {

    private Room [] rooms;

    public Flat() {
        super("Flat");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of rooms in the " + getAccommodationType() + " N " + getNumber() + ": ");
        this.rooms = new Room[scanner.nextInt()];
        super.isCorrectValue(rooms.length);
        setRooms();
    }

    public Flat(int flatNumber) {
        super("Flat", flatNumber);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of rooms in the " + getAccommodationType() + " N " + getNumber() + ": ");
        this.rooms = new Room[scanner.nextInt()];
        super.isCorrectValue(rooms.length);
        setRooms();
    }

    public Room[] getRooms() {
        return rooms;
    }

    @Override
    public void print () {
        super.print();
        System.out.print(rooms.length + " rooms. ");
    }

    public boolean isCorrectValue (int value, int compareValue) {
        if ( (value < 0) || (value > compareValue)) System.out.println("Incorrect value!");
        return (value > 0) && (value >= compareValue);
    }

    final private void setRooms () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter how many walk-through rooms in " + getAccommodationType() + " N " + getNumber() + ": ");
        int numberOfWalkThroughRooms = scanner.nextInt();
        isCorrectValue(numberOfWalkThroughRooms, rooms.length);
        int i = 0;
        for (; i < numberOfWalkThroughRooms; i++) {
            rooms[i] = new Room(true);
        }
        for (; i < rooms.length; i++) {
            rooms[i] = new Room(false);
        }
    }
}
