package com.company.telegram.commands;

import com.company.module.User;
import com.company.telegram.command_impl.CommandStates;

import static com.company.telegram.command_impl.CommandStates.*;

/**
 * Логика добавлеия денег в кошелек
 */
public class AddMoney implements ICommand {


    @Override
    public String execute(String data, User user) {
        return CommandStates.AddMoney(data, user);
    }
}
