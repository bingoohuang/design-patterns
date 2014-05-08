package com.github.bingoohuang.designpatterns.commands;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.User;
import com.github.bingoohuang.designpatterns.UserRegistry;

public class WorkloadCommand implements Command {
    private final String id;

    public WorkloadCommand(String id) {
        this.id = id;
    }

    @Override
    public String execute() {
        User user = UserRegistry.getInstance().get(id);
        if (user == null)
            return "user does not exist";

        return user.getName() + "'s workload per day is " + user.workLoadPerday();
    }

    @Override
    public boolean requireLogin() {
        return false;
    }
}
