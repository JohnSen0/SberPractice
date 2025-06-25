package org.example;
import java.util.Scanner;

public class Main {

    public static boolean is_prime(int number){
        if (number<=1) {
            return false;
        }
        for(int i = 2; i<Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число для провери, является ли оно простым - ");
        int number = sc.nextInt();

        if (is_prime(number)){
            System.out.print("Число является простым");
        }
        else {
            System.out.print("Число не является простым");
        }

    }
}