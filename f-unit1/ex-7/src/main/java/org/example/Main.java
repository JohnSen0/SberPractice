package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количсетво чисел Фибоначчи - ");
        int n = sc.nextInt();

        long a = 0;
        long b = 1;

        for (int i = 1; i <= n; i++){
            System.out.print(a + " ");
            long sum = a + b;
            a = b;
            b = sum;
        }
    }
}