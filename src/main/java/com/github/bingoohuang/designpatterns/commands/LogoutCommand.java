package com.github.bingoohuang.designpatterns.commands;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.UserRegistry;

public class LogoutCommand implements Command {
    @Override
    public String execute() {
        UserRegistry.getInstance().logout();
        return "logouted";
    }

    @Override
    public String getCommandType() {
        return "logout";
    }

    @Override
    public boolean requireLogin() {
        return true;
    }
}
