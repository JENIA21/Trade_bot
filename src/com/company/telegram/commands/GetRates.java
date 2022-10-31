package com.company.telegram.commands;

import com.company.module.User;
import com.company.module.Visualizer;

/**
 * Ответ на просмотр курса доллара
 */
public class GetRates implements ICommand {

    @Override
    public String execute(String data, User user) {
        Rate rate = new Rate();
        return Visualizer.DOLLAR_COST + rate.getDollarRate();
    }
}
