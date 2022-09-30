package com.company.telegram.commands;

import com.company.module.User;

import java.sql.SQLException;


public interface ICommand {

    String execute(String data, User user) throws SQLException;
}
