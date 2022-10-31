package com.company.telegram.commands;

import com.company.module.User;

import java.sql.SQLException;

/**
 * Для обработки команд
 */
public interface ICommand {
    /**
     * Бизнес-логика команды
     *
     * @param data сообщение от user
     * @param user телеграм бота
     * @return строка ответа
     * @throws SQLException ошибки при работе с БД
     */
    String execute(String data, User user) throws SQLException;
}
