package org.example;
import java.util.Scanner;

public class ShellApp {
    public static void main(String[] args) {
        ShellInvoker invoker = new ShellInvoker();
        // Регистрация команд с описаниями
        invoker.registerCommand(new DateCommand("date","выводит текущую дату"));
        invoker.registerCommand(new TimeCommand("time", "выводит текущее время"));
        invoker.registerCommand(new PWDCommand("pwd", "выводит текущий рабочий каталог"));
        invoker.registerCommand(new ExitCommand("exit", "завершает работу приложения "));
        invoker.registerCommand(new HelpCommand(invoker, "help", "выводит список доступных команд"));

        // Консольный ввод
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            invoker.executeCommand(input);
        }
    }
}