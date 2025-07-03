package org.example;
import java.sql.*;
import java.util.Scanner;

public class DoneCommand extends Command{
    Connection connection;

    public DoneCommand(Connection connection){
        super("done", "помечает задачу как выполненную");
        this.connection = connection;
    }

    @Override
    public void execute(Scanner scanner) throws SQLException {
        System.out.print("Введите UID команды, чтобы пометить его как выполненное: ");
        String input = scanner.nextLine();
        try {
            int uid = Integer.parseInt(input);
            String sql = "UPDATE todo_db SET status = TRUE WHERE uid = ? AND status = FALSE";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, uid);
                statement.executeUpdate();
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: UID должен быть числом.");
        }
    }
}
