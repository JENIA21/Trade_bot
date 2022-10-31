package com.company.telegram.command_impl;

import com.company.module.User;

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
     */
    String execute(String data, User user);

}
