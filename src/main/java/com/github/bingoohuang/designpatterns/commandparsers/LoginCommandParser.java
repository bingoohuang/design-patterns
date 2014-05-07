package com.github.bingoohuang.designpatterns.commandparsers;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.CommandParser;
import com.github.bingoohuang.designpatterns.commands.LoginCommand;

public class LoginCommandParser extends CommandParser {
    @Override
    public Command createCommand(String[] args) {
        return new LoginCommand();
    }

    @Override
    public String supportCommandType() {
        return "login";
    }
}
