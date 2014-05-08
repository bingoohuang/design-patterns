package com.github.bingoohuang.designpatterns.commandparsers;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.CommandParser;
import com.github.bingoohuang.designpatterns.argumentsvalidators.CloneCommandArgumentsValidator;
import com.github.bingoohuang.designpatterns.commands.CloneCommand;

public class CloneCommandParser extends CommandParser {
    @Override
    protected Command createCommand(String[] args) {
        CloneCommandArgumentsValidator argumentsValidator = new CloneCommandArgumentsValidator();
        argumentsValidator.validateArguments(args);

        return new CloneCommand(argumentsValidator);
    }

    @Override
    public String supportCommandType() {
        return "clone";
    }
}
