package com.company.telegram.command_impl;

import com.company.module.User;

public interface ICommand {

    String execute(String data, User user);

}
