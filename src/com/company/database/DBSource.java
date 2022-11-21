package com.company.database;

import com.company.module.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Методы для работы с БД
 */
public class DBSource implements IDataSource {

    private final SQLiteConnection sqLiteConnection;

    public DBSource(SQLiteConnection sqLiteConnection) throws SQLException {
        this.sqLiteConnection = new SQLiteConnection();
    }

    @Override
    public void saveUser(User user) {
        try (PreparedStatement statement = sqLiteConnection.getConnection().prepareStatement(
                "INSERT OR REPLACE INTO users(id, bank_ru, state_code, bank_usd, ex_code) " +
                        "VALUES(?, ?, ?, ?,?)")) {
            statement.setString(1, user.getChatId());
            statement.setInt(2, user.getBankRu());
            statement.setInt(3, user.getAddCode().addCode);
            statement.setInt(4, user.getBankUsd());
            statement.setInt(5, user.getExCode().addCode);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(String chatId) {
        try (Statement statement = sqLiteConnection.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM users WHERE id='%s'", chatId));
            return new User(resultSet.getString("id"),
                    resultSet.getInt("bank_ru"),
                    resultSet.getInt("state_code"),
                    resultSet.getInt("bank_usd"),
                    resultSet.getInt("ex_code"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        sqLiteConnection.getConnection().close();
    }
}
