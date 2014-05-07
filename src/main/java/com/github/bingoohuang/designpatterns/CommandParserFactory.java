package com.github.bingoohuang.designpatterns;

import com.github.bingoohuang.designpatterns.commandinterpreter.SimpleCommandInterpreter;
import com.github.bingoohuang.designpatterns.commandparsers.*;

class CommandParserFactory {
    public static CommandParser create(SimpleCommandInterpreter simpleCommandInterpreter) {
        CommandParser commandParser;
        String commandType = simpleCommandInterpreter.getCommandType();
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

        commandParser.setArgs(simpleCommandInterpreter.getArgs());

        return commandParser;
    }
}
