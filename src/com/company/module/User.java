package com.company.module;

import com.company.telegram.command_impl.CommandStates;
import com.company.telegram.commands.Rate;

import java.util.Arrays;

public class User {

    private String chatId;

    private int bankRu;

    private int addCode;

    private int bankUsd;

    private int exCode;


    public User(String chatId, int bankRu, int addCode, int bankUsd, int exCode) {
        this.chatId = chatId;
        this.bankRu = bankRu;
        this.addCode = addCode;
        this.bankUsd = bankUsd;
        this.exCode = exCode;
    }

    public User(String chatId, int bankRu, CommandStates addCode, int bankUsd) {
        this.chatId = chatId;
        this.bankRu = bankRu;
        this.addCode = addCode.addCode;
        this.bankUsd = bankUsd;
    }


    public CommandStates getExCode() {
        return Arrays.stream(CommandStates.values()).filter((t) -> t.addCode == exCode).findFirst().get();
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
        return Arrays.stream(CommandStates.values()).filter((t) -> t.addCode == addCode).findFirst().get();
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
