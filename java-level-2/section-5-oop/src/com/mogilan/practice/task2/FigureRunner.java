package com.mogilan.practice.task2;

public class FigureRunner {
    public static void main(String[] args) {
        Point one = new Point(0,2);
        Point two = new Point(0,4);
        Point three = new Point(4,4);
        Point four = new Point(4, 2);
        Point five = new Point(0, -1);

        Triangle triangle = new Triangle(four, two, three);
        System.out.println(triangle.isRightTriangle());

        Quadrilateral quadrilateral = new Quadrilateral(one, two, three, four);
        System.out.println(quadrilateral.centroid());
        System.out.println(ShapeUtils.isRectangle(quadrilateral));

//        Circle circle = new Circle(one, 4);
//        System.out.println(circle);
//        System.out.println(circle.area());
//        AreaDetermining circleArea = circle;
//
//        AreaDetermining quadrilateralArea = quadrilateral;
//        System.out.println(circleArea.compareArea(quadrilateral));
    }
}
