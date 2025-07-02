package org.example.commands;

import org.example.CommandAnnotation;
import org.example.Executable;

@CommandAnnotation(name = "exit", description = "завершает работу приложения")
class ExitCommand extends Command implements Executable {
    public ExitCommand(String name, String description) {
        super(name, description);
    }
    public void execute() {
        System.exit(0);
    }
}