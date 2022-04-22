package com.mogilan.practice2.task2;

import java.util.Objects;

public class PickupTruck extends Car {

    private final int trunkVolume;

    public PickupTruck(String brand, String model, int productYear, String color, int trunkVolume) {
        super("PickupTruck", brand, model, productYear, color);
        this.trunkVolume = trunkVolume;
    }

    public int getTrunkVolume() {
        return trunkVolume;
    }

    @Override
    public String toString() {
        return super.toString() + " {trunkVolume=" + trunkVolume + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PickupTruck that = (PickupTruck) o;
        return getTrunkVolume() == that.getTrunkVolume();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTrunkVolume());
    }
}
