package com.company.telegram.commands;

import com.company.module.User;

import static com.company.telegram.command_impl.CommandStates.*;

/**
 * Логика добавлеия денег в кошелек
 */
public class AddMoney implements ICommand {


    @Override
    public String execute(String data, User user) {

        switch (user.getAddCode()) {
            case GREETING -> {

                return GREETING.realisation.execute(data, user);

            }
            case AMOUNT_CURRENCY -> {

                return AMOUNT_CURRENCY.realisation.execute(data, user);
            }
            case GET_VALUE_RU -> {

                return GET_VALUE_RU.realisation.execute(data, user);
            }
            case GET_VALUE_USD -> {

                return GET_VALUE_USD.realisation.execute(data, user);
            }
        }


        return "!";
    }


}
