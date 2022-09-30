package com.company.telegram.command_impl;


public enum CommandStates {

    GREETING(0, new AddMoney0()),
    AMOUNT_CURRENCY(1, new AddMoney1()),
    GET_VALUE_RU(2, new AddMoney2()),
    GET_VALUE_USD(3, new AddMoney3()),
    GREETING_EX(4, new Exchange0()),
    DATA_EX(5, new Exchange1()),
    END_EX_RU(6, new Exchange2()),
    END_EX_USD(7, new Exchange3());

    public ICommand realisation;

    public int addCode;

    CommandStates(int addCode, ICommand realisation) {
        this.addCode = addCode;
        this.realisation = realisation;
    }

}
