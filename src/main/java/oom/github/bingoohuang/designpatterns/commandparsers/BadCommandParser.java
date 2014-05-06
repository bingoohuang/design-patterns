package oom.github.bingoohuang.designpatterns.commandparsers;

import oom.github.bingoohuang.designpatterns.commands.BadCommand;
import oom.github.bingoohuang.designpatterns.Command;
import oom.github.bingoohuang.designpatterns.User;

import java.util.Map;

public class BadCommandParser implements oom.github.bingoohuang.designpatterns.CommandParser {
    @Override
    public Command parseCommand(Map<String, User> registry, String commandBody) {
        return new BadCommand();
    }
}
