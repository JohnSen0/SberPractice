package org.example;

public class Point {
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    private double x;
    private double y;
}
