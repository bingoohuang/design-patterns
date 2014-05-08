package com.github.bingoohuang.designpatterns.argumentsvalidators;

import com.github.bingoohuang.designpatterns.UserRegistry;

public class CloneCommandArgumentsValidator implements  CommandArgumentsValidator {
    private String cloneId;
    private String id;
    private String name;

    @Override
    public void validateArguments(String[] args) {
        if (args.length < 2) throw new BadArgumentException("more than two arguments are required");

        this.cloneId = args[0];
        this.id = args[1];
        this.name = args.length > 2 ? args[2] : null;

        if (cloneId.equals(id)) throw new BadArgumentException(cloneId + " should not be same with id which is to be cloned");

        if (!UserRegistry.getInstance().exists(cloneId))
            throw new BadArgumentException(cloneId + " does not exist");

        // decorator
        ArgumentValidator validator = new NumberArgumentValidator(new FixedSizeArgumentValidator(4));
        validator.validate(cloneId);
        validator.validate(id);
    }

    public String getCloneId() {
        return cloneId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
