package com.mogilan.practice.task2;

public interface AreaDetermining {

    double area ();

    default double compareArea (Figure other) {
        return this.area() - other.area();
    }
}
