package com.mogilan.practice2.task2;

import java.util.HashMap;
import java.util.Map;

public class Garage {

    private Map <Car, Integer> cars;

    public Garage() {
        this.cars = new HashMap<>();
    }

    public Garage(Map<Car, Integer> cars) {
        this.cars = cars;
    }

    public void parking (Car newCar) {
        Integer currentNumberOfSuchCars = cars.get(newCar);
        Integer newNumberOfSuchCars =
                currentNumberOfSuchCars == null ?  1 : currentNumberOfSuchCars + 1;
        cars.put(newCar, newNumberOfSuchCars);
    }

    public void exitTheParkingLot ( Car leavingCar) {
        Integer currentNumberOfSuchCars = cars.get(leavingCar);
        if (currentNumberOfSuchCars != null) {
            Integer newNumberOfSuchCars = currentNumberOfSuchCars - 1;
            if (newNumberOfSuchCars != 0) cars.put(leavingCar, newNumberOfSuchCars);
            else cars.remove(leavingCar);
        }
    }

    public int numberOfSuchCars (Car car) {
        Integer result = cars.get(car);
        if (result != null) return result;
        else return 0;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "cars=" + cars +
                '}';
    }
}
