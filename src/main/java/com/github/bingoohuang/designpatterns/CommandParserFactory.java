package com.github.bingoohuang.designpatterns;

import com.github.bingoohuang.designpatterns.commandparsers.*;

class CommandParserFactory {
    public static CommandParser create(String commandType) {
        CommandParser commandParser;
        if ("add".equals(commandType)) {
            commandParser = new AddCommandParser();
        } else if ("get".equals(commandType)) {
            commandParser = new GetCommandParser();
        } else if ("del".equals(commandType)) {
            commandParser = new DelCommandParser();
        } else if ("save".equals(commandType)) {
            commandParser = new SaveCommandParser();
        } else {
            commandParser = new BadCommandParser();
        }
        return commandParser;
    }
}
