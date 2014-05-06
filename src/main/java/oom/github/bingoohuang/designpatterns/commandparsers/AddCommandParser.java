package oom.github.bingoohuang.designpatterns.commandparsers;

import oom.github.bingoohuang.designpatterns.commands.AddCommand;
import oom.github.bingoohuang.designpatterns.Command;
import oom.github.bingoohuang.designpatterns.User;

import java.util.Map;

public class AddCommandParser implements oom.github.bingoohuang.designpatterns.CommandParser {
    @Override
    public Command parseCommand(Map<String, User> registry, String commandBody) {
        String[] fields = commandBody.split("\\s+");
        String id = fields[0];
        String name = fields[1];
        return new AddCommand(registry, id, name);
    }
}
