package com.github.bingoohuang.designpatterns.commands;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.User;
import com.github.bingoohuang.designpatterns.UserRegistry;
import com.github.bingoohuang.designpatterns.mediator.UserRegistryMediator;

import java.util.Map;

public class DelCommand implements Command {
    private final String id;

    public DelCommand(String id) {
        this.id = id;
    }

    @Override
    public String execute() {
        UserRegistryMediator registry = UserRegistry.getInstance();
        User user = registry.get(id);
        if (user != null) {
            registry.remove(id);
            return "deleted " + user;
        } else {
            return "user not found";
        }

    }

    @Override
    public boolean requireLogin() {
        return true;
    }
}
