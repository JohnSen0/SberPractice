package org.example;

import java.util.Map;

class HelpCommand extends Command implements Executable {
    public HelpCommand(ShellInvoker invoker, String description) {
        super(description);
        this.invoker = invoker;
    }
    public void execute() {
        System.out.println("Доступные команды:");
        for (Map.Entry<String, Command> entry : invoker.getCommands().entrySet()) {
            System.out.println(" " + entry.getKey() + " - " + entry.getValue().getDescription());
        }
    }

    private ShellInvoker invoker;
}
