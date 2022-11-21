package com.company.database;

import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Соединение с БД
 */
public class SQLiteConnection {

    private static final String CONNECTION_STRING = "jdbc:sqlite:./mydatabase.db";;


    private Connection connection;

    static {
        try {
            DriverManager.registerDriver(new JDBC());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setConnection() throws SQLException {
        this.connection = DriverManager.getConnection(CONNECTION_STRING);
    }


    public SQLiteConnection() throws SQLException {
        setConnection();
    }


    public Connection getConnection() throws SQLException {

        if (connection.isValid(3)) {
            return connection;
        } else {
            System.out.println("Подключение не валидно, пробуем еще раз");
            setConnection();
            return this.connection;
        }
    }
}
