package org.example;

public final class FigureUtil {
    public static double area(Figure figure) {
        return figure.area();
    }
    public static double perimeter(Figure figure) {
        return figure.perimeter();
    }
    public static void draw(Figure figure) {
        figure.draw();
    }
    public static void draw(Figure figure, Color color) {
        figure.draw(color);
    }
    private FigureUtil(){}
}
