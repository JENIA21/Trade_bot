package com.company.telegram.command_impl;


import com.company.module.User;
import com.company.module.Visualizer;

import static java.lang.Integer.parseInt;


public class AddMoney3 extends AddMoney {

    @Override
    CommandResponse doBotLogic(User user, String data) {
        if (!super.checkTypeOfNumber(data)) {

            return new CommandResponse(Visualizer.WRITE_NUM + Visualizer.TRADE_EXIT, CommandStates.GET_VALUE_USD);
        }

        if (parseInt(data) < 0) {
            return new CommandResponse(Visualizer.INCORRECT_INPUT, CommandStates.GET_VALUE_USD);
        }

        int bank = user.getBankUsd() + parseInt(data);
        user.setBankUsd(bank);
        return new CommandResponse(Visualizer.GOOD + Visualizer.TRADE_EXIT, CommandStates.GREETING);

    }
}
