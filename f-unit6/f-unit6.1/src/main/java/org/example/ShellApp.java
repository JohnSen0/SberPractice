package org.example;
import org.example.commands.*;
import java.util.Scanner;

public class ShellApp {
    public static void main(String[] args) {
        ShellInvoker invoker = new ShellInvoker("org.example.commands");
        // Консольный ввод
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            invoker.executeCommand(input);
        }
    }
}