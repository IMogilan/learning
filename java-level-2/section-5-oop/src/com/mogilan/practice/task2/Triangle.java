package com.mogilan.practice.task2;

import java.util.Arrays;
import static java.lang.Math.pow;

public class Triangle extends Figure {

    private final Point vertexA, vertexB, vertexC;
    private final Point [] vertices;
    protected class Segments {
        private final LineSegment segmentAB = new LineSegment(vertexA, vertexB);
        private final LineSegment segmentBC = new LineSegment(vertexB, vertexC);
        private final LineSegment segmentCA = new LineSegment(vertexC, vertexA);
        private final LineSegment [] segmentOtTriangle = {segmentAB, segmentBC, segmentCA};

        public LineSegment getSegmentAB() { return segmentAB;}
        public LineSegment getSegmentBC() { return segmentBC; }
        public LineSegment getSegmentCA() { return segmentCA; }
        public LineSegment[] getSegmentOtTriangle() { return segmentOtTriangle;}

        @Override
        public String toString() {
            return "Треугольник состоит из следующих сегментов:\n" +
                    getSegmentAB() + "\n" +
                    getSegmentBC() + "\n" +
                    getSegmentCA();
        }
    }

    public Triangle (Point vertexA, Point vertexB, Point vertexC) throws IllegalArgumentException {
        if (vertexA == null || vertexB == null || vertexC == null) throw new IllegalArgumentException("Incorrect triangle vertex values");
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;
        /* Добавим проверку соответствия фигуры всем необходимым требованиям:
    1) ненулевая площадь, 2) невырожденность. */
        if ((area() == 0) || isDegenerative()) throw new IllegalArgumentException("Incorrect triangle vertex values");
        vertices = new Point[] {vertexA, vertexB, vertexC};
    }

    @Override
    public double area() {
        // Поиск площади по формуле Герона
        LineSegment segmentAB = new LineSegment(vertexA, vertexB);
        LineSegment segmentBC = new LineSegment(vertexB, vertexC);
        LineSegment segmentCA = new LineSegment(vertexC, vertexA);
        double s = (segmentAB.length() + segmentBC.length() + segmentCA.length()) / 2; // Полупериметр
        return Math.sqrt(s * (s - segmentAB.length()) * (s - segmentBC.length()) * (s - segmentCA.length())); // Площадь
    }

    @Override
    public Point centroid() {
        return new Point(((vertexA.getX() + vertexB.getX() + vertexC.getX()) / 3),((vertexA.getY() + vertexB.getY() + vertexC.getY()) / 3));
    }

    @Override
    final public boolean isDegenerative () {
        if (vertexA == null || vertexB == null || vertexC == null) return true;
        LineSegment segmentBC = new LineSegment(vertexB, vertexC);
        return vertexA.isBelongToTheLine(segmentBC);
        //        Второй вариант реализации этого же метода (без использования методов других классов):
//        double x1 = vertexA.getX(), y1 = vertexA.getY();
//        double x2 = vertexB.getX(), y2 = vertexB.getY();
//        double x = vertexC.getX(), y = vertexC.getY();
//        /* Используя формулу прямой, проходящей через 2 точки ("a" и "b"):
//        (y1 - y2) * x + (x2 - x1) * y + ( x1 * y2 - x2 * y1) = 0,
//        строим уравнение прямой, проходящей через точки "a" и "b" и проверяем:
//        - не равны ли ОДНОВРЕМЕННО коэффициенты данного уравнения (y1 - y2) и (x2 - x1)  нулю. Если равны, то 2 точки совпадают и треугольник вырожденный
//        - находится ли на этой прямой точка "c", подставив в уравнение соответствующие значения "x" и "y" данной точки;*/
//        if ((y1 - y2 == 0) && (x2 - x1 == 0)) return true;
//        else if (((y1 - y2) * x + (x2 - x1) * y + ( x1 * y2 - x2 * y1)) == 0) return true;
//        else return false;
    }

    public boolean isRightTriangle () {
        double [] segmentsLengths = new double[3];
        int i = 0;
        for (LineSegment segment : new Segments().getSegmentOtTriangle()) segmentsLengths [i++] = segment.length();
        Arrays.sort(segmentsLengths);
        double hypotenuseLength = segmentsLengths[2], cathetusOneLength = segmentsLengths[1], cathetusTwoLength = segmentsLengths[0];
        return deltaCompare(pow(hypotenuseLength, 2), pow(cathetusOneLength, 2) + pow(cathetusTwoLength, 2));
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (this == figure) return true;
        if ((figure == null) || (figure.getClass() != this.getClass())) return false;
        Triangle otherTriangle = (Triangle) figure;
        if (otherTriangle.isDegenerative()) return false;
        Point [] verticesOfOtherTriangle = {otherTriangle.getVertexA(), otherTriangle.getVertexB(), otherTriangle.getVertexC()};
        return checkVertices(vertices, verticesOfOtherTriangle);
    }

    @Override
    public double perimeter() {
//        LineSegment segmentAB = new LineSegment(vertexA, vertexB);
//        LineSegment segmentBC = new LineSegment(vertexB, vertexC);
//        LineSegment segmentCA = new LineSegment(vertexC, vertexA);
        Segments s = new Segments();
        return s.getSegmentAB().length() + s.getSegmentBC().length() + s.getSegmentCA().length();
    }

    @Override
    public String toString() {
        return "Треугольник со следующими вершинами:\n" +
                "точка один: " + getVertexA() + "\n" +
                "точка два: " + getVertexB() + "\n" +
                "точка три: " + getVertexC();
    }

    public Point getVertexA() {return vertexA;}

    public Point getVertexB() {return vertexB;}

    public Point getVertexC() {return vertexC;}

}
