package com.github.bingoohuang.designpatterns.argumentsvalidators;

public class NumberArgumentValidator implements ArgumentValidator{
    private final ArgumentValidator argumentValidator;

    public NumberArgumentValidator(ArgumentValidator argumentValidator) {
        this.argumentValidator = argumentValidator;
    }

    @Override
    public void validate(String arg) {
        argumentValidator.validate(arg);

        if (!arg.matches("\\d+")) throw new BadArgumentException(arg + " is not a number");
    }
}
