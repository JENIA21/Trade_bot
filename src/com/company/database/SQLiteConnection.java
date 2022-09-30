package com.company.database;

import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLiteConnection {

    private static final String CONNECTION_STRING = "jdbc:sqlite:./mydatabase.db";


    private final Connection connection;


    public SQLiteConnection() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(CONNECTION_STRING);
    }


    public Connection getConnection() {
        return connection;
    }
}
