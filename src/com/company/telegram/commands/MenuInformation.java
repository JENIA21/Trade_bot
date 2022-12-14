package com.company.telegram.commands;

import com.company.module.User;
import com.company.module.Visualizer;

/**
 * Ответ на команду /information
 */
public class MenuInformation implements ICommand {

    @Override
    public String execute(String data, User user) {
        return Visualizer.INFORMATION;
    }
}
