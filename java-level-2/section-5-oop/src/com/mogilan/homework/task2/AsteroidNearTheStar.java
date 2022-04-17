package com.mogilan.homework.task2;

public class AsteroidNearTheStar extends ObjectSurroundingStar{
    private long speed;

    public AsteroidNearTheStar(String name, long mass, long diameter, long distanceToStar) {
        super("Астероид", name, mass, diameter, distanceToStar);
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }
}
