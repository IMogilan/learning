package com.mogilan.homework.task2;

import java.math.BigDecimal;

public abstract class ObjectSurroundingStar extends AstronomicalObject implements SurroundingStar{
    private long distanceToStar;
    private long orbitLength;

    public ObjectSurroundingStar(String type, String name, long mass, long diameter, long distanceToStar) {
        super(type, name, mass, diameter);
        this.distanceToStar = distanceToStar;
        orbitLength = (long) (Math.PI * Math.pow(distanceToStar, 2));
    }

    @Override
    public String toString() {
        return getType() + " " + getName() +
                " (mass= " + getMass() +
                ", diameter= " + getDiameter() + ", " +
                "distanceToStar= " + getDistanceToStar() +
                ", orbitLength= " + getOrbitLength() +
                ")";
    }

    @Override
    public long getDistanceToStar() {
        return distanceToStar;
    }

    @Override
    public void setDistanceToStar(long distanceToStar) {
        this.distanceToStar = distanceToStar;
        orbitLength = (long) (Math.PI * Math.pow(distanceToStar, 2));
    }

    @Override
    public long getOrbitLength() {
        return orbitLength;
    }

    @Override
    public void setOrbitLength(long orbitLength) {
        this.orbitLength = orbitLength;
        distanceToStar = (long) (Math.sqrt(orbitLength / Math.PI));
    }

}
