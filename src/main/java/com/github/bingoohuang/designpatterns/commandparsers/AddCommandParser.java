package com.github.bingoohuang.designpatterns.commandparsers;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.CommandParser;
import com.github.bingoohuang.designpatterns.argumentsvalidators.AddCommandArgumentsValidator;
import com.github.bingoohuang.designpatterns.argumentsvalidators.CommandArgumentsValidator;
import com.github.bingoohuang.designpatterns.commands.AddCommand;

public class AddCommandParser extends CommandParser {
    private AddCommandArgumentsValidator argumentsValidator;

    @Override
    protected CommandArgumentsValidator createArgumentsValidator() {
        this.argumentsValidator = new AddCommandArgumentsValidator();
        return argumentsValidator;
    }

    @Override
    public Command createCommand(String[] args) {
        return new AddCommand(argumentsValidator);
    }

    @Override
    public String supportCommandType() {
        return "add";
    }
}
