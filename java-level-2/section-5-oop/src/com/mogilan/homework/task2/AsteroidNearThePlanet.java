package com.mogilan.homework.task2;

public class AsteroidNearThePlanet extends ObjectSurroundingPlanet {
    private long speed;

    public AsteroidNearThePlanet(String name, long mass, long diameter, long distanceToPlanet) {
        super("Астероид", name, mass, diameter, distanceToPlanet);
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }
}
