package org.example;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.*;

/**
 * Класс для добавления новой задачи
 */
public class AddCommand extends Command{
    public Connection connection;

    /**
     * Конструктор
     * @param connection  соединение с БД
     */
    public AddCommand(Connection connection){
        super("add", "добавляет новую запись в список дел");
        this.connection = connection;
    }

    @Override
    public void execute(Scanner scanner) throws SQLException{
        System.out.println("Введите название задачи");
        String taskName = scanner.nextLine();
        String sql = "INSERT INTO todo_db (name, status) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, taskName);
            statement.setBoolean(2, false);
            statement.executeUpdate();
        }
    }
}
