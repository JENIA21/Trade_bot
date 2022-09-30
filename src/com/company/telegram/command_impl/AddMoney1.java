package com.company.telegram.command_impl;


import com.company.module.User;
import com.company.module.Visualizer;

import static java.lang.Integer.parseInt;


public class AddMoney1 extends AddMoney {


    @Override
    CommandResponse doBotLogic(User user, String data) {

        if (data.equals("ru")) {
            return new CommandResponse(Visualizer.AMOUNT, CommandStates.GET_VALUE_RU);
        }
        if (data.equals("usd")) {
            return new CommandResponse(Visualizer.AMOUNT, CommandStates.GET_VALUE_USD);
        }
        return new CommandResponse(Visualizer.NOT_CURRENCY, CommandStates.AMOUNT_CURRENCY);


    }

}