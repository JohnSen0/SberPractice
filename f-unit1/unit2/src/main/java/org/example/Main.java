package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите a: ");
        int a = scanner.nextInt();

        System.out.print("Введите b: ");
        int b = scanner.nextInt();

        System.out.println(a + " / " + b + " = " + (a/b) + " и " + (a%b) + " в остатке");
    }
}