package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLiteConnection {

    public static Connection connector() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:src/main/resources/profiles/profiles.db");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
