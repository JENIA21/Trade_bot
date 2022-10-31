package com.company.telegram.commands;

import com.company.module.User;
import com.company.module.Visualizer;

/**
 * Ответ на /help
 */
public class MenuHelp implements ICommand {

    @Override
    public String execute(String data, User user) {
        return Visualizer.MENU_HELP;
    }
}
