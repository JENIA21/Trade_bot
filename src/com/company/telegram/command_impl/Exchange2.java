package com.company.telegram.command_impl;

import com.company.module.User;
import com.company.module.Visualizer;
import com.company.telegram.commands.Rate;

import static java.lang.Integer.parseInt;
/**
 * Обмен на доллары
 */
public class Exchange2 extends Exchange {
    @Override
    CommandResponse doBotLogic(User user, String data) {
        Rate rate = new Rate();

        if (!super.checkTypeOfNumber(data)) {

            return new CommandResponse(Visualizer.WRITE_NUM + Visualizer.TRADE_EXIT, CommandStates.END_EX_RU);
        }

        if (parseInt(data) < 0) {
            return new CommandResponse(Visualizer.INCORRECT_INPUT, CommandStates.END_EX_RU);
        }

        if (user.getBankRu() < parseInt(data)) {
            return new CommandResponse(Visualizer.NO_MANY, CommandStates.END_EX_RU);
        }

        if (parseInt(data) % rate.getDollarRate() != 0) {
            return new CommandResponse(Visualizer.NOT_ROUND, CommandStates.END_EX_RU);
        }
        System.out.println(data);
        int bank = user.getBankRu() - parseInt(data);
        user.setBankRu(bank);
        int usd = user.getBankUsd() + parseInt(data) / rate.getDollarRate();
        user.setBankUsd(usd);
        return new CommandResponse(Visualizer.GOOD + Visualizer.TRADE_EXIT, CommandStates.GREETING_EX);
    }
}
