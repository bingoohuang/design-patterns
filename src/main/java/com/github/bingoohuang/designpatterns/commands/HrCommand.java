package com.github.bingoohuang.designpatterns.commands;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.User;
import com.github.bingoohuang.designpatterns.UserRegistry;
import com.github.bingoohuang.designpatterns.visitor.HumanResourceVisitor;

import java.util.Collection;

public class HrCommand implements Command {
    @Override
    public String execute() {
        Collection<User> users = UserRegistry.getInstance().getUsers();
        StringBuilder info = new StringBuilder();
        HumanResourceVisitor visitor = new HumanResourceVisitor(info);
        for (User user : users) {
            user.accept(visitor);
        }

        return info.toString();
    }

    @Override
    public boolean requireLogin() {
        return false;
    }
}
