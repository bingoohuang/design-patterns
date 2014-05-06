package com.github.bingoohuang.designpatterns.commands;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.User;
import com.github.bingoohuang.designpatterns.storage.UserStorageContext;

import java.util.Map;

public class SaveCommand implements Command {
    private final Map<String, User> registry;
    private final UserStorageContext userStorageContext;

    public SaveCommand(Map<String, User> registry, UserStorageContext userStorageContext) {
        this.registry = registry;
        this.userStorageContext = userStorageContext;
    }

    @Override
    public String execute() {
        return userStorageContext.save(registry);
    }
}
