package com.company.telegram.command_impl;

import com.company.module.User;
import com.company.module.Visualizer;

public class Exchange1 extends Exchange {

    @Override
    CommandResponse doBotLogic(User user, String data) {

        if (data.equals("ru")) {
            return new CommandResponse(Visualizer.AMOUNT, CommandStates.END_EX_RU);
        }
        if (data.equals("usd")) {
            return new CommandResponse(Visualizer.AMOUNT, CommandStates.END_EX_USD);
        }
        return new CommandResponse(Visualizer.NOT_CURRENCY, CommandStates.DATA_EX);

    }

}
