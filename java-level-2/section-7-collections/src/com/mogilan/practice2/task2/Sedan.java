package com.mogilan.practice2.task2;

import java.util.Objects;

public class Sedan extends Car {

    private final int gasTankVolume;

    public Sedan(String brand, String model, int productYear, String color, int gasTankVolume) {
        super("Sedan", brand, model, productYear, color);
        this.gasTankVolume = gasTankVolume;
    }

    public int getGasTankVolume() {
        return gasTankVolume;
    }

    @Override
    public String toString() {
        return super.toString() + " {gasTankVolume=" + gasTankVolume + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Sedan sedan = (Sedan) o;
        return getGasTankVolume() == sedan.getGasTankVolume();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getGasTankVolume());
    }
}
