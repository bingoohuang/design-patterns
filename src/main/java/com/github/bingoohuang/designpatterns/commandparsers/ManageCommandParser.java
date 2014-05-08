package com.github.bingoohuang.designpatterns.commandparsers;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.CommandParser;
import com.github.bingoohuang.designpatterns.argumentsvalidators.ManageCommandArgumentsValidator;
import com.github.bingoohuang.designpatterns.commands.ManageCommand;

public class ManageCommandParser extends CommandParser {
    @Override
    protected Command createCommand(String[] args) {
        ManageCommandArgumentsValidator validator = new ManageCommandArgumentsValidator();
        validator.validateArguments(args);

        return new ManageCommand(validator);
    }

    @Override
    public String supportCommandType() {
        return "manage";
    }
}
