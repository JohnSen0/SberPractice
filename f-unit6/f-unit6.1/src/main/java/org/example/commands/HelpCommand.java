package org.example.commands;

import org.example.CommandAnnotation;
import org.example.Executable;
import org.example.ShellInvoker;
import java.util.Map;

@CommandAnnotation(name = "help", description = "выводит список доступных команд")
class HelpCommand extends Command implements Executable {
    public HelpCommand(String name, String description) {
        super(name, description);
    }
    public void execute() {
        System.out.println("Доступные команды:");
        for (Map.Entry<String, Command> entry : ShellInvoker.commands.entrySet()) {
            System.out.println(" " + entry.getKey() + " - " + entry.getValue().getDescription());
        }
    }
}