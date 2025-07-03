package org.example.commands;

import org.example.CommandAnnotation;
import org.example.Executable;

import java.lang.reflect.Constructor;
import java.util.*;

import org.reflections.Reflections;
import java.util.HashMap;
import java.util.Map;

// Invoker
public class ShellInvoker {
    public static Map<String, Executable> commands = new HashMap<>();

    public ShellInvoker(String packageName){
        registerCommandsFromPackage(packageName);
    }

    public Map<String, Executable> getCommands() {
        return commands;
    }

    public void executeCommand(String command_name) {
        if (commands.containsKey(command_name)) {
            Executable command = commands.get(command_name);
            command.execute();
        } else {
            System.out.println("Ошибка: неизвестная команда '" + command_name + "'");
        }
    }

    private void registerCommandsFromPackage(String packageName) {
        Reflections reflections = new Reflections(packageName);
        Set<Class<? extends Command>> commandClasses = reflections.getSubTypesOf(Command.class);

        for (Class<? extends Command> clazz : commandClasses) {
            CommandAnnotation annotation = clazz.getAnnotation(CommandAnnotation.class);
            if (annotation != null) {
                try {
                    // Извлекаем name и description из аннотации
                    String name = annotation.name();
                    String description = annotation.description();
                    // Создаем экземпляр команды с параметрами из аннотации
                    Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, String.class);
                    Executable command = (Executable) constructor.newInstance(name, description);
                    // Особый случай для HelpCommand
                    if (clazz.equals(HelpCommand.class)) {
                        ((HelpCommand) command).setInvoker(this);
                    }
                    registerCommand(name, command);
                } catch (NoSuchMethodException e) {
                    System.err.println("No constructor with String parameters for: " + clazz.getName());
                } catch (Exception e) {
                    System.err.println("Error initializing command: " + clazz.getName() + ": " + e.getMessage());
                }
            }
        }
    }

    private void registerCommand(String name, Executable command) {
        commands.put(name, command);
    }
}