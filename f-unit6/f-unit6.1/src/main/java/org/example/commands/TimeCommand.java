package org.example.commands;

import org.example.CommandAnnotation;
import org.example.Executable;

import java.time.LocalTime;

@CommandAnnotation(name = "time", description = "выводит текущее время")
class TimeCommand extends Command implements Executable {
    public TimeCommand(String name, String description) {
        super(name, description);
    }
    public void execute() {
        System.out.println("Текущая дата: " + LocalTime.now());
    }
}