package com.mogilan.practice.task2;

public class Circle extends Figure {

    private final Point center;
    private final double radius;

    public Circle (Point center, double radius) throws IllegalArgumentException {
        this.center = center;
        this.radius = radius;
        /* Добавим проверку соответствия фигуры всем необходимым требованиям:
    1) ненулевая площадь, 2) невырожденность.*/
        if ((area() == 0) || isDegenerative()) throw new IllegalArgumentException("Incorrect circle values");
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public Point centroid() {
        return new Point(center.getX(), center.getY());
    }

    @Override
    public boolean isDegenerative () {
        if ((center == null) || (radius <= 0)) return true;
        else return false;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (this == figure) return true;
        if ((figure == null) || (figure.getClass() != this.getClass())) return false;
        Circle otherCircle = (Circle) figure;
        if (center.equalsWithDelta(otherCircle.getCenter()) &&
                deltaCompare(radius, otherCircle.getRadius())) return true;
        else return false;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Круг с центром в следующей точке: " + getCenter() + " и радиусом " + getRadius();
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

}
