package org.example;
import java.sql.*;
import java.util.Scanner;

class ExitCommand extends Command implements Executable {
    public ExitCommand() {
        super("exit", "завершает работу программы");
    }
    public void execute(Scanner scanner) {
        System.exit(0);
    }
}