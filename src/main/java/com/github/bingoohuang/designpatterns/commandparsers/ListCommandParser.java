package com.github.bingoohuang.designpatterns.commandparsers;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.CommandParser;
import com.github.bingoohuang.designpatterns.commands.GetCommand;
import com.github.bingoohuang.designpatterns.commands.ListCommand;

public class ListCommandParser extends CommandParser {
    @Override
    public Command createCommand(String[] args) {
        return new ListCommand();
    }

    @Override
    public String supportCommandType() {
        return "list";
    }
}
