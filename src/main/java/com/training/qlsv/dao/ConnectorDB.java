package com.training.qlsv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDB {

    private static final String url = "jdbc:mysql://localhost:3306/QLSV";

    private static final String username = "root";

    private static final String password = "root";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting database...");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected database");
            return connection;
        } catch (Exception e) {
            System.out.println("Fail connect to database");
            return null;
        }
    }
}
