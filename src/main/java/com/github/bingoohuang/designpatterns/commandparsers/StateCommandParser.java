package com.github.bingoohuang.designpatterns.commandparsers;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.CommandParser;
import com.github.bingoohuang.designpatterns.commands.StateCommand;

public class StateCommandParser extends CommandParser {
    @Override
    protected Command createCommand(String[] args) {
        return new StateCommand(args[0], args[1]);
    }

    @Override
    public String supportCommandType() {
        return "state";
    }
}
