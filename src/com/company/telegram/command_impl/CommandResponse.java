package com.company.telegram.command_impl;

public class CommandResponse {

    private String response;

    private CommandStates addCode;

    public String getResponse() {
        return response;
    }

    public CommandStates getAddCode() {
        return addCode;
    }

    CommandResponse(String response, CommandStates addCode) {
        this.response = response;
        this.addCode = addCode;
    }

}
