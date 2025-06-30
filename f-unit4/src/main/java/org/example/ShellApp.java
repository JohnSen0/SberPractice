package org.example;
import java.util.Scanner;

public class ShellApp {
    public static void main(String[] args) {
        ShellInvoker invoker = new ShellInvoker();
        // Регистрация команд с описаниями
        invoker.registerCommand("date", new DateCommand("выводит текущую дату"));
        invoker.registerCommand("time", new TimeCommand("выводит текущее время"));
        invoker.registerCommand("pwd", new PWDCommand("выводит текущий рабочий каталог"));
        invoker.registerCommand("exit", new ExitCommand("завершает работу приложения "));
        invoker.registerCommand("help", new HelpCommand(invoker, "выводит список доступных команд"));

        // Консольный ввод
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            invoker.executeCommand(input);
        }
    }
}