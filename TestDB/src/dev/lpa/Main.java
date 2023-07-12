package dev.lpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        try(Connection conn = DriverManager.getConnection("jdbc:sqlite://home/shahid/projects/TestDB/src/test.db");
            Statement statement = conn.createStatement()) {
//            Connection conn = DriverManager.getConnection("jdbc:sqlite://home/shahid/projects/TestDB/src/test.db");
//            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");
            System.out.println("Contacts table created");
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());

        }
    }

}
