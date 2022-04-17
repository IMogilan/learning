package com.mogilan.practice.task2;

public class LineSegment extends Line {

    public LineSegment(Point pointOne, Point pointTwo) {
        super(pointOne, pointTwo);
    }

    /** Метод проверяет, пересекаются ли 2 отрезка.
    * Сначала находится точка пересечения (если она имеется) двух прямых, проходящих через точки, которые соединяют данные отрезки.
    * Если есть только одна точка пересечения (прямые не совпадают и не параллельны), то выполняется
     * проверка, находится ли эта точка пересечения внутри каждого из отрезков*/
    public static boolean segmentsIntersection (LineSegment segmentOne, LineSegment segmentTwo) {
        Point intersectionPoint = linesIntersectionPoint(segmentOne, segmentTwo);
        if (intersectionPoint != null) return intersectionPoint.isBelongToTheSegment(segmentOne) && intersectionPoint.isBelongToTheSegment(segmentTwo);
        else return false;
    }

    public double length() {
        return getPointOne().distance(getPointTwo());
    }

    @Override
    public String toString() {
        return "Отрезок, соединяющий следующие 2 точки:\n" +
                "точка один: " + getPointOne() + "\n" +
                "точка два: " + getPointTwo();}

    public boolean equalsWithDelta (LineSegment otherLineSegment) {
        return this.getPointOne().equalsWithDelta(otherLineSegment.getPointOne()) && this.getPointTwo().equalsWithDelta(otherLineSegment.getPointTwo()) ||
                this.getPointTwo().equalsWithDelta(otherLineSegment.getPointOne()) && this.getPointOne().equalsWithDelta(otherLineSegment.getPointTwo());
    }

    }



//    /** Метод проверяет, находится ли точка на данном отрезке.
//     * Сначала осуществляется проверка, принадлежит ли точка прямой, на котором расположен данный отрезок.
//     * Потом проверяется, находится ли точка в границах отрезка*/
//    public boolean isPointBelongToTheSegment (Point point) {
//        if (isPointBelongToTheLine(point)) {
//            return  (((getPointOne().getX() <= point.getX()) && (point.getX() <= getPointTwo().getX())) || // Случай, если точка "one" расположена на оси X слева от точки "two"
//                    ((getPointTwo().getX() <= point.getX()) && (point.getX() <= getPointOne().getX())));  // Случай, если точка "two" расположена на оси X слева от точки "one"
//        } else return false;
//    }

