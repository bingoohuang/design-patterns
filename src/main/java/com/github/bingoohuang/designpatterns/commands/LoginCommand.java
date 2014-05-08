package com.github.bingoohuang.designpatterns.commands;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.UserRegistry;

public class LoginCommand implements Command {
    @Override
    public String execute() {
        UserRegistry.getInstance().login();
        return "logined";
    }

    @Override
    public boolean requireLogin() {
        return false;
    }
}
