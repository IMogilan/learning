package com.mogilan.practice.task1;

public class Rectangle {
    private Point leftUpperVertex, leftDownVertex, rightDownVertex, rightUpperVertex;

    public Rectangle(Point leftUpperVertex, Point rightDownVertex) {
        this.leftUpperVertex = leftUpperVertex;
        this.rightDownVertex = rightDownVertex;
    }

    public double area () {
        Point leftDownVertex = new Point(leftUpperVertex.getX(), rightDownVertex.getY());
        double sideOneLength = leftDownVertex.distance(leftUpperVertex);
        double sideTwoLength = leftDownVertex.distance(rightDownVertex);
        return sideOneLength * sideTwoLength;
    }

    public double diagonalLength () {
        return leftUpperVertex.distance(rightDownVertex);
    }

}
