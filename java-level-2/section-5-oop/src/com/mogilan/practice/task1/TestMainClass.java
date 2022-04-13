package com.mogilan.practice.task1;

/*Внимание. При выполнении задания держите в уме принцип инкапсуляции.
Создать класс Point, описывающий точку в двумерных координатах.
Полями этого класса должны быть координаты x и y.
Класс должен иметь один конструктор, принимающий координаты x и y.
Добавьте функционал для получения скрытой информации (координаты точки), а получить её можно только с помощью методов доступа (get/set).
Создать метод distance, принимающий объект Point и определяющий расстояние до неё.
Используя класс точки, создать класс Rectangle, описывающий прямоугольник.
В нём хранятся два поля типа Point - координаты левого верхнего и правого нижнего углов.
Создать следующие методы в классе Rectangle:
- Высчитывающий площадь прямоугольника
- Высчитывающий длину диагонали
Написать тестовый класс с методом main программу, демонстрирующим создание объекта класса Rectangle и применение вышеперечисленных методов.*/

public class TestMainClass {
    public static void main(String[] args) {
        Point leftUpperVertex = new Point(2, 5);
        Point rightDownVertex = new Point(7, 2);
        System.out.printf("Point one coordinates: x = %d, y = %d\n", leftUpperVertex.getX(), leftUpperVertex.getY());
        System.out.printf("Point two coordinates: x = %d, y = %d\n", rightDownVertex.getX(), rightDownVertex.getY());
        System.out.println("Distance between Point one and Point two: " + leftUpperVertex.distance(rightDownVertex));

        Rectangle rectangle = new Rectangle(leftUpperVertex, rightDownVertex);
        System.out.println("Diagonal length of the rectangle: "  + rectangle.diagonalLength());
        System.out.println("Area of the rectangle: " + rectangle.area());
    }

}
