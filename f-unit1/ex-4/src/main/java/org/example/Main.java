package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите число n - ");
        int n = sc.nextInt();

        int sum = 0;

        while (n != 0){
            int digit = n % 10;
            n /= 10;
            sum += digit;
        }

        System.out.print("Сумма цифр n - " + sum);
    }
}