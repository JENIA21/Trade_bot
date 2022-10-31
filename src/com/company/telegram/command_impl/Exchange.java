package com.company.telegram.command_impl;

import com.company.module.User;
import com.company.telegram.commands.Commands;

/**
 * Работа с командами обмена
 */
public abstract class Exchange implements ICommand {

    @Override
    public String execute(String data, User user) {
        CommandResponse dialogSettings = doBotLogic(user, data);
        String response = dialogSettings.getResponse();
        CommandStates exCode = dialogSettings.getAddCode();
        user.setExCode(exCode.addCode);
        return response;
    }

    ;

    abstract CommandResponse doBotLogic(User user, String data);

    protected boolean checkTypeOfNumber(String number) {
        try {
            if (!number.equals(Commands.EXIT.command) && Integer.parseInt(number) > -1) {
                return true;

            }
            return true;

        } catch (NumberFormatException e) {
            return false;
        }

    }
}
