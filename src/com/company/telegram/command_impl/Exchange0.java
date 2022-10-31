package com.company.telegram.command_impl;

import com.company.module.User;
import com.company.module.Visualizer;

/**
 * Первый ответ на команду обмена
 */
public class Exchange0 extends Exchange {
    @Override
    CommandResponse doBotLogic(User user, String data) {
        return new CommandResponse(Visualizer.TYPE_CURRENCY_EX, CommandStates.DATA_EX);
    }
}
