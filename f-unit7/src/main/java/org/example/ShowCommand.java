package org.example;

import java.sql.*;
import java.sql.Statement;
import java.util.Scanner;

public class ShowCommand extends Command {
    public Connection connection;

    /**
     * Конструктор
     * @param connection  соединение с БД
     */
    public ShowCommand(Connection connection){
        super("show", "показать невыполненные задания");
        this.connection = connection;
    }

    @Override
    public void execute(Scanner scanner) throws SQLException {
        String sql = "SELECT * FROM todo_db WHERE status = FALSE";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            System.out.println("Задачи:");

            while (resultSet.next()) {
                System.out.printf("| UID: %d | Название: %s | Статус: %s |%n",
                        resultSet.getInt("uid"),
                        resultSet.getString("name"),
                        resultSet.getBoolean("status") ? "Выполнено" : "Не выполнено");
            }
        }
    }
}
