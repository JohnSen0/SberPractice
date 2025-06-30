package org.example;

public class PaintExample {
    public static void main(String[] args) {
        Point center = new Point(0, 0);
        Point topLeft = new Point(1, 1);
        Point a = new Point(0, 0);
        Point b = new Point(3, 0);
        Point c = new Point(0, 4);

        Figure circle = new Circle(center, 5);
        Figure rectangle = new Rectangle(topLeft, 4, 5);
        Figure square = new Square(new Point(2, 2), 3);
        Figure triangle = new Triangle(a, b, c);

        FigureUtil.draw(rectangle);
        FigureUtil.draw(square, Color.RED);
        FigureUtil.draw(triangle, Color.BLUE);
        FigureUtil.draw(circle, Color.GREEN);
        FigureUtil.draw(rectangle, Color.YELLOW);

        System.out.println("Площадь круга: " + FigureUtil.area(circle));
        System.out.println("Периметр квадрата: " + FigureUtil.perimeter(square));
        System.out.println("Площадь треугольника: " + FigureUtil.area(triangle));
    }
}