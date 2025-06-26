package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char right_answer = 'S';
        char players_answer = '0';

        do{
            System.out.print("Введите букву - ");
            String players_answer_input = sc.nextLine();
            players_answer = players_answer_input.charAt(0);
            if (players_answer != right_answer){
                if ((int) players_answer > (int) right_answer){
                    System.out.println("You are too high");
                }
                else {
                    System.out.println("You are too low");
                }
            }
        } while (players_answer!=right_answer);

        System.out.print("Right");

    }
}