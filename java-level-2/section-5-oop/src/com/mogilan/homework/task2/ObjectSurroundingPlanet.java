package com.mogilan.homework.task2;

import java.math.BigDecimal;

public abstract class ObjectSurroundingPlanet extends AstronomicalObject implements SurroundingPlanet{
    private long distanceToPlanet;
    private long orbitLength;

    public ObjectSurroundingPlanet(String type, String name, long mass, long diameter, long distanceToPlanet) {
        super(type, name, mass, diameter);
        this.distanceToPlanet = distanceToPlanet;
        orbitLength = (long) (Math.PI * Math.pow(distanceToPlanet, 2));
    }

    @Override
    public String toString() {
        return getType() + " " + getName() +
                " (mass= " + getMass() +
                ", diameter= " + getDiameter() + ", " +
                "distanceToPlanet= " + distanceToPlanet +
                ", orbitLength= " + orbitLength +
                ")";
    }

    @Override
    public long getDistanceToPlanet() {
        return distanceToPlanet;
    }

    @Override
    public void setDistanceToPlanet(long distanceToPlanet) {
        this.distanceToPlanet = distanceToPlanet;
        orbitLength = (long) (Math.PI * Math.pow(distanceToPlanet, 2));
    }

    @Override
    public long getOrbitLength() {
        return orbitLength;
    }

    @Override
    public void setOrbitLength(long orbitLength) {
        this.orbitLength = orbitLength;
        distanceToPlanet = (long) (Math.sqrt(orbitLength / Math.PI));
    }
}
