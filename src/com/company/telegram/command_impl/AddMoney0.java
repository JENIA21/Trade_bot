package com.company.telegram.command_impl;


import com.company.module.User;
import com.company.module.Visualizer;


public class AddMoney0 extends AddMoney {

    @Override
    CommandResponse doBotLogic(User user, String data) {

        return new CommandResponse(Visualizer.TYPE_CURRENCY_ADD, CommandStates.AMOUNT_CURRENCY);

    }

}
