package com.github.bingoohuang.designpatterns.commandparsers;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.CommandParser;
import com.github.bingoohuang.designpatterns.commands.DelCommand;
import com.github.bingoohuang.designpatterns.User;

import java.util.Map;

public class DelCommandParser implements CommandParser {
    @Override
    public Command parseCommand(Map<String, User> registry, String commandBody) {
        String id = commandBody;
        return new DelCommand(registry, id);
    }
}
