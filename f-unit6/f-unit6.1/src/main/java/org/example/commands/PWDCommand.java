package org.example.commands;

import org.example.CommandAnnotation;
import org.example.Executable;

@CommandAnnotation(name = "pwd", description = "выводит текущий рабочий каталог")
class PWDCommand extends Command implements Executable {
    public PWDCommand(String name, String description) {
        super(name, description);
    }
    public void execute() {
        System.out.println("Текущая директория: " + System.getProperty("user.dir"));
    }
}