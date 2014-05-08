package com.github.bingoohuang.designpatterns.commands;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.storage.UserStorageContext;

public class SaveCommand implements Command {
    private final UserStorageContext userStorageContext;

    public SaveCommand(UserStorageContext userStorageContext) {
        this.userStorageContext = userStorageContext;
    }

    @Override
    public String execute() {
        return userStorageContext.save();
    }

    @Override
    public boolean requireLogin() {
        return true;
    }
}
