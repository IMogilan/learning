package com.mogilan.practice2.task2;

import java.util.Objects;

public abstract class Car {

    private final String type;
    private final String brand;
    private final String model;
    private final int productYear;
    private String color;

    public Car(String type, String brand, String model, int productYear, String color) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.productYear = productYear;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getProductYear() {
        return productYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", productYear=" + productYear +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getProductYear() == car.getProductYear() && Objects.equals(getType(), car.getType()) && Objects.equals(getBrand(), car.getBrand()) && Objects.equals(getModel(), car.getModel()) && Objects.equals(getColor(), car.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getBrand(), getModel(), getProductYear(), getColor());
    }
}
