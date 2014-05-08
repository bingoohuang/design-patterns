package com.github.bingoohuang.designpatterns.commands;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.UserRegistry;

public class HistoryCommand implements Command {
    @Override
    public String execute() {
        return UserRegistry.getInstance().showHistory();
    }

    @Override
    public boolean requireLogin() {
        return false;
    }
}
