package com.mogilan.practice2.task2;

import java.util.Objects;

public class Coupe extends Car {

    private final int maxSpeed;

    public Coupe(String brand, String model, int productYear, String color, int maxSpeed) {
        super("Coupe", brand, model, productYear, color);
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return super.toString() + " {maxSpeed=" + maxSpeed + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Coupe coupe = (Coupe) o;
        return getMaxSpeed() == coupe.getMaxSpeed();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMaxSpeed());
    }
}
