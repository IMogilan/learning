package com.mogilan.practice.task2;

public interface PerimeterDetermining {

    double perimeter ();

    default double comparePerimeter (Figure other) {
        return this.perimeter() - other.perimeter();
    }
}
