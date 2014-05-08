package com.github.bingoohuang.designpatterns.commands;

import com.github.bingoohuang.designpatterns.Command;
import com.github.bingoohuang.designpatterns.User;
import com.github.bingoohuang.designpatterns.UserRegistry;

public class AddSalaryCommand implements Command {
    private final String id;
    private final int incrementSalary;

    public AddSalaryCommand(String id, int incrementSalary) {
        this.id = id;
        this.incrementSalary = incrementSalary;
    }

    @Override
    public String execute() {
        User staff = UserRegistry.getInstance().get(id);
        staff.addSalary(incrementSalary);

        return "salary of" + staff.getId() + " and all its staff has been added by" + incrementSalary;
    }

    @Override
    public boolean requireLogin() {
        return false;
    }
}
