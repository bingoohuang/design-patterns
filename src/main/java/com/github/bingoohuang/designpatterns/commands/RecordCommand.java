package com.github.bingoohuang.designpatterns.commands;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.UserRegistry;
import com.github.bingoohuang.designpatterns.recorder.CommandHistory;

public class RecordCommand implements Command {
    private final CommandHistory commandHistory;

    public RecordCommand(CommandHistory commandHistory) {
        this.commandHistory = commandHistory;
    }

    @Override
    public String execute() {
        UserRegistry.getInstance().setCommandHistory(commandHistory);
        return "record " + (commandHistory != null ? "on" : "off");
    }

    @Override
    public boolean requireLogin() {
        return false;
    }
}
