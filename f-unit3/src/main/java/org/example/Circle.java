package org.example;

// Круг
public class Circle extends Figure implements Drawable {
    // Констуктор
    public Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }

    // Методы
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
    public void draw() {
        printFigure(Color.BLACK.toString());
    }
    public void draw(Color color) {
        printFigure(color.toString());
    }
    private void printFigure(String color) {
        System.out.println("Нарисован круг с координатами " + getPosition() + " цвет: " + color);
    }
    // Параметры
    private double radius;
}
