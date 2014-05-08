package com.github.bingoohuang.designpatterns.commandparsers;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.CommandParser;
import com.github.bingoohuang.designpatterns.argumentsvalidators.AddCommandArgumentsValidator;
import com.github.bingoohuang.designpatterns.commands.AddCommand;

public class AddCommandParser extends CommandParser {
    @Override
    public Command createCommand(String[] args) {
        AddCommandArgumentsValidator argumentsValidator = new AddCommandArgumentsValidator();
        argumentsValidator.validateArguments(args);

        return new AddCommand(argumentsValidator);
    }

    @Override
    public String supportCommandType() {
        return "add";
    }
}
