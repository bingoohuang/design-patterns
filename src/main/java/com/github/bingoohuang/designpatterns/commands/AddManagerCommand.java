package com.github.bingoohuang.designpatterns.commands;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.User;
import com.github.bingoohuang.designpatterns.UserBuilder;
import com.github.bingoohuang.designpatterns.UserRegistry;
import com.github.bingoohuang.designpatterns.argumentsvalidators.AddCommandArgumentsValidator;

public class AddManagerCommand implements Command {
    private final AddCommandArgumentsValidator argumentsValidator;

    public AddManagerCommand(AddCommandArgumentsValidator argumentsValidator) {
        this.argumentsValidator = argumentsValidator;
    }

    @Override
    public String execute() {
        User user = UserBuilder.newUser(argumentsValidator.getId(), argumentsValidator.getName())
                .age(argumentsValidator.getAge())
                .phone(argumentsValidator.getPhone())
                .city(argumentsValidator.getAddress())
                .buildManager();
        UserRegistry.getInstance().put(user);

        return "added " + user;
    }

    @Override
    public boolean requireLogin() {
        return false;
    }
}
