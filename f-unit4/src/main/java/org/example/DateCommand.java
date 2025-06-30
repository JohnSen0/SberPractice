package org.example;

import java.time.LocalDate;

// Комманды
class DateCommand extends Command implements Executable {
    public DateCommand(String description) {
        super(description);
    }
    public void execute() {
        System.out.println("Текущая дата: " + LocalDate.now());
    }
}
