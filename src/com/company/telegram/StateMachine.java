package com.company.telegram;

import com.company.module.User;
import com.company.telegram.commands.*;
import com.company.telegram.command_impl.CommandStates;

import java.util.HashMap;
import java.util.Map;

public class StateMachine {

    static Map<String, ICommand> menuCommand = new HashMap<>();


    static {

        for (Commands command : Commands.values()) {
            menuCommand.put(command.command, command.realization);
        }
    }

    public String doCommand(String command, User user) {

        try {
            ICommand iCommand = menuCommand.get(command);

            return iCommand.execute(command, user);
        } catch (Exception exception) {
            if (user.getAddCode() != CommandStates.GREETING && !command.equals("/exit")) {
                return new AddMoney().execute(command, user);
            }
            if (user.getExCode() != CommandStates.GREETING_EX && !command.equals("/exit")) {
                return new Exchange().execute(command, user);
            }

            return "Не понял команду!";

        }
    }
}
