package org.example;

import java.util.HashMap;
import java.util.Map;

// Invoker
class ShellInvoker {
    public Map<String, Command> getCommands() {
        return commands;
    }

    public void registerCommand(Command command) {
        commands.put(command.getName(), command);
    }

    public void executeCommand(String command_name) {
        if (commands.containsKey(command_name)) {
            Command command = commands.get(command_name);
            command.execute();
        } else {
            System.out.println("Ошибка: неизвестная команда '" + command_name + "'");
        }
    }

    private Map<String, Command> commands = new HashMap<>();
}
