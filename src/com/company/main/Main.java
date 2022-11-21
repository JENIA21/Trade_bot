package com.company.main;

import com.company.database.DBSource;
import com.company.database.SQLiteConnection;
import com.company.telegram.StateMachine;
import com.company.telegram.TelegramBot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.sql.SQLException;

/**
 * Точка входа в проект, создание соединения, работа с ботом
 */
public class Main {
    static DBSource dbSource;
    public static void main(String[] args) throws Exception {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            dbSource = new DBSource(new SQLiteConnection());
            TelegramBot bot = new TelegramBot(dbSource);
            telegramBotsApi.registerBot(bot);

        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    dbSource.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}