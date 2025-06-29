package org.example;

class Triangle extends Figure implements Drawable{
    public Triangle(Point pointA, Point pointB, Point pointC) {
        super(pointA);
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public double area() {
        double a = distance(pointA, pointB);
        double b = distance(pointB, pointC);
        double c = distance(pointC, pointA);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c)); // Формула Герона
    }
    public void draw() {
        printFigure(Color.BLACK.toString());
    }
    public void draw(Color color) {
        printFigure(color.toString());
    }
    private void printFigure(String color) {
        System.out.println("Нарисован треугольник с координатами " + getPosition() + " цвет: " + color);
    }
    public double perimeter() {
        return distance(pointA, pointB) + distance(pointB, pointC) + distance(pointC, pointA);
    }

    private double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }

    private Point pointA;
    private Point pointB;
    private Point pointC;
}
