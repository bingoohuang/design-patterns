package com.github.bingoohuang.designpatterns.commandparsers;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.CommandParser;
import com.github.bingoohuang.designpatterns.commands.GetCommand;

public class GetCommandParser extends CommandParser {
    @Override
    public Command createCommand(String[] args) {
        return new GetCommand(args[0]);
    }

    @Override
    public String supportCommandType() {
        return "get";
    }
}
