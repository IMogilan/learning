package com.mogilan.homework.task2;

public class Star extends AstronomicalObject{
    private Planet [] planets;
    private AsteroidNearTheStar [] asteroids;

    public Star(String name, long mass, long diameter) {
        super("Звезда", name, mass, diameter);
    }

    public Planet[] getPlanets() {
        return planets;
    }

    public void setPlanets(Planet ... planets) {
        this.planets = planets;
    }

    public AsteroidNearTheStar[] getAsteroids() {
        return asteroids;
    }

    public void setAsteroids(AsteroidNearTheStar ... asteroids) {
        this.asteroids = asteroids;
    }

}
