package com.company.telegram.command_impl;


import com.company.module.User;
import com.company.module.Visualizer;

import static java.lang.Integer.parseInt;

/**
 * Добавление рублей
 */
public class AddMoney2 extends AddMoney {


    @Override
    CommandResponse doBotLogic(User user, String data) {

        if (!super.checkTypeOfNumber(data)) {
            return new CommandResponse(Visualizer.WRITE_NUM + Visualizer.TRADE_EXIT, CommandStates.GET_VALUE_RU);
        }

        if (parseInt(data) < 0) {
            return new CommandResponse(Visualizer.INCORRECT_INPUT, CommandStates.GET_VALUE_RU);
        }

        int bank = user.getBankRu() + parseInt(data);
        user.setBankRu(bank);
        return new CommandResponse(Visualizer.GOOD + Visualizer.TRADE_EXIT, CommandStates.GREETING);
    }


}
