package com.github.bingoohuang.designpatterns.commands;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.UserRegistry;

public class UndoCommand implements Command {
    @Override
    public String execute() {
        UserRegistry.getInstance().undo();
        return "undo";
    }

    @Override
    public boolean requireLogin() {
        return false;
    }
}
