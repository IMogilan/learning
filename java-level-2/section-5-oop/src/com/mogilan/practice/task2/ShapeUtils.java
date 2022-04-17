package com.mogilan.practice.task2;

public class ShapeUtils {


    public static boolean isTriangle(Object obj) {
        if ((obj != null) && (obj instanceof Triangle)) {
            Triangle otherTriangle = (Triangle) obj;
            return !otherTriangle.isDegenerative();
        } else return false;
    }

    /**Метод осуществляет проверку, является ли четырехугольник прямоугольником.
     * Сначала проверяется, является ли объект четырехугольником.
     * Потом выполняется проверка, можно ли такой четырехугольник разделить по диагоналям на 4 прямоугольных треугольника.
     * Поле этого проверяется, являются ли гипотенузами этих треугольников именно диагонали четырехугольника (чтобы )*/
    public static boolean isRectangle (Object obj) {
        if ((obj != null) && (obj instanceof Quadrilateral)) {
            Quadrilateral otherQuadrilateral = (Quadrilateral) obj;
            if ((otherQuadrilateral.area() != 0) && !otherQuadrilateral.isDegenerative() && otherQuadrilateral.isConvex() && otherQuadrilateral.isPlain() && otherQuadrilateral.isRectangle()) return true;
            else return false;
        } else return false;
    }
}
