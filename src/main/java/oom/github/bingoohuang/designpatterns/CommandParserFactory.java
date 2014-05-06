package oom.github.bingoohuang.designpatterns;

import oom.github.bingoohuang.designpatterns.commandparsers.AddCommandParser;
import oom.github.bingoohuang.designpatterns.commandparsers.BadCommandParser;
import oom.github.bingoohuang.designpatterns.commandparsers.DelCommandParser;
import oom.github.bingoohuang.designpatterns.commandparsers.GetCommandParser;

class CommandParserFactory {
    public static CommandParser create(String commandType) {
        CommandParser commandParser;
        if ("add".equals(commandType)) {
            commandParser = new AddCommandParser();
        } else if ("get".equals(commandType)) {
            commandParser = new GetCommandParser();
        } else if ("del".equals(commandType)) {
            commandParser = new DelCommandParser();
        } else {
            commandParser = new BadCommandParser();
        }
        return commandParser;
    }
}
