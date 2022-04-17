package com.mogilan.practice.task2;

import static com.mogilan.practice.task2.LineSegment.*;

public class Quadrilateral extends Figure {

    private final Point vertexA, vertexB, vertexC, vertexD;
    private final Point [] vertices;
    protected class Segments {
        private final LineSegment segmentAB = new LineSegment(vertexA, vertexB);
        private final LineSegment segmentBC = new LineSegment(vertexB, vertexC);
        private final LineSegment segmentCD = new LineSegment(vertexC, vertexD);
        private final LineSegment segmentDA = new LineSegment(vertexD, vertexA);

        public LineSegment getSegmentAB() { return segmentAB; }
        public LineSegment getSegmentBC() { return segmentBC; }
        public LineSegment getSegmentCD() { return segmentCD; }
        public LineSegment getSegmentDA() {return segmentDA; }

        @Override
        public String toString() {
            return "Четырехугольник состоит из следующих сегментов:\n" +
                    getSegmentAB() + "\n" +
                    getSegmentBC() + "\n" +
                    getSegmentCD() + "\n" +
                    getSegmentDA();
        }
    }

    public Quadrilateral(Point vertexA, Point vertexB, Point vertexC, Point vertexD) throws IllegalArgumentException {
        if (vertexA == null || vertexB == null || vertexC == null || vertexD == null) throw new IllegalArgumentException("Incorrect triangle vertex values"); // Сначала быстро проверяем, не равна ли какая-то вершина null
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;
        this.vertexD = vertexD;
         /* Добавим проверку соответствия фигуры всем необходимым требованиям:
    1) ненулевая площадь, 2) невырожденность и 3) выпуклость. Выпуклость
    проверяется методами isConvex() и isPlain())*/
        if ((area() == 0) || isDegenerative() || !isConvex() || !isPlain()) throw new IllegalArgumentException("Incorrect quadrilateral vertex values");
        vertices = new Point[] {vertexA, vertexB, vertexC, vertexD};
    }

    @Override
    public double area() {
        // Разделим по диагонали "ca" (связывает вершины "a" и "с") наш выпуклый четырехугольник на 2 треугольника (с вершинами "abс" и "adc")
        Triangle abc = new Triangle (vertexA, vertexB, vertexC);
        Triangle adc = new Triangle (vertexA, vertexD, vertexC);
        return (abc.area() + adc.area()); // Возврат суммы площадей двух треугольников, образующих наш четырехугольник
    }

    /*Ниже в комментариях пример реализации альтернативного метода для поиска площади четырехугольника
    без поиска площадей треугольников. Поиск площади осуществляется по формуле
    16S^2 = 4d1^2 * d2^2 - (b^2 + d^2 -a^2 - c^2),
    где "d1" и "d2" - длины диагоналей, "a" "b" "c" "d" - сторонычетырехугольника, символ каррет "^" - квадратная степень

    public double areaThirdMethod() {
    double d1 = distanceBetweenPoints(a, c);
    double d2 = distanceBetweenPoints(b, d);
    double ab = distanceBetweenPoints(a, b);
    double bc = distanceBetweenPoints(b, c);
    double cd = distanceBetweenPoints(c, d);
    double da = distanceBetweenPoints(d, a);
    return Math.sqrt ((4 * pow(d1, 2) * pow(d2, 2) - (pow(bc, 2) + pow(da, 2) - pow(ab, 2) - pow(cd, 2))) / 16);
}*/

    /**Метод осуществляет поиск центроида четырехугольника.
     * Сначала находятся центроиды 4х треугольников (abc, bcd, cda, dab), на которые по диагонали делится наш 4-угольник.
     * Затем находится точка пересечения 2-х прямых, которые проходят через 2 из указанных выше центроида треугольника
     * (одна прямая - через центроиды треугольников abc и cda, и вторая прямая - через центроиды треугольников bcd и dab).
     * Центроид четырехугольника - точка пересечения данных прямых. */
    @Override
    public Point centroid() {
        Point abcCentroid = (new Triangle(vertexA, vertexB, vertexC)).centroid();
        Point cdaCentroid = (new Triangle(vertexC, vertexD, vertexA)).centroid();
        Line lineOne = new Line(abcCentroid, cdaCentroid);
        Point bcdCentroid = (new Triangle(vertexB, vertexC, vertexD)).centroid();
        Point dabCentroid = (new Triangle(vertexD, vertexA, vertexB)).centroid();
        Line lineTwo = new Line(bcdCentroid, dabCentroid);
        return Line.linesIntersectionPoint(lineOne, lineTwo);
    }

    /**Метод осуществляет проверку, является ли четырехугольник вырожденным.
     * Невырожденный выпуклый четырехугольник делится на четыре невырожденных треугольника своими
     * диагоналями. Поэтому метод делит четырехугольник на 4 треугольника и проверяет каждый из треугольников
     * на вырожденность*/
    @Override
    final public boolean isDegenerative() {
        if (vertexA == null || vertexB == null || vertexC == null || vertexD == null) return true;
        Triangle abc = new Triangle(vertexA, vertexB, vertexC);
        Triangle bcd = new Triangle(vertexB, vertexC, vertexD);
        Triangle cda = new Triangle(vertexC, vertexD, vertexA);
        Triangle dab = new Triangle(vertexD, vertexA, vertexB);
        return abc.isDegenerative() || bcd.isDegenerative()
                || cda.isDegenerative() || dab.isDegenerative();
    }

    /**Метод проверяет, является ли четырехугольник выпуклым.
     * В методе сравнивается сумма площадей треугольников с вершинами "abс" "adc" с суммой площадей
     * треугольников с вершинами "abd" "bdc". Если четырехугольник выпуклый, то суммы площадей таких
     * пар треугольников (образованных путем деления четырехугольника по диагоналям на треугольники)
     * должны быть равны. */
    public boolean isConvex () {
        Triangle abc = new Triangle (vertexA, vertexB, vertexC);
        Triangle adc = new Triangle (vertexA, vertexD, vertexC);
        double areaOnePair = abc.area() + adc.area();
        Triangle abd = new Triangle (vertexA, vertexB, vertexD);
        Triangle bdc = new Triangle (vertexB, vertexD, vertexC);
        double areaSecondPair = abd.area() + bdc.area();
        return deltaCompare(areaOnePair, areaSecondPair);
    }

    /**Метод проверяет, является ли четырехугольник простым.
     * В методе проверяется, не пересекаются ли между собой ПРОТИВОПОЛОЖНЫЕ ОТРЕЗКИ ("ab" и "cd", а также
     * отрезки "bc" и "ad") рассматриваемого четырехугольника. Если любая из этих пар отрезков пересекается,
     * то возвращается false */
    public boolean isPlain () {
        LineSegment ab = new LineSegment (vertexA, vertexB);
        LineSegment cd = new LineSegment (vertexC, vertexD);
        LineSegment bc = new LineSegment (vertexB, vertexC);
        LineSegment ad = new LineSegment (vertexA, vertexD);
        return !segmentsIntersection(ab, cd) && !segmentsIntersection(bc, ad);
    }

    public boolean isRectangle () {
        boolean result = true;
        Triangle abc = new Triangle(vertexA, vertexB, vertexC);
        LineSegment diagonalAC = new LineSegment(vertexA, vertexC);
        if (!isTrianglesHypotenuseIsDiagonalOfQuadrilateral(abc, diagonalAC)) result = false;

        Triangle bcd = new Triangle(vertexB, vertexC, vertexD);
        LineSegment diagonalBD = new LineSegment(vertexB, vertexD);
        if (!isTrianglesHypotenuseIsDiagonalOfQuadrilateral(bcd, diagonalBD)) result = false;

        Triangle cda = new Triangle(vertexC, vertexD, vertexA);
        LineSegment diagonalCA = new LineSegment(vertexC, vertexA);
        if (!isTrianglesHypotenuseIsDiagonalOfQuadrilateral(cda, diagonalCA)) result = false;

        Triangle dab = new Triangle(vertexD, vertexA, vertexB);
        LineSegment diagonalDB = new LineSegment(vertexD, vertexB);
        if (!isTrianglesHypotenuseIsDiagonalOfQuadrilateral(dab, diagonalDB)) result = false;
        return result;
    }

    private boolean isTrianglesHypotenuseIsDiagonalOfQuadrilateral (Triangle triangle, LineSegment diagonalOfQuadrilateral) {
        if (triangle.isRightTriangle()) {
            RightTriangle rightTriangle = new RightTriangle(triangle);
            return rightTriangle.getHypotenuse().equalsWithDelta(diagonalOfQuadrilateral);
        } else return false;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (this == figure) return true;
        if ((figure == null) || (figure.getClass() != this.getClass())) return false;
        Quadrilateral otherQuadrilateral = (Quadrilateral) figure;
        if (otherQuadrilateral.isDegenerative()) return false;
        Point [] verticesOfOtherQuadrilateral = {otherQuadrilateral.getVertexA(), otherQuadrilateral.getVertexB(), otherQuadrilateral.getVertexC(), otherQuadrilateral.getVertexD()};
        return checkVertices(vertices, verticesOfOtherQuadrilateral);
    }

    @Override
    public double perimeter() {
        Segments s = new Segments();
        return  s.getSegmentAB().length() + s.getSegmentBC().length() +
                s.getSegmentCD().length() + s.getSegmentDA().length();
    }

    @Override
    public String toString() {
        return "Четырехугольник со следующими вершинами:\n" +
                "точка один: " + getVertexA() + "\n" +
                "точка два: " + getVertexB() + "\n" +
                "точка три: " + getVertexC() + "\n" +
                "точка четыре: " + getVertexD();
    }

    public Point getVertexA() {return vertexA;}

    public Point getVertexB() {return vertexB;}

    public Point getVertexC() {return vertexC;}

    public Point getVertexD() {return vertexD;}

}
