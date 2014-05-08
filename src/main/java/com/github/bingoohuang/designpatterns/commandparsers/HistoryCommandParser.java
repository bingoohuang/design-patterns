package com.github.bingoohuang.designpatterns.commandparsers;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.CommandParser;
import com.github.bingoohuang.designpatterns.commands.HistoryCommand;

public class HistoryCommandParser extends CommandParser {
    @Override
    protected Command createCommand(String[] args) {
        return new HistoryCommand();
    }

    @Override
    public String supportCommandType() {
        return "history";
    }
}
