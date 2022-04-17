package com.mogilan.homework.task2;

public abstract class AstronomicalObject implements Massive {
    private String type;
    private String name;
    private long mass;
    private long diameter;

    public AstronomicalObject(String type, String name, long mass, long diameter) {
        this.type = type;
        this.name = name;
        this.mass = mass;
        this.diameter = diameter;
    }
    @Override
    public String toString() {
        return "AstronomicalObject{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", mass=" + mass +
                ", diameter=" + diameter +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public long getMass() {
        return mass;
    }

    public void setMass(long mass) {
        this.mass = mass;
    }

    public long getDiameter() {
        return diameter;
    }

    public void setDiameter(long diameter) {
        this.diameter = diameter;
    }
}
