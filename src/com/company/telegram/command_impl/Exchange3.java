package com.company.telegram.command_impl;

import com.company.module.User;
import com.company.module.Visualizer;
import com.company.telegram.commands.Rate;

import static java.lang.Integer.parseInt;

public class Exchange3 extends Exchange {
    @Override
    CommandResponse doBotLogic(User user, String data) {

        if (!super.checkTypeOfNumber(data)) {

            return new CommandResponse(Visualizer.WRITE_NUM + Visualizer.TRADE_EXIT, CommandStates.END_EX_USD);
        }

        if (parseInt(data) < 0) {
            return new CommandResponse(Visualizer.INCORRECT_INPUT, CommandStates.END_EX_USD);
        }

        if (user.getBankUsd() < parseInt(data)) {
            return new CommandResponse(Visualizer.NO_MANY, CommandStates.END_EX_USD);
        }

        Rate rate = new Rate();
        int usd = user.getBankUsd() - parseInt(data);
        user.setBankUsd(usd);
        int bank = user.getBankRu() + parseInt(data) * rate.getDollarRate();
        user.setBankRu(bank);
        return new CommandResponse(Visualizer.GOOD + Visualizer.TRADE_EXIT, CommandStates.GREETING_EX);

    }
}
