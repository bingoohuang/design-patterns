package com.github.bingoohuang.designpatterns.commands;

import com.github.bingoohuang.designpatterns.Command;

public class BadCommand implements Command {
    @Override
    public String execute() {
        return "command unknown";
    }

    @Override
    public boolean requireLogin() {
        return false;
    }
}
