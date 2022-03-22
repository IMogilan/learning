package com.mogilan.homework;

public class Room {

    private String accommodationType = "Room";
    private boolean isWalkThrough;

    public Room(boolean isPassageRoom) {
        this.isWalkThrough = isPassageRoom;
    }

    public String getAccommodationType() {
        return accommodationType;
    }

    public boolean isWalkThrough() {
        return isWalkThrough;
    }

    public void print () {
        System.out.print(isWalkThrough ? " Walk-through room. ": " Not a walk-through room.");
    }
}
