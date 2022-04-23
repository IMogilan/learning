package com.mogilan.practice2.task2;

public class GarageRunner {
    public static void main(String[] args) {

        Car audiA61 = new Sedan("Audi", "A6", 2020, "Black", 50);
        Car audiA62 = new Sedan("Audi", "A6", 2020, "Silver", 50);
        Car audiA63 = new Sedan("Audi", "A6", 2020, "Black", 60);
        Car audiA64 = new Sedan("Audi", "A6", 2020, "Black", 50);
        Car audiR81 = new Coupe("Audi", "R8", 2020, "Black", 300);
        Car audiR82 = new Coupe("Audi", "R8", 2020, "Silver", 300);
        Car audiR83 = new Coupe("Audi", "R8", 2020, "Black", 310);
        Car audiR84 = new Coupe("Audi", "R8", 2020, "Black", 300);
        Car Toyota1 = new PickupTruck("Toyota", "Tundra", 2020, "Black", 800);
        Car Toyota2 = new PickupTruck("Toyota", "Tundra", 2020, "Silver", 800);
        Car VW1 = new Minivan("VW", "Multivan", 2020, "Black", 7);
        Car VW2 = new Minivan("VW", "Multivan", 2020, "Silver", 7);

        Garage garage = new Garage();

        garage.parking(audiA61);
        garage.parking(audiA62);
        garage.parking(audiA63);
        garage.parking(audiA64);
        System.out.println(garage);
        System.out.println(garage.numberOfSuchCars(audiA61));

        garage.parking(audiR81);
        garage.parking(audiR82);
        garage.parking(audiR83);
        garage.parking(audiR84);
        System.out.println(garage);
        System.out.println(garage.numberOfSuchCars(audiR84));

        garage.parking(Toyota1);
        garage.parking(Toyota2);
        garage.parking(VW1);
        garage.parking(VW2);
        System.out.println(garage);
        System.out.println(garage.numberOfSuchCars(VW1));

        garage.exitTheParkingLot(audiA61);
        System.out.println(garage.numberOfSuchCars(audiA61));
        garage.exitTheParkingLot(audiA61);
        System.out.println(garage.numberOfSuchCars(audiA61));
        garage.exitTheParkingLot(audiA61);
        System.out.println(garage.numberOfSuchCars(audiA61));
        garage.exitTheParkingLot(audiA61);
        System.out.println(garage.numberOfSuchCars(audiA61));

        System.out.println(garage.numberOfCarsOfSuchType("Minivan"));
        System.out.println(garage.numberOfCarsOfSuchModel("Tundra"));
        System.out.println(garage.numberOfCarsOfSuchBrand("Audi"));

    }
}
