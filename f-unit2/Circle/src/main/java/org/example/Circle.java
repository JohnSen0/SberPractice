package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Circle {

    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }

    public double area() {
        return (Math.PI * Math.pow(this.radius, 2));
    }

    public double perimetr() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        System.out.println("Характерисики круга{ радиус - " + this.radius +
                ", цвет - " + this.color +
                ", площадь - " + area() +
                ", периметр - " + perimetr() + " }");
        return super.toString();
    }

    private double radius;
    private String color;
}

class Main {
    public static void main(String[] args) {

        Circle circle = new Circle(5, "Синий");

        System.out.println(circle.area());
        System.out.println(circle.perimetr());

        circle.toString();
    }
}