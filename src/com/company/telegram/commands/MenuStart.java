package com.company.telegram.commands;

import com.company.module.User;
import com.company.module.Visualizer;

import java.sql.SQLException;


public class MenuStart implements ICommand {

    @Override
    public String execute(String data, User user) {
        return Visualizer.GREETING_BOT;
    }
}





