package org.example;

import java.time.LocalTime;

class TimeCommand extends Command implements Executable {
    public TimeCommand(String name, String description) {
        super(name, description);
    }
    public void execute() {
        System.out.println("Текущая дата: " + LocalTime.now());
    }
}
