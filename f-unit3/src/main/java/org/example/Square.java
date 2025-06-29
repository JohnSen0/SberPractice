package org.example;

// Квадрат
public class Square extends Rectangle {
    public Square(Point top_left, double side) {
        super(top_left, side, side);
    }
    protected void printFigure(String color) {
        System.out.println("Нарисован квадрат с координатами " + getPosition() + " цвет: " + color);
    }
}
