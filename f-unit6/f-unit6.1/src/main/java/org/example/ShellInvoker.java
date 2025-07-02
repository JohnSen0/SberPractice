package org.example;

import org.example.commands.Command;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

// Invoker
public class ShellInvoker {
    public static Map<String, Command> commands = new HashMap<>();

    public ShellInvoker(String packageName){
        registerCommandsFromPackage(packageName);
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    public void executeCommand(String command_name) {
        if (commands.containsKey(command_name)) {
            Command command = commands.get(command_name);
            command.execute();
        } else {
            System.out.println("Ошибка: неизвестная команда '" + command_name + "'");
        }
    }

    private void registerCommandsFromPackage(String packageName) {

    }
}