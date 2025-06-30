package org.example;

class ExitCommand extends Command implements Executable {
    public ExitCommand(String name, String description) {
        super(name, description);
    }
    public void execute() {
        System.exit(0);
    }
}
