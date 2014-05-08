package com.github.bingoohuang.designpatterns.commandparsers;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.CommandParser;
import com.github.bingoohuang.designpatterns.commands.BossCommand;

public class BossCommandParser extends CommandParser {
    @Override
    protected Command createCommand(String[] args) {
        return new BossCommand();
    }

    @Override
    public String supportCommandType() {
        return "boss";
    }
}
