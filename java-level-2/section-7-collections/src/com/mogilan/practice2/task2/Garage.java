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

    public int numberOfCarsOfSuchType (String type) {
        int result = 0;
        for (Map.Entry<Car, Integer> entry : cars.entrySet()) {
            if (entry.getKey().getType().equals(type)) result += entry.getValue();
        }
        return result;
    }

    public int numberOfCarsOfSuchBrand (String brand) {
        int result = 0;
        for (Map.Entry<Car, Integer> entry : cars.entrySet()) {
            if (entry.getKey().getBrand().equals(brand)) result += entry.getValue();
        }
        return result;
    }

    public int numberOfCarsOfSuchModel (String model) {
        int result = 0;
        for (Map.Entry<Car, Integer> entry : cars.entrySet()) {
            if (entry.getKey().getModel().equals(model)) result += entry.getValue();
        }
        return result;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "cars=" + cars +
                '}';
    }
}
