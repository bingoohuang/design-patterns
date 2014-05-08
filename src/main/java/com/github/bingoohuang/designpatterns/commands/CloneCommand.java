package com.github.bingoohuang.designpatterns.commands;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.User;
import com.github.bingoohuang.designpatterns.UserRegistry;
import com.github.bingoohuang.designpatterns.argumentsvalidators.CloneCommandArgumentsValidator;

public class CloneCommand implements Command {
    private final CloneCommandArgumentsValidator argumentsValidator;

    public CloneCommand(CloneCommandArgumentsValidator argumentsValidator) {
        this.argumentsValidator = argumentsValidator;
    }

    @Override
    public String execute() {
        User user = UserRegistry.getInstance().get(argumentsValidator.getCloneId());
        User newUser = user.clone();
        newUser.setId(argumentsValidator.getId());
        String newName = argumentsValidator.getName();
        newUser.setName(newName == null ? user.getName() : newName);

        UserRegistry.getInstance().put(newUser);

        return "cloned " + newUser;
    }

    @Override
    public boolean requireLogin() {
        return false;
    }
}
