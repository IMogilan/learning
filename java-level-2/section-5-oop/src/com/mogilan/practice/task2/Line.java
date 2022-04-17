package com.mogilan.practice.task2;

public class Line {
    // Прямая (а) проходит через точки one и two и (б) описывается уравнением y = k * x + b
    private final Point pointOne;
    private final Point pointTwo;
    private final double k;
    private final double b;

    public Line(final Point pointOne, final Point pointTwo) {
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
        if (pointOne.equalsWithDelta(pointTwo)) throw new IllegalArgumentException("The points are equal!");
         /* Используя формулу прямой, проходящей через 2 точки:
        (y1 - y2) * x + (x2 - x1) * y + ( x1 * y2 - x2 * y1) = 0,
        строим уравнение прямой, которая проходит через 2 указанные выше точки.
        (y1 - y2) * x + (x2 - x1) * y + ( x1 * y2 - x2 * y1) = 0.
        Приводим (для удобства вычисления) данное уравнение к форме линейного уравнения (y = k * x + b):
        y = (- (y1 - y2) / (x2 - x1)) * x + (- (x1 * y2 - x2 * y1) / (x2 - x1))
        и находим коэффициенты 'k' и 'b' для уравнения данной прямой:*/
        double x1 = pointOne.getX(), y1 = pointOne.getY();
        double x2 = pointTwo.getX(), y2 = pointTwo.getY();
        k = (-(y1 - y2) / (x2 - x1));
        b = (-(x1 * y2 - x2 * y1) / (x2 - x1));
    }
    /** Метод для нахождения точки пересечения двух прямых.
     * Если прямые (1) полностью совпадают, т.е. у прямых попарно совпадают коэффициенты 'k' и 'b' (k1 == k2 и b1 == b2) или
     *             (2) параллельны (у прямых совпадают ТОЛЬКО угловые коэффициенты 'k'),
     * то метод возвращает null.*/
    public static Point linesIntersectionPoint (Line lineOne, Line lineTwo) {
        double k1 = lineOne.getK(), b1 = lineOne.getB();
        double k2 = lineTwo.getK(), b2 = lineTwo.getB();
        if ((k1 == k2) && (b1 == b2)) return null;
        else if (k1 == k2) return null;
        /*Теперь из одного уравнения (y = k * x + b) вычитаем второе уравнение (так в точке пересечения значения x и y
         у обоих уравнений должны быть равны) и находим координату 'x' точки пересечения.
        По результатам упрощения итогового вычитание одного уравнения из другого уравнения получаем следующее: x = (b2 -b1) / (k1 - k2).*/
        else {
            double x = (b2 - b1) / (k1 - k2);
            // После нахождения значения "x" точки пересечения двух прямых подставляем его в любое (например, первое) уравнение для поиска значения "y" точки пересечения двух прямых.
            double y = k1 * x + b1;
            return new Point(x, y);
        }
    }

    @Override
    public String toString() {
        return "Прямая задается уравнением y = " + getK() + " * x + " + getB() + ".\nПрямая проходит в частности через следующие точки:\n" +
                "точка один: " + getPointOne() + "\n" +
                "точка два: " + getPointTwo();
    }

    public Point getPointOne() { return pointOne; }

    public Point getPointTwo() { return pointTwo; }

    public double getK() { return k; }

    public double getB() { return b; }


//    /** Метод проверяет, находится ли точка на данной прямой,
//     * то есть выполняется ли при подстановке значений 'x' и 'y' данной точки равенство
//     * y = k * x + b*/
//    public boolean isPointBelongToTheLine (Point point) {
//        return point.getY() == this.getK() * point.getX() + this.getB();
//    }
}
