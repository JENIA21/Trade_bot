package com.company.module;

import com.company.telegram.command_impl.CommandStates;
import com.company.telegram.command_impl.ICommand;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Пользователь
 */
public class User {

    //уникальный id чата
    private String chatId;

    //количество рублей
    private int bankRu;

    //код для шага добавления валюты
    private int addCode;

    //количество долларов
    private int bankUsd;

    //код для шага обмена валюты
    private int exCode;


    public User(String chatId, int bankRu, int addCode, int bankUsd, int exCode) {
        this.chatId = chatId;
        this.bankRu = bankRu;
        this.addCode = addCode;
        this.bankUsd = bankUsd;
        this.exCode = exCode;
    }


    static HashMap<Integer, CommandStates> commands = new HashMap<Integer, CommandStates>();
    static {

        for (CommandStates command : CommandStates.values()) {
            commands.put(command.addCode, command);
        }
    }
    public CommandStates getExCode() {
        return commands.get(exCode);
    }


    public void setExCode(int exCode) {
        this.exCode = exCode;
    }

    public void setBankUsd(int bankUsd) {
        this.bankUsd = bankUsd;
    }

    public int getBankUsd() {
        return bankUsd;
    }


    public CommandStates getAddCode() {
        return commands.get(addCode);
    }

    public void setAddCode(CommandStates addCode) {
        this.addCode = addCode.addCode;
    }

    public int getBankRu() {
        return this.bankRu;
    }

    public String getChatId() {
        return this.chatId;
    }

    public void setBankRu(int bankRu) {
        this.bankRu = bankRu;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

}
