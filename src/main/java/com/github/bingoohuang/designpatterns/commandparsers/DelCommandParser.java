package com.github.bingoohuang.designpatterns.commandparsers;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.CommandParser;
import com.github.bingoohuang.designpatterns.commands.DelCommand;

public class DelCommandParser extends CommandParser {
    @Override
    public Command createCommand(String[] args) {
        return new DelCommand(args[0]);
    }

    @Override
    public String supportCommandType() {
        return "del";
    }
}
