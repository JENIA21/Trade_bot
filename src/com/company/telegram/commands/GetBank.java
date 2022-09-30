package com.company.telegram.commands;

import com.company.module.User;
import com.company.module.Visualizer;


public class GetBank implements ICommand {

    @Override
    public String execute(String data, User user) {
        return Visualizer.AMOUNT_RU + user.getBankRu() + Visualizer.AMOUNT_USD + user.getBankUsd();
    }
}
