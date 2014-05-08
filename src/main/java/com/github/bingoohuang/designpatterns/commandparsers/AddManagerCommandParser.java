package com.github.bingoohuang.designpatterns.commandparsers;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.CommandParser;
import com.github.bingoohuang.designpatterns.argumentsvalidators.AddCommandArgumentsValidator;
import com.github.bingoohuang.designpatterns.argumentsvalidators.CommandArgumentsValidator;
import com.github.bingoohuang.designpatterns.commands.AddCommand;
import com.github.bingoohuang.designpatterns.commands.AddManagerCommand;

public class AddManagerCommandParser extends CommandParser {
    private AddCommandArgumentsValidator argumentsValidator;

    @Override
    protected CommandArgumentsValidator createArgumentsValidator() {
        this.argumentsValidator = new AddCommandArgumentsValidator();
        return argumentsValidator;
    }

    @Override
    public Command createCommand(String[] args) {
        return new AddManagerCommand(argumentsValidator);
    }

    @Override
    public String supportCommandType() {
        return "addmanager";
    }
}
