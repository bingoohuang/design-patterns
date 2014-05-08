package com.github.bingoohuang.designpatterns.commandparsers;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.CommandParser;
import com.github.bingoohuang.designpatterns.commands.HrCommand;

public class HrCommandParser extends CommandParser {
    @Override
    protected Command createCommand(String[] args) {
        return new HrCommand();
    }

    @Override
    public String supportCommandType() {
        return "hr";
    }
}
