package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите а - ");
        double a = sc.nextDouble();
        System.out.print("Введите b - ");
        double b = sc.nextDouble();
        System.out.print("Введите c - ");
        double c = sc.nextDouble();

        if (a != 0) {
            double D = Math.pow(b, 2) - 4 * a * c;

            if (D > 0) {
                double x1 = (-b + Math.sqrt(D)) / (2 * a);
                double x2 = (-b - Math.sqrt(D)) / (2 * a);
                System.out.printf("x1 = %f %nx2 = %f %n", x1, x2);
            } else if (D == 0) {
                double x1 = (-b + Math.sqrt(D)) / (2 * a);
                System.out.printf("x1 = %f %n", x1);
            } else if (D < 0) {
                System.out.println("Корней нет");
            }
        }
    }
}