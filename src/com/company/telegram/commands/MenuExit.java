package com.company.telegram.commands;

import com.company.module.User;
import com.company.module.Visualizer;
import com.company.telegram.command_impl.CommandStates;

/**
 * Ответ на команду /exit
 */
public class MenuExit implements ICommand {


    @Override
    public String execute(String data, User user) {
        user.setAddCode(CommandStates.GREETING);
        return Visualizer.MENU_EXIT;
    }
}
