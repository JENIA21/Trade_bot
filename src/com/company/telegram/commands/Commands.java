package com.company.telegram.commands;

import com.company.module.User;

import static com.company.telegram.command_impl.CommandStates.*;
import static com.company.telegram.command_impl.CommandStates.GET_VALUE_USD;

/**
 * Команды
 */
public enum Commands {


    ADD_BANK("/exchange", new Exchange()),
    EXIT("/exit", new MenuExit()),
    GET_BANK("/getBank", new GetBank()),
    RATES("/getRates", new GetRates()),
    ADD_MONEY("/addMoney", new AddMoney()),
    HELP("/help", new MenuHelp()),
    INFORMATION("/information", new MenuInformation()),
    START("/start", new MenuStart());

    public String command;


    public ICommand realization;



    Commands(String command, ICommand realization) {
        this.command = command;
        this.realization = realization;
    }

}
