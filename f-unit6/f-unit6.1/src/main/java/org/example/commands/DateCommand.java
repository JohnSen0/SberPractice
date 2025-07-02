package org.example.commands;

import org.example.CommandAnnotation;
import org.example.Executable;

import java.time.LocalDate;

@CommandAnnotation(name = "date", description = "выводит текущее время")
class DateCommand extends Command implements Executable {
    public DateCommand(String name, String description) {
        super(name, description);
    }
    public void execute() {
        System.out.println("Текущая дата: " + LocalDate.now());
    }
}