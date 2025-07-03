package org.example.commands;

import org.example.CommandAnnotation;
import org.example.Executable;

import java.util.Map;

@CommandAnnotation(name = "help", description = "выводит список доступных команд")
public class HelpCommand extends Command implements Executable {
    private ShellInvoker invoker;
    public HelpCommand(String name, String description) {
        super(name, description);
    }
    public void execute() {
        System.out.println("Доступные команды:");
        for (Map.Entry<String, Executable> entry : invoker.getCommands().entrySet()) {
            Command command = (Command) entry.getValue();
            System.out.println("  " + command.getName() + " - " + command.getDescription());
        }
    }

    public void setInvoker(ShellInvoker shellInvoker) {
        this.invoker = shellInvoker;
    }
}