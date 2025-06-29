package org.example;

// Абстрактный класс для Фигур
public abstract class Figure implements Drawable{
    public Figure(Point position) {
        this.position = position;
    }
    public Point getPosition() {
        return position;
    }
    public abstract double area();
    public abstract double perimeter();

    private Point position;
}
