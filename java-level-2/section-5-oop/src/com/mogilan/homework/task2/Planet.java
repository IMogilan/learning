package com.mogilan.homework.task2;

public class Planet extends ObjectSurroundingStar{
    private NaturalSatellite [] naturalSatellites;
    private AsteroidNearThePlanet [] asteroids;

    public Planet(String name, long mass, long diameter, long distanceToStar) {
        super("Планета", name, mass, diameter, distanceToStar);
    }

    public NaturalSatellite[] getNaturalSatellites() {
        return naturalSatellites;
    }

    public void setNaturalSatellites(NaturalSatellite ... naturalSatellites) {
        this.naturalSatellites = naturalSatellites;
    }

    public AsteroidNearThePlanet[] getAsteroids() {
        return asteroids;
    }

    public void setAsteroids(AsteroidNearThePlanet ... asteroids) {
        this.asteroids = asteroids;
    }
}
