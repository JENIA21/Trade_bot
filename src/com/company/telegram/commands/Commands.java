package com.company.telegram.commands;

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
