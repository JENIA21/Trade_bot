package com.company.telegram.commands;

import com.company.module.User;
import com.company.module.Visualizer;
import com.company.telegram.command_impl.CommandStates;

public class MenuExit implements ICommand {


    @Override
    public String execute(String data, User user) {
        user.setAddCode(CommandStates.GREETING);
        user.setExCode(CommandStates.GREETING_EX.addCode);
        return Visualizer.MENU_EXIT;
    }
}
