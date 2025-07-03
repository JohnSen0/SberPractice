package org.example;

import java.sql.*;
import java.util.Scanner;

public class ToDoApp {
    private static final String URL = "jdbc:h2:~/todo_db";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    private static void createTable(Connection connection) throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS todo_db (
                uid INT PRIMARY KEY AUTO_INCREMENT,
                name VARCHAR(50) NOT NULL,
                status BOOLEAN NOT NULL
                )
                """;
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Таблица создана!");
        }
    }

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTable(connection);
            ShellInvoker invoker = new ShellInvoker(connection);

            invoker.initializeCommands();


            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("> ");
                String input = scanner.nextLine().trim();
                invoker.executeCommand(input, scanner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}