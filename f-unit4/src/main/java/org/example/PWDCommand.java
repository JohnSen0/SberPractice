package org.example;

class PWDCommand extends Command implements Executable {
    public PWDCommand(String name, String description) {
        super(name, description);
    }
    public void execute() {
        System.out.println("Текущая директория: " + System.getProperty("user.dir"));
    }
}
