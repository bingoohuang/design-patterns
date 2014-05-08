package com.github.bingoohuang.designpatterns.commandparsers;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.CommandParser;
import com.github.bingoohuang.designpatterns.commands.LoadCommand;

public class LoadCommandParser extends CommandParser {
    @Override
    protected Command createCommand(String[] args) {
        return new LoadCommand();
    }

    @Override
    public String supportCommandType() {
        return "load";
    }
}
