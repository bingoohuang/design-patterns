package com.github.bingoohuang.designpatterns;

import com.github.bingoohuang.designpatterns.argumentsvalidators.CommandArgumentsValidator;
import com.github.bingoohuang.designpatterns.commandinterpreter.SimpleCommandInterpreter;
import com.github.bingoohuang.designpatterns.commands.BadCommand;

public abstract class CommandParser {
    private CommandParser next;

    public Command parseCommand(SimpleCommandInterpreter simpleCommandInterpreter) {
        String commandType = simpleCommandInterpreter.getCommandType();

        if (supportCommandType().equals(commandType)) {
            return createCommand(simpleCommandInterpreter.getArgs());
        }
        if (next != null) return next.parseCommand(simpleCommandInterpreter);
        return new BadCommand();
    }

    public void validateArguments(SimpleCommandInterpreter simpleCommandInterpreter) {
        String commandType = simpleCommandInterpreter.getCommandType();

        if (supportCommandType().equals(commandType)) {
            CommandArgumentsValidator argumentsValidator = createArgumentsValidator();
            if (argumentsValidator != null) argumentsValidator.validateArguments(simpleCommandInterpreter.getArgs());
        } else if (next != null) {
            next.validateArguments(simpleCommandInterpreter);
        }
    }

    protected CommandArgumentsValidator createArgumentsValidator() {
        return null;
    }

    protected abstract Command createCommand(String[] args);

    public abstract String supportCommandType();

    public void setNext(CommandParser next) {
        this.next = next;
    }

}
