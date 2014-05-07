package com.github.bingoohuang.designpatterns.commandparsers;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.CommandParser;
import com.github.bingoohuang.designpatterns.commands.AddCommand;

public class AddCommandParser extends CommandParser {
    @Override
    public Command parseCommand() {
        String id = args[0];
        String name = args[1];
        return new AddCommand(id, name);
    }
}
