package com.company.telegram.commands;

import com.company.module.User;

import static com.company.telegram.command_impl.CommandStates.*;

/**
 * Логика обмена валюты
 */
public class Exchange implements ICommand {

    @Override
    public String execute(String data, User user) {

        switch (user.getExCode()) {
            case GREETING_EX -> {

                return GREETING_EX.realisation.execute(data, user);

            }
            case DATA_EX -> {

                return DATA_EX.realisation.execute(data, user);
            }
            case END_EX_RU -> {

                return END_EX_RU.realisation.execute(data, user);
            }
            case END_EX_USD -> {

                return END_EX_USD.realisation.execute(data, user);
            }
        }

        return "!";

    }
}
