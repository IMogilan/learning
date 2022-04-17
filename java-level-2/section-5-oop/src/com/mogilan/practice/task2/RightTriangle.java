package com.mogilan.practice.task2;

import java.util.Arrays;

import static java.lang.Math.pow;

public class RightTriangle extends Triangle {

    public RightTriangle(Point vertexA, Point vertexB, Point vertexC) throws IllegalArgumentException {
        super(vertexA, vertexB, vertexC);
        if (!isRightTriangle()) throw new IllegalArgumentException("This triangle is not a right triangle");
    }

    public RightTriangle(Triangle triangle) throws IllegalArgumentException {
        super(triangle.getVertexA(), triangle.getVertexB(), triangle.getVertexC());
        if (!isRightTriangle()) throw new IllegalArgumentException("This triangle is not a right triangle");
    }
    public LineSegment getHypotenuse () {
        LineSegment [] segments = new Segments().getSegmentOtTriangle();
        int indexOfLongestSegment = 0;
        double maxValue = segments[0].length();
        for (int i = 1; i < segments.length; i++) {
            if (segments[i].length() > maxValue) {
                indexOfLongestSegment = i;
                maxValue = segments[i].length();
            }
        }
        return segments[indexOfLongestSegment];
    }

    @Override
    public String toString() {
        return "Прямоугольный треугольник со следующими вершинами:\n" +
                "точка один: " + getVertexA() + "\n" +
                "точка два: " + getVertexB() + "\n" +
                "точка три: " + getVertexC() + "\n" +
                "Гипотенуза:  " + getHypotenuse();
    }
}
