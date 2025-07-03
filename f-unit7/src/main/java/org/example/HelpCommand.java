package org.example;

import java.util.Map;
import java.util.Scanner;

class HelpCommand extends Command implements Executable {
    public HelpCommand(ShellInvoker invoker) {
        super("help", "выводит список доступных команд");
        this.invoker = invoker;
    }
    public void execute(Scanner scanner) {
        System.out.println("Доступные команды:");
        for (Map.Entry<String, Command> entry : invoker.getCommands().entrySet()) {
            System.out.println(" " + entry.getKey() + " - " + entry.getValue().getDescription());
        }
    }

    private ShellInvoker invoker;
}