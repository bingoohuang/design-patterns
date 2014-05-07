package com.github.bingoohuang.designpatterns.commands;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.UserRegistry;

public class ProxyCommand implements Command {
    private final Command command;

    public ProxyCommand(Command command) {
        this.command = command;
    }

    @Override
    public String execute() {
        if (!command.requireLogin()) {
            return command.execute();
        }

        if (UserRegistry.getInstance().isLogined()) {
            return command.execute();
        }

        return "login required";
    }

    @Override
    public String getCommandType() {
        return command.getCommandType();
    }

    @Override
    public boolean requireLogin() {
        return false;
    }
}
