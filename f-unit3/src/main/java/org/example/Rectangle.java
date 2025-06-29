package org.example;

// Прямоугольник
public class Rectangle extends Figure implements Drawable {
    // Констуктор
    public Rectangle(Point top_left, double width, double height) {
        super(top_left);
        this.width = width;
        this.height = height;
    }

    // Методы
    public double area() {
        return width * height;
    }
    public double perimeter() {
        return 2 * width + 2 * height;
    }
    public void draw() {
        printFigure(Color.BLACK.toString());
    }
    public void draw(Color color) {
        printFigure(color.toString());
    }
    protected void printFigure(String color) {
        System.out.println("Нарисован прямоугольник с координатами " + getPosition() + " цвет: " + color);
    }
    // Параметры
    private double width;
    private double height;
}
