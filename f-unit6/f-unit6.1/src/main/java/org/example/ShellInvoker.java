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
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            URL packageURL = loader.getResource(packageName.replace('.', '/'));

            File packageDir = new File(packageURL.getFile());
            for (File file : packageDir.listFiles()) {
                if (file.getName().endsWith(".class")) {
                    String className = packageName + "." + file.getName().replace(".class", "");
                    Class <?> clazz = Class.forName(className);

                    if (clazz.isAnnotationPresent(CommandAnnotation.class)) {
                        CommandAnnotation annotation = clazz.getAnnotation(CommandAnnotation.class);
                        Command command = (Command) clazz
                                .getDeclaredConstructor(String.class, String.class)
                                .newInstance(annotation.name(), annotation.description());
                        commands.put(annotation.name(), command);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}