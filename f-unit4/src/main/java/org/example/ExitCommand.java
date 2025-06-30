package org.example;

class ExitCommand extends Command implements Executable {
    public ExitCommand(String description) {
        super(description);
    }
    public void execute() {
        System.exit(0);
    }
}
