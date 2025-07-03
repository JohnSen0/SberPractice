package org.example;

import java.util.Scanner;
import java.sql.*;

// Интерфейс комманд
interface Executable {
    void execute(Scanner scanner) throws SQLException;
}