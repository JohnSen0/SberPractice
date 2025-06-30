package org.example;

import java.time.LocalTime;

class TimeCommand extends Command implements Executable {
    public TimeCommand(String description) {
        super(description);
    }
    public void execute() {
        System.out.println("Текущая дата: " + LocalTime.now());
    }
}
