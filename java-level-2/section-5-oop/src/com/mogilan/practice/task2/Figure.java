package com.mogilan.practice.task2;

public abstract class Figure implements AreaDetermining, PerimeterDetermining {

    public abstract Point centroid();

    /** Метод для проверки, является ли фигура вырожденной*/
    public abstract boolean isDegenerative ();

    public abstract boolean isTheSame(Figure figure);

    /**Метод для проверки совпадения вершин одной фигуры, с введенными вершинами второй фигуры.
     * В качестве первого параметра принимает массив вершин первой фигуры, в потом - вершины второй фигуры*/
    public boolean checkVertices (Point [] verticesOfThis, Point ... verticesOfFigure) {
        if ((verticesOfFigure != null) && (verticesOfFigure.length == verticesOfThis.length)) {
            int checkSum = 0;
            for (int i = 0; i < verticesOfFigure.length; i++)
                for (int j = 0; j < verticesOfThis.length; j++)
                    if (verticesOfFigure[i].equalsWithDelta(verticesOfThis[j])) {
                        checkSum++;
                        verticesOfThis [j] = null;
                    }
            if (checkSum == verticesOfThis.length) return true;
            else return false;
        } else return false;
    }

    /** Метод для поиска расстояния между двумя точками*/
    public static final double distanceBetweenPoints (Point pointOne, Point pointTwo) {
        return Math.sqrt((pointTwo.getX() - pointOne.getX()) * (pointTwo.getX() - pointOne.getX()) + (pointTwo.getY() - pointOne.getY()) * (pointTwo.getY() - pointOne.getY()));
    }

    /**Метод для сравнения значений с плавающей точкой с учетом допустимой погрешности (delta).
     * По умолчанию значение допустимой погрешности (delta) установлено в размере 0.00000000001*/
    public boolean deltaCompare (double a, double b) {
        double delta = 0.00000000001; // устанавливаем допустимую погрешность при сравнении
        return  Math.abs(a - b) < delta;
    }



}
