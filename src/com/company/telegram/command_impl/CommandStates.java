package com.company.telegram.command_impl;

import com.company.module.User;

/**
 * Команды
 */
public enum CommandStates {

    GREETING(0, new AddMoney0()),
    AMOUNT_CURRENCY(1, new AddMoney1()),
    GET_VALUE_RU(2, new AddMoney2()),
    GET_VALUE_USD(3, new AddMoney3()),
    GREETING_EX(4, new Exchange0()),
    DATA_EX(5, new Exchange1()),
    END_EX_RU(6, new Exchange2()),
    END_EX_USD(7, new Exchange3());

    private ICommand realisation;
    public static String AddMoney(String data, User user) {

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

    public static String Exchange(String data, User user) {

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

    public int addCode;

    CommandStates(int addCode, ICommand realisation) {
        this.addCode = addCode;
        this.realisation = realisation;
    }

}
