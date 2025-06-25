package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите вес на Земле - ");
        int weight_on_earth = sc.nextInt();

        System.out.print("Вес на Луне - " + (weight_on_earth * 0.17));

    }
}