package com.github.bingoohuang.designpatterns.commands;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.User;
import com.github.bingoohuang.designpatterns.UserRegistry;

import java.util.Map;

public class GetCommand implements Command {
    private final String id;

    public GetCommand(String id) {
        this.id = id;
    }

    @Override
    public String execute() {
        User user = UserRegistry.getInstance().get(id);
        if (user != null) {
            return "got " + user;
        } else {
            return "user not found";
        }
    }

    @Override
    public String getCommandType() {
        return "get";
    }

    @Override
    public boolean requireLogin() {
        return false;
    }
}
