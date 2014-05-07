package com.github.bingoohuang.designpatterns.argumentsvalidators;

public class AddCommandArgumentsValidator implements  CommandArgumentsValidator {
    private String id;
    private String name;

    @Override
    public void validateArguments(String[] args) {
        if (args.length != 2) throw new BadArgumentException("two arguments are required");

        this.id = args[0];
        this.name = args[1];

        // decorator
        ArgumentValidator validator = new NumberArgumentValidator(new FixedSizeArgumentValidator(4));
        validator.validate(id);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
