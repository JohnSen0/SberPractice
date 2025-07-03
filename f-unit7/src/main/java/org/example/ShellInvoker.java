package org.example;

import java.util.HashMap;
import java.util.Map;
import java.sql.*;
import java.util.Scanner;

// Invoker
class ShellInvoker {
    private Map<String, Command> commands = new HashMap<>();
    private Connection connection;

    public ShellInvoker(Connection connection) throws SQLException {
        this.connection = connection;
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    public void registerCommand(Command command) {
        commands.put(command.getName(), command);
    }

    public void executeCommand(String command_name, Scanner scanner) throws SQLException{
        if (commands.containsKey(command_name)) {
            Command command = commands.get(command_name);
            command.execute(scanner);
        } else {
            System.out.println("Ошибка: неизвестная команда '" + command_name + "'");
        }
    }

    public void initializeCommands() {
        registerCommand(new AddCommand(connection));
        registerCommand(new ShowCommand(connection));
        registerCommand(new HelpCommand(this));
        registerCommand(new DoneCommand(connection));
        registerCommand(new ExitCommand());
    }
}