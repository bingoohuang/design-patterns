package com.github.bingoohuang.designpatterns.commandparsers;

import com.github.bingoohuang.designpatterns.CommandParser;
import com.github.bingoohuang.designpatterns.commands.AddCommand;
import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.User;

import java.util.Map;

public class AddCommandParser implements CommandParser {
    @Override
    public Command parseCommand(Map<String, User> registry, String commandBody) {
        String[] fields = commandBody.split("\\s+");
        String id = fields[0];
        String name = fields[1];
        return new AddCommand(registry, id, name);
    }
}
