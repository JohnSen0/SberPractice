package org.example;

class PWDCommand extends Command implements Executable {
    public PWDCommand(String description) {
        super(description);
    }
    public void execute() {
        System.out.println("Текущая директория: " + System.getProperty("user.dir"));
    }
}
