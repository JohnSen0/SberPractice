package org.example;
import java.util.Scanner;

public class Main {

    public static int reverseNum(int number) {
        int reversed_number = 0;

        while(number!=0){
            int digit = number % 10;
            number /= 10;
            reversed_number = reversed_number*10 + digit;
        }

        return reversed_number;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите число для его проверки - ");
        int number = sc.nextInt();

        int reversed_number = reverseNum(number);

        if (reversed_number == number){
            System.out.println("Число является палиндромом");
        } else {
            System.out.println("Число не является палиндромом");
        }
    }
}