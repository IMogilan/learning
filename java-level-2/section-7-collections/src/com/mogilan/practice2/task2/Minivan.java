package com.mogilan.practice2.task2;

import java.util.Objects;

public class Minivan extends Car {

    private final int maxNumberOfPassengers;

    public Minivan(String brand, String model, int productYear, String color, int maxNumberOfPassengers) {
        super("Minivan", brand, model, productYear, color);
        this.maxNumberOfPassengers = maxNumberOfPassengers;
    }

    public int getMaxNumberOfPassengers() {
        return maxNumberOfPassengers;
    }

    @Override
    public String toString() {
        return super.toString() + " {maxNumberOfPassengers=" + maxNumberOfPassengers + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Minivan minivan = (Minivan) o;
        return getMaxNumberOfPassengers() == minivan.getMaxNumberOfPassengers();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMaxNumberOfPassengers());
    }
}
