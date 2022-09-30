package com.company.database;

import com.company.module.User;


public interface IDataSource {

    void saveUser(User user);

    User getUser(String chatId);

}
