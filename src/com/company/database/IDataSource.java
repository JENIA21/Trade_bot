package com.company.database;

import com.company.module.User;

import java.sql.SQLException;

/**
 *
 */

public interface IDataSource extends AutoCloseable {
    /**
     * Сохранения user в БД
     * @param user пользователь телеграм бота
     */
    void saveUser(User user);

    /**
     * Получения user из БД
     * @param chatId телеграма
     * @return пользователя телеграм бота
     */
    User getUser(String chatId);

    void close() throws Exception;
}
