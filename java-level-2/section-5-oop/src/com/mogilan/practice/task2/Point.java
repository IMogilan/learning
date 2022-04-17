package com.mogilan.practice.task2;

public class Point {

    private double x;
    private double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double distance (Point other) {
        return Math.sqrt((this.x - other.getX()) * (this.x - other.getX()) +
                (this.y - other.getY()) * (this.y - other.getY()));
    }

    /** Метод проверяет, находится ли точка на заданной прямой,
     * то есть выполняется ли при подстановке значений 'x' и 'y' данной точки равенство
     * y = k * x + b*/
    public boolean isBelongToTheLine(Line line) {
        return this.getY() == line.getK() * this.getX() + line.getB();
    }

    /** Метод проверяет, находится ли точка на заданном отрезке.
     * Сначала осуществляется проверка, принадлежит ли точка прямой, на котором расположен данный отрезок.
     * Потом проверяется, находится ли точка в границах отрезка*/
    public boolean isBelongToTheSegment(LineSegment segment) {
        if (isBelongToTheLine(segment)) {
            Point pointOne = segment.getPointOne(), pointTwo = segment.getPointTwo();
            return  (((pointOne.getX() <= this.getX()) && (this.getX() <= pointTwo.getX())) || // Случай, если точка "one" расположена на оси X слева от точки "two"
                    ((pointTwo.getX() <= this.getX()) && (this.getX() <= pointOne.getX())));  // Случай, если точка "two" расположена на оси X слева от точки "one"
        } else return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() == obj.getClass()) return false;
        Point other = (Point) obj;
        return (this.getX() == other.getX()) && (this.getY() == other.getY());
    }

    /**Метод осуществляет сравнения значений 'x' и 'y' у двух точек с учетом допустимой погрешности (delta).
     * По умолчанию значение допустимой погрешности (delta) установлено в размере 0.00000000001*/
    public boolean equalsWithDelta (Object obj) {
        double delta = 0.00000000001;
        if (this == obj) return true;
        if (obj == null || getClass() == obj.getClass()) return false;
        Point other = (Point) obj;
        return  (Math.abs(other.getX() - this.getX()) < delta) && (Math.abs(other.getY() - this.getY()) < delta);
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + (int) this.getX();
        result = result * 31 + (int) this.getY();
        return result;
    }

    @Override
    public String toString() {
        return "точка с координатами (" + getX() + "; " + getY() + ")";
    }

    public double getX() { return x; }

    public double getY() { return y; }
}
